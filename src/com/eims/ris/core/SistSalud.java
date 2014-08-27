package com.eims.ris.core;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.trolltech.qt.gui.QPainter;
import com.trolltech.qt.gui.QPrinter;
import com.trolltech.qt.gui.QTableWidget;

public class SistSalud extends SimpleTable {
	public boolean setSistemaSalud(int sistSaludID){
		try{
	    	ResultSet rs = DBUtils.getResultSet(String.format("SELECT ssa_desc, ssa_vige FROM miniris.sist_salud WHERE ssa_id=%1$s", sistSaludID));
	    	if(rs.next()){
	    		this.setId(sistSaludID);
	    		this.setDescripcion(rs.getString("ssa_desc"));
	    		this.setVigente(rs.getBoolean("ssa_vige"));
	    	}
    	}catch(SQLException e) {
			DBUtils.showSQLException(e);
			return false;
		}
		return true;
	}
	
	public boolean Insertar(){
		//Connection cnn = DBUtils.connectDB();
		String sql = String.format("INSERT INTO miniRIS.sist_salud (ssa_desc,ssa_vige) VALUES('%1$s', %2$s);",this.getDescripcion(),this.isVigente());
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
		String sql = String.format("UPDATE miniRIS.sist_salud SET ssa_desc='%1$s', ssa_vige=%2$s WHERE ssa_id=%3$s;",this.getDescripcion(),this.isVigente(),this.getId());
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
		String sql = String.format("DELETE FROM sist_salud WHERE ssa_id=%1$i;",this.getId());
		return DBUtils.executeNonQuery(sql);
		/*try{
			PreparedStatement ps = cnn.prepareStatement(sql);
			ps.execute();
			cnn.commit();
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
		String sql = "{call miniRIS.FN_SAVE_SISTSALUD(?,?,?)}";
		//System.out.print("ID: "+this.getId()+" - Desc: "+this.getDescripcion()+" - Vige: "+this.isVigente());
		try{
			//PreparedStatement ps = cnn.prepareCall(sql);
			CallableStatement cs = cnn.prepareCall(sql);
			cs.setInt("id", this.getId());
			cs.setString("descripcion", this.getDescripcion());
			cs.setBoolean("vigente", this.isVigente());
			cs.execute();
			cs.close();
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
        printer.setDocName("Informe sistemas de salud");
        QPainter painter = new QPainter();
        if(!painter.begin(printer)){
            //qWarning("Error al abrir el archivo PDF para escritura.");
            return;
        }
        painter.setRenderHint(QPainter.RenderHint.Antialiasing, true);
        // Arreglo utilizado para el header del informe con sus respectivos Widths y Aligns
        String header[][] = new String[3][3];
        header[0][0] = "50"; // Width de la celda
        header[0][1] = "ID"; // Texto de la celda
        header[0][2] = "3";  // Align de la celda
        header[1][0] = "300";
        header[1][1] = "DESCRIPCIÓN";
        header[1][2] = "0";
        header[2][0] = "80";
        header[2][1] = "VIGENTE";
        header[2][2] = "5";
        String lTitle = "INFORME SISTEMAS DE SALUD";
        Utils.PrintHeader(painter, lTitle, header, 1, (int)(tw.rowCount() / 44) + 1);
        Utils.PrintTableWidget(printer, painter, lTitle, tw, header);
        
        painter.end(); // finaliza el dibujado y libera el archivo PDF.
        Utils.ShowPDF(printer.outputFileName());
	}
}
