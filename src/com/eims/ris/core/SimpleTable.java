package com.eims.ris.core;

public abstract class SimpleTable extends BasicTable {
	/**
	 * @uml.property  name="_Vigente"
	 */
	private boolean _Vigente;
	
	SimpleTable(){
		super();
	}
	
	public boolean isVigente() {
		return _Vigente;
	}
	public void setVigente(boolean vigente){
		this._Vigente = vigente;
	}
}
