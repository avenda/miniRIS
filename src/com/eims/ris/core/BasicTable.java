package com.eims.ris.core;

public abstract class BasicTable{
	/**
	 * @uml.property  name="_Id"
	 */
	private int _Id;
	/**
	 * @uml.property  name="_Descripcion"
	 */
	private String _Descripcion;
	
	BasicTable(){
		this._Id = 0;
	}
	
	public int getId(){
		return _Id;
	}
	public void setId(int id){
		this._Id = id;
	}
	public String getDescripcion(){
		return _Descripcion;
	}
	public void setDescripcion(String descripcion){
		this._Descripcion = descripcion;
	}
}
