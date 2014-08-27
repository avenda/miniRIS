package com.eims.ris.core;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.trolltech.qt.core.QDateTime;

public class Recepcion {
	private long _id;
	private int _tipo;
	private QDateTime _fechaHora;
	private Paciente _paciente;
	private Derivador _derivador;
	private SistSalud _sistSalud;
	private int _nivelUrgencia;
	private RRFFs _rrff;
	private Funcionario _responsable;
	private boolean _asiste;
	private long _idCitacion;
	private String _observacion;
	private QDateTime _fhDigitacion;
	private String _usuario;
	private int _estadoRecepcion;
	private int _paraInformar;
	private long _infoAdicional;
	private List<RecepcionPrestaciones> _recepcionPrestaciones;
	
	public Recepcion(){
		super();
		this._recepcionPrestaciones = new ArrayList<RecepcionPrestaciones>();
	}
	
	public long getId() {
		return _id;
	}
	public void setId(long id) {
		this._id = id;
	}
	public int getTipo() {
		return _tipo;
	}
	public void setTipo(int tipo) {
		this._tipo = tipo;
	}
	public QDateTime getFechaHora() {
		return _fechaHora;
	}
	public void setFechaHora(QDateTime fechaHora) {
		this._fechaHora = fechaHora;
	}
	public Paciente getPaciente() {
		return _paciente;
	}
	public void setPaciente(Paciente paciente) {
		this._paciente = paciente;
	}
	public Derivador getDerivador() {
		return _derivador;
	}
	public void setDerivador(Derivador derivador) {
		this._derivador = derivador;
	}
	public SistSalud getSistemaSalud() {
		return _sistSalud;
	}
	public void setSistemaSalud(SistSalud sistSalud) {
		this._sistSalud = sistSalud;
	}
	public int getNivelUrgencia() {
		return _nivelUrgencia;
	}
	public void setNivelUrgencia(int nivelUrgencia) {
		this._nivelUrgencia = nivelUrgencia;
	}
	public RRFFs getRRFF() {
		return _rrff;
	}
	public void setRRFF(RRFFs rrff) {
		this._rrff = rrff;
	}
	public Funcionario getResponsable() {
		return _responsable;
	}
	public void setResponsable(Funcionario responsable) {
		this._responsable = responsable;
	}
	public boolean getAsiste() {
		return _asiste;
	}
	public void setAsiste(boolean asiste) {
		this._asiste = asiste;
	}
	public long getIDCitacion() {
		return _idCitacion;
	}
	public void setIDCitacion(long idCitacion) {
		this._idCitacion = idCitacion;
	}
	public String getObservacion() {
		return _observacion;
	}
	public void setObservacion(String observacion) {
		this._observacion = observacion;
	}
	public QDateTime getFHDigitacion() {
		return _fhDigitacion;
	}
	public void setFHDigitacion(QDateTime fhDigitacion) {
		this._fhDigitacion = fhDigitacion;
	}
	public String getUsuario() {
		return _usuario;
	}
	public void setUsuario(String usuario) {
		this._usuario = usuario;
	}
	public int getEstadoRecepcion() {
		return _estadoRecepcion;
	}
	public void setEstadoRecepcion(int estadoRecepcion) {
		this._estadoRecepcion = estadoRecepcion;
	}
	public int getParaInformar() {
		return _paraInformar;
	}
	public void setParaInformar(int paraInformar) {
		this._paraInformar = paraInformar;
	}
	public long getInfoAdicional() {
		return _infoAdicional;
	}
	public void setInfoAdicional(long infoAdicional) {
		this._infoAdicional = infoAdicional;
	}
	public List<RecepcionPrestaciones> getRecepcionPrestaciones() {
		return _recepcionPrestaciones;
	}
	public void setRecepcionPrestaciones(RecepcionPrestaciones recepcionPrestaciones) {
		this._recepcionPrestaciones.add(recepcionPrestaciones);
	}
	
	public boolean Insertar(){
		boolean result = true;
		Connection cnn = DBUtils.connectDB();
		try{
			cnn.setAutoCommit(false);
			this.setId(DBUtils.getLastIDRecepcion());
			String sql = String.format("INSERT INTO miniris.prestsol_enc (" +
										"eps_trec," +
										"eps_fhre," +
										"pac_id," +
										"deri_id," +
										"ssa_id," +
										"eps_nurg," +
										"rf_id," +
										"eps_ures," +
										"eps_obse," +
										"eps_user," +
										"eps_erec," +
										"eps_pinf," +
										"eps_info," +
										"eps_pasi," +
										"eps_id) " +
										"VALUES(%1$s, '%2$s', %3$s, %4$s, %5$s, %6$s, %7$s, %8$s, '%9$s', '%10$s', %11$s, %12$s, %13$s, %14$s, %15$s);",
										this.getTipo(),
										Timestamp.valueOf(this.getFechaHora().toString("yyyy-MM-dd HH:mm:ss")),
										this.getPaciente().getId(),
										this.getDerivador().getId(),
										this.getSistemaSalud().getId(),
										this.getNivelUrgencia(),
										this.getRRFF().getId(),
										this.getResponsable().getId(),
										this.getObservacion(),
										this.getUsuario(),
										this.getEstadoRecepcion(),
										this.getParaInformar(),
										this.getInfoAdicional(),
										this.getAsiste(),
										this.getId());
			//System.out.println(sql);
			result = DBUtils.executeNonQuery(sql);
			String FHToma = "0000-00-00 00:00:00";
			for(RecepcionPrestaciones rp : this._recepcionPrestaciones){
				if(rp.getFHToma().isValid()) FHToma = rp.getFHToma().toString("yyyy-MM-dd HH:mm:ss");
				if(rp.getEstado().equals("I")){
					sql = String.format("INSERT INTO miniris.prestsol_det VALUES(%1$s, '%2$s', %3$s, %4$s, %5$s, '%6$s');",
										this.getId(),
										rp.getPrestacion().getId(),
										rp.getCantidad(),
										rp.getResponsable().getId(),
										rp.getTomado(),
										Timestamp.valueOf(FHToma));
				}else if(rp.getEstado().equals("M"))
					sql = String.format("UPDATE miniris.prestsol_det SET dps_cant=%1$s, fun_id=%2$s, dps_toma=%3Ss, dps_fhto='%4$s' WHERE eps_id=%5$s AND prest_id='%6$s';", 
										rp.getCantidad(),
										rp.getResponsable().getId(),
										rp.getTomado(),
										Timestamp.valueOf(FHToma),
										this.getId(),
										rp.getPrestacion().getId());
				else
					sql = String.format("DELETE miniris.prestsol_det WHERE eps_id=%1$s AND prest_id='%2$s';", 
										this.getId(),
										rp.getPrestacion().getId());
				System.out.println(sql);
				DBUtils.executeNonQuery(sql);
			}
			cnn.commit();
		}catch(SQLException e) {
			try{
				cnn.rollback();
			}catch (SQLException ex) {
				ex.printStackTrace();
			}
			DBUtils.showSQLException(e);
		}
		return result;
	}
	public boolean Modificar(){
		String sql = String.format("UPDATE miniris.prestsol_enc SET eps_trec=%1$s, eps_fhre='%2$s', pac_id=%3$s, deri_id=%4$s, ssa_id=%5$s, eps_nurg=%6$s, rf_id=%7$s, eps_ures=%8$s, eps_obse='%9$s', eps_user='%10$s', eps_erec=%11$s, eps_pinf=%12$s, eps_info=%13$s, eps_pasi=%14$s WHERE eps_id=%15$s;",
									this.getTipo(),
									Timestamp.valueOf(this.getFechaHora().toString("yyyy-MM-dd HH:mm:ss")),
									this.getPaciente().getId(),
									this.getDerivador().getId(),
									this.getSistemaSalud().getId(),
									this.getNivelUrgencia(),
									this.getRRFF().getId(),
									this.getResponsable().getId(),
									this.getObservacion(),
									this.getUsuario(),
									this.getEstadoRecepcion(),
									this.getParaInformar(),
									this.getInfoAdicional(),
									this.getAsiste(),
									this.getId());
		System.out.println(sql);
		//AGREGAR CODIGO PARA GUARDAR LAS PRESTACIONES DE LA RECEPCION
		return DBUtils.executeNonQuery(sql);
	}
	public boolean Eliminar(){
		String sql = String.format("DELETE FROM miniris.prestsol_enc WHERE eps_id=%1$s;",this.getId());
		return DBUtils.executeNonQuery(sql);
	}
}
