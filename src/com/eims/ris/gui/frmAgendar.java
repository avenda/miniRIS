package com.eims.ris.gui;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.eims.ris.core.Agenda;
import com.eims.ris.core.AgendaDetails;
import com.eims.ris.core.DBUtils;
import com.eims.ris.core.Utils;
import com.eims.ris.core.Enumeradores.Action;
import com.eims.ris.core.Enumeradores.DateTimeFormat;
import com.eims.ris.core.Enumeradores.Message;
import com.eims.ris.gui.Ui_frmAgendar;

import com.trolltech.qt.core.QTime;
import com.trolltech.qt.core.Qt;
import com.trolltech.qt.gui.QCursor;
import com.trolltech.qt.gui.QDialog;
import com.trolltech.qt.gui.QWidget;
import com.trolltech.qt.gui.QTableWidgetItem;
import com.trolltech.qt.gui.QApplication;
import com.trolltech.qt.gui.QDialogButtonBox.StandardButton;

import com.trolltech.qt.core.QDate;

public class frmAgendar extends QDialog {

    /**
	 * @uml.property  name="ui"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
    Ui_frmAgendar ui = new Ui_frmAgendar();
    /**
	 * @uml.property  name="_userName"
	 */
    private String _userName;
    /**
	 * @uml.property  name="_dateFormat"
	 */
    private String _dateFormat;
    /**
	 * @uml.property  name="_curDate"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
    private QDate _curDate = new QDate();
    /**
	 * @uml.property  name="_Action"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
    private Action _Action = Action.None;

    public frmAgendar(String userName) {
        this(userName, null);
    }
    
    public frmAgendar(String userName, QWidget parent) {
        super(parent);
        ui.setupUi(this);
        _userName = userName;
        _dateFormat = Utils.getDateTimeFormat(DateTimeFormat.Date);
        ui.deFIni.setDisplayFormat(_dateFormat);
        ui.deFTer.setDisplayFormat(_dateFormat);
        ui.deFOmitir.setDisplayFormat(_dateFormat);
        CreateConnect();
        QApplication.restoreOverrideCursor();
    }
    
    public void on_btnNuevo_Clicked(){
    	Utils.HabilitaAcciones(this, _userName, objectName().substring(3), 'A');
    	ui.gbProgA.setEnabled(true);
        ui.gbProgM.setEnabled(true);
        ui.btnIniciar.setEnabled(true);
        ui.cmbProf.showPopup();
        _Action = Action.New;
    }
    public void on_btnEditar_Clicked(){
    	int id = Integer.parseInt(ui.twAgendas.item(ui.twAgendas.currentRow(), 0).text());
    	Agenda agenda = new Agenda();
    	if(agenda.findAgenda(id)){
    		ui.cmbProf.setCurrentIndex(ui.cmbProf.findData(agenda.getProfesional()));
    		ui.cmbRF.setCurrentIndex(ui.cmbRF.findData(agenda.getRFAsociado()));
    		ui.sbCupos.setValue(agenda.getCantidadCupos());
    		ui.sbIntervalo.setValue(agenda.getIntervalo());
    		ui.teInicio.setTime(QTime.fromString(agenda.getHoraInicio()));
    		ui.ckbALun.setChecked(agenda.getLunes());
    		ui.ckbAMar.setChecked(agenda.getMartes());
    		ui.ckbAMie.setChecked(agenda.getMiercoles());
    		ui.ckbAJue.setChecked(agenda.getJueves());
    		ui.ckbAVie.setChecked(agenda.getViernes());
    		ui.ckbASab.setChecked(agenda.getSabado());
    		ui.ckbADom.setChecked(agenda.getDomingo());
    		ui.leDesc.setText(agenda.getDescripcion());
    		int row = 0;
    		QTableWidgetItem item;
    		ui.twSemana.setRowCount(0);
    		for (AgendaDetails ad : agenda.getPlanificacion()){
    			ui.twSemana.insertRow(row);
                ui.twSemana.setRowHeight(row,18);
                if(ui.ckbALun.isChecked()){
                    item = new QTableWidgetItem();
                    item.setText(ad.getLunes());
                    item.setTextAlignment(5);
                    ui.twSemana.setItem(row,0,item);
                    
                    item = new QTableWidgetItem();
                    item.setText(ad.getMartes());
                    item.setTextAlignment(5);
                    ui.twSemana.setItem(row,1,item);
                    
                    item = new QTableWidgetItem();
                    item.setText(ad.getMiercoles());
                    item.setTextAlignment(5);
                    ui.twSemana.setItem(row,2,item);
                    
                    item = new QTableWidgetItem();
                    item.setText(ad.getJueves());
                    item.setTextAlignment(5);
                    ui.twSemana.setItem(row,3,item);
                    
                    item = new QTableWidgetItem();
                    item.setText(ad.getViernes());
                    item.setTextAlignment(5);
                    ui.twSemana.setItem(row,4,item);
                    
                    item = new QTableWidgetItem();
                    item.setText(ad.getSabado());
                    item.setTextAlignment(5);
                    ui.twSemana.setItem(row,5,item);
                    
                    item = new QTableWidgetItem();
                    item.setText(ad.getDomingo());
                    item.setTextAlignment(5);
                    ui.twSemana.setItem(row,6,item);
                    
                    row++;
                }
			}
    		ui.twSemana.resizeColumnsToContents();
        	Utils.HabilitaAcciones(this, _userName, objectName().substring(3), 'E');
        	_Action = Action.Edit;
    	}
    }
    public void on_btnGuardar_Clicked(){
    	if(ui.cmbProf.currentIndex()<0){
    		ui.cmbProf.showPopup();
    		return;
    	}else if(ui.cmbRF.currentIndex()<1){
    		ui.cmbRF.showPopup();
    		return;	
    	}else if(ui.leDesc.text().equals("")){
    		Utils.MessageBox(Message.Information, "Debe ingresar la descripción de la plantilla.\nIntente nuevamente.");
    		ui.leDesc.setFocus();
    		return;
    	}else if(ui.twSemana.rowCount()<1){
    		Utils.MessageBox(Message.Information, "Debe ingresar la planificación semanal.\nIntente nuevamente.");
    		return;
    	}
    	Agenda agenda = new Agenda();
    	agenda.setProfesional(Integer.parseInt(ui.cmbProf.itemData(ui.cmbProf.currentIndex()).toString()));
    	agenda.setRFAsociado(Integer.parseInt(ui.cmbRF.itemData(ui.cmbRF.currentIndex()).toString()));
    	agenda.setDescripcion(ui.leDesc.text());
    	agenda.setCantidadCupos(ui.sbCupos.value());
    	agenda.setIntervalo(ui.sbIntervalo.value());
    	agenda.setHoraInicio(ui.teInicio.text());
    	agenda.setLunes(ui.ckbALun.isChecked());
    	agenda.setMartes(ui.ckbAMar.isChecked());
    	agenda.setMiercoles(ui.ckbAMie.isChecked());
    	agenda.setJueves(ui.ckbAJue.isChecked());
    	agenda.setViernes(ui.ckbAVie.isChecked());
    	agenda.setSabado(ui.ckbASab.isChecked());
    	agenda.setDomingo(ui.ckbADom.isChecked());
    	boolean result = false;
    	if(_Action == Action.New){
    		AgendaDetails ad;
    		for(int i=0; i<ui.twSemana.rowCount(); i++){
    			ad = new AgendaDetails();
    			if(ui.ckbALun.isChecked()) ad.setLunes(ui.twSemana.item(i, 0).text());
    			if(ui.ckbAMar.isChecked()) ad.setMartes(ui.twSemana.item(i, 1).text());
    			if(ui.ckbAMie.isChecked()) ad.setMiercoles(ui.twSemana.item(i, 2).text());
    			if(ui.ckbAJue.isChecked()) ad.setJueves(ui.twSemana.item(i, 3).text());
    			if(ui.ckbAVie.isChecked()) ad.setViernes(ui.twSemana.item(i, 4).text());
    			if(ui.ckbASab.isChecked()) ad.setSabado(ui.twSemana.item(i, 5).text());
    			if(ui.ckbADom.isChecked()) ad.setDomingo(ui.twSemana.item(i, 6).text());
    			agenda.setPlanificacion(ad);
    		}
    		result = agenda.Insertar();
    	}else{
    		int id = Integer.parseInt(ui.twAgendas.item(ui.twAgendas.currentRow(), 0).text());
    		agenda.setId(id);
    		result = agenda.Modificar();
    	}
    	if(result){
    		Utils.MessageBox(Message.Information, "¡El registro se ha guardado satisfactoriamente!");
    		ui.twAgendas.setEnabled(true);
    		this.ClearForm();
        	Utils.HabilitaAcciones(this,_userName,objectName().substring(3),'B');
        	_Action = Action.None;
        	LoadData();
    	}else
    		Utils.MessageBox(Message.Error, "¡Se ha producido un error al guardar el registro!");
    }
    public void on_btnImprimir_Clicked(){
    	
    }
    
    public void on_btnAplicar_Clicked(){
    	String time = ui.teInicio.text();
        QTableWidgetItem item;
        String[] hora;
        int h, m;
        int row = 0;
        for(int i=1;i<=ui.sbCupos.value();i++){
            row = ui.twSemana.rowCount();
            ui.twSemana.insertRow(row);
            ui.twSemana.setRowHeight(row,18);
            if(ui.ckbALun.isChecked()){
                item = new QTableWidgetItem();
                item.setText(time);
                item.setTextAlignment(5);
                ui.twSemana.setItem(row,0,item);
            }
            if(ui.ckbAMar.isChecked()){
                item = new QTableWidgetItem();
                item.setText(time);
                item.setTextAlignment(5);
                ui.twSemana.setItem(row,1,item);
            }
            if(ui.ckbAMie.isChecked()){
                item = new QTableWidgetItem();
                item.setText(time);
                item.setTextAlignment(5);
                ui.twSemana.setItem(row,2,item);
            }
            if(ui.ckbAJue.isChecked()){
                item = new QTableWidgetItem();
                item.setText(time);
                item.setTextAlignment(5);
                ui.twSemana.setItem(row,3,item);
            }
            if(ui.ckbAVie.isChecked()){
                item = new QTableWidgetItem();
                item.setText(time);
                item.setTextAlignment(5);
                ui.twSemana.setItem(row,4,item);
            }
            if(ui.ckbASab.isChecked()){
                item = new QTableWidgetItem();
                item.setText(time);
                item.setTextAlignment(5);
                ui.twSemana.setItem(row,5,item);
            }
            if(ui.ckbADom.isChecked()){
                item = new QTableWidgetItem();
                item.setText(time);
                item.setTextAlignment(5);
                ui.twSemana.setItem(row,6,item);
            }
            hora = time.split(":");
            h = Integer.parseInt(hora[0]);
            m = Integer.parseInt(hora[1]);
            if(ui.sbIntervalo.value()==60)
                h += 1;
            else{
                if(m + ui.sbIntervalo.value() > 59){
                    h += 1;
                    m = (m + ui.sbIntervalo.value()) - 60;
                }else{
                    m += ui.sbIntervalo.value();
                }
            }
            time = String.format("%02d",h)+":"+String.format("%02d",m);
        }
        ui.twSemana.resizeColumnsToContents();
        ui.btnAplicar.setEnabled(false);
    }
    
    public void on_btnLimpiar_Clicked(){
    	ui.twSemana.setRowCount(0);
    	ui.btnAplicar.setEnabled(true);
    }

    public void on_btnIniciar_Clicked(){
    	if(ui.twSemana.rowCount()<1){
            Utils.MessageBox(Message.Information, "Debe programar la agenda semanal antes de proceder.\nIntente nuevamente.");
            return;
        }
        if(ui.cmbProf.currentIndex()<0){
            ui.cmbProf.showPopup();
            return;
        }
        if(ui.cmbRF.currentIndex()<1){
            ui.cmbRF.showPopup();
            return;
        }
        QApplication.setOverrideCursor(new QCursor(Qt.CursorShape.WaitCursor));
        
        Connection cnn = DBUtils.getConnection();
        try{	
        	cnn.setAutoCommit(false);
        }catch (SQLException e) {
			DBUtils.showSQLException(e);
		}
        
        PreparedStatement stm;
        QDate ini = ui.deFIni.date();
        String citacion = "";
        int dia = 0;
        while(!ini.equals(ui.deFTer.date().addDays(1))){
            dia = ini.dayOfWeek();
            //System.out.println(ini + "::" + dia);
            if(!VerificarOmisionFecha(ini)){
	            if((ui.ckbALun.isChecked() && dia==1) ||
	               (ui.ckbAMar.isChecked() && dia==2) ||
	               (ui.ckbAMie.isChecked() && dia==3) ||
	               (ui.ckbAJue.isChecked() && dia==4) ||
	               (ui.ckbAVie.isChecked() && dia==5) ||
	               (ui.ckbASab.isChecked() && dia==6) ||
	               (ui.ckbADom.isChecked() && dia==7)){
	                for(int r=0;r<ui.twSemana.rowCount();r++){
	                	try{
	                        stm = cnn.prepareStatement("INSERT INTO miniris.citaciones (cita_feho,fun_id,rf_id,cita_esta,cita_stor,cita_obse,cita_user) VALUES(?,?,?,?,?,?,?)");
	                        citacion = ini.toString("yyyy-MM-dd ")+ui.twSemana.item(r,dia-1).text()+":00";
	                        stm.setTimestamp(1, Timestamp.valueOf(citacion));
	                        stm.setInt(2, Integer.parseInt(ui.cmbProf.itemData(ui.cmbProf.currentIndex()).toString()));
	                        stm.setInt(3, Integer.parseInt(ui.cmbRF.itemData(ui.cmbRF.currentIndex()).toString()));
	                        stm.setString(4, "D");
	                        stm.setString(5, "D");
	                        stm.setString(6, DBUtils.getTableField("SELECT par_desc FROM miniris.parametros WHERE par_grupo='TC' AND par_id=1").toString());
	                        stm.setString(7, _userName);
	                        stm.execute();
	                	}catch (SQLException e) {
	                		DBUtils.showSQLException(e);
							QApplication.restoreOverrideCursor();
							try{
								cnn.rollback();
							}catch (SQLException ex) {
								DBUtils.showSQLException(ex);
							}
							return;
						}
	                }
	            }
            }
            ini = ini.addDays(1);
            //System.out.println("INI: " + ini);
        }
        try{
        	cnn.commit();
        	cnn.setAutoCommit(true);
        }catch (SQLException e) {
			DBUtils.showSQLException(e);
			return;
		}
        QApplication.restoreOverrideCursor();
        if(_Action == Action.New){
        	int res = Utils.MessageBox(Message.Question, "El proceso se ha realizado correctamente.\n¿Desea guardar la programación recientemente creada?");
        	if(res == StandardButton.Yes.value()){
        		this.on_btnGuardar_Clicked();
        	}
        }else
        	Utils.MessageBox(Message.Information, "El proceso se ha realizado satisfactoriamente.");
    }
    
    @SuppressWarnings("unused")
	private void on_btnAdd_Clicked(){
    	QTableWidgetItem item;
    	String time = ui.teHora.text();
    	int row = ui.twSemana.rowCount();
        ui.twSemana.insertRow(row);
        ui.twSemana.setRowHeight(row,18);
        if(ui.ckbMLun.isChecked()){
            item = new QTableWidgetItem();
            item.setText(time);
            item.setTextAlignment(5);
            ui.twSemana.setItem(row,0,item);
        }
        if(ui.ckbMMar.isChecked()){
            item = new QTableWidgetItem();
            item.setText(time);
            item.setTextAlignment(5);
            ui.twSemana.setItem(row,1,item);
        }
        if(ui.ckbMMie.isChecked()){
            item = new QTableWidgetItem();
            item.setText(time);
            item.setTextAlignment(5);
            ui.twSemana.setItem(row,2,item);
        }
        if(ui.ckbMJue.isChecked()){
            item = new QTableWidgetItem();
            item.setText(time);
            item.setTextAlignment(5);
            ui.twSemana.setItem(row,3,item);
        }
        if(ui.ckbMVie.isChecked()){
            item = new QTableWidgetItem();
            item.setText(time);
            item.setTextAlignment(5);
            ui.twSemana.setItem(row,4,item);
        }
        if(ui.ckbMSab.isChecked()){
            item = new QTableWidgetItem();
            item.setText(time);
            item.setTextAlignment(5);
            ui.twSemana.setItem(row,5,item);
        }
        if(ui.ckbMDom.isChecked()){
            item = new QTableWidgetItem();
            item.setText(time);
            item.setTextAlignment(5);
            ui.twSemana.setItem(row,6,item);
        }
        ui.twSemana.resizeColumnsToContents();
    }
    
    @SuppressWarnings("unused")
	private void on_tbAdd_Clicked(){
    	for(int i=0;i<ui.twFechasOmitidas.rowCount();i++){
    		if(ui.deFOmitir.text().equals(ui.twFechasOmitidas.item(i, 0).text())){
    			Utils.MessageBox(Message.Information, "Lo siento, la fecha a omitir ya está en la lista de omisión.");
    			return;
    		}
    	}
    	QTableWidgetItem item = null;
    	int row = ui.twFechasOmitidas.rowCount();
        ui.twFechasOmitidas.insertRow(row);
        ui.twFechasOmitidas.setRowHeight(row,20);

        item = new QTableWidgetItem();
        item.setText(ui.deFOmitir.text());
        item.setTextAlignment(5);
        ui.twFechasOmitidas.setItem(row,0,item);
    }
    @SuppressWarnings("unused")
	private void on_tbRemove_Clicked(){
    	ui.twFechasOmitidas.removeRow(ui.twFechasOmitidas.currentRow());
    	ui.tbRemove.setEnabled(false);
    }
    @SuppressWarnings("unused")
	private void on_twFechasOmitidas_CellClicked(int row, int col){
    	ui.tbRemove.setEnabled(true);
    }
    @SuppressWarnings("unused")
	private void on_twAgendas_CellClicked(int row, int col){
    	Utils.HabilitaAcciones(this,_userName,objectName().substring(3),'B');
    }
    
    public void CreateConnect(){
    	ui.ckbAInv.setVisible(false);
    	ui.ckbMInv.setVisible(false);
    	
    	ui.btnNuevo.clicked.connect(this, "on_btnNuevo_Clicked()");
    	ui.btnEditar.clicked.connect(this, "on_btnEditar_Clicked()");
    	ui.btnGuardar.clicked.connect(this, "on_btnGuardar_Clicked()");
    	ui.btnImprimir.clicked.connect(this, "on_btnImprimir_Clicked()");
    	ui.btnCerrar.clicked.connect(this, "close()");
    	
    	ui.btnAplicar.clicked.connect(this, "on_btnAplicar_Clicked()");
    	ui.btnLimpiar.clicked.connect(this, "on_btnLimpiar_Clicked()");
    	
    	ui.btnAdd.clicked.connect(this, "on_btnAdd_Clicked()");
    	
    	ui.btnIniciar.clicked.connect(this, "on_btnIniciar_Clicked()");

    	ui.tbAdd.clicked.connect(this, "on_tbAdd_Clicked()");
    	ui.tbRemove.clicked.connect(this, "on_tbRemove_Clicked()");
    	ui.twFechasOmitidas.cellClicked.connect(this, "on_twFechasOmitidas_CellClicked(int, int)");
    	
    	ui.twAgendas.cellClicked.connect(this, "on_twAgendas_CellClicked(int, int)");
    	
    	Utils.HabilitaAcciones(this,_userName,objectName().substring(3),'\0');
    	
    	_curDate = QDate.fromString(Utils.ObtenerFechaHora().substring(0, 10), "yyyy-MM-dd");
    	ui.deFIni.setDate(_curDate);
    	ui.deFTer.setDate(_curDate);
    	ui.deFOmitir.setDate(_curDate);
    	
    	LoadData();
    	LoadCombos();
    	ui.twSemana.resizeColumnsToContents();
    }
    
    private void LoadData(){
        int row = 0;
		ui.twAgendas.setRowCount(0);
        String sql = String.format("SELECT pae_id,pae_desc,fun_nomb,fun_apat,rf_desc FROM miniris.plantillas_agendas_enc pa INNER JOIN miniris.funcionarios f ON pa.fun_id=f.fun_id INNER JOIN miniris.rrffs rf ON pa.rf_id=rf.rf_id ORDER BY pae_id");
        try{
	        ResultSet query = DBUtils.getResultSet(sql); 
	        while(query.next()){
	            QTableWidgetItem item = null;
	            ui.twAgendas.insertRow(row);
	            ui.twAgendas.setRowHeight(row,20);
	
	            item = new QTableWidgetItem();
	            item.setText(query.getString("pae_id"));
	            item.setTextAlignment(Qt.AlignmentFlag.AlignVCenter.value() | Qt.AlignmentFlag.AlignRight.value());
	            ui.twAgendas.setItem(row,0,item);
	
	            item = new QTableWidgetItem();
	            item.setText(query.getString("pae_desc"));
	            item.setTextAlignment(Qt.AlignmentFlag.AlignVCenter.value());
	            ui.twAgendas.setItem(row,1,item);
	            
	            item = new QTableWidgetItem();
	            item.setText(query.getString("fun_nomb") + " " + query.getString("fun_apat"));
	            item.setTextAlignment(Qt.AlignmentFlag.AlignVCenter.value());
	            ui.twAgendas.setItem(row,2,item);
	            
	            item = new QTableWidgetItem();
	            item.setText(query.getString("rf_desc"));
	            item.setTextAlignment(Qt.AlignmentFlag.AlignVCenter.value());
	            ui.twAgendas.setItem(row,3,item);
	
	            row++;
	        }
        }catch(SQLException e){
        	e.printStackTrace();
        }
        ui.twAgendas.resizeColumnsToContents();
    }
    
    private void LoadCombos(){
    	String sql;
        sql = String.format("SELECT fun_id,fun_apat || ' ' || fun_nomb  FROM miniris.funcionarios WHERE fun_vige=TRUE ORDER BY fun_id");
        DBUtils.loadComboBox(ui.cmbProf, sql);
        sql = String.format("SELECT rf_id,rf_desc FROM miniris.rrffs WHERE rf_vige=TRUE ORDER BY rf_id");
        DBUtils.loadComboBox(ui.cmbRF, sql);
    }
    
    private boolean VerificarOmisionFecha(QDate fecha){
    	QDate fechaOmitida;
    	for(int i=0;i<ui.twFechasOmitidas.rowCount();i++){
    		fechaOmitida = QDate.fromString(ui.twFechasOmitidas.item(i, 0).text(), _dateFormat);
    		if(fecha.compareTo(fechaOmitida) == 0) return true;
    	}
    	return false;
    }
	private void ClearForm(){
    	ui.cmbProf.setCurrentIndex(-1);
		ui.cmbRF.setCurrentIndex(-1);
		ui.sbCupos.setValue(1);
		ui.sbIntervalo.setValue(5);
		ui.teInicio.setTime(QTime.fromString("08:00"));
    	ui.ckbALun.setChecked(false);
    	ui.ckbAMar.setChecked(false);
    	ui.ckbAMie.setChecked(false);
    	ui.ckbAJue.setChecked(false);
    	ui.ckbAVie.setChecked(false);
    	ui.ckbASab.setChecked(false);
    	ui.ckbADom.setChecked(false);
    	ui.leDesc.setText("");
    }
}
