package com.eims.ris.gui;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.eims.ris.core.DBUtils;
import com.eims.ris.core.Enumeradores;
import com.eims.ris.core.Profesion;
import com.eims.ris.core.Utils;
import com.eims.ris.gui.Ui_frmProfesiones;
import com.trolltech.qt.gui.QApplication;
import com.trolltech.qt.gui.QDialog;
import com.trolltech.qt.gui.QWidget;
import com.trolltech.qt.gui.QTableWidgetItem;
import com.trolltech.qt.gui.QDialogButtonBox.StandardButton;

public class frmProfesiones extends QDialog {

    /**
	 * @uml.property  name="ui"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
    Ui_frmProfesiones ui = new Ui_frmProfesiones();
    /**
	 * @uml.property  name="_userName"
	 */
    private String _userName;
    /**
	 * @uml.property  name="_Action"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
    Enumeradores.Action _Action = Enumeradores.Action.None;

    public frmProfesiones(String userName) {
        this(userName, null);
    }
    public frmProfesiones(String userName, QWidget parent) {
        super(parent);
        ui.setupUi(this);
        _userName = userName;
        CreateConnect();
        QApplication.restoreOverrideCursor();
    }
    public void on_btnNuevo_Clicked(){
    	ui.gbUpdate.setEnabled(true);
    	ui.leDesc.setText("");
    	ui.leAbre.setText("");
    	ui.ckbVige.setChecked(false);
    	ui.lblStat.setText("Agregando\n[Esc] Cancelar");
    	ui.twProfesiones.setEnabled(false);
    	Utils.HabilitaAcciones(this,_userName,objectName().substring(3),'A');
    	_Action = Enumeradores.Action.New;
    }
    public void on_btnEditar_Clicked(){
    	ui.gbUpdate.setEnabled(true);
    	ui.leDesc.setText(ui.twProfesiones.item(ui.twProfesiones.currentRow(), 1).text());
    	ui.leAbre.setText(ui.twProfesiones.item(ui.twProfesiones.currentRow(), 2).text());
    	ui.ckbVige.setChecked(ui.twProfesiones.item(ui.twProfesiones.currentRow(), 3).text().equals("Sí"));
    	ui.lblStat.setText("Editando\n[Esc] Cancelar");
    	ui.twProfesiones.setEnabled(false);
    	Utils.HabilitaAcciones(this,_userName,objectName().substring(3),'E');
    	_Action = Enumeradores.Action.Edit;
    }
    public void on_btnEliminar_Clicked(){
    	if(Utils.MessageBox(Enumeradores.Message.Question, "¿Está seguro que desea eliminar el registro?")==StandardButton.Yes.value()){
	    	Profesion prof = new Profesion();
	    	prof.setId(Integer.parseInt(ui.twProfesiones.item(ui.twProfesiones.currentRow(), 0).text()));
	    	if(prof.Eliminar())
	    		Utils.MessageBox(Enumeradores.Message.Information, "El registro ha sido eliminado satisfactoriamente.");
	    	else{
	    		Utils.MessageBox(Enumeradores.Message.Error, "Ha sido imposible eliminar el registro.\nIntente nuevamente");
	    		return;
	    	}
	    	Utils.HabilitaAcciones(this,_userName, objectName().substring(3), '\n');
	    	_Action = Enumeradores.Action.Delete;
	    	LoadData();
    	}
    }
    public void on_btnGuardar_Clicked(){
    	if(ui.leDesc.text().equals("") || ui.leAbre.text().equals("")){
    		Utils.MessageBox(Enumeradores.Message.Information, "Debe ingresar la descripción y la abreviatura de la profesión.\nIntente nuevamente.");
    		return;
    	}
    	if(Utils.MessageBox(Enumeradores.Message.Question, "¿Está seguro que desea guardar?")==StandardButton.Yes.value()){
	    	boolean result = false;
	    	Profesion prof = new Profesion();
	    	prof.setDescripcion(ui.leDesc.text());
	    	prof.setAbreviacion(ui.leAbre.text());
	    	prof.setVigente(ui.ckbVige.isChecked());
	    	if(_Action == Enumeradores.Action.New)	
	    		result = prof.Insertar();
	    	else{
	    		prof.setId(Integer.parseInt(ui.twProfesiones.item(ui.twProfesiones.currentRow(),0).text()));
	    		result = prof.Modificar();
	    	}
	    	if(result){
	    		Utils.MessageBox(Enumeradores.Message.Information, "¡El registro se ha guardado satisfactoriamente!");
	    		ui.twProfesiones.setEnabled(true);
	    		ui.gbUpdate.setEnabled(false);
	        	ui.leDesc.setText("");
	        	ui.leAbre.setText("");
	        	ui.ckbVige.setChecked(false);
	        	ui.lblStat.setText("");
	        	ui.twProfesiones.setEnabled(true);
	        	Utils.HabilitaAcciones(this,_userName,objectName().substring(3),'B');
	        	_Action = Enumeradores.Action.None;
	        	LoadData();
	    	}else
	    		Utils.MessageBox(Enumeradores.Message.Error, "¡Se ha producido un error al guardar el registro!");
    	}
    }
    public void on_btnImprimir_Clicked(){
    	Profesion.Printer(ui.twProfesiones);
    }
    @SuppressWarnings("unused")
    private void on_twProfesiones_CellClicked(int row, int col){
    	Utils.HabilitaAcciones(this,_userName,objectName().substring(3),'B');
    }
    
    public void CreateConnect(){
    	ui.btnNuevo.clicked.connect(this, "on_btnNuevo_Clicked()");
    	ui.btnEditar.clicked.connect(this, "on_btnEditar_Clicked()");
    	ui.btnGuardar.clicked.connect(this, "on_btnGuardar_Clicked()");
    	ui.btnEliminar.clicked.connect(this, "on_btnEliminar_Clicked()");
    	ui.btnImprimir.clicked.connect(this, "on_btnImprimir_Clicked()");
    	ui.twProfesiones.cellClicked.connect(this, "on_twProfesiones_CellClicked(int, int)");
    	Utils.HabilitaAcciones(this, _userName, objectName().substring(3), '\0');
    	LoadData();
    }
    
    private void LoadData(){
        int row = 0;
        ui.twProfesiones.setRowCount(0);
        String sql = String.format("SELECT prf_id,prf_desc,prf_abre,prf_vige FROM miniris.profesiones ORDER BY prf_id");
        try{
	        ResultSet query = DBUtils.getResultSet(sql);
	        while(query.next()){
	            QTableWidgetItem item = null;
	            ui.twProfesiones.insertRow(row);
	            ui.twProfesiones.setRowHeight(row,20);
	
	            item = new QTableWidgetItem();
	            item.setText(query.getString("prf_id"));
	            item.setTextAlignment(2);
	            ui.twProfesiones.setItem(row,0,item);
	
	            item = new QTableWidgetItem();
	            item.setText(query.getString("prf_desc"));
	            ui.twProfesiones.setItem(row,1,item);  
	            
	            item = new QTableWidgetItem();
	            item.setText(query.getString("prf_abre"));
	            ui.twProfesiones.setItem(row,2,item);  
	            
	            item = new QTableWidgetItem();
	            item.setText(query.getBoolean("prf_vige")?"Sí":"No");
	            item.setTextAlignment(5);
	            ui.twProfesiones.setItem(row,3,item);
	
	            row++;
	        }
        }catch(SQLException e){
        	e.printStackTrace();
        }
        ui.twProfesiones.resizeColumnsToContents();
    }
}