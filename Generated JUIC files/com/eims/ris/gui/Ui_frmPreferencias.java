/********************************************************************************
** Form generated from reading ui file 'frmPreferencias.jui'
**
** Created: vie dic 2 00:07:22 2011
**      by: Qt User Interface Compiler version 4.5.2
**
** WARNING! All changes made in this file will be lost when recompiling ui file!
********************************************************************************/

package com.eims.ris.gui;

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class Ui_frmPreferencias implements com.trolltech.qt.QUiForm<QWidget>
{
    public QLabel label;
    public QLabel label_2;
    public QTabWidget tabWidget;
    public QWidget tab;
    public QComboBox cmbTheme;
    public QLabel label_3;
    public QWidget tab_2;
    public QPushButton btnAceptar;

    public Ui_frmPreferencias() { super(); }

    public void setupUi(QWidget frmPreferencias)
    {
        frmPreferencias.setObjectName("frmPreferencias");
        frmPreferencias.resize(new QSize(310, 240).expandedTo(frmPreferencias.minimumSizeHint()));
        frmPreferencias.setMinimumSize(new QSize(310, 0));
        frmPreferencias.setMaximumSize(new QSize(310, 16777215));
        frmPreferencias.setWindowIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/prefe64.png")));
        label = new QLabel(frmPreferencias);
        label.setObjectName("label");
        label.setGeometry(new QRect(0, 0, 311, 91));
        QFont font = new QFont();
        label.setFont(font);
        label.setStyleSheet("background-color: qlineargradient(spread:pad, x1:0, y1:0, x2:0, y2:1, stop:0 rgba(0, 50, 100, 255), stop:1 rgba(0, 0, 0, 0));");
        label.setPixmap(new QPixmap(("classpath:com/eims/ris/images/prefe64.png")));
        label.setMargin(10);
        label_2 = new QLabel(frmPreferencias);
        label_2.setObjectName("label_2");
        label_2.setGeometry(new QRect(90, 10, 341, 53));
        QFont font1 = new QFont();
        label_2.setFont(font1);
        tabWidget = new QTabWidget(frmPreferencias);
        tabWidget.setObjectName("tabWidget");
        tabWidget.setGeometry(new QRect(10, 90, 291, 101));
        tab = new QWidget();
        tab.setObjectName("tab");
        cmbTheme = new QComboBox(tab);
        cmbTheme.setObjectName("cmbTheme");
        cmbTheme.setGeometry(new QRect(50, 10, 121, 25));
        label_3 = new QLabel(tab);
        label_3.setObjectName("label_3");
        label_3.setGeometry(new QRect(10, 10, 41, 16));
        tabWidget.addTab(tab, com.trolltech.qt.core.QCoreApplication.translate("frmPreferencias", "Com\u00fan", null));
        tab_2 = new QWidget();
        tab_2.setObjectName("tab_2");
        tabWidget.addTab(tab_2, com.trolltech.qt.core.QCoreApplication.translate("frmPreferencias", "Sistema", null));
        btnAceptar = new QPushButton(frmPreferencias);
        btnAceptar.setObjectName("btnAceptar");
        btnAceptar.setGeometry(new QRect(210, 200, 91, 30));
        btnAceptar.setCursor(new QCursor(Qt.CursorShape.PointingHandCursor));
        btnAceptar.setIcon(new QIcon(new QPixmap("classpath:com/eims/ris/images/ok48.png")));
        retranslateUi(frmPreferencias);

        tabWidget.setCurrentIndex(0);


        frmPreferencias.connectSlotsByName();
    } // setupUi

    void retranslateUi(QWidget frmPreferencias)
    {
        frmPreferencias.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("frmPreferencias", "Preferencias del sistema", null));
        label.setText("");
        label_2.setText(com.trolltech.qt.core.QCoreApplication.translate("frmPreferencias", "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0//EN\" \"http://www.w3.org/TR/REC-html40/strict.dtd\">\n"+
"<html><head><meta name=\"qrichtext\" content=\"1\" /><style type=\"text/css\">\n"+
"p, li { white-space: pre-wrap; }\n"+
"</style></head><body style=\" font-family:'Sans Serif'; font-size:9pt; font-weight:400; font-style:normal;\">\n"+
"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-family:'Calibri'; font-size:20pt;\">PREFERENCIAS</span></p>\n"+
"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-family:'Calibri'; font-size:10pt;\">Configure </span><span style=\" font-family:'Calibri'; font-size:10pt;\">aqu\u00ed</span><span style=\" font-family:'Calibri'; font-size:10pt;\"> las preferencias.</span></p></body></html>", null));
        cmbTheme.clear();
        cmbTheme.addItem(com.trolltech.qt.core.QCoreApplication.translate("frmPreferencias", "Plastique", null));
        cmbTheme.addItem(com.trolltech.qt.core.QCoreApplication.translate("frmPreferencias", "Windows", null));
        cmbTheme.addItem(com.trolltech.qt.core.QCoreApplication.translate("frmPreferencias", "Motif", null));
        cmbTheme.addItem(com.trolltech.qt.core.QCoreApplication.translate("frmPreferencias", "Cleanlooks", null));
        cmbTheme.addItem(com.trolltech.qt.core.QCoreApplication.translate("frmPreferencias", "CDE", null));
        label_3.setText(com.trolltech.qt.core.QCoreApplication.translate("frmPreferencias", "Tema", null));
        tabWidget.setTabText(tabWidget.indexOf(tab), com.trolltech.qt.core.QCoreApplication.translate("frmPreferencias", "Com\u00fan", null));
        tabWidget.setTabText(tabWidget.indexOf(tab_2), com.trolltech.qt.core.QCoreApplication.translate("frmPreferencias", "Sistema", null));
        btnAceptar.setText(com.trolltech.qt.core.QCoreApplication.translate("frmPreferencias", "Aceptar", null));
    } // retranslateUi

}

