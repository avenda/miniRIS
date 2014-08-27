/********************************************************************************
** Form generated from reading ui file 'frmLogin.jui'
**
** Created: Sun Oct 9 22:44:59 2011
**      by: Qt User Interface Compiler version 4.5.2
**
** WARNING! All changes made in this file will be lost when recompiling ui file!
********************************************************************************/

package com.eims.ris.gui;

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class Ui_frmLogin implements com.trolltech.qt.QUiForm<QDialog>
{
    /**
	 * @uml.property  name="lblTitleBar"
	 * @uml.associationEnd  
	 */
    public QLabel lblTitleBar;
    /**
	 * @uml.property  name="cmbServer"
	 * @uml.associationEnd  
	 */
    public QComboBox cmbServer;
    /**
	 * @uml.property  name="lblInfo2"
	 * @uml.associationEnd  
	 */
    public QLabel lblInfo2;
    /**
	 * @uml.property  name="btnAceptar"
	 * @uml.associationEnd  
	 */
    public QPushButton btnAceptar;
    /**
	 * @uml.property  name="label_4"
	 * @uml.associationEnd  
	 */
    public QLabel label_4;
    /**
	 * @uml.property  name="line"
	 * @uml.associationEnd  
	 */
    public QFrame line;
    /**
	 * @uml.property  name="frmMsg"
	 * @uml.associationEnd  
	 */
    public QFrame frmMsg;
    /**
	 * @uml.property  name="img3"
	 * @uml.associationEnd  
	 */
    public QLabel img3;
    /**
	 * @uml.property  name="lblInfo3"
	 * @uml.associationEnd  
	 */
    public QLabel lblInfo3;
    /**
	 * @uml.property  name="lblTitle"
	 * @uml.associationEnd  
	 */
    public QLabel lblTitle;
    /**
	 * @uml.property  name="line_2"
	 * @uml.associationEnd  
	 */
    public QFrame line_2;
    /**
	 * @uml.property  name="lblInfo1"
	 * @uml.associationEnd  
	 */
    public QLabel lblInfo1;
    /**
	 * @uml.property  name="label_5"
	 * @uml.associationEnd  
	 */
    public QLabel label_5;
    /**
	 * @uml.property  name="btnCancelar"
	 * @uml.associationEnd  
	 */
    public QPushButton btnCancelar;
    /**
	 * @uml.property  name="img1"
	 * @uml.associationEnd  
	 */
    public QLabel img1;
    /**
	 * @uml.property  name="lePass"
	 * @uml.associationEnd  
	 */
    public QLineEdit lePass;
    /**
	 * @uml.property  name="leUser"
	 * @uml.associationEnd  
	 */
    public QLineEdit leUser;
    /**
	 * @uml.property  name="lblServer"
	 * @uml.associationEnd  
	 */
    public QLabel lblServer;
    /**
	 * @uml.property  name="img2"
	 * @uml.associationEnd  
	 */
    public QLabel img2;

    public Ui_frmLogin() { super(); }

    public void setupUi(QDialog frmLogin)
    {
        frmLogin.setObjectName("frmLogin");
        frmLogin.resize(new QSize(389, 260).expandedTo(frmLogin.minimumSizeHint()));
        frmLogin.setMinimumSize(new QSize(389, 260));
        frmLogin.setMaximumSize(new QSize(389, 260));
        frmLogin.setWindowIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/keys48.png")));
        lblTitleBar = new QLabel(frmLogin);
        lblTitleBar.setObjectName("lblTitleBar");
        lblTitleBar.setGeometry(new QRect(0, 0, 391, 81));
        QFont font = new QFont();
        font.setFamily("Gill Sans MT Condensed");
        font.setPointSize(20);
        lblTitleBar.setFont(font);
        lblTitleBar.setStyleSheet("background-color: qlineargradient(spread:pad, x1:0, y1:0, x2:0, y2:1, stop:0 rgba(0, 50, 100, 255), stop:1 rgba(0, 0, 0, 0));");
        lblTitleBar.setMargin(1);
        lblTitleBar.setIndent(0);
        cmbServer = new QComboBox(frmLogin);
        cmbServer.setObjectName("cmbServer");
        cmbServer.setGeometry(new QRect(70, 150, 131, 22));
        cmbServer.setEditable(true);
        lblInfo2 = new QLabel(frmLogin);
        lblInfo2.setObjectName("lblInfo2");
        lblInfo2.setGeometry(new QRect(10, 190, 205, 63));
        QFont font1 = new QFont();
        font1.setFamily("Gill Sans MT Condensed");
        font1.setPointSize(10);
        lblInfo2.setFont(font1);
        btnAceptar = new QPushButton(frmLogin);
        btnAceptar.setObjectName("btnAceptar");
        btnAceptar.setGeometry(new QRect(210, 150, 84, 26));
        QFont font2 = new QFont();
        btnAceptar.setFont(font2);
        btnAceptar.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnAceptar.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/ok48.png")));
        btnAceptar.setDefault(true);
        label_4 = new QLabel(frmLogin);
        label_4.setObjectName("label_4");
        label_4.setGeometry(new QRect(10, 120, 52, 16));
        QFont font3 = new QFont();
        font3.setBold(true);
        font3.setWeight(75);
        label_4.setFont(font3);
        line = new QFrame(frmLogin);
        line.setObjectName("line");
        line.setGeometry(new QRect(10, 100, 371, 16));
        QFont font4 = new QFont();
        line.setFont(font4);
        line.setFrameShape(QFrame.Shape.HLine);
        line.setFrameShadow(QFrame.Shadow.Sunken);
        frmMsg = new QFrame(frmLogin);
        frmMsg.setObjectName("frmMsg");
        frmMsg.setEnabled(true);
        frmMsg.setGeometry(new QRect(230, 200, 152, 51));
        QFont font5 = new QFont();
        frmMsg.setFont(font5);
        img3 = new QLabel(frmMsg);
        img3.setObjectName("img3");
        img3.setGeometry(new QRect(0, 0, 21, 21));
        QFont font6 = new QFont();
        img3.setFont(font6);
        img3.setPixmap(new QPixmap(("classpath:com/eims/ris/images/stop16.png")));
        lblInfo3 = new QLabel(frmMsg);
        lblInfo3.setObjectName("lblInfo3");
        lblInfo3.setGeometry(new QRect(18, 0, 134, 51));
        QFont font7 = new QFont();
        lblInfo3.setFont(font7);
        lblTitle = new QLabel(frmLogin);
        lblTitle.setObjectName("lblTitle");
        lblTitle.setGeometry(new QRect(90, 0, 208, 34));
        QFont font8 = new QFont();
        font8.setFamily("Gill Sans MT Condensed");
        font8.setPointSize(20);
        lblTitle.setFont(font8);
        line_2 = new QFrame(frmLogin);
        line_2.setObjectName("line_2");
        line_2.setGeometry(new QRect(10, 177, 371, 16));
        QFont font9 = new QFont();
        line_2.setFont(font9);
        line_2.setFrameShadow(com.trolltech.qt.gui.QFrame.Shadow.Sunken);
        line_2.setFrameShape(QFrame.Shape.HLine);
        line_2.setFrameShadow(QFrame.Shadow.Sunken);
        lblInfo1 = new QLabel(frmLogin);
        lblInfo1.setObjectName("lblInfo1");
        lblInfo1.setGeometry(new QRect(110, 40, 267, 60));
        QFont font10 = new QFont();
        lblInfo1.setFont(font10);
        label_5 = new QLabel(frmLogin);
        label_5.setObjectName("label_5");
        label_5.setGeometry(new QRect(190, 120, 78, 16));
        QFont font11 = new QFont();
        font11.setBold(true);
        font11.setWeight(75);
        label_5.setFont(font11);
        btnCancelar = new QPushButton(frmLogin);
        btnCancelar.setObjectName("btnCancelar");
        btnCancelar.setGeometry(new QRect(300, 150, 82, 26));
        QFont font12 = new QFont();
        btnCancelar.setFont(font12);
        btnCancelar.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnCancelar.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/stop16.png")));
        img1 = new QLabel(frmLogin);
        img1.setObjectName("img1");
        img1.setGeometry(new QRect(10, 0, 71, 81));
        QFont font13 = new QFont();
        img1.setFont(font13);
        img1.setPixmap(new QPixmap(("classpath:com/eims/ris/images/user65.png")));
        lePass = new QLineEdit(frmLogin);
        lePass.setObjectName("lePass");
        lePass.setGeometry(new QRect(280, 120, 101, 22));
        QFont font14 = new QFont();
        lePass.setFont(font14);
        lePass.setMaxLength(20);
        lePass.setEchoMode(com.trolltech.qt.gui.QLineEdit.EchoMode.Password);
        leUser = new QLineEdit(frmLogin);
        leUser.setObjectName("leUser");
        leUser.setGeometry(new QRect(70, 120, 101, 22));
        QFont font15 = new QFont();
        leUser.setFont(font15);
        leUser.setMaxLength(20);
        lblServer = new QLabel(frmLogin);
        lblServer.setObjectName("lblServer");
        lblServer.setGeometry(new QRect(10, 150, 58, 16));
        QFont font16 = new QFont();
        font16.setBold(true);
        font16.setWeight(75);
        lblServer.setFont(font16);
        img2 = new QLabel(frmLogin);
        img2.setObjectName("img2");
        img2.setGeometry(new QRect(50, 50, 51, 51));
        QFont font17 = new QFont();
        img2.setFont(font17);
        img2.setPixmap(new QPixmap(("classpath:com/eims/ris/images/keys48.png")));
        QWidget.setTabOrder(leUser, lePass);
        QWidget.setTabOrder(lePass, cmbServer);
        QWidget.setTabOrder(cmbServer, btnAceptar);
        QWidget.setTabOrder(btnAceptar, btnCancelar);
        retranslateUi(frmLogin);
        btnCancelar.clicked.connect(frmLogin, "reject()");

        frmLogin.connectSlotsByName();
    } // setupUi

    void retranslateUi(QDialog frmLogin)
    {
        frmLogin.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("frmLogin", "EIMS - RIS - Inicio de sesi\u00f3n", null));
        cmbServer.clear();
        cmbServer.addItem(new QIcon(new QPixmap("classpath:com/eims/ris/images/server22.png")), com.trolltech.qt.core.QCoreApplication.translate("frmLogin", "localhost", null));
        cmbServer.addItem(new QIcon(new QPixmap("classpath:com/eims/ris/images/server22.png")), com.trolltech.qt.core.QCoreApplication.translate("frmLogin", "190.13.185.234", null));
        lblInfo2.setText(com.trolltech.qt.core.QCoreApplication.translate("frmLogin", "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0//EN\" \"http://www.w3.org/TR/REC-html40/strict.dtd\">\n"+
"<html><head><meta name=\"qrichtext\" content=\"1\" /><style type=\"text/css\">\n"+
"p, li { white-space: pre-wrap; }\n"+
"</style></head><body style=\" font-family:'Gill Sans MT Condensed'; font-size:10pt; font-weight:400; font-style:normal;\">\n"+
"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-size:8pt;\">Sistema de Informaci\u00f3n Radiol\u00f3gica</span></p>\n"+
"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-size:9pt;\">\u00a9 2011. Parte de la familia</span> EIMS</p></body></html>", null));
        btnAceptar.setText(com.trolltech.qt.core.QCoreApplication.translate("frmLogin", "Aceptar", null));
        btnAceptar.setShortcut(com.trolltech.qt.core.QCoreApplication.translate("frmLogin", "Alt+A", null));
        label_4.setText(com.trolltech.qt.core.QCoreApplication.translate("frmLogin", "Usuario", null));
        lblInfo3.setText(com.trolltech.qt.core.QCoreApplication.translate("frmLogin", "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0//EN\" \"http://www.w3.org/TR/REC-html40/strict.dtd\">\n"+
"<html><head><meta name=\"qrichtext\" content=\"1\" /><style type=\"text/css\">\n"+
"p, li { white-space: pre-wrap; }\n"+
"</style></head><body style=\" font-family:'Sans Serif'; font-size:9pt; font-weight:400; font-style:normal;\">\n"+
"<p align=\"justify\" style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-family:'MS Shell Dlg 2'; font-size:8pt; font-weight:600;\">Usuario o contrase\u00f1a</span></p>\n"+
"<p align=\"justify\" style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-family:'MS Shell Dlg 2'; font-size:8pt;\">No v\u00e1lido. </span></p>\n"+
"<p align=\"justify\" style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-family:'MS Shell Dlg 2'; font-size:8pt;\">Intente nuevamente</span></p></body></html>", null));
        lblTitle.setText(com.trolltech.qt.core.QCoreApplication.translate("frmLogin", "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0//EN\" \"http://www.w3.org/TR/REC-html40/strict.dtd\">\n"+
"<html><head><meta name=\"qrichtext\" content=\"1\" /><style type=\"text/css\">\n"+
"p, li { white-space: pre-wrap; }\n"+
"</style></head><body style=\" font-family:'Gill Sans MT Condensed'; font-size:20pt; font-weight:400; font-style:normal;\">\n"+
"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-size:18pt; color:#ffffff;\">EIMS - </span><span style=\" color:#ffffff;\">RIS</span></p></body></html>", null));
        lblInfo1.setText(com.trolltech.qt.core.QCoreApplication.translate("frmLogin", "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0//EN\" \"http://www.w3.org/TR/REC-html40/strict.dtd\">\n"+
"<html><head><meta name=\"qrichtext\" content=\"1\" /><style type=\"text/css\">\n"+
"p, li { white-space: pre-wrap; }\n"+
"</style></head><body style=\" font-family:'MS Shell Dlg 2'; font-size:8.25pt; font-weight:400; font-style:normal;\">\n"+
"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-size:8pt; font-weight:600; color:#dfdfdf;\">ACCESO AL SISTEMA</span></p>\n"+
"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-size:8pt;\">Gesti\u00f3n Unidad de Imagenolog\u00eda</span></p>\n"+
"<p style=\"-qt-paragraph-type:empty; margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px; font-size:8pt;\"></p>\n"+
"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-size:8pt;\">Ingrese aqu\u00ed los datos de su cuenta de acceso.</span></p></body></html>", null));
        label_5.setText(com.trolltech.qt.core.QCoreApplication.translate("frmLogin", "Contrase\u00f1a", null));
        btnCancelar.setText(com.trolltech.qt.core.QCoreApplication.translate("frmLogin", "Cancelar", null));
        btnCancelar.setShortcut(com.trolltech.qt.core.QCoreApplication.translate("frmLogin", "Alt+C", null));
        img1.setText("");
        lePass.setText(com.trolltech.qt.core.QCoreApplication.translate("frmLogin", "123", null));
        leUser.setText(com.trolltech.qt.core.QCoreApplication.translate("frmLogin", "admin", null));
        lblServer.setText(com.trolltech.qt.core.QCoreApplication.translate("frmLogin", "Servidor", null));
        img2.setText("");
    } // retranslateUi

}

