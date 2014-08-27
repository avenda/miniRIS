package com.eims.ris.core;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.trolltech.qt.gui.QPainter;
import com.trolltech.qt.gui.QPrinter;
import com.trolltech.qt.gui.QTableWidget;

public class Prestacion {
	
	/**
	 * @uml.property  name="_Id"
	 */
	private String _Id;
	/**
	 * @uml.property  name="_Descripcion"
	 */
	private String _Descripcion;
	/**
	 * @uml.property  name="_Tipo"
	 */
	private Tipo _Tipo;
	/**
	 * @uml.property  name="_rfDefecto"
	 */
	private RRFFs _rfDefecto;
	/**
	 * @uml.property  name="_Vigente"
	 */
	private boolean _Vigente;
	
	public Prestacion(){
		DBUtils.connectDB();
	}
	
	public String getId() {
		return _Id;
	}

	public void setId(String id) {
		this._Id = id;
	}

	public String getDescripcion() {
		return _Descripcion;
	}

	public void setDescripcion(String descripcion) {
		this._Descripcion = descripcion;
	}

	public Tipo getTipo() {
		return _Tipo;
	}

	public void setTipo(Tipo tipo) {
		this._Tipo = tipo;
	}

	public RRFFs getRRFFxDefecto() {
		return _rfDefecto;
	}

	public void setRRFFxDefecto(RRFFs rfDefecto) {
		this._rfDefecto = rfDefecto;
	}
	
	public boolean isVigente() {
		return _Vigente;
	}

	public void setVigente(boolean vigente) {
		this._Vigente = vigente;
	}
	
	public boolean setPrestacion(String ID){
		ResultSet rs = DBUtils.getResultSet(String.format("SELECT prest_desc, prest_tipo, rf_id, prest_vige FROM miniris.prestaciones WHERE prest_id='%1$s';", ID));
		try{
	    	if(rs.next()){
	    		this.setId(ID);
	    		this.setDescripcion(rs.getString("prest_desc"));
	    		Tipo tipo = new Tipo();
	    		tipo.setTipo(rs.getInt("prest_tipo"));
	    		this.setTipo(tipo);
	    		RRFFs rf = new RRFFs();
	    		rf.setRF(rs.getInt("rf_id"));
	    		this.setRRFFxDefecto(rf);
	    		this.setVigente(rs.getBoolean("prest_vige"));
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
		String sql = String.format("INSERT INTO miniris.prestaciones (prest_id,prest_desc,prest_tipo,rf_id,prest_vige) VALUES('%1$s', '%2$s', %3$s, %4$s, %5$s);",this.getId(),this.getDescripcion(),this.getTipo().getId(),this.getRRFFxDefecto().getId(),this.isVigente());
		return DBUtils.executeNonQuery(sql);
	}
	
	public boolean Modificar(){
		String sql = String.format("UPDATE miniris.prestaciones SET prest_desc='%1$s',prest_tipo=%2$s,rf_id=%3$s,prest_vige=%4$s WHERE prest_id='%5$s';",this.getDescripcion(), this.getTipo().getId(), this.getRRFFxDefecto().getId(), this.isVigente(), this.getId());
		return DBUtils.executeNonQuery(sql);
	}
	
	public boolean Eliminar(){
		String sql = String.format("DELETE FROM miniris.prestaciones WHERE prest_id='%1$s';",this.getId());
		return DBUtils.executeNonQuery(sql);
	}
	
	public static void Printer(QTableWidget tw){
		QPrinter printer = new QPrinter(); //(QPrinter::HighResolution);
        printer.setOutputFormat(QPrinter.OutputFormat.PdfFormat);
        printer.setOutputFileName("/home/pablo/temp/informe.pdf");
        printer.setOrientation(QPrinter.Orientation.Landscape);
        printer.setPageSize(QPrinter.PageSize.Letter);
        QPainter painter = new QPainter();
        if(!painter.begin(printer)){
            //qWarning("Error al abrir el archivo PDF para escritura.");
            return;
        }
        painter.setRenderHint(QPainter.RenderHint.Antialiasing, true);
        // Arreglo utilizado para el header del informe con sus respectivos Widths y Aligns
        String header[][] = new String[5][3];
        header[0][0] = "70";     // Width de la celda
        header[0][1] = "CÓDIGO"; // Texto de la celda
        header[0][2] = "0";      // Align de la celda
        header[1][0] = "100";
        header[1][1] = "TIPO";
        header[1][2] = "0";
        header[2][0] = "400";
        header[2][1] = "DESCRIPCIÓN";
        header[2][2] = "0";
        header[3][0] = "250";
        header[3][1] = "RRFF ASOCIADO";
        header[3][2] = "0";
        header[4][0] = "80";
        header[4][1] = "VIGENTE";
        header[4][2] = "5";
        String lTitle = "INFORME DE PRESTACIONES";
        Utils.PrintHeader(painter, lTitle, header, 1, (int)(tw.rowCount() / 32) + 1);
        Utils.PrintTableWidget(printer, painter, lTitle, tw, header);
        
        painter.end(); // finaliza el dibujado y libera el archivo PDF.
        Utils.ShowPDF(printer.outputFileName());
	}
}
