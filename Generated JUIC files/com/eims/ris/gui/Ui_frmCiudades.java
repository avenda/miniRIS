/********************************************************************************
** Form generated from reading ui file 'frmCiudades.jui'
**
** Created: s�b nov 19 15:17:34 2011
**      by: Qt User Interface Compiler version 4.5.2
**
** WARNING! All changes made in this file will be lost when recompiling ui file!
********************************************************************************/

package com.eims.ris.gui;

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class Ui_frmCiudades implements com.trolltech.qt.QUiForm<QDialog>
{
    public QPushButton btnNuevo;
    public QPushButton btnEditar;
    public QPushButton btnGuardar;
    public QGroupBox gbUpdate;
    public QLabel lblDesc;
    public QLineEdit leDesc;
    public QPushButton btnCerrar;
    public QPushButton btnImprimir;
    public QPushButton btnEliminar;
    public QLabel label;
    public QLabel label_2;
    public QTableWidget twCiudades;
    public QLabel lblStat;

    public Ui_frmCiudades() { super(); }

    public void setupUi(QDialog frmCiudades)
    {
        frmCiudades.setObjectName("frmCiudades");
        frmCiudades.resize(new QSize(490, 600).expandedTo(frmCiudades.minimumSizeHint()));
        QSizePolicy sizePolicy = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Preferred, com.trolltech.qt.gui.QSizePolicy.Policy.Preferred);
        sizePolicy.setHorizontalStretch((byte)17);
        sizePolicy.setVerticalStretch((byte)0);
        sizePolicy.setHeightForWidth(frmCiudades.sizePolicy().hasHeightForWidth());
        frmCiudades.setSizePolicy(sizePolicy);
        frmCiudades.setMinimumSize(new QSize(490, 600));
        frmCiudades.setMaximumSize(new QSize(490, 600));
        frmCiudades.setWindowIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/city64.png")));
        btnNuevo = new QPushButton(frmCiudades);
        btnNuevo.setObjectName("btnNuevo");
        btnNuevo.setGeometry(new QRect(20, 90, 61, 61));
        btnNuevo.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnNuevo.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/nuev48.png")));
        btnNuevo.setIconSize(new QSize(48, 48));
        btnEditar = new QPushButton(frmCiudades);
        btnEditar.setObjectName("btnEditar");
        btnEditar.setEnabled(false);
        btnEditar.setGeometry(new QRect(90, 90, 61, 61));
        btnEditar.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnEditar.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/edit48.png")));
        btnEditar.setIconSize(new QSize(48, 48));
        btnGuardar = new QPushButton(frmCiudades);
        btnGuardar.setObjectName("btnGuardar");
        btnGuardar.setEnabled(false);
        btnGuardar.setGeometry(new QRect(160, 90, 61, 61));
        btnGuardar.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnGuardar.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/save48.png")));
        btnGuardar.setIconSize(new QSize(48, 48));
        gbUpdate = new QGroupBox(frmCiudades);
        gbUpdate.setObjectName("gbUpdate");
        gbUpdate.setEnabled(false);
        gbUpdate.setGeometry(new QRect(10, 160, 401, 71));
        lblDesc = new QLabel(gbUpdate);
        lblDesc.setObjectName("lblDesc");
        lblDesc.setGeometry(new QRect(10, 20, 81, 16));
        QFont font = new QFont();
        font.setBold(true);
        font.setWeight(75);
        lblDesc.setFont(font);
        leDesc = new QLineEdit(gbUpdate);
        leDesc.setObjectName("leDesc");
        leDesc.setGeometry(new QRect(10, 40, 381, 22));
        btnCerrar = new QPushButton(frmCiudades);
        btnCerrar.setObjectName("btnCerrar");
        btnCerrar.setGeometry(new QRect(420, 170, 61, 61));
        btnCerrar.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnCerrar.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/shutdown64.png")));
        btnCerrar.setIconSize(new QSize(48, 48));
        btnImprimir = new QPushButton(frmCiudades);
        btnImprimir.setObjectName("btnImprimir");
        btnImprimir.setEnabled(false);
        btnImprimir.setGeometry(new QRect(420, 90, 61, 61));
        btnImprimir.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnImprimir.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/print48.png")));
        btnImprimir.setIconSize(new QSize(48, 48));
        btnEliminar = new QPushButton(frmCiudades);
        btnEliminar.setObjectName("btnEliminar");
        btnEliminar.setEnabled(false);
        btnEliminar.setGeometry(new QRect(330, 90, 61, 61));
        btnEliminar.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnEliminar.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/dele48.png")));
        btnEliminar.setIconSize(new QSize(48, 48));
        label = new QLabel(frmCiudades);
        label.setObjectName("label");
        label.setGeometry(new QRect(0, 0, 491, 91));
        label.setPixmap(new QPixmap(("classpath:com/eims/ris/images/city64.png")));
        label.setMargin(10);
        label_2 = new QLabel(frmCiudades);
        label_2.setObjectName("label_2");
        label_2.setGeometry(new QRect(90, 10, 391, 74));
        twCiudades = new QTableWidget(frmCiudades);
        twCiudades.setObjectName("twCiudades");
        twCiudades.setGeometry(new QRect(10, 240, 471, 351));
        QFont font1 = new QFont();
        twCiudades.setFont(font1);
        twCiudades.setStyleSheet("QTableWidget {\n"+
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
        twCiudades.setEditTriggers(com.trolltech.qt.gui.QAbstractItemView.EditTrigger.createQFlags(com.trolltech.qt.gui.QAbstractItemView.EditTrigger.NoEditTriggers));
        twCiudades.setAlternatingRowColors(true);
        twCiudades.setSelectionMode(com.trolltech.qt.gui.QAbstractItemView.SelectionMode.SingleSelection);
        twCiudades.setSelectionBehavior(com.trolltech.qt.gui.QAbstractItemView.SelectionBehavior.SelectRows);
        lblStat = new QLabel(frmCiudades);
        lblStat.setObjectName("lblStat");
        lblStat.setGeometry(new QRect(230, 120, 91, 31));
        QFont font2 = new QFont();
        lblStat.setFont(font2);
        lblStat.setStyleSheet("background-color: rgb(248, 255, 184);\n"+
"border:1px solid rgb(170, 170, 127);\n"+
"border-radius:4px;");
        lblStat.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));
        retranslateUi(frmCiudades);
        btnCerrar.clicked.connect(frmCiudades, "close()");

        frmCiudades.connectSlotsByName();
    } // setupUi

    void retranslateUi(QDialog frmCiudades)
    {
        frmCiudades.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("frmCiudades", "Mantenci\u00f3n de ciudades", null));
        btnNuevo.setText("");
        btnEditar.setText("");
        btnGuardar.setText("");
        gbUpdate.setTitle(com.trolltech.qt.core.QCoreApplication.translate("frmCiudades", "Actualizaci\u00f3n de Registro", null));
        lblDesc.setText(com.trolltech.qt.core.QCoreApplication.translate("frmCiudades", "Descripci\u00f3n", null));
        btnCerrar.setText("");
        btnImprimir.setText("");
        btnEliminar.setText("");
        label.setStyleSheet(com.trolltech.qt.core.QCoreApplication.translate("frmCiudades", "background-color: qlineargradient(spread:pad, x1:0, y1:0, x2:0, y2:1, stop:0 rgba(0, 50, 100, 255), stop:1 rgba(0, 0, 0, 0));", null));
        label.setText("");
        label_2.setText(com.trolltech.qt.core.QCoreApplication.translate("frmCiudades", "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0//EN\" \"http://www.w3.org/TR/REC-html40/strict.dtd\">\n"+
"<html><head><meta name=\"qrichtext\" content=\"1\" /><style type=\"text/css\">\n"+
"p, li { white-space: pre-wrap; }\n"+
"</style></head><body style=\" font-family:'Ubuntu'; font-size:9pt; font-weight:400; font-style:normal;\">\n"+
"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-size:18pt;\">MANTENCI\u00d3N DE CIUDADES</span></p>\n"+
"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-family:'Calibri'; font-size:10pt;\">Aqu\u00ed podr\u00e1 buscar, agregar, editar o eliminar</span><span style=\" font-size:10pt;\"> ciudades.</span></p>\n"+
"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-size:10pt;\">Haga clic en un \u00edtem para comenzar.</span></p></body></html>", null));
        twCiudades.clear();
        twCiudades.setColumnCount(2);

        QTableWidgetItem __colItem = new QTableWidgetItem();
        __colItem.setText(com.trolltech.qt.core.QCoreApplication.translate("frmCiudades", "ID", null));
        twCiudades.setHorizontalHeaderItem(0, __colItem);

        QTableWidgetItem __colItem1 = new QTableWidgetItem();
        __colItem1.setText(com.trolltech.qt.core.QCoreApplication.translate("frmCiudades", "Descripci\u00f3n", null));
        twCiudades.setHorizontalHeaderItem(1, __colItem1);
        twCiudades.setRowCount(0);
        lblStat.setText("");
    } // retranslateUi

}

