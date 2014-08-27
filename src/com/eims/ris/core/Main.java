package com.eims.ris.core;

import com.eims.ris.gui.frmLogin;
import com.eims.ris.gui.frmMain;
import com.trolltech.qt.core.QSettings;
import com.trolltech.qt.core.Qt;
import com.trolltech.qt.gui.QApplication;
import com.trolltech.qt.gui.QCDEStyle;
import com.trolltech.qt.gui.QCursor;
import com.trolltech.qt.gui.QMotifStyle;
import com.trolltech.qt.gui.QPixmap;
import com.trolltech.qt.gui.QSplashScreen;

import com.trolltech.qt.gui.QPlastiqueStyle;
import com.trolltech.qt.gui.QCleanlooksStyle;
import com.trolltech.qt.gui.QWindowsStyle;

public class Main{
    public static void main(String[] args) {
        QApplication.initialize(args);
        QSettings setting = new QSettings("EIMS", "eHC");
        int theme = Integer.parseInt(setting.value("Theme", 0).toString());
        switch(theme){
        	case 0: QApplication.setStyle(new QPlastiqueStyle()); break;
        	case 1: QApplication.setStyle(new QWindowsStyle()); break;
        	case 2: QApplication.setStyle(new QMotifStyle()); break;
        	case 3: QApplication.setStyle(new QCleanlooksStyle()); break;
        	case 4: QApplication.setStyle(new QCDEStyle()); break;
        }
        frmLogin fLogin = new frmLogin();
        int result = fLogin.exec();
        QApplication.setOverrideCursor(new QCursor(Qt.CursorShape.WaitCursor));
        QApplication.processEvents();
        System.out.println("Resultado de exec(): " + result);
        if(result != 0){
        	QPixmap pixmap = new QPixmap("classpath:com/eims/ris/images/splash.png");
            QSplashScreen splash = new QSplashScreen(pixmap);
            splash.show();
            QApplication.processEvents();
        	frmMain fMain = new frmMain(fLogin.getUserName());
        	fMain.setAttribute(Qt.WidgetAttribute.WA_QuitOnClose);
        	fMain.show();
        	splash.finish(fMain);
        	QApplication.restoreOverrideCursor();
        	QApplication.exec();
        }
    }
}