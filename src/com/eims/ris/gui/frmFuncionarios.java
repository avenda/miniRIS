package com.eims.ris.gui;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.eims.ris.core.DBUtils;
import com.eims.ris.core.Enumeradores;
import com.eims.ris.core.Funcionario;
import com.eims.ris.core.Profesion;
import com.eims.ris.core.Utils;
import com.eims.ris.gui.Ui_frmFuncionarios;
import com.trolltech.qt.gui.QApplication;
import com.trolltech.qt.gui.QDialog;
import com.trolltech.qt.gui.QTableWidgetItem;
import com.trolltech.qt.gui.QWidget;
import com.trolltech.qt.gui.QDialogButtonBox.StandardButton;

public class frmFuncionarios extends QDialog {

    /**
	 * @uml.property  name="ui"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
    Ui_frmFuncionarios ui = new Ui_frmFuncionarios();
    /**
	 * @uml.property  name="_userName"
	 */
    private String _userName;
    /**
	 * @uml.property  name="_Action"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
    private Enumeradores.Action _Action = Enumeradores.Action.None;

    public frmFuncionarios(String userName) {
       this(userName, null);
    }
    public frmFuncionarios(String userName, QWidget parent) {
        super(parent);
        ui.setupUi(this);
        _userName = userName;
        CreateConnect();
        QApplication.restoreOverrideCursor();
    }
    public void on_btnNuevo_Clicked(){
    	ui.gbUpdate.setEnabled(true);
    	ui.cmbProf.setCurrentIndex(-1);
    	//ui.leDesc.setText("");
    	ui.leAMat.setText("");
    	ui.leAPat.setText("");
    	ui.leAMat.setText("");
    	ui.leInic.setText("");
    	ui.leNomb.setText("");
    	ui.ckbVige.setChecked(false);
    	ui.lblStat.setText("Agregando\n[Esc] Cancelar");
    	ui.twFuncionarios.setEnabled(false);
    	Utils.HabilitaAcciones(this,_userName,objectName().substring(3),'A');
    	_Action = Enumeradores.Action.New;
    }
    public void on_btnEditar_Clicked(){
    	ui.gbUpdate.setEnabled(true);
       	ui.leNomb.setText(ui.twFuncionarios.item(ui.twFuncionarios.currentRow(), 1).text());
    	ui.leAPat.setText(ui.twFuncionarios.item(ui.twFuncionarios.currentRow(), 2).text());
    	ui.leAMat.setText(ui.twFuncionarios.item(ui.twFuncionarios.currentRow(), 3).text());
    	ui.leInic.setText(ui.twFuncionarios.item(ui.twFuncionarios.currentRow(), 4).text());
    	ui.cmbProf.setCurrentIndex(ui.cmbProf.findText(ui.twFuncionarios.item(ui.twFuncionarios.currentRow(), 5).text()));
    	ui.ckbVige.setChecked(ui.twFuncionarios.item(ui.twFuncionarios.currentRow(), 6).text().equals("Sí"));
    	ui.lblStat.setText("Editando\n[Esc] Cancelar");
    	ui.twFuncionarios.setEnabled(false);
    	Utils.HabilitaAcciones(this,_userName,objectName().substring(3),'E');
    	_Action = Enumeradores.Action.Edit;
    }
    public void on_btnEliminar_Clicked(){
    	if(Utils.MessageBox(Enumeradores.Message.Question, "¿Está seguro que desea eliminar el registro?")==StandardButton.Yes.value()){
	    	Funcionario func = new Funcionario();
	    	func.setId(Integer.parseInt(ui.twFuncionarios.item(ui.twFuncionarios.currentRow(), 0).text()));
	    	if(func.Eliminar())
	    		Utils.MessageBox(Enumeradores.Message.Information, "El registro ha sido eliminado satisfactoriamente.");
	    	else{
	    		Utils.MessageBox(Enumeradores.Message.Error, "Ha sido imposible eliminar el registro.\nIntente nuevamente");
	    		return;
	    	}
	    	Utils.HabilitaAcciones(this,_userName,objectName().substring(3),'\n');
	    	_Action = Enumeradores.Action.Delete;
	    	LoadData();
    	}
    }
    public void on_btnGuardar_Clicked(){
    	if(ui.leNomb.text().equals("") || ui.leInic.text().equals("") || ui.cmbProf.currentIndex() < 0){
    		Utils.MessageBox(Enumeradores.Message.Information, "Debe ingresar el nombre, las iniciales y la profesión.\nIntente nuevamente.");
    		return;
    	}
    	if(Utils.MessageBox(Enumeradores.Message.Question, "¿Está seguro que desea guardar?")==StandardButton.Yes.value()){
	    	boolean result = false;
	    	Funcionario func = new Funcionario();
	    	Profesion prof = new Profesion();
	    	prof.setId(Integer.parseInt(ui.cmbProf.itemData(ui.cmbProf.currentIndex()).toString()));
	    	prof.setDescripcion(ui.cmbProf.currentText());
	    	func.setProfesion(prof);
	    	func.setAMaterno(ui.leAMat.text());
	    	func.setAPaterno(ui.leAPat.text());
	    	func.setIniciales(ui.leInic.text());
	    	func.setNombre(ui.leNomb.text());
	    	func.setVigente(ui.ckbVige.isChecked());
	    	if(_Action == Enumeradores.Action.New)
	    		result = func.Insertar();
	    	else{
	    		func.setId(Integer.parseInt(ui.twFuncionarios.item(ui.twFuncionarios.currentRow(),0).text()));
	    		result = func.Modificar();
	    	}
	    	if(result){
	    		Utils.MessageBox(Enumeradores.Message.Information, "¡El registro se ha guardado satisfactoriamente!");
	    		ui.twFuncionarios.setEnabled(true);
	    		ui.gbUpdate.setEnabled(false);
	    		ui.cmbProf.setCurrentIndex(-1);
	    		ui.leAMat.setText("");
	        	ui.leAPat.setText("");
	        	ui.leAMat.setText("");
	        	ui.leInic.setText("");
	        	ui.leNomb.setText("");
	        	ui.ckbVige.setChecked(false);
	        	ui.lblStat.setText("");
	        	ui.twFuncionarios.setEnabled(true);
	        	Utils.HabilitaAcciones(this,_userName,objectName().substring(3),'B');
	        	_Action = Enumeradores.Action.None;
	        	LoadData();
	    	}else
	    		Utils.MessageBox(Enumeradores.Message.Error, "¡Se ha producido un error al guardar el registro!");
    	}
    }
    public void on_btnImprimir_Clicked(){
    	Funcionario.Printer(ui.twFuncionarios);
    }
    @SuppressWarnings("unused")
    private void on_twFuncionarios_CellClicked(int row, int col){
    	Utils.HabilitaAcciones(this,_userName,objectName().substring(3),'B');
    }
    
    private void CreateConnect(){
    	ui.btnNuevo.clicked.connect(this, "on_btnNuevo_Clicked()");
    	ui.btnEditar.clicked.connect(this, "on_btnEditar_Clicked()");
    	ui.btnGuardar.clicked.connect(this, "on_btnGuardar_Clicked()");
    	ui.btnEliminar.clicked.connect(this, "on_btnEliminar_Clicked()");
    	ui.btnImprimir.clicked.connect(this, "on_btnImprimir_Clicked()");
    	ui.twFuncionarios.cellClicked.connect(this, "on_twFuncionarios_CellClicked(int, int)");
    	Utils.HabilitaAcciones(this, _userName, objectName().substring(3), '\0');
    	LoadData();
    	LoadCombos();
    }
    
    private void LoadData(){
        int row = 0;
		ui.twFuncionarios.setRowCount(0);
        String sql = String.format("SELECT fun_id,fun_nomb,fun_apat,fun_amat,fun_inic,prf_desc,fun_vige FROM miniris.funcionarios INNER JOIN miniris.profesiones ON funcionarios.prf_id=miniris.profesiones.prf_id ORDER BY fun_id");
        try{
	        ResultSet query = DBUtils.getResultSet(sql); 
	        while(query.next()){
	            QTableWidgetItem item = null;
	            ui.twFuncionarios.insertRow(row);
	            ui.twFuncionarios.setRowHeight(row,20);
	
	            item = new QTableWidgetItem();
	            item.setText(query.getString("fun_id"));
	            //item.setTextAlignment(2);
	            ui.twFuncionarios.setItem(row,0,item);
	
	            item = new QTableWidgetItem();
	            item.setText(query.getString("fun_nomb"));
	            ui.twFuncionarios.setItem(row,1,item);
	            
	            item = new QTableWidgetItem();
	            item.setText(query.getString("fun_apat"));
	            ui.twFuncionarios.setItem(row,2,item);
	
	            item = new QTableWidgetItem();
	            item.setText(query.getString("fun_amat"));
	            ui.twFuncionarios.setItem(row,3,item);
	            
	            item = new QTableWidgetItem();
	            item.setText(query.getString("fun_inic"));
	            ui.twFuncionarios.setItem(row,4,item);
	            
	            item = new QTableWidgetItem();
	            item.setText(query.getString("prf_desc"));
	            ui.twFuncionarios.setItem(row,5,item);
	            
	            
	            item = new QTableWidgetItem();
	            item.setText(query.getBoolean("fun_vige")?"Sí":"No");
	            item.setTextAlignment(5);
	            ui.twFuncionarios.setItem(row,6,item);
	
	            row++;
	        }
        }catch(SQLException e){
        	e.printStackTrace();
        }
        ui.twFuncionarios.resizeColumnsToContents();
    }
    private void LoadCombos(){
    	DBUtils.loadComboBox(ui.cmbProf, String.format("SELECT prf_id,prf_desc FROM miniris.profesiones WHERE prf_vige='1' ORDER BY prf_id"));
    }

}
