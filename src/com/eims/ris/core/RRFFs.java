package com.eims.ris.core;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.trolltech.qt.gui.QPainter;
import com.trolltech.qt.gui.QPrinter;
import com.trolltech.qt.gui.QTableWidget;


public class RRFFs extends SimpleTable {
	/**
	 * @uml.property  name="_Modalidad"
	 */
	private Modalidad _Modalidad;
	

	public Modalidad getModalidad() {
		return _Modalidad;
	}

	public void setModalidad(Modalidad modalidad) {
		this._Modalidad = modalidad;
	}
	
	public boolean setRF(int ID){
		ResultSet rs = DBUtils.getResultSet(String.format("SELECT rf_desc, rf_moda, rf_vige FROM miniris.rrffs WHERE rf_id=%1$s", ID));
		try{
	    	if(rs.next()){
	    		this.setId(ID);
	    		this.setDescripcion(rs.getString("rf_desc"));
	    		Modalidad modalidad = new Modalidad();
	    		modalidad.setModalidad(rs.getInt("rf_moda"));
	    		this.setModalidad(modalidad);
	    		this.setVigente(rs.getBoolean("rf_vige"));
	    	}
	    	rs.close();
    	}catch(SQLException e) {
			DBUtils.showSQLException(e);
			return false;
		}finally{
			rs = null;
		}
		return true;
	}
	
	public boolean Insertar(){
		String sql = String.format("INSERT INTO miniris.rrffs (rf_desc, rf_moda, rf_vige) VALUES('%1$s', '%2$s', %3$s);", this.getDescripcion(), this.getModalidad().getId(), this.isVigente());
		return DBUtils.executeNonQuery(sql);
	}
	public boolean Modificar(){
		String sql = String.format("UPDATE miniris.rrffs SET rf_desc='%1$s', rf_moda='%2$s', rf_vige=%3$s WHERE rf_id=%4$s;", this.getDescripcion(), this.getModalidad().getId(), this.isVigente(), this.getId());
		return DBUtils.executeNonQuery(sql);
	}
	public boolean Eliminar(){
		String sql = String.format("DELETE FROM miniris.rrffs WHERE rf_id=%1$s", this.getId());
		return DBUtils.executeNonQuery(sql);
	}
	public static void Printer(QTableWidget tw){
		QPrinter printer = new QPrinter(); //(QPrinter::HighResolution);
        printer.setOutputFormat(QPrinter.OutputFormat.PdfFormat);
        printer.setOutputFileName("/home/pablo/temp/informe.pdf");
        printer.setPageSize(QPrinter.PageSize.Letter);
        printer.setCreator("EIMS - eHC::RIS");
        printer.setDocName("Informe de recursos físicos");
        QPainter painter = new QPainter();
        if(!painter.begin(printer)){
            //qWarning("Error al abrir el archivo PDF para escritura.");
            return;
        }
        painter.setRenderHint(QPainter.RenderHint.Antialiasing, true);
        // Arreglo utilizado para el header del informe con sus respectivos Widths y Aligns
        String header[][] = new String[4][4];
        header[0][0] = "50"; // Width de la celda
        header[0][1] = "ID"; // Texto de la celda
        header[0][2] = "3";  // Align de la celda
        header[1][0] = "300";
        header[1][1] = "DESCRIPCIÓN";
        header[1][2] = "0";
        header[2][0] = "100";
        header[2][1] = "MODALIDAD";
        header[2][2] = "5";
        header[3][0] = "80";
        header[3][1] = "VIGENTE";
        header[3][2] = "5";
        String lTitle = "INFORME DE RECURSOS FÍSICOS";
        Utils.PrintHeader(painter, lTitle, header, 1, (int)(tw.rowCount() / 44) + 1);
        Utils.PrintTableWidget(printer, painter, lTitle, tw, header);
        
        painter.end(); // finaliza el dibujado y libera el archivo PDF.
        Utils.ShowPDF(printer.outputFileName());
	}
}
