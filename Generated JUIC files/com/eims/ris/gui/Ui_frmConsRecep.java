/********************************************************************************
** Form generated from reading ui file 'frmConsRecep.jui'
**
** Created: vie dic 2 09:31:04 2011
**      by: Qt User Interface Compiler version 4.5.2
**
** WARNING! All changes made in this file will be lost when recompiling ui file!
********************************************************************************/

package com.eims.ris.gui;

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class Ui_frmConsRecep implements com.trolltech.qt.QUiForm<QDialog>
{
    public QLabel label;
    public QLabel label_2;
    public QTableWidget twRecepciones;
    public QLabel label_3;
    public QDateEdit deFDesde;
    public QDateEdit deFHasta;
    public QPushButton btnAceptar;
    public QPushButton btnImprimir;

    public Ui_frmConsRecep() { super(); }

    public void setupUi(QDialog frmConsRecep)
    {
        frmConsRecep.setObjectName("frmConsRecep");
        frmConsRecep.resize(new QSize(800, 600).expandedTo(frmConsRecep.minimumSizeHint()));
        frmConsRecep.setWindowIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/recep64.png")));
        label = new QLabel(frmConsRecep);
        label.setObjectName("label");
        label.setGeometry(new QRect(0, 0, 801, 91));
        label.setStyleSheet("background-color: qlineargradient(spread:pad, x1:0, y1:0, x2:0, y2:1, stop:0 rgba(0, 50, 100, 255), stop:1 rgba(0, 0, 0, 0));");
        label.setPixmap(new QPixmap(("classpath:com/eims/ris/images/recep64.png")));
        label.setMargin(10);
        label_2 = new QLabel(frmConsRecep);
        label_2.setObjectName("label_2");
        label_2.setGeometry(new QRect(90, 10, 601, 64));
        twRecepciones = new QTableWidget(frmConsRecep);
        twRecepciones.setObjectName("twRecepciones");
        twRecepciones.setGeometry(new QRect(10, 110, 781, 481));
        twRecepciones.setStyleSheet("QTableWidget {\n"+
"    show-decoration-selected: 1;\n"+
"	alternate-background-color: rgb(247, 255, 193);\n"+
"	background-color: rgba(240, 240, 240, 100);\n"+
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
        twRecepciones.setEditTriggers(com.trolltech.qt.gui.QAbstractItemView.EditTrigger.createQFlags(com.trolltech.qt.gui.QAbstractItemView.EditTrigger.NoEditTriggers));
        twRecepciones.setAlternatingRowColors(true);
        twRecepciones.setSelectionMode(com.trolltech.qt.gui.QAbstractItemView.SelectionMode.SingleSelection);
        twRecepciones.setSelectionBehavior(com.trolltech.qt.gui.QAbstractItemView.SelectionBehavior.SelectRows);
        label_3 = new QLabel(frmConsRecep);
        label_3.setObjectName("label_3");
        label_3.setGeometry(new QRect(320, 80, 56, 21));
        QFont font = new QFont();
        font.setBold(true);
        font.setWeight(75);
        label_3.setFont(font);
        deFDesde = new QDateEdit(frmConsRecep);
        deFDesde.setObjectName("deFDesde");
        deFDesde.setGeometry(new QRect(380, 76, 101, 25));
        deFDesde.setAutoFillBackground(true);
        deFDesde.setCalendarPopup(true);
        deFDesde.setDate(new QDate(2011, 12, 1));
        deFHasta = new QDateEdit(frmConsRecep);
        deFHasta.setObjectName("deFHasta");
        deFHasta.setGeometry(new QRect(490, 76, 101, 25));
        deFHasta.setAutoFillBackground(true);
        deFHasta.setCalendarPopup(true);
        deFHasta.setDate(new QDate(2011, 12, 1));
        btnAceptar = new QPushButton(frmConsRecep);
        btnAceptar.setObjectName("btnAceptar");
        btnAceptar.setGeometry(new QRect(600, 72, 91, 31));
        btnAceptar.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnAceptar.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/ok48.png")));
        btnAceptar.setIconSize(new QSize(24, 24));
        btnImprimir = new QPushButton(frmConsRecep);
        btnImprimir.setObjectName("btnImprimir");
        btnImprimir.setGeometry(new QRect(700, 72, 91, 31));
        btnImprimir.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnImprimir.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/print48.png")));
        btnImprimir.setIconSize(new QSize(24, 24));
        retranslateUi(frmConsRecep);

        frmConsRecep.connectSlotsByName();
    } // setupUi

    void retranslateUi(QDialog frmConsRecep)
    {
        frmConsRecep.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("frmConsRecep", "Consulta de recepciones", null));
        label.setText("");
        label_2.setText(com.trolltech.qt.core.QCoreApplication.translate("frmConsRecep", "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0//EN\" \"http://www.w3.org/TR/REC-html40/strict.dtd\">\n"+
"<html><head><meta name=\"qrichtext\" content=\"1\" /><style type=\"text/css\">\n"+
"p, li { white-space: pre-wrap; }\n"+
"</style></head><body style=\" font-family:'Sans Serif'; font-size:9pt; font-weight:400; font-style:normal;\">\n"+
"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-family:'Calibri'; font-size:20pt;\">CONSULTA DE RECEPCIONES</span></p>\n"+
"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-family:'Calibri'; font-size:10pt;\">Aqu\u00ed podr\u00e1 consultar y/o imprimir recepciones realizadas durante un periodo determinado.</span></p>\n"+
"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-family:'Calibri'; font-size:10pt;\">Ingrese los par\u00e1metros y haga clic en aceptar.</span></p></body></html>", null));
        twRecepciones.clear();
        twRecepciones.setColumnCount(9);

        QTableWidgetItem __colItem = new QTableWidgetItem();
        __colItem.setText(com.trolltech.qt.core.QCoreApplication.translate("frmConsRecep", "ID", null));
        twRecepciones.setHorizontalHeaderItem(0, __colItem);

        QTableWidgetItem __colItem1 = new QTableWidgetItem();
        __colItem1.setText(com.trolltech.qt.core.QCoreApplication.translate("frmConsRecep", "Tipo", null));
        twRecepciones.setHorizontalHeaderItem(1, __colItem1);

        QTableWidgetItem __colItem2 = new QTableWidgetItem();
        __colItem2.setText(com.trolltech.qt.core.QCoreApplication.translate("frmConsRecep", "Fecha/Hora", null));
        twRecepciones.setHorizontalHeaderItem(2, __colItem2);

        QTableWidgetItem __colItem3 = new QTableWidgetItem();
        __colItem3.setText(com.trolltech.qt.core.QCoreApplication.translate("frmConsRecep", "Paciente", null));
        twRecepciones.setHorizontalHeaderItem(3, __colItem3);

        QTableWidgetItem __colItem4 = new QTableWidgetItem();
        __colItem4.setText(com.trolltech.qt.core.QCoreApplication.translate("frmConsRecep", "Derivador", null));
        twRecepciones.setHorizontalHeaderItem(4, __colItem4);

        QTableWidgetItem __colItem5 = new QTableWidgetItem();
        __colItem5.setText(com.trolltech.qt.core.QCoreApplication.translate("frmConsRecep", "N.U.", null));
        twRecepciones.setHorizontalHeaderItem(5, __colItem5);

        QTableWidgetItem __colItem6 = new QTableWidgetItem();
        __colItem6.setText(com.trolltech.qt.core.QCoreApplication.translate("frmConsRecep", "Asiste", null));
        twRecepciones.setHorizontalHeaderItem(6, __colItem6);

        QTableWidgetItem __colItem7 = new QTableWidgetItem();
        __colItem7.setText(com.trolltech.qt.core.QCoreApplication.translate("frmConsRecep", "Estado", null));
        twRecepciones.setHorizontalHeaderItem(7, __colItem7);

        QTableWidgetItem __colItem8 = new QTableWidgetItem();
        __colItem8.setText(com.trolltech.qt.core.QCoreApplication.translate("frmConsRecep", "Sistema Salud", null));
        twRecepciones.setHorizontalHeaderItem(8, __colItem8);
        twRecepciones.setRowCount(0);
        label_3.setText(com.trolltech.qt.core.QCoreApplication.translate("frmConsRecep", "Periodo", null));
        btnAceptar.setText(com.trolltech.qt.core.QCoreApplication.translate("frmConsRecep", "Aceptar", null));
        btnImprimir.setText(com.trolltech.qt.core.QCoreApplication.translate("frmConsRecep", "Imprimir", null));
    } // retranslateUi

}

