/********************************************************************************
** Form generated from reading ui file 'frmRecepciones.jui'
**
** Created: mi� nov 30 20:07:36 2011
**      by: Qt User Interface Compiler version 4.5.2
**
** WARNING! All changes made in this file will be lost when recompiling ui file!
********************************************************************************/

package com.eims.ris.gui;

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class Ui_frmRecepciones implements com.trolltech.qt.QUiForm<QDialog>
{
    public QPushButton btnNuevo;
    public QPushButton btnGuardar;
    public QGroupBox gbDeta;
    public QLabel label_18;
    public QLabel label_19;
    public QLabel label_21;
    public QLineEdit lePrest;
    public QComboBox cmbToma;
    public QPushButton btnDNuevo;
    public QPushButton btnDEditar;
    public QPushButton btnDGuardar;
    public QPushButton btnDEliminar;
    public QPushButton btnDCancelar;
    public QSpinBox sbCant;
    public QGroupBox gbHecho;
    public QDateTimeEdit dteHecho;
    public QPushButton btnMFunc;
    public QComboBox cmbPres;
    public QTableWidget twPrestaciones;
    public QPushButton btnImprimir;
    public QPushButton btnMBRec;
    public QGroupBox gbEnca;
    public QLabel label;
    public QLabel label_2;
    public QLabel label_3;
    public QLabel label_4;
    public QLabel label_5;
    public QLabel lblNombre;
    public QGroupBox groupBox_3;
    public QComboBox cmbTRec;
    public QLabel label_7;
    public QLabel label_8;
    public QLabel label_9;
    public QLabel label_10;
    public QLabel label_11;
    public QLabel label_13;
    public QCheckBox checkBox;
    public QLineEdit leRUN;
    public QLineEdit leDAU;
    public QPushButton btnMPaci;
    public QLineEdit lePaci;
    public QLineEdit leFono;
    public QLabel leEdad;
    public QLabel leSexo;
    public QComboBox cmbDeri;
    public QComboBox cmbSSal;
    public QPushButton btnMDeri;
    public QPushButton btnMSSal;
    public QComboBox cmbNUrg;
    public QLineEdit leObse;
    public QLabel label_16;
    public QLabel label_17;
    public QLineEdit leFich;
    public QLineEdit leCCte;
    public QLabel lblDigi;
    public QLabel label_22;
    public QComboBox cmbTDer;
    public QLabel lblFHCit;
    public QLabel label_14;
    public QComboBox cmbRF;
    public QComboBox cmbResp;
    public QLabel label_15;
    public QLabel label_20;
    public QComboBox cmbERec;
    public QLabel label_12;
    public QLabel lblApat;
    public QLabel lblAmat;
    public QLineEdit leAPat;
    public QLineEdit leAMat;
    public QLineEdit leCiud;
    public QLabel lblCiud;
    public QDateTimeEdit dteFeHo;
    public QPushButton btnMBPac;
    public QPushButton btnClose;
    public QLabel lblStat;
    public QLineEdit leID;

    public Ui_frmRecepciones() { super(); }

    public void setupUi(QDialog frmRecepciones)
    {
        frmRecepciones.setObjectName("frmRecepciones");
        frmRecepciones.resize(new QSize(800, 600).expandedTo(frmRecepciones.minimumSizeHint()));
        frmRecepciones.setMinimumSize(new QSize(800, 600));
        frmRecepciones.setMaximumSize(new QSize(800, 600));
        frmRecepciones.setWindowIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/recep64.png")));
        btnNuevo = new QPushButton(frmRecepciones);
        btnNuevo.setObjectName("btnNuevo");
        btnNuevo.setEnabled(false);
        btnNuevo.setGeometry(new QRect(270, 10, 111, 60));
        QFont font = new QFont();
        font.setPointSize(8);
        btnNuevo.setFont(font);
        btnNuevo.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnNuevo.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/nuev48.png")));
        btnNuevo.setIconSize(new QSize(48, 48));
        btnGuardar = new QPushButton(frmRecepciones);
        btnGuardar.setObjectName("btnGuardar");
        btnGuardar.setEnabled(false);
        btnGuardar.setGeometry(new QRect(390, 10, 111, 60));
        QFont font1 = new QFont();
        font1.setPointSize(8);
        btnGuardar.setFont(font1);
        btnGuardar.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnGuardar.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/save48.png")));
        btnGuardar.setIconSize(new QSize(48, 48));
        gbDeta = new QGroupBox(frmRecepciones);
        gbDeta.setObjectName("gbDeta");
        gbDeta.setGeometry(new QRect(10, 370, 781, 221));
        QFont font2 = new QFont();
        font2.setFamily("Sans Serif");
        gbDeta.setFont(font2);
        label_18 = new QLabel(gbDeta);
        label_18.setObjectName("label_18");
        label_18.setGeometry(new QRect(10, 20, 62, 16));
        QFont font3 = new QFont();
        label_18.setFont(font3);
        label_19 = new QLabel(gbDeta);
        label_19.setObjectName("label_19");
        label_19.setGeometry(new QRect(558, 20, 7, 14));
        QFont font4 = new QFont();
        font4.setBold(true);
        font4.setWeight(75);
        label_19.setFont(font4);
        label_21 = new QLabel(gbDeta);
        label_21.setObjectName("label_21");
        label_21.setGeometry(new QRect(10, 50, 121, 16));
        QFont font5 = new QFont();
        label_21.setFont(font5);
        lePrest = new QLineEdit(gbDeta);
        lePrest.setObjectName("lePrest");
        lePrest.setGeometry(new QRect(80, 20, 81, 22));
        QFont font6 = new QFont();
        lePrest.setFont(font6);
        lePrest.setMaxLength(20);
        cmbToma = new QComboBox(gbDeta);
        cmbToma.setObjectName("cmbToma");
        cmbToma.setGeometry(new QRect(140, 50, 351, 22));
        QFont font7 = new QFont();
        cmbToma.setFont(font7);
        cmbToma.setMaxVisibleItems(20);
        btnDNuevo = new QPushButton(gbDeta);
        btnDNuevo.setObjectName("btnDNuevo");
        btnDNuevo.setEnabled(false);
        btnDNuevo.setGeometry(new QRect(10, 76, 91, 30));
        QFont font8 = new QFont();
        btnDNuevo.setFont(font8);
        btnDNuevo.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnDNuevo.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/nuev48.png")));
        btnDNuevo.setIconSize(new QSize(20, 20));
        btnDEditar = new QPushButton(gbDeta);
        btnDEditar.setObjectName("btnDEditar");
        btnDEditar.setEnabled(false);
        btnDEditar.setGeometry(new QRect(110, 76, 91, 30));
        QFont font9 = new QFont();
        btnDEditar.setFont(font9);
        btnDEditar.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnDEditar.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/edit48.png")));
        btnDEditar.setIconSize(new QSize(20, 20));
        btnDGuardar = new QPushButton(gbDeta);
        btnDGuardar.setObjectName("btnDGuardar");
        btnDGuardar.setEnabled(false);
        btnDGuardar.setGeometry(new QRect(210, 76, 91, 30));
        QFont font10 = new QFont();
        btnDGuardar.setFont(font10);
        btnDGuardar.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnDGuardar.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/save48.png")));
        btnDGuardar.setIconSize(new QSize(20, 20));
        btnDEliminar = new QPushButton(gbDeta);
        btnDEliminar.setObjectName("btnDEliminar");
        btnDEliminar.setEnabled(false);
        btnDEliminar.setGeometry(new QRect(310, 76, 91, 30));
        QFont font11 = new QFont();
        btnDEliminar.setFont(font11);
        btnDEliminar.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnDEliminar.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/dele48.png")));
        btnDEliminar.setIconSize(new QSize(20, 20));
        btnDCancelar = new QPushButton(gbDeta);
        btnDCancelar.setObjectName("btnDCancelar");
        btnDCancelar.setEnabled(false);
        btnDCancelar.setGeometry(new QRect(540, 76, 91, 30));
        QFont font12 = new QFont();
        btnDCancelar.setFont(font12);
        btnDCancelar.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnDCancelar.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/undo24.png")));
        btnDCancelar.setIconSize(new QSize(20, 20));
        sbCant = new QSpinBox(gbDeta);
        sbCant.setObjectName("sbCant");
        sbCant.setGeometry(new QRect(570, 20, 42, 22));
        QFont font13 = new QFont();
        sbCant.setFont(font13);
        sbCant.setMinimum(1);
        gbHecho = new QGroupBox(gbDeta);
        gbHecho.setObjectName("gbHecho");
        gbHecho.setGeometry(new QRect(620, 20, 151, 51));
        QFont font14 = new QFont();
        gbHecho.setFont(font14);
        gbHecho.setCheckable(true);
        gbHecho.setChecked(false);
        dteHecho = new QDateTimeEdit(gbHecho);
        dteHecho.setObjectName("dteHecho");
        dteHecho.setGeometry(new QRect(10, 20, 131, 22));
        QFont font15 = new QFont();
        font15.setPointSize(8);
        dteHecho.setFont(font15);
        dteHecho.setDate(new QDate(2011, 12, 1));
        dteHecho.setCalendarPopup(true);
        btnMFunc = new QPushButton(gbDeta);
        btnMFunc.setObjectName("btnMFunc");
        btnMFunc.setEnabled(false);
        btnMFunc.setGeometry(new QRect(500, 50, 31, 31));
        QFont font16 = new QFont();
        btnMFunc.setFont(font16);
        btnMFunc.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnMFunc.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/func64.png")));
        btnMFunc.setIconSize(new QSize(24, 24));
        cmbPres = new QComboBox(gbDeta);
        cmbPres.setObjectName("cmbPres");
        cmbPres.setGeometry(new QRect(170, 20, 381, 22));
        QFont font17 = new QFont();
        cmbPres.setFont(font17);
        cmbPres.setMaxVisibleItems(26);
        twPrestaciones = new QTableWidget(gbDeta);
        twPrestaciones.setObjectName("twPrestaciones");
        twPrestaciones.setGeometry(new QRect(10, 110, 761, 101));
        QFont font18 = new QFont();
        twPrestaciones.setFont(font18);
        twPrestaciones.setStyleSheet("QTableWidget {\n"+
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
        twPrestaciones.setEditTriggers(com.trolltech.qt.gui.QAbstractItemView.EditTrigger.createQFlags(com.trolltech.qt.gui.QAbstractItemView.EditTrigger.NoEditTriggers));
        twPrestaciones.setAlternatingRowColors(true);
        twPrestaciones.setSelectionMode(com.trolltech.qt.gui.QAbstractItemView.SelectionMode.SingleSelection);
        twPrestaciones.setSelectionBehavior(com.trolltech.qt.gui.QAbstractItemView.SelectionBehavior.SelectRows);
        btnImprimir = new QPushButton(frmRecepciones);
        btnImprimir.setObjectName("btnImprimir");
        btnImprimir.setEnabled(false);
        btnImprimir.setGeometry(new QRect(510, 10, 111, 60));
        QFont font19 = new QFont();
        font19.setPointSize(8);
        btnImprimir.setFont(font19);
        btnImprimir.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnImprimir.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/print48.png")));
        btnImprimir.setIconSize(new QSize(48, 48));
        btnMBRec = new QPushButton(frmRecepciones);
        btnMBRec.setObjectName("btnMBRec");
        btnMBRec.setEnabled(false);
        btnMBRec.setGeometry(new QRect(140, 10, 121, 60));
        QFont font20 = new QFont();
        font20.setPointSize(8);
        btnMBRec.setFont(font20);
        btnMBRec.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnMBRec.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/search64.png")));
        btnMBRec.setIconSize(new QSize(48, 48));
        gbEnca = new QGroupBox(frmRecepciones);
        gbEnca.setObjectName("gbEnca");
        gbEnca.setGeometry(new QRect(10, 80, 781, 271));
        QFont font21 = new QFont();
        font21.setFamily("Sans Serif");
        gbEnca.setFont(font21);
        label = new QLabel(gbEnca);
        label.setObjectName("label");
        label.setGeometry(new QRect(10, 40, 25, 16));
        QFont font22 = new QFont();
        label.setFont(font22);
        label_2 = new QLabel(gbEnca);
        label_2.setObjectName("label_2");
        label_2.setGeometry(new QRect(180, 20, 35, 16));
        QFont font23 = new QFont();
        label_2.setFont(font23);
        label_3 = new QLabel(gbEnca);
        label_3.setObjectName("label_3");
        label_3.setGeometry(new QRect(260, 20, 28, 16));
        QFont font24 = new QFont();
        label_3.setFont(font24);
        label_4 = new QLabel(gbEnca);
        label_4.setObjectName("label_4");
        label_4.setGeometry(new QRect(10, 80, 26, 16));
        QFont font25 = new QFont();
        label_4.setFont(font25);
        label_5 = new QLabel(gbEnca);
        label_5.setObjectName("label_5");
        label_5.setGeometry(new QRect(150, 80, 26, 16));
        QFont font26 = new QFont();
        label_5.setFont(font26);
        lblNombre = new QLabel(gbEnca);
        lblNombre.setObjectName("lblNombre");
        lblNombre.setGeometry(new QRect(10, 110, 50, 16));
        QFont font27 = new QFont();
        lblNombre.setFont(font27);
        groupBox_3 = new QGroupBox(gbEnca);
        groupBox_3.setObjectName("groupBox_3");
        groupBox_3.setGeometry(new QRect(590, 20, 181, 71));
        QFont font28 = new QFont();
        groupBox_3.setFont(font28);
        cmbTRec = new QComboBox(gbEnca);
        cmbTRec.setObjectName("cmbTRec");
        cmbTRec.setGeometry(new QRect(40, 40, 111, 22));
        QFont font29 = new QFont();
        cmbTRec.setFont(font29);
        label_7 = new QLabel(gbEnca);
        label_7.setObjectName("label_7");
        label_7.setGeometry(new QRect(650, 94, 31, 16));
        QFont font30 = new QFont();
        label_7.setFont(font30);
        label_8 = new QLabel(gbEnca);
        label_8.setObjectName("label_8");
        label_8.setGeometry(new QRect(730, 94, 29, 16));
        QFont font31 = new QFont();
        label_8.setFont(font31);
        label_9 = new QLabel(gbEnca);
        label_9.setObjectName("label_9");
        label_9.setGeometry(new QRect(400, 230, 58, 16));
        QFont font32 = new QFont();
        label_9.setFont(font32);
        label_10 = new QLabel(gbEnca);
        label_10.setObjectName("label_10");
        label_10.setGeometry(new QRect(10, 200, 86, 16));
        QFont font33 = new QFont();
        label_10.setFont(font33);
        label_11 = new QLabel(gbEnca);
        label_11.setObjectName("label_11");
        label_11.setGeometry(new QRect(10, 170, 87, 16));
        QFont font34 = new QFont();
        label_11.setFont(font34);
        label_13 = new QLabel(gbEnca);
        label_13.setObjectName("label_13");
        label_13.setGeometry(new QRect(10, 232, 27, 16));
        QFont font35 = new QFont();
        label_13.setFont(font35);
        checkBox = new QCheckBox(gbEnca);
        checkBox.setObjectName("checkBox");
        checkBox.setEnabled(false);
        checkBox.setGeometry(new QRect(158, 40, 16, 16));
        QFont font36 = new QFont();
        checkBox.setFont(font36);
        leRUN = new QLineEdit(gbEnca);
        leRUN.setObjectName("leRUN");
        leRUN.setGeometry(new QRect(40, 80, 91, 22));
        QFont font37 = new QFont();
        font37.setBold(true);
        font37.setWeight(75);
        leRUN.setFont(font37);
        leRUN.setStyleSheet("background-color: rgba(9, 113, 174, 100);");
        leRUN.setMaxLength(10);
        leDAU = new QLineEdit(gbEnca);
        leDAU.setObjectName("leDAU");
        leDAU.setGeometry(new QRect(180, 80, 51, 22));
        QFont font38 = new QFont();
        font38.setBold(true);
        font38.setWeight(75);
        leDAU.setFont(font38);
        leDAU.setStyleSheet("background-color: rgba(9, 113, 174, 80);");
        leDAU.setMaxLength(6);
        btnMPaci = new QPushButton(gbEnca);
        btnMPaci.setObjectName("btnMPaci");
        btnMPaci.setEnabled(false);
        btnMPaci.setGeometry(new QRect(460, 30, 110, 41));
        QFont font39 = new QFont();
        btnMPaci.setFont(font39);
        btnMPaci.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnMPaci.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/paci64.png")));
        btnMPaci.setIconSize(new QSize(32, 32));
        lePaci = new QLineEdit(gbEnca);
        lePaci.setObjectName("lePaci");
        lePaci.setGeometry(new QRect(70, 110, 301, 22));
        QFont font40 = new QFont();
        font40.setFamily("Arial");
        font40.setPointSize(10);
        font40.setBold(true);
        font40.setWeight(75);
        lePaci.setFont(font40);
        lePaci.setStyleSheet("background-color: rgb(213, 234, 255);\n"+
"border:1px solid rgb(39, 146, 167);\n"+
"border-radius:4px;");
        lePaci.setReadOnly(true);
        leFono = new QLineEdit(gbEnca);
        leFono.setObjectName("leFono");
        leFono.setGeometry(new QRect(450, 110, 161, 22));
        QFont font41 = new QFont();
        font41.setBold(true);
        font41.setWeight(75);
        leFono.setFont(font41);
        leFono.setStyleSheet("");
        leFono.setMaxLength(40);
        leEdad = new QLabel(gbEnca);
        leEdad.setObjectName("leEdad");
        leEdad.setGeometry(new QRect(620, 110, 91, 22));
        QFont font42 = new QFont();
        font42.setBold(true);
        font42.setWeight(75);
        leEdad.setFont(font42);
        leEdad.setStyleSheet("background-color: rgb(213, 234, 255);\n"+
"border:1px solid rgb(39, 146, 167);\n"+
"border-radius:4px;");
        leSexo = new QLabel(gbEnca);
        leSexo.setObjectName("leSexo");
        leSexo.setGeometry(new QRect(720, 110, 46, 22));
        QFont font43 = new QFont();
        font43.setBold(true);
        font43.setWeight(75);
        leSexo.setFont(font43);
        leSexo.setStyleSheet("background-color: rgb(213, 234, 255);\n"+
"border:1px solid rgb(39, 146, 167);\n"+
"border-radius:4px;");
        cmbDeri = new QComboBox(gbEnca);
        cmbDeri.setObjectName("cmbDeri");
        cmbDeri.setGeometry(new QRect(530, 232, 211, 22));
        QFont font44 = new QFont();
        cmbDeri.setFont(font44);
        cmbDeri.setMaxVisibleItems(21);
        cmbSSal = new QComboBox(gbEnca);
        cmbSSal.setObjectName("cmbSSal");
        cmbSSal.setGeometry(new QRect(100, 200, 241, 22));
        QFont font45 = new QFont();
        cmbSSal.setFont(font45);
        cmbSSal.setMaxVisibleItems(24);
        btnMDeri = new QPushButton(gbEnca);
        btnMDeri.setObjectName("btnMDeri");
        btnMDeri.setEnabled(false);
        btnMDeri.setGeometry(new QRect(740, 232, 31, 31));
        QFont font46 = new QFont();
        btnMDeri.setFont(font46);
        btnMDeri.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnMDeri.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/local64.png")));
        btnMDeri.setIconSize(new QSize(24, 24));
        btnMSSal = new QPushButton(gbEnca);
        btnMSSal.setObjectName("btnMSSal");
        btnMSSal.setEnabled(false);
        btnMSSal.setGeometry(new QRect(350, 200, 31, 31));
        QFont font47 = new QFont();
        btnMSSal.setFont(font47);
        btnMSSal.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnMSSal.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/salud64.png")));
        btnMSSal.setIconSize(new QSize(24, 24));
        cmbNUrg = new QComboBox(gbEnca);
        cmbNUrg.setObjectName("cmbNUrg");
        cmbNUrg.setGeometry(new QRect(100, 170, 181, 22));
        QFont font48 = new QFont();
        cmbNUrg.setFont(font48);
        cmbNUrg.setMaxVisibleItems(20);
        leObse = new QLineEdit(gbEnca);
        leObse.setObjectName("leObse");
        leObse.setGeometry(new QRect(40, 232, 351, 22));
        QFont font49 = new QFont();
        leObse.setFont(font49);
        leObse.setMaxLength(100);
        label_16 = new QLabel(gbEnca);
        label_16.setObjectName("label_16");
        label_16.setGeometry(new QRect(250, 80, 36, 16));
        QFont font50 = new QFont();
        label_16.setFont(font50);
        label_17 = new QLabel(gbEnca);
        label_17.setObjectName("label_17");
        label_17.setGeometry(new QRect(390, 80, 57, 16));
        QFont font51 = new QFont();
        label_17.setFont(font51);
        leFich = new QLineEdit(gbEnca);
        leFich.setObjectName("leFich");
        leFich.setGeometry(new QRect(290, 80, 81, 20));
        QFont font52 = new QFont();
        font52.setBold(true);
        font52.setWeight(75);
        leFich.setFont(font52);
        leFich.setStyleSheet("background-color: rgba(9, 113, 174, 100);");
        leFich.setMaxLength(10);
        leCCte = new QLineEdit(gbEnca);
        leCCte.setObjectName("leCCte");
        leCCte.setGeometry(new QRect(450, 80, 81, 20));
        QFont font53 = new QFont();
        font53.setBold(true);
        font53.setWeight(75);
        leCCte.setFont(font53);
        leCCte.setStyleSheet("background-color: rgba(9, 113, 174, 100);");
        leCCte.setMaxLength(10);
        lblDigi = new QLabel(gbEnca);
        lblDigi.setObjectName("lblDigi");
        lblDigi.setGeometry(new QRect(350, 40, 101, 31));
        QFont font54 = new QFont();
        font54.setPointSize(8);
        lblDigi.setFont(font54);
        lblDigi.setStyleSheet("background-color: rgb(213, 234, 255);\n"+
"border:1px solid rgb(39, 146, 167);\n"+
"border-radius:4px;");
        lblDigi.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));
        label_22 = new QLabel(gbEnca);
        label_22.setObjectName("label_22");
        label_22.setGeometry(new QRect(370, 20, 50, 16));
        QFont font55 = new QFont();
        label_22.setFont(font55);
        cmbTDer = new QComboBox(gbEnca);
        cmbTDer.setObjectName("cmbTDer");
        cmbTDer.setGeometry(new QRect(460, 232, 61, 22));
        QFont font56 = new QFont();
        cmbTDer.setFont(font56);
        cmbTDer.setMaxVisibleItems(24);
        lblFHCit = new QLabel(gbEnca);
        lblFHCit.setObjectName("lblFHCit");
        lblFHCit.setGeometry(new QRect(670, 140, 101, 22));
        QFont font57 = new QFont();
        font57.setPointSize(7);
        lblFHCit.setFont(font57);
        lblFHCit.setStyleSheet("background-color: rgba(85, 170, 255,200);\n"+
"border:1px solid rgb(39, 146, 167);\n"+
"border-radius:4px;");
        lblFHCit.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));
        label_14 = new QLabel(gbEnca);
        label_14.setObjectName("label_14");
        label_14.setGeometry(new QRect(620, 140, 48, 16));
        QFont font58 = new QFont();
        label_14.setFont(font58);
        cmbRF = new QComboBox(gbEnca);
        cmbRF.setObjectName("cmbRF");
        cmbRF.setGeometry(new QRect(490, 174, 281, 22));
        QFont font59 = new QFont();
        cmbRF.setFont(font59);
        cmbRF.setMaxVisibleItems(17);
        cmbResp = new QComboBox(gbEnca);
        cmbResp.setObjectName("cmbResp");
        cmbResp.setGeometry(new QRect(490, 200, 281, 22));
        QFont font60 = new QFont();
        cmbResp.setFont(font60);
        cmbResp.setMaxVisibleItems(19);
        label_15 = new QLabel(gbEnca);
        label_15.setObjectName("label_15");
        label_15.setGeometry(new QRect(400, 170, 25, 16));
        QFont font61 = new QFont();
        label_15.setFont(font61);
        label_20 = new QLabel(gbEnca);
        label_20.setObjectName("label_20");
        label_20.setGeometry(new QRect(400, 200, 74, 16));
        QFont font62 = new QFont();
        label_20.setFont(font62);
        cmbERec = new QComboBox(gbEnca);
        cmbERec.setObjectName("cmbERec");
        cmbERec.setGeometry(new QRect(660, 15, 101, 22));
        label_12 = new QLabel(gbEnca);
        label_12.setObjectName("label_12");
        label_12.setGeometry(new QRect(390, 110, 54, 16));
        lblApat = new QLabel(gbEnca);
        lblApat.setObjectName("lblApat");
        lblApat.setGeometry(new QRect(10, 140, 53, 16));
        lblAmat = new QLabel(gbEnca);
        lblAmat.setObjectName("lblAmat");
        lblAmat.setGeometry(new QRect(200, 140, 53, 16));
        leAPat = new QLineEdit(gbEnca);
        leAPat.setObjectName("leAPat");
        leAPat.setGeometry(new QRect(60, 140, 131, 22));
        QFont font63 = new QFont();
        font63.setFamily("Arial");
        font63.setPointSize(10);
        font63.setBold(true);
        font63.setWeight(75);
        leAPat.setFont(font63);
        leAPat.setStyleSheet("background-color: rgb(213, 234, 255);\n"+
"border:1px solid rgb(39, 146, 167);\n"+
"border-radius:4px;");
        leAPat.setReadOnly(true);
        leAMat = new QLineEdit(gbEnca);
        leAMat.setObjectName("leAMat");
        leAMat.setGeometry(new QRect(250, 140, 141, 22));
        QFont font64 = new QFont();
        font64.setFamily("Arial");
        font64.setPointSize(10);
        font64.setBold(true);
        font64.setWeight(75);
        leAMat.setFont(font64);
        leAMat.setStyleSheet("background-color: rgb(213, 234, 255);\n"+
"border:1px solid rgb(39, 146, 167);\n"+
"border-radius:4px;");
        leAMat.setReadOnly(true);
        leCiud = new QLineEdit(gbEnca);
        leCiud.setObjectName("leCiud");
        leCiud.setGeometry(new QRect(460, 140, 141, 22));
        QFont font65 = new QFont();
        font65.setFamily("Arial");
        font65.setPointSize(10);
        font65.setBold(true);
        font65.setWeight(75);
        leCiud.setFont(font65);
        leCiud.setStyleSheet("background-color: rgb(213, 234, 255);\n"+
"border:1px solid rgb(39, 146, 167);\n"+
"border-radius:4px;");
        leCiud.setReadOnly(true);
        lblCiud = new QLabel(gbEnca);
        lblCiud.setObjectName("lblCiud");
        lblCiud.setGeometry(new QRect(400, 140, 53, 16));
        lblCiud.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.NoFrame);
        dteFeHo = new QDateTimeEdit(gbEnca);
        dteFeHo.setObjectName("dteFeHo");
        dteFeHo.setGeometry(new QRect(180, 40, 161, 25));
        dteFeHo.setDate(new QDate(2011, 12, 1));
        dteFeHo.setCalendarPopup(true);
        btnMBPac = new QPushButton(frmRecepciones);
        btnMBPac.setObjectName("btnMBPac");
        btnMBPac.setEnabled(false);
        btnMBPac.setGeometry(new QRect(10, 10, 121, 60));
        QFont font66 = new QFont();
        font66.setPointSize(8);
        btnMBPac.setFont(font66);
        btnMBPac.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnMBPac.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/bpac64.png")));
        btnMBPac.setIconSize(new QSize(48, 48));
        btnClose = new QPushButton(frmRecepciones);
        btnClose.setObjectName("btnClose");
        btnClose.setGeometry(new QRect(730, 10, 60, 60));
        QFont font67 = new QFont();
        btnClose.setFont(font67);
        btnClose.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnClose.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/shutdown64.png")));
        btnClose.setIconSize(new QSize(48, 48));
        lblStat = new QLabel(frmRecepciones);
        lblStat.setObjectName("lblStat");
        lblStat.setGeometry(new QRect(630, 40, 91, 31));
        QFont font68 = new QFont();
        lblStat.setFont(font68);
        lblStat.setStyleSheet("background-color: rgb(248, 255, 184);\n"+
"border:1px solid rgb(170, 170, 127);\n"+
"border-radius:4px;");
        lblStat.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));
        leID = new QLineEdit(frmRecepciones);
        leID.setObjectName("leID");
        leID.setGeometry(new QRect(610, 120, 161, 41));
        QFont font69 = new QFont();
        font69.setFamily("Arial");
        font69.setPointSize(19);
        leID.setFont(font69);
        leID.setStyleSheet("border:1px solid rgb(50, 50, 50);\n"+
"background-color: rgb(78, 78, 78);\n"+
"color: rgb(230, 230, 230);");
        leID.setMaxLength(10);
        leID.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignRight,com.trolltech.qt.core.Qt.AlignmentFlag.AlignVCenter));
        QWidget.setTabOrder(btnMBPac, btnMBRec);
        QWidget.setTabOrder(btnMBRec, btnNuevo);
        QWidget.setTabOrder(btnNuevo, btnGuardar);
        QWidget.setTabOrder(btnGuardar, btnImprimir);
        QWidget.setTabOrder(btnImprimir, btnClose);
        QWidget.setTabOrder(btnClose, cmbTRec);
        QWidget.setTabOrder(cmbTRec, checkBox);
        QWidget.setTabOrder(checkBox, dteFeHo);
        QWidget.setTabOrder(dteFeHo, leRUN);
        QWidget.setTabOrder(leRUN, leDAU);
        QWidget.setTabOrder(leDAU, leFich);
        QWidget.setTabOrder(leFich, leCCte);
        QWidget.setTabOrder(leCCte, btnMPaci);
        QWidget.setTabOrder(btnMPaci, leFono);
        QWidget.setTabOrder(leFono, cmbNUrg);
        QWidget.setTabOrder(cmbNUrg, cmbRF);
        QWidget.setTabOrder(cmbRF, cmbSSal);
        QWidget.setTabOrder(cmbSSal, btnMSSal);
        QWidget.setTabOrder(btnMSSal, cmbResp);
        QWidget.setTabOrder(cmbResp, leObse);
        QWidget.setTabOrder(leObse, cmbTDer);
        QWidget.setTabOrder(cmbTDer, cmbDeri);
        QWidget.setTabOrder(cmbDeri, btnMDeri);
        QWidget.setTabOrder(btnMDeri, lePrest);
        QWidget.setTabOrder(lePrest, cmbPres);
        QWidget.setTabOrder(cmbPres, sbCant);
        QWidget.setTabOrder(sbCant, cmbToma);
        QWidget.setTabOrder(cmbToma, btnMFunc);
        QWidget.setTabOrder(btnMFunc, gbHecho);
        QWidget.setTabOrder(gbHecho, dteHecho);
        QWidget.setTabOrder(dteHecho, btnDNuevo);
        QWidget.setTabOrder(btnDNuevo, btnDEditar);
        QWidget.setTabOrder(btnDEditar, btnDGuardar);
        QWidget.setTabOrder(btnDGuardar, btnDEliminar);
        QWidget.setTabOrder(btnDEliminar, btnDCancelar);
        QWidget.setTabOrder(btnDCancelar, twPrestaciones);
        QWidget.setTabOrder(twPrestaciones, leAPat);
        QWidget.setTabOrder(leAPat, leAMat);
        QWidget.setTabOrder(leAMat, leCiud);
        QWidget.setTabOrder(leCiud, cmbERec);
        QWidget.setTabOrder(cmbERec, lePaci);
        QWidget.setTabOrder(lePaci, leID);
        retranslateUi(frmRecepciones);
        btnClose.clicked.connect(frmRecepciones, "close()");

        frmRecepciones.connectSlotsByName();
    } // setupUi

    void retranslateUi(QDialog frmRecepciones)
    {
        frmRecepciones.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("frmRecepciones", "Recepci\u00f3n de pacientes", null));
        btnNuevo.setText(com.trolltech.qt.core.QCoreApplication.translate("frmRecepciones", "Nueva\n"+
"[Ctrl+N]", null));
        btnNuevo.setShortcut(com.trolltech.qt.core.QCoreApplication.translate("frmRecepciones", "Ctrl+N", null));
        btnGuardar.setText(com.trolltech.qt.core.QCoreApplication.translate("frmRecepciones", "Guardar\n"+
"[Ctrl+G]", null));
        btnGuardar.setShortcut(com.trolltech.qt.core.QCoreApplication.translate("frmRecepciones", "Ctrl+G", null));
        gbDeta.setTitle(com.trolltech.qt.core.QCoreApplication.translate("frmRecepciones", "DETALLE DE EXAMENES, PROCEDIMIENTOS E INSUMOS", null));
        label_18.setText(com.trolltech.qt.core.QCoreApplication.translate("frmRecepciones", "Prestaci\u00f3n", null));
        label_19.setText(com.trolltech.qt.core.QCoreApplication.translate("frmRecepciones", "x", null));
        label_21.setText(com.trolltech.qt.core.QCoreApplication.translate("frmRecepciones", "Realiza la prestaci\u00f3n", null));
        btnDNuevo.setText(com.trolltech.qt.core.QCoreApplication.translate("frmRecepciones", "Nuevo", null));
        btnDEditar.setText(com.trolltech.qt.core.QCoreApplication.translate("frmRecepciones", "Editar", null));
        btnDGuardar.setText(com.trolltech.qt.core.QCoreApplication.translate("frmRecepciones", "Guardar", null));
        btnDEliminar.setText(com.trolltech.qt.core.QCoreApplication.translate("frmRecepciones", "Eliminar", null));
        btnDCancelar.setText(com.trolltech.qt.core.QCoreApplication.translate("frmRecepciones", "Cancelar", null));
        gbHecho.setTitle(com.trolltech.qt.core.QCoreApplication.translate("frmRecepciones", "Realizado", null));
        dteHecho.setDisplayFormat(com.trolltech.qt.core.QCoreApplication.translate("frmRecepciones", "dd-MM-yyyy HH:mm", null));
        btnMFunc.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("frmRecepciones", " Mantenci\u00f3n de funcionarios ", null));
        btnMFunc.setWhatsThis(com.trolltech.qt.core.QCoreApplication.translate("frmRecepciones", "Funcionarios", null));
        twPrestaciones.clear();
        twPrestaciones.setColumnCount(8);

        QTableWidgetItem __colItem = new QTableWidgetItem();
        __colItem.setText(com.trolltech.qt.core.QCoreApplication.translate("frmRecepciones", "E", null));
        twPrestaciones.setHorizontalHeaderItem(0, __colItem);

        QTableWidgetItem __colItem1 = new QTableWidgetItem();
        __colItem1.setText(com.trolltech.qt.core.QCoreApplication.translate("frmRecepciones", "C\u00f3d. Prest.", null));
        twPrestaciones.setHorizontalHeaderItem(1, __colItem1);

        QTableWidgetItem __colItem2 = new QTableWidgetItem();
        __colItem2.setText(com.trolltech.qt.core.QCoreApplication.translate("frmRecepciones", "Detalle Prestaci\u00f3n", null));
        twPrestaciones.setHorizontalHeaderItem(2, __colItem2);

        QTableWidgetItem __colItem3 = new QTableWidgetItem();
        __colItem3.setText(com.trolltech.qt.core.QCoreApplication.translate("frmRecepciones", "Cant.", null));
        twPrestaciones.setHorizontalHeaderItem(3, __colItem3);

        QTableWidgetItem __colItem4 = new QTableWidgetItem();
        __colItem4.setText(com.trolltech.qt.core.QCoreApplication.translate("frmRecepciones", "IDResp", null));
        twPrestaciones.setHorizontalHeaderItem(4, __colItem4);

        QTableWidgetItem __colItem5 = new QTableWidgetItem();
        __colItem5.setText(com.trolltech.qt.core.QCoreApplication.translate("frmRecepciones", "Responsable", null));
        twPrestaciones.setHorizontalHeaderItem(5, __colItem5);

        QTableWidgetItem __colItem6 = new QTableWidgetItem();
        __colItem6.setText(com.trolltech.qt.core.QCoreApplication.translate("frmRecepciones", "Tomado", null));
        twPrestaciones.setHorizontalHeaderItem(6, __colItem6);

        QTableWidgetItem __colItem7 = new QTableWidgetItem();
        __colItem7.setText(com.trolltech.qt.core.QCoreApplication.translate("frmRecepciones", "El", null));
        twPrestaciones.setHorizontalHeaderItem(7, __colItem7);
        twPrestaciones.setRowCount(0);
        btnImprimir.setText(com.trolltech.qt.core.QCoreApplication.translate("frmRecepciones", "Imprimir\n"+
"[Ctrl+P]", null));
        btnImprimir.setShortcut(com.trolltech.qt.core.QCoreApplication.translate("frmRecepciones", "Ctrl+P", null));
        btnMBRec.setWhatsThis(com.trolltech.qt.core.QCoreApplication.translate("frmRecepciones", "BuscarRecepcion", null));
        btnMBRec.setText(com.trolltech.qt.core.QCoreApplication.translate("frmRecepciones", "[F3] Buscar\n"+
"Recepci\u00f3n", null));
        btnMBRec.setShortcut(com.trolltech.qt.core.QCoreApplication.translate("frmRecepciones", "F3", null));
        gbEnca.setTitle(com.trolltech.qt.core.QCoreApplication.translate("frmRecepciones", "DATOS DE LA RECEPCION", null));
        label.setText(com.trolltech.qt.core.QCoreApplication.translate("frmRecepciones", "Tipo", null));
        label_2.setText(com.trolltech.qt.core.QCoreApplication.translate("frmRecepciones", "Fecha", null));
        label_3.setText(com.trolltech.qt.core.QCoreApplication.translate("frmRecepciones", "Hora", null));
        label_4.setText(com.trolltech.qt.core.QCoreApplication.translate("frmRecepciones", "RUN", null));
        label_5.setText(com.trolltech.qt.core.QCoreApplication.translate("frmRecepciones", "DAU", null));
        lblNombre.setText(com.trolltech.qt.core.QCoreApplication.translate("frmRecepciones", "Paciente", null));
        groupBox_3.setTitle(com.trolltech.qt.core.QCoreApplication.translate("frmRecepciones", "ID Recep.", null));
        label_7.setText(com.trolltech.qt.core.QCoreApplication.translate("frmRecepciones", "Edad", null));
        label_8.setText(com.trolltech.qt.core.QCoreApplication.translate("frmRecepciones", "Sexo", null));
        label_9.setText(com.trolltech.qt.core.QCoreApplication.translate("frmRecepciones", "Derivador", null));
        label_10.setText(com.trolltech.qt.core.QCoreApplication.translate("frmRecepciones", "Sistema Salud", null));
        label_11.setText(com.trolltech.qt.core.QCoreApplication.translate("frmRecepciones", "Nivel Urgencia", null));
        label_13.setText(com.trolltech.qt.core.QCoreApplication.translate("frmRecepciones", "Obs.", null));
        checkBox.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("frmRecepciones", " Fijar Tipo, Fecha y Hora ", null));
        checkBox.setText("");
        btnMPaci.setWhatsThis(com.trolltech.qt.core.QCoreApplication.translate("frmRecepciones", "Pacientes", null));
        btnMPaci.setText(com.trolltech.qt.core.QCoreApplication.translate("frmRecepciones", "Archivo de\n"+
" Pacientes", null));
        btnMDeri.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("frmRecepciones", " Mantenci\u00f3n de derivadores ", null));
        btnMDeri.setWhatsThis(com.trolltech.qt.core.QCoreApplication.translate("frmRecepciones", "Derivadores", null));
        btnMSSal.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("frmRecepciones", "Mantenci\u00f3n sistemas de salud ", null));
        btnMSSal.setWhatsThis(com.trolltech.qt.core.QCoreApplication.translate("frmRecepciones", "SistSalud", null));
        label_16.setText(com.trolltech.qt.core.QCoreApplication.translate("frmRecepciones", "FICHA", null));
        label_17.setText(com.trolltech.qt.core.QCoreApplication.translate("frmRecepciones", "CTA. CTE.", null));
        lblDigi.setText("");
        label_22.setText(com.trolltech.qt.core.QCoreApplication.translate("frmRecepciones", "Digitado", null));
        label_14.setText(com.trolltech.qt.core.QCoreApplication.translate("frmRecepciones", "Citaci\u00f3n", null));
        label_15.setText(com.trolltech.qt.core.QCoreApplication.translate("frmRecepciones", "Sala", null));
        label_20.setText(com.trolltech.qt.core.QCoreApplication.translate("frmRecepciones", "Responsable", null));
        label_12.setText(com.trolltech.qt.core.QCoreApplication.translate("frmRecepciones", "Tel\u00e9fonos", null));
        lblApat.setText(com.trolltech.qt.core.QCoreApplication.translate("frmRecepciones", "Paterno", null));
        lblAmat.setText(com.trolltech.qt.core.QCoreApplication.translate("frmRecepciones", "Materno", null));
        lblCiud.setText(com.trolltech.qt.core.QCoreApplication.translate("frmRecepciones", "Ciudad", null));
        dteFeHo.setDisplayFormat(com.trolltech.qt.core.QCoreApplication.translate("frmRecepciones", "dd-MM-yyyy HH:mm", null));
        btnMBPac.setWhatsThis(com.trolltech.qt.core.QCoreApplication.translate("frmRecepciones", "Pacientes", null));
        btnMBPac.setText(com.trolltech.qt.core.QCoreApplication.translate("frmRecepciones", "[F2] Buscar\n"+
"Pacientes", null));
        btnMBPac.setShortcut(com.trolltech.qt.core.QCoreApplication.translate("frmRecepciones", "F2", null));
        lblStat.setText("");
        leID.setText(com.trolltech.qt.core.QCoreApplication.translate("frmRecepciones", "1112000001", null));
    } // retranslateUi

}

