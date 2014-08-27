/********************************************************************************
** Form generated from reading ui file 'frmSplash.jui'
**
** Created: s�b oct 15 02:51:01 2011
**      by: Qt User Interface Compiler version 4.5.2
**
** WARNING! All changes made in this file will be lost when recompiling ui file!
********************************************************************************/

package com.eims.ris.gui;

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class Ui_frmSplash implements com.trolltech.qt.QUiForm<QDialog>
{

    public Ui_frmSplash() { super(); }

    public void setupUi(QDialog frmSplash)
    {
        frmSplash.setObjectName("frmSplash");
        frmSplash.resize(new QSize(500, 300).expandedTo(frmSplash.minimumSizeHint()));
        frmSplash.setMinimumSize(new QSize(500, 300));
        frmSplash.setMaximumSize(new QSize(500, 300));
        frmSplash.setStyleSheet("QDialog{\n"+
"	background-image: url(classpath:com/eims/ris/images/splash.png);\n"+
"}");
        retranslateUi(frmSplash);

        frmSplash.connectSlotsByName();
    } // setupUi

    void retranslateUi(QDialog frmSplash)
    {
        frmSplash.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("frmSplash", "Acerca de...", null));
    } // retranslateUi

}

