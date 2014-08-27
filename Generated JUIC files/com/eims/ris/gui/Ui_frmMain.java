/********************************************************************************
** Form generated from reading ui file 'frmMain.jui'
**
** Created: Sun Dec 11 18:56:43 2011
**      by: Qt User Interface Compiler version 4.5.2
**
** WARNING! All changes made in this file will be lost when recompiling ui file!
********************************************************************************/

package com.eims.ris.gui;

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class Ui_frmMain implements com.trolltech.qt.QUiForm<QMainWindow>
{
    public QWidget centralwidget;
    public QTabWidget tabWidget;
    public QWidget tab;
    public QPushButton btnMBPac;
    public QPushButton btnMRece;
    public QPushButton btnMBRec;
    public QPushButton btnMCita;
    public QPushButton btnClose;
    public QPushButton btnMPCit;
    public QLabel label_22;
    public QLabel label_23;
    public QLabel label_24;
    public QLabel label_25;
    public QLabel label_26;
    public QLabel label_27;
    public QWidget tab_2;
    public QGroupBox groupBox_4;
    public QLabel label_12;
    public QPushButton btnMRX;
    public QLabel label_13;
    public QPushButton btnMUS;
    public QLabel label_14;
    public QPushButton btnMMG;
    public QLabel label_15;
    public QPushButton btnMCT;
    public QLabel label_32;
    public QPushButton btnMMR;
    public QLabel label_33;
    public QPushButton btnMXA;
    public QGroupBox groupBox_5;
    public QLabel label_17;
    public QPushButton btnMTInf;
    public QWidget tab_3;
    public QPushButton btnMIRec;
    public QLabel label_21;
    public QLabel label_28;
    public QPushButton btnMILEs;
    public QWidget tab_4;
    public QPushButton btnMMoni;
    public QLabel label_11;
    public QPushButton btnMGRxT;
    public QLabel label_29;
    public QWidget tab_5;
    public QPushButton btnMPaci;
    public QPushButton btnMFunc;
    public QLabel label_6;
    public QLabel label_7;
    public QLabel label_8;
    public QPushButton btnMDeri;
    public QLabel label_9;
    public QPushButton btnMSSal;
    public QLabel label_10;
    public QPushButton btnMPres;
    public QPushButton btnMProf;
    public QLabel label_16;
    public QLabel label_19;
    public QPushButton btnMRRFF;
    public QPushButton btnMCiud;
    public QLabel label_30;
    public QWidget tab_6;
    public QPushButton btnMUser;
    public QLabel label_18;
    public QLabel label_20;
    public QPushButton btnMCAge;
    public QLabel label_31;
    public QPushButton btnMPref;
    public QFrame frmUser;
    public QLabel lblBGUser;
    public QLabel lblIconUser;
    public QLabel lblUser;
    public QLabel lblUser_2;
    public QLabel label_5;
    public QLabel lblLogin;
    public QLabel label;
    public QCommandLinkButton cmdLBAbout;
    public QFrame frmSQL;
    public QLabel lblCxHIS;
    public QLabel lblCxRIS;
    public QLabel label_3;
    public QLabel label_4;
    public QLabel label_2;
    public QStatusBar statusbar;

    public Ui_frmMain() { super(); }

    public void setupUi(QMainWindow frmMain)
    {
        frmMain.setObjectName("frmMain");
        frmMain.resize(new QSize(780, 450).expandedTo(frmMain.minimumSizeHint()));
        frmMain.setMinimumSize(new QSize(780, 450));
        frmMain.setWindowIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/logo.png")));
        centralwidget = new QWidget(frmMain);
        centralwidget.setObjectName("centralwidget");
        tabWidget = new QTabWidget(centralwidget);
        tabWidget.setObjectName("tabWidget");
        tabWidget.setGeometry(new QRect(0, 2, 781, 431));
        tabWidget.setStyleSheet("/*QTabWidget::pane {\n"+
"    border-top: 4px solid qlineargradient(x1:0, y1:0, x2:0, y2:1, stop:0 #FFE085, stop: 0.8 #CC9900);\n"+
"}\n"+
" \n"+
"QTabWidget::tab-bar {\n"+
"    left: 5px;\n"+
"}\n"+
" \n"+
"QTabBar::tab {\n"+
"    border: 1px solid #000000;\n"+
"    border-top-left-radius: 4px; \n"+
"    border-top-right-radius: 4px;\n"+
"    min-width: 8ex;\n"+
"    padding: 2px; \n"+
"    margin-left: 4px;\n"+
"    margin-right: 4px;\n"+
"}\n"+
"\n"+
"QTabBar::tab:selected {\n"+
"    background: qlineargradient(x1:0, y1:0, x2:0, y2:1, stop:0 #CC9900, stop: 0.8 #FFE085);\n"+
"    border-color: #000000;\n"+
"    border-bottom-color: qlineargradient(x1:0, y1:0, x2:0, y2:1, stop:0 #CC9900, stop: 0.8 #FFE085);\n"+
"}\n"+
" \n"+
"QTabBar::tab:!selected {\n"+
"    background: #C2C7CB; \n"+
"    border-bottom-color: qlineargradient(x1:0, y1:0, x2:0, y2:1, stop:0 #CC9900, stop: 0.8 #FFE085); \n"+
"    margin-top: 4px;\n"+
"}\n"+
" \n"+
"QTabBar::tab:first:selected {\n"+
"    margin-left: 0;\n"+
"}\n"+
" \n"+
"QTabBar::tab:last:selected {\n"+
"    margin-right: 0;\n"+
"}*/");
        tabWidget.setIconSize(new QSize(32, 32));
        tab = new QWidget();
        tab.setObjectName("tab");
        btnMBPac = new QPushButton(tab);
        btnMBPac.setObjectName("btnMBPac");
        btnMBPac.setEnabled(false);
        btnMBPac.setGeometry(new QRect(530, 30, 76, 75));
        btnMBPac.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnMBPac.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/bpac64.png")));
        btnMBPac.setIconSize(new QSize(64, 64));
        btnMRece = new QPushButton(tab);
        btnMRece.setObjectName("btnMRece");
        btnMRece.setEnabled(false);
        btnMRece.setGeometry(new QRect(350, 30, 76, 75));
        btnMRece.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnMRece.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/recep64.png")));
        btnMRece.setIconSize(new QSize(64, 64));
        btnMBRec = new QPushButton(tab);
        btnMBRec.setObjectName("btnMBRec");
        btnMBRec.setEnabled(false);
        btnMBRec.setGeometry(new QRect(440, 30, 76, 75));
        btnMBRec.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnMBRec.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/search64.png")));
        btnMBRec.setIconSize(new QSize(64, 64));
        btnMCita = new QPushButton(tab);
        btnMCita.setObjectName("btnMCita");
        btnMCita.setEnabled(false);
        btnMCita.setGeometry(new QRect(260, 30, 76, 75));
        btnMCita.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnMCita.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/agenda64.png")));
        btnMCita.setIconSize(new QSize(64, 64));
        btnClose = new QPushButton(tab);
        btnClose.setObjectName("btnClose");
        btnClose.setGeometry(new QRect(350, 150, 76, 75));
        btnClose.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnClose.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/close64.png")));
        btnClose.setIconSize(new QSize(64, 64));
        btnMPCit = new QPushButton(tab);
        btnMPCit.setObjectName("btnMPCit");
        btnMPCit.setEnabled(false);
        btnMPCit.setGeometry(new QRect(260, 150, 76, 75));
        btnMPCit.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnMPCit.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/pcit64.png")));
        btnMPCit.setIconSize(new QSize(64, 64));
        label_22 = new QLabel(tab);
        label_22.setObjectName("label_22");
        label_22.setGeometry(new QRect(260, 110, 76, 31));
        QFont font = new QFont();
        font.setFamily("Arial");
        font.setPointSize(8);
        label_22.setFont(font);
        label_22.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));
        label_23 = new QLabel(tab);
        label_23.setObjectName("label_23");
        label_23.setGeometry(new QRect(350, 110, 76, 31));
        QFont font1 = new QFont();
        font1.setFamily("Arial");
        font1.setPointSize(8);
        label_23.setFont(font1);
        label_23.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));
        label_24 = new QLabel(tab);
        label_24.setObjectName("label_24");
        label_24.setGeometry(new QRect(440, 110, 76, 31));
        QFont font2 = new QFont();
        font2.setFamily("Arial");
        font2.setPointSize(8);
        label_24.setFont(font2);
        label_24.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));
        label_25 = new QLabel(tab);
        label_25.setObjectName("label_25");
        label_25.setGeometry(new QRect(530, 110, 76, 31));
        QFont font3 = new QFont();
        font3.setFamily("Arial");
        font3.setPointSize(8);
        label_25.setFont(font3);
        label_25.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));
        label_26 = new QLabel(tab);
        label_26.setObjectName("label_26");
        label_26.setGeometry(new QRect(260, 230, 76, 31));
        QFont font4 = new QFont();
        font4.setFamily("Arial");
        font4.setPointSize(8);
        label_26.setFont(font4);
        label_26.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));
        label_27 = new QLabel(tab);
        label_27.setObjectName("label_27");
        label_27.setGeometry(new QRect(350, 230, 76, 31));
        QFont font5 = new QFont();
        font5.setFamily("Arial");
        font5.setPointSize(8);
        label_27.setFont(font5);
        label_27.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));
        tabWidget.addTab(tab, new QIcon(new QPixmap("classpath:com/eims/ris/images/paci64.png")), com.trolltech.qt.core.QCoreApplication.translate("frmMain", "Admisi\u00f3n", null));
        tab_2 = new QWidget();
        tab_2.setObjectName("tab_2");
        groupBox_4 = new QGroupBox(tab_2);
        groupBox_4.setObjectName("groupBox_4");
        groupBox_4.setGeometry(new QRect(260, 20, 281, 221));
        label_12 = new QLabel(groupBox_4);
        label_12.setObjectName("label_12");
        label_12.setGeometry(new QRect(10, 100, 76, 16));
        QFont font6 = new QFont();
        font6.setFamily("Arial");
        font6.setPointSize(8);
        label_12.setFont(font6);
        label_12.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));
        btnMRX = new QPushButton(groupBox_4);
        btnMRX.setObjectName("btnMRX");
        btnMRX.setEnabled(true);
        btnMRX.setGeometry(new QRect(10, 20, 76, 75));
        btnMRX.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnMRX.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/cr.png")));
        btnMRX.setIconSize(new QSize(64, 64));
        label_13 = new QLabel(groupBox_4);
        label_13.setObjectName("label_13");
        label_13.setGeometry(new QRect(10, 200, 76, 16));
        QFont font7 = new QFont();
        font7.setFamily("Arial");
        font7.setPointSize(8);
        label_13.setFont(font7);
        label_13.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));
        btnMUS = new QPushButton(groupBox_4);
        btnMUS.setObjectName("btnMUS");
        btnMUS.setEnabled(true);
        btnMUS.setGeometry(new QRect(10, 120, 76, 75));
        btnMUS.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnMUS.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/us.png")));
        btnMUS.setIconSize(new QSize(64, 64));
        label_14 = new QLabel(groupBox_4);
        label_14.setObjectName("label_14");
        label_14.setGeometry(new QRect(100, 100, 76, 16));
        QFont font8 = new QFont();
        font8.setFamily("Arial");
        font8.setPointSize(8);
        label_14.setFont(font8);
        label_14.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));
        btnMMG = new QPushButton(groupBox_4);
        btnMMG.setObjectName("btnMMG");
        btnMMG.setEnabled(true);
        btnMMG.setGeometry(new QRect(100, 20, 76, 75));
        btnMMG.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnMMG.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/mg.png")));
        btnMMG.setIconSize(new QSize(64, 64));
        label_15 = new QLabel(groupBox_4);
        label_15.setObjectName("label_15");
        label_15.setGeometry(new QRect(100, 200, 76, 16));
        QFont font9 = new QFont();
        font9.setFamily("Arial");
        font9.setPointSize(8);
        label_15.setFont(font9);
        label_15.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));
        btnMCT = new QPushButton(groupBox_4);
        btnMCT.setObjectName("btnMCT");
        btnMCT.setEnabled(true);
        btnMCT.setGeometry(new QRect(100, 120, 76, 75));
        btnMCT.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnMCT.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/ct.png")));
        btnMCT.setIconSize(new QSize(64, 64));
        label_32 = new QLabel(groupBox_4);
        label_32.setObjectName("label_32");
        label_32.setGeometry(new QRect(190, 100, 76, 16));
        QFont font10 = new QFont();
        font10.setFamily("Arial");
        font10.setPointSize(8);
        label_32.setFont(font10);
        label_32.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));
        btnMMR = new QPushButton(groupBox_4);
        btnMMR.setObjectName("btnMMR");
        btnMMR.setEnabled(true);
        btnMMR.setGeometry(new QRect(190, 20, 76, 75));
        btnMMR.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnMMR.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/mr.png")));
        btnMMR.setIconSize(new QSize(64, 64));
        label_33 = new QLabel(groupBox_4);
        label_33.setObjectName("label_33");
        label_33.setGeometry(new QRect(190, 200, 76, 16));
        QFont font11 = new QFont();
        font11.setFamily("Arial");
        font11.setPointSize(8);
        label_33.setFont(font11);
        label_33.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));
        btnMXA = new QPushButton(groupBox_4);
        btnMXA.setObjectName("btnMXA");
        btnMXA.setEnabled(true);
        btnMXA.setGeometry(new QRect(190, 120, 76, 75));
        btnMXA.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnMXA.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/xa.png")));
        btnMXA.setIconSize(new QSize(64, 64));
        groupBox_5 = new QGroupBox(tab_2);
        groupBox_5.setObjectName("groupBox_5");
        groupBox_5.setGeometry(new QRect(560, 20, 201, 221));
        label_17 = new QLabel(groupBox_5);
        label_17.setObjectName("label_17");
        label_17.setGeometry(new QRect(10, 100, 76, 16));
        QFont font12 = new QFont();
        font12.setFamily("Arial");
        font12.setPointSize(8);
        label_17.setFont(font12);
        label_17.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));
        btnMTInf = new QPushButton(groupBox_5);
        btnMTInf.setObjectName("btnMTInf");
        btnMTInf.setEnabled(false);
        btnMTInf.setGeometry(new QRect(10, 20, 76, 75));
        btnMTInf.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnMTInf.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/mic64.png")));
        btnMTInf.setIconSize(new QSize(64, 64));
        tabWidget.addTab(tab_2, new QIcon(new QPixmap("classpath:com/eims/ris/images/worklist32.png")), com.trolltech.qt.core.QCoreApplication.translate("frmMain", "Lista de Trabajo", null));
        tab_3 = new QWidget();
        tab_3.setObjectName("tab_3");
        btnMIRec = new QPushButton(tab_3);
        btnMIRec.setObjectName("btnMIRec");
        btnMIRec.setEnabled(false);
        btnMIRec.setGeometry(new QRect(260, 30, 76, 75));
        btnMIRec.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnMIRec.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/recep64.png")));
        btnMIRec.setIconSize(new QSize(64, 64));
        label_21 = new QLabel(tab_3);
        label_21.setObjectName("label_21");
        label_21.setGeometry(new QRect(260, 110, 76, 16));
        QFont font13 = new QFont();
        font13.setFamily("Arial");
        font13.setPointSize(8);
        label_21.setFont(font13);
        label_21.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));
        label_28 = new QLabel(tab_3);
        label_28.setObjectName("label_28");
        label_28.setGeometry(new QRect(350, 110, 76, 16));
        QFont font14 = new QFont();
        font14.setFamily("Arial");
        font14.setPointSize(8);
        label_28.setFont(font14);
        label_28.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));
        btnMILEs = new QPushButton(tab_3);
        btnMILEs.setObjectName("btnMILEs");
        btnMILEs.setEnabled(false);
        btnMILEs.setGeometry(new QRect(350, 30, 76, 75));
        btnMILEs.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnMILEs.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/lista_espera64.png")));
        btnMILEs.setIconSize(new QSize(64, 64));
        tabWidget.addTab(tab_3, new QIcon(new QPixmap("classpath:com/eims/ris/images/print48.png")), com.trolltech.qt.core.QCoreApplication.translate("frmMain", "Informes", null));
        tab_4 = new QWidget();
        tab_4.setObjectName("tab_4");
        btnMMoni = new QPushButton(tab_4);
        btnMMoni.setObjectName("btnMMoni");
        btnMMoni.setEnabled(false);
        btnMMoni.setGeometry(new QRect(260, 30, 76, 75));
        btnMMoni.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnMMoni.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/monitor64.png")));
        btnMMoni.setIconSize(new QSize(64, 64));
        label_11 = new QLabel(tab_4);
        label_11.setObjectName("label_11");
        label_11.setGeometry(new QRect(260, 110, 76, 16));
        QFont font15 = new QFont();
        font15.setFamily("Arial");
        font15.setPointSize(8);
        label_11.setFont(font15);
        label_11.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));
        btnMGRxT = new QPushButton(tab_4);
        btnMGRxT.setObjectName("btnMGRxT");
        btnMGRxT.setEnabled(false);
        btnMGRxT.setGeometry(new QRect(350, 30, 76, 75));
        btnMGRxT.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnMGRxT.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/tiporecep64.png")));
        btnMGRxT.setIconSize(new QSize(64, 64));
        label_29 = new QLabel(tab_4);
        label_29.setObjectName("label_29");
        label_29.setGeometry(new QRect(350, 110, 76, 31));
        QFont font16 = new QFont();
        font16.setFamily("Arial");
        font16.setPointSize(8);
        label_29.setFont(font16);
        label_29.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));
        tabWidget.addTab(tab_4, new QIcon(new QPixmap("classpath:com/eims/ris/images/chart32.png")), com.trolltech.qt.core.QCoreApplication.translate("frmMain", "Estad\u00edsticas", null));
        tab_5 = new QWidget();
        tab_5.setObjectName("tab_5");
        btnMPaci = new QPushButton(tab_5);
        btnMPaci.setObjectName("btnMPaci");
        btnMPaci.setEnabled(false);
        btnMPaci.setGeometry(new QRect(340, 140, 76, 75));
        btnMPaci.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnMPaci.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/paci64.png")));
        btnMPaci.setIconSize(new QSize(64, 64));
        btnMFunc = new QPushButton(tab_5);
        btnMFunc.setObjectName("btnMFunc");
        btnMFunc.setEnabled(false);
        btnMFunc.setGeometry(new QRect(420, 140, 76, 75));
        btnMFunc.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnMFunc.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/func64.png")));
        btnMFunc.setIconSize(new QSize(64, 64));
        label_6 = new QLabel(tab_5);
        label_6.setObjectName("label_6");
        label_6.setGeometry(new QRect(340, 220, 76, 16));
        QFont font17 = new QFont();
        font17.setFamily("Arial");
        font17.setPointSize(8);
        label_6.setFont(font17);
        label_6.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));
        label_7 = new QLabel(tab_5);
        label_7.setObjectName("label_7");
        label_7.setGeometry(new QRect(420, 220, 76, 16));
        QFont font18 = new QFont();
        font18.setFamily("Arial");
        font18.setPointSize(8);
        label_7.setFont(font18);
        label_7.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));
        label_8 = new QLabel(tab_5);
        label_8.setObjectName("label_8");
        label_8.setGeometry(new QRect(500, 110, 76, 16));
        QFont font19 = new QFont();
        font19.setFamily("Arial");
        font19.setPointSize(8);
        label_8.setFont(font19);
        label_8.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));
        btnMDeri = new QPushButton(tab_5);
        btnMDeri.setObjectName("btnMDeri");
        btnMDeri.setEnabled(false);
        btnMDeri.setGeometry(new QRect(500, 30, 76, 75));
        btnMDeri.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnMDeri.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/local64.png")));
        btnMDeri.setIconSize(new QSize(64, 64));
        label_9 = new QLabel(tab_5);
        label_9.setObjectName("label_9");
        label_9.setGeometry(new QRect(340, 110, 76, 16));
        QFont font20 = new QFont();
        font20.setFamily("Arial");
        font20.setPointSize(8);
        label_9.setFont(font20);
        label_9.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));
        btnMSSal = new QPushButton(tab_5);
        btnMSSal.setObjectName("btnMSSal");
        btnMSSal.setEnabled(false);
        btnMSSal.setGeometry(new QRect(340, 30, 76, 75));
        btnMSSal.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnMSSal.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/salud64.png")));
        btnMSSal.setIconSize(new QSize(64, 64));
        label_10 = new QLabel(tab_5);
        label_10.setObjectName("label_10");
        label_10.setGeometry(new QRect(500, 220, 76, 16));
        QFont font21 = new QFont();
        font21.setFamily("Arial");
        font21.setPointSize(8);
        label_10.setFont(font21);
        label_10.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));
        btnMPres = new QPushButton(tab_5);
        btnMPres.setObjectName("btnMPres");
        btnMPres.setEnabled(false);
        btnMPres.setGeometry(new QRect(500, 140, 76, 75));
        btnMPres.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnMPres.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/rx64.png")));
        btnMPres.setIconSize(new QSize(64, 64));
        btnMProf = new QPushButton(tab_5);
        btnMProf.setObjectName("btnMProf");
        btnMProf.setEnabled(false);
        btnMProf.setGeometry(new QRect(260, 30, 76, 75));
        btnMProf.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnMProf.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/prof64.png")));
        btnMProf.setIconSize(new QSize(64, 64));
        label_16 = new QLabel(tab_5);
        label_16.setObjectName("label_16");
        label_16.setGeometry(new QRect(260, 110, 76, 16));
        QFont font22 = new QFont();
        font22.setFamily("Arial");
        font22.setPointSize(8);
        label_16.setFont(font22);
        label_16.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));
        label_19 = new QLabel(tab_5);
        label_19.setObjectName("label_19");
        label_19.setGeometry(new QRect(420, 110, 76, 16));
        QFont font23 = new QFont();
        font23.setFamily("Arial");
        font23.setPointSize(8);
        label_19.setFont(font23);
        label_19.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));
        btnMRRFF = new QPushButton(tab_5);
        btnMRRFF.setObjectName("btnMRRFF");
        btnMRRFF.setEnabled(false);
        btnMRRFF.setGeometry(new QRect(420, 30, 76, 75));
        btnMRRFF.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnMRRFF.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/sala64.png")));
        btnMRRFF.setIconSize(new QSize(64, 64));
        btnMCiud = new QPushButton(tab_5);
        btnMCiud.setObjectName("btnMCiud");
        btnMCiud.setEnabled(false);
        btnMCiud.setGeometry(new QRect(260, 140, 76, 75));
        btnMCiud.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnMCiud.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/city64.png")));
        btnMCiud.setIconSize(new QSize(64, 64));
        label_30 = new QLabel(tab_5);
        label_30.setObjectName("label_30");
        label_30.setGeometry(new QRect(260, 220, 76, 16));
        QFont font24 = new QFont();
        font24.setFamily("Arial");
        font24.setPointSize(8);
        label_30.setFont(font24);
        label_30.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));
        tabWidget.addTab(tab_5, new QIcon(new QPixmap("classpath:com/eims/ris/images/archivo32.png")), com.trolltech.qt.core.QCoreApplication.translate("frmMain", "Archivo", null));
        tab_6 = new QWidget();
        tab_6.setObjectName("tab_6");
        btnMUser = new QPushButton(tab_6);
        btnMUser.setObjectName("btnMUser");
        btnMUser.setEnabled(false);
        btnMUser.setGeometry(new QRect(340, 130, 76, 75));
        btnMUser.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnMUser.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/user64.png")));
        btnMUser.setIconSize(new QSize(64, 64));
        label_18 = new QLabel(tab_6);
        label_18.setObjectName("label_18");
        label_18.setGeometry(new QRect(340, 210, 76, 16));
        QFont font25 = new QFont();
        font25.setFamily("Arial");
        font25.setPointSize(8);
        label_18.setFont(font25);
        label_18.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));
        label_20 = new QLabel(tab_6);
        label_20.setObjectName("label_20");
        label_20.setGeometry(new QRect(260, 110, 76, 16));
        QFont font26 = new QFont();
        font26.setFamily("Arial");
        font26.setPointSize(8);
        label_20.setFont(font26);
        label_20.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));
        btnMCAge = new QPushButton(tab_6);
        btnMCAge.setObjectName("btnMCAge");
        btnMCAge.setEnabled(false);
        btnMCAge.setGeometry(new QRect(260, 30, 76, 75));
        btnMCAge.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnMCAge.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/agendar64.png")));
        btnMCAge.setIconSize(new QSize(64, 64));
        label_31 = new QLabel(tab_6);
        label_31.setObjectName("label_31");
        label_31.setGeometry(new QRect(260, 210, 76, 16));
        QFont font27 = new QFont();
        font27.setFamily("Arial");
        font27.setPointSize(8);
        label_31.setFont(font27);
        label_31.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));
        btnMPref = new QPushButton(tab_6);
        btnMPref.setObjectName("btnMPref");
        btnMPref.setEnabled(false);
        btnMPref.setGeometry(new QRect(260, 130, 76, 75));
        btnMPref.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnMPref.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/prefe64.png")));
        btnMPref.setIconSize(new QSize(64, 64));
        tabWidget.addTab(tab_6, new QIcon(new QPixmap("classpath:com/eims/ris/images/admin32.png")), com.trolltech.qt.core.QCoreApplication.translate("frmMain", "Administraci\u00f3n", null));
        frmUser = new QFrame(centralwidget);
        frmUser.setObjectName("frmUser");
        frmUser.setGeometry(new QRect(30, 68, 221, 321));
        frmUser.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        frmUser.setFrameShadow(com.trolltech.qt.gui.QFrame.Shadow.Sunken);
        lblBGUser = new QLabel(frmUser);
        lblBGUser.setObjectName("lblBGUser");
        lblBGUser.setGeometry(new QRect(2, 2, 217, 317));
        QFont font28 = new QFont();
        font28.setFamily("Gill Sans MT Condensed");
        font28.setPointSize(12);
        lblBGUser.setFont(font28);
        lblBGUser.setStyleSheet("background-color: qlineargradient(spread:pad, x1:0, y1:0, x2:0, y2:1, stop:0 rgba(0, 0, 0, 255), stop:1 rgba(2, 19, 62, 180));");
        lblBGUser.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignLeft,com.trolltech.qt.core.Qt.AlignmentFlag.AlignTop));
        lblBGUser.setMargin(5);
        lblIconUser = new QLabel(frmUser);
        lblIconUser.setObjectName("lblIconUser");
        lblIconUser.setGeometry(new QRect(10, 40, 54, 54));
        lblIconUser.setPixmap(new QPixmap(("classpath:com/eims/ris/images/user54.png")));
        lblIconUser.setOpenExternalLinks(true);
        lblUser = new QLabel(frmUser);
        lblUser.setObjectName("lblUser");
        lblUser.setGeometry(new QRect(70, 40, 141, 16));
        QFont font29 = new QFont();
        lblUser.setFont(font29);
        lblUser_2 = new QLabel(frmUser);
        lblUser_2.setObjectName("lblUser_2");
        lblUser_2.setGeometry(new QRect(70, 55, 141, 41));
        QFont font30 = new QFont();
        lblUser_2.setFont(font30);
        lblUser_2.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignLeft,com.trolltech.qt.core.Qt.AlignmentFlag.AlignTop));
        label_5 = new QLabel(frmUser);
        label_5.setObjectName("label_5");
        label_5.setGeometry(new QRect(2, 2, 217, 21));
        label_5.setPixmap(new QPixmap(("classpath:com/eims/ris/images/bar147.png")));
        label_5.setScaledContents(true);
        lblLogin = new QLabel(frmUser);
        lblLogin.setObjectName("lblLogin");
        lblLogin.setGeometry(new QRect(10, 100, 201, 16));
        label = new QLabel(frmUser);
        label.setObjectName("label");
        label.setGeometry(new QRect(10, 160, 206, 71));
        label.setStyleSheet("");
        label.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignLeft,com.trolltech.qt.core.Qt.AlignmentFlag.AlignTop));
        cmdLBAbout = new QCommandLinkButton(frmUser);
        cmdLBAbout.setObjectName("cmdLBAbout");
        cmdLBAbout.setGeometry(new QRect(10, 120, 201, 31));
        cmdLBAbout.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        cmdLBAbout.setIconSize(new QSize(20, 20));
        frmSQL = new QFrame(frmUser);
        frmSQL.setObjectName("frmSQL");
        frmSQL.setGeometry(new QRect(30, 250, 161, 61));
        frmSQL.setStyleSheet("background: qlineargradient(x1: 0, y1: 0, x2: 0, y2: 1, stop: 0 rgba(255, 255, 255, 255), stop: 0.5 rgba(255, 255, 255, 255), stop: 0.5 rgba(254, 255, 170, 255), stop: 1 rgba(254, 255, 170, 255));\n"+
"/*background-color: rgb(248, 255, 184);*/\n"+
"border:2px solid rgb(170, 170, 127);\n"+
"border-radius:6px;");
        frmSQL.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        frmSQL.setFrameShadow(com.trolltech.qt.gui.QFrame.Shadow.Raised);
        lblCxHIS = new QLabel(frmSQL);
        lblCxHIS.setObjectName("lblCxHIS");
        lblCxHIS.setGeometry(new QRect(120, 28, 24, 24));
        lblCxHIS.setStyleSheet("background: none;\n"+
"border:none;");
        lblCxHIS.setPixmap(new QPixmap(("classpath:com/eims/ris/images/red24.png")));
        lblCxRIS = new QLabel(frmSQL);
        lblCxRIS.setObjectName("lblCxRIS");
        lblCxRIS.setGeometry(new QRect(40, 28, 24, 24));
        lblCxRIS.setStyleSheet("background: none;\n"+
"border:none;");
        lblCxRIS.setPixmap(new QPixmap(("classpath:com/eims/ris/images/green24.png")));
        label_3 = new QLabel(frmSQL);
        label_3.setObjectName("label_3");
        label_3.setGeometry(new QRect(10, 30, 23, 18));
        label_3.setStyleSheet("background: none;\n"+
"border:none;");
        label_4 = new QLabel(frmSQL);
        label_4.setObjectName("label_4");
        label_4.setGeometry(new QRect(90, 30, 24, 18));
        label_4.setStyleSheet("background: none;\n"+
"border:none;");
        label_2 = new QLabel(frmSQL);
        label_2.setObjectName("label_2");
        label_2.setGeometry(new QRect(0, 4, 161, 21));
        QFont font31 = new QFont();
        font31.setFamily("Calibri");
        font31.setPointSize(10);
        label_2.setFont(font31);
        label_2.setStyleSheet("background: none;\n"+
"border:none;");
        label_2.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignHCenter,com.trolltech.qt.core.Qt.AlignmentFlag.AlignTop));
        frmMain.setCentralWidget(centralwidget);
        statusbar = new QStatusBar(frmMain);
        statusbar.setObjectName("statusbar");
        frmMain.setStatusBar(statusbar);
        QWidget.setTabOrder(tabWidget, btnMBPac);
        QWidget.setTabOrder(btnMBPac, btnMRece);
        QWidget.setTabOrder(btnMRece, btnMBRec);
        QWidget.setTabOrder(btnMBRec, btnMCita);
        QWidget.setTabOrder(btnMCita, btnClose);
        QWidget.setTabOrder(btnClose, btnMPCit);
        QWidget.setTabOrder(btnMPCit, btnMRX);
        QWidget.setTabOrder(btnMRX, btnMUS);
        QWidget.setTabOrder(btnMUS, btnMMG);
        QWidget.setTabOrder(btnMMG, btnMCT);
        QWidget.setTabOrder(btnMCT, btnMTInf);
        QWidget.setTabOrder(btnMTInf, btnMIRec);
        QWidget.setTabOrder(btnMIRec, btnMILEs);
        QWidget.setTabOrder(btnMILEs, btnMMoni);
        QWidget.setTabOrder(btnMMoni, btnMGRxT);
        QWidget.setTabOrder(btnMGRxT, btnMProf);
        QWidget.setTabOrder(btnMProf, btnMSSal);
        QWidget.setTabOrder(btnMSSal, btnMRRFF);
        QWidget.setTabOrder(btnMRRFF, btnMDeri);
        QWidget.setTabOrder(btnMDeri, btnMCiud);
        QWidget.setTabOrder(btnMCiud, btnMPaci);
        QWidget.setTabOrder(btnMPaci, btnMFunc);
        QWidget.setTabOrder(btnMFunc, btnMPres);
        QWidget.setTabOrder(btnMPres, btnMCAge);
        QWidget.setTabOrder(btnMCAge, btnMPref);
        QWidget.setTabOrder(btnMPref, btnMUser);
        QWidget.setTabOrder(btnMUser, cmdLBAbout);
        retranslateUi(frmMain);
        btnClose.clicked.connect(frmMain, "close()");

        tabWidget.setCurrentIndex(1);


        frmMain.connectSlotsByName();
    } // setupUi

    void retranslateUi(QMainWindow frmMain)
    {
        frmMain.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("frmMain", "eHC RIS - Men\u00fa principal", null));
        btnMBPac.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("frmMain", "Buscar pacientes", null));
        btnMBPac.setWhatsThis(com.trolltech.qt.core.QCoreApplication.translate("frmMain", "Pacientes", null));
        btnMRece.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("frmMain", "Recepci\u00f3n de pacientes, m\u00e9todo abreviado [Alt+R]", null));
        btnMRece.setWhatsThis(com.trolltech.qt.core.QCoreApplication.translate("frmMain", "Recepciones", null));
        btnMRece.setShortcut(com.trolltech.qt.core.QCoreApplication.translate("frmMain", "Alt+R", null));
        btnMBRec.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("frmMain", "Buscar recepciones", null));
        btnMBRec.setWhatsThis(com.trolltech.qt.core.QCoreApplication.translate("frmMain", "BuscarRecepcion", null));
        btnMCita.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("frmMain", "Citaci\u00f3n de pacientes, m\u00e9todo abreviado [Alt+C]", null));
        btnMCita.setWhatsThis(com.trolltech.qt.core.QCoreApplication.translate("frmMain", "Citaciones", null));
        btnMCita.setShortcut(com.trolltech.qt.core.QCoreApplication.translate("frmMain", "Alt+C", null));
        btnClose.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("frmMain", "Cerrar el sistema eHC RIS, m\u00e9todo abreviado [Alt+X]", null));
        btnClose.setShortcut(com.trolltech.qt.core.QCoreApplication.translate("frmMain", "Alt+X", null));
        btnMPCit.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("frmMain", "Pacientes citados", null));
        btnMPCit.setWhatsThis(com.trolltech.qt.core.QCoreApplication.translate("frmMain", "PacientesCitados", null));
        label_22.setText(com.trolltech.qt.core.QCoreApplication.translate("frmMain", "Citar\n"+
"Pacientes", null));
        label_23.setText(com.trolltech.qt.core.QCoreApplication.translate("frmMain", "Recepcionar\n"+
"Pacientes", null));
        label_24.setText(com.trolltech.qt.core.QCoreApplication.translate("frmMain", "Buscar\n"+
"Recepciones", null));
        label_25.setText(com.trolltech.qt.core.QCoreApplication.translate("frmMain", "Buscar\n"+
"Pacientes", null));
        label_26.setText(com.trolltech.qt.core.QCoreApplication.translate("frmMain", "Consultar\n"+
"Citaciones", null));
        label_27.setText(com.trolltech.qt.core.QCoreApplication.translate("frmMain", "Salir del\n"+
"Sistema", null));
        tabWidget.setTabText(tabWidget.indexOf(tab), com.trolltech.qt.core.QCoreApplication.translate("frmMain", "Admisi\u00f3n", null));
        groupBox_4.setTitle(com.trolltech.qt.core.QCoreApplication.translate("frmMain", "Para prestaciones", null));
        label_12.setText(com.trolltech.qt.core.QCoreApplication.translate("frmMain", "Radiograf\u00edas", null));
        btnMRX.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("frmMain", "Worklist para prestaciones de radiograf\u00edas", null));
        btnMRX.setWhatsThis(com.trolltech.qt.core.QCoreApplication.translate("frmMain", "WLRx", null));
        label_13.setText(com.trolltech.qt.core.QCoreApplication.translate("frmMain", "Ecotomograf\u00edas", null));
        btnMUS.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("frmMain", "Worklist para prestaciones de ecotomograf\u00edas", null));
        btnMUS.setWhatsThis(com.trolltech.qt.core.QCoreApplication.translate("frmMain", "WLEt", null));
        label_14.setText(com.trolltech.qt.core.QCoreApplication.translate("frmMain", "Mamograf\u00edas", null));
        btnMMG.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("frmMain", "Worklist para prestaciones de mamograf\u00edas", null));
        btnMMG.setWhatsThis(com.trolltech.qt.core.QCoreApplication.translate("frmMain", "WLMg", null));
        label_15.setText(com.trolltech.qt.core.QCoreApplication.translate("frmMain", "Tomograf\u00edas", null));
        btnMCT.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("frmMain", "Worklist para prestaciones de tomograf\u00edas computadas", null));
        btnMCT.setWhatsThis(com.trolltech.qt.core.QCoreApplication.translate("frmMain", "WLTc", null));
        label_32.setText(com.trolltech.qt.core.QCoreApplication.translate("frmMain", "Res. Magn\u00e9tica", null));
        btnMMR.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("frmMain", "Worklist para prestaciones de ecotomograf\u00edas", null));
        btnMMR.setWhatsThis(com.trolltech.qt.core.QCoreApplication.translate("frmMain", "WLEt", null));
        label_33.setText(com.trolltech.qt.core.QCoreApplication.translate("frmMain", "Angiograf\u00edas", null));
        btnMXA.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("frmMain", "Worklist para prestaciones de tomograf\u00edas computadas", null));
        btnMXA.setWhatsThis(com.trolltech.qt.core.QCoreApplication.translate("frmMain", "WLTc", null));
        groupBox_5.setTitle(com.trolltech.qt.core.QCoreApplication.translate("frmMain", "Para transcripci\u00f3n de informes", null));
        label_17.setText(com.trolltech.qt.core.QCoreApplication.translate("frmMain", "Transcripci\u00f3n", null));
        btnMTInf.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("frmMain", "Worklist para transcripci\u00f3n de informes", null));
        btnMTInf.setWhatsThis(com.trolltech.qt.core.QCoreApplication.translate("frmMain", "WLIRx", null));
        tabWidget.setTabText(tabWidget.indexOf(tab_2), com.trolltech.qt.core.QCoreApplication.translate("frmMain", "Lista de Trabajo", null));
        btnMIRec.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("frmMain", "Informe recepci\u00f3n de pacientes", null));
        btnMIRec.setWhatsThis(com.trolltech.qt.core.QCoreApplication.translate("frmMain", "InfRecep", null));
        label_21.setText(com.trolltech.qt.core.QCoreApplication.translate("frmMain", "Recepciones", null));
        label_28.setText(com.trolltech.qt.core.QCoreApplication.translate("frmMain", "Lista de Espera", null));
        btnMILEs.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("frmMain", "Informe lista de espera", null));
        btnMILEs.setWhatsThis(com.trolltech.qt.core.QCoreApplication.translate("frmMain", "InfListaEspera", null));
        tabWidget.setTabText(tabWidget.indexOf(tab_3), com.trolltech.qt.core.QCoreApplication.translate("frmMain", "Informes", null));
        btnMMoni.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("frmMain", "Monitorear en tiempo real", null));
        btnMMoni.setWhatsThis(com.trolltech.qt.core.QCoreApplication.translate("frmMain", "Monitorear", null));
        label_11.setText(com.trolltech.qt.core.QCoreApplication.translate("frmMain", "Monitorear", null));
        btnMGRxT.setWhatsThis(com.trolltech.qt.core.QCoreApplication.translate("frmMain", "GrafTipoRecep", null));
        label_29.setText(com.trolltech.qt.core.QCoreApplication.translate("frmMain", "Recepciones\n"+
"por Tipo", null));
        tabWidget.setTabText(tabWidget.indexOf(tab_4), com.trolltech.qt.core.QCoreApplication.translate("frmMain", "Estad\u00edsticas", null));
        btnMPaci.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("frmMain", "Archivo de pacientes", null));
        btnMPaci.setWhatsThis(com.trolltech.qt.core.QCoreApplication.translate("frmMain", "Pacientes", null));
        btnMFunc.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("frmMain", "Archivo de funcionarios", null));
        btnMFunc.setWhatsThis(com.trolltech.qt.core.QCoreApplication.translate("frmMain", "Funcionarios", null));
        label_6.setText(com.trolltech.qt.core.QCoreApplication.translate("frmMain", "Pacientes", null));
        label_7.setText(com.trolltech.qt.core.QCoreApplication.translate("frmMain", "Funcionarios", null));
        label_8.setText(com.trolltech.qt.core.QCoreApplication.translate("frmMain", "Derivadores", null));
        btnMDeri.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("frmMain", "Mantenci\u00f3n de derivadores", null));
        btnMDeri.setWhatsThis(com.trolltech.qt.core.QCoreApplication.translate("frmMain", "Derivadores", null));
        label_9.setText(com.trolltech.qt.core.QCoreApplication.translate("frmMain", "Sistema Salud", null));
        btnMSSal.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("frmMain", "Mantenci\u00f3n sistemas de salud", null));
        btnMSSal.setWhatsThis(com.trolltech.qt.core.QCoreApplication.translate("frmMain", "SistSalud", null));
        label_10.setText(com.trolltech.qt.core.QCoreApplication.translate("frmMain", "Prestaciones", null));
        btnMPres.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("frmMain", "Archivo de prestaciones", null));
        btnMPres.setWhatsThis(com.trolltech.qt.core.QCoreApplication.translate("frmMain", "Prestaciones", null));
        btnMProf.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("frmMain", "Mantenci\u00f3n de profesiones", null));
        btnMProf.setWhatsThis(com.trolltech.qt.core.QCoreApplication.translate("frmMain", "Profesiones", null));
        label_16.setText(com.trolltech.qt.core.QCoreApplication.translate("frmMain", "Profesiones", null));
        label_19.setText(com.trolltech.qt.core.QCoreApplication.translate("frmMain", "RR.FF.", null));
        btnMRRFF.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("frmMain", "Mantenci\u00f3n de recursos f\u00edsicos", null));
        btnMRRFF.setWhatsThis(com.trolltech.qt.core.QCoreApplication.translate("frmMain", "RRFFs", null));
        btnMCiud.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("frmMain", "Archivo de ciudades", null));
        btnMCiud.setWhatsThis(com.trolltech.qt.core.QCoreApplication.translate("frmMain", "Ciudades", null));
        btnMCiud.setText("");
        label_30.setText(com.trolltech.qt.core.QCoreApplication.translate("frmMain", "Ciudades", null));
        tabWidget.setTabText(tabWidget.indexOf(tab_5), com.trolltech.qt.core.QCoreApplication.translate("frmMain", "Archivo", null));
        btnMUser.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("frmMain", "Administraci\u00f3n de usuarios, m\u00e9todo abreviado [Alt+U]", null));
        btnMUser.setWhatsThis(com.trolltech.qt.core.QCoreApplication.translate("frmMain", "Usuarios", null));
        btnMUser.setShortcut(com.trolltech.qt.core.QCoreApplication.translate("frmMain", "Alt+U", null));
        label_18.setText(com.trolltech.qt.core.QCoreApplication.translate("frmMain", "Usuarios", null));
        label_20.setText(com.trolltech.qt.core.QCoreApplication.translate("frmMain", "Crear Agendas", null));
        btnMCAge.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("frmMain", "Creaci\u00f3n de agenda de citaciones, m\u00e9todo abreviado [Alt+A]", null));
        btnMCAge.setWhatsThis(com.trolltech.qt.core.QCoreApplication.translate("frmMain", "Agendar", null));
        btnMCAge.setShortcut(com.trolltech.qt.core.QCoreApplication.translate("frmMain", "Alt+A", null));
        label_31.setText(com.trolltech.qt.core.QCoreApplication.translate("frmMain", "Preferencias", null));
        btnMPref.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("frmMain", "Creaci\u00f3n de agenda de citaciones, m\u00e9todo abreviado [Alt+A]", null));
        btnMPref.setWhatsThis(com.trolltech.qt.core.QCoreApplication.translate("frmMain", "Agendar", null));
        btnMPref.setShortcut(com.trolltech.qt.core.QCoreApplication.translate("frmMain", "Alt+A", null));
        tabWidget.setTabText(tabWidget.indexOf(tab_6), com.trolltech.qt.core.QCoreApplication.translate("frmMain", "Administraci\u00f3n", null));
        lblBGUser.setText(com.trolltech.qt.core.QCoreApplication.translate("frmMain", "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0//EN\" \"http://www.w3.org/TR/REC-html40/strict.dtd\">\n"+
"<html><head><meta name=\"qrichtext\" content=\"1\" /><style type=\"text/css\">\n"+
"p, li { white-space: pre-wrap; }\n"+
"</style></head><body style=\" font-family:'Gill Sans MT Condensed'; font-size:12pt; font-weight:400; font-style:normal;\">\n"+
"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" color:#ffffff;\">Bienvenido</span></p></body></html>", null));
        lblIconUser.setText("");
        lblUser.setText(com.trolltech.qt.core.QCoreApplication.translate("frmMain", "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0//EN\" \"http://www.w3.org/TR/REC-html40/strict.dtd\">\n"+
"<html><head><meta name=\"qrichtext\" content=\"1\" /><style type=\"text/css\">\n"+
"p, li { white-space: pre-wrap; }\n"+
"</style></head><body style=\" font-family:'MS Shell Dlg 2'; font-size:8.25pt; font-weight:400; font-style:normal;\">\n"+
"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px; font-size:8pt;\"><span style=\" color:#ffffff;\">Usuario</span></p></body></html>", null));
        lblUser_2.setText(com.trolltech.qt.core.QCoreApplication.translate("frmMain", "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0//EN\" \"http://www.w3.org/TR/REC-html40/strict.dtd\">\n"+
"<html><head><meta name=\"qrichtext\" content=\"1\" /><style type=\"text/css\">\n"+
"p, li { white-space: pre-wrap; }\n"+
"</style></head><body style=\" font-family:'MS Shell Dlg 2'; font-size:8.25pt; font-weight:400; font-style:normal;\">\n"+
"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" color:#ffffff;\">UserAccount</span></p></body></html>", null));
        lblLogin.setText(com.trolltech.qt.core.QCoreApplication.translate("frmMain", "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0//EN\" \"http://www.w3.org/TR/REC-html40/strict.dtd\">\n"+
"<html><head><meta name=\"qrichtext\" content=\"1\" /><style type=\"text/css\">\n"+
"p, li { white-space: pre-wrap; }\n"+
"</style></head><body style=\" font-family:'Calibri'; font-size:11pt; font-weight:400; font-style:normal;\">\n"+
"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-family:'MS Shell Dlg 2'; font-size:8pt; color:#ffffff;\">Logueado: 01-01-2009 18:00</span></p></body></html>", null));
        label.setText(com.trolltech.qt.core.QCoreApplication.translate("frmMain", "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0//EN\" \"http://www.w3.org/TR/REC-html40/strict.dtd\">\n"+
"<html><head><meta name=\"qrichtext\" content=\"1\" /><style type=\"text/css\">\n"+
"p, li { white-space: pre-wrap; }\n"+
"</style></head><body style=\" font-family:'Sans Serif'; font-size:9pt; font-weight:400; font-style:normal;\">\n"+
"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-family:'Calibri'; font-size:10pt; color:#e6e6e6;\">eHC RIS \u00a9 2011  v1.1</span></p>\n"+
"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-family:'Calibri'; font-size:10pt; color:#e6e6e6;\">Gesti\u00f3n para Imagenolog\u00eda</span></p>\n"+
"<p style=\"-qt-paragraph-type:empty; margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px; font-family:'Calibri'; font-size:10pt;\"></p>\n"+
"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-family:'Calibri'; font-size:10pt; color:#e6e6e6;\">Parte de la familia EIMS</span></p></body></html>", null));
        cmdLBAbout.setText(com.trolltech.qt.core.QCoreApplication.translate("frmMain", "Acerca de...", null));
        label_3.setText(com.trolltech.qt.core.QCoreApplication.translate("frmMain", "RIS", null));
        label_4.setText(com.trolltech.qt.core.QCoreApplication.translate("frmMain", "HIS", null));
        label_2.setText(com.trolltech.qt.core.QCoreApplication.translate("frmMain", "Conexi\u00f3n Servidor SQL", null));
    } // retranslateUi

}

