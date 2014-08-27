/********************************************************************************
** Form generated from reading ui file 'frmDerivadores.jui'
**
** Created: s�b nov 19 15:49:11 2011
**      by: Qt User Interface Compiler version 4.5.2
**
** WARNING! All changes made in this file will be lost when recompiling ui file!
********************************************************************************/

package com.eims.ris.gui;

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class Ui_frmDerivadores implements com.trolltech.qt.QUiForm<QDialog>
{
    public QPushButton btnEditar;
    public QPushButton btnEliminar;
    public QPushButton btnGuardar;
    public QGroupBox gbUpdate;
    public QLabel label_3;
    public QLabel label_7;
    public QCheckBox ckbVige;
    public QLineEdit leDesc;
    public QComboBox cmbTipo;
    public QTableWidget twDerivadores;
    public QPushButton btnImprimir;
    public QPushButton btnNuevo;
    public QPushButton btnCerrar;
    public QLabel lblStat;
    public QLabel label;
    public QLabel label_2;

    public Ui_frmDerivadores() { super(); }

    public void setupUi(QDialog frmDerivadores)
    {
        frmDerivadores.setObjectName("frmDerivadores");
        frmDerivadores.resize(new QSize(490, 600).expandedTo(frmDerivadores.minimumSizeHint()));
        frmDerivadores.setMinimumSize(new QSize(490, 600));
        frmDerivadores.setMaximumSize(new QSize(490, 600));
        frmDerivadores.setWindowIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/local64.png")));
        btnEditar = new QPushButton(frmDerivadores);
        btnEditar.setObjectName("btnEditar");
        btnEditar.setEnabled(false);
        btnEditar.setGeometry(new QRect(90, 90, 61, 61));
        QFont font = new QFont();
        btnEditar.setFont(font);
        btnEditar.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnEditar.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/edit48.png")));
        btnEditar.setIconSize(new QSize(48, 48));
        btnEliminar = new QPushButton(frmDerivadores);
        btnEliminar.setObjectName("btnEliminar");
        btnEliminar.setEnabled(false);
        btnEliminar.setGeometry(new QRect(330, 90, 61, 61));
        QFont font1 = new QFont();
        btnEliminar.setFont(font1);
        btnEliminar.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnEliminar.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/dele48.png")));
        btnEliminar.setIconSize(new QSize(48, 48));
        btnGuardar = new QPushButton(frmDerivadores);
        btnGuardar.setObjectName("btnGuardar");
        btnGuardar.setEnabled(false);
        btnGuardar.setGeometry(new QRect(160, 90, 61, 61));
        QFont font2 = new QFont();
        btnGuardar.setFont(font2);
        btnGuardar.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnGuardar.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/save48.png")));
        btnGuardar.setIconSize(new QSize(48, 48));
        gbUpdate = new QGroupBox(frmDerivadores);
        gbUpdate.setObjectName("gbUpdate");
        gbUpdate.setEnabled(false);
        gbUpdate.setGeometry(new QRect(10, 160, 401, 81));
        QFont font3 = new QFont();
        gbUpdate.setFont(font3);
        label_3 = new QLabel(gbUpdate);
        label_3.setObjectName("label_3");
        label_3.setGeometry(new QRect(10, 50, 79, 16));
        QFont font4 = new QFont();
        font4.setBold(true);
        font4.setWeight(75);
        label_3.setFont(font4);
        label_7 = new QLabel(gbUpdate);
        label_7.setObjectName("label_7");
        label_7.setGeometry(new QRect(10, 20, 29, 16));
        QFont font5 = new QFont();
        font5.setBold(true);
        font5.setWeight(75);
        label_7.setFont(font5);
        ckbVige = new QCheckBox(gbUpdate);
        ckbVige.setObjectName("ckbVige");
        ckbVige.setGeometry(new QRect(310, 20, 77, 22));
        QFont font6 = new QFont();
        font6.setBold(true);
        font6.setWeight(75);
        ckbVige.setFont(font6);
        ckbVige.setLayoutDirection(com.trolltech.qt.core.Qt.LayoutDirection.LeftToRight);
        leDesc = new QLineEdit(gbUpdate);
        leDesc.setObjectName("leDesc");
        leDesc.setGeometry(new QRect(90, 50, 301, 22));
        cmbTipo = new QComboBox(gbUpdate);
        cmbTipo.setObjectName("cmbTipo");
        cmbTipo.setGeometry(new QRect(90, 20, 131, 22));
        twDerivadores = new QTableWidget(frmDerivadores);
        twDerivadores.setObjectName("twDerivadores");
        twDerivadores.setGeometry(new QRect(10, 250, 471, 341));
        QFont font7 = new QFont();
        twDerivadores.setFont(font7);
        twDerivadores.setStyleSheet("QTableWidget {\n"+
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
        twDerivadores.setEditTriggers(com.trolltech.qt.gui.QAbstractItemView.EditTrigger.createQFlags(com.trolltech.qt.gui.QAbstractItemView.EditTrigger.NoEditTriggers));
        twDerivadores.setAlternatingRowColors(true);
        twDerivadores.setSelectionMode(com.trolltech.qt.gui.QAbstractItemView.SelectionMode.SingleSelection);
        twDerivadores.setSelectionBehavior(com.trolltech.qt.gui.QAbstractItemView.SelectionBehavior.SelectRows);
        btnImprimir = new QPushButton(frmDerivadores);
        btnImprimir.setObjectName("btnImprimir");
        btnImprimir.setEnabled(false);
        btnImprimir.setGeometry(new QRect(420, 90, 61, 61));
        QFont font8 = new QFont();
        btnImprimir.setFont(font8);
        btnImprimir.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnImprimir.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/print48.png")));
        btnImprimir.setIconSize(new QSize(48, 48));
        btnNuevo = new QPushButton(frmDerivadores);
        btnNuevo.setObjectName("btnNuevo");
        btnNuevo.setEnabled(false);
        btnNuevo.setGeometry(new QRect(20, 90, 61, 61));
        QFont font9 = new QFont();
        btnNuevo.setFont(font9);
        btnNuevo.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnNuevo.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/nuev48.png")));
        btnNuevo.setIconSize(new QSize(48, 48));
        btnCerrar = new QPushButton(frmDerivadores);
        btnCerrar.setObjectName("btnCerrar");
        btnCerrar.setGeometry(new QRect(420, 170, 61, 61));
        QFont font10 = new QFont();
        btnCerrar.setFont(font10);
        btnCerrar.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnCerrar.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/shutdown64.png")));
        btnCerrar.setIconSize(new QSize(48, 48));
        lblStat = new QLabel(frmDerivadores);
        lblStat.setObjectName("lblStat");
        lblStat.setGeometry(new QRect(230, 120, 91, 31));
        QFont font11 = new QFont();
        lblStat.setFont(font11);
        lblStat.setStyleSheet("background-color: rgb(248, 255, 184);\n"+
"border:1px solid rgb(170, 170, 127);\n"+
"border-radius:4px;");
        lblStat.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));
        label = new QLabel(frmDerivadores);
        label.setObjectName("label");
        label.setGeometry(new QRect(0, 0, 491, 91));
        label.setStyleSheet("background-color: qlineargradient(spread:pad, x1:0, y1:0, x2:0, y2:1, stop:0 rgba(0, 50, 100, 255), stop:1 rgba(0, 0, 0, 0));");
        label.setPixmap(new QPixmap(("classpath:com/eims/ris/images/local64.png")));
        label.setMargin(10);
        label_2 = new QLabel(frmDerivadores);
        label_2.setObjectName("label_2");
        label_2.setGeometry(new QRect(90, 10, 391, 74));
        QFont font12 = new QFont();
        label_2.setFont(font12);
        QWidget.setTabOrder(cmbTipo, leDesc);
        QWidget.setTabOrder(leDesc, ckbVige);
        QWidget.setTabOrder(ckbVige, btnNuevo);
        QWidget.setTabOrder(btnNuevo, btnEditar);
        QWidget.setTabOrder(btnEditar, btnGuardar);
        QWidget.setTabOrder(btnGuardar, btnEliminar);
        QWidget.setTabOrder(btnEliminar, btnImprimir);
        QWidget.setTabOrder(btnImprimir, twDerivadores);
        QWidget.setTabOrder(twDerivadores, btnCerrar);
        retranslateUi(frmDerivadores);
        btnCerrar.clicked.connect(frmDerivadores, "accept()");

        frmDerivadores.connectSlotsByName();
    } // setupUi

    void retranslateUi(QDialog frmDerivadores)
    {
        frmDerivadores.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("frmDerivadores", "Mantenci\u00f3n de derivadores", null));
        gbUpdate.setTitle(com.trolltech.qt.core.QCoreApplication.translate("frmDerivadores", "Actualizaci\u00f3n del registro", null));
        label_3.setText(com.trolltech.qt.core.QCoreApplication.translate("frmDerivadores", "Descripci\u00f3n", null));
        label_7.setText(com.trolltech.qt.core.QCoreApplication.translate("frmDerivadores", "Tipo", null));
        ckbVige.setText(com.trolltech.qt.core.QCoreApplication.translate("frmDerivadores", "&Vigente", null));
        twDerivadores.clear();
        twDerivadores.setColumnCount(4);

        QTableWidgetItem __colItem = new QTableWidgetItem();
        __colItem.setText(com.trolltech.qt.core.QCoreApplication.translate("frmDerivadores", "ID", null));
        twDerivadores.setHorizontalHeaderItem(0, __colItem);

        QTableWidgetItem __colItem1 = new QTableWidgetItem();
        __colItem1.setText(com.trolltech.qt.core.QCoreApplication.translate("frmDerivadores", "Tipo", null));
        twDerivadores.setHorizontalHeaderItem(1, __colItem1);

        QTableWidgetItem __colItem2 = new QTableWidgetItem();
        __colItem2.setText(com.trolltech.qt.core.QCoreApplication.translate("frmDerivadores", "Descripci\u00f3n", null));
        twDerivadores.setHorizontalHeaderItem(2, __colItem2);

        QTableWidgetItem __colItem3 = new QTableWidgetItem();
        __colItem3.setText(com.trolltech.qt.core.QCoreApplication.translate("frmDerivadores", "Vigente", null));
        twDerivadores.setHorizontalHeaderItem(3, __colItem3);
        twDerivadores.setRowCount(0);
        lblStat.setText("");
        label.setText("");
        label_2.setText(com.trolltech.qt.core.QCoreApplication.translate("frmDerivadores", "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0//EN\" \"http://www.w3.org/TR/REC-html40/strict.dtd\">\n"+
"<html><head><meta name=\"qrichtext\" content=\"1\" /><style type=\"text/css\">\n"+
"p, li { white-space: pre-wrap; }\n"+
"</style></head><body style=\" font-family:'Ubuntu'; font-size:9pt; font-weight:400; font-style:normal;\">\n"+
"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-family:'Calibri'; font-size:18pt;\">MANTENCI\u00d3N DE DERIVADORES</span></p>\n"+
"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-family:'Calibri'; font-size:10pt;\">Aqu\u00ed podr\u00e1 buscar, agregar, editar o eliminar unidades</span></p>\n"+
"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-family:'Calibri'; font-size:10pt;\">de derivaci\u00f3n. Haga clic en un \u00edtem para comenzar.</span></p></body></html>", null));
    } // retranslateUi

}

