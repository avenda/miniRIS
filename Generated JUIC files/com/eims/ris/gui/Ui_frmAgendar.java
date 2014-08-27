/********************************************************************************
** Form generated from reading ui file 'frmAgendar.jui'
**
** Created: mi� nov 30 21:45:03 2011
**      by: Qt User Interface Compiler version 4.5.2
**
** WARNING! All changes made in this file will be lost when recompiling ui file!
********************************************************************************/

package com.eims.ris.gui;

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class Ui_frmAgendar implements com.trolltech.qt.QUiForm<QDialog>
{
    public QTableWidget twFechasOmitidas;
    public QGroupBox gbProgM;
    public QLabel label_6;
    public QTimeEdit teHora;
    public QCheckBox ckbMVie;
    public QCheckBox ckbMLun;
    public QCheckBox ckbMMie;
    public QCheckBox ckbMSab;
    public QCheckBox ckbMInv;
    public QCheckBox ckbMMar;
    public QCheckBox ckbMDom;
    public QCheckBox ckbMJue;
    public QPushButton btnAdd;
    public QLabel label_7;
    public QToolButton tbRemove;
    public QDateEdit deFOmitir;
    public QLabel lblStat;
    public QTableWidget twAgendas;
    public QGroupBox gbProgA;
    public QLabel label_4;
    public QSpinBox sbCupos;
    public QLabel label_5;
    public QGroupBox groupBox;
    public QGridLayout gridLayout;
    public QCheckBox ckbALun;
    public QCheckBox ckbAVie;
    public QCheckBox ckbAMar;
    public QCheckBox ckbASab;
    public QCheckBox ckbAMie;
    public QCheckBox ckbADom;
    public QCheckBox ckbAJue;
    public QCheckBox ckbAInv;
    public QPushButton btnAplicar;
    public QLabel label_10;
    public QTimeEdit teInicio;
    public QPushButton btnLimpiar;
    public QSpinBox sbIntervalo;
    public QTableWidget twSemana;
    public QToolButton tbAdd;
    public QGroupBox gbGAgen;
    public QLabel label_8;
    public QLabel label_9;
    public QDateEdit deFIni;
    public QDateEdit deFTer;
    public QPushButton btnIniciar;
    public QCheckBox checkBox_17;
    public QLabel label_3;
    public QComboBox cmbRF;
    public QComboBox cmbProf;
    public QLabel label_11;
    public QLineEdit leDesc;
    public QLabel label;
    public QPushButton btnGuardar;
    public QPushButton btnNuevo;
    public QPushButton btnEditar;
    public QPushButton btnImprimir;
    public QPushButton btnCerrar;
    public QLabel label_2;

    public Ui_frmAgendar() { super(); }

    public void setupUi(QDialog frmAgendar)
    {
        frmAgendar.setObjectName("frmAgendar");
        frmAgendar.resize(new QSize(800, 600).expandedTo(frmAgendar.minimumSizeHint()));
        frmAgendar.setWindowIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/agendar64.png")));
        frmAgendar.setStyleSheet("QTableWidget {\n"+
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
        twFechasOmitidas = new QTableWidget(frmAgendar);
        twFechasOmitidas.setObjectName("twFechasOmitidas");
        twFechasOmitidas.setGeometry(new QRect(290, 520, 141, 71));
        twFechasOmitidas.setEditTriggers(com.trolltech.qt.gui.QAbstractItemView.EditTrigger.createQFlags(com.trolltech.qt.gui.QAbstractItemView.EditTrigger.NoEditTriggers));
        twFechasOmitidas.setAlternatingRowColors(true);
        twFechasOmitidas.setSelectionMode(com.trolltech.qt.gui.QAbstractItemView.SelectionMode.SingleSelection);
        gbProgM = new QGroupBox(frmAgendar);
        gbProgM.setObjectName("gbProgM");
        gbProgM.setEnabled(false);
        gbProgM.setGeometry(new QRect(10, 500, 271, 91));
        label_6 = new QLabel(gbProgM);
        label_6.setObjectName("label_6");
        label_6.setGeometry(new QRect(20, 20, 32, 16));
        QFont font = new QFont();
        font.setBold(true);
        font.setWeight(75);
        label_6.setFont(font);
        teHora = new QTimeEdit(gbProgM);
        teHora.setObjectName("teHora");
        teHora.setGeometry(new QRect(10, 40, 61, 22));
        teHora.setMinimumTime(new QTime(8, 0, 0));
        ckbMVie = new QCheckBox(gbProgM);
        ckbMVie.setObjectName("ckbMVie");
        ckbMVie.setGeometry(new QRect(140, 18, 61, 18));
        ckbMLun = new QCheckBox(gbProgM);
        ckbMLun.setObjectName("ckbMLun");
        ckbMLun.setGeometry(new QRect(80, 18, 61, 18));
        ckbMMie = new QCheckBox(gbProgM);
        ckbMMie.setObjectName("ckbMMie");
        ckbMMie.setGeometry(new QRect(80, 46, 61, 18));
        ckbMSab = new QCheckBox(gbProgM);
        ckbMSab.setObjectName("ckbMSab");
        ckbMSab.setGeometry(new QRect(140, 32, 61, 18));
        ckbMInv = new QCheckBox(gbProgM);
        ckbMInv.setObjectName("ckbMInv");
        ckbMInv.setGeometry(new QRect(140, 60, 68, 22));
        ckbMMar = new QCheckBox(gbProgM);
        ckbMMar.setObjectName("ckbMMar");
        ckbMMar.setGeometry(new QRect(80, 32, 61, 18));
        ckbMDom = new QCheckBox(gbProgM);
        ckbMDom.setObjectName("ckbMDom");
        ckbMDom.setGeometry(new QRect(140, 46, 61, 18));
        ckbMJue = new QCheckBox(gbProgM);
        ckbMJue.setObjectName("ckbMJue");
        ckbMJue.setGeometry(new QRect(80, 60, 61, 18));
        btnAdd = new QPushButton(gbProgM);
        btnAdd.setObjectName("btnAdd");
        btnAdd.setGeometry(new QRect(220, 20, 41, 41));
        btnAdd.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnAdd.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/add32.png")));
        btnAdd.setIconSize(new QSize(32, 32));
        label_7 = new QLabel(gbProgM);
        label_7.setObjectName("label_7");
        label_7.setGeometry(new QRect(220, 60, 41, 16));
        tbRemove = new QToolButton(frmAgendar);
        tbRemove.setObjectName("tbRemove");
        tbRemove.setEnabled(false);
        tbRemove.setGeometry(new QRect(412, 495, 20, 20));
        QFont font1 = new QFont();
        font1.setPointSize(12);
        font1.setBold(true);
        font1.setWeight(75);
        tbRemove.setFont(font1);
        tbRemove.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        deFOmitir = new QDateEdit(frmAgendar);
        deFOmitir.setObjectName("deFOmitir");
        deFOmitir.setGeometry(new QRect(290, 495, 91, 22));
        QFont font2 = new QFont();
        font2.setFamily("Arial");
        deFOmitir.setFont(font2);
        deFOmitir.setDateTime(new QDateTime(new QDate(2011, 8, 1), new QTime(0, 0, 0)));
        deFOmitir.setCalendarPopup(true);
        deFOmitir.setDate(new QDate(2011, 8, 1));
        lblStat = new QLabel(frmAgendar);
        lblStat.setObjectName("lblStat");
        lblStat.setGeometry(new QRect(440, 160, 351, 21));
        QFont font3 = new QFont();
        font3.setBold(true);
        font3.setWeight(75);
        lblStat.setFont(font3);
        lblStat.setStyleSheet("background-color: rgb(248, 255, 184);\n"+
"border:1px solid rgb(170, 170, 127);\n"+
"border-radius:4px;");
        twAgendas = new QTableWidget(frmAgendar);
        twAgendas.setObjectName("twAgendas");
        twAgendas.setGeometry(new QRect(440, 190, 351, 301));
        twAgendas.setEditTriggers(com.trolltech.qt.gui.QAbstractItemView.EditTrigger.createQFlags(com.trolltech.qt.gui.QAbstractItemView.EditTrigger.NoEditTriggers));
        twAgendas.setAlternatingRowColors(true);
        twAgendas.setSelectionMode(com.trolltech.qt.gui.QAbstractItemView.SelectionMode.SingleSelection);
        twAgendas.setSelectionBehavior(com.trolltech.qt.gui.QAbstractItemView.SelectionBehavior.SelectRows);
        gbProgA = new QGroupBox(frmAgendar);
        gbProgA.setObjectName("gbProgA");
        gbProgA.setEnabled(false);
        gbProgA.setGeometry(new QRect(10, 84, 421, 141));
        label_4 = new QLabel(gbProgA);
        label_4.setObjectName("label_4");
        label_4.setGeometry(new QRect(10, 20, 72, 16));
        sbCupos = new QSpinBox(gbProgA);
        sbCupos.setObjectName("sbCupos");
        sbCupos.setGeometry(new QRect(90, 20, 44, 22));
        sbCupos.setMinimum(1);
        sbCupos.setMaximum(50);
        label_5 = new QLabel(gbProgA);
        label_5.setObjectName("label_5");
        label_5.setGeometry(new QRect(10, 50, 71, 16));
        groupBox = new QGroupBox(gbProgA);
        groupBox.setObjectName("groupBox");
        groupBox.setGeometry(new QRect(140, 20, 161, 111));
        gridLayout = new QGridLayout(groupBox);
        gridLayout.setObjectName("gridLayout");
        ckbALun = new QCheckBox(groupBox);
        ckbALun.setObjectName("ckbALun");

        gridLayout.addWidget(ckbALun, 0, 0, 1, 1);

        ckbAVie = new QCheckBox(groupBox);
        ckbAVie.setObjectName("ckbAVie");

        gridLayout.addWidget(ckbAVie, 0, 1, 1, 1);

        ckbAMar = new QCheckBox(groupBox);
        ckbAMar.setObjectName("ckbAMar");

        gridLayout.addWidget(ckbAMar, 1, 0, 1, 1);

        ckbASab = new QCheckBox(groupBox);
        ckbASab.setObjectName("ckbASab");

        gridLayout.addWidget(ckbASab, 1, 1, 1, 1);

        ckbAMie = new QCheckBox(groupBox);
        ckbAMie.setObjectName("ckbAMie");

        gridLayout.addWidget(ckbAMie, 2, 0, 1, 1);

        ckbADom = new QCheckBox(groupBox);
        ckbADom.setObjectName("ckbADom");

        gridLayout.addWidget(ckbADom, 2, 1, 1, 1);

        ckbAJue = new QCheckBox(groupBox);
        ckbAJue.setObjectName("ckbAJue");

        gridLayout.addWidget(ckbAJue, 3, 0, 1, 1);

        ckbAInv = new QCheckBox(groupBox);
        ckbAInv.setObjectName("ckbAInv");

        gridLayout.addWidget(ckbAInv, 3, 1, 1, 1);

        btnAplicar = new QPushButton(gbProgA);
        btnAplicar.setObjectName("btnAplicar");
        btnAplicar.setGeometry(new QRect(320, 30, 91, 41));
        btnAplicar.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnAplicar.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/ok48.png")));
        btnAplicar.setIconSize(new QSize(32, 32));
        label_10 = new QLabel(gbProgA);
        label_10.setObjectName("label_10");
        label_10.setGeometry(new QRect(10, 80, 68, 16));
        teInicio = new QTimeEdit(gbProgA);
        teInicio.setObjectName("teInicio");
        teInicio.setGeometry(new QRect(10, 100, 61, 22));
        teInicio.setTime(new QTime(8, 0, 0));
        btnLimpiar = new QPushButton(gbProgA);
        btnLimpiar.setObjectName("btnLimpiar");
        btnLimpiar.setGeometry(new QRect(320, 90, 91, 41));
        btnLimpiar.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnLimpiar.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/clear48.png")));
        btnLimpiar.setIconSize(new QSize(32, 32));
        sbIntervalo = new QSpinBox(gbProgA);
        sbIntervalo.setObjectName("sbIntervalo");
        sbIntervalo.setGeometry(new QRect(90, 50, 44, 22));
        sbIntervalo.setMinimum(5);
        sbIntervalo.setMaximum(60);
        sbIntervalo.setSingleStep(5);
        sbIntervalo.setValue(5);
        twSemana = new QTableWidget(frmAgendar);
        twSemana.setObjectName("twSemana");
        twSemana.setGeometry(new QRect(10, 260, 421, 231));
        twSemana.setAlternatingRowColors(true);
        twSemana.setSelectionMode(com.trolltech.qt.gui.QAbstractItemView.SelectionMode.SingleSelection);
        tbAdd = new QToolButton(frmAgendar);
        tbAdd.setObjectName("tbAdd");
        tbAdd.setGeometry(new QRect(390, 495, 20, 20));
        tbAdd.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        gbGAgen = new QGroupBox(frmAgendar);
        gbGAgen.setObjectName("gbGAgen");
        gbGAgen.setGeometry(new QRect(440, 500, 351, 91));
        label_8 = new QLabel(gbGAgen);
        label_8.setObjectName("label_8");
        label_8.setGeometry(new QRect(10, 20, 51, 16));
        label_9 = new QLabel(gbGAgen);
        label_9.setObjectName("label_9");
        label_9.setGeometry(new QRect(10, 48, 51, 16));
        deFIni = new QDateEdit(gbGAgen);
        deFIni.setObjectName("deFIni");
        deFIni.setGeometry(new QRect(70, 20, 91, 22));
        QFont font4 = new QFont();
        font4.setFamily("Arial");
        deFIni.setFont(font4);
        deFIni.setDateTime(new QDateTime(new QDate(2011, 8, 1), new QTime(0, 0, 0)));
        deFIni.setCalendarPopup(true);
        deFIni.setDate(new QDate(2011, 8, 1));
        deFTer = new QDateEdit(gbGAgen);
        deFTer.setObjectName("deFTer");
        deFTer.setGeometry(new QRect(70, 48, 91, 22));
        QFont font5 = new QFont();
        font5.setFamily("Arial");
        font5.setPointSize(9);
        deFTer.setFont(font5);
        deFTer.setDateTime(new QDateTime(new QDate(2011, 8, 1), new QTime(0, 0, 0)));
        deFTer.setCalendarPopup(true);
        deFTer.setDate(new QDate(2011, 8, 1));
        btnIniciar = new QPushButton(gbGAgen);
        btnIniciar.setObjectName("btnIniciar");
        btnIniciar.setEnabled(false);
        btnIniciar.setGeometry(new QRect(170, 20, 171, 60));
        btnIniciar.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnIniciar.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/agendar64.png")));
        btnIniciar.setIconSize(new QSize(48, 48));
        checkBox_17 = new QCheckBox(gbGAgen);
        checkBox_17.setObjectName("checkBox_17");
        checkBox_17.setEnabled(false);
        checkBox_17.setGeometry(new QRect(10, 72, 153, 18));
        label_3 = new QLabel(frmAgendar);
        label_3.setObjectName("label_3");
        label_3.setGeometry(new QRect(440, 80, 191, 16));
        QFont font6 = new QFont();
        font6.setBold(true);
        font6.setWeight(75);
        label_3.setFont(font6);
        cmbRF = new QComboBox(frmAgendar);
        cmbRF.setObjectName("cmbRF");
        cmbRF.setGeometry(new QRect(490, 130, 301, 22));
        cmbProf = new QComboBox(frmAgendar);
        cmbProf.setObjectName("cmbProf");
        cmbProf.setGeometry(new QRect(440, 100, 351, 22));
        cmbProf.setMaxVisibleItems(30);
        label_11 = new QLabel(frmAgendar);
        label_11.setObjectName("label_11");
        label_11.setGeometry(new QRect(440, 130, 41, 16));
        QFont font7 = new QFont();
        font7.setBold(true);
        font7.setWeight(75);
        label_11.setFont(font7);
        leDesc = new QLineEdit(frmAgendar);
        leDesc.setObjectName("leDesc");
        leDesc.setGeometry(new QRect(10, 230, 421, 25));
        leDesc.setMaxLength(80);
        label = new QLabel(frmAgendar);
        label.setObjectName("label");
        label.setGeometry(new QRect(0, 0, 801, 91));
        label.setStyleSheet("background-color: qlineargradient(spread:pad, x1:0, y1:0, x2:0, y2:1, stop:0 rgba(0, 50, 100, 255), stop:1 rgba(0, 0, 0, 0));");
        label.setPixmap(new QPixmap(("classpath:com/eims/ris/images/agendar64.png")));
        label.setMargin(10);
        btnGuardar = new QPushButton(frmAgendar);
        btnGuardar.setObjectName("btnGuardar");
        btnGuardar.setEnabled(false);
        btnGuardar.setGeometry(new QRect(580, 10, 61, 61));
        btnGuardar.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnGuardar.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/save48.png")));
        btnGuardar.setIconSize(new QSize(48, 48));
        btnNuevo = new QPushButton(frmAgendar);
        btnNuevo.setObjectName("btnNuevo");
        btnNuevo.setEnabled(false);
        btnNuevo.setGeometry(new QRect(440, 10, 61, 61));
        btnNuevo.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnNuevo.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/nuev48.png")));
        btnNuevo.setIconSize(new QSize(48, 48));
        btnEditar = new QPushButton(frmAgendar);
        btnEditar.setObjectName("btnEditar");
        btnEditar.setEnabled(false);
        btnEditar.setGeometry(new QRect(510, 10, 61, 61));
        btnEditar.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnEditar.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/edit48.png")));
        btnEditar.setIconSize(new QSize(48, 48));
        btnImprimir = new QPushButton(frmAgendar);
        btnImprimir.setObjectName("btnImprimir");
        btnImprimir.setEnabled(false);
        btnImprimir.setGeometry(new QRect(650, 10, 61, 61));
        btnImprimir.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnImprimir.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/print48.png")));
        btnImprimir.setIconSize(new QSize(48, 48));
        btnCerrar = new QPushButton(frmAgendar);
        btnCerrar.setObjectName("btnCerrar");
        btnCerrar.setGeometry(new QRect(730, 10, 61, 61));
        btnCerrar.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnCerrar.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/shutdown64.png")));
        btnCerrar.setIconSize(new QSize(48, 48));
        label_2 = new QLabel(frmAgendar);
        label_2.setObjectName("label_2");
        label_2.setGeometry(new QRect(90, 10, 341, 64));
        QWidget.setTabOrder(cmbProf, cmbRF);
        QWidget.setTabOrder(cmbRF, sbCupos);
        QWidget.setTabOrder(sbCupos, sbIntervalo);
        QWidget.setTabOrder(sbIntervalo, teInicio);
        QWidget.setTabOrder(teInicio, ckbALun);
        QWidget.setTabOrder(ckbALun, ckbAMar);
        QWidget.setTabOrder(ckbAMar, ckbAMie);
        QWidget.setTabOrder(ckbAMie, ckbAJue);
        QWidget.setTabOrder(ckbAJue, ckbAVie);
        QWidget.setTabOrder(ckbAVie, ckbASab);
        QWidget.setTabOrder(ckbASab, ckbMJue);
        QWidget.setTabOrder(ckbMJue, ckbADom);
        QWidget.setTabOrder(ckbADom, btnAplicar);
        QWidget.setTabOrder(btnAplicar, btnLimpiar);
        QWidget.setTabOrder(btnLimpiar, leDesc);
        QWidget.setTabOrder(leDesc, twSemana);
        QWidget.setTabOrder(twSemana, deFOmitir);
        QWidget.setTabOrder(deFOmitir, tbAdd);
        QWidget.setTabOrder(tbAdd, tbRemove);
        QWidget.setTabOrder(tbRemove, twFechasOmitidas);
        QWidget.setTabOrder(twFechasOmitidas, deFIni);
        QWidget.setTabOrder(deFIni, deFTer);
        QWidget.setTabOrder(deFTer, btnIniciar);
        QWidget.setTabOrder(btnIniciar, checkBox_17);
        QWidget.setTabOrder(checkBox_17, teHora);
        QWidget.setTabOrder(teHora, ckbMVie);
        QWidget.setTabOrder(ckbMVie, twAgendas);
        QWidget.setTabOrder(twAgendas, btnAdd);
        QWidget.setTabOrder(btnAdd, ckbMLun);
        QWidget.setTabOrder(ckbMLun, ckbMMie);
        QWidget.setTabOrder(ckbMMie, ckbMDom);
        QWidget.setTabOrder(ckbMDom, ckbMSab);
        QWidget.setTabOrder(ckbMSab, ckbMInv);
        QWidget.setTabOrder(ckbMInv, ckbMMar);
        QWidget.setTabOrder(ckbMMar, ckbAInv);
        retranslateUi(frmAgendar);

        frmAgendar.connectSlotsByName();
    } // setupUi

    void retranslateUi(QDialog frmAgendar)
    {
        frmAgendar.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("frmAgendar", "Creaci\u00f3n de las agendas", null));
        twFechasOmitidas.clear();
        twFechasOmitidas.setColumnCount(1);

        QTableWidgetItem __colItem = new QTableWidgetItem();
        __colItem.setText(com.trolltech.qt.core.QCoreApplication.translate("frmAgendar", "Omitir", null));
        twFechasOmitidas.setHorizontalHeaderItem(0, __colItem);
        twFechasOmitidas.setRowCount(0);
        gbProgM.setTitle(com.trolltech.qt.core.QCoreApplication.translate("frmAgendar", "Prograci\u00f3n manual de la semana", null));
        label_6.setText(com.trolltech.qt.core.QCoreApplication.translate("frmAgendar", "Hora", null));
        teHora.setDisplayFormat(com.trolltech.qt.core.QCoreApplication.translate("frmAgendar", "HH:mm", null));
        ckbMVie.setText(com.trolltech.qt.core.QCoreApplication.translate("frmAgendar", "Vie.", null));
        ckbMLun.setText(com.trolltech.qt.core.QCoreApplication.translate("frmAgendar", "Lun.", null));
        ckbMMie.setText(com.trolltech.qt.core.QCoreApplication.translate("frmAgendar", "Mi\u00e9.", null));
        ckbMSab.setText(com.trolltech.qt.core.QCoreApplication.translate("frmAgendar", "S\u00e1b.", null));
        ckbMInv.setText(com.trolltech.qt.core.QCoreApplication.translate("frmAgendar", "&Invertir", null));
        ckbMMar.setText(com.trolltech.qt.core.QCoreApplication.translate("frmAgendar", "Mar.", null));
        ckbMDom.setText(com.trolltech.qt.core.QCoreApplication.translate("frmAgendar", "Dom.", null));
        ckbMJue.setText(com.trolltech.qt.core.QCoreApplication.translate("frmAgendar", "Jue.", null));
        label_7.setText(com.trolltech.qt.core.QCoreApplication.translate("frmAgendar", "A\u00f1adir", null));
        tbRemove.setText(com.trolltech.qt.core.QCoreApplication.translate("frmAgendar", "-", null));
        lblStat.setText("");
        twAgendas.clear();
        twAgendas.setColumnCount(4);

        QTableWidgetItem __colItem1 = new QTableWidgetItem();
        __colItem1.setText(com.trolltech.qt.core.QCoreApplication.translate("frmAgendar", "ID", null));
        twAgendas.setHorizontalHeaderItem(0, __colItem1);

        QTableWidgetItem __colItem2 = new QTableWidgetItem();
        __colItem2.setText(com.trolltech.qt.core.QCoreApplication.translate("frmAgendar", "Descripci\u00f3n", null));
        twAgendas.setHorizontalHeaderItem(1, __colItem2);

        QTableWidgetItem __colItem3 = new QTableWidgetItem();
        __colItem3.setText(com.trolltech.qt.core.QCoreApplication.translate("frmAgendar", "Profesional", null));
        twAgendas.setHorizontalHeaderItem(2, __colItem3);

        QTableWidgetItem __colItem4 = new QTableWidgetItem();
        __colItem4.setText(com.trolltech.qt.core.QCoreApplication.translate("frmAgendar", "Recurso F\u00edsico", null));
        twAgendas.setHorizontalHeaderItem(3, __colItem4);
        twAgendas.setRowCount(0);
        gbProgA.setTitle(com.trolltech.qt.core.QCoreApplication.translate("frmAgendar", "Automatizaci\u00f3n de la prograci\u00f3n semanal", null));
        label_4.setText(com.trolltech.qt.core.QCoreApplication.translate("frmAgendar", "Cant. cupos", null));
        label_5.setText(com.trolltech.qt.core.QCoreApplication.translate("frmAgendar", "Intervalo", null));
        groupBox.setTitle(com.trolltech.qt.core.QCoreApplication.translate("frmAgendar", "Aplicar a los d\u00edas", null));
        ckbALun.setText(com.trolltech.qt.core.QCoreApplication.translate("frmAgendar", "Lun.", null));
        ckbAVie.setText(com.trolltech.qt.core.QCoreApplication.translate("frmAgendar", "Vie.", null));
        ckbAMar.setText(com.trolltech.qt.core.QCoreApplication.translate("frmAgendar", "Mar.", null));
        ckbASab.setText(com.trolltech.qt.core.QCoreApplication.translate("frmAgendar", "S\u00e1b.", null));
        ckbAMie.setText(com.trolltech.qt.core.QCoreApplication.translate("frmAgendar", "Mi\u00e9.", null));
        ckbADom.setText(com.trolltech.qt.core.QCoreApplication.translate("frmAgendar", "Dom.", null));
        ckbAJue.setText(com.trolltech.qt.core.QCoreApplication.translate("frmAgendar", "Jue.", null));
        ckbAInv.setText(com.trolltech.qt.core.QCoreApplication.translate("frmAgendar", "&Invertir", null));
        btnAplicar.setText(com.trolltech.qt.core.QCoreApplication.translate("frmAgendar", "Aplicar", null));
        label_10.setText(com.trolltech.qt.core.QCoreApplication.translate("frmAgendar", "Iniciar a las", null));
        teInicio.setDisplayFormat(com.trolltech.qt.core.QCoreApplication.translate("frmAgendar", "HH:mm", null));
        btnLimpiar.setText(com.trolltech.qt.core.QCoreApplication.translate("frmAgendar", "&Limpiar", null));
        sbIntervalo.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("frmAgendar", " Intervalo en minutos entre cada cupo ", null));
        twSemana.clear();
        twSemana.setColumnCount(7);

        QTableWidgetItem __colItem5 = new QTableWidgetItem();
        __colItem5.setText(com.trolltech.qt.core.QCoreApplication.translate("frmAgendar", "Lun", null));
        twSemana.setHorizontalHeaderItem(0, __colItem5);

        QTableWidgetItem __colItem6 = new QTableWidgetItem();
        __colItem6.setText(com.trolltech.qt.core.QCoreApplication.translate("frmAgendar", "Mar", null));
        twSemana.setHorizontalHeaderItem(1, __colItem6);

        QTableWidgetItem __colItem7 = new QTableWidgetItem();
        __colItem7.setText(com.trolltech.qt.core.QCoreApplication.translate("frmAgendar", "Mi\u00e9", null));
        twSemana.setHorizontalHeaderItem(2, __colItem7);

        QTableWidgetItem __colItem8 = new QTableWidgetItem();
        __colItem8.setText(com.trolltech.qt.core.QCoreApplication.translate("frmAgendar", "Jue", null));
        twSemana.setHorizontalHeaderItem(3, __colItem8);

        QTableWidgetItem __colItem9 = new QTableWidgetItem();
        __colItem9.setText(com.trolltech.qt.core.QCoreApplication.translate("frmAgendar", "Vie", null));
        twSemana.setHorizontalHeaderItem(4, __colItem9);

        QTableWidgetItem __colItem10 = new QTableWidgetItem();
        __colItem10.setText(com.trolltech.qt.core.QCoreApplication.translate("frmAgendar", "S\u00e1b", null));
        twSemana.setHorizontalHeaderItem(5, __colItem10);

        QTableWidgetItem __colItem11 = new QTableWidgetItem();
        __colItem11.setText(com.trolltech.qt.core.QCoreApplication.translate("frmAgendar", "Dom", null));
        twSemana.setHorizontalHeaderItem(6, __colItem11);
        twSemana.setRowCount(0);
        tbAdd.setText(com.trolltech.qt.core.QCoreApplication.translate("frmAgendar", "+", null));
        gbGAgen.setTitle(com.trolltech.qt.core.QCoreApplication.translate("frmAgendar", "Generaci\u00f3n de la agenda", null));
        label_8.setText(com.trolltech.qt.core.QCoreApplication.translate("frmAgendar", "F. Inicio", null));
        label_9.setText(com.trolltech.qt.core.QCoreApplication.translate("frmAgendar", "F. T\u00e9rm.", null));
        btnIniciar.setText(com.trolltech.qt.core.QCoreApplication.translate("frmAgendar", "Iniciar el proceso\n"+
"de agendamiento", null));
        checkBox_17.setText(com.trolltech.qt.core.QCoreApplication.translate("frmAgendar", "Mostrar registro LOG", null));
        label_3.setText(com.trolltech.qt.core.QCoreApplication.translate("frmAgendar", "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0//EN\" \"http://www.w3.org/TR/REC-html40/strict.dtd\">\n"+
"<html><head><meta name=\"qrichtext\" content=\"1\" /><style type=\"text/css\">\n"+
"p, li { white-space: pre-wrap; }\n"+
"</style></head><body style=\" font-family:'Sans Serif'; font-size:9pt; font-weight:600; font-style:normal;\">\n"+
"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" color:#000000;\">PROFESIONAL A AGENDAR</span></p></body></html>", null));
        label_11.setText(com.trolltech.qt.core.QCoreApplication.translate("frmAgendar", "RR.FF.", null));
        leDesc.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("frmAgendar", " Descripci\u00f3n de la plantilla ", null));
        label.setText("");
        label_2.setText(com.trolltech.qt.core.QCoreApplication.translate("frmAgendar", "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0//EN\" \"http://www.w3.org/TR/REC-html40/strict.dtd\">\n"+
"<html><head><meta name=\"qrichtext\" content=\"1\" /><style type=\"text/css\">\n"+
"p, li { white-space: pre-wrap; }\n"+
"</style></head><body style=\" font-family:'Sans Serif'; font-size:9pt; font-weight:400; font-style:normal;\">\n"+
"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-family:'Calibri'; font-size:20pt;\">GENERACI\u00d3N AGENDAS</span></p>\n"+
"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-family:'Calibri'; font-size:10pt;\">Aqu\u00ed podr\u00e1 agregar, editar o eliminar las plantillas</span></p>\n"+
"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-family:'Calibri'; font-size:10pt;\">para generar las agendas de citaciones.</span></p></body></html>", null));
    } // retranslateUi

}

