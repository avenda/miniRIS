/********************************************************************************
** Form generated from reading ui file 'frmCitaciones.jui'
**
** Created: mi� nov 30 23:59:49 2011
**      by: Qt User Interface Compiler version 4.5.2
**
** WARNING! All changes made in this file will be lost when recompiling ui file!
********************************************************************************/

package com.eims.ris.gui;

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class Ui_frmCitaciones implements com.trolltech.qt.QUiForm<QDialog>
{
    public QPushButton btnLock;
    public QGroupBox gbDeta;
    public QLabel label_18;
    public QLabel label_19;
    public QLineEdit lePrest;
    public QPushButton btnDNuevo;
    public QPushButton btnDEditar;
    public QPushButton btnDGuardar;
    public QPushButton btnDEliminar;
    public QPushButton btnDCancelar;
    public QSpinBox sbCant;
    public QTableWidget twPrestaciones;
    public QGroupBox groupBox;
    public QLabel label_3;
    public QLabel label_4;
    public QLineEdit leRUN;
    public QLineEdit leFich;
    public QLineEdit lePaciente;
    public QPushButton btnMPaci;
    public QComboBox cmbRF;
    public QPushButton btnAceptar;
    public QPushButton btnLimpiar;
    public QPushButton btnSCAdd;
    public QCalendarWidget cwFecha;
    public QComboBox cmbResp;
    public QDateEdit deFDesde;
    public QPushButton btnImprimir;
    public QPushButton btnGuardar;
    public QPushButton btnEliminar;
    public QCheckBox ckbDisp;
    public QTableWidget twHoras;
    public QLabel label;
    public QPushButton btnSCRemove;
    public QLabel label_2;
    public QGroupBox groupBox_3;
    public QLineEdit leID;
    public QFrame frmSC;
    public QLabel lblTitleSC;
    public QLabel lblSCHora;
    public QTimeEdit teSCHora;
    public QPushButton btnSCAceptar;
    public QPushButton btnSCCancelar;
    public QFrame frame;
    public QPushButton btnMSSal;
    public QLabel label_5;
    public QComboBox cmbTDer;
    public QLabel label_6;
    public QComboBox cmbSSal;
    public QPushButton btnMProc;
    public QComboBox cmbDeri;

    public Ui_frmCitaciones() { super(); }

    public void setupUi(QDialog frmCitaciones)
    {
        frmCitaciones.setObjectName("frmCitaciones");
        frmCitaciones.setWindowModality(com.trolltech.qt.core.Qt.WindowModality.NonModal);
        frmCitaciones.resize(new QSize(648, 600).expandedTo(frmCitaciones.minimumSizeHint()));
        frmCitaciones.setMinimumSize(new QSize(648, 600));
        frmCitaciones.setMaximumSize(new QSize(640, 600));
        frmCitaciones.setWindowIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/agenda64.png")));
        btnLock = new QPushButton(frmCitaciones);
        btnLock.setObjectName("btnLock");
        btnLock.setEnabled(false);
        btnLock.setGeometry(new QRect(600, 406, 31, 31));
        QFont font = new QFont();
        btnLock.setFont(font);
        btnLock.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnLock.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/lock24.png")));
        btnLock.setIconSize(new QSize(24, 24));
        btnLock.setAutoDefault(false);
        gbDeta = new QGroupBox(frmCitaciones);
        gbDeta.setObjectName("gbDeta");
        gbDeta.setGeometry(new QRect(5, 434, 631, 161));
        QFont font1 = new QFont();
        gbDeta.setFont(font1);
        label_18 = new QLabel(gbDeta);
        label_18.setObjectName("label_18");
        label_18.setGeometry(new QRect(10, 20, 72, 16));
        QFont font2 = new QFont();
        font2.setBold(true);
        font2.setWeight(75);
        label_18.setFont(font2);
        label_19 = new QLabel(gbDeta);
        label_19.setObjectName("label_19");
        label_19.setEnabled(false);
        label_19.setGeometry(new QRect(121, 20, 21, 20));
        QFont font3 = new QFont();
        font3.setBold(true);
        font3.setWeight(75);
        label_19.setFont(font3);
        label_19.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));
        lePrest = new QLineEdit(gbDeta);
        lePrest.setObjectName("lePrest");
        lePrest.setEnabled(false);
        lePrest.setGeometry(new QRect(140, 20, 81, 22));
        QFont font4 = new QFont();
        lePrest.setFont(font4);
        lePrest.setMaxLength(20);
        lePrest.setReadOnly(true);
        btnDNuevo = new QPushButton(gbDeta);
        btnDNuevo.setObjectName("btnDNuevo");
        btnDNuevo.setGeometry(new QRect(230, 16, 75, 28));
        QFont font5 = new QFont();
        font5.setFamily("Arial");
        font5.setPointSize(8);
        btnDNuevo.setFont(font5);
        btnDNuevo.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnDNuevo.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/nuev48.png")));
        btnDNuevo.setIconSize(new QSize(20, 20));
        btnDNuevo.setAutoDefault(false);
        btnDEditar = new QPushButton(gbDeta);
        btnDEditar.setObjectName("btnDEditar");
        btnDEditar.setEnabled(false);
        btnDEditar.setGeometry(new QRect(310, 16, 75, 28));
        QFont font6 = new QFont();
        font6.setFamily("Arial");
        font6.setPointSize(8);
        btnDEditar.setFont(font6);
        btnDEditar.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnDEditar.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/edit48.png")));
        btnDEditar.setIconSize(new QSize(20, 20));
        btnDEditar.setAutoDefault(false);
        btnDGuardar = new QPushButton(gbDeta);
        btnDGuardar.setObjectName("btnDGuardar");
        btnDGuardar.setEnabled(false);
        btnDGuardar.setGeometry(new QRect(390, 16, 75, 28));
        QFont font7 = new QFont();
        font7.setFamily("Arial");
        font7.setPointSize(8);
        btnDGuardar.setFont(font7);
        btnDGuardar.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnDGuardar.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/save48.png")));
        btnDGuardar.setIconSize(new QSize(20, 20));
        btnDGuardar.setAutoDefault(false);
        btnDEliminar = new QPushButton(gbDeta);
        btnDEliminar.setObjectName("btnDEliminar");
        btnDEliminar.setEnabled(false);
        btnDEliminar.setGeometry(new QRect(470, 16, 75, 28));
        QFont font8 = new QFont();
        font8.setFamily("Arial");
        font8.setPointSize(8);
        btnDEliminar.setFont(font8);
        btnDEliminar.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnDEliminar.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/dele48.png")));
        btnDEliminar.setIconSize(new QSize(20, 20));
        btnDEliminar.setAutoDefault(false);
        btnDCancelar = new QPushButton(gbDeta);
        btnDCancelar.setObjectName("btnDCancelar");
        btnDCancelar.setEnabled(false);
        btnDCancelar.setGeometry(new QRect(550, 16, 75, 28));
        QFont font9 = new QFont();
        font9.setFamily("Arial");
        font9.setPointSize(8);
        btnDCancelar.setFont(font9);
        btnDCancelar.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnDCancelar.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/undo24.png")));
        btnDCancelar.setIconSize(new QSize(20, 20));
        btnDCancelar.setAutoDefault(false);
        sbCant = new QSpinBox(gbDeta);
        sbCant.setObjectName("sbCant");
        sbCant.setEnabled(false);
        sbCant.setGeometry(new QRect(82, 20, 42, 22));
        QFont font10 = new QFont();
        sbCant.setFont(font10);
        sbCant.setMinimum(1);
        twPrestaciones = new QTableWidget(gbDeta);
        twPrestaciones.setObjectName("twPrestaciones");
        twPrestaciones.setGeometry(new QRect(10, 50, 611, 101));
        QFont font11 = new QFont();
        twPrestaciones.setFont(font11);
        twPrestaciones.setStyleSheet("QTableWidget {\n"+
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
        twPrestaciones.setEditTriggers(com.trolltech.qt.gui.QAbstractItemView.EditTrigger.createQFlags(com.trolltech.qt.gui.QAbstractItemView.EditTrigger.NoEditTriggers));
        twPrestaciones.setAlternatingRowColors(true);
        twPrestaciones.setSelectionMode(com.trolltech.qt.gui.QAbstractItemView.SelectionMode.SingleSelection);
        twPrestaciones.setSelectionBehavior(com.trolltech.qt.gui.QAbstractItemView.SelectionBehavior.SelectRows);
        groupBox = new QGroupBox(frmCitaciones);
        groupBox.setObjectName("groupBox");
        groupBox.setGeometry(new QRect(10, 290, 311, 81));
        QFont font12 = new QFont();
        groupBox.setFont(font12);
        label_3 = new QLabel(groupBox);
        label_3.setObjectName("label_3");
        label_3.setGeometry(new QRect(10, 20, 29, 16));
        QFont font13 = new QFont();
        font13.setBold(true);
        font13.setWeight(75);
        label_3.setFont(font13);
        label_4 = new QLabel(groupBox);
        label_4.setObjectName("label_4");
        label_4.setGeometry(new QRect(140, 20, 36, 16));
        QFont font14 = new QFont();
        font14.setBold(true);
        font14.setWeight(75);
        label_4.setFont(font14);
        leRUN = new QLineEdit(groupBox);
        leRUN.setObjectName("leRUN");
        leRUN.setGeometry(new QRect(40, 20, 91, 22));
        QFont font15 = new QFont();
        font15.setBold(true);
        font15.setWeight(75);
        leRUN.setFont(font15);
        leRUN.setMaxLength(10);
        leFich = new QLineEdit(groupBox);
        leFich.setObjectName("leFich");
        leFich.setGeometry(new QRect(180, 20, 81, 22));
        QFont font16 = new QFont();
        font16.setBold(true);
        font16.setWeight(75);
        leFich.setFont(font16);
        leFich.setMaxLength(10);
        leFich.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignRight,com.trolltech.qt.core.Qt.AlignmentFlag.AlignVCenter));
        lePaciente = new QLineEdit(groupBox);
        lePaciente.setObjectName("lePaciente");
        lePaciente.setGeometry(new QRect(10, 50, 291, 22));
        QFont font17 = new QFont();
        font17.setFamily("Arial");
        font17.setPointSize(10);
        font17.setBold(true);
        font17.setWeight(75);
        lePaciente.setFont(font17);
        lePaciente.setStyleSheet("background-color: rgb(213, 234, 255);\n"+
"border:1px solid rgb(39, 146, 167);\n"+
"border-radius:4px;");
        lePaciente.setReadOnly(true);
        btnMPaci = new QPushButton(groupBox);
        btnMPaci.setObjectName("btnMPaci");
        btnMPaci.setEnabled(false);
        btnMPaci.setGeometry(new QRect(269, 15, 31, 31));
        QFont font18 = new QFont();
        btnMPaci.setFont(font18);
        btnMPaci.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnMPaci.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/paci64.png")));
        btnMPaci.setIconSize(new QSize(24, 24));
        btnMPaci.setAutoDefault(false);
        cmbRF = new QComboBox(frmCitaciones);
        cmbRF.setObjectName("cmbRF");
        cmbRF.setGeometry(new QRect(330, 120, 241, 22));
        QFont font19 = new QFont();
        cmbRF.setFont(font19);
        cmbRF.setMaxVisibleItems(20);
        btnAceptar = new QPushButton(frmCitaciones);
        btnAceptar.setObjectName("btnAceptar");
        btnAceptar.setGeometry(new QRect(580, 90, 51, 51));
        btnAceptar.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnAceptar.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/ok48.png")));
        btnAceptar.setIconSize(new QSize(42, 42));
        btnLimpiar = new QPushButton(frmCitaciones);
        btnLimpiar.setObjectName("btnLimpiar");
        btnLimpiar.setGeometry(new QRect(480, 406, 31, 31));
        QFont font20 = new QFont();
        btnLimpiar.setFont(font20);
        btnLimpiar.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnLimpiar.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/clear48.png")));
        btnLimpiar.setIconSize(new QSize(24, 24));
        btnLimpiar.setAutoDefault(false);
        btnSCAdd = new QPushButton(frmCitaciones);
        btnSCAdd.setObjectName("btnSCAdd");
        btnSCAdd.setEnabled(false);
        btnSCAdd.setGeometry(new QRect(520, 406, 31, 31));
        QFont font21 = new QFont();
        btnSCAdd.setFont(font21);
        btnSCAdd.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnSCAdd.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/add32.png")));
        btnSCAdd.setIconSize(new QSize(24, 24));
        btnSCAdd.setAutoDefault(false);
        cwFecha = new QCalendarWidget(frmCitaciones);
        cwFecha.setObjectName("cwFecha");
        cwFecha.setGeometry(new QRect(10, 90, 311, 191));
        QFont font22 = new QFont();
        font22.setPointSize(8);
        cwFecha.setFont(font22);
        cwFecha.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.StrongFocus);
        cwFecha.setLayoutDirection(com.trolltech.qt.core.Qt.LayoutDirection.LeftToRight);
        cwFecha.setLocale(new QLocale(QLocale.Language.Spanish, QLocale.Country.Chile));
        cwFecha.setFirstDayOfWeek(com.trolltech.qt.core.Qt.DayOfWeek.Monday);
        cwFecha.setGridVisible(true);
        cwFecha.setSelectionMode(com.trolltech.qt.gui.QCalendarWidget.SelectionMode.SingleSelection);
        cmbResp = new QComboBox(frmCitaciones);
        cmbResp.setObjectName("cmbResp");
        cmbResp.setGeometry(new QRect(330, 90, 241, 22));
        QFont font23 = new QFont();
        cmbResp.setFont(font23);
        cmbResp.setMaxVisibleItems(18);
        deFDesde = new QDateEdit(frmCitaciones);
        deFDesde.setObjectName("deFDesde");
        deFDesde.setEnabled(false);
        deFDesde.setGeometry(new QRect(530, 150, 101, 22));
        deFDesde.setDateTime(new QDateTime(new QDate(2011, 8, 1), new QTime(0, 0, 0)));
        deFDesde.setCalendarPopup(true);
        deFDesde.setDate(new QDate(2011, 8, 1));
        btnImprimir = new QPushButton(frmCitaciones);
        btnImprimir.setObjectName("btnImprimir");
        btnImprimir.setEnabled(false);
        btnImprimir.setGeometry(new QRect(400, 406, 76, 31));
        QFont font24 = new QFont();
        font24.setFamily("Arial");
        font24.setPointSize(8);
        btnImprimir.setFont(font24);
        btnImprimir.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnImprimir.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/print48.png")));
        btnImprimir.setIconSize(new QSize(22, 22));
        btnImprimir.setAutoDefault(false);
        btnGuardar = new QPushButton(frmCitaciones);
        btnGuardar.setObjectName("btnGuardar");
        btnGuardar.setEnabled(false);
        btnGuardar.setGeometry(new QRect(400, 374, 111, 31));
        QFont font25 = new QFont();
        font25.setFamily("Arial");
        font25.setPointSize(8);
        btnGuardar.setFont(font25);
        btnGuardar.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnGuardar.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/green24.png")));
        btnGuardar.setIconSize(new QSize(20, 20));
        btnGuardar.setAutoDefault(false);
        btnEliminar = new QPushButton(frmCitaciones);
        btnEliminar.setObjectName("btnEliminar");
        btnEliminar.setEnabled(false);
        btnEliminar.setGeometry(new QRect(520, 374, 111, 31));
        QFont font26 = new QFont();
        font26.setFamily("Arial");
        font26.setPointSize(8);
        btnEliminar.setFont(font26);
        btnEliminar.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnEliminar.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/red24.png")));
        btnEliminar.setIconSize(new QSize(20, 20));
        btnEliminar.setAutoDefault(false);
        ckbDisp = new QCheckBox(frmCitaciones);
        ckbDisp.setObjectName("ckbDisp");
        ckbDisp.setGeometry(new QRect(330, 150, 201, 18));
        QFont font27 = new QFont();
        font27.setFamily("Arial");
        font27.setPointSize(7);
        ckbDisp.setFont(font27);
        twHoras = new QTableWidget(frmCitaciones);
        twHoras.setObjectName("twHoras");
        twHoras.setGeometry(new QRect(330, 170, 301, 201));
        QFont font28 = new QFont();
        twHoras.setFont(font28);
        twHoras.setStyleSheet("QTableWidget {\n"+
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
        twHoras.setEditTriggers(com.trolltech.qt.gui.QAbstractItemView.EditTrigger.createQFlags(com.trolltech.qt.gui.QAbstractItemView.EditTrigger.NoEditTriggers));
        twHoras.setAlternatingRowColors(true);
        twHoras.setSelectionMode(com.trolltech.qt.gui.QAbstractItemView.SelectionMode.SingleSelection);
        twHoras.setSelectionBehavior(com.trolltech.qt.gui.QAbstractItemView.SelectionBehavior.SelectRows);
        label = new QLabel(frmCitaciones);
        label.setObjectName("label");
        label.setGeometry(new QRect(0, 0, 641, 91));
        label.setStyleSheet("background-color: qlineargradient(spread:pad, x1:0, y1:0, x2:0, y2:1, stop:0 rgba(0, 50, 100, 255), stop:1 rgba(0, 0, 0, 0));");
        label.setPixmap(new QPixmap(("classpath:com/eims/ris/images/agenda64.png")));
        label.setMargin(10);
        btnSCRemove = new QPushButton(frmCitaciones);
        btnSCRemove.setObjectName("btnSCRemove");
        btnSCRemove.setEnabled(false);
        btnSCRemove.setGeometry(new QRect(560, 406, 31, 31));
        QFont font29 = new QFont();
        btnSCRemove.setFont(font29);
        btnSCRemove.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnSCRemove.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/remove32.png")));
        btnSCRemove.setIconSize(new QSize(24, 24));
        btnSCRemove.setAutoDefault(false);
        label_2 = new QLabel(frmCitaciones);
        label_2.setObjectName("label_2");
        label_2.setGeometry(new QRect(80, 10, 361, 53));
        QFont font30 = new QFont();
        label_2.setFont(font30);
        groupBox_3 = new QGroupBox(frmCitaciones);
        groupBox_3.setObjectName("groupBox_3");
        groupBox_3.setGeometry(new QRect(450, 10, 181, 71));
        QFont font31 = new QFont();
        groupBox_3.setFont(font31);
        leID = new QLineEdit(groupBox_3);
        leID.setObjectName("leID");
        leID.setGeometry(new QRect(10, 20, 161, 41));
        QFont font32 = new QFont();
        font32.setFamily("Arial");
        font32.setPointSize(19);
        leID.setFont(font32);
        leID.setStyleSheet("border:1px solid rgb(50, 50, 50);\n"+
"background-color: rgb(78, 78, 78);\n"+
"color: rgb(230, 230, 230);");
        leID.setMaxLength(10);
        leID.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignRight,com.trolltech.qt.core.Qt.AlignmentFlag.AlignVCenter));
        frmSC = new QFrame(frmCitaciones);
        frmSC.setObjectName("frmSC");
        frmSC.setGeometry(new QRect(460, 270, 171, 101));
        frmSC.setAutoFillBackground(true);
        frmSC.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        frmSC.setFrameShadow(com.trolltech.qt.gui.QFrame.Shadow.Plain);
        lblTitleSC = new QLabel(frmSC);
        lblTitleSC.setObjectName("lblTitleSC");
        lblTitleSC.setGeometry(new QRect(2, 2, 167, 21));
        lblTitleSC.setStyleSheet("background-color: rgb(40, 40, 40);");
        lblTitleSC.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));
        lblSCHora = new QLabel(frmSC);
        lblSCHora.setObjectName("lblSCHora");
        lblSCHora.setGeometry(new QRect(20, 40, 32, 16));
        QFont font33 = new QFont();
        font33.setBold(true);
        font33.setWeight(75);
        lblSCHora.setFont(font33);
        teSCHora = new QTimeEdit(frmSC);
        teSCHora.setObjectName("teSCHora");
        teSCHora.setGeometry(new QRect(10, 60, 61, 20));
        teSCHora.setTime(new QTime(8, 0, 0));
        btnSCAceptar = new QPushButton(frmSC);
        btnSCAceptar.setObjectName("btnSCAceptar");
        btnSCAceptar.setGeometry(new QRect(84, 30, 81, 28));
        QFont font34 = new QFont();
        font34.setPointSize(8);
        btnSCAceptar.setFont(font34);
        btnSCAceptar.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnSCAceptar.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/ok48.png")));
        btnSCAceptar.setIconSize(new QSize(20, 20));
        btnSCCancelar = new QPushButton(frmSC);
        btnSCCancelar.setObjectName("btnSCCancelar");
        btnSCCancelar.setGeometry(new QRect(84, 60, 81, 28));
        QFont font35 = new QFont();
        font35.setPointSize(8);
        btnSCCancelar.setFont(font35);
        btnSCCancelar.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnSCCancelar.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/shutdown64.png")));
        btnSCCancelar.setIconSize(new QSize(20, 20));
        btnSCCancelar.setAutoDefault(false);
        frame = new QFrame(frmCitaciones);
        frame.setObjectName("frame");
        frame.setGeometry(new QRect(6, 371, 391, 70));
        btnMSSal = new QPushButton(frame);
        btnMSSal.setObjectName("btnMSSal");
        btnMSSal.setEnabled(false);
        btnMSSal.setGeometry(new QRect(350, 35, 31, 31));
        QFont font36 = new QFont();
        btnMSSal.setFont(font36);
        btnMSSal.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnMSSal.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/salud64.png")));
        btnMSSal.setIconSize(new QSize(24, 24));
        btnMSSal.setAutoDefault(false);
        label_5 = new QLabel(frame);
        label_5.setObjectName("label_5");
        label_5.setGeometry(new QRect(4, 39, 98, 16));
        QFont font37 = new QFont();
        font37.setBold(true);
        font37.setWeight(75);
        label_5.setFont(font37);
        cmbTDer = new QComboBox(frame);
        cmbTDer.setObjectName("cmbTDer");
        cmbTDer.setGeometry(new QRect(72, 8, 51, 22));
        QFont font38 = new QFont();
        cmbTDer.setFont(font38);
        cmbTDer.setMaxVisibleItems(24);
        label_6 = new QLabel(frame);
        label_6.setObjectName("label_6");
        label_6.setGeometry(new QRect(4, 8, 67, 16));
        QFont font39 = new QFont();
        font39.setBold(true);
        font39.setWeight(75);
        label_6.setFont(font39);
        cmbSSal = new QComboBox(frame);
        cmbSSal.setObjectName("cmbSSal");
        cmbSSal.setGeometry(new QRect(114, 39, 231, 22));
        QFont font40 = new QFont();
        cmbSSal.setFont(font40);
        cmbSSal.setMaxVisibleItems(24);
        btnMProc = new QPushButton(frame);
        btnMProc.setObjectName("btnMProc");
        btnMProc.setEnabled(false);
        btnMProc.setGeometry(new QRect(350, 3, 31, 31));
        QFont font41 = new QFont();
        btnMProc.setFont(font41);
        btnMProc.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnMProc.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/local64.png")));
        btnMProc.setIconSize(new QSize(24, 24));
        btnMProc.setAutoDefault(false);
        cmbDeri = new QComboBox(frame);
        cmbDeri.setObjectName("cmbDeri");
        cmbDeri.setGeometry(new QRect(124, 8, 221, 22));
        QFont font42 = new QFont();
        cmbDeri.setFont(font42);
        cmbDeri.setMaxVisibleItems(24);
        QWidget.setTabOrder(leID, cmbResp);
        QWidget.setTabOrder(cmbResp, cmbRF);
        QWidget.setTabOrder(cmbRF, btnAceptar);
        QWidget.setTabOrder(btnAceptar, cwFecha);
        QWidget.setTabOrder(cwFecha, leRUN);
        QWidget.setTabOrder(leRUN, leFich);
        QWidget.setTabOrder(leFich, btnMPaci);
        QWidget.setTabOrder(btnMPaci, cmbTDer);
        QWidget.setTabOrder(cmbTDer, cmbDeri);
        QWidget.setTabOrder(cmbDeri, cmbSSal);
        QWidget.setTabOrder(cmbSSal, btnDNuevo);
        QWidget.setTabOrder(btnDNuevo, sbCant);
        QWidget.setTabOrder(sbCant, lePrest);
        QWidget.setTabOrder(lePrest, btnDEditar);
        QWidget.setTabOrder(btnDEditar, btnDGuardar);
        QWidget.setTabOrder(btnDGuardar, btnDEliminar);
        QWidget.setTabOrder(btnDEliminar, btnDCancelar);
        QWidget.setTabOrder(btnDCancelar, twPrestaciones);
        QWidget.setTabOrder(twPrestaciones, btnGuardar);
        QWidget.setTabOrder(btnGuardar, btnImprimir);
        QWidget.setTabOrder(btnImprimir, btnLimpiar);
        QWidget.setTabOrder(btnLimpiar, btnEliminar);
        QWidget.setTabOrder(btnEliminar, btnSCAdd);
        QWidget.setTabOrder(btnSCAdd, btnSCRemove);
        QWidget.setTabOrder(btnSCRemove, btnLock);
        QWidget.setTabOrder(btnLock, teSCHora);
        QWidget.setTabOrder(teSCHora, btnSCAceptar);
        QWidget.setTabOrder(btnSCAceptar, btnSCCancelar);
        QWidget.setTabOrder(btnSCCancelar, ckbDisp);
        QWidget.setTabOrder(ckbDisp, deFDesde);
        QWidget.setTabOrder(deFDesde, twHoras);
        QWidget.setTabOrder(twHoras, lePaciente);
        QWidget.setTabOrder(lePaciente, btnMProc);
        QWidget.setTabOrder(btnMProc, btnMSSal);
        retranslateUi(frmCitaciones);

        frmCitaciones.connectSlotsByName();
    } // setupUi

    void retranslateUi(QDialog frmCitaciones)
    {
        frmCitaciones.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("frmCitaciones", "Citaci\u00f3n de pacientes", null));
        btnLock.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("frmCitaciones", " Bloquear hora ", null));
        gbDeta.setTitle(com.trolltech.qt.core.QCoreApplication.translate("frmCitaciones", "DETALLE DE PRESTACIONES", null));
        label_18.setText(com.trolltech.qt.core.QCoreApplication.translate("frmCitaciones", "Prestaci\u00f3n", null));
        label_19.setText(com.trolltech.qt.core.QCoreApplication.translate("frmCitaciones", "x", null));
        btnDNuevo.setText(com.trolltech.qt.core.QCoreApplication.translate("frmCitaciones", "Nuevo", null));
        btnDEditar.setText(com.trolltech.qt.core.QCoreApplication.translate("frmCitaciones", "Editar", null));
        btnDGuardar.setText(com.trolltech.qt.core.QCoreApplication.translate("frmCitaciones", "Guardar", null));
        btnDEliminar.setText(com.trolltech.qt.core.QCoreApplication.translate("frmCitaciones", "Eliminar", null));
        btnDCancelar.setText(com.trolltech.qt.core.QCoreApplication.translate("frmCitaciones", "Cancelar", null));
        twPrestaciones.clear();
        twPrestaciones.setColumnCount(4);

        QTableWidgetItem __colItem = new QTableWidgetItem();
        __colItem.setText(com.trolltech.qt.core.QCoreApplication.translate("frmCitaciones", "E", null));
        twPrestaciones.setHorizontalHeaderItem(0, __colItem);

        QTableWidgetItem __colItem1 = new QTableWidgetItem();
        __colItem1.setText(com.trolltech.qt.core.QCoreApplication.translate("frmCitaciones", "C\u00f3d. Prest.", null));
        twPrestaciones.setHorizontalHeaderItem(1, __colItem1);

        QTableWidgetItem __colItem2 = new QTableWidgetItem();
        __colItem2.setText(com.trolltech.qt.core.QCoreApplication.translate("frmCitaciones", "Detalle Prestaci\u00f3n", null));
        twPrestaciones.setHorizontalHeaderItem(2, __colItem2);

        QTableWidgetItem __colItem3 = new QTableWidgetItem();
        __colItem3.setText(com.trolltech.qt.core.QCoreApplication.translate("frmCitaciones", "Cant.", null));
        twPrestaciones.setHorizontalHeaderItem(3, __colItem3);
        twPrestaciones.setRowCount(0);
        groupBox.setTitle(com.trolltech.qt.core.QCoreApplication.translate("frmCitaciones", "Informaci\u00f3n del paciente asignado", null));
        label_3.setText(com.trolltech.qt.core.QCoreApplication.translate("frmCitaciones", "RUN", null));
        label_4.setText(com.trolltech.qt.core.QCoreApplication.translate("frmCitaciones", "Ficha", null));
        btnMPaci.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("frmCitaciones", " Mantenci\u00f3n de procedencias ", null));
        btnMPaci.setWhatsThis(com.trolltech.qt.core.QCoreApplication.translate("frmCitaciones", "Pacientes", null));
        btnLimpiar.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("frmCitaciones", " Limpiar cuadros de ingreso ", null));
        btnSCAdd.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("frmCitaciones", " Agregar sobrecupo ", null));
        deFDesde.setDisplayFormat(com.trolltech.qt.core.QCoreApplication.translate("frmCitaciones", "dd-MM-yyyy", null));
        btnImprimir.setText(com.trolltech.qt.core.QCoreApplication.translate("frmCitaciones", "Imprimir", null));
        btnGuardar.setText(com.trolltech.qt.core.QCoreApplication.translate("frmCitaciones", "Reservar Hora", null));
        btnEliminar.setText(com.trolltech.qt.core.QCoreApplication.translate("frmCitaciones", "Devolver Hora", null));
        ckbDisp.setText(com.trolltech.qt.core.QCoreApplication.translate("frmCitaciones", "Mostrar todas y s\u00f3lo las horas disponibles", null));
        twHoras.clear();
        twHoras.setColumnCount(7);

        QTableWidgetItem __colItem4 = new QTableWidgetItem();
        __colItem4.setText(com.trolltech.qt.core.QCoreApplication.translate("frmCitaciones", "Stat", null));
        twHoras.setHorizontalHeaderItem(0, __colItem4);

        QTableWidgetItem __colItem5 = new QTableWidgetItem();
        __colItem5.setText(com.trolltech.qt.core.QCoreApplication.translate("frmCitaciones", "Hora", null));
        twHoras.setHorizontalHeaderItem(1, __colItem5);

        QTableWidgetItem __colItem6 = new QTableWidgetItem();
        __colItem6.setText(com.trolltech.qt.core.QCoreApplication.translate("frmCitaciones", "Comentario", null));
        twHoras.setHorizontalHeaderItem(2, __colItem6);

        QTableWidgetItem __colItem7 = new QTableWidgetItem();
        __colItem7.setText(com.trolltech.qt.core.QCoreApplication.translate("frmCitaciones", "ID Citaci\u00f3n", null));
        twHoras.setHorizontalHeaderItem(3, __colItem7);

        QTableWidgetItem __colItem8 = new QTableWidgetItem();
        __colItem8.setText(com.trolltech.qt.core.QCoreApplication.translate("frmCitaciones", "Fecha", null));
        twHoras.setHorizontalHeaderItem(4, __colItem8);

        QTableWidgetItem __colItem9 = new QTableWidgetItem();
        __colItem9.setText(com.trolltech.qt.core.QCoreApplication.translate("frmCitaciones", "ID Interna", null));
        twHoras.setHorizontalHeaderItem(5, __colItem9);

        QTableWidgetItem __colItem10 = new QTableWidgetItem();
        __colItem10.setText(com.trolltech.qt.core.QCoreApplication.translate("frmCitaciones", "EO", null));
        twHoras.setHorizontalHeaderItem(6, __colItem10);
        twHoras.setRowCount(0);
        label.setText("");
        btnSCRemove.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("frmCitaciones", " Eliminar sobrecupo ", null));
        label_2.setText(com.trolltech.qt.core.QCoreApplication.translate("frmCitaciones", "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0//EN\" \"http://www.w3.org/TR/REC-html40/strict.dtd\">\n"+
"<html><head><meta name=\"qrichtext\" content=\"1\" /><style type=\"text/css\">\n"+
"p, li { white-space: pre-wrap; }\n"+
"</style></head><body style=\" font-family:'Sans Serif'; font-size:9pt; font-weight:400; font-style:normal;\">\n"+
"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-family:'Calibri'; font-size:20pt;\">CITACI\u00d3N DE PACIENTES</span></p>\n"+
"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-family:'Calibri';\">Aqu\u00ed podr\u00e1 realizar la gesti\u00f3n de las citaciones a pacientes.</span></p></body></html>", null));
        groupBox_3.setTitle(com.trolltech.qt.core.QCoreApplication.translate("frmCitaciones", "ID Citaci\u00f3n", null));
        lblTitleSC.setText(com.trolltech.qt.core.QCoreApplication.translate("frmCitaciones", "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0//EN\" \"http://www.w3.org/TR/REC-html40/strict.dtd\">\n"+
"<html><head><meta name=\"qrichtext\" content=\"1\" /><style type=\"text/css\">\n"+
"p, li { white-space: pre-wrap; }\n"+
"</style></head><body style=\" font-family:'MS Shell Dlg 2'; font-size:8.25pt; font-weight:400; font-style:normal;\">\n"+
"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-size:10pt; color:#dadada;\">AGREGAR SOBRECUPO</span></p></body></html>", null));
        lblSCHora.setText(com.trolltech.qt.core.QCoreApplication.translate("frmCitaciones", "Hora", null));
        teSCHora.setDisplayFormat(com.trolltech.qt.core.QCoreApplication.translate("frmCitaciones", "HH:mm", null));
        btnSCAceptar.setText(com.trolltech.qt.core.QCoreApplication.translate("frmCitaciones", "Aceptar", null));
        btnSCCancelar.setText(com.trolltech.qt.core.QCoreApplication.translate("frmCitaciones", "Cancelar", null));
        btnMSSal.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("frmCitaciones", "Mantenci\u00f3n sistemas de salud ", null));
        btnMSSal.setWhatsThis(com.trolltech.qt.core.QCoreApplication.translate("frmCitaciones", "SistSalud", null));
        label_5.setText(com.trolltech.qt.core.QCoreApplication.translate("frmCitaciones", "Sistema Salud", null));
        label_6.setText(com.trolltech.qt.core.QCoreApplication.translate("frmCitaciones", "Derivador", null));
        btnMProc.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("frmCitaciones", " Mantenci\u00f3n de procedencias ", null));
        btnMProc.setWhatsThis(com.trolltech.qt.core.QCoreApplication.translate("frmCitaciones", "Derivadores", null));
    } // retranslateUi

}

