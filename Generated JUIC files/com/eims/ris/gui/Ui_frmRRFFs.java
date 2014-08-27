/********************************************************************************
** Form generated from reading ui file 'frmRRFFs.jui'
**
** Created: jue nov 24 10:48:24 2011
**      by: Qt User Interface Compiler version 4.5.2
**
** WARNING! All changes made in this file will be lost when recompiling ui file!
********************************************************************************/

package com.eims.ris.gui;

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class Ui_frmRRFFs implements com.trolltech.qt.QUiForm<QDialog>
{
    public QPushButton btnEditar;
    public QPushButton btnEliminar;
    public QPushButton btnCerrar;
    public QLabel lblStat;
    public QLabel label;
    public QPushButton btnImprimir;
    public QPushButton btnGuardar;
    public QTableWidget twRFs;
    public QLabel label_2;
    public QPushButton btnNuevo;
    public QGroupBox gbUpdate;
    public QLabel label_3;
    public QCheckBox ckbVige;
    public QLineEdit leDesc;
    public QComboBox cmbModa;
    public QLabel label_12;

    public Ui_frmRRFFs() { super(); }

    public void setupUi(QDialog frmRRFFs)
    {
        frmRRFFs.setObjectName("frmRRFFs");
        frmRRFFs.resize(new QSize(490, 600).expandedTo(frmRRFFs.minimumSizeHint()));
        frmRRFFs.setMinimumSize(new QSize(490, 600));
        frmRRFFs.setMaximumSize(new QSize(490, 600));
        frmRRFFs.setWindowIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/sala64.png")));
        btnEditar = new QPushButton(frmRRFFs);
        btnEditar.setObjectName("btnEditar");
        btnEditar.setEnabled(false);
        btnEditar.setGeometry(new QRect(90, 90, 61, 61));
        QFont font = new QFont();
        btnEditar.setFont(font);
        btnEditar.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnEditar.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/edit48.png")));
        btnEditar.setIconSize(new QSize(48, 48));
        btnEliminar = new QPushButton(frmRRFFs);
        btnEliminar.setObjectName("btnEliminar");
        btnEliminar.setEnabled(false);
        btnEliminar.setGeometry(new QRect(330, 90, 61, 61));
        QFont font1 = new QFont();
        btnEliminar.setFont(font1);
        btnEliminar.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnEliminar.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/dele48.png")));
        btnEliminar.setIconSize(new QSize(48, 48));
        btnCerrar = new QPushButton(frmRRFFs);
        btnCerrar.setObjectName("btnCerrar");
        btnCerrar.setGeometry(new QRect(420, 170, 61, 61));
        QFont font2 = new QFont();
        btnCerrar.setFont(font2);
        btnCerrar.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnCerrar.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/shutdown64.png")));
        btnCerrar.setIconSize(new QSize(48, 48));
        lblStat = new QLabel(frmRRFFs);
        lblStat.setObjectName("lblStat");
        lblStat.setGeometry(new QRect(230, 120, 91, 31));
        QFont font3 = new QFont();
        lblStat.setFont(font3);
        lblStat.setStyleSheet("background-color: rgb(248, 255, 184);\n"+
"border:1px solid rgb(170, 170, 127);\n"+
"border-radius:4px;");
        lblStat.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));
        label = new QLabel(frmRRFFs);
        label.setObjectName("label");
        label.setGeometry(new QRect(0, 0, 491, 91));
        label.setStyleSheet("background-color: qlineargradient(spread:pad, x1:0, y1:0, x2:0, y2:1, stop:0 rgba(0, 50, 100, 255), stop:1 rgba(0, 0, 0, 0));");
        label.setPixmap(new QPixmap(("classpath:com/eims/ris/images/sala64.png")));
        label.setMargin(10);
        btnImprimir = new QPushButton(frmRRFFs);
        btnImprimir.setObjectName("btnImprimir");
        btnImprimir.setEnabled(false);
        btnImprimir.setGeometry(new QRect(420, 90, 61, 61));
        QFont font4 = new QFont();
        btnImprimir.setFont(font4);
        btnImprimir.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnImprimir.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/print48.png")));
        btnImprimir.setIconSize(new QSize(48, 48));
        btnGuardar = new QPushButton(frmRRFFs);
        btnGuardar.setObjectName("btnGuardar");
        btnGuardar.setEnabled(false);
        btnGuardar.setGeometry(new QRect(160, 90, 61, 61));
        QFont font5 = new QFont();
        btnGuardar.setFont(font5);
        btnGuardar.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnGuardar.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/save48.png")));
        btnGuardar.setIconSize(new QSize(48, 48));
        twRFs = new QTableWidget(frmRRFFs);
        twRFs.setObjectName("twRFs");
        twRFs.setGeometry(new QRect(10, 270, 471, 321));
        QFont font6 = new QFont();
        twRFs.setFont(font6);
        twRFs.setStyleSheet("QTableWidget {\n"+
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
        twRFs.setEditTriggers(com.trolltech.qt.gui.QAbstractItemView.EditTrigger.createQFlags(com.trolltech.qt.gui.QAbstractItemView.EditTrigger.NoEditTriggers));
        twRFs.setAlternatingRowColors(true);
        twRFs.setSelectionMode(com.trolltech.qt.gui.QAbstractItemView.SelectionMode.SingleSelection);
        twRFs.setSelectionBehavior(com.trolltech.qt.gui.QAbstractItemView.SelectionBehavior.SelectRows);
        label_2 = new QLabel(frmRRFFs);
        label_2.setObjectName("label_2");
        label_2.setGeometry(new QRect(90, 10, 391, 72));
        QFont font7 = new QFont();
        label_2.setFont(font7);
        btnNuevo = new QPushButton(frmRRFFs);
        btnNuevo.setObjectName("btnNuevo");
        btnNuevo.setEnabled(false);
        btnNuevo.setGeometry(new QRect(20, 90, 61, 61));
        QFont font8 = new QFont();
        btnNuevo.setFont(font8);
        btnNuevo.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnNuevo.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/nuev48.png")));
        btnNuevo.setIconSize(new QSize(48, 48));
        gbUpdate = new QGroupBox(frmRRFFs);
        gbUpdate.setObjectName("gbUpdate");
        gbUpdate.setEnabled(false);
        gbUpdate.setGeometry(new QRect(10, 160, 401, 101));
        QFont font9 = new QFont();
        gbUpdate.setFont(font9);
        label_3 = new QLabel(gbUpdate);
        label_3.setObjectName("label_3");
        label_3.setGeometry(new QRect(10, 20, 81, 16));
        QFont font10 = new QFont();
        font10.setBold(true);
        font10.setWeight(75);
        label_3.setFont(font10);
        ckbVige = new QCheckBox(gbUpdate);
        ckbVige.setObjectName("ckbVige");
        ckbVige.setGeometry(new QRect(310, 70, 81, 20));
        QFont font11 = new QFont();
        font11.setBold(true);
        font11.setWeight(75);
        ckbVige.setFont(font11);
        ckbVige.setLayoutDirection(com.trolltech.qt.core.Qt.LayoutDirection.LeftToRight);
        leDesc = new QLineEdit(gbUpdate);
        leDesc.setObjectName("leDesc");
        leDesc.setGeometry(new QRect(10, 40, 381, 20));
        leDesc.setMaxLength(50);
        cmbModa = new QComboBox(gbUpdate);
        cmbModa.setObjectName("cmbModa");
        cmbModa.setGeometry(new QRect(160, 70, 81, 22));
        label_12 = new QLabel(gbUpdate);
        label_12.setObjectName("label_12");
        label_12.setGeometry(new QRect(10, 70, 141, 20));
        QFont font12 = new QFont();
        font12.setBold(true);
        font12.setWeight(75);
        label_12.setFont(font12);
        QWidget.setTabOrder(btnNuevo, btnEditar);
        QWidget.setTabOrder(btnEditar, btnGuardar);
        QWidget.setTabOrder(btnGuardar, btnEliminar);
        QWidget.setTabOrder(btnEliminar, btnImprimir);
        QWidget.setTabOrder(btnImprimir, btnCerrar);
        QWidget.setTabOrder(btnCerrar, leDesc);
        QWidget.setTabOrder(leDesc, cmbModa);
        QWidget.setTabOrder(cmbModa, ckbVige);
        QWidget.setTabOrder(ckbVige, twRFs);
        retranslateUi(frmRRFFs);
        btnCerrar.clicked.connect(frmRRFFs, "close()");

        frmRRFFs.connectSlotsByName();
    } // setupUi

    void retranslateUi(QDialog frmRRFFs)
    {
        frmRRFFs.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("frmRRFFs", "Mantenci\u00f3n de RRFFs", null));
        lblStat.setText("");
        label.setText("");
        twRFs.clear();
        twRFs.setColumnCount(4);

        QTableWidgetItem __colItem = new QTableWidgetItem();
        __colItem.setText(com.trolltech.qt.core.QCoreApplication.translate("frmRRFFs", "ID", null));
        twRFs.setHorizontalHeaderItem(0, __colItem);

        QTableWidgetItem __colItem1 = new QTableWidgetItem();
        __colItem1.setText(com.trolltech.qt.core.QCoreApplication.translate("frmRRFFs", "Descripci\u00f3n", null));
        twRFs.setHorizontalHeaderItem(1, __colItem1);

        QTableWidgetItem __colItem2 = new QTableWidgetItem();
        __colItem2.setText(com.trolltech.qt.core.QCoreApplication.translate("frmRRFFs", "Modalidad", null));
        twRFs.setHorizontalHeaderItem(2, __colItem2);

        QTableWidgetItem __colItem3 = new QTableWidgetItem();
        __colItem3.setText(com.trolltech.qt.core.QCoreApplication.translate("frmRRFFs", "Vigente", null));
        twRFs.setHorizontalHeaderItem(3, __colItem3);
        twRFs.setRowCount(0);
        label_2.setText(com.trolltech.qt.core.QCoreApplication.translate("frmRRFFs", "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0//EN\" \"http://www.w3.org/TR/REC-html40/strict.dtd\">\n"+
"<html><head><meta name=\"qrichtext\" content=\"1\" /><style type=\"text/css\">\n"+
"p, li { white-space: pre-wrap; }\n"+
"</style></head><body style=\" font-family:'Ubuntu'; font-size:9pt; font-weight:400; font-style:normal;\">\n"+
"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-family:'Calibri'; font-size:18pt;\">MANTENCI\u00d3N DE RR.FF.</span></p>\n"+
"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-family:'Calibri'; font-size:10pt;\">Aqu\u00ed podr\u00e1 buscar, agregar, editar o eliminar los RR.FF.</span></p>\n"+
"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-family:'Calibri'; font-size:10pt;\">que posee. Haga clic en un \u00edtem para comenzar.</span></p></body></html>", null));
        gbUpdate.setTitle(com.trolltech.qt.core.QCoreApplication.translate("frmRRFFs", "Actualizaci\u00f3n del registro", null));
        label_3.setText(com.trolltech.qt.core.QCoreApplication.translate("frmRRFFs", "Descripci\u00f3n", null));
        ckbVige.setText(com.trolltech.qt.core.QCoreApplication.translate("frmRRFFs", "&Vigente", null));
        label_12.setText(com.trolltech.qt.core.QCoreApplication.translate("frmRRFFs", "Modalidad asociada", null));
    } // retranslateUi

}

