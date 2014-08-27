package com.eims.ris.core;

import java.util.Date;

public class CitacionDetails {
	/**
	 * @uml.property  name="epsId"
	 */
	private int epsId;
	/**
	 * @uml.property  name="prestId"
	 */
	private String prestId;
	/**
	 * @uml.property  name="dpsCant"
	 */
	private int dpsCant;
	/**
	 * @uml.property  name="funId"
	 */
	private int funId;
	/**
	 * @uml.property  name="dpsToma"
	 */
	private boolean dpsToma;
	/**
	 * @uml.property  name="dpsFhto"
	 */
	private Date dpsFhto;
	
	/**
	 * @return
	 * @uml.property  name="epsId"
	 */
	public int getEpsId() {
		return epsId;
	}
	/**
	 * @param epsId
	 * @uml.property  name="epsId"
	 */
	public void setEpsId(int epsId) {
		this.epsId = epsId;
	}
	/**
	 * @return
	 * @uml.property  name="prestId"
	 */
	public String getPrestId() {
		return prestId;
	}
	/**
	 * @param prestId
	 * @uml.property  name="prestId"
	 */
	public void setPrestId(String prestId) {
		this.prestId = prestId;
	}
	/**
	 * @return
	 * @uml.property  name="dpsCant"
	 */
	public int getDpsCant() {
		return dpsCant;
	}
	/**
	 * @param dpsCant
	 * @uml.property  name="dpsCant"
	 */
	public void setDpsCant(int dpsCant) {
		this.dpsCant = dpsCant;
	}
	/**
	 * @return
	 * @uml.property  name="funId"
	 */
	public int getFunId() {
		return funId;
	}
	/**
	 * @param funId
	 * @uml.property  name="funId"
	 */
	public void setFunId(int funId) {
		this.funId = funId;
	}
	/**
	 * @return
	 * @uml.property  name="dpsToma"
	 */
	public boolean isDpsToma() {
		return dpsToma;
	}
	/**
	 * @param dpsToma
	 * @uml.property  name="dpsToma"
	 */
	public void setDpsToma(boolean dpsToma) {
		this.dpsToma = dpsToma;
	}
	/**
	 * @return
	 * @uml.property  name="dpsFhto"
	 */
	public Date getDpsFhto() {
		return dpsFhto;
	}
	/**
	 * @param dpsFhto
	 * @uml.property  name="dpsFhto"
	 */
	public void setDpsFhto(Date dpsFhto) {
		this.dpsFhto = dpsFhto;
	}
}
