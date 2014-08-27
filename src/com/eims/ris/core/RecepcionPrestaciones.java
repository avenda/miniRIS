package com.eims.ris.core;

import com.trolltech.qt.core.QDateTime;

public class RecepcionPrestaciones {
	private Prestacion _prestacion;
	private int _cantidad;
	private Funcionario _responsable;
	private boolean _tomado;
	private QDateTime _fhToma;
	private String _estado;
	
	public Prestacion getPrestacion() {
		return _prestacion;
	}
	public void setPrestacion(Prestacion prestacion) {
		this._prestacion = prestacion;
	}
	public int getCantidad() {
		return _cantidad;
	}
	public void setCantidad(int cantidad) {
		this._cantidad = cantidad;
	}
	public Funcionario getResponsable() {
		return _responsable;
	}
	public void setResponsable(Funcionario responsable) {
		this._responsable = responsable;
	}
	public boolean getTomado() {
		return _tomado;
	}
	public void setTomado(boolean tomado) {
		this._tomado = tomado;
	}
	public QDateTime getFHToma() {
		return _fhToma;
	}
	public void setFHToma(QDateTime fhToma) {
		this._fhToma = fhToma;
	}
	public String getEstado() {
		return _estado;
	}
	public void setEstado(String estado) {
		this._estado = estado;
	}
	
}
