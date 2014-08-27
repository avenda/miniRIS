package com.eims.ris.gui;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.eims.ris.core.DBUtils;
import com.eims.ris.core.Enumeradores;
import com.eims.ris.core.Prestacion;
import com.eims.ris.core.RRFFs;
import com.eims.ris.core.Tipo;
import com.eims.ris.core.Utils;
import com.eims.ris.gui.Ui_frmPrestaciones;
import com.trolltech.qt.gui.QApplication;
import com.trolltech.qt.gui.QDialog;
import com.trolltech.qt.gui.QTableWidgetItem;
import com.trolltech.qt.gui.QWidget;
import com.trolltech.qt.gui.QDialogButtonBox.StandardButton;

public class frmPrestaciones extends QDialog {

    /**
	 * @uml.property  name="ui"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
    Ui_frmPrestaciones ui = new Ui_frmPrestaciones();
    /**
	 * @uml.property  name="_userName"
	 */
    private String _userName;
    /**
	 * @uml.property  name="_Action"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
    private Enumeradores.Action _Action = Enumeradores.Action.None;

    public frmPrestaciones(String userName) {
        this(userName, null);
    }

    public frmPrestaciones(String userName, QWidget parent) {
        super(parent);
        ui.setupUi(this);
        _userName = userName;
        CreateConnect();
        QApplication.restoreOverrideCursor();
    }
    
    public void on_btnNuevo_Clicked(){
    	ui.gbUpdate.setEnabled(true);
    	ClearFields();
    	ui.lblStat.setText("Agregando\n[Esc] Cancelar");
    	ui.twPrestaciones.setEnabled(false);
    	Utils.HabilitaAcciones(this,_userName,objectName().substring(3),'A');
    	_Action = Enumeradores.Action.New;
    }
    public void on_btnEditar_Clicked(){
    	ui.gbUpdate.setEnabled(true);
    	ui.leCodi.setText(ui.twPrestaciones.item(ui.twPrestaciones.currentRow(), 0).text());
    	ui.cmbTipo.setCurrentIndex(ui.cmbTipo.findText(ui.twPrestaciones.item(ui.twPrestaciones.currentRow(), 1).text()));
    	ui.pteDesc.setPlainText(ui.twPrestaciones.item(ui.twPrestaciones.currentRow(), 2).text());
    	ui.cmbRF.setCurrentIndex(ui.cmbRF.findText(ui.twPrestaciones.item(ui.twPrestaciones.currentRow(), 3).text()));
    	ui.ckbVige.setChecked(ui.twPrestaciones.item(ui.twPrestaciones.currentRow(), 4).text().equals("Sí"));
    	ui.lblStat.setText("Editando\n[Esc] Cancelar");
    	ui.twPrestaciones.setEnabled(false);
    	Utils.HabilitaAcciones(this,_userName,objectName().substring(3),'A');
    	_Action = Enumeradores.Action.Edit;
    }
    public void on_btnEliminar_Clicked(){
    	if(Utils.MessageBox(Enumeradores.Message.Question, "¿Está seguro que desea eliminar el registro?")==StandardButton.Yes.value()){
	    	Prestacion prestacion = new Prestacion();
	    	prestacion.setId(ui.twPrestaciones.item(ui.twPrestaciones.currentRow(), 0).text());
	    	if(prestacion.Eliminar())
	    		Utils.MessageBox(Enumeradores.Message.Information, "El registro ha sido eliminado satisfactoriamente.");
	    	else{
	    		Utils.MessageBox(Enumeradores.Message.Error, "Ha sido imposible eliminar el registro.\nIntente nuevamente");
	    		return;
	    	}
	    	Utils.HabilitaAcciones(this,_userName,objectName().substring(3),'\0');
	    	_Action = Enumeradores.Action.Delete;
	    	LoadData();
    	}
    }
    public void on_btnGuardar_Clicked(){
    	if(ui.leCodi.text().equals("") || ui.pteDesc.toPlainText().equals("")){
    		Utils.MessageBox(Enumeradores.Message.Information, "Debe ingresar el código y la descripción.\nIntente nuevamente.");
    		return;
    	}
    	if(Utils.MessageBox(Enumeradores.Message.Question, "¿Está seguro que desea guardar?")==StandardButton.Yes.value()){
	    	boolean result = true;
	    	Prestacion prestacion = new Prestacion();
	    	Tipo tipo = new Tipo();
	    	tipo.setId(Integer.parseInt(ui.cmbTipo.itemData(ui.cmbTipo.currentIndex()).toString()));
	    	tipo.setDescripcion(ui.cmbTipo.currentText());
	    	prestacion.setTipo(tipo);
	    	prestacion.setDescripcion(ui.pteDesc.toPlainText());
	    	RRFFs rf = new RRFFs();
	    	rf.setId(Integer.parseInt(ui.cmbRF.itemData(ui.cmbRF.currentIndex()).toString()));
	    	rf.setDescripcion(ui.cmbRF.currentText());
	    	prestacion.setRRFFxDefecto(rf);
	    	prestacion.setVigente(ui.ckbVige.isChecked());
	    	if(_Action == Enumeradores.Action.New)	
	    		result = prestacion.Insertar();
	    	else{
	    		prestacion.setId(ui.twPrestaciones.item(ui.twPrestaciones.currentRow(),0).text());
	    		result = prestacion.Modificar();
	    	}
	    	if(result){
	    		Utils.MessageBox(Enumeradores.Message.Information, "¡El registro se ha guardado satisfactoriamente!");
	    		ui.twPrestaciones.setEnabled(true);
	    		ui.gbUpdate.setEnabled(false);
	    		ClearFields();
	    		ui.lblStat.setText("");
	        	ui.twPrestaciones.setEnabled(true);
	        	Utils.HabilitaAcciones(this,_userName,objectName().substring(3),'B');
	        	_Action = Enumeradores.Action.None;
	        	LoadData();
	    	}else
	    		Utils.MessageBox(Enumeradores.Message.Error, "¡Se ha producido un error al guardar el registro!");
    	}
    }
    public void on_btnImprimir_Clicked(){
    	Prestacion.Printer(ui.twPrestaciones);
    }
    @SuppressWarnings("unused")
	private void on_twPrestaciones_CellClicked(int row, int col){
    	Utils.HabilitaAcciones(this,_userName,objectName().substring(3),'B');
    }
    
    public void CreateConnect(){
    	ui.btnNuevo.clicked.connect(this, "on_btnNuevo_Clicked()");
    	ui.btnEditar.clicked.connect(this, "on_btnEditar_Clicked()");
    	ui.btnGuardar.clicked.connect(this, "on_btnGuardar_Clicked()");
    	ui.btnEliminar.clicked.connect(this, "on_btnEliminar_Clicked()");
    	ui.btnImprimir.clicked.connect(this, "on_btnImprimir_Clicked()");
    	ui.twPrestaciones.cellClicked.connect(this, "on_twPrestaciones_CellClicked(int, int)");
    	Utils.HabilitaAcciones(this,_userName,objectName().substring(3),'\0');
    	LoadData();
    	LoadCombos();
    }
    
    private void ClearFields(){
    	ui.leCodi.setText("");
    	ui.cmbTipo.setCurrentIndex(-1);
    	ui.pteDesc.setPlainText("");
    	ui.cmbRF.setCurrentIndex(-1);
    	ui.ckbVige.setChecked(false);
    }
    
    private void LoadData(){
        int row = 0;
		ui.twPrestaciones.setRowCount(0);
        String sql = String.format("SELECT prest_id,prest_desc,par_desc,rf_desc,prest_vige FROM miniris.prestaciones p, miniris.parametros pm, miniris.rrffs rf WHERE par_grupo='TP' AND p.prest_tipo=pm.par_id AND p.rf_id=rf.rf_id ORDER BY prest_id");
        try{
	        ResultSet query = DBUtils.getResultSet(sql); 
	        while(query.next()){
	            QTableWidgetItem item = null;
	            ui.twPrestaciones.insertRow(row);
	            ui.twPrestaciones.setRowHeight(row,20);
	
	            item = new QTableWidgetItem();
	            item.setText(query.getString("prest_id"));
	            item.setTextAlignment(2);
	            ui.twPrestaciones.setItem(row,0,item);
	
	            item = new QTableWidgetItem();
	            item.setText(query.getString("par_desc"));
	            ui.twPrestaciones.setItem(row,1,item);
	            
	            item = new QTableWidgetItem();
	            item.setText(query.getString("prest_desc"));
	            ui.twPrestaciones.setItem(row,2,item);
	            
	            item = new QTableWidgetItem();
	            item.setText(query.getString("rf_desc"));
	            ui.twPrestaciones.setItem(row,3,item);
	            	
	            item = new QTableWidgetItem();
	            item.setText(query.getBoolean("prest_vige")?"Sí":"No");
	            item.setTextAlignment(5);
	            ui.twPrestaciones.setItem(row,4,item);
	
	            row++;
	        }
        }catch(SQLException e){
        	e.printStackTrace();
        }
        ui.twPrestaciones.resizeColumnsToContents();
        ui.twPrestaciones.setColumnWidth(2, 350);
    }
    private void LoadCombos(){
        String sql = String.format("SELECT par_id,par_desc FROM miniris.parametros WHERE par_grupo='TP' AND par_vige=TRUE ORDER BY par_id");
        DBUtils.loadComboBox(ui.cmbTipo, sql);
        sql = String.format("SELECT rf_id,rf_desc FROM miniris.rrffs WHERE rf_vige=TRUE ORDER BY rf_id");
        DBUtils.loadComboBox(ui.cmbRF, sql);
    }
}