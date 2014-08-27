/********************************************************************************
** Form generated from reading ui file 'frmSistSalud.jui'
**
** Created: s�b nov 19 15:34:19 2011
**      by: Qt User Interface Compiler version 4.5.2
**
** WARNING! All changes made in this file will be lost when recompiling ui file!
********************************************************************************/

package com.eims.ris.gui;

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class Ui_frmSistSalud implements com.trolltech.qt.QUiForm<QDialog>
{
    public QGroupBox gbUpdate;
    public QLabel label_3;
    public QCheckBox ckbVige;
    public QLineEdit leDesc;
    public QPushButton btnGuardar;
    public QPushButton btnImprimir;
    public QPushButton btnCerrar;
    public QPushButton btnNuevo;
    public QLabel label;
    public QPushButton btnEliminar;
    public QTableWidget twSistSalud;
    public QLabel lblStat;
    public QPushButton btnEditar;
    public QLabel label_2;

    public Ui_frmSistSalud() { super(); }

    public void setupUi(QDialog frmSistSalud)
    {
        frmSistSalud.setObjectName("frmSistSalud");
        frmSistSalud.resize(new QSize(490, 600).expandedTo(frmSistSalud.minimumSizeHint()));
        frmSistSalud.setMinimumSize(new QSize(490, 600));
        frmSistSalud.setMaximumSize(new QSize(490, 600));
        frmSistSalud.setWindowIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/salud64.png")));
        gbUpdate = new QGroupBox(frmSistSalud);
        gbUpdate.setObjectName("gbUpdate");
        gbUpdate.setEnabled(false);
        gbUpdate.setGeometry(new QRect(10, 160, 401, 71));
        QFont font = new QFont();
        gbUpdate.setFont(font);
        label_3 = new QLabel(gbUpdate);
        label_3.setObjectName("label_3");
        label_3.setGeometry(new QRect(10, 20, 79, 16));
        QFont font1 = new QFont();
        font1.setBold(true);
        font1.setWeight(75);
        label_3.setFont(font1);
        ckbVige = new QCheckBox(gbUpdate);
        ckbVige.setObjectName("ckbVige");
        ckbVige.setGeometry(new QRect(310, 12, 77, 22));
        QFont font2 = new QFont();
        font2.setBold(true);
        font2.setWeight(75);
        ckbVige.setFont(font2);
        ckbVige.setLayoutDirection(com.trolltech.qt.core.Qt.LayoutDirection.LeftToRight);
        leDesc = new QLineEdit(gbUpdate);
        leDesc.setObjectName("leDesc");
        leDesc.setGeometry(new QRect(10, 40, 381, 22));
        leDesc.setMaxLength(50);
        btnGuardar = new QPushButton(frmSistSalud);
        btnGuardar.setObjectName("btnGuardar");
        btnGuardar.setEnabled(false);
        btnGuardar.setGeometry(new QRect(160, 90, 61, 61));
        QFont font3 = new QFont();
        btnGuardar.setFont(font3);
        btnGuardar.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnGuardar.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/save48.png")));
        btnGuardar.setIconSize(new QSize(48, 48));
        btnImprimir = new QPushButton(frmSistSalud);
        btnImprimir.setObjectName("btnImprimir");
        btnImprimir.setGeometry(new QRect(420, 90, 61, 61));
        QFont font4 = new QFont();
        btnImprimir.setFont(font4);
        btnImprimir.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnImprimir.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/print48.png")));
        btnImprimir.setIconSize(new QSize(48, 48));
        btnCerrar = new QPushButton(frmSistSalud);
        btnCerrar.setObjectName("btnCerrar");
        btnCerrar.setGeometry(new QRect(420, 170, 61, 61));
        QFont font5 = new QFont();
        btnCerrar.setFont(font5);
        btnCerrar.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnCerrar.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/shutdown64.png")));
        btnCerrar.setIconSize(new QSize(48, 48));
        btnNuevo = new QPushButton(frmSistSalud);
        btnNuevo.setObjectName("btnNuevo");
        btnNuevo.setEnabled(false);
        btnNuevo.setGeometry(new QRect(20, 90, 61, 61));
        QFont font6 = new QFont();
        btnNuevo.setFont(font6);
        btnNuevo.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnNuevo.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/nuev48.png")));
        btnNuevo.setIconSize(new QSize(48, 48));
        label = new QLabel(frmSistSalud);
        label.setObjectName("label");
        label.setGeometry(new QRect(0, 0, 491, 91));
        label.setStyleSheet("background-color: qlineargradient(spread:pad, x1:0, y1:0, x2:0, y2:1, stop:0 rgba(0, 50, 100, 255), stop:1 rgba(0, 0, 0, 0));");
        label.setPixmap(new QPixmap(("classpath:com/eims/ris/images/salud64.png")));
        label.setMargin(10);
        btnEliminar = new QPushButton(frmSistSalud);
        btnEliminar.setObjectName("btnEliminar");
        btnEliminar.setEnabled(false);
        btnEliminar.setGeometry(new QRect(330, 90, 61, 61));
        QFont font7 = new QFont();
        btnEliminar.setFont(font7);
        btnEliminar.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnEliminar.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/dele48.png")));
        btnEliminar.setIconSize(new QSize(48, 48));
        twSistSalud = new QTableWidget(frmSistSalud);
        twSistSalud.setObjectName("twSistSalud");
        twSistSalud.setGeometry(new QRect(10, 240, 471, 351));
        QFont font8 = new QFont();
        twSistSalud.setFont(font8);
        twSistSalud.setStyleSheet("QTableWidget {\n"+
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
        twSistSalud.setEditTriggers(com.trolltech.qt.gui.QAbstractItemView.EditTrigger.createQFlags(com.trolltech.qt.gui.QAbstractItemView.EditTrigger.NoEditTriggers));
        twSistSalud.setAlternatingRowColors(true);
        twSistSalud.setSelectionMode(com.trolltech.qt.gui.QAbstractItemView.SelectionMode.SingleSelection);
        twSistSalud.setSelectionBehavior(com.trolltech.qt.gui.QAbstractItemView.SelectionBehavior.SelectRows);
        lblStat = new QLabel(frmSistSalud);
        lblStat.setObjectName("lblStat");
        lblStat.setGeometry(new QRect(230, 120, 91, 31));
        QFont font9 = new QFont();
        lblStat.setFont(font9);
        lblStat.setStyleSheet("background-color: rgb(248, 255, 184);\n"+
"border:1px solid rgb(170, 170, 127);\n"+
"border-radius:4px;");
        lblStat.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));
        btnEditar = new QPushButton(frmSistSalud);
        btnEditar.setObjectName("btnEditar");
        btnEditar.setEnabled(false);
        btnEditar.setGeometry(new QRect(90, 90, 61, 61));
        QFont font10 = new QFont();
        btnEditar.setFont(font10);
        btnEditar.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnEditar.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/edit48.png")));
        btnEditar.setIconSize(new QSize(48, 48));
        label_2 = new QLabel(frmSistSalud);
        label_2.setObjectName("label_2");
        label_2.setGeometry(new QRect(90, 10, 391, 74));
        QFont font11 = new QFont();
        label_2.setFont(font11);
        QWidget.setTabOrder(leDesc, ckbVige);
        QWidget.setTabOrder(ckbVige, btnNuevo);
        QWidget.setTabOrder(btnNuevo, btnEditar);
        QWidget.setTabOrder(btnEditar, btnGuardar);
        QWidget.setTabOrder(btnGuardar, btnEliminar);
        QWidget.setTabOrder(btnEliminar, btnImprimir);
        QWidget.setTabOrder(btnImprimir, twSistSalud);
        QWidget.setTabOrder(twSistSalud, btnCerrar);
        retranslateUi(frmSistSalud);
        btnCerrar.clicked.connect(frmSistSalud, "accept()");

        frmSistSalud.connectSlotsByName();
    } // setupUi

    void retranslateUi(QDialog frmSistSalud)
    {
        frmSistSalud.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("frmSistSalud", "Mantenci\u00f3n sistemas de salud", null));
        gbUpdate.setTitle(com.trolltech.qt.core.QCoreApplication.translate("frmSistSalud", "Actualizaci\u00f3n del registro", null));
        label_3.setText(com.trolltech.qt.core.QCoreApplication.translate("frmSistSalud", "Descripci\u00f3n", null));
        ckbVige.setText(com.trolltech.qt.core.QCoreApplication.translate("frmSistSalud", "&Vigente", null));
        label.setText("");
        twSistSalud.clear();
        twSistSalud.setColumnCount(3);

        QTableWidgetItem __colItem = new QTableWidgetItem();
        __colItem.setText(com.trolltech.qt.core.QCoreApplication.translate("frmSistSalud", "ID", null));
        twSistSalud.setHorizontalHeaderItem(0, __colItem);

        QTableWidgetItem __colItem1 = new QTableWidgetItem();
        __colItem1.setText(com.trolltech.qt.core.QCoreApplication.translate("frmSistSalud", "Descripci\u00f3n", null));
        twSistSalud.setHorizontalHeaderItem(1, __colItem1);

        QTableWidgetItem __colItem2 = new QTableWidgetItem();
        __colItem2.setText(com.trolltech.qt.core.QCoreApplication.translate("frmSistSalud", "Vigente", null));
        twSistSalud.setHorizontalHeaderItem(2, __colItem2);
        twSistSalud.setRowCount(0);
        lblStat.setText("");
        label_2.setText(com.trolltech.qt.core.QCoreApplication.translate("frmSistSalud", "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0//EN\" \"http://www.w3.org/TR/REC-html40/strict.dtd\">\n"+
"<html><head><meta name=\"qrichtext\" content=\"1\" /><style type=\"text/css\">\n"+
"p, li { white-space: pre-wrap; }\n"+
"</style></head><body style=\" font-family:'Sans Serif'; font-size:9pt; font-weight:400; font-style:normal;\">\n"+
"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-family:'Calibri'; font-size:16pt;\">MANTENCI\u00d3N SISTEMAS DE SALUD</span></p>\n"+
"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-family:'Calibri'; font-size:10pt;\">Aqu\u00ed podr\u00e1 buscar, agregar, editar o eliminar los sistemas</span></p>\n"+
"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-family:'Calibri'; font-size:10pt;\">de salud. Haga clic en un \u00edtem para comenzar.</span></p></body></html>", null));
    } // retranslateUi

}

