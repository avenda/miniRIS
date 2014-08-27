package com.eims.ris.gui;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.eims.ris.core.Citacion;
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
import com.eims.ris.core.Enumeradores.Message;
import com.eims.ris.gui.Ui_frmCitaciones;

import com.trolltech.qt.core.QDate;
import com.trolltech.qt.core.QDateTime;
import com.trolltech.qt.core.QTime;
import com.trolltech.qt.core.Qt;
import com.trolltech.qt.core.Qt.DayOfWeek;
import com.trolltech.qt.gui.QApplication;
import com.trolltech.qt.gui.QBrush;
import com.trolltech.qt.gui.QDialog;
import com.trolltech.qt.gui.QFont;
import com.trolltech.qt.gui.QMessageBox;
import com.trolltech.qt.gui.QMessageBox.StandardButton;
import com.trolltech.qt.gui.QPainter;
import com.trolltech.qt.gui.QPen;
import com.trolltech.qt.gui.QPrinter;
import com.trolltech.qt.gui.QTextCharFormat;
import com.trolltech.qt.gui.QWidget;
import com.trolltech.qt.gui.QColor;
import com.trolltech.qt.gui.QTableWidgetItem;

public class frmCitaciones extends QDialog {
    /**
	 * @uml.property  name="ui"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
    Ui_frmCitaciones ui = new Ui_frmCitaciones();
    /**
	 * @uml.property  name="_userName"
	 */
    private String _userName;
    /**
	 * @uml.property  name="_Action"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
    private Action _Action = Action.None;
    /**
	 * @uml.property  name="_DAction"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
    @SuppressWarnings("unused")
	private Action _DAction = Action.None;
    /**
     * Constructor del QDialog según nombre usuario
     * habilita o deshabilita: acciones u opciones
     * @param userName
     */
    public frmCitaciones(String userName) {
        this(userName, null);
    }
    /**
     * Constructor del QDialog según nombre usuario
     * habilita o deshabilita: acciones u opciones
     * @param userName
     * @param parent
     */
    public frmCitaciones(String userName, QWidget parent) {
        super(parent);
        ui.setupUi(this);
        _userName = userName;
        ui.cwFecha.setFirstDayOfWeek(DayOfWeek.Monday);
        CreateConnect();
        QApplication.restoreOverrideCursor();
    }
    public void on_leID_ReturnPressed(){
    	if(!ui.leID.text().isEmpty()){
    		if(LoadCitacion()){
	    		ColoredCalendar();
	            LoadHoras();
    		}else{
    			Utils.MessageBox(Message.Information, "Lo siento, no existe una citación para el ID proporcionado.\nIntente nuevamente.");
    			ui.leID.clear();
    		}
    	}
    }
    /**
     * 
     */
    public void on_btnAceptar_Clicked(){
    	if(ui.cmbResp.currentIndex()==-1)
            ui.cmbResp.showPopup();
        else if(ui.cmbRF.currentIndex()==-1)
            ui.cmbRF.showPopup();
        else{
            ui.btnSCAdd.setEnabled(true);
            ColoredCalendar();
            LoadHoras();
            clearForm();
            _Action = Action.New;
            _DAction = Action.None;
        }
    }
    /**
     * 
     */
    public void on_btnMPaci_Clicked()
    {
        frmPacientes pac = new frmPacientes(_userName, true);
        pac.setPacRun(ui.leRUN.text());
        pac.setPacFicha(ui.leFich.text());
        pac.on_btnFiltrar_Clicked();
        if(pac.exec()==1){
        	try{
	            ResultSet query = DBUtils.getResultSet(String.format("SELECT pac_run, pac_fich, pac_apat || ' ' || pac_amat || ' ' || pac_nomb, ssa_id FROM miniris.pacientes WHERE pac_id=%1$s", 1)); //pac.getPacienteID()));
	            if(query.next()){
	                ui.leRUN.setText(query.getString(1));
	                ui.leFich.setText(query.getString(2));
	                ui.lePaciente.setText(query.getString(3));
	                ui.cmbSSal.setCurrentIndex(ui.cmbSSal.findData(query.getInt(4)));
	            }
        	}catch (SQLException e) {
				DBUtils.showSQLException(e);
			}
        }
        QApplication.restoreOverrideCursor();
    }
    /**
     * 
     */
    public void on_btnMProc_Clicked(){
    	frmDerivadores fDer = new frmDerivadores(_userName);
    	fDer.exec();
    }
    /**
     * 
     */
    public void on_btnMSSal_Clicked(){
    	frmSistSalud fSS = new frmSistSalud(_userName);
    	fSS.exec();    	
    }
    /**
     * 
     */
    public void on_btnGuardar_Clicked()
    {
    	if(ui.cmbTDer.currentIndex()<-1){
    		Utils.MessageBox(Message.Information, "No ha ingresado ningun origen de derivación para la citacion.\nIntente nuevamente.");
            ui.cmbTDer.showPopup();
            return;
    	}
    	if(ui.cmbDeri.currentIndex()<-1){
    		Utils.MessageBox(Message.Information, "No ha ingresado Derivador para la citacion.\nIntente nuevamente.");
            ui.cmbDeri.showPopup();
            return;
    	}
    	if(ui.cmbSSal.currentIndex()<-1){
    		Utils.MessageBox(Message.Information, "No ha ingresado ningun Sistema de Salud para la citacion.\nIntente nuevamente.");
            ui.cmbSSal.showPopup();
            return;
    	}
    	if(ui.leRUN.text().isEmpty()){
    		Utils.MessageBox(Message.Information, "No ha ingresado ningun paciente para la citacion.\nIntente nuevamente.");
            ui.leRUN.setFocus();
            return;
    	}
        if(ui.twPrestaciones.rowCount()<1){
        	Utils.MessageBox(Message.Information, "No ha ingresado ninguna prestación para la citacion.\nIntente nuevamente.");
            ui.btnDNuevo.setFocus();
            return;
        }
        Connection cnn = DBUtils.getConnection();
        try{
        	cnn.setAutoCommit(false);
        	boolean result = false;
        	Citacion citacion = new Citacion();
        	citacion.setId(Long.parseLong(ui.twHoras.item(ui.twHoras.currentRow(),5).text()));
        	Funcionario responsable = new Funcionario();
		    responsable.setFuncionario(Integer.parseInt(ui.cmbResp.itemData(ui.cmbResp.currentIndex()).toString()));
        	citacion.setProfesional(responsable);
        	RRFFs rf = new RRFFs();
		    rf.setRF(Integer.parseInt(ui.cmbRF.itemData(ui.cmbRF.currentIndex()).toString()));
		    citacion.setRRFF(rf);
		    
        	Recepcion recepcion = new Recepcion();
		    recepcion.setTipo(2);
		    recepcion.setFechaHora(QDateTime.fromString("0000-00-00 00:00:00.0"));
		    Paciente paciente = new Paciente();
		    int pacID = Integer.parseInt(DBUtils.getTableField(String.format("SELECT pac_id FROM miniris.pacientes WHERE pac_run='%1$s';", ui.leRUN.text().trim())).toString());
		    paciente.setPaciente(pacID);
		    recepcion.setPaciente(paciente);
		    Derivador derivador = new Derivador();
		    derivador.setDerivador(Integer.parseInt(ui.cmbDeri.itemData(ui.cmbDeri.currentIndex()).toString()));
		    recepcion.setDerivador(derivador);
		    SistSalud sistSalud = new SistSalud();
		    sistSalud.setSistemaSalud(Integer.parseInt(ui.cmbSSal.itemData(ui.cmbSSal.currentIndex()).toString()));
		    recepcion.setSistemaSalud(sistSalud);
		    recepcion.setNivelUrgencia(2);
		    
		    recepcion.setRRFF(rf);
		    recepcion.setResponsable(responsable);
		    
		    //recepcion.setIDCitacion(Long.parseLong(DBUtils.getTableField(String.format("SELECT cita_id FROM miniris.citaciones WHERE eps_id=%1$s", ui.leID.text()))));
		    recepcion.setObservacion("CITADO POR SISTEMA");
		    recepcion.setUsuario(this._userName);
		    recepcion.setEstadoRecepcion(1);
		    recepcion.setParaInformar(0);
		    recepcion.setInfoAdicional(0);
		    recepcion.setAsiste(false);
		    
		    RecepcionPrestaciones rp = new RecepcionPrestaciones();
		    Prestacion prestacion = null;
		    for(int i=0; i<ui.twPrestaciones.rowCount(); i++){
		    	prestacion = new Prestacion();
		    	prestacion.setPrestacion(ui.twPrestaciones.item(i,1).text());
			    rp.setPrestacion(prestacion);
			    rp.setCantidad(Integer.parseInt(ui.twPrestaciones.item(i,3).text()));
			    rp.setResponsable(responsable);
			    rp.setTomado(false);
			    rp.setFHToma(QDateTime.fromString("0000-00-00 00:00:00.0"));
			    rp.setEstado(ui.twPrestaciones.item(i, 0).text());
			    recepcion.setRecepcionPrestaciones(rp);
		    }
		    citacion.setCitacion(recepcion);
		    citacion.setObservacion("Reservada");
		    citacion.setUsuario(_userName);
		    if(this._Action == Action.New){
		    	recepcion.setFHDigitacion(QDateTime.fromString(Utils.ObtenerFechaHora()));
		    	result = citacion.Insertar();
		    }else{
		    	recepcion.setId(Long.parseLong(ui.leID.text().trim()));
		    	result = citacion.Modificar();
		    }
		    if(result){	    		        
		        EnabledDButtons(true,false,false,false,false);
		        Utils.HabilitaAcciones(this, _userName, objectName().substring(3),'E');
		        _Action = Action.Edit;
		        cnn.commit();
		        Utils.MessageBox(Message.Information, "¡El registro se ha guardado satisfactoriamente!");
		    }else{
		    	cnn.rollback();
		    	Utils.MessageBox(Message.Error, "¡Se ha producido un error al guardar el registro!");
		    }
		    cnn.setAutoCommit(true);
		    QBrush brush = new QBrush(new QColor(208, 0, 50, 50));
		    int curRow = ui.twHoras.currentRow();
		    ui.twHoras.item(curRow,0).setBackground(brush);
            ui.twHoras.item(curRow,0).setText("R");
            ui.twHoras.item(curRow,1).setBackground(brush);
            ui.twHoras.item(curRow,2).setBackground(brush);
            ui.twHoras.item(curRow,2).setText("Reservada");
            ui.twHoras.item(curRow,3).setBackground(brush);
            ui.twHoras.item(curRow,3).setText(String.valueOf(citacion.getCitacion().getId()));
            EnabledDButtons(true,false,false,false,false);
            ui.btnImprimir.setEnabled(true);
            //clearForm();
        }catch (SQLException e) {
			try{
				cnn.rollback();
			}catch (SQLException ex) {
				ex.printStackTrace();
			}
			DBUtils.showSQLException(e);
		}
    }
    /**
     * 
     */
    public void on_btnEliminar_Clicked()
    {
    	if(Utils.MessageBox(Message.Question, "¿Está seguro que desea devolver la hora de citación?") == StandardButton.Yes.value()){
    		Connection cnn = DBUtils.connectDB();
    		try{
	    		cnn.setAutoCommit(false);
	    		String sql = String.format("DELETE FROM miniris.prestsol_enc WHERE eps_id=%1$s", ui.twHoras.item(ui.twHoras.currentRow(),3).text());
	    		DBUtils.executeNonQuery(sql);
	    		sql = String.format("UPDATE miniris.citaciones SET eps_id=0, cita_esta='D', cita_obse='Disponible' WHERE cita_id=%1$s", ui.twHoras.item(ui.twHoras.currentRow(),5).text());
	    		DBUtils.executeNonQuery(sql);
				ui.btnEliminar.setEnabled(false);
				LoadHoras();
				clearForm();
    		}catch(SQLException e){
    			try{
    				cnn.rollback();
    			}catch (SQLException ex) {
    				e.printStackTrace();
				}
    			DBUtils.showSQLException(e);
			}
    	}
    }
    /**
     * 
     */
    public void on_btnImprimir_Clicked()
    {
        QPrinter printer = new QPrinter(QPrinter.PrinterMode.HighResolution);

        printer.setOutputFormat(QPrinter.OutputFormat.PdfFormat);
        printer.setOutputFileName("/home/pablo/temp/citacion.pdf");
        printer.setPageSize(QPrinter.PageSize.A6);
        //printer.setFullPage(true);
        printer.setPageMargins(2,2,2,2,QPrinter.Unit.Millimeter);
        QPainter painter = new QPainter();
        if(!painter.begin(printer)){
            QMessageBox.critical(this, "Escritura de archivo", "Error al abrir el archivo PDF para escritura.");
            return;
        }
        QPen pen = new QPen();
        pen.setWidth(1);
        pen.setColor(QColor.black);
        painter.setPen(pen);

        QFont fnt = new QFont("Tahoma",10);
        painter.setFont(fnt);
        painter.drawText( 20, 100, "COMPROBANTE DE CITACION NUMERO: ");
        //painter.drawText( 20, 250, "Imp.:"+Utils.ObtenerFechaHora().toDateTime().toString("dd-MM-yyyy HH:mm ")+DBUtils.getTableField(String.format("SELECT eps_user FROM minitis.prestsol_enc WHERE eps_id=%1$s", ui.leID.text())).toString());
        painter.drawText( 20, 250, "Imp.:"+Utils.ObtenerFechaHora()+" "+DBUtils.getTableField(String.format("SELECT eps_user FROM miniris.prestsol_enc WHERE eps_id=%1$s", ui.leID.text())).toString());
        painter.drawText( 20, 400, "Ambulatorio");
        painter.drawText( 20, 550, "Citación");
        painter.drawText( 20, 700, ui.cmbSSal.currentText());
        painter.drawText( 20, 850, "DERIVADO DE: "+ui.cmbTDer.currentText()+". "+ui.cmbDeri.currentText());

        fnt.setFamily("C39HrP48DhTt");
        fnt.setPointSize(42);
        painter.setFont(fnt);
        painter.drawText(3400, 550, "*"+ui.leID.text()+"*");

        fnt.setFamily("Tahoma");
        fnt.setPointSize(10);
        painter.setFont(fnt);

        painter.drawLine( 0, 950, 4700,950);
        painter.drawText(20,1150, ui.leRUN.text().isEmpty()?ui.leFich.text():ui.leRUN.text()+" "+ui.lePaciente.text());
        //painter.drawText(20,1300, "Edad: "+ui.lblEdad.text()+" Sexo: "+ui.lblSexo.text()+" Prioridad: "+ui.cmbNUrg.currentText()+" "+ui.lblFHCit.text());
        painter.drawLine( 0,1400, 4700,1400);

        fnt.setPointSize(8);
        painter.setFont(fnt);
        int lY = 1400;
        for(int row=0;row<ui.twPrestaciones.rowCount();row++)
            painter.drawText(20,lY+=150, ui.twPrestaciones.item(row,1).text()+" x "+ui.twPrestaciones.item(row,3).text()+" "+ui.twPrestaciones.item(row,2).text());

        lY += 100;
        painter.drawLine( 0,lY,4700,lY);
        fnt.setPointSize(13);
        painter.setFont(fnt);
        lY += 200;
        painter.drawText(20,lY,"CITADO EL: "+ui.cwFecha.selectedDate().toString("dd-MM-yyyy")+"  A LAS: "+ui.twHoras.item(ui.twHoras.currentRow(),1).text()+" HRS.");

        painter.end();
        Utils.ShowPDF(printer.outputFileName());
    	//Citacion.Printer(ui.twHoras);
    }
    /**
     * 
     */
    public void on_btnLimpiar_Clicked()
    {
    	ui.cmbResp.setCurrentIndex(-1);
        ui.cmbRF.setCurrentIndex(-1);
    	clearForm();
        ui.twHoras.setRowCount(0);
        ColoredCalendar();
        _Action = Action.New;
        _DAction = Action.None;
    }

    public void on_btnSCAdd_Clicked()
    {
        ui.teSCHora.setTime(QTime.currentTime()); //ObtenerFechaHora().toTime());
        ui.frmSC.setVisible(true);
    }

    public void on_btnSCRemove_Clicked()
    {
    	
    }

    public void on_btnSCAceptar_Clicked()
    {
    	try{
	        PreparedStatement stm = DBUtils.connectDB().prepareStatement("INSERT INTO miniris.citaciones (cita_feho,fun_id,rf_id,cita_esta,cita_stor,cita_obse,cita_fhdi,cita_user) VALUES(?,?,?,?,?,?,?,?)");
	        String citacion = ui.cwFecha.selectedDate().toString("yyyy-MM-dd ")+ui.teSCHora.time().toString("HH:mm:ss");
	        stm.setTimestamp(1, Timestamp.valueOf(citacion));
	        stm.setInt(2, Integer.parseInt(ui.cmbResp.itemData(ui.cmbResp.currentIndex()).toString()));
	        stm.setInt(3, Integer.parseInt(ui.cmbRF.itemData(ui.cmbRF.currentIndex()).toString()));
	        stm.setString(4, "S");
	        stm.setString(5, "S");
	        stm.setString(6, DBUtils.getTableField(String.format("SELECT par_desc FROM miniris.parametros WHERE par_grupo='TC' AND par_id=3")));
	        stm.setTimestamp(7, Timestamp.valueOf(Utils.ObtenerFechaHora()));
	        stm.setString(8, _userName);
	        stm.execute();
	        ui.frmSC.setVisible(false);
	        LoadHoras();
    	}catch (SQLException e) {
			DBUtils.showSQLException(e);
		}
    }

    public void on_btnSCCancelar_Clicked()
    {
        ui.frmSC.setVisible(false);
    }
    
    public void on_btnLock_Clicked()
    {
    	String sql = String.format("UPDATE miniris.citaciones SET cita_esta='B', cita_obse='Bloqueada' WHERE cita_id=%1$s", ui.twHoras.item(ui.twHoras.currentRow(),5).text());
    	if(DBUtils.executeNonQuery(sql))
    		ColoredCalendar();
    	else
    		Utils.MessageBox(Message.Error, "Ha sido imposible bloquear la hora.\nIntente nuevamente.");
    }
    
    public void on_btnDNuevo_Clicked()
    {
        ui.lePrest.setEnabled(true);
        ui.label_19.setEnabled(true);
        ui.sbCant.setEnabled(true);
        ui.lePrest.clear();
        ui.sbCant.setValue(1);
        ui.sbCant.selectAll();
        ui.sbCant.setFocus();
        ui.lePrest.setReadOnly(false);
        EnabledDButtons(false,false,true,false,true);
        _DAction = Action.New;
    }

    public void on_btnDEditar_Clicked()
    {
        ui.lePrest.setReadOnly(false);
        ui.lePrest.setText(ui.twPrestaciones.item(ui.twPrestaciones.currentRow(),1).text());
        ui.sbCant.setValue(Integer.parseInt(ui.twPrestaciones.item(ui.twPrestaciones.currentRow(),3).text()));
        ui.sbCant.selectAll();
        ui.sbCant.setFocus();
        EnabledDButtons(false,false,true,false,true);
        _DAction = Action.Edit;
    }

    public void on_btnDGuardar_Clicked()
    {
    	String res = DBUtils.getTableField(String.format("SELECT prest_desc FROM miniris.prestaciones WHERE prest_id='%1$s'",ui.lePrest.text()).toUpperCase());
    	if(res.equals("")){
        	QMessageBox.information(this,"Prestación","No ha ingresado un código válido.\nIntente nuevamente.");
        	ui.lePrest.setFocus();
        }else{
        	int row = 0;
        	if(_Action == Action.New){
                row = ui.twPrestaciones.rowCount();
                ui.twPrestaciones.insertRow(row);
                ui.twPrestaciones.setRowHeight(row,20);
            }else{
	        	row = ui.twPrestaciones.currentRow();
            }
	        QTableWidgetItem item;
	
	        item = new QTableWidgetItem();
	        item.setText(_Action == Action.New ? "I" : ui.twPrestaciones.item(row,0).text()!="I"?"M":"I");
	        item.setTextAlignment(5);
	        ui.twPrestaciones.setItem(row,0,item);
	
	        item = new QTableWidgetItem();
	        item.setText(ui.lePrest.text());
	        ui.twPrestaciones.setItem(row,1,item);
	
	        item = new QTableWidgetItem();
	        item.setText(res);
	        ui.twPrestaciones.setItem(row,2,item);
	
	        item = new QTableWidgetItem();
	        item.setText(ui.sbCant.text());
	        item.setTextAlignment(2);
	        ui.twPrestaciones.setItem(row,3,item);
	
	        ui.twPrestaciones.resizeColumnsToContents();
	        EnabledDButtons(true,false,false,false,false);
	        ui.lePrest.clear();
	        ui.sbCant.setValue(1);
	        
	        _DAction = Action.None;
	        ui.btnDNuevo.setFocus();
        }
    }

    public void on_btnDEliminar_Clicked()
    {
        if(ui.twPrestaciones.item(ui.twPrestaciones.currentRow(),0).text().equals("") ||
           ui.twPrestaciones.item(ui.twPrestaciones.currentRow(),0).text().equals("M"))
            ui.twPrestaciones.item(ui.twPrestaciones.currentRow(),0).setText("E");
        else
            ui.twPrestaciones.removeRow(ui.twPrestaciones.currentRow());
        if(ui.twPrestaciones.rowCount()==0){ 
        	EnabledDButtons(true,false,false,false,false);
        	
        }
    }

    public void on_btnDCancelar_Clicked()
    {
        ui.lePrest.clear();
        ui.sbCant.setValue(1);
        EnabledDButtons(true,false,false,false,false);
    }
    
    public void on_twPrestaciones_CellClicked(int row, int col)
    {
        EnabledDButtons(true,true,false,true,false);
    }
    public void on_lePrest_ReturnPressed(){
    	if(ui.lePrest.text().isEmpty()){
    		Utils.MessageBox(Message.Information, "No ha ingresado ningun código.\nIntente nuevamente.");
        	ui.lePrest.setFocus();
    	}else{
    		this.on_btnDGuardar_Clicked();
    	}
    }
    
    public void on_twHoras_CellClicked(int row, int col)
    {
        if(("DS").contains(ui.twHoras.item(row,0).text())){
            ui.btnSCRemove.setEnabled(ui.twHoras.item(row,0).text().equals("S") && ui.twHoras.item(row,6).text().equals("S"));
            ui.btnGuardar.setEnabled(true);
            ui.btnEliminar.setEnabled(false);
            ui.btnImprimir.setEnabled(false);
            ui.btnLock.setEnabled(true);
        }else{
            ui.btnGuardar.setEnabled(false);
            //ui.btnEliminar.setEnabled(true);
            //ui.btnImprimir.setEnabled(true);
            ui.btnLock.setEnabled(false);
        }
    }

    public void on_twHoras_CellDoubleClicked(int row, int col)
    {
        if(ui.twHoras.item(row,0).text().equals("R")){
            ui.btnGuardar.setEnabled(false);
            ui.btnEliminar.setEnabled(true);
            ui.btnImprimir.setEnabled(true);
        }
        ui.leID.setText(ui.twHoras.item(row,3).text());
        if(!ui.leID.text().isEmpty()) LoadCitacion();
    }
    public void on_cmbTDer_CurrentIndexChanged(int idx)
    {
    	if(!(ui.cmbTDer.currentIndex()==-1)){
    		String sql = String.format("SELECT deri_id,deri_desc FROM miniris.derivadores WHERE deri_tipo='%1$s' AND deri_vige='1' ORDER BY deri_desc", ui.cmbTDer.itemData(idx).toString());
    		DBUtils.loadComboBox(ui.cmbDeri, sql);
    	}
    }
    public void on_cmbDeri_CurrentIndexChanged(){
    	ui.btnDNuevo.setFocus();
    }
    public void on_cwFecha_SelectionChanged()
    {
    	LoadHoras();
    }
    public void on_sbCant_valueChanged(){
    	ui.lePrest.setFocus();
    }
    
    public void on_cwFecha_CurrentPageChanged(int year, int month){
    	if(ui.cmbResp.currentIndex()>-1 && ui.cmbRF.currentIndex()>-1)
    		ColoredCalendar();
    }
    
    private void CreateConnect(){
    	ui.frmSC.setVisible(false);
    	ui.twHoras.setColumnHidden(4,true);
        ui.twHoras.setColumnHidden(5,true);
        ui.twHoras.setColumnHidden(6,true);
        ui.twHoras.resizeColumnsToContents();
        
        //LoadHoras();
    	LoadCombos();
    	
    	ui.leID.returnPressed.connect(this, "on_leID_ReturnPressed()");
    	
    	ui.btnAceptar.clicked.connect(this, "on_btnAceptar_Clicked()");
    	ui.btnMPaci.clicked.connect(this, "on_btnMPaci_Clicked()");
    	
    	ui.twPrestaciones.cellClicked.connect(this, "on_twPrestaciones_CellClicked(int, int)");
    	
    	ui.twHoras.cellClicked.connect(this, "on_twHoras_CellClicked(int, int)");
    	ui.twHoras.cellDoubleClicked.connect(this, "on_twHoras_CellDoubleClicked(int, int)");
    	
    	ui.btnDNuevo.clicked.connect(this, "on_btnDNuevo_Clicked()");
        ui.btnDEditar.clicked.connect(this, "on_btnDEditar_Clicked()");
        ui.btnDGuardar.clicked.connect(this, "on_btnDGuardar_Clicked()");
        ui.btnDEliminar.clicked.connect(this, "on_btnDEliminar_Clicked()");
        ui.btnDCancelar.clicked.connect(this, "on_btnDCancelar_Clicked()");
        
        ui.btnGuardar.clicked.connect(this, "on_btnGuardar_Clicked()");
        ui.btnEliminar.clicked.connect(this, "on_btnEliminar_Clicked()");
        ui.btnImprimir.clicked.connect(this, "on_btnImprimir_Clicked()");
        ui.btnLimpiar.clicked.connect(this, "on_btnLimpiar_Clicked()");
    	
    	ui.leRUN.returnPressed.connect(this, "SearchPatient()");
    	ui.leFich.returnPressed.connect(this, "SearchPatient()");
    	ui.lePrest.returnPressed.connect(this, "on_lePrest_ReturnPressed()");
    	
    	ui.cmbTDer.currentIndexChanged.connect(this, "on_cmbTDer_CurrentIndexChanged(int)");
    	ui.cmbDeri.currentIndexChanged.connect(this, "on_cmbDeri_CurrentIndexChanged()");
    	
    	ui.cwFecha.selectionChanged.connect(this, "on_cwFecha_SelectionChanged()");
    	
    	ui.btnMProc.clicked.connect(this, "on_btnMProc_Clicked()");
    	ui.btnMSSal.clicked.connect(this, "on_btnMSSal_Clicked()");
    	
    	ui.btnSCAdd.clicked.connect(this, "on_btnSCAdd_Clicked()");
    	ui.btnSCRemove.clicked.connect(this, "on_btnSCRemove_Clicked()");
    	ui.btnSCAceptar.clicked.connect(this, "on_btnSCAceptar_Clicked()");
    	ui.btnSCCancelar.clicked.connect(this, "on_btnSCCancelar_Clicked()");
    	ui.btnLock.clicked.connect(this, "on_btnLock_Clicked()");
    	
    	ui.sbCant.valueChanged.connect(this, "on_sbCant_valueChanged()");
    	
    	ui.cwFecha.currentPageChanged.connect(this, "on_cwFecha_CurrentPageChanged(int, int)");
    	
    	Utils.HabilitaOpciones(this, _userName);
    	ui.twPrestaciones.resizeColumnsToContents();
    }
    
    private void LoadHoras(){
    	if(ui.cmbResp.currentIndex() < 0 || ui.cmbRF.currentIndex() < 0) return;
        ResultSet query;
        ui.twHoras.setRowCount(0);
        int row = 0;
        String sql;
        String filtro = "";
        if(ui.ckbDisp.isChecked()){
            filtro = String.format("cita_feho>='%1$s' AND cita_esta='D'", ui.deFDesde.date().toString("yyyy-MM-dd"));
        }else
			filtro = String.format("cita_feho BETWEEN '%1$s' AND '%2$s'", ui.cwFecha.selectedDate().toString("yyyy-MM-dd 00:00:00"), ui.cwFecha.selectedDate().toString("yyyy-MM-dd 23:59:59"));
		
        sql = String.format("SELECT cita_esta,cita_feho,cita_obse,eps_id,cita_id,cita_stor FROM miniris.citaciones WHERE fun_id=%1$s AND rf_id=%2$s AND %3$s ORDER BY cita_feho ASC", ui.cmbResp.itemData(ui.cmbResp.currentIndex()).toString(), ui.cmbRF.itemData(ui.cmbRF.currentIndex()).toString(), filtro);
		query = DBUtils.getResultSet(sql);
		
		QColor color = new QColor();
		QTableWidgetItem item;
        try{
	        while(query.next()){  
	            ui.twHoras.insertRow(row);
	            ui.twHoras.setRowHeight(row,20);
	
	            if(query.getString("cita_esta").equals("D"))
	                color = new QColor(146,198,238,50);
	            else if(query.getString("cita_esta").equals("R"))
	                color = new QColor(208,  0, 50,50);
	
	            item = new QTableWidgetItem();
	            item.setBackground(new QBrush(color));
	            item.setText(query.getString("cita_esta"));
	            item.setTextAlignment(Qt.AlignmentFlag.AlignVCenter.value() | Qt.AlignmentFlag.AlignHCenter.value());
	            ui.twHoras.setItem(row,0,item);
	
	            item = new QTableWidgetItem();
	            item.setBackground(new QBrush(color));
	            item.setText(query.getTime("cita_feho").toString().substring(0,5));
	            item.setTextAlignment(Qt.AlignmentFlag.AlignVCenter.value()| Qt.AlignmentFlag.AlignHCenter.value());
	            ui.twHoras.setItem(row,1,item);
	
	            item = new QTableWidgetItem();
	            item.setBackground(new QBrush(color));
	            item.setText(query.getString("cita_obse"));
	            item.setTextAlignment(Qt.AlignmentFlag.AlignVCenter.value());
	            ui.twHoras.setItem(row,2,item);
	
	            item = new QTableWidgetItem();
	            item.setBackground(new QBrush(color));
	            item.setText(query.getInt("eps_id")==0 ? "" : query.getString("eps_id"));
	            //item.setText(query.getInt("eps_id")==0 ? "" : String.format("%010d", query.getString("eps_id")));
	            item.setTextAlignment(Qt.AlignmentFlag.AlignVCenter.value() | Qt.AlignmentFlag.AlignRight.value());
	            ui.twHoras.setItem(row,3,item);
	
	            item = new QTableWidgetItem();
	            item.setBackground(new QBrush(color));
	            item.setText(query.getDate("cita_feho").toString().substring(0,10));
	            item.setTextAlignment(Qt.AlignmentFlag.AlignVCenter.value());
	            ui.twHoras.setItem(row,4,item);
	
	            item = new QTableWidgetItem();
	            item.setText(query.getString("cita_id"));
	            item.setTextAlignment(Qt.AlignmentFlag.AlignVCenter.value() | Qt.AlignmentFlag.AlignRight.value());
	            ui.twHoras.setItem(row,5,item);
	
	            item = new QTableWidgetItem();
	            item.setText(query.getString("cita_stor"));
	            item.setTextAlignment(Qt.AlignmentFlag.AlignVCenter.value() | Qt.AlignmentFlag.AlignHCenter.value());
	            ui.twHoras.setItem(row,6,item);
	
	            row++;
	        }
        }catch (SQLException e) {
			DBUtils.showSQLException(e);
		}
        ui.twHoras.resizeColumnsToContents();
        if(row==0){
            //ui.cwFecha.
        }else
            ui.twHoras.item(0,0).setSelected(true);
    }
    private void clearForm(){
    	ui.cmbDeri.setCurrentIndex(-1);
    	ui.cmbTDer.setCurrentIndex(-1);
    	ui.cmbSSal.setCurrentIndex(-1);
    	ui.leRUN.clear();
    	ui.leFich.clear();
    	ui.lePaciente.clear();
    	ui.lePrest.clear();
    	ui.sbCant.clear();
    	ui.twPrestaciones.setRowCount(0);
    	ui.twPrestaciones.resizeColumnsToContents();
    }
    private void LoadCombos(){
        String sql = String.format("SELECT fun_id,fun_apat || ' ' || fun_amat || ' ' || fun_nomb FROM miniris.funcionarios WHERE fun_vige=TRUE AND prf_id<3 ORDER BY fun_apat,fun_amat,fun_nomb");
        DBUtils.loadComboBox(ui.cmbResp, sql);
        sql = String.format("SELECT rf_id,rf_desc FROM miniris.rrffs WHERE rf_vige=TRUE ORDER BY rf_desc");
        DBUtils.loadComboBox(ui.cmbRF, sql);
        sql = String.format("SELECT par_id,par_info FROM miniris.parametros WHERE par_grupo='TD' AND par_vige='1' ORDER BY par_id");
    	DBUtils.loadComboBox(ui.cmbTDer, sql);
        sql = String.format("SELECT ssa_id,ssa_desc FROM miniris.sist_salud WHERE ssa_vige=TRUE ORDER BY ssa_desc");
        DBUtils.loadComboBox(ui.cmbSSal, sql);	            
    }
    /**
     * Método que colorea las fechas del calendario
     * según el horario especificado en la calendarización de la Agenda
     */
    private void ColoredCalendar()
    {
        ResultSet query1, query2;
        QTextCharFormat format = new QTextCharFormat();
        Date actualDate, recordDate;
        actualDate = Date.valueOf(Utils.ObtenerFechaHora().substring(0,10));
        format.setBackground(new QBrush(QColor.white));
        QDate fecha = ui.cwFecha.selectedDate();
        fecha = fecha.addDays(-fecha.day()+1);
        //ui.cwFecha.clearMask();
        //ui.cwFecha.repaint();
        /*for(int d=1;d<=fecha.daysInMonth();d++){
            ui.cwFecha.setDateTextFormat(fecha, format);
            fecha = fecha.addDays(1);
        }*/
        //String filtro = "";
        int viewYear = ui.cwFecha.yearShown();
        int viewMonth = ui.cwFecha.monthShown();
        String sql = String.format("SELECT TO_CHAR(cita_feho,'yyyy-MM-dd') FROM miniris.citaciones WHERE fun_id=%1$s AND rf_id=%2$s AND EXTRACT(YEAR FROM cita_feho)=%3$s AND EXTRACT(MONTH FROM cita_feho)=%4$s GROUP BY TO_CHAR(cita_feho,'yyyy-MM-dd') ORDER BY TO_CHAR(cita_feho,'yyyy-MM-dd') ASC", ui.cmbResp.itemData(ui.cmbResp.currentIndex()).toString(), ui.cmbRF.itemData(ui.cmbRF.currentIndex()).toString(), viewYear, viewMonth);
        //System.out.println(sql);
        query1 = DBUtils.getResultSet(sql);
        try{
	        while(query1.next()){
	        	//sql = String.format("SELECT cita_esta, DATE(cita_feho) FROM miniris.citaciones WHERE fun_id=%1$s AND rf_id=%2$s AND DATE(cita_feho)='%3$s' GROUP BY cita_esta,DATE(cita_feho)", ui.cmbResp.itemData(ui.cmbResp.currentIndex()).toString(), ui.cmbRF.itemData(ui.cmbRF.currentIndex()).toString(), query1.getDate(1));
	        	sql = String.format("SELECT cita_esta, DATE(cita_feho) FROM miniris.citaciones WHERE fun_id=%1$s AND rf_id=%2$s AND DATE(cita_feho)='%3$s' GROUP BY cita_esta,DATE(cita_feho)", ui.cmbResp.itemData(ui.cmbResp.currentIndex()).toString(), ui.cmbRF.itemData(ui.cmbRF.currentIndex()).toString(), query1.getDate(1));
	        	//System.out.println(sql);
	            query2 = DBUtils.getResultSet(sql);
	            if(query2.next()){
	            	//String esta = query2.getString(1);
	            	//String feho = query2.getString(2);
	                if(DBUtils.getNumRows(query2)>1){
	                    format.setBackground(new QBrush(QColor.blue));
	                }else{
	                    if(query2.getString(1).equals("D"))
	                        format.setBackground(new QBrush(QColor.blue));
	                    else if(query2.getString(1).equals("R"))
	                        format.setBackground(new QBrush(QColor.red)); //QColor(255, 0, 0));
	                }
	                recordDate = query2.getDate(2);
	                if(recordDate.compareTo(actualDate) < 1)
	                    format.setBackground(new QBrush(QColor.red)); //QColor(255, 0, 0));
	            }else{
	                format.setBackground(new QBrush(QColor.red)); //QColor(255, 0, 0));
	            }
	            ui.cwFecha.setDateTextFormat(QDate.fromString(query2.getDate(2).toString(), "yyyy-MM-dd"), format);
	        }
        }catch (SQLException e) {
			e.printStackTrace();
		}
    }
    /**
     * Realiza la búsqueda de paciente: validad y llena los controles
     * con los datos establecidos en el RUN
     */
    @SuppressWarnings("unused")
	private void SearchPatient(){
    	ResultSet query;
        String filtro = "";
        if(focusWidget()==ui.leRUN && !ui.leRUN.text().isEmpty()){
            if(!Utils.ValidarRUN(ui.leRUN.text())){
                QMessageBox.information(this,"RUN Inválido","El RUN ingresado no es válido.\nIntente nuevamente.");
                return;
            }
            filtro = String.format("pac_run='%1$s'", ui.leRUN.text().toUpperCase());
        }else if(focusWidget()==ui.leFich && !ui.leFich.text().isEmpty()){
            filtro = String.format("pac_fich=%1$s", ui.leFich.text());
        }else{
        	if(ui.leRUN.text().isEmpty() || ui.leFich.text().isEmpty()){
        		QMessageBox.information(this, "Búsqueda de paciente", "Debe proporcionar un RUN válido ó N° de ficha para realizar una búsqueda.\nIntente nuevamente");
        		return;
        	}
        }
        try{
	        query = DBUtils.getResultSet(String.format("SELECT pac_id, pac_run, pac_fich, pac_apat || ' ' || pac_amat || ' ' || pac_nomb, ssa_id FROM miniris.pacientes WHERE %1$s", filtro));
	        if(query.next()){
	            ui.leRUN.setText(query.getString(2));
	            ui.leFich.setText(query.getString(3));
	            ui.lePaciente.setText(query.getString(4));
	            ui.cmbSSal.setCurrentIndex(ui.cmbSSal.findData(query.getInt(5)));
	            ui.cmbTDer.showPopup();
	        }else{
	        	QMessageBox.information(this, "Búsqueda de paciente", "RUN de Paciente no se encuentra en los registros.\nIntente nuevamente");
	        }
        }catch (SQLException e) {
			DBUtils.showSQLException(e);
		}
    }
    /**
     * Realiza la carga de los controles para una cita determinada 
     */
    private boolean LoadCitacion()
    {
    	boolean result = false;
        ResultSet query = null;
        try{
        	String sql = String.format("SELECT eps_id,eps_trec,eps_fhre,pac_id,eps_dau,eps_ccte,deri_id,ssa_id,eps_nurg,rf_id,eps_ures,eps_cita,eps_obse,eps_fhdi,eps_user,eps_erec,eps_pinf FROM miniris.prestsol_enc WHERE eps_id=%1$s", ui.leID.text());
        	//System.out.println(sql);
	        query = DBUtils.getResultSet(sql);
	        if(query.next()){
	        	result = true;
	            int TDeri = Integer.parseInt(DBUtils.getTableField(String.format("SELECT deri_tipo FROM miniris.derivadores WHERE deri_id=%1$s",query.getInt("deri_id"))));
	            ui.cmbResp.setCurrentIndex(ui.cmbResp.findData(query.getInt("eps_ures")));
	            ui.cmbRF.setCurrentIndex(ui.cmbRF.findData(query.getInt("rf_id")));
	            
	            ui.cmbTDer.setCurrentIndex(ui.cmbTDer.findData(TDeri));
	            ui.cmbDeri.setCurrentIndex(ui.cmbDeri.findData(query.getInt("deri_id")));
	            ui.cmbSSal.setCurrentIndex(ui.cmbSSal.findData(query.getInt("ssa_id")));
	            
	            try{
		            query = DBUtils.getResultSet(String.format("SELECT pac_run,pac_fich, pac_apat || ' ' || pac_amat || ' ' || pac_nomb FROM miniris.pacientes WHERE pac_id=%1$s", query.getInt("pac_id")));
	            }catch(SQLException e){
	            	DBUtils.showSQLException(e);
	            }
	            if(query.next()){
	                ui.leRUN.setText(query.getString(1));
	                ui.leFich.setText(query.getString(2));
	                ui.lePaciente.setText(query.getString(3));
	            }
	            int row = 0;
	            ui.twPrestaciones.setRowCount(0);
	            query = DBUtils.getResultSet(String.format("SELECT pd.prest_id,p.prest_desc,dps_cant FROM miniris.prestsol_det pd INNER JOIN miniris.prestaciones p ON pd.prest_id=p.prest_id INNER JOIN miniris.funcionarios f ON pd.fun_id=f.fun_id WHERE eps_id=%1$s", ui.leID.text()));
	            while(query.next()){
	                QTableWidgetItem item;
	                ui.twPrestaciones.insertRow(row);
	                ui.twPrestaciones.setRowHeight(row,20);
	
	                item = new QTableWidgetItem();
	                item.setText("");
	                item.setTextAlignment(Qt.AlignmentFlag.AlignVCenter.value() | Qt.AlignmentFlag.AlignHCenter.value());
	                ui.twPrestaciones.setItem(row,0,item);
	
	                item = new QTableWidgetItem();
	                item.setText(query.getString("prest_id"));
	                item.setTextAlignment(Qt.AlignmentFlag.AlignVCenter.value());
	                ui.twPrestaciones.setItem(row,1,item);
	
	                item = new QTableWidgetItem();
	                item.setText(query.getString("prest_desc"));
	                item.setTextAlignment(Qt.AlignmentFlag.AlignVCenter.value());
	                ui.twPrestaciones.setItem(row,2,item);
	
	                item = new QTableWidgetItem();
	                item.setText(query.getString("dps_cant"));
	                item.setTextAlignment(Qt.AlignmentFlag.AlignVCenter.value() | Qt.AlignmentFlag.AlignRight.value());
	                ui.twPrestaciones.setItem(row,3,item);
	
	                row++;
	            }
	            ui.twPrestaciones.resizeColumnsToContents();
	            sql = String.format("SELECT cita_feho FROM miniris.citaciones WHERE eps_id=%1$s", ui.leID.text());
	            query = DBUtils.getResultSet(sql);
		        if(query.next())
		        	ui.cwFecha.setSelectedDate(Utils.DateToQDate(query.getDate(1)));
	        }
        }catch (SQLException e) {
			DBUtils.showSQLException(e);
		}
        return result;
    }
    /**
     * Habilita o Deshabilita los controles: 
     * btnDNuevo
     * btnDEditar
     * btnDGuardar
     * btnDEliminar
     * btnDCancelar
     *   
     * @param nuevo
     * @param editar
     * @param guardar
     * @param eliminar
     * @param cancelar
     */
    private void EnabledDButtons(boolean nuevo, boolean editar, boolean guardar, boolean eliminar, boolean cancelar)
    {
        ui.btnDNuevo.setEnabled(nuevo);
        ui.btnDEditar.setEnabled(editar);
        ui.btnDGuardar.setEnabled(guardar);
        ui.btnDEliminar.setEnabled(eliminar);
        ui.btnDCancelar.setEnabled(cancelar);
    }
}
