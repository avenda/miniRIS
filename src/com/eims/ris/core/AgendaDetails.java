/**
 * Proyecto		: eHC.RIS (parte del proyecto EIMS)
 * Clase		: AgendaDetails.java
 * Fecha		: 2011.11.01
 * Uso			: Clase que permite gestionar el detalle de las plantillas de las agendas generadas en el sistema
 * Dependencias	: 
 * 					Funcionarios
 * 					RR.FF.
 */

package com.eims.ris.core;

public class AgendaDetails {
	/**
	 * @uml.property  name="_lun"
	 */
	private String _lun;
	/**
	 * @uml.property  name="_mar"
	 */
	private String _mar;
	/**
	 * @uml.property  name="_mie"
	 */
	private String _mie;
	/**
	 * @uml.property  name="_jue"
	 */
	private String _jue;
	/**
	 * @uml.property  name="_vie"
	 */
	private String _vie;
	/**
	 * @uml.property  name="_sab"
	 */
	private String _sab;
	/**
	 * @uml.property  name="_dom"
	 */
	private String _dom;
	/**
	 * @uml.property  name="_defaultValue"
	 */
	private String _defaultValue = "";
	
	public AgendaDetails() {
		this._lun = this._defaultValue;
		this._mar = this._defaultValue;
		this._mie = this._defaultValue;
		this._jue = this._defaultValue;
		this._vie = this._defaultValue;
		this._sab = this._defaultValue;
		this._dom = this._defaultValue;
	}
	
	public String getLunes() {
		return this._lun;
	}
	public void setLunes(String lun) {
		this._lun = lun;
	}
	public String getMartes() {
		return this._mar;
	}
	public void setMartes(String mar) {
		this._mar = mar;
	}
	public String getMiercoles() {
		return this._mie;
	}
	public void setMiercoles(String mie) {
		this._mie = mie;
	}
	public String getJueves() {
		return this._jue;
	}
	public void setJueves(String jue) {
		this._jue = jue;
	}
	public String getViernes() {
		return this._vie;
	}
	public void setViernes(String vie) {
		this._vie = vie;
	}
	public String getSabado() {
		return this._sab;
	}
	public void setSabado(String sab) {
		this._sab = sab;
	}
	public String getDomingo() {
		return this._dom;
	}
	public void setDomingo(String dom) {
		this._dom = dom;
	}
}
