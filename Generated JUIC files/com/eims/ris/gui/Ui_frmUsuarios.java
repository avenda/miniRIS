/********************************************************************************
** Form generated from reading ui file 'frmUsuarios.jui'
**
** Created: dom nov 20 00:29:10 2011
**      by: Qt User Interface Compiler version 4.5.2
**
** WARNING! All changes made in this file will be lost when recompiling ui file!
********************************************************************************/

package com.eims.ris.gui;

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class Ui_frmUsuarios implements com.trolltech.qt.QUiForm<QDialog>
{
    public QLabel label_4;
    public QPushButton btnNuevo;
    public QPushButton btnImprimir;
    public QLabel label_5;
    public QLabel label;
    public QPushButton btnCerrar;
    public QLabel label_22;
    public QPushButton btnEliminar;
    public QLabel label_21;
    public QPushButton btnEditar;
    public QLabel label_6;
    public QLabel label_2;
    public QFrame frmReg;
    public QPushButton btnCancelar;
    public QPushButton btnAceptar;
    public QLabel label_12;
    public QLabel label_13;
    public QTabWidget tabWidget;
    public QWidget tab;
    public QLabel label_3;
    public QLabel label_7;
    public QLabel label_8;
    public QLabel label_9;
    public QLabel label_10;
    public QLabel label_11;
    public QLabel label_14;
    public QCheckBox ckbVige;
    public QLineEdit leAcco;
    public QLineEdit lePass1;
    public QLineEdit lePass2;
    public QLineEdit leNomb;
    public QLineEdit leAPat;
    public QLineEdit leAMat;
    public QLineEdit leDesc;
    public QLabel imgAction;
    public QLabel label_15;
    public QComboBox cmbPerfil;
    public QGroupBox gbTUser;
    public QRadioButton rbUserA;
    public QRadioButton rbUserR;
    public QWidget tab_2;
    public QTableWidget twAccesos;
    public QToolButton tbAdd;
    public QToolButton tbDel;
    public QGroupBox gbPrivilegios;
    public QCheckBox ckbAdd;
    public QCheckBox ckbEdit;
    public QCheckBox ckbDel;
    public QCheckBox ckbPrint;
    public QTableWidget twClases;
    public QTableWidget twUsuarios;

    public Ui_frmUsuarios() { super(); }

    public void setupUi(QDialog frmUsuarios)
    {
        frmUsuarios.setObjectName("frmUsuarios");
        frmUsuarios.resize(new QSize(640, 430).expandedTo(frmUsuarios.minimumSizeHint()));
        frmUsuarios.setMinimumSize(new QSize(640, 430));
        frmUsuarios.setMaximumSize(new QSize(640, 430));
        frmUsuarios.setWindowIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/user64.png")));
        label_4 = new QLabel(frmUsuarios);
        label_4.setObjectName("label_4");
        label_4.setGeometry(new QRect(100, 150, 251, 56));
        QFont font = new QFont();
        font.setFamily("Arial");
        label_4.setFont(font);
        btnNuevo = new QPushButton(frmUsuarios);
        btnNuevo.setObjectName("btnNuevo");
        btnNuevo.setGeometry(new QRect(20, 150, 62, 58));
        btnNuevo.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnNuevo.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/nuev48.png")));
        btnNuevo.setIconSize(new QSize(48, 48));
        btnImprimir = new QPushButton(frmUsuarios);
        btnImprimir.setObjectName("btnImprimir");
        btnImprimir.setGeometry(new QRect(360, 150, 62, 58));
        btnImprimir.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnImprimir.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/print48.png")));
        btnImprimir.setIconSize(new QSize(48, 48));
        label_5 = new QLabel(frmUsuarios);
        label_5.setObjectName("label_5");
        label_5.setGeometry(new QRect(100, 230, 251, 42));
        label = new QLabel(frmUsuarios);
        label.setObjectName("label");
        label.setGeometry(new QRect(0, 0, 641, 111));
        label.setStyleSheet("background-color: qlineargradient(spread:pad, x1:0, y1:0, x2:0, y2:1, stop:0 rgba(0, 50, 100, 255), stop:1 rgba(0, 0, 0, 0));");
        label.setPixmap(new QPixmap(("classpath:com/eims/ris/images/user64.png")));
        label.setMargin(10);
        btnCerrar = new QPushButton(frmUsuarios);
        btnCerrar.setObjectName("btnCerrar");
        btnCerrar.setGeometry(new QRect(360, 230, 62, 58));
        btnCerrar.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnCerrar.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/shutdown64.png")));
        btnCerrar.setIconSize(new QSize(48, 48));
        label_22 = new QLabel(frmUsuarios);
        label_22.setObjectName("label_22");
        label_22.setGeometry(new QRect(440, 230, 191, 42));
        btnEliminar = new QPushButton(frmUsuarios);
        btnEliminar.setObjectName("btnEliminar");
        btnEliminar.setGeometry(new QRect(20, 310, 62, 58));
        btnEliminar.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnEliminar.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/dele48.png")));
        btnEliminar.setIconSize(new QSize(48, 48));
        label_21 = new QLabel(frmUsuarios);
        label_21.setObjectName("label_21");
        label_21.setGeometry(new QRect(440, 150, 171, 42));
        btnEditar = new QPushButton(frmUsuarios);
        btnEditar.setObjectName("btnEditar");
        btnEditar.setGeometry(new QRect(20, 230, 62, 58));
        btnEditar.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnEditar.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/edit48.png")));
        btnEditar.setIconSize(new QSize(48, 48));
        label_6 = new QLabel(frmUsuarios);
        label_6.setObjectName("label_6");
        label_6.setGeometry(new QRect(100, 310, 251, 70));
        label_2 = new QLabel(frmUsuarios);
        label_2.setObjectName("label_2");
        label_2.setGeometry(new QRect(90, 10, 492, 96));
        frmReg = new QFrame(frmUsuarios);
        frmReg.setObjectName("frmReg");
        frmReg.setGeometry(new QRect(10, 120, 621, 301));
        frmReg.setAutoFillBackground(true);
        frmReg.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.NoFrame);
        frmReg.setFrameShadow(com.trolltech.qt.gui.QFrame.Shadow.CustomEnum);
        btnCancelar = new QPushButton(frmReg);
        btnCancelar.setObjectName("btnCancelar");
        btnCancelar.setGeometry(new QRect(350, 270, 77, 26));
        btnCancelar.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnCancelar.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/stop16.png")));
        btnAceptar = new QPushButton(frmReg);
        btnAceptar.setObjectName("btnAceptar");
        btnAceptar.setGeometry(new QRect(150, 270, 77, 26));
        btnAceptar.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnAceptar.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/ok48.png")));
        label_12 = new QLabel(frmReg);
        label_12.setObjectName("label_12");
        label_12.setGeometry(new QRect(230, 270, 121, 28));
        QFont font1 = new QFont();
        font1.setPointSize(8);
        label_12.setFont(font1);
        label_13 = new QLabel(frmReg);
        label_13.setObjectName("label_13");
        label_13.setGeometry(new QRect(430, 270, 111, 28));
        QFont font2 = new QFont();
        font2.setPointSize(8);
        label_13.setFont(font2);
        tabWidget = new QTabWidget(frmReg);
        tabWidget.setObjectName("tabWidget");
        tabWidget.setGeometry(new QRect(10, 10, 601, 251));
        QFont font3 = new QFont();
        font3.setFamily("Arial");
        tabWidget.setFont(font3);
        tabWidget.setTabPosition(com.trolltech.qt.gui.QTabWidget.TabPosition.West);
        tab = new QWidget();
        tab.setObjectName("tab");
        label_3 = new QLabel(tab);
        label_3.setObjectName("label_3");
        label_3.setGeometry(new QRect(20, 30, 40, 15));
        label_7 = new QLabel(tab);
        label_7.setObjectName("label_7");
        label_7.setGeometry(new QRect(20, 60, 64, 15));
        label_8 = new QLabel(tab);
        label_8.setObjectName("label_8");
        label_8.setGeometry(new QRect(20, 85, 61, 30));
        label_9 = new QLabel(tab);
        label_9.setObjectName("label_9");
        label_9.setGeometry(new QRect(20, 130, 50, 15));
        label_10 = new QLabel(tab);
        label_10.setObjectName("label_10");
        label_10.setGeometry(new QRect(20, 160, 57, 15));
        label_11 = new QLabel(tab);
        label_11.setObjectName("label_11");
        label_11.setGeometry(new QRect(250, 160, 59, 15));
        label_14 = new QLabel(tab);
        label_14.setObjectName("label_14");
        label_14.setGeometry(new QRect(20, 190, 65, 15));
        ckbVige = new QCheckBox(tab);
        ckbVige.setObjectName("ckbVige");
        ckbVige.setGeometry(new QRect(400, 190, 66, 21));
        leAcco = new QLineEdit(tab);
        leAcco.setObjectName("leAcco");
        leAcco.setGeometry(new QRect(90, 30, 113, 20));
        leAcco.setMaxLength(15);
        lePass1 = new QLineEdit(tab);
        lePass1.setObjectName("lePass1");
        lePass1.setGeometry(new QRect(90, 60, 113, 20));
        lePass1.setMaxLength(15);
        lePass1.setEchoMode(com.trolltech.qt.gui.QLineEdit.EchoMode.Normal);
        lePass2 = new QLineEdit(tab);
        lePass2.setObjectName("lePass2");
        lePass2.setGeometry(new QRect(90, 90, 113, 20));
        lePass2.setMaxLength(13);
        lePass2.setEchoMode(com.trolltech.qt.gui.QLineEdit.EchoMode.Normal);
        leNomb = new QLineEdit(tab);
        leNomb.setObjectName("leNomb");
        leNomb.setGeometry(new QRect(90, 130, 161, 20));
        leNomb.setMaxLength(25);
        leAPat = new QLineEdit(tab);
        leAPat.setObjectName("leAPat");
        leAPat.setGeometry(new QRect(90, 160, 131, 20));
        leAPat.setMaxLength(20);
        leAMat = new QLineEdit(tab);
        leAMat.setObjectName("leAMat");
        leAMat.setGeometry(new QRect(320, 160, 131, 20));
        leAMat.setMaxLength(20);
        leDesc = new QLineEdit(tab);
        leDesc.setObjectName("leDesc");
        leDesc.setGeometry(new QRect(90, 190, 291, 20));
        leDesc.setMaxLength(40);
        imgAction = new QLabel(tab);
        imgAction.setObjectName("imgAction");
        imgAction.setGeometry(new QRect(500, 10, 61, 61));
        QFont font4 = new QFont();
        imgAction.setFont(font4);
        imgAction.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.NoFrame);
        imgAction.setFrameShadow(com.trolltech.qt.gui.QFrame.Shadow.CustomEnum);
        label_15 = new QLabel(tab);
        label_15.setObjectName("label_15");
        label_15.setGeometry(new QRect(280, 29, 203, 31));
        cmbPerfil = new QComboBox(tab);
        cmbPerfil.setObjectName("cmbPerfil");
        cmbPerfil.setGeometry(new QRect(280, 60, 201, 22));
        gbTUser = new QGroupBox(tab);
        gbTUser.setObjectName("gbTUser");
        gbTUser.setGeometry(new QRect(280, 90, 201, 51));
        rbUserA = new QRadioButton(gbTUser);
        rbUserA.setObjectName("rbUserA");
        rbUserA.setGeometry(new QRect(10, 20, 99, 21));
        rbUserR = new QRadioButton(gbTUser);
        rbUserR.setObjectName("rbUserR");
        rbUserR.setGeometry(new QRect(110, 20, 86, 21));
        rbUserR.setChecked(true);
        tabWidget.addTab(tab, new QIcon(new QPixmap("classpath:com/eims/ris/images/user64.png")), com.trolltech.qt.core.QCoreApplication.translate("frmUsuarios", "Usuario", null));
        tab_2 = new QWidget();
        tab_2.setObjectName("tab_2");
        twAccesos = new QTableWidget(tab_2);
        twAccesos.setObjectName("twAccesos");
        twAccesos.setGeometry(new QRect(255, 10, 312, 188));
        QFont font5 = new QFont();
        font5.setPointSize(8);
        twAccesos.setFont(font5);
        twAccesos.setStyleSheet("QTableWidget {\n"+
"     show-decoration-selected: 1;\n"+
"	alternate-background-color: rgb(247, 255, 193);\n"+
"}\n"+
"\n"+
"QTableWidget::item:hover {\n"+
"     background: qlineargradient(x1: 0, y1: 0, x2: 0, y2: 1, stop: 0 #e7effd, stop: 1 #cbdaf1);\n"+
"}\n"+
"\n"+
"QTableWidget::item:selected:active{\n"+
"     background: qlineargradient(x1: 0, y1: 0, x2: 0, y2: 1, stop: 0 rgba(128, 163, 186, 150), stop: 1 rgba(87, 127, 191, 150));\n"+
"}\n"+
"\n"+
"QTableWidget::item:selected:!active {\n"+
"     background: qlineargradient(x1: 0, y1: 0, x2: 0, y2: 1, stop: 0 rgba(128, 163, 186, 150), stop: 1 rgba(87, 127, 191, 150));\n"+
"}");
        twAccesos.setEditTriggers(com.trolltech.qt.gui.QAbstractItemView.EditTrigger.createQFlags(com.trolltech.qt.gui.QAbstractItemView.EditTrigger.NoEditTriggers));
        twAccesos.setAlternatingRowColors(true);
        twAccesos.setSelectionMode(com.trolltech.qt.gui.QAbstractItemView.SelectionMode.SingleSelection);
        twAccesos.setSelectionBehavior(com.trolltech.qt.gui.QAbstractItemView.SelectionBehavior.SelectRows);
        tbAdd = new QToolButton(tab_2);
        tbAdd.setObjectName("tbAdd");
        tbAdd.setGeometry(new QRect(220, 50, 29, 28));
        QFont font6 = new QFont();
        font6.setPointSize(10);
        tbAdd.setFont(font6);
        tbAdd.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        tbAdd.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/arrow_right22.png")));
        tbAdd.setIconSize(new QSize(22, 22));
        tbDel = new QToolButton(tab_2);
        tbDel.setObjectName("tbDel");
        tbDel.setGeometry(new QRect(220, 90, 29, 28));
        QFont font7 = new QFont();
        font7.setPointSize(10);
        tbDel.setFont(font7);
        tbDel.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        tbDel.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/arrow_left22.png")));
        tbDel.setIconSize(new QSize(22, 22));
        gbPrivilegios = new QGroupBox(tab_2);
        gbPrivilegios.setObjectName("gbPrivilegios");
        gbPrivilegios.setGeometry(new QRect(220, 200, 341, 41));
        gbPrivilegios.setCheckable(true);
        gbPrivilegios.setChecked(true);
        ckbAdd = new QCheckBox(gbPrivilegios);
        ckbAdd.setObjectName("ckbAdd");
        ckbAdd.setGeometry(new QRect(10, 18, 68, 21));
        ckbEdit = new QCheckBox(gbPrivilegios);
        ckbEdit.setObjectName("ckbEdit");
        ckbEdit.setGeometry(new QRect(90, 18, 74, 21));
        ckbDel = new QCheckBox(gbPrivilegios);
        ckbDel.setObjectName("ckbDel");
        ckbDel.setGeometry(new QRect(180, 18, 69, 21));
        ckbPrint = new QCheckBox(gbPrivilegios);
        ckbPrint.setObjectName("ckbPrint");
        ckbPrint.setGeometry(new QRect(270, 18, 68, 21));
        twClases = new QTableWidget(tab_2);
        twClases.setObjectName("twClases");
        twClases.setGeometry(new QRect(10, 10, 201, 231));
        QFont font8 = new QFont();
        font8.setFamily("Arial");
        font8.setPointSize(8);
        twClases.setFont(font8);
        twClases.setStyleSheet("QTableWidget {\n"+
"     show-decoration-selected: 1;\n"+
"	alternate-background-color: rgb(247, 255, 193);\n"+
"}\n"+
"\n"+
"QTableWidget::item:hover {\n"+
"     background: qlineargradient(x1: 0, y1: 0, x2: 0, y2: 1, stop: 0 #e7effd, stop: 1 #cbdaf1);\n"+
"}\n"+
"\n"+
"QTableWidget::item:selected:active{\n"+
"     background: qlineargradient(x1: 0, y1: 0, x2: 0, y2: 1, stop: 0 rgba(128, 163, 186, 150), stop: 1 rgba(87, 127, 191, 150));\n"+
"}\n"+
"\n"+
"QTableWidget::item:selected:!active {\n"+
"     background: qlineargradient(x1: 0, y1: 0, x2: 0, y2: 1, stop: 0 rgba(128, 163, 186, 150), stop: 1 rgba(87, 127, 191, 150));\n"+
"}");
        twClases.setEditTriggers(com.trolltech.qt.gui.QAbstractItemView.EditTrigger.createQFlags(com.trolltech.qt.gui.QAbstractItemView.EditTrigger.NoEditTriggers));
        twClases.setAlternatingRowColors(true);
        twClases.setSelectionMode(com.trolltech.qt.gui.QAbstractItemView.SelectionMode.SingleSelection);
        twClases.setSelectionBehavior(com.trolltech.qt.gui.QAbstractItemView.SelectionBehavior.SelectRows);
        tabWidget.addTab(tab_2, new QIcon(new QPixmap("classpath:com/eims/ris/images/keys48.png")), com.trolltech.qt.core.QCoreApplication.translate("frmUsuarios", "Privilegios", null));
        twUsuarios = new QTableWidget(frmReg);
        twUsuarios.setObjectName("twUsuarios");
        twUsuarios.setGeometry(new QRect(10, 10, 601, 258));
        twUsuarios.setStyleSheet("QTableWidget {\n"+
"     show-decoration-selected: 1;\n"+
"	alternate-background-color: rgb(247, 255, 193);\n"+
"}\n"+
"\n"+
"QTableWidget::item:hover {\n"+
"     background: qlineargradient(x1: 0, y1: 0, x2: 0, y2: 1, stop: 0 #e7effd, stop: 1 #cbdaf1);\n"+
"}\n"+
"\n"+
"QTableWidget::item:selected:active{\n"+
"     background: qlineargradient(x1: 0, y1: 0, x2: 0, y2: 1, stop: 0 rgba(128, 163, 186, 150), stop: 1 rgba(87, 127, 191, 150));\n"+
"}\n"+
"\n"+
"QTableWidget::item:selected:!active {\n"+
"     background: qlineargradient(x1: 0, y1: 0, x2: 0, y2: 1, stop: 0 rgba(128, 163, 186, 150), stop: 1 rgba(87, 127, 191, 150));\n"+
"}");
        twUsuarios.setEditTriggers(com.trolltech.qt.gui.QAbstractItemView.EditTrigger.createQFlags(com.trolltech.qt.gui.QAbstractItemView.EditTrigger.NoEditTriggers));
        twUsuarios.setSelectionMode(com.trolltech.qt.gui.QAbstractItemView.SelectionMode.SingleSelection);
        twUsuarios.setSelectionBehavior(com.trolltech.qt.gui.QAbstractItemView.SelectionBehavior.SelectRows);
        retranslateUi(frmUsuarios);
        btnCerrar.clicked.connect(frmUsuarios, "close()");

        tabWidget.setCurrentIndex(0);


        frmUsuarios.connectSlotsByName();
    } // setupUi

    void retranslateUi(QDialog frmUsuarios)
    {
        frmUsuarios.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("frmUsuarios", "Administraci\u00f3n de usuarios", null));
        label_4.setText(com.trolltech.qt.core.QCoreApplication.translate("frmUsuarios", "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0//EN\" \"http://www.w3.org/TR/REC-html40/strict.dtd\">\n"+
"<html><head><meta name=\"qrichtext\" content=\"1\" /><style type=\"text/css\">\n"+
"p, li { white-space: pre-wrap; }\n"+
"</style></head><body style=\" font-family:'Arial'; font-size:8.25pt; font-weight:400; font-style:normal;\">\n"+
"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px; font-size:8pt;\"><span style=\" font-weight:600; color:#000000;\">Crear nuevos usuarios</span></p>\n"+
"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px; font-size:8pt; color:#000000;\">Para crear nuevos usuarios seleccione este \u00edtem.</p>\n"+
"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px; font-size:8pt; color:#000000;\">Se presentar\u00e1 un formulario con los campos</p>\n"+
"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px; font-size:8pt; color:#000000;\">necesarios para crear el nuevo registro.</p></body></html>", null));
        btnNuevo.setText("");
        btnImprimir.setText("");
        label_5.setText(com.trolltech.qt.core.QCoreApplication.translate("frmUsuarios", "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0//EN\" \"http://www.w3.org/TR/REC-html40/strict.dtd\">\n"+
"<html><head><meta name=\"qrichtext\" content=\"1\" /><style type=\"text/css\">\n"+
"p, li { white-space: pre-wrap; }\n"+
"</style></head><body style=\" font-family:'Arial'; font-size:8.25pt; font-weight:400; font-style:normal;\">\n"+
"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px; font-size:8pt;\"><span style=\" font-weight:600; color:#000000;\">Editar usuarios existentes</span></p>\n"+
"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px; font-size:8pt; color:#000000;\">Puede corregir informaci\u00f3n acerca de un usuario</p>\n"+
"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px; font-size:8pt; color:#000000;\">determinado.</p></body></html>", null));
        label.setText("");
        btnCerrar.setText("");
        label_22.setText(com.trolltech.qt.core.QCoreApplication.translate("frmUsuarios", "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0//EN\" \"http://www.w3.org/TR/REC-html40/strict.dtd\">\n"+
"<html><head><meta name=\"qrichtext\" content=\"1\" /><style type=\"text/css\">\n"+
"p, li { white-space: pre-wrap; }\n"+
"</style></head><body style=\" font-family:'Arial'; font-size:8.25pt; font-weight:400; font-style:normal;\">\n"+
"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px; font-size:8pt;\"><span style=\" font-weight:600; color:#000000;\">Cerrar la ventana</span></p>\n"+
"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px; font-size:8pt; color:#000000;\">Una vez que haya realizado las tareas</p>\n"+
"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px; font-size:8pt; color:#000000;\">en este m\u00f3dulo cierre desde aqu\u00ed.</p></body></html>", null));
        btnEliminar.setText("");
        label_21.setText(com.trolltech.qt.core.QCoreApplication.translate("frmUsuarios", "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0//EN\" \"http://www.w3.org/TR/REC-html40/strict.dtd\">\n"+
"<html><head><meta name=\"qrichtext\" content=\"1\" /><style type=\"text/css\">\n"+
"p, li { white-space: pre-wrap; }\n"+
"</style></head><body style=\" font-family:'Arial'; font-size:8.25pt; font-weight:400; font-style:normal;\">\n"+
"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px; font-size:8pt;\"><span style=\" font-weight:600; color:#000000;\">Imprimir usuarios existentes</span></p>\n"+
"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px; font-size:8pt; color:#000000;\">Puede generar un listado con los</p>\n"+
"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px; font-size:8pt; color:#000000;\">usuarios del sistema.</p></body></html>", null));
        btnEditar.setText("");
        label_6.setText(com.trolltech.qt.core.QCoreApplication.translate("frmUsuarios", "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0//EN\" \"http://www.w3.org/TR/REC-html40/strict.dtd\">\n"+
"<html><head><meta name=\"qrichtext\" content=\"1\" /><style type=\"text/css\">\n"+
"p, li { white-space: pre-wrap; }\n"+
"</style></head><body style=\" font-family:'Arial'; font-size:8.25pt; font-weight:400; font-style:normal;\">\n"+
"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px; font-size:8pt;\"><span style=\" font-weight:600; color:#000000;\">Eliminar usuarios existentes</span></p>\n"+
"<p align=\"justify\" style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px; font-size:8pt; color:#000000;\">Puede eliminar un usuario mal ingresado, recuerde</p>\n"+
"<p align=\"justify\" style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px; font-size:8pt; color:#000000;\">que no puede eliminar usuarios que posean</p>\n"+
"<p align=\"justify\" style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px; font-size:8pt; color:#000000;\">informaci\u00f3n asociada. Es recomendable dejarlos</p>\n"+
"<p align=\"justify\" style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px; font-size:8pt; color:#000000;\">sin vigencia en vez de eliminarlos.</p></body></html>", null));
        label_2.setText(com.trolltech.qt.core.QCoreApplication.translate("frmUsuarios", "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0//EN\" \"http://www.w3.org/TR/REC-html40/strict.dtd\">\n"+
"<html><head><meta name=\"qrichtext\" content=\"1\" /><style type=\"text/css\">\n"+
"p, li { white-space: pre-wrap; }\n"+
"</style></head><body style=\" font-family:'MS Shell Dlg 2'; font-size:8.25pt; font-weight:400; font-style:normal;\">\n"+
"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-family:'Calibri'; font-size:20pt;\">ADMINISTRACION DE USUARIOS</span></p>\n"+
"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-family:'Calibri'; font-size:11pt; color:#000000;\">Aqu\u00ed podr\u00e1 agregar, editar y eliminar los usuarios que tendr\u00e1n acceso al sistema,</span></p>\n"+
"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-family:'Calibri'; font-size:11pt; color:#000000;\">asignar los privilegios de  inserci\u00f3n, edici\u00f3n, eliminaci\u00f3n e impresi\u00f3n.</span></p>\n"+
"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-family:'Calibri'; font-size:11pt; color:#000000;\">Haga clic en un \u00edtem para comenzar.</span></p></body></html>", null));
        btnCancelar.setText(com.trolltech.qt.core.QCoreApplication.translate("frmUsuarios", "Cancelar", null));
        btnAceptar.setText(com.trolltech.qt.core.QCoreApplication.translate("frmUsuarios", "Aceptar", null));
        label_12.setText(com.trolltech.qt.core.QCoreApplication.translate("frmUsuarios", "Confirma la acci\u00f3n\n"+
"a realizar.", null));
        label_13.setText(com.trolltech.qt.core.QCoreApplication.translate("frmUsuarios", "Cancela la acci\u00f3n\n"+
"a realizar.", null));
        label_3.setText(com.trolltech.qt.core.QCoreApplication.translate("frmUsuarios", "Cuenta", null));
        label_7.setText(com.trolltech.qt.core.QCoreApplication.translate("frmUsuarios", "Contrase\u00f1a", null));
        label_8.setText(com.trolltech.qt.core.QCoreApplication.translate("frmUsuarios", "Confirmar\n"+
"contrase\u00f1a", null));
        label_9.setText(com.trolltech.qt.core.QCoreApplication.translate("frmUsuarios", "Nombres", null));
        label_10.setText(com.trolltech.qt.core.QCoreApplication.translate("frmUsuarios", "A. Paterno", null));
        label_11.setText(com.trolltech.qt.core.QCoreApplication.translate("frmUsuarios", "A. Materno", null));
        label_14.setText(com.trolltech.qt.core.QCoreApplication.translate("frmUsuarios", "Descripci\u00f3n", null));
        ckbVige.setText(com.trolltech.qt.core.QCoreApplication.translate("frmUsuarios", "Vigente", null));
        imgAction.setText("");
        label_15.setText(com.trolltech.qt.core.QCoreApplication.translate("frmUsuarios", "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0//EN\" \"http://www.w3.org/TR/REC-html40/strict.dtd\">\n"+
"<html><head><meta name=\"qrichtext\" content=\"1\" /><style type=\"text/css\">\n"+
"p, li { white-space: pre-wrap; }\n"+
"</style></head><body style=\" font-family:'Arial'; font-size:8.25pt; font-weight:400; font-style:normal;\">\n"+
"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px; font-size:8pt;\">Puede seleccionar un perfil existente para</p>\n"+
"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px; font-size:8pt;\">asignar privilegios similares.</p></body></html>", null));
        gbTUser.setTitle(com.trolltech.qt.core.QCoreApplication.translate("frmUsuarios", "Tipo de usuario", null));
        rbUserA.setText(com.trolltech.qt.core.QCoreApplication.translate("frmUsuarios", "Administrador", null));
        rbUserR.setText(com.trolltech.qt.core.QCoreApplication.translate("frmUsuarios", "Restringido", null));
        tabWidget.setTabText(tabWidget.indexOf(tab), com.trolltech.qt.core.QCoreApplication.translate("frmUsuarios", "Usuario", null));
        twAccesos.clear();
        twAccesos.setColumnCount(7);

        QTableWidgetItem __colItem = new QTableWidgetItem();
        __colItem.setText(com.trolltech.qt.core.QCoreApplication.translate("frmUsuarios", "Id", null));
        twAccesos.setHorizontalHeaderItem(0, __colItem);

        QTableWidgetItem __colItem1 = new QTableWidgetItem();
        __colItem1.setText(com.trolltech.qt.core.QCoreApplication.translate("frmUsuarios", "Opciones habilitadas", null));
        twAccesos.setHorizontalHeaderItem(1, __colItem1);

        QTableWidgetItem __colItem2 = new QTableWidgetItem();
        __colItem2.setText(com.trolltech.qt.core.QCoreApplication.translate("frmUsuarios", "L", null));
        twAccesos.setHorizontalHeaderItem(2, __colItem2);

        QTableWidgetItem __colItem3 = new QTableWidgetItem();
        __colItem3.setText(com.trolltech.qt.core.QCoreApplication.translate("frmUsuarios", "A", null));
        twAccesos.setHorizontalHeaderItem(3, __colItem3);

        QTableWidgetItem __colItem4 = new QTableWidgetItem();
        __colItem4.setText(com.trolltech.qt.core.QCoreApplication.translate("frmUsuarios", "M", null));
        twAccesos.setHorizontalHeaderItem(4, __colItem4);

        QTableWidgetItem __colItem5 = new QTableWidgetItem();
        __colItem5.setText(com.trolltech.qt.core.QCoreApplication.translate("frmUsuarios", "E", null));
        twAccesos.setHorizontalHeaderItem(5, __colItem5);

        QTableWidgetItem __colItem6 = new QTableWidgetItem();
        __colItem6.setText(com.trolltech.qt.core.QCoreApplication.translate("frmUsuarios", "I", null));
        twAccesos.setHorizontalHeaderItem(6, __colItem6);
        twAccesos.setRowCount(0);
        tbAdd.setText(com.trolltech.qt.core.QCoreApplication.translate("frmUsuarios", ">", null));
        tbDel.setText(com.trolltech.qt.core.QCoreApplication.translate("frmUsuarios", "<", null));
        gbPrivilegios.setTitle(com.trolltech.qt.core.QCoreApplication.translate("frmUsuarios", "Lectura - Privilegios", null));
        ckbAdd.setText(com.trolltech.qt.core.QCoreApplication.translate("frmUsuarios", "Agregar", null));
        ckbEdit.setText(com.trolltech.qt.core.QCoreApplication.translate("frmUsuarios", "Modificar", null));
        ckbDel.setText(com.trolltech.qt.core.QCoreApplication.translate("frmUsuarios", "Eliminar", null));
        ckbPrint.setText(com.trolltech.qt.core.QCoreApplication.translate("frmUsuarios", "Imprimir", null));
        twClases.clear();
        twClases.setColumnCount(2);

        QTableWidgetItem __colItem7 = new QTableWidgetItem();
        __colItem7.setText(com.trolltech.qt.core.QCoreApplication.translate("frmUsuarios", "Id", null));
        twClases.setHorizontalHeaderItem(0, __colItem7);

        QTableWidgetItem __colItem8 = new QTableWidgetItem();
        __colItem8.setText(com.trolltech.qt.core.QCoreApplication.translate("frmUsuarios", "Opciones Disponibles", null));
        twClases.setHorizontalHeaderItem(1, __colItem8);
        twClases.setRowCount(0);
        tabWidget.setTabText(tabWidget.indexOf(tab_2), com.trolltech.qt.core.QCoreApplication.translate("frmUsuarios", "Privilegios", null));
        twUsuarios.clear();
        twUsuarios.setColumnCount(9);

        QTableWidgetItem __colItem9 = new QTableWidgetItem();
        __colItem9.setText(com.trolltech.qt.core.QCoreApplication.translate("frmUsuarios", "ID", null));
        twUsuarios.setHorizontalHeaderItem(0, __colItem9);

        QTableWidgetItem __colItem10 = new QTableWidgetItem();
        __colItem10.setText(com.trolltech.qt.core.QCoreApplication.translate("frmUsuarios", "Cuenta", null));
        twUsuarios.setHorizontalHeaderItem(1, __colItem10);

        QTableWidgetItem __colItem11 = new QTableWidgetItem();
        __colItem11.setText(com.trolltech.qt.core.QCoreApplication.translate("frmUsuarios", "Nombre", null));
        twUsuarios.setHorizontalHeaderItem(2, __colItem11);

        QTableWidgetItem __colItem12 = new QTableWidgetItem();
        __colItem12.setText(com.trolltech.qt.core.QCoreApplication.translate("frmUsuarios", "A. Paterno", null));
        twUsuarios.setHorizontalHeaderItem(3, __colItem12);

        QTableWidgetItem __colItem13 = new QTableWidgetItem();
        __colItem13.setText(com.trolltech.qt.core.QCoreApplication.translate("frmUsuarios", "A. Materno", null));
        twUsuarios.setHorizontalHeaderItem(4, __colItem13);

        QTableWidgetItem __colItem14 = new QTableWidgetItem();
        __colItem14.setText(com.trolltech.qt.core.QCoreApplication.translate("frmUsuarios", "Descripci\u00f3n", null));
        twUsuarios.setHorizontalHeaderItem(5, __colItem14);

        QTableWidgetItem __colItem15 = new QTableWidgetItem();
        __colItem15.setText(com.trolltech.qt.core.QCoreApplication.translate("frmUsuarios", "F.U.A.", null));
        twUsuarios.setHorizontalHeaderItem(6, __colItem15);

        QTableWidgetItem __colItem16 = new QTableWidgetItem();
        __colItem16.setText(com.trolltech.qt.core.QCoreApplication.translate("frmUsuarios", "Tipo", null));
        twUsuarios.setHorizontalHeaderItem(7, __colItem16);

        QTableWidgetItem __colItem17 = new QTableWidgetItem();
        __colItem17.setText(com.trolltech.qt.core.QCoreApplication.translate("frmUsuarios", "Vigente", null));
        twUsuarios.setHorizontalHeaderItem(8, __colItem17);
        twUsuarios.setRowCount(0);
    } // retranslateUi

}

