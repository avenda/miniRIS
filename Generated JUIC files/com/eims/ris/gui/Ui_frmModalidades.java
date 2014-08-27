/********************************************************************************
** Form generated from reading ui file 'frmModalidades.jui'
**
** Created: Sun Dec 11 22:50:53 2011
**      by: Qt User Interface Compiler version 4.5.2
**
** WARNING! All changes made in this file will be lost when recompiling ui file!
********************************************************************************/

package com.eims.ris.gui;

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class Ui_frmModalidades implements com.trolltech.qt.QUiForm<QWidget>
{
    public QTableWidget twWorklist;
    public QPushButton btnBuscar;
    public QGroupBox gbBusqueda;
    public QLabel lblNombre;
    public QLineEdit leNombre;
    public QLineEdit leRun;
    public QLabel lblRun;
    public QGroupBox gbFecha;
    public QDateEdit deHasta;
    public QLabel label_3;
    public QDateEdit deDesde;
    public QLabel label_4;
    public QCheckBox cbFecha;
    public QLabel lblHeaderTitle;
    public QLabel lblHeader;
    public QLabel lblCounter;

    public Ui_frmModalidades() { super(); }

    public void setupUi(QWidget frmModalidades)
    {
        frmModalidades.setObjectName("frmModalidades");
        frmModalidades.resize(new QSize(800, 400).expandedTo(frmModalidades.minimumSizeHint()));
        frmModalidades.setMinimumSize(new QSize(800, 400));
        frmModalidades.setMaximumSize(new QSize(800, 400));
        twWorklist = new QTableWidget(frmModalidades);
        twWorklist.setObjectName("twWorklist");
        twWorklist.setGeometry(new QRect(10, 200, 781, 191));
        QFont font = new QFont();
        twWorklist.setFont(font);
        twWorklist.setStyleSheet("QTableWidget {\n"+
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
        twWorklist.setEditTriggers(com.trolltech.qt.gui.QAbstractItemView.EditTrigger.createQFlags(com.trolltech.qt.gui.QAbstractItemView.EditTrigger.NoEditTriggers));
        twWorklist.setAlternatingRowColors(true);
        twWorklist.setSelectionMode(com.trolltech.qt.gui.QAbstractItemView.SelectionMode.SingleSelection);
        twWorklist.setSelectionBehavior(com.trolltech.qt.gui.QAbstractItemView.SelectionBehavior.SelectRows);
        btnBuscar = new QPushButton(frmModalidades);
        btnBuscar.setObjectName("btnBuscar");
        btnBuscar.setGeometry(new QRect(720, 100, 71, 81));
        btnBuscar.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnBuscar.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/search64.png")));
        btnBuscar.setIconSize(new QSize(48, 48));
        gbBusqueda = new QGroupBox(frmModalidades);
        gbBusqueda.setObjectName("gbBusqueda");
        gbBusqueda.setEnabled(true);
        gbBusqueda.setGeometry(new QRect(10, 90, 701, 91));
        lblNombre = new QLabel(gbBusqueda);
        lblNombre.setObjectName("lblNombre");
        lblNombre.setEnabled(true);
        lblNombre.setGeometry(new QRect(10, 20, 81, 16));
        QFont font1 = new QFont();
        font1.setBold(true);
        font1.setWeight(75);
        lblNombre.setFont(font1);
        leNombre = new QLineEdit(gbBusqueda);
        leNombre.setObjectName("leNombre");
        leNombre.setEnabled(true);
        leNombre.setGeometry(new QRect(70, 20, 381, 22));
        leRun = new QLineEdit(gbBusqueda);
        leRun.setObjectName("leRun");
        leRun.setEnabled(true);
        leRun.setGeometry(new QRect(70, 50, 151, 22));
        lblRun = new QLabel(gbBusqueda);
        lblRun.setObjectName("lblRun");
        lblRun.setEnabled(true);
        lblRun.setGeometry(new QRect(10, 50, 81, 16));
        QFont font2 = new QFont();
        font2.setBold(true);
        font2.setWeight(75);
        lblRun.setFont(font2);
        gbFecha = new QGroupBox(gbBusqueda);
        gbFecha.setObjectName("gbFecha");
        gbFecha.setEnabled(false);
        gbFecha.setGeometry(new QRect(500, 10, 201, 81));
        deHasta = new QDateEdit(gbFecha);
        deHasta.setObjectName("deHasta");
        deHasta.setGeometry(new QRect(70, 50, 110, 22));
        deHasta.setLayoutDirection(com.trolltech.qt.core.Qt.LayoutDirection.LeftToRight);
        deHasta.setLocale(new QLocale(QLocale.Language.Spanish, QLocale.Country.Chile));
        deHasta.setCalendarPopup(true);
        label_3 = new QLabel(gbFecha);
        label_3.setObjectName("label_3");
        label_3.setGeometry(new QRect(20, 20, 53, 16));
        QFont font3 = new QFont();
        font3.setBold(true);
        font3.setWeight(75);
        label_3.setFont(font3);
        label_3.setLayoutDirection(com.trolltech.qt.core.Qt.LayoutDirection.LeftToRight);
        deDesde = new QDateEdit(gbFecha);
        deDesde.setObjectName("deDesde");
        deDesde.setGeometry(new QRect(70, 20, 110, 22));
        deDesde.setLayoutDirection(com.trolltech.qt.core.Qt.LayoutDirection.LeftToRight);
        deDesde.setLocale(new QLocale(QLocale.Language.Spanish, QLocale.Country.Chile));
        deDesde.setCalendarPopup(true);
        label_4 = new QLabel(gbFecha);
        label_4.setObjectName("label_4");
        label_4.setGeometry(new QRect(20, 50, 53, 16));
        QFont font4 = new QFont();
        font4.setBold(true);
        font4.setWeight(75);
        label_4.setFont(font4);
        label_4.setLayoutDirection(com.trolltech.qt.core.Qt.LayoutDirection.LeftToRight);
        cbFecha = new QCheckBox(gbBusqueda);
        cbFecha.setObjectName("cbFecha");
        cbFecha.setGeometry(new QRect(370, 60, 78, 21));
        cbFecha.setLayoutDirection(com.trolltech.qt.core.Qt.LayoutDirection.RightToLeft);
        lblHeaderTitle = new QLabel(frmModalidades);
        lblHeaderTitle.setObjectName("lblHeaderTitle");
        lblHeaderTitle.setGeometry(new QRect(240, 10, 391, 74));
        lblHeader = new QLabel(frmModalidades);
        lblHeader.setObjectName("lblHeader");
        lblHeader.setGeometry(new QRect(0, 0, 801, 101));
        lblHeader.setScaledContents(false);
        lblHeader.setMargin(10);
        lblCounter = new QLabel(frmModalidades);
        lblCounter.setObjectName("lblCounter");
        lblCounter.setEnabled(true);
        lblCounter.setGeometry(new QRect(10, 180, 781, 16));
        retranslateUi(frmModalidades);

        frmModalidades.connectSlotsByName();
    } // setupUi

    void retranslateUi(QWidget frmModalidades)
    {
        frmModalidades.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("frmModalidades", "Form", null));
        twWorklist.clear();
        twWorklist.setColumnCount(8);

        QTableWidgetItem __colItem = new QTableWidgetItem();
        __colItem.setText(com.trolltech.qt.core.QCoreApplication.translate("frmModalidades", "Numero Acceso", null));
        twWorklist.setHorizontalHeaderItem(0, __colItem);

        QTableWidgetItem __colItem1 = new QTableWidgetItem();
        __colItem1.setText(com.trolltech.qt.core.QCoreApplication.translate("frmModalidades", "ID Paciente", null));
        twWorklist.setHorizontalHeaderItem(1, __colItem1);

        QTableWidgetItem __colItem2 = new QTableWidgetItem();
        __colItem2.setText(com.trolltech.qt.core.QCoreApplication.translate("frmModalidades", "Nombre Paciente", null));
        twWorklist.setHorizontalHeaderItem(2, __colItem2);

        QTableWidgetItem __colItem3 = new QTableWidgetItem();
        __colItem3.setText(com.trolltech.qt.core.QCoreApplication.translate("frmModalidades", "Sexo", null));
        twWorklist.setHorizontalHeaderItem(3, __colItem3);

        QTableWidgetItem __colItem4 = new QTableWidgetItem();
        __colItem4.setText(com.trolltech.qt.core.QCoreApplication.translate("frmModalidades", "Fecha Nacimiento", null));
        twWorklist.setHorizontalHeaderItem(4, __colItem4);

        QTableWidgetItem __colItem5 = new QTableWidgetItem();
        __colItem5.setText(com.trolltech.qt.core.QCoreApplication.translate("frmModalidades", "Fecha Procedimiento", null));
        twWorklist.setHorizontalHeaderItem(5, __colItem5);

        QTableWidgetItem __colItem6 = new QTableWidgetItem();
        __colItem6.setText(com.trolltech.qt.core.QCoreApplication.translate("frmModalidades", "Codigo Proc.", null));
        twWorklist.setHorizontalHeaderItem(6, __colItem6);

        QTableWidgetItem __colItem7 = new QTableWidgetItem();
        __colItem7.setText(com.trolltech.qt.core.QCoreApplication.translate("frmModalidades", "Procedimiento", null));
        twWorklist.setHorizontalHeaderItem(7, __colItem7);
        twWorklist.setRowCount(0);
        btnBuscar.setText("");
        gbBusqueda.setTitle(com.trolltech.qt.core.QCoreApplication.translate("frmModalidades", "B\u00fasqueda", null));
        lblNombre.setText(com.trolltech.qt.core.QCoreApplication.translate("frmModalidades", "Nombre", null));
        lblRun.setText(com.trolltech.qt.core.QCoreApplication.translate("frmModalidades", "ID", null));
        gbFecha.setTitle(com.trolltech.qt.core.QCoreApplication.translate("frmModalidades", "Entre Fechas", null));
        deHasta.setDisplayFormat(com.trolltech.qt.core.QCoreApplication.translate("frmModalidades", "dd/MM/yyyy", null));
        label_3.setText(com.trolltech.qt.core.QCoreApplication.translate("frmModalidades", "Desde", null));
        deDesde.setDisplayFormat(com.trolltech.qt.core.QCoreApplication.translate("frmModalidades", "dd/MM/yyyy", null));
        label_4.setText(com.trolltech.qt.core.QCoreApplication.translate("frmModalidades", "Hasta", null));
        cbFecha.setText(com.trolltech.qt.core.QCoreApplication.translate("frmModalidades", "Fecha", null));
        lblHeaderTitle.setText(com.trolltech.qt.core.QCoreApplication.translate("frmModalidades", "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0//EN\" \"http://www.w3.org/TR/REC-html40/strict.dtd\">\n"+
"<html><head><meta name=\"qrichtext\" content=\"1\" /><style type=\"text/css\">\n"+
"p, li { white-space: pre-wrap; }\n"+
"</style></head><body style=\" font-family:'Ubuntu'; font-size:9pt; font-weight:400; font-style:normal;\">\n"+
"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-size:18pt;\">Worklist Radiograf\u00edas</span></p>\n"+
"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-family:'Calibri'; font-size:10pt;\">Aqu\u00ed podr\u00e1 buscar pacientes en espera de la realizaci\u00f3n del examen</span><span style=\" font-size:10pt;\">.</span></p></body></html>", null));
        lblHeader.setStyleSheet(com.trolltech.qt.core.QCoreApplication.translate("frmModalidades", "background-color: qlineargradient(spread:pad, x1:0, y1:0, x2:0, y2:1, stop:0 rgba(0, 50, 100, 255), stop:1 rgba(0, 0, 0, 0));", null));
        lblHeader.setText("");
        lblCounter.setText("");
    } // retranslateUi

}

