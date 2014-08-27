/********************************************************************************
** Form generated from reading ui file 'frmPrestaciones.jui'
**
** Created: jue nov 24 10:48:51 2011
**      by: Qt User Interface Compiler version 4.5.2
**
** WARNING! All changes made in this file will be lost when recompiling ui file!
********************************************************************************/

package com.eims.ris.gui;

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class Ui_frmPrestaciones implements com.trolltech.qt.QUiForm<QDialog>
{
    public QPushButton btnImprimir;
    public QPushButton btnCerrar;
    public QPushButton btnGuardar;
    public QPushButton btnEliminar;
    public QGroupBox gbUpdate;
    public QLabel label_3;
    public QLabel label_7;
    public QCheckBox ckbVige;
    public QLineEdit leCodi;
    public QComboBox cmbTipo;
    public QLabel label_4;
    public QPlainTextEdit pteDesc;
    public QLabel label_11;
    public QComboBox cmbRF;
    public QLabel label;
    public QLabel label_2;
    public QPushButton btnEditar;
    public QPushButton btnNuevo;
    public QLabel lblStat;
    public QTableWidget twPrestaciones;

    public Ui_frmPrestaciones() { super(); }

    public void setupUi(QDialog frmPrestaciones)
    {
        frmPrestaciones.setObjectName("frmPrestaciones");
        frmPrestaciones.resize(new QSize(640, 600).expandedTo(frmPrestaciones.minimumSizeHint()));
        frmPrestaciones.setMinimumSize(new QSize(640, 600));
        frmPrestaciones.setMaximumSize(new QSize(640, 600));
        frmPrestaciones.setWindowIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/rx64.png")));
        btnImprimir = new QPushButton(frmPrestaciones);
        btnImprimir.setObjectName("btnImprimir");
        btnImprimir.setEnabled(false);
        btnImprimir.setGeometry(new QRect(490, 90, 61, 61));
        QFont font = new QFont();
        btnImprimir.setFont(font);
        btnImprimir.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnImprimir.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/print48.png")));
        btnImprimir.setIconSize(new QSize(48, 48));
        btnCerrar = new QPushButton(frmPrestaciones);
        btnCerrar.setObjectName("btnCerrar");
        btnCerrar.setGeometry(new QRect(570, 90, 61, 61));
        QFont font1 = new QFont();
        btnCerrar.setFont(font1);
        btnCerrar.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnCerrar.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/shutdown64.png")));
        btnCerrar.setIconSize(new QSize(48, 48));
        btnGuardar = new QPushButton(frmPrestaciones);
        btnGuardar.setObjectName("btnGuardar");
        btnGuardar.setEnabled(false);
        btnGuardar.setGeometry(new QRect(160, 90, 61, 61));
        QFont font2 = new QFont();
        btnGuardar.setFont(font2);
        btnGuardar.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnGuardar.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/save48.png")));
        btnGuardar.setIconSize(new QSize(48, 48));
        btnEliminar = new QPushButton(frmPrestaciones);
        btnEliminar.setObjectName("btnEliminar");
        btnEliminar.setEnabled(false);
        btnEliminar.setGeometry(new QRect(330, 90, 61, 61));
        QFont font3 = new QFont();
        btnEliminar.setFont(font3);
        btnEliminar.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnEliminar.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/dele48.png")));
        btnEliminar.setIconSize(new QSize(48, 48));
        gbUpdate = new QGroupBox(frmPrestaciones);
        gbUpdate.setObjectName("gbUpdate");
        gbUpdate.setEnabled(false);
        gbUpdate.setGeometry(new QRect(10, 160, 621, 131));
        QFont font4 = new QFont();
        gbUpdate.setFont(font4);
        label_3 = new QLabel(gbUpdate);
        label_3.setObjectName("label_3");
        label_3.setGeometry(new QRect(10, 50, 79, 16));
        QFont font5 = new QFont();
        font5.setBold(true);
        font5.setWeight(75);
        label_3.setFont(font5);
        label_7 = new QLabel(gbUpdate);
        label_7.setObjectName("label_7");
        label_7.setGeometry(new QRect(360, 20, 29, 16));
        QFont font6 = new QFont();
        font6.setBold(true);
        font6.setWeight(75);
        label_7.setFont(font6);
        ckbVige = new QCheckBox(gbUpdate);
        ckbVige.setObjectName("ckbVige");
        ckbVige.setGeometry(new QRect(530, 100, 77, 22));
        QFont font7 = new QFont();
        font7.setBold(true);
        font7.setWeight(75);
        ckbVige.setFont(font7);
        ckbVige.setLayoutDirection(com.trolltech.qt.core.Qt.LayoutDirection.LeftToRight);
        leCodi = new QLineEdit(gbUpdate);
        leCodi.setObjectName("leCodi");
        leCodi.setGeometry(new QRect(90, 20, 101, 21));
        leCodi.setMaxLength(10);
        cmbTipo = new QComboBox(gbUpdate);
        cmbTipo.setObjectName("cmbTipo");
        cmbTipo.setGeometry(new QRect(400, 20, 211, 22));
        label_4 = new QLabel(gbUpdate);
        label_4.setObjectName("label_4");
        label_4.setGeometry(new QRect(10, 20, 47, 16));
        QFont font8 = new QFont();
        font8.setBold(true);
        font8.setWeight(75);
        label_4.setFont(font8);
        pteDesc = new QPlainTextEdit(gbUpdate);
        pteDesc.setObjectName("pteDesc");
        pteDesc.setGeometry(new QRect(90, 50, 521, 41));
        label_11 = new QLabel(gbUpdate);
        label_11.setObjectName("label_11");
        label_11.setGeometry(new QRect(10, 100, 111, 16));
        QFont font9 = new QFont();
        font9.setBold(true);
        font9.setWeight(75);
        label_11.setFont(font9);
        cmbRF = new QComboBox(gbUpdate);
        cmbRF.setObjectName("cmbRF");
        cmbRF.setGeometry(new QRect(130, 100, 251, 22));
        label = new QLabel(frmPrestaciones);
        label.setObjectName("label");
        label.setGeometry(new QRect(0, 0, 641, 91));
        label.setStyleSheet("background-color: qlineargradient(spread:pad, x1:0, y1:0, x2:0, y2:1, stop:0 rgba(0, 50, 100, 255), stop:1 rgba(0, 0, 0, 0));");
        label.setPixmap(new QPixmap(("classpath:com/eims/ris/images/rx64.png")));
        label.setMargin(10);
        label_2 = new QLabel(frmPrestaciones);
        label_2.setObjectName("label_2");
        label_2.setGeometry(new QRect(90, 10, 411, 74));
        QFont font10 = new QFont();
        label_2.setFont(font10);
        btnEditar = new QPushButton(frmPrestaciones);
        btnEditar.setObjectName("btnEditar");
        btnEditar.setEnabled(false);
        btnEditar.setGeometry(new QRect(90, 90, 61, 61));
        QFont font11 = new QFont();
        btnEditar.setFont(font11);
        btnEditar.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnEditar.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/edit48.png")));
        btnEditar.setIconSize(new QSize(48, 48));
        btnNuevo = new QPushButton(frmPrestaciones);
        btnNuevo.setObjectName("btnNuevo");
        btnNuevo.setEnabled(false);
        btnNuevo.setGeometry(new QRect(20, 90, 61, 61));
        QFont font12 = new QFont();
        btnNuevo.setFont(font12);
        btnNuevo.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnNuevo.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/nuev48.png")));
        btnNuevo.setIconSize(new QSize(48, 48));
        lblStat = new QLabel(frmPrestaciones);
        lblStat.setObjectName("lblStat");
        lblStat.setGeometry(new QRect(230, 120, 91, 31));
        QFont font13 = new QFont();
        lblStat.setFont(font13);
        lblStat.setStyleSheet("background-color: rgb(248, 255, 184);\n"+
"border:1px solid rgb(170, 170, 127);\n"+
"border-radius:4px;");
        lblStat.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));
        twPrestaciones = new QTableWidget(frmPrestaciones);
        twPrestaciones.setObjectName("twPrestaciones");
        twPrestaciones.setGeometry(new QRect(10, 300, 621, 291));
        QFont font14 = new QFont();
        twPrestaciones.setFont(font14);
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
        QWidget.setTabOrder(btnNuevo, btnEditar);
        QWidget.setTabOrder(btnEditar, btnGuardar);
        QWidget.setTabOrder(btnGuardar, btnEliminar);
        QWidget.setTabOrder(btnEliminar, btnImprimir);
        QWidget.setTabOrder(btnImprimir, btnCerrar);
        QWidget.setTabOrder(btnCerrar, leCodi);
        QWidget.setTabOrder(leCodi, cmbTipo);
        QWidget.setTabOrder(cmbTipo, pteDesc);
        QWidget.setTabOrder(pteDesc, cmbRF);
        QWidget.setTabOrder(cmbRF, ckbVige);
        QWidget.setTabOrder(ckbVige, twPrestaciones);
        retranslateUi(frmPrestaciones);
        btnCerrar.clicked.connect(frmPrestaciones, "close()");

        frmPrestaciones.connectSlotsByName();
    } // setupUi

    void retranslateUi(QDialog frmPrestaciones)
    {
        frmPrestaciones.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("frmPrestaciones", "Archivo de prestaciones", null));
        gbUpdate.setTitle(com.trolltech.qt.core.QCoreApplication.translate("frmPrestaciones", "Actualizaci\u00f3n del registro", null));
        label_3.setText(com.trolltech.qt.core.QCoreApplication.translate("frmPrestaciones", "Descripci\u00f3n", null));
        label_7.setText(com.trolltech.qt.core.QCoreApplication.translate("frmPrestaciones", "Tipo", null));
        ckbVige.setText(com.trolltech.qt.core.QCoreApplication.translate("frmPrestaciones", "&Vigente", null));
        label_4.setText(com.trolltech.qt.core.QCoreApplication.translate("frmPrestaciones", "C\u00f3digo", null));
        label_11.setText(com.trolltech.qt.core.QCoreApplication.translate("frmPrestaciones", "RR.FF. asociado", null));
        label.setText("");
        label_2.setText(com.trolltech.qt.core.QCoreApplication.translate("frmPrestaciones", "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0//EN\" \"http://www.w3.org/TR/REC-html40/strict.dtd\">\n"+
"<html><head><meta name=\"qrichtext\" content=\"1\" /><style type=\"text/css\">\n"+
"p, li { white-space: pre-wrap; }\n"+
"</style></head><body style=\" font-family:'Ubuntu'; font-size:9pt; font-weight:400; font-style:normal;\">\n"+
"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-family:'Calibri'; font-size:18pt;\">ARCHIVO DE PRESTACIONES</span></p>\n"+
"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-family:'Calibri'; font-size:10pt;\">Aqu\u00ed podr\u00e1 buscar, agregar, editar o eliminar prestaciones</span></p>\n"+
"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-family:'Calibri'; font-size:10pt;\">realizadas en su unidad. Haga clic en un \u00edtem para comenzar.</span></p></body></html>", null));
        lblStat.setText("");
        twPrestaciones.clear();
        twPrestaciones.setColumnCount(5);

        QTableWidgetItem __colItem = new QTableWidgetItem();
        __colItem.setText(com.trolltech.qt.core.QCoreApplication.translate("frmPrestaciones", "C\u00f3digo", null));
        twPrestaciones.setHorizontalHeaderItem(0, __colItem);

        QTableWidgetItem __colItem1 = new QTableWidgetItem();
        __colItem1.setText(com.trolltech.qt.core.QCoreApplication.translate("frmPrestaciones", "Tipo", null));
        twPrestaciones.setHorizontalHeaderItem(1, __colItem1);

        QTableWidgetItem __colItem2 = new QTableWidgetItem();
        __colItem2.setText(com.trolltech.qt.core.QCoreApplication.translate("frmPrestaciones", "Descripci\u00f3n", null));
        twPrestaciones.setHorizontalHeaderItem(2, __colItem2);

        QTableWidgetItem __colItem3 = new QTableWidgetItem();
        __colItem3.setText(com.trolltech.qt.core.QCoreApplication.translate("frmPrestaciones", "RR.FF. Asociado", null));
        twPrestaciones.setHorizontalHeaderItem(3, __colItem3);

        QTableWidgetItem __colItem4 = new QTableWidgetItem();
        __colItem4.setText(com.trolltech.qt.core.QCoreApplication.translate("frmPrestaciones", "Vigente", null));
        twPrestaciones.setHorizontalHeaderItem(4, __colItem4);
        twPrestaciones.setRowCount(0);
    } // retranslateUi

}

