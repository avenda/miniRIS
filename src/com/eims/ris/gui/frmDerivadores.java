package com.eims.ris.gui;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.eims.ris.core.DBUtils;
import com.eims.ris.core.Derivador;
import com.eims.ris.core.Enumeradores;
import com.eims.ris.core.Tipo;
import com.eims.ris.core.Utils;
import com.eims.ris.gui.Ui_frmDerivadores;
import com.trolltech.qt.gui.QApplication;
import com.trolltech.qt.gui.QDialog;
import com.trolltech.qt.gui.QWidget;
import com.trolltech.qt.gui.QTableWidgetItem;
import com.trolltech.qt.gui.QDialogButtonBox.StandardButton;

public class frmDerivadores extends QDialog {

    /**
	 * @uml.property  name="ui"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
    Ui_frmDerivadores ui = new Ui_frmDerivadores();
    /**
	 * @uml.property  name="_userName"
	 */
    private String _userName;
    /**
	 * @uml.property  name="_Action"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
    private Enumeradores.Action _Action = Enumeradores.Action.None;

    public frmDerivadores(String userName) {
        this(userName, null);
    }
    public frmDerivadores(String userName, QWidget parent) {
        super(parent);
        ui.setupUi(this);
        _userName = userName;
        CreateConnect();
        QApplication.restoreOverrideCursor();
    }
    public void on_btnNuevo_Clicked(){
    	ui.gbUpdate.setEnabled(true);
    	ui.cmbTipo.setCurrentIndex(-1);
    	ui.leDesc.setText("");
    	ui.ckbVige.setChecked(false);
    	ui.lblStat.setText("Agregando\n[Esc] Cancelar");
    	ui.twDerivadores.setEnabled(false);
    	Utils.HabilitaAcciones(this,_userName,objectName().substring(3),'A');
    	_Action = Enumeradores.Action.New;
    }
    public void on_btnEditar_Clicked(){
    	ui.gbUpdate.setEnabled(true);
    	ui.cmbTipo.setCurrentIndex(ui.cmbTipo.findText(ui.twDerivadores.item(ui.twDerivadores.currentRow(), 1).text()));
    	ui.leDesc.setText(ui.twDerivadores.item(ui.twDerivadores.currentRow(), 2).text());
    	ui.ckbVige.setChecked(ui.twDerivadores.item(ui.twDerivadores.currentRow(), 3).text().equals("Sí"));
    	ui.lblStat.setText("Editando\n[Esc] Cancelar");
    	ui.twDerivadores.setEnabled(false);
    	Utils.HabilitaAcciones(this,_userName,objectName().substring(3),'E');
    	_Action = Enumeradores.Action.Edit;
    }
    public void on_btnEliminar_Clicked(){
    	if(Utils.MessageBox(Enumeradores.Message.Question, "¿Está seguro que desea eliminar el registro?")==StandardButton.Yes.value()){
	    	Derivador deri = new Derivador();
	    	deri.setId(Integer.parseInt(ui.twDerivadores.item(ui.twDerivadores.currentRow(), 0).text()));
	    	if(deri.Eliminar())
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
    	if(ui.cmbTipo.currentIndex() < 0 || ui.leDesc.text().equals("")){
    		Utils.MessageBox(Enumeradores.Message.Information, "Debe ingresar el tipo y la descripción.\nIntente nuevamente.");
    		return;
    	}
    	if(Utils.MessageBox(Enumeradores.Message.Question, "¿Está seguro que desea guardar?")==StandardButton.Yes.value()){
	    	boolean result = false;
	    	Derivador deri = new Derivador();
	    	Tipo tipo = new Tipo();
	    	//tipo.setId(Integer.parseInt(ui.cmbTipo.itemData(ui.cmbTipo.currentIndex()).toString()));
	    	//tipo.setDescripcion(ui.cmbTipo.currentText());
	    	tipo.setTipo(Integer.parseInt(ui.cmbTipo.itemData(ui.cmbTipo.currentIndex()).toString()));
	    	
	    	deri.setTipo(tipo);
	    	deri.setDescripcion(ui.leDesc.text());
	    	deri.setVigente(ui.ckbVige.isChecked());
	    	if(_Action == Enumeradores.Action.New)	
	    		result = deri.Insertar();
	    	else{
	    		deri.setId(Integer.parseInt(ui.twDerivadores.item(ui.twDerivadores.currentRow(),0).text()));
	    		result = deri.Modificar();
	    	}
	    	if(result){
	    		Utils.MessageBox(Enumeradores.Message.Information, "¡El registro se ha guardado satisfactoriamente!");
	    		ui.twDerivadores.setEnabled(true);
	    		ui.gbUpdate.setEnabled(false);
	    		ui.cmbTipo.setCurrentIndex(-1);
	        	ui.leDesc.setText("");
	        	ui.ckbVige.setChecked(false);
	        	ui.lblStat.setText("");
	        	ui.twDerivadores.setEnabled(true);
	        	Utils.HabilitaAcciones(this,_userName,objectName().substring(3),'B');
	        	_Action = Enumeradores.Action.None;
	        	LoadData();
	    	}else
	    		Utils.MessageBox(Enumeradores.Message.Error, "¡Se ha producido un error al guardar el registro!");
    	}
    }
    public void on_btnImprimir_Clicked(){
    	Derivador.Printer(ui.twDerivadores);
    }
    @SuppressWarnings("unused")
    private void on_twDerivadores_CellClicked(int row, int col){
    	Utils.HabilitaAcciones(this,_userName,objectName().substring(3),'B');
    }
    
    private void CreateConnect(){
    	ui.btnNuevo.clicked.connect(this, "on_btnNuevo_Clicked()");
    	ui.btnEditar.clicked.connect(this, "on_btnEditar_Clicked()");
    	ui.btnGuardar.clicked.connect(this, "on_btnGuardar_Clicked()");
    	ui.btnEliminar.clicked.connect(this, "on_btnEliminar_Clicked()");
    	ui.btnImprimir.clicked.connect(this, "on_btnImprimir_Clicked()");
    	ui.twDerivadores.cellClicked.connect(this, "on_twDerivadores_CellClicked(int, int)");
    	Utils.HabilitaAcciones(this, _userName, objectName().substring(3), '\0');
    	LoadData();
    	LoadCombos();
    }
    
    private void LoadData(){
        int row = 0;
		ui.twDerivadores.setRowCount(0);
        String sql = String.format("SELECT deri_id,par_desc,deri_desc,deri_vige FROM miniris.derivadores d, miniris.parametros p WHERE p.par_grupo='TD' AND d.deri_tipo=p.par_id ORDER BY deri_id");
        try{
	        ResultSet query = DBUtils.getResultSet(sql); 
	        while(query.next()){
	            QTableWidgetItem item = null;
	            ui.twDerivadores.insertRow(row);
	            ui.twDerivadores.setRowHeight(row,20);
	
	            item = new QTableWidgetItem();
	            item.setText(query.getString("deri_id"));
	            item.setTextAlignment(2);
	            ui.twDerivadores.setItem(row,0,item);
	
	            item = new QTableWidgetItem();
	            item.setText(query.getString("par_desc"));
	            ui.twDerivadores.setItem(row,1,item);
	            
	            item = new QTableWidgetItem();
	            item.setText(query.getString("deri_desc"));
	            ui.twDerivadores.setItem(row,2,item);
	
	            item = new QTableWidgetItem();
	            item.setText(query.getBoolean("deri_vige")?"Sí":"No");
	            item.setTextAlignment(5);
	            ui.twDerivadores.setItem(row,3,item);
	
	            row++;
	        }
        }catch(SQLException e){
        	e.printStackTrace();
        }
        ui.twDerivadores.resizeColumnsToContents();
    }
    private void LoadCombos(){
    	DBUtils.loadComboBox(ui.cmbTipo, String.format("SELECT par_id,par_desc FROM miniris.parametros WHERE par_grupo='TD' AND par_vige=TRUE ORDER BY par_id"));
    }
}
