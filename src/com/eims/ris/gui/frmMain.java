package com.eims.ris.gui;


import java.sql.ResultSet;
import java.sql.SQLException;
import com.trolltech.qt.core.Qt;
import com.trolltech.qt.gui.QApplication;
import com.trolltech.qt.gui.QCursor;
import com.trolltech.qt.gui.QDialog;
import com.trolltech.qt.gui.QMainWindow;
import com.trolltech.qt.gui.QWidget;
import com.trolltech.qt.gui.QResizeEvent;

import com.eims.ris.core.DBUtils;
import com.eims.ris.core.Utils;
import com.eims.ris.gui.Ui_frmMain;

public class frmMain extends QMainWindow {

    /**
	 * @uml.property  name="ui"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
    Ui_frmMain ui = new Ui_frmMain();
    /**
	 * @uml.property  name="_userName"
	 */
    private String _userName;

    public frmMain(String userName) {
        this(userName, null);
    }

    public frmMain(String userName, QWidget parent) {
        super(parent);
        ui.setupUi(this);
        _userName = userName;
        CreateConnect();
    }
    
    @Override
    protected void resizeEvent(QResizeEvent e)
    {
        super.resizeEvent(e);
        ui.tabWidget.resize(this.width(), this.height()-24);
        ui.frmUser.resize(ui.frmUser.width(), this.height() - 129);
        ui.lblBGUser.resize(ui.frmUser.width() - 4, ui.frmUser.height() - 4);
        ui.frmSQL.move(ui.frmSQL.x(), ui.frmUser.height() - ui.frmSQL.height() - 10);
    }
    
    @SuppressWarnings("unused")
	private void on_btnMCita_Clicked(){
    	QApplication.setOverrideCursor(new QCursor(Qt.CursorShape.WaitCursor));
    	frmCitaciones fCita = new frmCitaciones(_userName);
    	fCita.exec();
    }
    @SuppressWarnings("unused")
	private void on_btnMRece_Clicked(){
    	QApplication.setOverrideCursor(new QCursor(Qt.CursorShape.WaitCursor));
    	frmRecepciones fRece = new frmRecepciones(_userName);
    	fRece.exec();
    }
    @SuppressWarnings("unused")
	private void on_btnMIRec_Clicked(){
    	QApplication.setOverrideCursor(new QCursor(Qt.CursorShape.WaitCursor));
    	frmConsRecep fCRece = new frmConsRecep(_userName);
    	fCRece.exec();
    }
    @SuppressWarnings("unused")
    private void on_btnMSSal_Clicked(){
    	QApplication.setOverrideCursor(new QCursor(Qt.CursorShape.WaitCursor));
    	frmSistSalud fSSal = new frmSistSalud(_userName);
    	fSSal.exec();
    }
    @SuppressWarnings("unused")
    private void on_btnMDeri_Clicked(){
    	QApplication.setOverrideCursor(new QCursor(Qt.CursorShape.WaitCursor));
    	frmDerivadores fDeri = new frmDerivadores(_userName);
    	fDeri.exec();
    }
    @SuppressWarnings("unused")
    private void on_btnMProf_Clicked(){
    	QApplication.setOverrideCursor(new QCursor(Qt.CursorShape.WaitCursor));
    	frmProfesiones fProf = new frmProfesiones(_userName);
    	fProf.exec();
    }
    @SuppressWarnings("unused")
    private void on_btnMPaci_Clicked(){
    	QApplication.setOverrideCursor(new QCursor(Qt.CursorShape.WaitCursor));
    	frmPacientes fPaci = new frmPacientes(_userName, true);
    	fPaci.exec();
    }
    @SuppressWarnings("unused")
    private void on_btnMBPac_Clicked(){
    	QApplication.setOverrideCursor(new QCursor(Qt.CursorShape.WaitCursor));
    	frmPacientes fPaci = new frmPacientes(_userName, false);
    	fPaci.exec();
    }
    @SuppressWarnings("unused")
    private void on_btnMPres_Clicked(){
    	QApplication.setOverrideCursor(new QCursor(Qt.CursorShape.WaitCursor));
    	frmPrestaciones fPres = new frmPrestaciones(_userName);
    	fPres.exec();
    }
    @SuppressWarnings("unused")
    private void on_btnMRRFF_Clicked(){
    	QApplication.setOverrideCursor(new QCursor(Qt.CursorShape.WaitCursor));
    	frmRRFFs fRRFF = new frmRRFFs(_userName);
    	fRRFF.exec();
    }
    @SuppressWarnings("unused")
    private void on_btnMFunc_Clicked(){
    	QApplication.setOverrideCursor(new QCursor(Qt.CursorShape.WaitCursor));
    	frmFuncionarios fFunc = new frmFuncionarios(_userName);
    	fFunc.exec();
    }
    @SuppressWarnings("unused")
    private void on_btnMCiud_Clicked(){
    	QApplication.setOverrideCursor(new QCursor(Qt.CursorShape.WaitCursor));
    	frmCiudades fCiud = new frmCiudades(_userName);
    	fCiud.exec();
    }
    @SuppressWarnings("unused")
    private void on_btnMUser_Clicked(){
    	QApplication.setOverrideCursor(new QCursor(Qt.CursorShape.WaitCursor));
    	frmUsuarios fUser = new frmUsuarios(_userName, this);
    	fUser.exec();
    }
    @SuppressWarnings("unused")
    private void on_btnMCAge_Clicked(){
    	QApplication.setOverrideCursor(new QCursor(Qt.CursorShape.WaitCursor));
    	frmAgendar fCAge = new frmAgendar(_userName);
    	fCAge.exec();
    }
    @SuppressWarnings("unused")
    private void on_btnMPref_Clicked(){
    	QApplication.setOverrideCursor(new QCursor(Qt.CursorShape.WaitCursor));
    	frmPreferencias fPrefe = new frmPreferencias(_userName);
    	fPrefe.exec();
    }
    @SuppressWarnings("unused")
    private void on_cmdLBAbout_Clicked(){
    	QDialog fSplash = new QDialog();
    	fSplash.setWindowTitle("Acerca de...");
    	fSplash.resize(500, 300);
    	fSplash.setMinimumSize(500, 300);
    	fSplash.setStyleSheet("background-image: url(classpath:com/ehealthcare/ris/images/splash.png);");
    	fSplash.show();
    	QApplication.restoreOverrideCursor();
    }
    @SuppressWarnings("unused")
    private void on_btnMRX_Clicked(){
    	QApplication.setOverrideCursor(new QCursor(Qt.CursorShape.WaitCursor));
    	frmModalidades fRx = new frmModalidades(_userName, "CR");
    	fRx.exec();
    }
    @SuppressWarnings("unused")
    private void on_btnMMG_Clicked(){
    	QApplication.setOverrideCursor(new QCursor(Qt.CursorShape.WaitCursor));
    	frmModalidades fMg = new frmModalidades(_userName, "MG");
    	fMg.exec();
    }
    @SuppressWarnings("unused")
    private void on_btnMMR_Clicked(){
    	QApplication.setOverrideCursor(new QCursor(Qt.CursorShape.WaitCursor));
    	frmModalidades fMr = new frmModalidades(_userName, "MR");
    	fMr.exec();
    }
    @SuppressWarnings("unused")
    private void on_btnMUS_Clicked(){
    	QApplication.setOverrideCursor(new QCursor(Qt.CursorShape.WaitCursor));
    	frmModalidades fUs = new frmModalidades(_userName, "US");
    	fUs.exec();
    }
    @SuppressWarnings("unused")
    private void on_btnMCT_Clicked(){
    	QApplication.setOverrideCursor(new QCursor(Qt.CursorShape.WaitCursor));
    	frmModalidades fCt = new frmModalidades(_userName, "CT");
    	fCt.exec();
    }
    @SuppressWarnings("unused")
    private void on_btnMXA_Clicked(){
    	QApplication.setOverrideCursor(new QCursor(Qt.CursorShape.WaitCursor));
    	frmModalidades fXa = new frmModalidades(_userName, "XA");
    	fXa.exec();
    }
    /**
     * METODO PARA ESTABLECER LAS SEÑALES CON SUS RESPECTIVAS RANURAS (SIGNALS & SLOTS)
     */
    private void CreateConnect(){
    	
    	
    	ui.btnMCita.clicked.connect(this, "on_btnMCita_Clicked()");
    	ui.btnMRece.clicked.connect(this, "on_btnMRece_Clicked()");
    	
    	ui.btnMIRec.clicked.connect(this, "on_btnMIRec_Clicked()");
    	
    	ui.btnMCiud.clicked.connect(this, "on_btnMCiud_Clicked()");
    	ui.btnMSSal.clicked.connect(this, "on_btnMSSal_Clicked()");
    	ui.btnMDeri.clicked.connect(this, "on_btnMDeri_Clicked()");
    	ui.btnMPaci.clicked.connect(this, "on_btnMPaci_Clicked()");
    	ui.btnMBPac.clicked.connect(this, "on_btnMBPac_Clicked()");
    	ui.btnMProf.clicked.connect(this, "on_btnMProf_Clicked()");
    	ui.btnMPres.clicked.connect(this, "on_btnMPres_Clicked()");
    	ui.btnMRRFF.clicked.connect(this, "on_btnMRRFF_Clicked()");
    	ui.btnMFunc.clicked.connect(this, "on_btnMFunc_Clicked()");
    	ui.btnMUser.clicked.connect(this, "on_btnMUser_Clicked()");
    	ui.btnMCAge.clicked.connect(this, "on_btnMCAge_Clicked()");
    	ui.btnMPref.clicked.connect(this, "on_btnMPref_Clicked()");
    	
    	ui.btnMRX.clicked.connect(this, "on_btnMRX_Clicked()");
    	ui.btnMMG.clicked.connect(this, "on_btnMMG_Clicked()");
    	ui.btnMMR.clicked.connect(this, "on_btnMMR_Clicked()");
    	ui.btnMUS.clicked.connect(this, "on_btnMUS_Clicked()");
    	ui.btnMCT.clicked.connect(this, "on_btnMCT_Clicked()");
    	ui.btnMXA.clicked.connect(this, "on_btnMXA_Clicked()");
    	
    	
    	ui.cmdLBAbout.clicked.connect(this, "on_cmdLBAbout_Clicked()");

    	Utils.HabilitaOpciones(this, _userName);
    	LoadInfoSession();
    }
    
    private void LoadInfoSession(){
    	final String prefix = "<!DOCTYPE HTML PUBLIC '-//W3C//DTD HTML 4.0//EN' 'http://www.w3.org/TR/REC-html40/strict.dtd'>\n<html><head><meta name='qrichtext' content='1' /><style type='text/css'>\np, li { white-space: pre-wrap; }\n</style></head><body style=' font-family:\'MS Shell Dlg 2\'; font-size:8.25pt; font-weight:400; font-style:normal;'>\n<p style=' margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;'><span style=' font-size:8pt; color:#ffffff;'>";
    	try{
	    	ResultSet query = DBUtils.getResultSet(String.format("SELECT * FROM miniris.usuarios WHERE usu_acco='%1$s';", _userName));
	        query.next();
	        //int _userID = query.getInt(1);
	        ui.lblUser.setText(prefix+"UID000"+query.getString(1)+"</span></p></body></html>");
	        ui.lblUser_2.setText(prefix+query.getString(2)+"<br>"+query.getString(5)+" "+query.getString(6)+", "+query.getString(4)+"<br>"+(query.getInt(9)==1?"Administrador":"Restringido")+"</span></p></body></html>");
            ui.lblLogin.setText(prefix+"Logueado: "+Utils.ObtenerFechaHora()+"</span></p></body></html>");
            DBUtils.executeNonQuery(String.format("UPDATE miniris.usuarios SET usu_fuac=NOW() WHERE usu_acco='%1$s'", _userName));
    	}catch (SQLException e) {
			e.printStackTrace();
		}
    }
}
