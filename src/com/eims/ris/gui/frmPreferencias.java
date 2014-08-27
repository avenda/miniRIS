package com.eims.ris.gui;

import com.eims.ris.gui.Ui_frmPreferencias;
import com.trolltech.qt.core.QSettings;
import com.trolltech.qt.gui.QApplication;
import com.trolltech.qt.gui.QDialog;
import com.trolltech.qt.gui.QWidget;

public class frmPreferencias extends QDialog {

    Ui_frmPreferencias ui = new Ui_frmPreferencias();
    private String _userName;
    private QSettings setting = new QSettings("EIMS", "eHC");
    
    public frmPreferencias(String userName) {
        this(userName, null);
    }

    public frmPreferencias(String userName, QWidget parent) {
        super(parent);
        _userName = userName;
        ui.setupUi(this);
        ui.cmbTheme.setCurrentIndex(Integer.parseInt(setting.value("Theme", 0).toString()));
        //ui.leAETPACS.setText(setting.value("AETitlePACS", "DCM4CHEE").toString());
        //ui.leHostPACS.setText(setting.value("HostPACS", "localhost").toString());
        //ui.sbPortPACS.setValue(Integer.parseInt(setting.value("PortPACS", 11112).toString()));
        ui.btnAceptar.clicked.connect(this, "on_btnAceptar_Clicked()");
        QApplication.restoreOverrideCursor();
    }
    
    public void on_btnAceptar_Clicked(){
    	setting.setValue("Theme", ui.cmbTheme.currentIndex());
    	//setting.setValue("AETitlePACS", ui.leAETPACS.text());
    	//setting.setValue("HostPACS", ui.leHostPACS.text());
    	//setting.setValue("PortPACS", ui.sbPortPACS.text());
    	close();
    }
}
