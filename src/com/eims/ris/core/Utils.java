package com.eims.ris.core;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import com.eims.ris.core.DBUtils;
import com.eims.ris.core.Enumeradores.DateTimeFormat;
import com.trolltech.qt.core.QDate;
import com.trolltech.qt.core.QDateTime;
import com.trolltech.qt.core.QFile;
import com.trolltech.qt.core.QIODevice;
import com.trolltech.qt.core.QObject;
import com.trolltech.qt.core.QTime;
import com.trolltech.qt.core.QUrl;
import com.trolltech.qt.core.Qt;
import com.trolltech.qt.gui.QColor;
import com.trolltech.qt.gui.QDesktopServices;
import com.trolltech.qt.gui.QFont;
import com.trolltech.qt.gui.QMessageBox;
import com.trolltech.qt.gui.QPainter;
import com.trolltech.qt.gui.QPen;
import com.trolltech.qt.gui.QPixmap;
import com.trolltech.qt.gui.QPrinter;
import com.trolltech.qt.gui.QTableWidget;
import com.trolltech.qt.gui.QWidget;
import com.trolltech.qt.gui.QPushButton;
import com.trolltech.qt.xml.QXmlStreamWriter;

public class Utils {
		
	public static boolean HabilitaOpciones(QWidget parent, String userAccount){
	    if(parent.equals(0) || userAccount.equals(""))return false;
	    try{
		    String sql = String.format("SELECT usu_id FROM miniris.usuarios WHERE usu_acco='%1$s';", userAccount);
		    ResultSet query = DBUtils.getResultSet(sql);
		    query.next();
		    int userID = query.getInt(1);
		    sql = String.format("SELECT cls_id FROM miniris.user_access WHERE usu_id=%1$s", userID);
		    //sql = String.format("SELECT cls_id FROM miniris.user_access WHERE cls_id='Ciudades'");
		    query = DBUtils.getResultSet(sql);
		    query.next();
		    List<QObject> allObjects = parent.findChildren();
		    ListIterator<QObject> iteratObjs = allObjects.listIterator();
		    QObject objeto = new QObject();
		    QPushButton boton = new QPushButton();
		    while (iteratObjs.hasNext()){
		    	objeto = iteratObjs.next();
		        if(objeto.objectName().length()>4){
			        if(objeto.objectName().substring(0, 4).equals("btnM")){
			        	boton = (QPushButton)objeto;
			        	boton.setEnabled(false);
			        	System.out.println(boton.whatsThis());
			            query.first();
			            do{
			                if(boton.whatsThis().equals(query.getString(1).trim())){
			                    boton.setEnabled(true);
			                    break;
			                }
			            }while(query.next());
			        }
		        }
		    }
		    return true;
	    }catch (SQLException e) {
	    	DBUtils.showSQLException(e);
			return false;
		}
	}

	public static boolean HabilitaAcciones(QWidget parent, String userAccount, String clase, char accion){
		try{
			String sql = String.format("SELECT usu_id FROM miniris.usuarios WHERE usu_acco='%1$s';", userAccount);
			ResultSet query = DBUtils.getResultSet(sql);
		    query.next();
		    int userID = query.getInt(1);
		    boolean lUseRecord = false;
		    sql = String.format("SELECT acc_lect,acc_ins,acc_edit,acc_elim,acc_print FROM miniris.user_access WHERE usu_id=%1$s AND TRIM(cls_id)='%2$s'", userID, clase);
		    //System.out.println(sql);
		    query = DBUtils.getResultSet(sql);
		    if(query.next()) lUseRecord = true;
		    List<QObject> allObjects = parent.findChildren();
		    ListIterator<QObject> iteratObjs = allObjects.listIterator();
		    QObject objeto = new QObject();
		    QPushButton boton = new QPushButton();
		    while (iteratObjs.hasNext()){
		        objeto = iteratObjs.next();
		        if(objeto.objectName().length()>3){
			        if(objeto.objectName().substring(0, 3).equals("btn")){
			        	boton = (QPushButton)objeto;
			        	//System.out.println(boton.objectName());
				        if(boton.objectName().equals("btnNuevo")){
				            if(lUseRecord)
				            	boton.setEnabled(query.getBoolean(2) && (accion=='\0' || accion=='G' || accion=='B'));
				            else
				            	boton.setEnabled(false);
				        }else if(boton.objectName().equals("btnEditar")){
				            if(lUseRecord)
				            	boton.setEnabled(query.getBoolean(3) && (accion=='B'));
				            else
				            	boton.setEnabled(false);
				        }else if(boton.objectName().equals("btnGuardar")){
				        	boton.setEnabled(accion=='A' || accion=='E');
				        }else if(boton.objectName().equals("btnEliminar")){
				            if(lUseRecord)
				            	boton.setEnabled(query.getBoolean(4) && (accion=='G' || accion=='B'));
				            else
				            	boton.setEnabled(false);
				        }else if(boton.objectName().equals("btnImprimir")){
				            if(lUseRecord)
				            	boton.setEnabled(query.getBoolean(5));// && (accion=='G' || accion=='B'));
				            else
				            	boton.setEnabled(false);
				        }
			        }
		        }
		    }
		    return lUseRecord;
		}catch (SQLException e) {
			DBUtils.showSQLException(e);
			return false;
		}
	}
	/**
	 * Método estático para Transformar un objeto Date a QDate 
	 * @return Objeto QDate
	 */
	public static QDate DateToQDate(Date fecha){
		String[] f = fecha.toString().substring(0, 10).split("-");
    	return new QDate(Integer.parseInt(f[0]), Integer.parseInt(f[1]), Integer.parseInt(f[2]));
	}
	/**
	 * Método estático para obtener la Fecha y Hora actual 
	 * @return FechaHora de tipo String
	 */
	public static String ObtenerFechaHora(){
		String result = QDateTime.currentDateTime().toString("yyyy-MM-dd HH:mm:ss"); 
        try{
	        ResultSet query = DBUtils.getResultSet("SELECT NOW();");
	        query.next();
	        //System.out.println(query.getTimestamp(1).toString());
	        result = query.getTimestamp(1).toString().substring(0, 19); // == null ? "" : query.getTimestamp(1).toString();
	    }catch (SQLException e) {
	    	DBUtils.showSQLException(e);
		}
	    return result;
	}
	public static String getDateTimeFormat(DateTimeFormat dtf){
		String dateTimeFormat = "dd-MM-yyyy HH:mm:ss";
		try{
	        ResultSet query = DBUtils.getResultSet("SELECT par_info FROM miniris.parametros WHERE par_grupo='DF' AND par_id=1;");
	        query.next();
	        if(dtf.equals(Enumeradores.DateTimeFormat.Date))
	        	dateTimeFormat = query.getString(1).substring(0, 10);
	        else if(dtf.equals(Enumeradores.DateTimeFormat.Time))
	        	dateTimeFormat = query.getString(1).substring(10,8);
        	else
        		dateTimeFormat = query.getString(1);
	    }catch (SQLException e) {
	    	DBUtils.showSQLException(e);
		}
	    return dateTimeFormat;
	}
	public static String getAETitle(){
		return "EIMSRIS";
	}
	public static boolean ValidarRUN(String RUN)
	{
		RUN.replace(".", "");
	    String list[] = RUN.split("-");
	    String run, dv;
	    run = list[0];
	    dv = list[1];
	    int T = Integer.parseInt(run);
	    int M = 0, S = 1;
	    for( ; T!=0; T/=10)
	        S = (S + T % 10 * (9 - M++ % 6)) % 11;
	    //System.out.print((char)(S!=0?S+47:75));
	    return String.format("%1$s",(char)(S!=0?S+47:75)).toUpperCase().equals(dv.toUpperCase());
	}
	public static void ShowPDF(String fileName)
	{
	    QDesktopServices.openUrl(QUrl.fromLocalFile(fileName));
	}
	public static int MessageBox(Enumeradores.Message tipo, String msg){
		String image = (tipo==Enumeradores.Message.Information ? "info" : (tipo==Enumeradores.Message.Error ? "error" : "question"));
		QPixmap icon = new QPixmap(String.format("classpath:com/ehealthcare/ris/images/%1$s64.png", image));
		QMessageBox mbox = new QMessageBox(QMessageBox.Icon.NoIcon, "RIS - Mensaje", msg);
		mbox.setIconPixmap(icon);
		//mbox.setDetailedText("Algún texto de detalle en caso de error");
		//mbox.setInformativeText("Información adicional");
		mbox.setText(msg);
		if(tipo == Enumeradores.Message.Question){
			mbox.setStandardButtons(QMessageBox.StandardButton.No, QMessageBox.StandardButton.Yes);
			mbox.setDefaultButton(QMessageBox.StandardButton.No);
		}
		mbox.setText(msg);
		return mbox.exec();
	}
	/**
	  GenerateXML
	  Descripción: Genera un archivo XML con información del TableWidget enviado como parámetro.
	  Parámetros :
	    index    : entero que indica el ID del TableWidget
	    fileName : nombre de archivo excluye la extensión
	    tw       : QTableWidget con información
	  */
	public static void GenerateXML(int index, String fileName, QTableWidget tw)
	{
		//String lPath = QCoreApplication.applicationDirPath();
		String lPath = "/home/pablo/temp";
		String lFullFile = lPath+"/"+fileName+".xml";
		System.out.print("FullFile: "+lFullFile);
	    QFile file = new QFile(lFullFile);
	    if(!file.open(QIODevice.OpenModeFlag.WriteOnly)){
	        //QMessageBox::warning(0, "Error de archivo", "Imposible abrir el archivo en modo escritura.");
	        return;
	    }else{
	        QXmlStreamWriter xmlWriter = new QXmlStreamWriter();
	        xmlWriter.setDevice(file);
	        xmlWriter.writeStartDocument();
	        xmlWriter.writeStartElement("Registros");
	        String columnName;
	        for(int row=0;row<tw.rowCount();row++){
	            xmlWriter.writeStartElement(tw.horizontalHeaderItem(index).text().toUpperCase());
	            for(int i=0;i<tw.columnCount();i++){
	                if(i!=index){
	                    columnName = tw.horizontalHeaderItem(i).text().toUpperCase().replace("/", "_");
	                    columnName = columnName.replace(" ", "_");
	                    xmlWriter.writeAttribute(columnName, tw.item(row,i).text());
	                }
	            }
	            xmlWriter.writeCharacters(tw.item(row,index).text());
	            xmlWriter.writeEndElement();
	        }
	        xmlWriter.writeEndElement();
	        xmlWriter.writeEndDocument();
	        file.close();
	        QDesktopServices.openUrl(QUrl.fromLocalFile(lFullFile));
	    }
	}
	/**
	  PrintHeader
	  Descripción: Imprime en el painter la cabezera de un informe.
	  Parámetros :
	    painter  : Objeto QPainter en donde se dibujará (argumento utilizado por referencia)
	    title    : String con el título del informe
	  */
	public static void PrintHeader(QPainter painter, String title, String header[][], int nroPage, int totalPage){
		//QRect rect = new QRect(10,10,350,150);
		QPen pen = new QPen();
        pen.setWidth(1);
        pen.setColor(QColor.black);
        painter.setPen(pen);
        int width  = painter.paintEngine().paintDevice().width();  // ancho de la página
        int height = painter.paintEngine().paintDevice().height(); // alto de la página
        QFont fnt = new QFont("Arial",8);
        //fnt.setLetterSpacing(QFont::PercentageSpacing,104);
        int lX = 20; // Para el margen izquierdo
        //painter.drawImage(rect,QImage(String(":/images/resources/logo.png")));
        //painter.drawRect(lX, 10, width - (lX * 2), 60);
        painter.setFont(fnt);
        painter.drawText(lX+4 , 30, "EIMS");
        painter.drawText(width - lX - 60 , 30, QDate.currentDate().toString("dd-MM-yyyy"));
        painter.drawText(lX+4, 50, "RIS");
        painter.drawText(width - lX - 60 , 50, QTime.currentTime().toString("HH:mm:ss"));
        
        fnt.setPointSize(14);
        fnt.setBold(true);
        painter.setFont(fnt);
        painter.drawText(0, 20, width, 40, 5, title);
        pen.setWidth(2);
        painter.setPen(pen);
        painter.drawLine(lX, 65, width - lX, 65);
        pen.setWidth(1);
        painter.setPen(pen);
        
        fnt.setPointSize(12);
        fnt.setBold(false);
        painter.setFont(fnt);
        int lX1 = lX;
        int lW;
        for(int i=0; i<header.length; i++){
        	lW = Integer.parseInt(header[i][0]);
        	painter.fillRect(lX1  , 70, lW  , 20, QColor.lightGray);
        	painter.drawRect(lX1  , 70, lW  , 20);
        	painter.drawText(lX1+2, 70, lW-4, 20, 0, header[i][1]);
        	lX1 += lW;
        }
        // Para el footer de la página
        fnt.setPointSize(8);
        painter.setFont(fnt);
        pen.setWidth(2);
        painter.setPen(pen);
        painter.drawLine(lX, height - 14, width - lX, height - 14);
        pen.setWidth(1);
        painter.setPen(pen);
        painter.drawText(lX, height - 10, width - lX, 20, 5, "EIMS - Sistema de Información Radiológica");
        painter.drawText(width - lX - 60 , height - 10, 100, 20, 0, "Pág.: " + nroPage+"/"+totalPage);
	}
	public static void PrintTableWidget(QPrinter printer, QPainter painter, String title, QTableWidget tw, String widthFields[][]){
		int lW;
		int lH = 20;
    	int lX1 = 20; 
    	int lY = 90;
    	int nroPage = 1;
    	int height = painter.paintEngine().paintDevice().height(); // alto de la página
    	int nroPerPage = (height == 992 ? 44 : 32); //922 
        int totalPage = (int)(tw.rowCount() / nroPerPage) + 1;
    	QPen pen = new QPen();
        pen.setWidth(1);
        pen.setColor(QColor.black);
        painter.setPen(pen);
        QFont fnt = new QFont("Arial",10);
        painter.setFont(fnt); 
        //992 salto de página letter portrait 
        for(int i=0; i<tw.rowCount(); i++){
        	if(lY>=(height - 22)){
        		printer.newPage();
        		PrintHeader(painter, title, widthFields, ++nroPage, totalPage);
        		fnt.setPointSize(10);
                painter.setFont(fnt);
                lX1 = 20;
        		lY = 90;
        	}
        	for(int j=0; j<widthFields.length; j++){
	        	lW = Integer.parseInt(widthFields[j][0]);
	        	painter.drawRect(lX1  , lY, lW  , lH);
	        	painter.drawText(lX1+2, lY, lW-4, lH, Qt.AlignmentFlag.AlignVCenter.value() | Integer.parseInt(widthFields[j][2]), tw.item(i, j).text());
	        	lX1 += lW;
        	}
        	//painter.drawText(40, lY-5, "Y:" + lY); // para chequear en que coordenada hacer el salto de página
        	lX1 = 20;
        	lY += lH;
        }
	}
}
