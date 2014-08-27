package com.eims.ris.core;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.trolltech.qt.core.QDate;

public class Paciente extends Persona{
	/**
	 * @uml.property  name="_Id"
	 */
	private int _Id;
	/**
	 * @uml.property  name="_run"
	 */
	private String _run;
	/**
	 * @uml.property  name="_Ficha"
	 */
	private int _Ficha;
	/**
	 * @uml.property  name="_FNac"
	 * @uml.associationEnd  
	 */
	private QDate _FNac;
	/**
	 * @uml.property  name="_Sexo"
	 */
	private String _Sexo;
	/**
	 * @uml.property  name="_Direccion"
	 */
	private String _Direccion;
	/**
	 * @uml.property  name="_Ciudad"
	 */
	private Ciudad _Ciudad;
	/**
	 * @uml.property  name="_Fono1"
	 */
	private String _Fono1;
	/**
	 * @uml.property  name="_Fono2"
	 */
	private String _Fono2;
	/**
	 * @uml.property  name="_Mail"
	 */
	private String _Mail;
	/**
	 * @uml.property  name="_SistSalud"
	 */
	private SistSalud _SistSalud;
	
    public Paciente(){
    	super();
    }
    public int getId() {
		return _Id;
	}
	public void setId(int id) {
		_Id = id;
	}
    public String getRUN(){
    	return this._run;
    }
    public void setRUN(String run){
    	this._run = run;
    }
	public int getFicha() {
		return _Ficha;
	}
	public void setFicha(int ficha) {
		_Ficha = ficha;
	}
	public QDate getFechaNacimiento(){
    	return this._FNac;
    }
    public void setFechaNacimiento(QDate fnac){
    	this._FNac = fnac;
    }
    public String getSexo(){
    	return this._Sexo;
    }
    public void setSexo(String sexo){
    	this._Sexo = sexo;
    }
	public String getDireccion(){
    	return this._Direccion;
    }
    public void setDireccion(String direccion){
    	this._Direccion = direccion;
    }
	public Ciudad getCiudad() {
		return _Ciudad;
	}
	public void setCiudad(Ciudad ciudad) {
		_Ciudad = ciudad;
	}
	public String getFono1(){
    	return this._Fono1;
    }
    public void setFono1(String fono){
    	this._Fono1 = fono;
    }
    public String getFono2(){
    	return this._Fono2;
    }
    public void setFono2(String fono){
    	this._Fono2 = fono;
    }
    public String getMail(){
    	return this._Mail;
    }
    public void setMail(String mail){
    	this._Mail = mail;
    }
    public SistSalud getSistemaSalud() {
		return _SistSalud;
	}
	public void setSistemaSalud(SistSalud sistSalud) {
		this._SistSalud = sistSalud;
	}
	
	public boolean setPaciente(int ID){
		ResultSet rs = DBUtils.getResultSet(String.format("SELECT pac_run, pac_fich, pac_nomb, pac_apat, pac_amat, pac_fnac, pac_sexo, ssa_id, pac_dire, pac_fon1, pac_fon2, pac_mail, ciu_id FROM miniris.pacientes WHERE pac_id=%1$s", ID));
    	try{
	    	if(rs.next()){
	    		this.setId(ID);
	    		this.setRUN(rs.getString("pac_run"));
	    		this.setFicha(rs.getInt("pac_fich"));
	    		this.setNombre(rs.getString("pac_nomb"));
	    		this.setAPaterno(rs.getString("pac_apat"));
	    		this.setAMaterno(rs.getString("pac_amat"));
	    		//this.setFechaNacimiento(QDate.fromString(rs.getString("pac_fnac"), "MM/dd/yy"));
	    		this.setFechaNacimiento(Utils.DateToQDate(rs.getDate("pac_fnac")));
	    		this.setSexo(rs.getString("pac_Sexo"));
	    		SistSalud sistSalud = new SistSalud();
	    		sistSalud.setSistemaSalud(rs.getInt("ssa_id"));
	    		this.setSistemaSalud(sistSalud);
	    		this.setDireccion(rs.getString("pac_dire"));
	    		this.setFono1(rs.getString("pac_fon1"));
	    		this.setFono2(rs.getString("pac_fon2"));
	    		this.setMail(rs.getString("pac_mail"));
	    		Ciudad ciudad = new Ciudad();
	    		ciudad.setCiudad(rs.getInt("ciu_id"));
	    		this.setCiudad(ciudad);
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
    	String sql = String.format("INSERT INTO miniris.pacientes (pac_run,pac_fich,pac_nomb, pac_apat, pac_amat, pac_fnac, pac_sexo, pac_dire, pac_fon1, pac_fon2, pac_mail,ciu_id,ssa_id )" +
    													"VALUES('%1$s', %2$s, '%3$s', '%4$s', '%5$s', '%6$s', '%7$s', '%8$s', '%9$s', '%10$s', '%11$s', %12$s, %12$s)"
    															   ,this.getRUN(),this.getFicha(),super.getNombre(),super.getAPaterno(), super.getAMaterno(), this.getFechaNacimiento().toString("yyyy-MM-dd"), this.getSexo(), this.getDireccion(), this.getFono1(), this.getFono2(), this.getMail(),this.getCiudad().getId(), this.getSistemaSalud().getId());
    	return DBUtils.executeNonQuery(sql);
    }
    public boolean Modificar(){
    	String sql = String.format("UPDATE miniris.pacientes SET pac_run='%1$s',pac_fich=%2$s,pac_nomb='%3$s', pac_apat='%4$s', pac_amat='%5$s', pac_fnac='%6$s', pac_sexo='%7$s', pac_dire='%8$s', pac_fon1='%9$s', pac_fon2='%10$s', pac_mail='%11$s', ciu_id=%12$s,ssa_id=%13$s WHERE pac_id=%14$s" 
    							,this.getRUN(),this.getFicha(),super.getNombre(),super.getAPaterno(),super.getAMaterno(),this.getFechaNacimiento().toString("yyyy-MM-dd"), this.getSexo(), this.getDireccion(), this.getFono1(), this.getFono2(), this.getMail(),this.getCiudad().getId(),this.getSistemaSalud().getId(), this.getId());
    	System.out.println(sql);
    	return DBUtils.executeNonQuery(sql);
    }
    public boolean Eliminar(){
    	String sql = String.format("DELETE FROM miniris.pacientes WHERE pac_id=%1$s", this.getId());
    	return DBUtils.executeNonQuery(sql);
    }
}