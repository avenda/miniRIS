package com.eims.ris.core;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.trolltech.qt.gui.QPainter;
import com.trolltech.qt.gui.QPrinter;
import com.trolltech.qt.gui.QTableWidget;

public class Funcionario extends Persona{
	/**
	 * @uml.property  name="_Id"
	 */
	private int _Id;
	/**
	 * @uml.property  name="_Iniciales"
	 */
	private String _Iniciales;
	/**
	 * @uml.property  name="_Profesion"
	 */
	private Profesion _Profesion;
	/**
	 * @uml.property  name="_Vigente"
	 */
	private boolean _Vigente;
	
	public int getId(){
		return _Id;
	}
	public void setId(int id){
		this._Id = id;
	}
	public String getIniciales(){
		return _Iniciales;
	}
	public void setIniciales(String iniciales){
		this._Iniciales = iniciales;
	}
	public Profesion getProfesion(){
		return _Profesion;
	}
	public void setProfesion(Profesion profesion){
		this._Profesion = profesion;
	}
	public boolean isVigente(){
		return _Vigente;
	}
	public void setVigente(boolean vigente){
		this._Vigente = vigente;
	}
	public boolean setFuncionario(int ID){
		ResultSet rs = DBUtils.getResultSet(String.format("SELECT fun_nomb, fun_apat, fun_amat, fun_inic, prf_id, fun_vige FROM miniris.funcionarios WHERE fun_id=%1$s", ID));
		try{
	    	if(rs.next()){
	    		this.setId(ID);
	    		this.setNombre(rs.getString("fun_nomb"));
	    		this.setAPaterno(rs.getString("fun_apat"));
	    		this.setAMaterno(rs.getString("fun_amat"));
	    		this.setIniciales(rs.getString("fun_inic"));
	    		Profesion profesion = new Profesion();
	    		profesion.setProfesion(rs.getInt("prf_id"));
	    		this.setProfesion(profesion);
	    		this.setVigente(rs.getBoolean("fun_vige"));
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
		String sql = String.format("INSERT INTO miniRIS.funcionarios (fun_nomb,fun_apat,fun_amat,fun_inic,prf_id,fun_vige) VALUES('%1$s', '%2$s', '%3$s', '%4$s', %5$s, %6$s);",this.getNombre(),this.getAPaterno(),this.getAMaterno(),this.getIniciales(),this.getProfesion().getId(),this.isVigente());
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
		String sql = String.format("UPDATE miniris.funcionarios SET fun_nomb='%1$s', fun_apat='%2$s', fun_amat='%3$s', fun_inic='%4$s', prf_id=%5$s, fun_vige=%6$s WHERE fun_id=%7$s;",this.getNombre(),this.getAPaterno(), this.getAMaterno(), this.getIniciales(), this.getProfesion().getId(),this.isVigente(),this.getId());
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
		String sql = String.format("DELETE FROM miniris.funcionarios WHERE fun_id=%1$s;",this.getId());
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
		//String sql = "INSERT INTO funcionarios (fun_nomb,fun_apat,fun_amat,fun_inic,prf_id,fun_vige) VALUES(?,?,?,?,?,?);";
		String sql = "CALL miniris.FN_SAVE_FUNCIONARIO(null,?,?,?,?,?,?);";
//		"{? = CALL miniris.FN_SAVE_FUNCIONARIO(null,?,?,?,?,?,?)}"; // PARA RECUPERAR parametro OUT
		try{
			PreparedStatement ps = cnn.prepareStatement(sql);
			ps.setString(1, this.getNombre());
			ps.setString(2, this.getAPaterno());
			ps.setString(3, this.getAMaterno());
			ps.setString(4, this._Iniciales);
			ps.setInt(5, this._Profesion);
			ps.setBoolean(6, this._Vigente);
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
        printer.setOrientation(QPrinter.Orientation.Landscape);
        printer.setPageSize(QPrinter.PageSize.Letter);
        printer.setCreator("EIMS - eHC::RIS");
        printer.setDocName("Informe de funcionarios");
        QPainter painter = new QPainter();
        if(!painter.begin(printer)){
            //qWarning("Error al abrir el archivo PDF para escritura.");
            return;
        }
        painter.setRenderHint(QPainter.RenderHint.Antialiasing, true);
        // Arreglo utilizado para el header del informe con sus respectivos Widths y Aligns
        String header[][] = new String[7][3];
        header[0][0] = "50"; // Width de la celda
        header[0][1] = "ID"; // Texto de la celda
        header[0][2] = "3";  // Align de la celda
        header[1][0] = "200";
        header[1][1] = "NOMBRE";
        header[1][2] = "0";
        header[2][0] = "150";
        header[2][1] = "A. PATERNO";
        header[2][2] = "0";
        header[3][0] = "150";
        header[3][1] = "A. MATERNO";
        header[3][2] = "0";
        header[4][0] = "50";
        header[4][1] = "INIC";
        header[4][2] = "0";
        header[5][0] = "200";
        header[5][1] = "PROFESIÓN";
        header[5][2] = "0";
        header[6][0] = "80";
        header[6][1] = "VIGENTE";
        header[6][2] = "5";
        String lTitle = "INFORME DE FUNCIONARIOS";
        Utils.PrintHeader(painter, lTitle, header, 1, (int)(tw.rowCount() / 32) + 1);
        Utils.PrintTableWidget(printer, painter, lTitle, tw, header);
        
        painter.end(); // finaliza el dibujado y libera el archivo PDF.
        Utils.ShowPDF(printer.outputFileName());
	}
}
