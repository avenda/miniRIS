package com.eims.ris.gui;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.dcm4che2.data.DicomObject;
import org.dcm4che2.data.Tag;
import org.dcm4che2.net.ConfigurationException;

import com.eims.ris.core.Enumeradores;
import com.eims.ris.core.Utils;
import com.eims.ris.core.Enumeradores.Message;
import com.eims.ris.gui.Ui_frmModalidades;
import com.eims.ris.integration.dicom.CFIND;
import com.trolltech.qt.core.QDate;
import com.trolltech.qt.gui.QApplication;
import com.trolltech.qt.gui.QDialog;
import com.trolltech.qt.gui.QPixmap;
import com.trolltech.qt.gui.QTableWidgetItem;

public class frmModalidades extends QDialog {
    Ui_frmModalidades ui = new Ui_frmModalidades();

    /**
	 * @uml.property  name="_userName"
	 */
    private String _userName;
    private String _Modalidad;
    /**
	 * @uml.property  name="_Action"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
    Enumeradores.Action _Action = Enumeradores.Action.None;

    public frmModalidades(String userName, String Modalidad) {
        this(userName, Modalidad, null);
    }
    public frmModalidades(String userName, String modalidad, QDialog parent) {
        super(parent);
        ui.setupUi(this);
        _userName = userName;
        _Modalidad = modalidad;
        this.setWindowTitle("WorkList "+modalidad);
        ui.lblHeader.setPixmap(new QPixmap(("classpath:com/ehealthcare/ris/images/"+modalidad.toLowerCase()+".png")));
        ui.lblHeaderTitle.setText("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0//EN\" \"http://www.w3.org/TR/REC-html40/strict.dtd\">\n"+
        		"<html><head><meta name=\"qrichtext\" content=\"1\" /><style type=\"text/css\">\n"+
        		"p, li { white-space: pre-wrap; }\n"+
        		"</style></head><body style=\" font-family:'Ubuntu'; font-size:9pt; font-weight:400; font-style:normal;\">\n"+
        		"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-size:18pt;\">Worklist "+_Modalidad+"</span></p>\n"+
        		"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-family:'Calibri'; font-size:10pt;\">Aqu\u00ed podr\u00e1 buscar pacientes en espera de la realizaci\u00f3n del examen</span><span style=\" font-size:10pt;\">.</span></p></body></html>");
        
        CreateConnect();
        QApplication.restoreOverrideCursor();
    }
    public void on_btnBuscar_Clicked() throws IOException, InterruptedException{
    	CFIND find = new CFIND(Utils.getAETitle());
    	int row=0;
    	find.setCalledAET("DCM4CHEE");
    	//find.setCalling("EIMSRIS");
    	find.setRemoteHost("127.0.0.1");
    	find.setRemotePort(11112);
    	find.setTransferSyntax(find.getLeTs());
    	if(!ui.leNombre.text().isEmpty())
    		find.addSpsMatchingKey(Tag.PatientName, ui.leNombre.text());
    	if(!ui.leRun.text().isEmpty())
        	find.addSpsMatchingKey(Tag.PatientID, ui.leRun.text());
       	if(ui.gbFecha.isChecked())
            find.addSpsMatchingKey(Tag.ScheduledProcedureStepStartDate, ui.deDesde.date().toString("yyyyMMdd")+
            						"/"+ui.deDesde.date().toString("yyyyMMdd"));
       	else{
       		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        	find.addSpsMatchingKey(Tag.ScheduledProcedureStepStartDate, sdf.format(new Date()));
       	}
		find.addSpsMatchingKey(Tag.Modality, _Modalidad);
    	try {
			find.open();
		} catch (ConfigurationException e) {
			Utils.MessageBox(Message.Error, "Error al conectar con la modalidad WorkList.\nFavor revise conectividad del equipo");
			e.printStackTrace();
		}
		for(DicomObject o : find.query()){
			
    		QTableWidgetItem item = null;
            ui.twWorklist.insertRow(row);
            ui.twWorklist.setRowHeight(row,20);

            item = new QTableWidgetItem();
            item.setText(o.getString(Tag.AccessionNumber));
            item.setTextAlignment(2);
            ui.twWorklist.setItem(row,0,item);

            item = new QTableWidgetItem();
            item.setText(o.getString(Tag.PatientID));
            ui.twWorklist.setItem(row,1,item);
            
            item = new QTableWidgetItem();
            item.setText(o.getString(Tag.PatientName));
            ui.twWorklist.setItem(row,2,item);
            
            item = new QTableWidgetItem();
            item.setText(o.getString(Tag.PatientSex));
            ui.twWorklist.setItem(row,3,item);
            
            item = new QTableWidgetItem();
            item.setText(o.getString(Tag.PatientBirthDate));
            ui.twWorklist.setItem(row,4,item);
            
            item = new QTableWidgetItem();
            item.setText(o.get(Tag.ScheduledProcedureStepSequence).getDicomObject().getString(Tag.ScheduledProcedureStepStartDate));
            ui.twWorklist.setItem(row,5,item);
            
            item = new QTableWidgetItem();
            item.setText(o.get(Tag.RequestedProcedureCodeSequence).getDicomObject().getString(Tag.CodeValue));
            ui.twWorklist.setItem(row,6,item);
            
            item = new QTableWidgetItem();
            item.setText(o.get(Tag.RequestedProcedureCodeSequence).getDicomObject().getString(Tag.CodeMeaning));
            ui.twWorklist.setItem(row,7,item);
            row++;
    	}
    	if(row==0){
    		Utils.MessageBox(Message.Error, "No se encontraron registros. Amplie los criterios de búsqueda");
    	}else
    		ui.lblCounter.setText("Número de procedimientos pendientes :"+row);
        ui.twWorklist.resizeColumnsToContents();
    }
    public void CreateConnect(){
    	ui.btnBuscar.clicked.connect(this, "on_btnBuscar_Clicked()");
    	//ui.twWorklist.cellClicked.connect(this, "on_twProfesiones_CellClicked(int, int)");
    	Utils.HabilitaAcciones(this, _userName, objectName().substring(3), '\0');
    	//LoadWLToday();
    	LoadCurrentDate();
    	ui.twWorklist.resizeColumnsToContents();
    }
    public void LoadWLToday(){
    	
    }
    public void LoadCurrentDate(){
    	ui.deDesde.setDate(QDate.currentDate());
    	ui.deHasta.setDate(QDate.currentDate());
    }
}

