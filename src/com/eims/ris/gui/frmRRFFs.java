package com.eims.ris.gui;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.eims.ris.core.DBUtils;
import com.eims.ris.core.Enumeradores;
import com.eims.ris.core.Modalidad;
import com.eims.ris.core.RRFFs;
import com.eims.ris.core.Utils;
import com.eims.ris.core.Enumeradores.Action;
import com.eims.ris.gui.Ui_frmRRFFs;
import com.trolltech.qt.core.Qt;
import com.trolltech.qt.gui.QApplication;
import com.trolltech.qt.gui.QDialog;
import com.trolltech.qt.gui.QDialogButtonBox.StandardButton;
import com.trolltech.qt.gui.QTableWidgetItem;
import com.trolltech.qt.gui.QWidget;

public class frmRRFFs extends QDialog {

    /**
	 * @uml.property  name="ui"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
    Ui_frmRRFFs ui = new Ui_frmRRFFs();
    /**
	 * @uml.property  name="_userName"
	 */
    private String _userName;
    /**
	 * @uml.property  name="_Action"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
    private Enumeradores.Action _Action = Enumeradores.Action.Edit;

    public frmRRFFs(String userName) {
        this(userName, null);
    }
    public frmRRFFs(String userName, QWidget parent) {
        super(parent);
        ui.setupUi(this);
        _userName = userName;
        CreateConnect();
        QApplication.restoreOverrideCursor();
    }
    public void on_btnNuevo_Clicked(){
    	ui.gbUpdate.setEnabled(true);
    	ui.leDesc.setText("");
    	ui.cmbModa.setCurrentIndex(-1);
    	ui.ckbVige.setChecked(false);
    	ui.lblStat.setText("Agregando\n[Esc] Cancelar");
    	ui.twRFs.setEnabled(false);
    	Utils.HabilitaAcciones(this, _userName, objectName().substring(3), 'A' );
    	_Action = Enumeradores.Action.New;
    }
    public void on_btnEditar_Clicked(){
    	ui.gbUpdate.setEnabled(true);
    	ui.leDesc.setText(ui.twRFs.item(ui.twRFs.currentRow(), 1).text());
    	ui.cmbModa.setCurrentIndex(ui.cmbModa.findText(ui.twRFs.item(ui.twRFs.currentRow(), 2).text()));
    	ui.ckbVige.setChecked(ui.twRFs.item(ui.twRFs.currentRow(), 3).text().equals("Sí"));
    	ui.lblStat.setText("Editando\n[Esc] Cancelar");
    	ui.twRFs.setEnabled(false);
    	Utils.HabilitaAcciones(this, _userName, objectName().substring(3), 'E');
    	_Action = Enumeradores.Action.Edit;
    }
    public void on_btnEliminar_Clicked(){
    	if(Utils.MessageBox(Enumeradores.Message.Question, "¿Está seguro que desea eliminar el registro?")==StandardButton.Yes.value()){
	    	RRFFs sal = new RRFFs();
	    	sal.setId(Integer.parseInt(ui.twRFs.item(ui.twRFs.currentRow(), 0).text()));
	    	sal.Eliminar();
	    	Utils.HabilitaAcciones(this, _userName , objectName().substring(3), '\n');
	    	_Action = Enumeradores.Action.Delete;
	    	LoadData();
    	}
    }
    public void on_btnGuardar_Clicked(){
    	if(ui.leDesc.text().equals("")){
    		Utils.MessageBox(Enumeradores.Message.Information, "Debe ingresar la descripción.\nIntente nuevamente.");
    		return;
    	}
    	if(Utils.MessageBox(Enumeradores.Message.Question, "¿Está seguro que desea guardar?")==StandardButton.Yes.value()){
	    	boolean result = false;
	    	RRFFs rf = new RRFFs();
	    	rf.setDescripcion(ui.leDesc.text());
	    	Modalidad modalidad = new Modalidad();
	    	modalidad.setModalidad(Integer.parseInt(ui.cmbModa.itemData(ui.cmbModa.currentIndex()).toString()));
	    	rf.setModalidad(modalidad);
	    	rf.setVigente(ui.ckbVige.isChecked());
	    	if(_Action == Action.New)
	    		result = rf.Insertar();
	    	else{
	    		rf.setId(Integer.parseInt(ui.twRFs.item(ui.twRFs.currentRow(), 0).text()));
	    		result = rf.Modificar();
	    	}
	    	if(result){
	    		Utils.MessageBox(Enumeradores.Message.Information, "El registro de ha guardado exitosamente!");
	    		ui.gbUpdate.setEnabled(false);
	    		ui.leDesc.setText("");
	    		ui.ckbVige.setChecked(false);
	    		ui.lblStat.setText("");
	    		ui.twRFs.setEnabled(true);
	    		_Action = Enumeradores.Action.None;
	    		LoadData();
	    		Utils.HabilitaAcciones(this, _userName, objectName().substring(3), 'B');
	    	}else
	    		Utils.MessageBox(Enumeradores.Message.Error, "Se ha producido un error!");
    	}
    }
    public void on_btnImprimir_Clicked(){
    	//Utils.GenerateXML(0, "salas", ui.twRFs);
    	RRFFs.Printer(ui.twRFs);
    }
    public void on_twRFs_CellClicked(int row, int col){
    	Utils.HabilitaAcciones(this, _userName, objectName().substring(3), 'B');
    }
    public void CreateConnect(){
    	ui.btnNuevo.clicked.connect(this, "on_btnNuevo_Clicked()");
    	ui.btnEditar.clicked.connect(this, "on_btnEditar_Clicked()");
    	ui.btnGuardar.clicked.connect(this, "on_btnGuardar_Clicked()");
    	ui.btnEliminar.clicked.connect(this, "on_btnEliminar_Clicked()");
    	ui.btnImprimir.clicked.connect(this, "on_btnImprimir_Clicked()");
    	ui.twRFs.cellClicked.connect(this, "on_twRFs_CellClicked(int, int)");
    	Utils.HabilitaAcciones(this, _userName, objectName().substring(3), '\0');
    	LoadData();
    }
    public void LoadData(){
    	int row = 0;
    	ui.twRFs.setRowCount(0);
    	String sql = String.format("SELECT rf_id,rf_desc,par_info,rf_vige FROM miniris.rrffs rf LEFT JOIN miniris.parametros p ON par_grupo='MD' AND rf.rf_moda=p.par_id ORDER BY rf_id");
    	try{
    		ResultSet query = DBUtils.getResultSet(sql);
    		while(query.next()){
    			QTableWidgetItem item = null;
    			ui.twRFs.insertRow(row);
    			ui.twRFs.setRowHeight(row, 20);
    			
    			item = new QTableWidgetItem();
    			item.setText(query.getString("rf_id"));
    			item.setTextAlignment(Qt.AlignmentFlag.AlignVCenter.value() | Qt.AlignmentFlag.AlignRight.value());
    			ui.twRFs.setItem(row, 0, item);
    			
    			item = new QTableWidgetItem();
    			item.setText(query.getString("rf_desc"));
    			item.setTextAlignment(Qt.AlignmentFlag.AlignVCenter.value());
    			ui.twRFs.setItem(row, 1, item);
    			
    			item = new QTableWidgetItem();
    			item.setText(query.getString("par_info"));
    			item.setTextAlignment(Qt.AlignmentFlag.AlignVCenter.value() | Qt.AlignmentFlag.AlignHCenter.value());
    			ui.twRFs.setItem(row, 2, item);
    			
    			item = new QTableWidgetItem();
    			item.setText(query.getBoolean("rf_vige")?"Sí":"No");
    			item.setTextAlignment(Qt.AlignmentFlag.AlignVCenter.value() | Qt.AlignmentFlag.AlignHCenter.value());
    			ui.twRFs.setItem(row, 3, item);
    			
    			row++;
    		}
    	}catch (SQLException e){
			e.printStackTrace();
		}
    	ui.twRFs.resizeColumnsToContents();
    	sql = String.format("SELECT par_id, par_info FROM miniris.parametros WHERE par_grupo='MD' AND par_vige=TRUE ORDER BY par_id");
        DBUtils.loadComboBox(ui.cmbModa, sql);
	}
}
