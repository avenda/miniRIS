package com.eims.ris.core;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.trolltech.qt.gui.QPainter;
import com.trolltech.qt.gui.QPrinter;
import com.trolltech.qt.gui.QTableWidget;

public class Ciudad extends SimpleTable {
	public boolean setCiudad(int ID){
		ResultSet rs = DBUtils.getResultSet(String.format("SELECT ciu_desc FROM miniris.ciudades WHERE ciu_id=%1$s", ID));
		try{
	    	if(rs.next()){
	    		this.setId(ID);
	    		this.setDescripcion(rs.getString("ciu_desc"));
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
		try{
			Connection cnn = DBUtils.connectDB();
			
			//String sql = String.format("INSERT INTO miniRIS.ciudades(ciu_id, ciu_nomb) VALUES('%1$s','%2$s')", this.getId(), this.getDescripcion());
			//PreparedStatement ps = cnn.prepareStatement(sql);
			//ps.execute();
			//ps.close();
		
			String sql = "{? = CALL miniris.fn_ciudad_insert()}";
			CallableStatement cs = cnn.prepareCall(sql);
			cs.setString(1, this.getDescripcion());
			cs.execute();
			cs.close();
			
			cnn.close();
			return true;
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}
	public boolean Modificar(){
		String sql = String.format("UPDATE miniRIS.ciudades SET ciu_desc='%1$s' WHERE ciu_id=%2$s", this.getDescripcion(), this.getId());
		return DBUtils.executeNonQuery(sql);
		/*try{
			Connection cnn = DBUtils.connectDB();
			String sql = String.format("UPDATE miniRIS.ciudades SET ciu_desc='%1$s' WHERE ciu_id=%2$s", this.getDescripcion(), this.getId());
			PreparedStatement ps = cnn.prepareStatement(sql);
			ps.execute();
			ps.close();
			
			//String sql = "{? = CALL miniris.fn_ciudad_update(?,?)}";
			//CallableStatement cs = cnn.prepareCall(sql);
			//cs.registerOutParameter(1, java.sql.Types.BOOLEAN);
			//cs.setLong(2, this.getId());
			//cs.setString(3, this.getDescripcion());
			//cs.execute();
			//cs.close();
			
			cnn.close();
			return true;
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}*/
	}
	public boolean Eliminar(){
		//Connection cnn = DBUtils.connectDB();
		String sql = String.format("DELETE FROM miniRIS.ciudades WHERE ciu_id='%1$s'", this.getId());
		return DBUtils.executeNonQuery(sql);
		/*try{
			PreparedStatement ps = cnn.prepareStatement(sql);
			ps.execute();
			ps.close();
			cnn.close();
			return true;
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}*/
	}
	public static void Printer(QTableWidget tw){
		QPrinter printer = new QPrinter(); //(QPrinter::HighResolution);
        printer.setOutputFormat(QPrinter.OutputFormat.PdfFormat);
        printer.setOutputFileName("/home/pablo/temp/informe.pdf");
        printer.setPageSize(QPrinter.PageSize.Letter);
        printer.setCreator("EIMS - eHC::RIS");
        printer.setDocName("Informe de cuidades");
        QPainter painter = new QPainter();
        if(!painter.begin(printer)){
            //qWarning("Error al abrir el archivo PDF para escritura.");
            return;
        }
        painter.setRenderHint(QPainter.RenderHint.Antialiasing, true);
        // Arreglo utilizado para el header del informe con sus respectivos Widths y Aligns
        String header[][] = new String[2][3];
        header[0][0] = "50"; // Width de la celda
        header[0][1] = "ID"; // Texto de la celda
        header[0][2] = "3";  // Align de la celda
        header[1][0] = "300";
        header[1][1] = "DESCRIPCIÓN";
        header[1][2] = "0";
        String lTitle = "INFORME DE CIUDADES";
        Utils.PrintHeader(painter, lTitle, header, 1, (int)(tw.rowCount() / 44) + 1);
        Utils.PrintTableWidget(printer, painter, lTitle, tw, header);
        
        painter.end(); // finaliza el dibujado y libera el archivo PDF.
        Utils.ShowPDF(printer.outputFileName());
	}
}
