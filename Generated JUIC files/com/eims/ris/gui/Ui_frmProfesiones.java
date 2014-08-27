/********************************************************************************
** Form generated from reading ui file 'frmProfesiones.jui'
**
** Created: s�b nov 19 15:49:11 2011
**      by: Qt User Interface Compiler version 4.5.2
**
** WARNING! All changes made in this file will be lost when recompiling ui file!
********************************************************************************/

package com.eims.ris.gui;

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class Ui_frmProfesiones implements com.trolltech.qt.QUiForm<QDialog>
{
    public QPushButton btnNuevo;
    public QLabel label;
    public QLabel label_2;
    public QTableWidget twProfesiones;
    public QLabel lblStat;
    public QGroupBox gbUpdate;
    public QLabel label_3;
    public QCheckBox ckbVige;
    public QLineEdit leDesc;
    public QLabel label_4;
    public QLineEdit leAbre;
    public QPushButton btnEliminar;
    public QPushButton btnImprimir;
    public QPushButton btnCerrar;
    public QPushButton btnEditar;
    public QPushButton btnGuardar;

    public Ui_frmProfesiones() { super(); }

    public void setupUi(QDialog frmProfesiones)
    {
        frmProfesiones.setObjectName("frmProfesiones");
        frmProfesiones.resize(new QSize(490, 600).expandedTo(frmProfesiones.minimumSizeHint()));
        frmProfesiones.setMinimumSize(new QSize(490, 600));
        frmProfesiones.setMaximumSize(new QSize(490, 600));
        frmProfesiones.setWindowIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/prof64.png")));
        btnNuevo = new QPushButton(frmProfesiones);
        btnNuevo.setObjectName("btnNuevo");
        btnNuevo.setEnabled(false);
        btnNuevo.setGeometry(new QRect(20, 90, 61, 61));
        QFont font = new QFont();
        btnNuevo.setFont(font);
        btnNuevo.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnNuevo.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/nuev48.png")));
        btnNuevo.setIconSize(new QSize(48, 48));
        label = new QLabel(frmProfesiones);
        label.setObjectName("label");
        label.setGeometry(new QRect(0, 0, 491, 91));
        label.setStyleSheet("background-color: qlineargradient(spread:pad, x1:0, y1:0, x2:0, y2:1, stop:0 rgba(0, 50, 100, 255), stop:1 rgba(0, 0, 0, 0));");
        label.setPixmap(new QPixmap(("classpath:com/eims/ris/images/prof64.png")));
        label.setMargin(10);
        label_2 = new QLabel(frmProfesiones);
        label_2.setObjectName("label_2");
        label_2.setGeometry(new QRect(90, 10, 391, 74));
        QFont font1 = new QFont();
        label_2.setFont(font1);
        twProfesiones = new QTableWidget(frmProfesiones);
        twProfesiones.setObjectName("twProfesiones");
        twProfesiones.setGeometry(new QRect(10, 240, 471, 351));
        QFont font2 = new QFont();
        twProfesiones.setFont(font2);
        twProfesiones.setStyleSheet("QTableWidget {\n"+
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
        twProfesiones.setEditTriggers(com.trolltech.qt.gui.QAbstractItemView.EditTrigger.createQFlags(com.trolltech.qt.gui.QAbstractItemView.EditTrigger.NoEditTriggers));
        twProfesiones.setAlternatingRowColors(true);
        twProfesiones.setSelectionMode(com.trolltech.qt.gui.QAbstractItemView.SelectionMode.SingleSelection);
        twProfesiones.setSelectionBehavior(com.trolltech.qt.gui.QAbstractItemView.SelectionBehavior.SelectRows);
        lblStat = new QLabel(frmProfesiones);
        lblStat.setObjectName("lblStat");
        lblStat.setGeometry(new QRect(230, 120, 91, 31));
        QFont font3 = new QFont();
        lblStat.setFont(font3);
        lblStat.setStyleSheet("background-color: rgb(248, 255, 184);\n"+
"border:1px solid rgb(170, 170, 127);\n"+
"border-radius:4px;");
        lblStat.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));
        gbUpdate = new QGroupBox(frmProfesiones);
        gbUpdate.setObjectName("gbUpdate");
        gbUpdate.setEnabled(false);
        gbUpdate.setGeometry(new QRect(10, 160, 401, 71));
        QFont font4 = new QFont();
        gbUpdate.setFont(font4);
        label_3 = new QLabel(gbUpdate);
        label_3.setObjectName("label_3");
        label_3.setGeometry(new QRect(10, 20, 79, 16));
        QFont font5 = new QFont();
        font5.setBold(true);
        font5.setWeight(75);
        label_3.setFont(font5);
        ckbVige = new QCheckBox(gbUpdate);
        ckbVige.setObjectName("ckbVige");
        ckbVige.setGeometry(new QRect(320, 18, 77, 22));
        QFont font6 = new QFont();
        font6.setBold(true);
        font6.setWeight(75);
        ckbVige.setFont(font6);
        ckbVige.setLayoutDirection(com.trolltech.qt.core.Qt.LayoutDirection.LeftToRight);
        leDesc = new QLineEdit(gbUpdate);
        leDesc.setObjectName("leDesc");
        leDesc.setGeometry(new QRect(10, 40, 381, 20));
        leDesc.setMaxLength(50);
        label_4 = new QLabel(gbUpdate);
        label_4.setObjectName("label_4");
        label_4.setGeometry(new QRect(150, 20, 44, 16));
        QFont font7 = new QFont();
        font7.setBold(true);
        font7.setWeight(75);
        label_4.setFont(font7);
        leAbre = new QLineEdit(gbUpdate);
        leAbre.setObjectName("leAbre");
        leAbre.setGeometry(new QRect(200, 19, 61, 20));
        leAbre.setMaxLength(4);
        btnEliminar = new QPushButton(frmProfesiones);
        btnEliminar.setObjectName("btnEliminar");
        btnEliminar.setEnabled(false);
        btnEliminar.setGeometry(new QRect(330, 90, 61, 61));
        QFont font8 = new QFont();
        btnEliminar.setFont(font8);
        btnEliminar.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnEliminar.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/dele48.png")));
        btnEliminar.setIconSize(new QSize(48, 48));
        btnImprimir = new QPushButton(frmProfesiones);
        btnImprimir.setObjectName("btnImprimir");
        btnImprimir.setEnabled(false);
        btnImprimir.setGeometry(new QRect(420, 90, 61, 61));
        QFont font9 = new QFont();
        btnImprimir.setFont(font9);
        btnImprimir.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnImprimir.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/print48.png")));
        btnImprimir.setIconSize(new QSize(48, 48));
        btnCerrar = new QPushButton(frmProfesiones);
        btnCerrar.setObjectName("btnCerrar");
        btnCerrar.setGeometry(new QRect(420, 170, 61, 61));
        QFont font10 = new QFont();
        btnCerrar.setFont(font10);
        btnCerrar.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnCerrar.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/shutdown64.png")));
        btnCerrar.setIconSize(new QSize(48, 48));
        btnEditar = new QPushButton(frmProfesiones);
        btnEditar.setObjectName("btnEditar");
        btnEditar.setEnabled(false);
        btnEditar.setGeometry(new QRect(90, 90, 61, 61));
        QFont font11 = new QFont();
        btnEditar.setFont(font11);
        btnEditar.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnEditar.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/edit48.png")));
        btnEditar.setIconSize(new QSize(48, 48));
        btnGuardar = new QPushButton(frmProfesiones);
        btnGuardar.setObjectName("btnGuardar");
        btnGuardar.setEnabled(false);
        btnGuardar.setGeometry(new QRect(160, 90, 61, 61));
        QFont font12 = new QFont();
        btnGuardar.setFont(font12);
        btnGuardar.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnGuardar.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/save48.png")));
        btnGuardar.setIconSize(new QSize(48, 48));
        retranslateUi(frmProfesiones);
        btnCerrar.clicked.connect(frmProfesiones, "close()");

        frmProfesiones.connectSlotsByName();
    } // setupUi

    void retranslateUi(QDialog frmProfesiones)
    {
        frmProfesiones.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("frmProfesiones", "Mantenci\u00f3n de Profesiones", null));
        label.setText("");
        label_2.setText(com.trolltech.qt.core.QCoreApplication.translate("frmProfesiones", "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0//EN\" \"http://www.w3.org/TR/REC-html40/strict.dtd\">\n"+
"<html><head><meta name=\"qrichtext\" content=\"1\" /><style type=\"text/css\">\n"+
"p, li { white-space: pre-wrap; }\n"+
"</style></head><body style=\" font-family:'Ubuntu'; font-size:9pt; font-weight:400; font-style:normal;\">\n"+
"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-family:'Calibri'; font-size:18pt;\">MANTENCI\u00d3N DE PROFESIONES</span></p>\n"+
"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-family:'Calibri'; font-size:10pt;\">Aqu\u00ed podr\u00e1 buscar, agregar, editar o eliminar las profesiones.</span></p>\n"+
"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-family:'Calibri'; font-size:10pt;\">Haga clic en un \u00edtem para comenzar.</span></p></body></html>", null));
        twProfesiones.clear();
        twProfesiones.setColumnCount(4);

        QTableWidgetItem __colItem = new QTableWidgetItem();
        __colItem.setText(com.trolltech.qt.core.QCoreApplication.translate("frmProfesiones", "ID", null));
        twProfesiones.setHorizontalHeaderItem(0, __colItem);

        QTableWidgetItem __colItem1 = new QTableWidgetItem();
        __colItem1.setText(com.trolltech.qt.core.QCoreApplication.translate("frmProfesiones", "Descripci\u00f3n", null));
        twProfesiones.setHorizontalHeaderItem(1, __colItem1);

        QTableWidgetItem __colItem2 = new QTableWidgetItem();
        __colItem2.setText(com.trolltech.qt.core.QCoreApplication.translate("frmProfesiones", "Abrev.", null));
        twProfesiones.setHorizontalHeaderItem(2, __colItem2);

        QTableWidgetItem __colItem3 = new QTableWidgetItem();
        __colItem3.setText(com.trolltech.qt.core.QCoreApplication.translate("frmProfesiones", "Vigente", null));
        twProfesiones.setHorizontalHeaderItem(3, __colItem3);
        twProfesiones.setRowCount(0);
        lblStat.setText("");
        gbUpdate.setTitle(com.trolltech.qt.core.QCoreApplication.translate("frmProfesiones", "Actualizaci\u00f3n del registro", null));
        label_3.setText(com.trolltech.qt.core.QCoreApplication.translate("frmProfesiones", "Descripci\u00f3n", null));
        ckbVige.setText(com.trolltech.qt.core.QCoreApplication.translate("frmProfesiones", "&Vigente", null));
        label_4.setText(com.trolltech.qt.core.QCoreApplication.translate("frmProfesiones", "Abrev.", null));
    } // retranslateUi

}

