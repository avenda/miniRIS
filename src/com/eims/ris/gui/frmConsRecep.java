package com.eims.ris.gui;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.eims.ris.core.DBUtils;
import com.eims.ris.core.Utils;
import com.eims.ris.core.Enumeradores.DateTimeFormat;
import com.eims.ris.gui.Ui_frmConsRecep;
import com.trolltech.qt.core.QDate;
import com.trolltech.qt.core.Qt;
import com.trolltech.qt.gui.QApplication;
import com.trolltech.qt.gui.QDialog;
import com.trolltech.qt.gui.QPainter;
import com.trolltech.qt.gui.QPrinter;
import com.trolltech.qt.gui.QTableWidget;
import com.trolltech.qt.gui.QTableWidgetItem;
import com.trolltech.qt.gui.QWidget;


public class frmConsRecep extends QDialog {

    Ui_frmConsRecep ui = new Ui_frmConsRecep();

    private String _userName;
    private String _dateFormat;

    public frmConsRecep(String userName) {
        this(userName, null);
    }

    public frmConsRecep(String userName, QWidget parent) {
        super(parent);
        ui.setupUi(this);
        _userName = userName;
        _dateFormat = Utils.getDateTimeFormat(DateTimeFormat.Date);
        ui.deFDesde.setDisplayFormat(_dateFormat);
        ui.deFHasta.setDisplayFormat(_dateFormat);
        QDate curDate = QDate.currentDate();
        ui.deFDesde.setDate(new QDate(curDate.year(), curDate.month(), 1));
        ui.deFHasta.setDate(QDate.currentDate());
        ui.twRecepciones.resizeColumnsToContents();
        ui.btnAceptar.clicked.connect(this, "on_btnAceptar_Clicked()");
        ui.btnImprimir.clicked.connect(this, "on_btnImprimir_Clicked()");
        QApplication.restoreOverrideCursor();
    }
    
    public void on_btnAceptar_Clicked()
    {
    	int row = 0;
		ui.twRecepciones.setRowCount(0);
    	//																							  			Nvl_Urge
    	String sql = String.format("SELECT eps_id, eps_trec, eps_fhre, pac_apat, pac_amat, pac_nomb, deri_desc, par_desc, eps_pasi, eps_erec, ssa_desc " +
			    				   "FROM miniris.prestsol_enc ps " +
			    				   "INNER JOIN miniris.pacientes pac ON ps.pac_id=pac.pac_id " +
			    				   "INNER JOIN miniris.derivadores der ON ps.deri_id=der.deri_id " +
			    				   "INNER JOIN miniris.sist_salud ss ON ps.ssa_id=ss.ssa_id " +
			    				   "INNER JOIN miniris.parametros par ON ps.eps_nurg=par.par_id AND par.par_grupo='NU' " +
			    				   "WHERE eps_fhre BETWEEN '%1$s 00:00:00' AND '%2$s 23:59:59';", ui.deFDesde.date().toString("yyyy-MM-dd"), ui.deFHasta.date().toString("yyyy-MM-dd"));
    	System.out.println(sql);
    	Connection cnn = DBUtils.connectDB();
    	try{
	    	Statement stmt = cnn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);//, ResultSet.CONCUR_UPDATABLE);
	    	ResultSet query = stmt.executeQuery(sql); 
    		while(query.next()){
	            QTableWidgetItem item = null;
	            ui.twRecepciones.insertRow(row);
	            ui.twRecepciones.setRowHeight(row,20);
	
	            item = new QTableWidgetItem();
	            item.setText(query.getString("eps_id"));
	            item.setTextAlignment(Qt.AlignmentFlag.AlignVCenter.value() | Qt.AlignmentFlag.AlignRight.value());
	            ui.twRecepciones.setItem(row,0,item);
	
	            item = new QTableWidgetItem();
	            item.setText(query.getString("eps_trec"));
	            item.setTextAlignment(Qt.AlignmentFlag.AlignVCenter.value());
	            ui.twRecepciones.setItem(row,1,item);
	            
	            item = new QTableWidgetItem();
	            item.setText(query.getString("eps_fhre").substring(0, 16));
	            item.setTextAlignment(Qt.AlignmentFlag.AlignVCenter.value() | Qt.AlignmentFlag.AlignHCenter.value());
	            ui.twRecepciones.setItem(row,2,item);
	            
	            item = new QTableWidgetItem();
	            item.setText(query.getString("pac_apat")+" "+query.getString("pac_amat")+" "+query.getString("pac_nomb"));
	            item.setTextAlignment(Qt.AlignmentFlag.AlignVCenter.value());
	            ui.twRecepciones.setItem(row,3,item);
	            
	            item = new QTableWidgetItem();
	            item.setText(query.getString("deri_desc"));
	            item.setTextAlignment(Qt.AlignmentFlag.AlignVCenter.value());
	            ui.twRecepciones.setItem(row,4,item);

	            item = new QTableWidgetItem();
	            item.setText(query.getString("par_desc"));
	            item.setTextAlignment(Qt.AlignmentFlag.AlignVCenter.value());
	            ui.twRecepciones.setItem(row,5,item);
	            
	            item = new QTableWidgetItem();
	            item.setText(query.getBoolean("eps_pasi")?"Sí":"No");
	            item.setTextAlignment(Qt.AlignmentFlag.AlignVCenter.value() | Qt.AlignmentFlag.AlignHCenter.value());
	            ui.twRecepciones.setItem(row,6,item);
	            
	            item = new QTableWidgetItem();
	            item.setText(query.getString("eps_erec"));
	            item.setTextAlignment(Qt.AlignmentFlag.AlignVCenter.value());
	            ui.twRecepciones.setItem(row,7,item);
	            
	            item = new QTableWidgetItem();
	            item.setText(query.getString("ssa_desc"));
	            item.setTextAlignment(Qt.AlignmentFlag.AlignVCenter.value());
	            ui.twRecepciones.setItem(row,8,item);
	
	            row++;
	        }
    		ui.twRecepciones.resizeColumnsToContents();
    	}catch (SQLException e) {
			DBUtils.showSQLException(e);
		}
    }
    
    public void on_btnImprimir_Clicked()
    {
    	QPrinter printer = new QPrinter(); //(QPrinter::HighResolution);
        printer.setOutputFormat(QPrinter.OutputFormat.PdfFormat);
        printer.setOutputFileName("/home/pablo/temp/informe_recepciones.pdf");
        printer.setOrientation(QPrinter.Orientation.Landscape);
        printer.setPageSize(QPrinter.PageSize.Legal);
        printer.setCreator("EIMS - eHC::RIS");
        printer.setDocName("Informe de recepciones por periodo");
        QPainter painter = new QPainter();
        if(!painter.begin(printer)){
            //qWarning("Error al abrir el archivo PDF para escritura.");
            return;
        }
        painter.setRenderHint(QPainter.RenderHint.Antialiasing, true);
        // Arreglo utilizado para el header del informe con sus respectivos Widths y Aligns
        String header[][] = new String[9][3];
        header[0][0] = "80";    // Width de la celda
        header[0][1] = "ID"; 	// Texto de la celda
        header[0][2] = "0";     // Align de la celda
        header[1][0] = "100";
        header[1][1] = "TIPO";
        header[1][2] = "0";
        header[2][0] = "110";
        header[2][1] = "FECHA/HORA";
        header[2][2] = "0";
        header[3][0] = "250";
        header[3][1] = "PACIENTE";
        header[3][2] = "0";
        header[4][0] = "200";
        header[4][1] = "DERIVADOR";
        header[4][2] = "0";
        header[5][0] = "100";
        header[5][1] = "N.U.";
        header[5][2] = "0";
        header[6][0] = "60";
        header[6][1] = "ASISTE";
        header[6][2] = "5";
        header[7][0] = "100";
        header[7][1] = "ESTADO";
        header[7][2] = "0";
        header[8][0] = "150";
        header[8][1] = "SISTEMA SALUD";
        header[8][2] = "0";
        
        String lTitle = String.format("INFORME DE RECEPCIONES POR PERIODO\nDEL %1$S AL %2$s", ui.deFDesde.text(), ui.deFHasta.text());
        Utils.PrintHeader(painter, lTitle, header, 1, (int)(ui.twRecepciones.rowCount() / 32) + 1);
        Utils.PrintTableWidget(printer, painter, lTitle, ui.twRecepciones, header);
        
        painter.end(); // finaliza el dibujado y libera el archivo PDF.
        Utils.ShowPDF(printer.outputFileName());
    }
}
