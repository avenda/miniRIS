package com.eims.ris.core;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Modalidad extends BasicTable {
	private String _host;
	private String _aeTitle;
	private int _port;
	
	public String getHost() {
		return _host;
	}

	public void setHost(String _host) {
		this._host = _host;
	}

	public String getAETitle() {
		return _aeTitle;
	}

	public void setAETitle(String _aeTitle) {
		this._aeTitle = _aeTitle;
	}

	public int getPort() {
		return _port;
	}

	public void setPort(int _port) {
		this._port = _port;
	}

	public boolean setModalidad(int ID){
		ResultSet rs = DBUtils.getResultSet(String.format("SELECT par_info FROM miniris.parametros WHERE par_grupo='MD' AND par_id=%1$s", ID));
		try{
	    	if(rs.next()){
	    		this.setId(ID);
	    		this.setDescripcion(rs.getString("par_info"));
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
}
