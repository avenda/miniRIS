package com.eims.ris.gui;


import java.sql.ResultSet;
import java.sql.SQLException;

import com.eims.ris.core.DBUtils;
import com.eims.ris.core.Enumeradores;
import com.eims.ris.core.SistSalud;
import com.eims.ris.core.Utils;
import com.eims.ris.gui.Ui_frmSistSalud;
import com.trolltech.qt.gui.QApplication;
import com.trolltech.qt.gui.QDialog;
import com.trolltech.qt.gui.QWidget;
import com.trolltech.qt.gui.QTableWidgetItem;
import com.trolltech.qt.gui.QDialogButtonBox.StandardButton;

public class frmSistSalud extends QDialog {

    /**
	 * @uml.property  name="ui"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
    Ui_frmSistSalud ui = new Ui_frmSistSalud();
    /**
	 * @uml.property  name="_userName"
	 */
    private String _userName;
    /**
	 * @uml.property  name="_Action"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
    private Enumeradores.Action _Action = Enumeradores.Action.None;

    public frmSistSalud(String userName) {
        this(userName, null);
    }
    public frmSistSalud(String userName, QWidget parent) {
        super(parent);
        ui.setupUi(this);
        _userName = userName;
        CreateConnect();
        QApplication.restoreOverrideCursor();
    }
    @SuppressWarnings("unused")
    private void on_btnNuevo_Clicked(){
    	ui.gbUpdate.setEnabled(true);
    	ui.leDesc.setText("");
    	ui.ckbVige.setChecked(true);
    	ui.lblStat.setText("Agregando\n[Esc] Cancelar");
    	ui.twSistSalud.setEnabled(false);
    	Utils.HabilitaAcciones(this,_userName,objectName().substring(3),'A');
    	_Action = Enumeradores.Action.New;
    }
    @SuppressWarnings("unused")
    private void on_btnEditar_Clicked(){
    	ui.gbUpdate.setEnabled(true);
        ui.twSistSalud.setEnabled(false);
        ui.leDesc.setText(ui.twSistSalud.item(ui.twSistSalud.currentRow(),1).text());
        ui.ckbVige.setChecked(ui.twSistSalud.item(ui.twSistSalud.currentRow(),2).text().equals("Sí"));
        ui.lblStat.setText("Editando\n[Esc] Cancelar");
        ui.twSistSalud.setEnabled(false);
        Utils.HabilitaAcciones(this,_userName,objectName().substring(3),'E');
    	_Action = Enumeradores.Action.Edit;
    }
    @SuppressWarnings("unused")
    private void on_btnEliminar_Clicked(){
    	if(Utils.MessageBox(Enumeradores.Message.Question, "¿Está seguro que desea eliminar el registro?")==StandardButton.Yes.value()){
	    	SistSalud ssalud = new SistSalud();
	    	ssalud.setId(Integer.parseInt(ui.twSistSalud.item(ui.twSistSalud.currentRow(), 0).text()));    	
	    	ssalud.Eliminar();
	    	Utils.HabilitaAcciones(this,_userName, objectName().substring(3), '\n');
	    	_Action = Enumeradores.Action.Delete;
	    	LoadData();
    	}
    }
    @SuppressWarnings("unused")
    private void on_btnGuardar_Clicked(){
    	if(ui.leDesc.text().equals("")){
    		Utils.MessageBox(Enumeradores.Message.Information, "Debe ingresar la descripción.\nIntente nuevamente.");
    		return;
    	}
    	if(Utils.MessageBox(Enumeradores.Message.Question, "¿Está seguro que desea guardar?")==StandardButton.Yes.value()){
    		boolean result = false;
	    	SistSalud ssalud = new SistSalud();
	    	ssalud.setDescripcion(ui.leDesc.text());
	    	ssalud.setVigente(ui.ckbVige.isChecked());
	    	if(_Action == Enumeradores.Action.New)	
	    		result = ssalud.Insertar();
	    	else{
	    		ssalud.setId(Integer.parseInt(ui.twSistSalud.item(ui.twSistSalud.currentRow(),0).text()));
	    		result = ssalud.Modificar();
	    	}
	    	if(result){
	    		Utils.MessageBox(Enumeradores.Message.Information, "¡El registro se ha guardado satisfactoriamente!");
	    		ui.twSistSalud.setEnabled(true);
	    		ui.gbUpdate.setEnabled(false);
	        	ui.leDesc.setText("");
	        	ui.ckbVige.setChecked(false);
	        	ui.lblStat.setText("");
	        	ui.twSistSalud.setEnabled(true);	 
	        	Utils.HabilitaAcciones(this,_userName,objectName().substring(3),'B');
	        	_Action = Enumeradores.Action.None;
	        	LoadData();
	        	ui.lblStat.setText("");
	    	}else
	    		Utils.MessageBox(Enumeradores.Message.Error, "¡Se ha producido un error al guardar el registro!");
    	}
    }
    public void on_btnImprimir_Clicked(){
    	SistSalud.Printer(ui.twSistSalud);
    }
    @SuppressWarnings("unused")
    private void on_twSistSalud_CellClicked(int row, int col){
    	Utils.HabilitaAcciones(this,_userName,objectName().substring(3),'B');
    }
    
    private void CreateConnect(){
    	ui.btnNuevo.clicked.connect(this, "on_btnNuevo_Clicked()");
    	ui.btnEditar.clicked.connect(this, "on_btnEditar_Clicked()");
    	ui.btnGuardar.clicked.connect(this, "on_btnGuardar_Clicked()");
    	ui.btnEliminar.clicked.connect(this, "on_btnEliminar_Clicked()");
    	ui.btnImprimir.clicked.connect(this, "on_btnImprimir_Clicked()");
    	ui.twSistSalud.cellClicked.connect(this, "on_twSistSalud_CellClicked(int, int)");
    	Utils.HabilitaAcciones(this, _userName, objectName().substring(3), '\0');
    	LoadData();
    }
    
    private void LoadData(){
        int row = 0;
        ui.twSistSalud.setRowCount(0);
        String sql = String.format("SELECT ssa_id,ssa_desc,ssa_vige FROM miniris.sist_salud ORDER BY ssa_id");
        try{
	        ResultSet query = DBUtils.getResultSet(sql);
	        while(query.next()){
	            QTableWidgetItem item = null;
	            ui.twSistSalud.insertRow(row);
	            ui.twSistSalud.setRowHeight(row,20);
	
	            item = new QTableWidgetItem();
	            item.setText(query.getString("ssa_id"));
	            item.setTextAlignment(2);
	            ui.twSistSalud.setItem(row,0,item);
	
	            item = new QTableWidgetItem();
	            item.setText(query.getString("ssa_desc"));
	            ui.twSistSalud.setItem(row,1,item);
	            
	            item = new QTableWidgetItem();
	            item.setText(query.getBoolean("ssa_vige")?"Sí":"No");
	            item.setTextAlignment(5);
	            ui.twSistSalud.setItem(row,2,item);
	
	            row++;
	        }
        }catch(SQLException e){
        	e.printStackTrace();
        }
        ui.twSistSalud.resizeColumnsToContents();
    }
}
