package com.eims.ris.core;

public abstract class Persona{
	/**
	 * @uml.property  name="_Nombre"
	 */
	private String _Nombre;
	/**
	 * @uml.property  name="_APaterno"
	 */
	private String _APaterno;
	/**
	 * @uml.property  name="_AMaterno"
	 */
	private String _AMaterno;

	public String getNombre(){
		return _Nombre;
	}
	public void setNombre(String nombre){
		this._Nombre = nombre;
	}
	public String getAPaterno(){
		return _APaterno;
	}
	public void setAPaterno(String apaterno){
		this._APaterno = apaterno;
	}
	public String getAMaterno(){
		return _AMaterno;
	}
	public void setAMaterno(String amaterno){
		this._AMaterno = amaterno;
	}
}
