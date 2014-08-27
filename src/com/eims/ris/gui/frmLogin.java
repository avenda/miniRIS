package com.eims.ris.gui;

import com.eims.ris.core.DBUtils;
import com.eims.ris.gui.Ui_frmLogin;
import com.trolltech.qt.core.Qt;
import com.trolltech.qt.gui.QApplication;
import com.trolltech.qt.gui.QCursor;
import com.trolltech.qt.gui.QDialog;
import com.trolltech.qt.gui.QWidget;

public class frmLogin extends QDialog {

    /**
	 * @uml.property  name="ui"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
    Ui_frmLogin ui = new Ui_frmLogin();
    private static int _intentos = 0;

    public frmLogin() {
        this(null);
    }

    public frmLogin(QWidget parent) {
        super(parent);
        ui.setupUi(this);
        CreateConnect();
    }
    
    public String getUserName(){
    	return ui.leUser.text();
    }
    
    private void CreateConnect(){
    	ui.frmMsg.setVisible(false);
    	ui.btnAceptar.clicked.connect(this, "on_btnAceptar_Clicked()");
    	ui.leUser.textChanged.connect(this, "HideMessageError()");
    	ui.lePass.textChanged.connect(this, "HideMessageError()");
    }
    
    @SuppressWarnings("unused")
	private void on_btnAceptar_Clicked(){
    	QApplication.setOverrideCursor(new QCursor(Qt.CursorShape.WaitCursor));
    	DBUtils.setServer(ui.cmbServer.currentText());
    	System.out.println(ui.leUser.text()+ " - "+ui.lePass.text()+" - "+DBUtils.encryptMD5(ui.lePass.text()));
    	if(DBUtils.verificaLogin(ui.leUser.text(), DBUtils.encryptMD5(ui.lePass.text()))){
			System.out.println("Logueado OK!");
			this.accept();
		}else{
			ui.frmMsg.setVisible(true);
		}
		frmLogin._intentos++;
		if(frmLogin._intentos>3) this.reject();
		QApplication.restoreOverrideCursor();
    }
    
    @SuppressWarnings("unused")
	private void HideMessageError(){
    	ui.frmMsg.setVisible(false);
    }
}
