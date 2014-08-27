package com.eims.ris.gui;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.llp.LLPException;

import com.eims.ris.core.DBUtils;
import com.eims.ris.core.Derivador;
import com.eims.ris.core.Funcionario;
import com.eims.ris.core.Paciente;
import com.eims.ris.core.Prestacion;
import com.eims.ris.core.RRFFs;
import com.eims.ris.core.Recepcion;
import com.eims.ris.core.RecepcionPrestaciones;
import com.eims.ris.core.SistSalud;
import com.eims.ris.core.Utils;
import com.eims.ris.core.Enumeradores.Action;
import com.eims.ris.core.Enumeradores.DateTimeFormat;
import com.eims.ris.core.Enumeradores.Message;
import com.eims.ris.gui.Ui_frmRecepciones;
import com.eims.ris.integration.hl7.HL7Message;
import com.eims.ris.integration.hl7.MensajeHL7;

import com.trolltech.qt.core.QDate;
import com.trolltech.qt.core.QDateTime;
import com.trolltech.qt.core.Qt;
import com.trolltech.qt.gui.QApplication;
import com.trolltech.qt.gui.QCursor;
import com.trolltech.qt.gui.QDialog;
import com.trolltech.qt.gui.QKeyEvent;
import com.trolltech.qt.gui.QTableWidgetItem;
import com.trolltech.qt.gui.QWidget;
import com.trolltech.qt.gui.QDialogButtonBox.StandardButton;


public class frmRecepciones extends QDialog {

    /**
	 * @uml.property  name="ui"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
    Ui_frmRecepciones ui = new Ui_frmRecepciones();
    /**
	 * @uml.property  name="_userName"
	 */
    private String _userName;
    /**
	 * @uml.property  name="_dateTimeFormat"
	 */
    private String _dateTimeFormat;
    /**
	 * @uml.property  name="_pacID"
	 */
    private int _pacID;
    /**
	 * @uml.property  name="_pacRUN"
	 */
    private String _pacRUN;
    /**
	 * @uml.property  name="_Action"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
    private Action _Action = Action.None;
    /**
	 * @uml.property  name="_DAction"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
    private Action _DAction = Action.None;

    public frmRecepciones(String userName) {
        this(userName, null);
    }
    public frmRecepciones(String userName, QWidget parent) {
        super(parent);
        ui.setupUi(this);
        _userName = userName;
        _dateTimeFormat = Utils.getDateTimeFormat(DateTimeFormat.DateTime);
        ui.dteFeHo.setDisplayFormat(this._dateTimeFormat);
        ui.dteHecho.setDisplayFormat(this._dateTimeFormat);
        ui.leID.setText(String.valueOf(DBUtils.getLastIDRecepcion()));
        CreateConnect();
        QApplication.restoreOverrideCursor();
    }
    @Override
    public void keyPressEvent(QKeyEvent e){
		if(e.key()==Qt.Key.Key_Return.value() || e.key()==Qt.Key.Key_Enter.value()){
	        //System.out.println(e.key() + " :: " + Qt.Key.Key_Tab);
	        if(focusWidget().equals(ui.leID)){
	            if(!ui.leID.text().isEmpty()){
	                if(LoadRecepcion(ui.leID.text())){
	                	//ui.leID.setText(ui.leID.text());
	                	ui.gbEnca.setEnabled(true);
	                	ui.gbDeta.setEnabled(true);
	                	ui.gbHecho.setEnabled(true);
	                }
	            }
	        }else if(focusWidget().equals(ui.leRUN) || focusWidget().equals(ui.leFich) || focusWidget().equals(ui.leCCte)){
	            String filtro = "";
	            if(focusWidget().equals(ui.leRUN)){
	                ui.leRUN.setText(ui.leRUN.text());
	                if(!Utils.ValidarRUN(ui.leRUN.text())){
	                    Utils.MessageBox(Message.Information, "El RUN ingresado no es vlido.\nIntente nuevamente.");
	                    return;
	                }
	                filtro = String.format("pac_run='%1$s'", ui.leRUN.text());
	            }else if(focusWidget().equals(ui.leFich)){
	                filtro = String.format("pac_fich=%1$s", ui.leFich.text());
	            }else if(focusWidget().equals(ui.leCCte)){
	                filtro = String.format("pac_ccte=%1$s", ui.leCCte.text());
	            }
	            String sql = String.format("SELECT pac_id FROM miniris.pacientes WHERE %1$s", filtro);
	            try{
		            ResultSet query = DBUtils.getResultSet(sql);
		            if(query.next()){
		                _pacID = query.getInt(1);
		                LoadPaciente();
		            }
	            }catch (SQLException ex) {
					DBUtils.showSQLException(ex);
				}
		            
		        /*else{
	                //if(!QSqlDatabase::database("dbHIS").isOpen()) return;
	                if(QMessageBox.question(this,"Paciente","El paciente buscado no existe en la BD de RIS, intente buscarlo en HIS.\nDesea hacerlo ahora?", QMessageBox.ButtonRole.YesRole | QMessageBox.ButtonRole.NoRole)==QMessageBox.ButtonRole.YesRole){
	                    frmPacientes p = new frmPacientes(_userName, true);
	                    if(focusWidget()==ui.leCCte){
	                    	query = DBUtils.getResultSet(String.format("SELECT PAC_CAR_NumerFicha FROM ATC_Cuenta c, PAC_Carpeta p WHERE c.PAC_PAC_Numero*=p.PAC_PAC_Numero AND ATC_CTA_Correlativo=%1$s", ui.leCCte.text().toString()));
	                        if(query.next()){
	                            ui.leFich.setText(query.getString(1).toString());
	                        }
	                    }
	                    p.setFindHIS(true);
	                    p.setPacRUN(ui.leRUN.text());
	                    p.setPacFicha(ui.leFich.text());
	                    p.on_btnFiltrar_Clicked();
	                    if(p.exec()==QDialog.Accepted){
	                        _pacID = p.getPacienteID();
	                        if(_pacID>0) LoadPaciente();
	                    }
	                }
	            }*/
	        }else if(focusWidget().equals(ui.lePrest)){
	        	try{
		        	ResultSet query = DBUtils.getResultSet(String.format("SELECT prest_id FROM miniris.prestaciones WHERE prest_id='%1$s'", ui.lePrest.text()));
		            if(query.next()){
		                ui.cmbPres.setCurrentIndex(ui.cmbPres.findData(query.getString(1).trim()));
		                query.close();
		            }else{
		            	Utils.MessageBox(Message.Information,"El código introducido no existe, verifique e intente nuevamente.");
		                return;
		            }
	        	}catch (SQLException ex) {
					DBUtils.showSQLException(ex);
				}
	        }
	        focusNextChild();
		}
	}
	public void on_btnMBPac_Clicked(){
		QApplication.setOverrideCursor(new QCursor(Qt.CursorShape.WaitCursor));
		frmPacientes pac = new frmPacientes(_userName, false);
		pac.setPacRun(ui.leRUN.text());
	    pac.setPacFicha(ui.leFich.text());
		pac.on_btnFiltrar_Clicked();
	    if(pac.exec() == 1){
	    	_pacID = pac.getPacID();
	        if(_pacID > 0) LoadPaciente();
	    }
	    QApplication.restoreOverrideCursor();
	}
	public void on_btnMBRec_Clicked(){
		/*frmRecepciones r = new Recepcion;
	    if(r.exec()==QDialog.DialogCode.Accepted){
	        ui.leID.setText(QString.number(r.getRecepcionID()));
	        LoadRecepcion(ui.leID.text());
	        delete r;
	    }*/
	}
	public void on_btnMPaci_Clicked(){
		QApplication.setOverrideCursor(new QCursor(Qt.CursorShape.WaitCursor));
        frmPacientes pac = new frmPacientes(_userName, true);
        pac.setPacRun(ui.leRUN.text());
        pac.setPacFicha(ui.leFich.text());
        pac.on_btnFiltrar_Clicked();
        if(pac.exec() == 1){
	        _pacID = pac.getPacID();
	        if(_pacID > 0) LoadPaciente();
	    }
        QApplication.restoreOverrideCursor();
	}
	public void on_btnMDeri_Clicked(){
		QApplication.setOverrideCursor(new QCursor(Qt.CursorShape.WaitCursor));
	    frmDerivadores derivador = new frmDerivadores(_userName);
	    derivador.exec();
	}
	public void on_btnMSSal_Clicked(){
		QApplication.setOverrideCursor(new QCursor(Qt.CursorShape.WaitCursor));
		frmSistSalud ssalud = new frmSistSalud(_userName);
	    ssalud.exec();
	    QApplication.restoreOverrideCursor();
	}
	public void on_btnMFunc_Clicked(){
		QApplication.setOverrideCursor(new QCursor(Qt.CursorShape.WaitCursor));
	    frmFuncionarios funcionario = new frmFuncionarios(_userName);
	    funcionario.exec();
	    QApplication.restoreOverrideCursor();
	}
	public void on_btnNuevo_Clicked(){
		ui.dteFeHo.setDateTime(QDateTime.fromString(Utils.ObtenerFechaHora()));
	    ui.lblDigi.setText(String.format("%1$s\n%2$s", QDateTime.fromString(Utils.ObtenerFechaHora(), "dd-MM-yyyy HH:mm"), this._userName));
	    ui.cmbTRec.setCurrentIndex(-1);
	    ui.cmbERec.setCurrentIndex(0);
	    ui.cmbTDer.setCurrentIndex(-1);
	    ui.cmbSSal.setCurrentIndex(-1);
	    ui.cmbNUrg.setCurrentIndex(-1);
	    ui.cmbRF.setCurrentIndex(-1);
	    ui.cmbResp.setCurrentIndex(-1);
	    ui.cmbToma.setCurrentIndex(-1);
	    ui.leID.setText(String.format("%1$s", DBUtils.getLastIDRecepcion()));
	    ui.leRUN.clear();
	    ui.leDAU.clear();
	    ui.leFich.clear();
	    ui.leCCte.clear();
	    ui.lePaci.clear();
	    ui.leFono.clear();
	    ui.leEdad.clear();
	    ui.leSexo.clear();
	    ui.lblFHCit.clear();
	    ui.leObse.clear();
	    ui.leCiud.clear();
	    ui.leAPat.clear();
	    ui.leAMat.clear();
	    ClearDetalle();
	    ui.dteHecho.setDateTime(QDateTime.fromString(Utils.ObtenerFechaHora()));
	    ui.dteFeHo.setEnabled(true);
    	ui.gbEnca.setEnabled(true);
    	ui.gbDeta.setEnabled(true);
    	ui.gbHecho.setEnabled(true);
	    ui.lblStat.setText("Agregando\nRecepción");
	    ui.twPrestaciones.setRowCount(0);
	    ui.twPrestaciones.clearContents();
	    Utils.HabilitaAcciones(this, _userName, objectName().substring(3),'A');
	    _Action = Action.New;
	    EnabledDButtons(true,false,false,false,false);
	    _pacID = 0;
	}
	public void on_btnGuardar_Clicked(){
		if(_pacID == 0){
	        Utils.MessageBox(Message.Information, "Debe seleccionar un paciente antes de guardar.\nIntente nuevamente.");
	        ui.leRUN.setFocus();
	        return;
	    }
	    if(ui.cmbTRec.currentIndex()<0){
	        ui.cmbTRec.showPopup();
	        return;
	    }
	    if(ui.cmbTDer.currentIndex()<0){
	        ui.cmbTDer.showPopup();
	        return;
	    }
	    if(ui.cmbDeri.currentIndex()<0){
	        ui.cmbDeri.showPopup();
	        return;
	    }
	    if(ui.cmbSSal.currentIndex()<0){
	        ui.cmbSSal.showPopup();
	        return;
	    }
	    if(ui.cmbNUrg.currentIndex()<0){
	        ui.cmbNUrg.showPopup();
	        return;
	    }
	    if(ui.cmbRF.currentIndex()<0){
	        ui.cmbRF.showPopup();
	        return;
	    }
	    if(ui.cmbResp.currentIndex()<0){
	        ui.cmbResp.showPopup();
	        return;
	    }
	    if(ui.twPrestaciones.rowCount()<1){
	        Utils.MessageBox(Message.Information, "No ha ingresado ninguna prestación para la recepción.\nIntente nuevamente.");
	        return;
	    }
	    if(Utils.MessageBox(Message.Question, "¿Está seguro que desea guardar?")==StandardButton.Yes.value()){
	    	boolean result = false;
	    	Recepcion recepcion = new Recepcion();
		    recepcion.setTipo(Integer.parseInt(ui.cmbTRec.itemData(ui.cmbTRec.currentIndex()).toString()));
		    recepcion.setFechaHora(ui.dteFeHo.dateTime());
		    Paciente paciente = new Paciente();
		    paciente.setPaciente(_pacID);
		    recepcion.setPaciente(paciente);
		    Derivador derivador = new Derivador();
		    derivador.setDerivador(Integer.parseInt(ui.cmbDeri.itemData(ui.cmbDeri.currentIndex()).toString()));
		    recepcion.setDerivador(derivador);
		    SistSalud sistSalud = new SistSalud();
		    sistSalud.setSistemaSalud(Integer.parseInt(ui.cmbSSal.itemData(ui.cmbSSal.currentIndex()).toString()));
		    recepcion.setSistemaSalud(sistSalud);
		    recepcion.setNivelUrgencia(Integer.parseInt(ui.cmbNUrg.itemData(ui.cmbNUrg.currentIndex()).toString()));
		    RRFFs rf = new RRFFs();
		    rf.setRF(Integer.parseInt(ui.cmbRF.itemData(ui.cmbRF.currentIndex()).toString()));
		    recepcion.setRRFF(rf);
		    Funcionario responsable = new Funcionario();
		    responsable.setFuncionario(Integer.parseInt(ui.cmbResp.itemData(ui.cmbResp.currentIndex()).toString()));
		    recepcion.setResponsable(responsable);
		    recepcion.setAsiste(true);
		    //recepcion.setIDCitacion(Long.parseLong(DBUtils.getTableField(String.format("SELECT cita_id FROM miniris.citaciones WHERE eps_id=%1$s", ui.leID.text()))));
		    recepcion.setObservacion(ui.leObse.text().trim());
		    recepcion.setUsuario(this._userName);
		    recepcion.setEstadoRecepcion(Integer.parseInt(ui.cmbERec.itemData(ui.cmbERec.currentIndex()).toString()));
		    recepcion.setParaInformar(0);
		    recepcion.setInfoAdicional(0);
		    
		    RecepcionPrestaciones rp = null;
		    Prestacion prestacion = null;
		    Funcionario funcionario = null;
		    for(int i=0; i<ui.twPrestaciones.rowCount(); i++){
		    	rp = new RecepcionPrestaciones();
		    	prestacion = new Prestacion();
		    	prestacion.setPrestacion(ui.twPrestaciones.item(i,1).text());
			    rp.setPrestacion(prestacion);
			    rp.setCantidad(Integer.parseInt(ui.twPrestaciones.item(i,3).text()));
			    funcionario = new Funcionario();
			    funcionario.setFuncionario(Integer.parseInt(ui.twPrestaciones.item(i,4).text()));
			    rp.setResponsable(responsable);
			    rp.setTomado(ui.twPrestaciones.item(i,6).text().equals("Sí"));
			    rp.setFHToma(QDateTime.fromString(ui.twPrestaciones.item(i,7).text()));
			    System.out.println("FHToma: " + rp.getFHToma());
			    rp.setEstado(ui.twPrestaciones.item(i, 0).text());
			    recepcion.setRecepcionPrestaciones(rp);
		    }
		    if(this._Action == Action.New){
		    	recepcion.setFHDigitacion(QDateTime.fromString(Utils.ObtenerFechaHora(), "yyyy-MM-dd HH:mm:ss"));
		    	result = recepcion.Insertar();
		    	HL7Message msg = new HL7Message();
		    	msg.setRecepcion(recepcion);
				try {
					msg.Enviar();
				} catch (HL7Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (LLPException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }else{
		    	recepcion.setId(Long.parseLong(ui.leID.text().trim()));
		    	result = recepcion.Modificar();
		    }
		    if(result){	    
		        //GenerarMensaje();		        
		        EnabledDButtons(true,false,false,false,false);
		        ui.lblStat.setText("Editando\nRecepción");
		        Utils.HabilitaAcciones(this, _userName, objectName().substring(3),'E');
		        //ui.btnNuevo.setEnabled(CheckAccessButton(_userName, objectName(), 'A'));
		        //ui.btnImprimir.setEnabled(CheckAccessButton(_userName, objectName(), 'I'));
		        _Action = Action.Edit;
		        Utils.MessageBox(Message.Information, "¡El registro se ha guardado satisfactoriamente!");
		    }else
		    	Utils.MessageBox(Message.Error, "¡Se ha producido un error al guardar el registro!");
	        
	    }
	}
	public void on_btnImprimir(){
		
	}
	public void on_btnDNuevo_Clicked(){
		ClearDetalle();
	    ui.lePrest.setFocus();
	    ui.cmbToma.setCurrentIndex(ui.cmbResp.currentIndex());
	    EnabledDButtons(false,false,true,false,true);
	    _DAction = Action.New;
	}
	public void on_btnDEditar_Clicked(){
		ui.cmbPres.setCurrentIndex(ui.cmbPres.findData(ui.twPrestaciones.item(ui.twPrestaciones.currentRow(),1).text()));
	    ui.sbCant.setValue(Integer.parseInt(ui.twPrestaciones.item(ui.twPrestaciones.currentRow(),3).text().toString()));
	    ui.cmbToma.setCurrentIndex(ui.cmbToma.findText(ui.twPrestaciones.item(ui.twPrestaciones.currentRow(),5).text()));
	    ui.gbHecho.setChecked(ui.twPrestaciones.item(ui.twPrestaciones.currentRow(),6).text().equals("Sí"));
	    ui.dteHecho.setDateTime(QDateTime.fromString(ui.twPrestaciones.item(ui.twPrestaciones.currentRow(),7).text(),"dd-MM-yyyy HH:mm"));
	    ui.sbCant.setFocus();
	    EnabledDButtons(false,false,true,false,true);
	    _DAction = Action.Edit;
	}
	public void on_btnDGuardar_Clicked()
	{
	    int row = 0;
	    if(_DAction == Action.New){
	        ui.twPrestaciones.insertRow(ui.twPrestaciones.rowCount());
	        row = ui.twPrestaciones.rowCount() - 1;
	        ui.twPrestaciones.setRowHeight(row,20);
	    }else
	        row = ui.twPrestaciones.currentRow();

	    QTableWidgetItem item;

	    item = new QTableWidgetItem();
	    item.setText(_DAction==Action.New ? "I" : "M");
	    item.setTextAlignment(5);
	    ui.twPrestaciones.setItem(row,0,item);

	    item = new QTableWidgetItem();
	    item.setText(ui.lePrest.text());
	    ui.twPrestaciones.setItem(row,1,item);

	    item = new QTableWidgetItem();
	    item.setText(ui.cmbPres.currentText());
	    ui.twPrestaciones.setItem(row,2,item);

	    item = new QTableWidgetItem();
	    item.setText(ui.sbCant.text());
	    item.setTextAlignment(2);
	    ui.twPrestaciones.setItem(row,3,item);

	    item = new QTableWidgetItem();
	    item.setText(ui.cmbToma.itemData(ui.cmbToma.currentIndex()).toString());
	    ui.twPrestaciones.setItem(row,4,item);
	    
	    item = new QTableWidgetItem();
	    item.setText(ui.cmbToma.currentText());
	    ui.twPrestaciones.setItem(row,5,item);

	    item = new QTableWidgetItem();
	    item.setText(ui.gbHecho.isChecked()?"Sí":"No");
	    item.setTextAlignment(5);
	    ui.twPrestaciones.setItem(row,6,item);

	    item = new QTableWidgetItem();
	    item.setText(ui.gbHecho.isChecked()?ui.dteHecho.text():"0000-00-00 00:00:00");
	    ui.twPrestaciones.setItem(row,7,item);

	    ui.twPrestaciones.resizeColumnsToContents();
	    EnabledDButtons(true,false,false,false,false);
	    ClearDetalle();
	    //on_btnDNuevo_Clicked();
	}
	public void on_btnDEliminar_Clicked(){
		if(ui.twPrestaciones.item(ui.twPrestaciones.currentRow(),0).text().equals("") ||
	       ui.twPrestaciones.item(ui.twPrestaciones.currentRow(),0).text().equals("M"))
	        ui.twPrestaciones.item(ui.twPrestaciones.currentRow(),0).setText("E");
	    else
	        ui.twPrestaciones.removeRow(ui.twPrestaciones.currentRow());
	}
	public void on_btnDCancelar_Clicked(){
		ClearDetalle();
	    EnabledDButtons(true,false,false,false,false);
	}
	public void on_cmbTRec_CurrentIndexChanged(int idx){
		if(idx != 1){
	        ui.cmbTDer.setCurrentIndex(ui.cmbTDer.findData(idx==0?5:4));
	        ui.cmbNUrg.setCurrentIndex(ui.cmbNUrg.findData(1));
	    }
	}
	public void on_cmbNUrg_CurrentIndexChanged(int idx){
		if(idx != 1){
	        ui.cmbTDer.setCurrentIndex(ui.cmbTDer.findData(idx==0?5:4));
	    }
	}
	public void on_cmbTDer_CurrentIndexChanged(int idx){
		DBUtils.loadComboBox(ui.cmbDeri, String.format("SELECT deri_id,deri_desc FROM miniris.derivadores WHERE deri_tipo='%1$s' AND deri_vige='1' ORDER BY deri_desc", ui.cmbTDer.itemData(idx).toString()));
	}
	public void on_cmbPres_CurrentIndexChanged(int idx){
		if(idx > -1)
			ui.lePrest.setText(ui.cmbPres.itemData(idx).toString());
		else
			ui.lePrest.setText("");
	}
	public void on_twPrestaciones_CellClicked(int row, int col)
	{
	    EnabledDButtons(true,true,false,true,false);
	}

    public void CreateConnect(){
    	LoadCombos();
    	
    	ui.btnMBPac.clicked.connect(this, "on_btnMBPac_Clicked()");
    	ui.btnMBRec.clicked.connect(this, "on_btnMBRec_Clicked()");
    	ui.btnMPaci.clicked.connect(this, "on_btnMPaci_Clicked()");
    	ui.btnMDeri.clicked.connect(this, "on_btnMDeri_Clicked()");
    	ui.btnMSSal.clicked.connect(this, "on_btnMSSal_Clicked()");
    	ui.btnMFunc.clicked.connect(this, "on_btnMFunc_Clicked()");

    	ui.btnNuevo.clicked.connect(this, "on_btnNuevo_Clicked()");
    	ui.btnGuardar.clicked.connect(this, "on_btnGuardar_Clicked()");
    	ui.btnImprimir.clicked.connect(this, "on_btnImprimir()");

    	ui.btnDNuevo.clicked.connect(this, "on_btnDNuevo_Clicked()");
    	ui.btnDEditar.clicked.connect(this, "on_btnDEditar_Clicked()");
    	ui.btnDGuardar.clicked.connect(this, "on_btnDGuardar_Clicked()");
    	ui.btnDEliminar.clicked.connect(this, "on_btnDEliminar_Clicked()");
    	ui.btnDCancelar.clicked.connect(this, "on_btnDCancelar_Clicked()");
    	    
    	ui.cmbTRec.currentIndexChanged.connect(this, "on_cmbTRec_CurrentIndexChanged(int)");
    	ui.cmbNUrg.currentIndexChanged.connect(this, "on_cmbNUrg_CurrentIndexChanged(int)");
    	ui.cmbTDer.currentIndexChanged.connect(this, "on_cmbTDer_CurrentIndexChanged(int)");
    	ui.cmbPres.currentIndexChanged.connect(this, "on_cmbPres_CurrentIndexChanged(int)");

    	ui.twPrestaciones.cellClicked.connect(this, "on_twPrestaciones_CellClicked(int,int)");
    	
    	Utils.HabilitaOpciones(this, _userName);
    	Utils.HabilitaAcciones(this, _userName, objectName().substring(3), '\0');
    	ui.dteFeHo.setEnabled(false);
    	ui.gbDeta.setEnabled(false);
    	ui.gbEnca.setEnabled(false);
    	ui.gbHecho.setEnabled(false);
    	ui.dteFeHo.setDateTime(QDateTime.currentDateTime());
    	ui.twPrestaciones.setColumnHidden(4, true);
    	ui.twPrestaciones.resizeColumnsToContents();
    }
    
    public void LoadCombos(){
    	String sql;
    	sql = String.format("SELECT par_id,par_desc FROM miniris.parametros WHERE par_grupo='TR' AND par_vige='1' ORDER BY par_id");
    	DBUtils.loadComboBox(ui.cmbTRec, sql);
    	sql = String.format("SELECT par_id,par_desc FROM miniris.parametros WHERE par_grupo='ER' AND par_vige='1' ORDER BY par_id");
    	DBUtils.loadComboBox(ui.cmbERec, sql);
    	sql = String.format("SELECT par_id,par_info FROM miniris.parametros WHERE par_grupo='TD' AND par_vige='1' ORDER BY par_id");
    	DBUtils.loadComboBox(ui.cmbTDer, sql);
    	sql = String.format("SELECT ssa_id,ssa_desc FROM miniris.sist_salud WHERE ssa_vige='1' ORDER BY ssa_desc");
    	DBUtils.loadComboBox(ui.cmbSSal, sql);
    	sql = String.format("SELECT par_id,par_desc FROM miniris.parametros WHERE par_grupo='NU' AND par_vige='1' ORDER BY par_id");
    	DBUtils.loadComboBox(ui.cmbNUrg, sql);
    	sql = String.format("SELECT rf_id,rf_desc FROM miniris.rrffs WHERE rf_vige='1' ORDER BY rf_desc");
    	DBUtils.loadComboBox(ui.cmbRF, sql);
    	sql = String.format("SELECT prest_id,prest_desc FROM miniris.prestaciones WHERE prest_vige='1' ORDER BY prest_desc");
    	DBUtils.loadComboBox(ui.cmbPres, sql);
    	sql = String.format("SELECT fun_id,TRIM(fun_apat || ' ' || fun_amat || ' ' || fun_nomb) FROM miniris.funcionarios WHERE fun_vige='1' ORDER BY fun_apat,fun_amat,fun_nomb");
    	DBUtils.loadComboBox(ui.cmbResp, sql);
    	DBUtils.loadComboBox(ui.cmbToma, sql);
    }
    
    public void LoadPaciente(){
        try{
        	ResultSet query = DBUtils.getResultSet(String.format("SELECT pac_run,pac_fich,pac_apat,pac_amat,pac_nomb,pac_sexo,pac_fnac,pac_fon1,pac_fon2,pac_mail,pac_dire,ssa_id, ciu_desc FROM miniris.pacientes, miniris.ciudades WHERE pac_id=%1$s AND ciudades.ciu_id = pacientes.ciu_id", _pacID));
        	if(query.next()){
        		System.out.println(query.getString("pac_nomb"));
        		//QSqlRecord record = query.();
        		EnabledDButtons(true,false,false,false,false);
        		ui.leRUN.setText(query.getString("pac_run"));
        		ui.leFich.setText(query.getString("pac_fich").toString());
        		ui.lePaci.setText(query.getString("pac_nomb").trim());
        		ui.leAPat.setText(query.getString("pac_apat").trim());
        		ui.leAMat.setText(query.getString("pac_amat").trim());
        		ui.leFono.setText(query.getString("pac_fon1").trim()+" - "+query.getString("pac_fon2").trim());
        		ui.leCiud.setText(query.getString("ciu_desc").trim());
        		ui.leEdad.setText(DBUtils.ObtenerEdad(QDate.fromString(query.getString("pac_fnac"))));
        		ui.leSexo.setText(query.getString("pac_sexo").trim());
        		ui.cmbSSal.setCurrentIndex(ui.cmbSSal.findData(query.getInt("ssa_id")));
        	}
        	query.close();
        }catch(SQLException e){
        	e.printStackTrace();
        }
    }
    
    public boolean LoadRecepcion(String idRecep)
    {
    	try{
	    	ResultSet query = DBUtils.getResultSet(String.format("SELECT eps_id,eps_trec,eps_fhre,pac_id,eps_dau,eps_ccte,deri_id,ssa_id,eps_nurg,rf_id,eps_ures,eps_cita,eps_obse,eps_fhdi,eps_user,eps_erec,eps_pinf FROM miniris.prestsol_enc WHERE eps_id=%1$s", ui.leID.text()));
	        if(query.next()){
	            //QSqlRecord record = query.record();
	
	            ui.cmbTRec.setCurrentIndex(ui.cmbTRec.findData(query.getInt("eps_trec")));
	            ui.cmbERec.setCurrentIndex(ui.cmbERec.findData(query.getInt("eps_erec")));
	            
	            Object FHRecep = query.getDate("eps_fhre");
	            if(FHRecep == null) 
	                ui.dteFeHo.setDateTime(QDateTime.fromString(Utils.ObtenerFechaHora(), Utils.getDateTimeFormat(DateTimeFormat.DateTime)));
	            else
	                ui.dteFeHo.setDateTime(QDateTime.fromString(query.getString("eps_fhre")));
	            
	            //ui.lblDigi.setText(query.getDate("eps_fhdi").toString("dd-MM-yyyy HH:mm")+"\n"+query.getString("eps_user").toString());
	            //ui.leDAU.setText(query.getString("eps_dau").toString());
	            //ui.leCCte.setText(query.getString("eps_ccte").toString());
	
	            String sql = String.format("SELECT deri_tipo FROM miniris.derivadores WHERE deri_id=%1$s", query.getInt("deri_id"));
	            int TDeri = Integer.parseInt(DBUtils.getTableField(sql));
	            ui.cmbTDer.setCurrentIndex(ui.cmbTDer.findData(TDeri));
	
	            _pacID = query.getInt("pac_id");
	            LoadPaciente();
	
	            ui.cmbDeri.setCurrentIndex(ui.cmbDeri.findData(query.getInt("deri_id")));
	            ui.cmbSSal.setCurrentIndex(ui.cmbSSal.findData(query.getInt("ssa_id")));
	            ui.cmbNUrg.setCurrentIndex(ui.cmbNUrg.findData(query.getInt("eps_nurg")));
	            ui.cmbRF.setCurrentIndex(ui.cmbRF.findData(query.getInt("rf_id")));
	            ui.cmbResp.setCurrentIndex(ui.cmbResp.findData(query.getInt("eps_ures")));
	            
	            if(query.getInt("eps_cita")>0)
	            	ui.lblFHCit.setText(DBUtils.getTableField(String.format("SELECT cita_feho FROM miniris.citaciones WHERE cita_id=%1$s",query.getInt("eps_cita"))).substring(0,16));
	            
	            ui.leObse.setText(query.getString("eps_obse"));
	
	            query.close();
	            int row = 0;
	            QTableWidgetItem item;
	            ui.twPrestaciones.setRowCount(0);
	            query = DBUtils.getResultSet(String.format("SELECT pd.prest_id,p.prest_desc,dps_cant,pd.fun_id,fun_apat,fun_amat,fun_nomb,dps_toma,dps_fhto FROM miniris.prestsol_det pd INNER JOIN miniris.prestaciones p ON pd.prest_id=p.prest_id INNER JOIN miniris.funcionarios f ON pd.fun_id=f.fun_id WHERE eps_id=%1$s", ui.leID.text()));
	            while(query.next()){
	                ui.twPrestaciones.insertRow(row);
	                ui.twPrestaciones.setRowHeight(row,20);
	
	                item = new QTableWidgetItem();
	                item.setText("");
	                item.setTextAlignment(Qt.AlignmentFlag.AlignVCenter.value() | Qt.AlignmentFlag.AlignCenter.value());
	                ui.twPrestaciones.setItem(row,0,item);
	
	                item = new QTableWidgetItem();
	                item.setText(query.getString("prest_id"));
	                item.setTextAlignment(Qt.AlignmentFlag.AlignVCenter.value() | Qt.AlignmentFlag.AlignLeft.value());
	                ui.twPrestaciones.setItem(row,1,item);
	
	                item = new QTableWidgetItem();
	                item.setText(query.getString("prest_desc"));
	                item.setTextAlignment(Qt.AlignmentFlag.AlignVCenter.value() | Qt.AlignmentFlag.AlignLeft.value());
	                ui.twPrestaciones.setItem(row,2,item);
	
	                item = new QTableWidgetItem();
	                item.setText(query.getString("dps_cant"));
	                item.setTextAlignment(Qt.AlignmentFlag.AlignVCenter.value() | Qt.AlignmentFlag.AlignRight.value());
	                ui.twPrestaciones.setItem(row,3,item);
	                
	                item = new QTableWidgetItem();
	                item.setText(query.getString("fun_id"));
	                ui.twPrestaciones.setItem(row,4,item);
	
	                item = new QTableWidgetItem();
	                item.setText(query.getString("fun_apat")+" "+query.getString("fun_amat")+" "+query.getString("fun_nomb"));
	                item.setTextAlignment(Qt.AlignmentFlag.AlignVCenter.value() | Qt.AlignmentFlag.AlignLeft.value());
	                ui.twPrestaciones.setItem(row,5,item);
	
	                item = new QTableWidgetItem();
	                item.setText(query.getBoolean("dps_toma") ? "Sí" : "No");
	                item.setTextAlignment(Qt.AlignmentFlag.AlignVCenter.value() | Qt.AlignmentFlag.AlignCenter.value());
	                ui.twPrestaciones.setItem(row,6,item);
	
	                item = new QTableWidgetItem();
	                item.setText(query.getBoolean("dps_toma") ? query.getString("dps_fhto") : "00-00-0000 00:00");
	                item.setTextAlignment(Qt.AlignmentFlag.AlignVCenter.value() | Qt.AlignmentFlag.AlignLeft.value());
	                ui.twPrestaciones.setItem(row,7,item);
	
	                row++;
	            }
	            ui.twPrestaciones.resizeColumnsToContents();
	            query.close();
	            ui.lblStat.setText("Editando\nRecepción");
	            Utils.HabilitaAcciones(this, this._userName, objectName(),'E');
	            //ui.btnNuevo.setEnabled(CheckAccessButton(this._userName, objectName(), 'A'));
	            //ui.btnImprimir.setEnabled(CheckAccessButton(this._userName, objectName(), 'I'));
	            this._Action = Action.Edit;
	            return true;
	        }
	        return false;
    	}catch (SQLException e) {
    		e.printStackTrace();
    		DBUtils.showSQLException(e);
			return false;
		}
    }
    
    public void EnabledDButtons(boolean nuevo, boolean editar, boolean guardar, boolean eliminar, boolean cancelar){
        ui.btnDNuevo.setEnabled(nuevo  && !this._Action.equals(Action.None));
        ui.btnDEditar.setEnabled(editar && !this._Action.equals(Action.None));
        ui.btnDGuardar.setEnabled(guardar  && !this._Action.equals(Action.None));
        ui.btnDEliminar.setEnabled(eliminar  && !this._Action.equals(Action.None));
        ui.btnDCancelar.setEnabled(cancelar  && !this._Action.equals(Action.None));
    }
    
    public void ClearDetalle(){
    	ui.lePrest.setText("");
        ui.cmbPres.setCurrentIndex(-1);
        ui.sbCant.setValue(1);
        ui.cmbToma.setCurrentIndex(ui.cmbResp.currentIndex());
        ui.gbHecho.setChecked(false);
    }
    
    //Método creado para probar el funcionamiento del envío de mensaje HL7
    private void GenerarMensaje(){
    	MensajeHL7 msg = new MensajeHL7();
	    //MSH
	    msg.set_IdMensaje(ui.leID.text());
	    //PATIENCE
	    msg.set_PATAMat(ui.leAMat.text());
	    msg.set_PATAPat(ui.leAPat.text());
	    msg.set_PATCiud(ui.leCiud.text());
	    msg.set_PATCPost("5500");
	    msg.set_PATDire("Direccion del paciente");
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	    msg.set_PATFNac(sdf.format(new Date()));
	    msg.set_PATId(ui.leRUN.text());
	    msg.set_PATNomb(ui.lePaci.text());
	    msg.set_PATPais("Chile");
	    msg.set_PATProv("Llanquihue");
	    msg.set_PATSexo(ui.leSexo.text());
	    msg.set_PATRut(_pacRUN);
	    //ORC - Datos del Derivador
	    msg.set_AbreMed("DR");
	    msg.set_APatMed("PaternoDoc");
	    msg.set_ORCLCita(ui.cmbTRec.currentText());
	    msg.set_NumColMed("NumColMed");
	    msg.set_NombMed("NombreDoc");
	    msg.set_NumOrden(ui.leID.text());
	    //ORB - Datos del examen, en este caso no acepta repeticiones (mas de un examen)
	    //msg.set_DescExamen(ui.twPrestaciones.item(0, 2).text());
	    //msg.set_IdExamen(ui.twPrestaciones.item(0, 1).text());
	    msg.set_DescExamen("RX. TORAX AP/L");
	    msg.set_IdExamen("0401070");
	    msg.set_AbreMed("DR");
	    //msg.set_Modalidad(ui.comboBox.itemText(ui.comboBox.currentIndex()));
	    //msg.set_AETitle(ui.comboBox.itemData(ui.comboBox.currentIndex()).toString());
	    msg.set_Prioridad(ui.cmbNUrg.currentText());
	    msg.set_userName(_userName);
	    try{
	    	msg.Enviar();
	    }catch (Exception e) {
			e.printStackTrace();
		}
    }
    
}
