/**
 * Proyecto		: eHC.RIS (parte del proyecto EIMS)
 * Clase		: Agenda.java
 * Fecha		: 2011.11.01
 * Uso			: Clase que permite gestionar las plantillas de las agendas generadas en el sistema
 * Dependencias	: 
 * 					Funcionarios
 * 					RR.FF.
 */

package com.eims.ris.core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Agenda extends SimpleTable {
	/**
	 * @uml.property  name="_profesional"
	 */
	private int _profesional;
	/**
	 * @uml.property  name="_rfAsociado"
	 */
	private int _rfAsociado;
	/**
	 * @uml.property  name="_cantCupos"
	 */
	private int _cantCupos;
	/**
	 * @uml.property  name="_intervalo"
	 */
	private int _intervalo;
	/**
	 * @uml.property  name="_horaInicio"
	 */
	private String _horaInicio;
	/**
	 * @uml.property  name="_lun"
	 */
	private boolean _lun;
	/**
	 * @uml.property  name="_mar"
	 */
	private boolean _mar;
	/**
	 * @uml.property  name="_mie"
	 */
	private boolean _mie;
	/**
	 * @uml.property  name="_jue"
	 */
	private boolean _jue;
	/**
	 * @uml.property  name="_vie"
	 */
	private boolean _vie;
	/**
	 * @uml.property  name="_sab"
	 */
	private boolean _sab;
	/**
	 * @uml.property  name="_dom"
	 */
	private boolean _dom;
	/**
	 * @uml.property  name="_usuario"
	 */
	private String _usuario;
	/**
	 * @uml.property  name="_planificacion"
	 */
	private List<AgendaDetails> _planificacion;
	
	public Agenda(){
		super();
		this._planificacion = new ArrayList<AgendaDetails>();
	}
	
	public int getProfesional() {
		return _profesional;
	}
	public void setProfesional(int profesional) {
		this._profesional = profesional;
	}
	public int getRFAsociado() {
		return _rfAsociado;
	}
	public void setRFAsociado(int rfAsociado) {
		this._rfAsociado = rfAsociado;
	}
	public int getCantidadCupos() {
		return _cantCupos;
	}
	public void setCantidadCupos(int cantCupos) {
		this._cantCupos = cantCupos;
	}
	public int getIntervalo() {
		return _intervalo;
	}
	public void setIntervalo(int intervalo) {
		this._intervalo = intervalo;
	}
	public String getHoraInicio() {
		return _horaInicio;
	}
	public void setHoraInicio(String horaInicio) {
		this._horaInicio = horaInicio;
	}
	public boolean getLunes() {
		return _lun;
	}
	public void setLunes(boolean lun) {
		this._lun = lun;
	}
	public boolean getMartes() {
		return _mar;
	}
	public void setMartes(boolean mar) {
		this._mar = mar;
	}
	public boolean getMiercoles() {
		return _mie;
	}
	public void setMiercoles(boolean mie) {
		this._mie = mie;
	}
	public boolean getJueves() {
		return _jue;
	}
	public void setJueves(boolean jue) {
		this._jue = jue;
	}
	public boolean getViernes() {
		return _vie;
	}
	public void setViernes(boolean vie) {
		this._vie = vie;
	}
	public boolean getSabado() {
		return _sab;
	}
	public void setSabado(boolean sab) {
		this._sab = sab;
	}
	public boolean getDomingo() {
		return _dom;
	}
	public void setDomingo(boolean dom) {
		this._dom = dom;
	}
	public String getUsuario() {
		return _usuario;
	}
	public void setUsuario(String usuario) {
		this._usuario = usuario;
	}
	public List<AgendaDetails> getPlanificacion() {
		return _planificacion;
	}
	public void setPlanificacion(AgendaDetails planificacion) {
		this._planificacion.add(planificacion);
	}
	
	public boolean Insertar(){
		try{
			Connection cnn = DBUtils.connectDB();
			cnn.setAutoCommit(false);
			String sql = "SELECT NEXTVAL('miniris.plantillas_agendas_enc_pae_id_seq');";
			ResultSet rs = DBUtils.getResultSet(sql);
			rs.next();
			this.setId(rs.getInt(1));
			rs.close();
			sql = String.format("INSERT INTO miniris.plantillas_agendas_enc (pae_id,fun_id, rf_id, pae_desc, pae_ccup, pae_itvo, pae_hini, pae_lun, pae_mar, pae_mie, pae_jue, pae_vie, pae_sab, pae_dom) VALUES(%1$s, %2$s, %3$s, '%4$s', %5$s, %6$s, '%7$s', %8$s, %9$s, %10$s, %11$s, %12$s, %13$s, %14$s);",
					this.getId(),
					this.getProfesional(), 
					this.getRFAsociado(), 
					this.getDescripcion(), 
					this.getCantidadCupos(), 
					this.getIntervalo(), 
					this.getHoraInicio(), 
					this.getLunes(), 
					this.getMartes(), 
					this.getMiercoles(),
					this.getJueves(),
					this.getViernes(),
					this.getSabado(),
					this.getDomingo());
			//System.out.println(sql);
			PreparedStatement ps = cnn.prepareStatement(sql);
			ps.execute();
			PreparedStatement ps2;
			for(AgendaDetails ad : this._planificacion){
				sql = String.format("INSERT INTO miniris.plantillas_agendas_det VALUES(%1$s, '%2$s', '%3$s', '%4$s', '%5$s', '%6$s', '%7$s', '%8$s')",
									this.getId(),
									ad.getLunes(),
									ad.getMartes(),
									ad.getMiercoles(),
									ad.getJueves(),
									ad.getViernes(),
									ad.getSabado(),
									ad.getDomingo());
				//System.out.println(sql);
				ps2 = cnn.prepareStatement(sql);
				ps2.execute();
			}
			//assert(true);
			cnn.commit();
			ps.close();
			cnn.close();
			return true;
		}catch(SQLException e){
			e.printStackTrace();
			assert(1 == 0);
			return false;
		}
	}
	public boolean Modificar(){
		boolean ok = false;
		String sql = String.format("UPDATE miniris.plantillas_agendas_enc SET fun_id=%1$s, rf_id=%2$s, pae_desc='%3$s' WHERE pae_id=%4$s;", this.getProfesional(), this.getRFAsociado(), this.getDescripcion(), this.getId());
		System.out.print(sql);
		ok = DBUtils.executeNonQuery(sql);
		assert(ok);
		return ok;
	}
	public boolean Eliminar(){
		boolean ok = false;
		String sql = String.format("DELETE FROM miniris.plantillas_agendas_enc WHERE pae_id=%1$s;",this.getId());
		ok = DBUtils.executeNonQuery(sql);
		assert(ok);
		return ok;
	}
	
	public boolean findAgenda(int id){
		boolean found = false;
		String sql;
		try{
			sql = "SELECT * FROM miniris.plantillas_agendas_enc WHERE pae_id=%1$s";
			ResultSet query = DBUtils.getResultSet(String.format(sql, id));
			while(query.next()){
				this.setProfesional(query.getInt("fun_id"));
				this.setRFAsociado(query.getInt("rf_id"));
				this.setDescripcion(query.getString("pae_desc"));
				this.setCantidadCupos(query.getInt("pae_ccup"));
				this.setIntervalo(query.getInt("pae_itvo"));
				this.setHoraInicio(query.getString("pae_hini"));
				this.setLunes(query.getBoolean("pae_lun"));
				this.setMartes(query.getBoolean("pae_mar"));
				this.setMiercoles(query.getBoolean("pae_mie"));
				this.setJueves(query.getBoolean("pae_jue"));
				this.setViernes(query.getBoolean("pae_vie"));
				this.setSabado(query.getBoolean("pae_sab"));
				this.setDomingo(query.getBoolean("pae_dom"));
				sql = "SELECT * FROM miniris.plantillas_agendas_det WHERE pae_id=%1$s";
				ResultSet query2 = DBUtils.getResultSet(String.format(sql, id));
				while(query2.next()){
					AgendaDetails planificacion = new AgendaDetails();
					planificacion.setLunes(query2.getString("pad_lun"));
					planificacion.setMartes(query2.getString("pad_mar"));
					planificacion.setMiercoles(query2.getString("pad_mie"));
					planificacion.setJueves(query2.getString("pad_jue"));
					planificacion.setViernes(query2.getString("pad_vie"));
					planificacion.setSabado(query2.getString("pad_sab"));
					planificacion.setDomingo(query2.getString("pad_dom"));
					this.setPlanificacion(planificacion);
				}
				found = (query.getRow() > 0);
				//found = (DBUtils.getNumRows(query) > 0);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return found;
	}
}
