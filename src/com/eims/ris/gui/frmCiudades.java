package com.eims.ris.gui;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.trolltech.qt.core.Qt;
import com.trolltech.qt.gui.QApplication;
import com.trolltech.qt.gui.QDialog;
import com.trolltech.qt.gui.QDialogButtonBox.StandardButton;
import com.trolltech.qt.gui.QKeyEvent;
import com.trolltech.qt.gui.QTableWidgetItem;
import com.trolltech.qt.gui.QWidget;
import com.eims.ris.core.Ciudad;
import com.eims.ris.core.DBUtils;
import com.eims.ris.core.Enumeradores;
import com.eims.ris.core.Utils;
import com.eims.ris.gui.Ui_frmCiudades;

public class frmCiudades extends QDialog {

    /**
	 * @uml.property  name="ui"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
    Ui_frmCiudades ui = new Ui_frmCiudades();
    /**
	 * @uml.property  name="_userName"
	 */
    private String _userName;
    /**
	 * @uml.property  name="_Action"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
    private Enumeradores.Action _Action = Enumeradores.Action.None;

    public frmCiudades(String userName) {
    	this(userName, null);
    }
    public frmCiudades(String userName, QWidget parent) {
        super(parent);
        ui.setupUi(this);
        _userName = userName;
        CreateConnect();
    }
    protected void keyPressEvent(QKeyEvent ke){
    	if(!this._Action.equals(Enumeradores.Action.None) && ke.key() == Qt.Key.Key_Escape.value()){
    		ui.twCiudades.setEnabled(true);
    		ui.gbUpdate.setEnabled(false);
    		ui.leDesc.setText("");
    		ui.lblStat.setText("");
    		ui.twCiudades.setEnabled(true);
    		Utils.HabilitaAcciones(this, _userName, objectName().substring(3), '\0');
    		_Action = Enumeradores.Action.None;
    	}
    }
    public void CreateConnect() {
    	ui.btnNuevo.clicked.connect(this, "on_btnNuevo_Clicked()");
    	ui.btnEditar.clicked.connect(this, "on_btnEditar_Clicked()");
    	ui.btnGuardar.clicked.connect(this, "on_btnGuardar_Clicked()");
    	ui.btnEliminar.clicked.connect(this, "on_btnEliminar_Clicked()");
    	ui.btnImprimir.clicked.connect(this, "on_btnImprimir_Clicked()");
    	ui.twCiudades.cellClicked.connect(this, "ui_twCiudades_cellClicked(int, int)");
    	Utils.HabilitaAcciones(this, _userName, objectName().substring(3), '\0');
    	LoadData();
    	QApplication.restoreOverrideCursor();
    }
    public void on_btnNuevo_Clicked(){
    	ui.gbUpdate.setEnabled(true);
    	ui.leDesc.setText("");
    	ui.lblStat.setText("Agregando\n[Esc] Cancelar");
    	ui.twCiudades.setEnabled(false);
    	Utils.HabilitaAcciones(this, _userName, objectName().substring(3),'A');
    	_Action = Enumeradores.Action.New;
    }
    public void on_btnEditar_Clicked(){
    	ui.gbUpdate.setEnabled(true);
    	ui.leDesc.setText(ui.twCiudades.item(ui.twCiudades.currentRow(), 1).text());
    	ui.lblStat.setText("Editando\n[Esc] Cancelar");
    	ui.twCiudades.setEnabled(false);
    	Utils.HabilitaAcciones(this, _userName, objectName().substring(3), 'E');
    	_Action = Enumeradores.Action.Edit;
    }
    public void on_btnEliminar_Clicked(){
    	if(Utils.MessageBox(Enumeradores.Message.Question, "¿Está seguro que desea eliminar el registro?")==StandardButton.Yes.value()){
	    	Ciudad cd = new Ciudad();
	    	cd.setId(Integer.parseInt(ui.twCiudades.item(ui.twCiudades.currentRow(),0).text()));
	    	if(cd.Eliminar())
	    		Utils.MessageBox(Enumeradores.Message.Information, "El registro ha sido eliminado satisfactoriamente.");
	    	else{
	    		Utils.MessageBox(Enumeradores.Message.Error, "Ha sido imposible eliminar el registro.\nIntente nuevamente");
	    		return;
	    	}
	    	Utils.HabilitaAcciones(this, _userName , objectName().substring(3), 'E');
	    	_Action = Enumeradores.Action.Delete;
	    	LoadData();
    	}
    }
    public void on_btnGuardar_Clicked() {
    	if(ui.leDesc.text().equals("")){
    		Utils.MessageBox(Enumeradores.Message.Information, "Debe ingresar la descripción.\nIntente nuevamente.");
    		return;
    	}
    	if(Utils.MessageBox(Enumeradores.Message.Question, "¿Está seguro que desea guardar?")==StandardButton.Yes.value()){
	    	boolean result = false;
	    	Ciudad cd = new Ciudad();
	    	cd.setDescripcion(ui.leDesc.text());
	    	if(_Action == Enumeradores.Action.New){
	    		result = cd.Insertar();
	    	}else{
	    		cd.setId(Integer.parseInt(ui.twCiudades.item(ui.twCiudades.currentRow(), 0).text()));
	    		result = cd.Modificar();
	    	}
	    	if(result){
	    		Utils.MessageBox(Enumeradores.Message.Information, "Se han guardado los datos con exito!");
	    		ui.twCiudades.setEnabled(true);
	    		ui.gbUpdate.setEnabled(false);
	    		ui.leDesc.setText("");
	    		ui.lblStat.setText("");
	    		ui.twCiudades.setEnabled(true);
	    		Utils.HabilitaAcciones(this, _userName, objectName().substring(3), 'B');
	    		_Action = Enumeradores.Action.None;
	    		LoadData();
	    	}else{
	    		Utils.MessageBox(Enumeradores.Message.Error, "Se ha producido un error!");	
	    	}
    	}
    }
    public void on_btnImprimir_Clicked(){
    	Ciudad.Printer(ui.twCiudades);
    }
    public void ui_twCiudades_cellClicked(int row , int col){
    	Utils.HabilitaAcciones(this, _userName, objectName().substring(3), 'B');
    }
    public void LoadData(){
    	int row = 0;
    	int height = 20;
    	ui.twCiudades.setRowCount(0);
    	String sql = String.format("SELECT ciu_id, ciu_desc FROM miniris.ciudades ORDER BY ciu_id");
    	try {
    		ResultSet rs = DBUtils.getResultSet(sql);
    		while(rs.next()){
    			//Instanciación de Registro, crear fila, establece parametros(medidas)
    			QTableWidgetItem item = null;
    			ui.twCiudades.insertRow(row);
    			ui.twCiudades.setRowHeight(row, height);
    			//Se agregan resultado de la consulta según el numero de campos(2, id y desc).
    			item = new QTableWidgetItem();
    			item.setText(rs.getString("ciu_id"));
    			item.setTextAlignment(2);
    			ui.twCiudades.setItem(row, 0, item);
    		
    			item = new QTableWidgetItem();
    			item.setText(rs.getString("ciu_desc"));
    			ui.twCiudades.setItem(row, 1, item);
    			row++;
    		}
    	}
    	catch(SQLException e){
    		e.printStackTrace();
    	}
    	ui.twCiudades.resizeColumnsToContents();
    }
}
