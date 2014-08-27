/********************************************************************************
** Form generated from reading ui file 'frmFuncionarios.jui'
**
** Created: s�b nov 19 15:49:11 2011
**      by: Qt User Interface Compiler version 4.5.2
**
** WARNING! All changes made in this file will be lost when recompiling ui file!
********************************************************************************/

package com.eims.ris.gui;

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class Ui_frmFuncionarios implements com.trolltech.qt.QUiForm<QDialog>
{
    public QGroupBox gbUpdate;
    public QLabel label_3;
    public QLabel label_4;
    public QLabel label_5;
    public QLabel label_6;
    public QLabel label_7;
    public QCheckBox ckbVige;
    public QLineEdit leNomb;
    public QLineEdit leAPat;
    public QLineEdit leAMat;
    public QLineEdit leInic;
    public QComboBox cmbProf;
    public QLabel label;
    public QPushButton btnNuevo;
    public QTableWidget twFuncionarios;
    public QPushButton btnImprimir;
    public QPushButton btnEditar;
    public QPushButton btnGuardar;
    public QLabel lblStat;
    public QPushButton btnEliminar;
    public QPushButton btnCerrar;
    public QLabel label_2;

    public Ui_frmFuncionarios() { super(); }

    public void setupUi(QDialog frmFuncionarios)
    {
        frmFuncionarios.setObjectName("frmFuncionarios");
        frmFuncionarios.resize(new QSize(640, 600).expandedTo(frmFuncionarios.minimumSizeHint()));
        frmFuncionarios.setMinimumSize(new QSize(640, 600));
        frmFuncionarios.setMaximumSize(new QSize(640, 600));
        frmFuncionarios.setWindowIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/func64.png")));
        gbUpdate = new QGroupBox(frmFuncionarios);
        gbUpdate.setObjectName("gbUpdate");
        gbUpdate.setEnabled(false);
        gbUpdate.setGeometry(new QRect(10, 160, 621, 81));
        QFont font = new QFont();
        gbUpdate.setFont(font);
        label_3 = new QLabel(gbUpdate);
        label_3.setObjectName("label_3");
        label_3.setGeometry(new QRect(10, 20, 48, 16));
        QFont font1 = new QFont();
        label_3.setFont(font1);
        label_4 = new QLabel(gbUpdate);
        label_4.setObjectName("label_4");
        label_4.setGeometry(new QRect(220, 20, 61, 16));
        label_5 = new QLabel(gbUpdate);
        label_5.setObjectName("label_5");
        label_5.setGeometry(new QRect(420, 20, 65, 16));
        label_6 = new QLabel(gbUpdate);
        label_6.setObjectName("label_6");
        label_6.setGeometry(new QRect(10, 50, 48, 16));
        label_7 = new QLabel(gbUpdate);
        label_7.setObjectName("label_7");
        label_7.setGeometry(new QRect(140, 50, 54, 16));
        ckbVige = new QCheckBox(gbUpdate);
        ckbVige.setObjectName("ckbVige");
        ckbVige.setGeometry(new QRect(540, 50, 77, 22));
        QFont font2 = new QFont();
        font2.setBold(true);
        font2.setWeight(75);
        ckbVige.setFont(font2);
        leNomb = new QLineEdit(gbUpdate);
        leNomb.setObjectName("leNomb");
        leNomb.setGeometry(new QRect(60, 20, 151, 20));
        leAPat = new QLineEdit(gbUpdate);
        leAPat.setObjectName("leAPat");
        leAPat.setGeometry(new QRect(290, 20, 121, 20));
        leAMat = new QLineEdit(gbUpdate);
        leAMat.setObjectName("leAMat");
        leAMat.setGeometry(new QRect(490, 20, 121, 20));
        leInic = new QLineEdit(gbUpdate);
        leInic.setObjectName("leInic");
        leInic.setGeometry(new QRect(60, 50, 71, 20));
        cmbProf = new QComboBox(gbUpdate);
        cmbProf.setObjectName("cmbProf");
        cmbProf.setGeometry(new QRect(200, 50, 301, 22));
        label = new QLabel(frmFuncionarios);
        label.setObjectName("label");
        label.setGeometry(new QRect(0, 0, 641, 91));
        label.setStyleSheet("background-color: qlineargradient(spread:pad, x1:0, y1:0, x2:0, y2:1, stop:0 rgba(0, 50, 100, 255), stop:1 rgba(0, 0, 0, 0));");
        label.setPixmap(new QPixmap(("classpath:com/eims/ris/images/func64.png")));
        label.setMargin(10);
        btnNuevo = new QPushButton(frmFuncionarios);
        btnNuevo.setObjectName("btnNuevo");
        btnNuevo.setEnabled(false);
        btnNuevo.setGeometry(new QRect(20, 90, 61, 61));
        QFont font3 = new QFont();
        btnNuevo.setFont(font3);
        btnNuevo.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnNuevo.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/nuev48.png")));
        btnNuevo.setIconSize(new QSize(48, 48));
        twFuncionarios = new QTableWidget(frmFuncionarios);
        twFuncionarios.setObjectName("twFuncionarios");
        twFuncionarios.setGeometry(new QRect(10, 250, 621, 341));
        QFont font4 = new QFont();
        twFuncionarios.setFont(font4);
        twFuncionarios.setStyleSheet("QTableWidget {\n"+
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
        twFuncionarios.setEditTriggers(com.trolltech.qt.gui.QAbstractItemView.EditTrigger.createQFlags(com.trolltech.qt.gui.QAbstractItemView.EditTrigger.NoEditTriggers));
        twFuncionarios.setAlternatingRowColors(true);
        twFuncionarios.setSelectionMode(com.trolltech.qt.gui.QAbstractItemView.SelectionMode.SingleSelection);
        twFuncionarios.setSelectionBehavior(com.trolltech.qt.gui.QAbstractItemView.SelectionBehavior.SelectRows);
        btnImprimir = new QPushButton(frmFuncionarios);
        btnImprimir.setObjectName("btnImprimir");
        btnImprimir.setEnabled(false);
        btnImprimir.setGeometry(new QRect(420, 90, 61, 61));
        QFont font5 = new QFont();
        btnImprimir.setFont(font5);
        btnImprimir.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnImprimir.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/print48.png")));
        btnImprimir.setIconSize(new QSize(48, 48));
        btnEditar = new QPushButton(frmFuncionarios);
        btnEditar.setObjectName("btnEditar");
        btnEditar.setEnabled(false);
        btnEditar.setGeometry(new QRect(90, 90, 61, 61));
        QFont font6 = new QFont();
        btnEditar.setFont(font6);
        btnEditar.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnEditar.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/edit48.png")));
        btnEditar.setIconSize(new QSize(48, 48));
        btnGuardar = new QPushButton(frmFuncionarios);
        btnGuardar.setObjectName("btnGuardar");
        btnGuardar.setEnabled(false);
        btnGuardar.setGeometry(new QRect(160, 90, 61, 61));
        QFont font7 = new QFont();
        btnGuardar.setFont(font7);
        btnGuardar.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnGuardar.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/save48.png")));
        btnGuardar.setIconSize(new QSize(48, 48));
        lblStat = new QLabel(frmFuncionarios);
        lblStat.setObjectName("lblStat");
        lblStat.setGeometry(new QRect(230, 120, 91, 31));
        QFont font8 = new QFont();
        lblStat.setFont(font8);
        lblStat.setStyleSheet("background-color: rgb(248, 255, 184);\n"+
"border:1px solid rgb(170, 170, 127);\n"+
"border-radius:4px;");
        lblStat.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));
        btnEliminar = new QPushButton(frmFuncionarios);
        btnEliminar.setObjectName("btnEliminar");
        btnEliminar.setEnabled(false);
        btnEliminar.setGeometry(new QRect(330, 90, 61, 61));
        QFont font9 = new QFont();
        btnEliminar.setFont(font9);
        btnEliminar.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnEliminar.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/dele48.png")));
        btnEliminar.setIconSize(new QSize(48, 48));
        btnCerrar = new QPushButton(frmFuncionarios);
        btnCerrar.setObjectName("btnCerrar");
        btnCerrar.setGeometry(new QRect(570, 90, 61, 61));
        QFont font10 = new QFont();
        btnCerrar.setFont(font10);
        btnCerrar.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnCerrar.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/shutdown64.png")));
        btnCerrar.setIconSize(new QSize(48, 48));
        label_2 = new QLabel(frmFuncionarios);
        label_2.setObjectName("label_2");
        label_2.setGeometry(new QRect(90, 10, 381, 74));
        QFont font11 = new QFont();
        label_2.setFont(font11);
        retranslateUi(frmFuncionarios);
        btnCerrar.clicked.connect(frmFuncionarios, "close()");

        frmFuncionarios.connectSlotsByName();
    } // setupUi

    void retranslateUi(QDialog frmFuncionarios)
    {
        frmFuncionarios.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("frmFuncionarios", "Archivo de funcionarios", null));
        gbUpdate.setTitle(com.trolltech.qt.core.QCoreApplication.translate("frmFuncionarios", "Actualizaci\u00f3n del registro", null));
        label_3.setText(com.trolltech.qt.core.QCoreApplication.translate("frmFuncionarios", "Nombre", null));
        label_4.setText(com.trolltech.qt.core.QCoreApplication.translate("frmFuncionarios", "A. Paterno", null));
        label_5.setText(com.trolltech.qt.core.QCoreApplication.translate("frmFuncionarios", "A. Materno", null));
        label_6.setText(com.trolltech.qt.core.QCoreApplication.translate("frmFuncionarios", "Iniciales", null));
        label_7.setText(com.trolltech.qt.core.QCoreApplication.translate("frmFuncionarios", "Profesi\u00f3n", null));
        ckbVige.setText(com.trolltech.qt.core.QCoreApplication.translate("frmFuncionarios", "&Vigente", null));
        label.setText("");
        twFuncionarios.clear();
        twFuncionarios.setColumnCount(7);

        QTableWidgetItem __colItem = new QTableWidgetItem();
        __colItem.setText(com.trolltech.qt.core.QCoreApplication.translate("frmFuncionarios", "ID", null));
        twFuncionarios.setHorizontalHeaderItem(0, __colItem);

        QTableWidgetItem __colItem1 = new QTableWidgetItem();
        __colItem1.setText(com.trolltech.qt.core.QCoreApplication.translate("frmFuncionarios", "Nombre", null));
        twFuncionarios.setHorizontalHeaderItem(1, __colItem1);

        QTableWidgetItem __colItem2 = new QTableWidgetItem();
        __colItem2.setText(com.trolltech.qt.core.QCoreApplication.translate("frmFuncionarios", "A. Paterno", null));
        twFuncionarios.setHorizontalHeaderItem(2, __colItem2);

        QTableWidgetItem __colItem3 = new QTableWidgetItem();
        __colItem3.setText(com.trolltech.qt.core.QCoreApplication.translate("frmFuncionarios", "A. Materno", null));
        twFuncionarios.setHorizontalHeaderItem(3, __colItem3);

        QTableWidgetItem __colItem4 = new QTableWidgetItem();
        __colItem4.setText(com.trolltech.qt.core.QCoreApplication.translate("frmFuncionarios", "Iniciales", null));
        twFuncionarios.setHorizontalHeaderItem(4, __colItem4);

        QTableWidgetItem __colItem5 = new QTableWidgetItem();
        __colItem5.setText(com.trolltech.qt.core.QCoreApplication.translate("frmFuncionarios", "Profesi\u00f3n", null));
        twFuncionarios.setHorizontalHeaderItem(5, __colItem5);

        QTableWidgetItem __colItem6 = new QTableWidgetItem();
        __colItem6.setText(com.trolltech.qt.core.QCoreApplication.translate("frmFuncionarios", "Vigente", null));
        twFuncionarios.setHorizontalHeaderItem(6, __colItem6);
        twFuncionarios.setRowCount(0);
        lblStat.setText("");
        label_2.setText(com.trolltech.qt.core.QCoreApplication.translate("frmFuncionarios", "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0//EN\" \"http://www.w3.org/TR/REC-html40/strict.dtd\">\n"+
"<html><head><meta name=\"qrichtext\" content=\"1\" /><style type=\"text/css\">\n"+
"p, li { white-space: pre-wrap; }\n"+
"</style></head><body style=\" font-family:'Ubuntu'; font-size:9pt; font-weight:400; font-style:normal;\">\n"+
"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-family:'Calibri'; font-size:18pt;\">ARCHIVO DE FUNCIONARIOS</span></p>\n"+
"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-family:'Calibri'; font-size:10pt;\">Aqu\u00ed podr\u00e1 buscar, agregar, editar o eliminar funcionarios.</span></p>\n"+
"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-family:'Calibri'; font-size:10pt;\">Haga clic en un \u00edtem para comenzar.</span></p></body></html>", null));
    } // retranslateUi

}

