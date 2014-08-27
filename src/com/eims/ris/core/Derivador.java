package com.eims.ris.core;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.trolltech.qt.gui.QPainter;
import com.trolltech.qt.gui.QPrinter;
import com.trolltech.qt.gui.QTableWidget;


public class Derivador extends SimpleTable{
	/**
	 * @uml.property  name="_Tipo"
	 */
	private Tipo _Tipo;
	public Tipo getTipo() {
		return _Tipo;
	}
	public void setTipo(Tipo tipo) {
		this._Tipo = tipo;
	}
	public boolean setDerivador(int ID){
		ResultSet rs = DBUtils.getResultSet(String.format("SELECT deri_desc, deri_tipo, deri_vige FROM miniris.derivadores WHERE deri_id=%1$s", ID));
		try{
	    	if(rs.next()){
	    		this.setId(ID);
	    		this.setDescripcion(rs.getString("deri_desc"));
	    		Tipo tipo = new Tipo();
	    		tipo.setTipo(rs.getInt("deri_tipo"));
	    		this.setTipo(tipo);
	    		this.setVigente(rs.getBoolean("deri_vige"));
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
		String sql = String.format("INSERT INTO miniRIS.derivadores (deri_tipo,deri_desc,deri_vige) VALUES(%1$s, '%2$s', %3$s);",this.getTipo().getId(),this.getDescripcion(),this.isVigente());
		return DBUtils.executeNonQuery(sql);
		/*try{
			PreparedStatement ps = cnn.prepareStatement(sql);
			ps.execute();
			//cnn.commit();  
			ps.close();
			cnn.close();
			assert(true);
			return true;
		}catch(SQLException e){
			e.printStackTrace();
			assert(1 == 0);
			return false;
		}*/
	}
	public boolean Modificar(){
		//Connection cnn = DBUtils.connectDB();
		String sql = String.format("UPDATE miniris.derivadores SET deri_tipo=%1$s, deri_desc='%2$s', deri_vige=%3$s WHERE deri_id=%4$s;",this.getTipo().getId(),this.getDescripcion(),this.isVigente(),this.getId());
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
		String sql = String.format("DELETE FROM miniris.derivadores WHERE deri_id=%1$s;",this.getId());
		return DBUtils.executeNonQuery(sql);
		/*Connection cnn = DBUtils.connectDB();
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
	/*private boolean Actualizar(){
		Connection cnn = DBUtils.connectDB();
		String sql = "{CALL miniris.FN_SAVE_SISTSALUD(null,?,?,?)}";
		try{
			//PreparedStatement ps = cnn.prepareCall(sql);
			CallableStatement ps = cnn.prepareCall(sql);
			ps.setString(1, this.getDescripcion());
			ps.setInt(2, this._Tipo);
			ps.setBoolean(3, this.isVigente());
			ps.execute();
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
        printer.setDocName("Informe lugares de derivación");
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
        header[1][0] = "120";
        header[1][1] = "TIPO";
        header[1][2] = "0";
        header[2][0] = "300";
        header[2][1] = "DESCRIPCIÓN";
        header[2][2] = "0";
        header[3][0] = "80";
        header[3][1] = "VIGENTE";
        header[3][2] = "5";
        String lTitle = "INFORME LUGARES DE DERIVACIÓN";
        Utils.PrintHeader(painter, lTitle, header, 1, (int)(tw.rowCount() / 44) + 1);
        Utils.PrintTableWidget(printer, painter, lTitle, tw, header);
        
        painter.end(); // finaliza el dibujado y libera el archivo PDF.
        Utils.ShowPDF(printer.outputFileName());
	}
}
