/********************************************************************************
** Form generated from reading ui file 'frmPacientes.jui'
**
** Created: s�b nov 26 19:34:30 2011
**      by: Qt User Interface Compiler version 4.5.2
**
** WARNING! All changes made in this file will be lost when recompiling ui file!
********************************************************************************/

package com.eims.ris.gui;

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class Ui_frmPacientes implements com.trolltech.qt.QUiForm<QDialog>
{
    public QDateEdit deFNac;
    public QRadioButton rbSFem;
    public QLabel label_11;
    public QPushButton btnCerrar;
    public QLabel label_3;
    public QLineEdit leAMat;
    public QLabel label_10;
    public QComboBox cmbSSalud;
    public QLabel label_12;
    public QLabel label_7;
    public QLineEdit leNomb;
    public QLabel label_8;
    public QLabel label_5;
    public QLineEdit leRUN;
    public QLabel lblEdad;
    public QRadioButton rbSMas;
    public QLineEdit leFich;
    public QLineEdit leAPat;
    public QLineEdit leFon1;
    public QFrame frmUpdate;
    public QPushButton btnNuevo;
    public QPushButton btnGuardar;
    public QPushButton btnEliminar;
    public QTableWidget twPacientes;
    public QLineEdit leDire;
    public QCheckBox ckbFindHIS;
    public QLabel lblSSalud;
    public QPushButton btnFiltrar;
    public QLabel lblSBar;
    public QLabel label_4;
    public QLineEdit leMail;
    public QLineEdit leFon2;
    public QLabel label;
    public QLabel label_6;
    public QLabel label_9;
    public QPushButton btnAceptar;
    public QLabel label_2;
    public QLabel lblAccion;
    public QPushButton btnLimpiar;
    public QComboBox cmbCiud;
    public QLabel lblCiud;

    public Ui_frmPacientes() { super(); }

    public void setupUi(QDialog frmPacientes)
    {
        frmPacientes.setObjectName("frmPacientes");
        frmPacientes.resize(new QSize(640, 600).expandedTo(frmPacientes.minimumSizeHint()));
        QFont font = new QFont();
        frmPacientes.setFont(font);
        frmPacientes.setWindowIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/paci64.png")));
        deFNac = new QDateEdit(frmPacientes);
        deFNac.setObjectName("deFNac");
        deFNac.setGeometry(new QRect(92, 130, 101, 22));
        QFont font1 = new QFont();
        font1.setPointSize(8);
        deFNac.setFont(font1);
        deFNac.setDateTime(new QDateTime(new QDate(2010, 1, 1), new QTime(0, 0, 0)));
        deFNac.setCalendarPopup(true);
        rbSFem = new QRadioButton(frmPacientes);
        rbSFem.setObjectName("rbSFem");
        rbSFem.setGeometry(new QRect(300, 160, 81, 22));
        QFont font2 = new QFont();
        rbSFem.setFont(font2);
        label_11 = new QLabel(frmPacientes);
        label_11.setObjectName("label_11");
        label_11.setGeometry(new QRect(330, 220, 40, 16));
        QFont font3 = new QFont();
        label_11.setFont(font3);
        btnCerrar = new QPushButton(frmPacientes);
        btnCerrar.setObjectName("btnCerrar");
        btnCerrar.setGeometry(new QRect(570, 210, 60, 60));
        QFont font4 = new QFont();
        btnCerrar.setFont(font4);
        btnCerrar.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnCerrar.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/shutdown64.png")));
        btnCerrar.setIconSize(new QSize(48, 48));
        label_3 = new QLabel(frmPacientes);
        label_3.setObjectName("label_3");
        label_3.setGeometry(new QRect(10, 100, 26, 16));
        QFont font5 = new QFont();
        label_3.setFont(font5);
        leAMat = new QLineEdit(frmPacientes);
        leAMat.setObjectName("leAMat");
        leAMat.setGeometry(new QRect(390, 190, 151, 22));
        QFont font6 = new QFont();
        leAMat.setFont(font6);
        leAMat.setStyleSheet("background-color: rgba(9, 113, 174, 100);\n"+
"/*border: 1px solid rgba(9,100,150,200);*/");
        label_10 = new QLabel(frmPacientes);
        label_10.setObjectName("label_10");
        label_10.setGeometry(new QRect(170, 220, 41, 16));
        QFont font7 = new QFont();
        label_10.setFont(font7);
        cmbSSalud = new QComboBox(frmPacientes);
        cmbSSalud.setObjectName("cmbSSalud");
        cmbSSalud.setGeometry(new QRect(400, 250, 161, 22));
        QFont font8 = new QFont();
        cmbSSalud.setFont(font8);
        cmbSSalud.setMaxVisibleItems(20);
        label_12 = new QLabel(frmPacientes);
        label_12.setObjectName("label_12");
        label_12.setGeometry(new QRect(10, 280, 56, 16));
        QFont font9 = new QFont();
        label_12.setFont(font9);
        label_7 = new QLabel(frmPacientes);
        label_7.setObjectName("label_7");
        label_7.setGeometry(new QRect(10, 190, 98, 16));
        QFont font10 = new QFont();
        label_7.setFont(font10);
        leNomb = new QLineEdit(frmPacientes);
        leNomb.setObjectName("leNomb");
        leNomb.setGeometry(new QRect(70, 160, 201, 22));
        QFont font11 = new QFont();
        leNomb.setFont(font11);
        leNomb.setStyleSheet("background-color: rgba(9, 113, 174, 100);\n"+
"/*border: 1px solid rgba(9,100,150,200);*/");
        label_8 = new QLabel(frmPacientes);
        label_8.setObjectName("label_8");
        label_8.setGeometry(new QRect(280, 190, 102, 16));
        QFont font12 = new QFont();
        label_8.setFont(font12);
        label_5 = new QLabel(frmPacientes);
        label_5.setObjectName("label_5");
        label_5.setGeometry(new QRect(10, 130, 81, 16));
        QFont font13 = new QFont();
        label_5.setFont(font13);
        leRUN = new QLineEdit(frmPacientes);
        leRUN.setObjectName("leRUN");
        leRUN.setGeometry(new QRect(40, 100, 91, 22));
        QFont font14 = new QFont();
        font14.setBold(true);
        font14.setWeight(75);
        leRUN.setFont(font14);
        leRUN.setStyleSheet("background-color: rgba(9, 113, 174, 100);\n"+
"/*border: 1px solid rgba(9,100,150,200);*/");
        leRUN.setMaxLength(10);
        lblEdad = new QLabel(frmPacientes);
        lblEdad.setObjectName("lblEdad");
        lblEdad.setGeometry(new QRect(200, 130, 71, 22));
        QFont font15 = new QFont();
        font15.setPointSize(6);
        font15.setBold(true);
        font15.setWeight(75);
        lblEdad.setFont(font15);
        lblEdad.setStyleSheet("background-color: rgb(213, 234, 255);\n"+
"border:1px solid rgb(39, 146, 167);\n"+
"border-radius:4px;");
        rbSMas = new QRadioButton(frmPacientes);
        rbSMas.setObjectName("rbSMas");
        rbSMas.setGeometry(new QRect(300, 140, 82, 22));
        QFont font16 = new QFont();
        rbSMas.setFont(font16);
        rbSMas.setChecked(true);
        leFich = new QLineEdit(frmPacientes);
        leFich.setObjectName("leFich");
        leFich.setGeometry(new QRect(180, 100, 91, 22));
        QFont font17 = new QFont();
        font17.setBold(true);
        font17.setWeight(75);
        leFich.setFont(font17);
        leFich.setStyleSheet("background-color: rgba(9, 113, 174, 100);\n"+
"/*border: 1px solid rgba(9,100,150,200);*/");
        leFich.setMaxLength(10);
        leFich.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignRight,com.trolltech.qt.core.Qt.AlignmentFlag.AlignVCenter));
        leAPat = new QLineEdit(frmPacientes);
        leAPat.setObjectName("leAPat");
        leAPat.setGeometry(new QRect(110, 190, 161, 22));
        QFont font18 = new QFont();
        leAPat.setFont(font18);
        leAPat.setStyleSheet("background-color: rgba(9, 113, 174, 100);\n"+
"/*border: 1px solid rgba(9,100,150,200);*/");
        leFon1 = new QLineEdit(frmPacientes);
        leFon1.setObjectName("leFon1");
        leFon1.setGeometry(new QRect(60, 220, 101, 22));
        QFont font19 = new QFont();
        leFon1.setFont(font19);
        frmUpdate = new QFrame(frmPacientes);
        frmUpdate.setObjectName("frmUpdate");
        frmUpdate.setGeometry(new QRect(430, 90, 201, 91));
        QFont font20 = new QFont();
        frmUpdate.setFont(font20);
        frmUpdate.setStyleSheet("QFrame{\n"+
"	border:1px solid rgb(170, 170, 127);\n"+
"}");
        frmUpdate.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        frmUpdate.setFrameShadow(com.trolltech.qt.gui.QFrame.Shadow.Sunken);
        btnNuevo = new QPushButton(frmUpdate);
        btnNuevo.setObjectName("btnNuevo");
        btnNuevo.setGeometry(new QRect(10, 10, 81, 31));
        QFont font21 = new QFont();
        btnNuevo.setFont(font21);
        btnNuevo.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnNuevo.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/nuev48.png")));
        btnNuevo.setIconSize(new QSize(22, 22));
        btnGuardar = new QPushButton(frmUpdate);
        btnGuardar.setObjectName("btnGuardar");
        btnGuardar.setGeometry(new QRect(110, 10, 81, 31));
        QFont font22 = new QFont();
        btnGuardar.setFont(font22);
        btnGuardar.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnGuardar.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/save48.png")));
        btnGuardar.setIconSize(new QSize(22, 22));
        btnEliminar = new QPushButton(frmUpdate);
        btnEliminar.setObjectName("btnEliminar");
        btnEliminar.setGeometry(new QRect(110, 50, 81, 31));
        QFont font23 = new QFont();
        btnEliminar.setFont(font23);
        btnEliminar.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnEliminar.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/dele48.png")));
        btnEliminar.setIconSize(new QSize(22, 22));
        twPacientes = new QTableWidget(frmPacientes);
        twPacientes.setObjectName("twPacientes");
        twPacientes.setGeometry(new QRect(10, 310, 621, 261));
        QFont font24 = new QFont();
        twPacientes.setFont(font24);
        twPacientes.setStyleSheet("QTableWidget {\n"+
"     show-decoration-selected: 1;\n"+
"	alternate-background-color: rgb(247, 255, 193);\n"+
"}\n"+
"\n"+
"/*QTableWidget::item {\n"+
"     border: 0.05px solid #d9d9d9;\n"+
"    /* border-top-color: transparent;\n"+
"     border-bottom-color: transparent;\n"+
"	height: 18px;\n"+
"}*/\n"+
"\n"+
"QTableWidget::item:hover {\n"+
"     background: qlineargradient(x1: 0, y1: 0, x2: 0, y2: 1, stop: 0 #e7effd, stop: 1 #cbdaf1);\n"+
"     /*border: 1px solid #bfcde4;*/\n"+
"}\n"+
"\n"+
"/*QTableWidget::item:selected {\n"+
"     border: 0.5px solid #567dbc;\n"+
"}*/\n"+
"\n"+
"QTableWidget::item:selected:active{\n"+
"     background: qlineargradient(x1: 0, y1: 0, x2: 0, y2: 1, stop: 0 rgba(128, 163, 186, 150), stop: 1 rgba(87, 127, 191, 150));\n"+
"}\n"+
"\n"+
"QTableWidget::item:selected:!active {\n"+
"     background: qlineargradient(x1: 0, y1: 0, x2: 0, y2: 1, stop: 0 rgba(128, 163, 186, 150), stop: 1 rgba(87, 127, 191, 150));\n"+
"}");
        twPacientes.setEditTriggers(com.trolltech.qt.gui.QAbstractItemView.EditTrigger.createQFlags(com.trolltech.qt.gui.QAbstractItemView.EditTrigger.NoEditTriggers));
        twPacientes.setAlternatingRowColors(true);
        twPacientes.setSelectionMode(com.trolltech.qt.gui.QAbstractItemView.SelectionMode.SingleSelection);
        twPacientes.setSelectionBehavior(com.trolltech.qt.gui.QAbstractItemView.SelectionBehavior.SelectRows);
        twPacientes.setSortingEnabled(true);
        leDire = new QLineEdit(frmPacientes);
        leDire.setObjectName("leDire");
        leDire.setGeometry(new QRect(70, 280, 491, 22));
        QFont font25 = new QFont();
        leDire.setFont(font25);
        ckbFindHIS = new QCheckBox(frmPacientes);
        ckbFindHIS.setObjectName("ckbFindHIS");
        ckbFindHIS.setEnabled(false);
        ckbFindHIS.setGeometry(new QRect(280, 80, 125, 22));
        QFont font26 = new QFont();
        ckbFindHIS.setFont(font26);
        lblSSalud = new QLabel(frmPacientes);
        lblSSalud.setObjectName("lblSSalud");
        lblSSalud.setGeometry(new QRect(330, 250, 64, 16));
        QFont font27 = new QFont();
        lblSSalud.setFont(font27);
        btnFiltrar = new QPushButton(frmPacientes);
        btnFiltrar.setObjectName("btnFiltrar");
        btnFiltrar.setGeometry(new QRect(280, 100, 101, 31));
        QFont font28 = new QFont();
        btnFiltrar.setFont(font28);
        btnFiltrar.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnFiltrar.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/filter24.png")));
        btnFiltrar.setIconSize(new QSize(20, 20));
        lblSBar = new QLabel(frmPacientes);
        lblSBar.setObjectName("lblSBar");
        lblSBar.setGeometry(new QRect(10, 575, 621, 21));
        QFont font29 = new QFont();
        font29.setFamily("Calibri");
        font29.setPointSize(9);
        lblSBar.setFont(font29);
        lblSBar.setStyleSheet("/*background: qlineargradient(x1: 0, y1: 0, x2: 0, y2: 1, stop: 0 rgba(200, 200, 200, 255), stop: 0.5 rgba(200, 200, 200, 255), stop: 0.5 rgba(90, 90, 90, 255), stop: 1.0 rgba(90, 90, 90, 255));*/\n"+
"background-color: rgb(78, 78, 78);\n"+
"border:1px solid rgb(50, 50, 50);\n"+
"border-radius:4px;");
        label_4 = new QLabel(frmPacientes);
        label_4.setObjectName("label_4");
        label_4.setGeometry(new QRect(140, 100, 36, 16));
        QFont font30 = new QFont();
        label_4.setFont(font30);
        leMail = new QLineEdit(frmPacientes);
        leMail.setObjectName("leMail");
        leMail.setGeometry(new QRect(380, 220, 181, 22));
        QFont font31 = new QFont();
        leMail.setFont(font31);
        leFon2 = new QLineEdit(frmPacientes);
        leFon2.setObjectName("leFon2");
        leFon2.setGeometry(new QRect(220, 220, 101, 22));
        QFont font32 = new QFont();
        leFon2.setFont(font32);
        label = new QLabel(frmPacientes);
        label.setObjectName("label");
        label.setGeometry(new QRect(0, 0, 641, 91));
        QFont font33 = new QFont();
        label.setFont(font33);
        label.setStyleSheet("background-color: qlineargradient(spread:pad, x1:0, y1:0, x2:0, y2:1, stop:0 rgba(0, 50, 100, 255), stop:1 rgba(0, 0, 0, 0));");
        label.setPixmap(new QPixmap(("classpath:com/eims/ris/images/paci64.png")));
        label.setMargin(10);
        label_6 = new QLabel(frmPacientes);
        label_6.setObjectName("label_6");
        label_6.setGeometry(new QRect(10, 160, 54, 16));
        QFont font34 = new QFont();
        label_6.setFont(font34);
        label_9 = new QLabel(frmPacientes);
        label_9.setObjectName("label_9");
        label_9.setGeometry(new QRect(10, 220, 41, 16));
        QFont font35 = new QFont();
        label_9.setFont(font35);
        btnAceptar = new QPushButton(frmPacientes);
        btnAceptar.setObjectName("btnAceptar");
        btnAceptar.setGeometry(new QRect(470, 20, 161, 31));
        QFont font36 = new QFont();
        btnAceptar.setFont(font36);
        btnAceptar.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnAceptar.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/arrow_right22.png")));
        btnAceptar.setIconSize(new QSize(24, 24));
        label_2 = new QLabel(frmPacientes);
        label_2.setObjectName("label_2");
        label_2.setGeometry(new QRect(90, 10, 361, 53));
        QFont font37 = new QFont();
        label_2.setFont(font37);
        lblAccion = new QLabel(frmPacientes);
        lblAccion.setObjectName("lblAccion");
        lblAccion.setGeometry(new QRect(430, 70, 201, 22));
        QFont font38 = new QFont();
        lblAccion.setFont(font38);
        lblAccion.setStyleSheet("background-color: rgb(248, 255, 184);\n"+
"border:1px solid rgb(170, 170, 127);");
        lblAccion.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        lblAccion.setFrameShadow(com.trolltech.qt.gui.QFrame.Shadow.Sunken);
        btnLimpiar = new QPushButton(frmPacientes);
        btnLimpiar.setObjectName("btnLimpiar");
        btnLimpiar.setGeometry(new QRect(440, 140, 81, 31));
        QFont font39 = new QFont();
        btnLimpiar.setFont(font39);
        btnLimpiar.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnLimpiar.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/clear48.png")));
        btnLimpiar.setIconSize(new QSize(22, 22));
        cmbCiud = new QComboBox(frmPacientes);
        cmbCiud.setObjectName("cmbCiud");
        cmbCiud.setGeometry(new QRect(60, 250, 261, 22));
        QFont font40 = new QFont();
        cmbCiud.setFont(font40);
        lblCiud = new QLabel(frmPacientes);
        lblCiud.setObjectName("lblCiud");
        lblCiud.setGeometry(new QRect(10, 250, 53, 16));
        QFont font41 = new QFont();
        lblCiud.setFont(font41);
        QWidget.setTabOrder(leRUN, leFich);
        QWidget.setTabOrder(leFich, ckbFindHIS);
        QWidget.setTabOrder(ckbFindHIS, btnFiltrar);
        QWidget.setTabOrder(btnFiltrar, deFNac);
        QWidget.setTabOrder(deFNac, rbSMas);
        QWidget.setTabOrder(rbSMas, rbSFem);
        QWidget.setTabOrder(rbSFem, leNomb);
        QWidget.setTabOrder(leNomb, leAPat);
        QWidget.setTabOrder(leAPat, leAMat);
        QWidget.setTabOrder(leAMat, leFon1);
        QWidget.setTabOrder(leFon1, leFon2);
        QWidget.setTabOrder(leFon2, leMail);
        QWidget.setTabOrder(leMail, leDire);
        QWidget.setTabOrder(leDire, cmbSSalud);
        QWidget.setTabOrder(cmbSSalud, btnNuevo);
        QWidget.setTabOrder(btnNuevo, btnGuardar);
        QWidget.setTabOrder(btnGuardar, btnEliminar);
        QWidget.setTabOrder(btnEliminar, btnLimpiar);
        QWidget.setTabOrder(btnLimpiar, btnAceptar);
        QWidget.setTabOrder(btnAceptar, twPacientes);
        QWidget.setTabOrder(twPacientes, btnCerrar);
        retranslateUi(frmPacientes);
        btnCerrar.clicked.connect(frmPacientes, "reject()");
        btnAceptar.clicked.connect(frmPacientes, "accept()");

        frmPacientes.connectSlotsByName();
    } // setupUi

    void retranslateUi(QDialog frmPacientes)
    {
        frmPacientes.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("frmPacientes", "Archivo de pacientes", null));
        deFNac.setDisplayFormat(com.trolltech.qt.core.QCoreApplication.translate("frmPacientes", "dd-MM-yyyy", null));
        rbSFem.setText(com.trolltech.qt.core.QCoreApplication.translate("frmPacientes", "&Femenino", null));
        label_11.setText(com.trolltech.qt.core.QCoreApplication.translate("frmPacientes", "E-M@il", null));
        label_3.setText(com.trolltech.qt.core.QCoreApplication.translate("frmPacientes", "RUN", null));
        label_10.setText(com.trolltech.qt.core.QCoreApplication.translate("frmPacientes", "Fono 2", null));
        label_12.setText(com.trolltech.qt.core.QCoreApplication.translate("frmPacientes", "Direcci\u00f3n", null));
        label_7.setText(com.trolltech.qt.core.QCoreApplication.translate("frmPacientes", "Apellido paterno", null));
        label_8.setText(com.trolltech.qt.core.QCoreApplication.translate("frmPacientes", "Apellido materno", null));
        label_5.setText(com.trolltech.qt.core.QCoreApplication.translate("frmPacientes", "F. Nacimiento", null));
        lblEdad.setText("");
        rbSMas.setText(com.trolltech.qt.core.QCoreApplication.translate("frmPacientes", "&Masculino", null));
        btnNuevo.setText(com.trolltech.qt.core.QCoreApplication.translate("frmPacientes", "&Nuevo", null));
        btnGuardar.setText(com.trolltech.qt.core.QCoreApplication.translate("frmPacientes", "&Guardar", null));
        btnEliminar.setText(com.trolltech.qt.core.QCoreApplication.translate("frmPacientes", "&Eliminar", null));
        twPacientes.clear();
        twPacientes.setColumnCount(14);

        QTableWidgetItem __colItem = new QTableWidgetItem();
        __colItem.setText(com.trolltech.qt.core.QCoreApplication.translate("frmPacientes", "ID", null));
        twPacientes.setHorizontalHeaderItem(0, __colItem);

        QTableWidgetItem __colItem1 = new QTableWidgetItem();
        __colItem1.setText(com.trolltech.qt.core.QCoreApplication.translate("frmPacientes", "RUN", null));
        twPacientes.setHorizontalHeaderItem(1, __colItem1);

        QTableWidgetItem __colItem2 = new QTableWidgetItem();
        __colItem2.setText(com.trolltech.qt.core.QCoreApplication.translate("frmPacientes", "FICHA", null));
        twPacientes.setHorizontalHeaderItem(2, __colItem2);

        QTableWidgetItem __colItem3 = new QTableWidgetItem();
        __colItem3.setText(com.trolltech.qt.core.QCoreApplication.translate("frmPacientes", "A. Paterno", null));
        twPacientes.setHorizontalHeaderItem(3, __colItem3);

        QTableWidgetItem __colItem4 = new QTableWidgetItem();
        __colItem4.setText(com.trolltech.qt.core.QCoreApplication.translate("frmPacientes", "A. Materno", null));
        twPacientes.setHorizontalHeaderItem(4, __colItem4);

        QTableWidgetItem __colItem5 = new QTableWidgetItem();
        __colItem5.setText(com.trolltech.qt.core.QCoreApplication.translate("frmPacientes", "Nombres", null));
        twPacientes.setHorizontalHeaderItem(5, __colItem5);

        QTableWidgetItem __colItem6 = new QTableWidgetItem();
        __colItem6.setText(com.trolltech.qt.core.QCoreApplication.translate("frmPacientes", "Sexo", null));
        twPacientes.setHorizontalHeaderItem(6, __colItem6);

        QTableWidgetItem __colItem7 = new QTableWidgetItem();
        __colItem7.setText(com.trolltech.qt.core.QCoreApplication.translate("frmPacientes", "F. Nacimiento", null));
        twPacientes.setHorizontalHeaderItem(7, __colItem7);

        QTableWidgetItem __colItem8 = new QTableWidgetItem();
        __colItem8.setText(com.trolltech.qt.core.QCoreApplication.translate("frmPacientes", "Fono 1", null));
        twPacientes.setHorizontalHeaderItem(8, __colItem8);

        QTableWidgetItem __colItem9 = new QTableWidgetItem();
        __colItem9.setText(com.trolltech.qt.core.QCoreApplication.translate("frmPacientes", "Fono 2", null));
        twPacientes.setHorizontalHeaderItem(9, __colItem9);

        QTableWidgetItem __colItem10 = new QTableWidgetItem();
        __colItem10.setText(com.trolltech.qt.core.QCoreApplication.translate("frmPacientes", "E-M@il", null));
        twPacientes.setHorizontalHeaderItem(10, __colItem10);

        QTableWidgetItem __colItem11 = new QTableWidgetItem();
        __colItem11.setText(com.trolltech.qt.core.QCoreApplication.translate("frmPacientes", "Direcci\u00f3n", null));
        twPacientes.setHorizontalHeaderItem(11, __colItem11);

        QTableWidgetItem __colItem12 = new QTableWidgetItem();
        __colItem12.setText(com.trolltech.qt.core.QCoreApplication.translate("frmPacientes", "Ciudad", null));
        twPacientes.setHorizontalHeaderItem(12, __colItem12);

        QTableWidgetItem __colItem13 = new QTableWidgetItem();
        __colItem13.setText(com.trolltech.qt.core.QCoreApplication.translate("frmPacientes", "Sistema Salud", null));
        twPacientes.setHorizontalHeaderItem(13, __colItem13);
        twPacientes.setRowCount(0);
        ckbFindHIS.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("frmPacientes", "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0//EN\" \"http://www.w3.org/TR/REC-html40/strict.dtd\">\n"+
"<html><head><meta name=\"qrichtext\" content=\"1\" /><style type=\"text/css\">\n"+
"p, li { white-space: pre-wrap; }\n"+
"</style></head><body style=\" font-family:'MS Shell Dlg 2'; font-size:8.25pt; font-weight:400; font-style:normal;\">\n"+
"<p align=\"justify\" style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\">Si habilita la b\u00fasqueda en HIS, s\u00f3lo puede usar los campos de RUN y FICHA para buscar.</p></body></html>", null));
        ckbFindHIS.setText(com.trolltech.qt.core.QCoreApplication.translate("frmPacientes", "Consultar en HIS", null));
        lblSSalud.setText(com.trolltech.qt.core.QCoreApplication.translate("frmPacientes", "Sist. Salud", null));
        btnFiltrar.setText(com.trolltech.qt.core.QCoreApplication.translate("frmPacientes", "&Filtrar [F3]", null));
        btnFiltrar.setShortcut(com.trolltech.qt.core.QCoreApplication.translate("frmPacientes", "F3", null));
        lblSBar.setText(com.trolltech.qt.core.QCoreApplication.translate("frmPacientes", "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0//EN\" \"http://www.w3.org/TR/REC-html40/strict.dtd\">\n"+
"<html><head><meta name=\"qrichtext\" content=\"1\" /><style type=\"text/css\">\n"+
"p, li { white-space: pre-wrap; }\n"+
"</style></head><body style=\" font-family:'Calibri'; font-size:9pt; font-weight:400; font-style:normal;\">\n"+
"<p style=\"-qt-paragraph-type:empty; margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px; font-family:'MS Shell Dlg 2'; font-size:8pt;\"></p></body></html>", null));
        label_4.setText(com.trolltech.qt.core.QCoreApplication.translate("frmPacientes", "FICHA", null));
        label.setText("");
        label_6.setText(com.trolltech.qt.core.QCoreApplication.translate("frmPacientes", "Nombres", null));
        label_9.setText(com.trolltech.qt.core.QCoreApplication.translate("frmPacientes", "Fono 1", null));
        btnAceptar.setText(com.trolltech.qt.core.QCoreApplication.translate("frmPacientes", "&Aceptar Paciente [F5]", null));
        btnAceptar.setShortcut(com.trolltech.qt.core.QCoreApplication.translate("frmPacientes", "F5", null));
        label_2.setText(com.trolltech.qt.core.QCoreApplication.translate("frmPacientes", "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0//EN\" \"http://www.w3.org/TR/REC-html40/strict.dtd\">\n"+
"<html><head><meta name=\"qrichtext\" content=\"1\" /><style type=\"text/css\">\n"+
"p, li { white-space: pre-wrap; }\n"+
"</style></head><body style=\" font-family:'Ubuntu'; font-size:9pt; font-weight:400; font-style:normal;\">\n"+
"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-family:'Calibri'; font-size:20pt;\">ARCHIVO DE PACIENTES</span></p>\n"+
"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-family:'Calibri'; font-size:10pt;\">Aqu\u00ed podr\u00e1 buscar, agregar, editar o eliminar pacientes.</span></p></body></html>", null));
        lblAccion.setText("");
        btnLimpiar.setText(com.trolltech.qt.core.QCoreApplication.translate("frmPacientes", "&Limpiar", null));
        lblCiud.setText(com.trolltech.qt.core.QCoreApplication.translate("frmPacientes", "Ciudad", null));
    } // retranslateUi

}

