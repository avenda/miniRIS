package com.eims.ris.core;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.trolltech.qt.gui.QPainter;
import com.trolltech.qt.gui.QPrinter;
import com.trolltech.qt.gui.QTableWidget;

/**
 * Clase Manipuladora del archivo maestro de Profesiones
 */
public class Profesion extends SimpleTable{
	
	/**
	 * @uml.property  name="_Abreviacion"
	 */
	private String _Abreviacion;

	public String getAbreviacion() {
		return this._Abreviacion;
	}

	public void setAbreviacion(String abreviacion) {
		this._Abreviacion = abreviacion;
	}
	public boolean setProfesion(int ID){
		ResultSet rs = DBUtils.getResultSet(String.format("SELECT prf_desc,prf_abre,prf_vige FROM miniris.profesiones WHERE prf_id=%1$s", ID));
		try{
	    	if(rs.next()){
	    		this.setId(ID);
	    		this.setDescripcion(rs.getString("prf_desc"));
	    		this.setAbreviacion(rs.getString("prf_abre"));
	    		this.setVigente(rs.getBoolean("prf_vige"));
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
		//Connection cnn = DBUtils.connectDB();
		String sql = String.format("INSERT INTO miniRIS.profesiones (prf_desc,prf_abre,prf_vige) VALUES('%1$s', '%2$s', %3$s);",this.getDescripcion(),this._Abreviacion,this.isVigente());
		return DBUtils.executeNonQuery(sql);
		/*try{
			PreparedStatement ps = cnn.prepareStatement(sql);
			ps.execute();
			//cnn.commit();  
			ps.close();
			cnn.close();
			return true;
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}*/
	}
	public boolean Modificar(){
		//Connection cnn = DBUtils.connectDB();
		String sql = String.format("UPDATE miniRIS.profesiones SET prf_desc='%1$s', prf_abre='%2$s', prf_vige=%3$s WHERE prf_id=%4$s;",this.getDescripcion(),this._Abreviacion,this.isVigente(),this.getId());
		return DBUtils.executeNonQuery(sql);
		/*System.out.print(sql);
		try{
			PreparedStatement ps = cnn.prepareStatement(sql);
			ps.execute();
			//cnn.commit();
			ps.close();
			cnn.close();
			return true;
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}*/
	}
	public boolean Eliminar(){
		//Connection cnn = DBUtils.connectDB();
		String sql = String.format("DELETE FROM miniris.profesiones WHERE prf_id=%1$s;",this.getId());
		return DBUtils.executeNonQuery(sql);
		/*try{
			PreparedStatement ps = cnn.prepareStatement(sql);
			ps.execute();
			//cnn.commit();
			ps.close();
			cnn.close();
			return true;
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}*/
	}
	/*private boolean Actualizar(){
		Connection cnn = DBUtils.connectDB();
		String sql = "CALL miniris.FN_SAVE_PROFESION(null,?,?,?,?);";
		try{
			PreparedStatement ps = cnn.prepareStatement(sql);
			ps.setInt(1, this.getId());
			ps.setString(2, this.getDescripcion());
			ps.setString(3, this.getPrsAbre());
			ps.setBoolean(4, this.isVigente());
			ps.execute();
			cnn.commit();
			ps.close();
			cnn.close();
			return true;
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}*/
	public static void Printer(QTableWidget tw){
		QPrinter printer = new QPrinter(); //(QPrinter::HighResolution);
        printer.setOutputFormat(QPrinter.OutputFormat.PdfFormat);
        printer.setOutputFileName("/home/pablo/temp/informe.pdf");
        printer.setPageSize(QPrinter.PageSize.Letter);
        printer.setCreator("EIMS - eHC::RIS");
        printer.setDocName("Informe de profesiones");
        QPainter painter = new QPainter();
        if(!painter.begin(printer)){
            //qWarning("Error al abrir el archivo PDF para escritura.");
            return;
        }
        painter.setRenderHint(QPainter.RenderHint.Antialiasing, true);
        // Arreglo utilizado para el header del informe con sus respectivos Widths y Aligns
        String header[][] = new String[4][3];
        header[0][0] = "50"; // Width de la celda
        header[0][1] = "ID"; // Texto de la celda
        header[0][2] = "3";  // Align de la celda
        header[1][0] = "300";
        header[1][1] = "DESCRIPCIÓN";
        header[1][2] = "0";
        header[2][0] = "100";
        header[2][1] = "ABREV.";
        header[2][2] = "0";
        header[3][0] = "80";
        header[3][1] = "VIGENTE";
        header[3][2] = "5";
        String lTitle = "INFORME DE PROFESIONES";
        Utils.PrintHeader(painter, lTitle, header, 1, (int)(tw.rowCount() / 44) + 1);
        Utils.PrintTableWidget(printer, painter, lTitle, tw, header);
        
        painter.end(); // finaliza el dibujado y libera el archivo PDF.
        Utils.ShowPDF(printer.outputFileName());
	}
}
