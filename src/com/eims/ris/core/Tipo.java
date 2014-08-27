package com.eims.ris.core;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Tipo extends BasicTable{
	public boolean setTipo(int ID){
		ResultSet rs = DBUtils.getResultSet(String.format("SELECT par_desc FROM miniris.parametros WHERE par_grupo='TD' AND par_id=%1$s", ID));
		try{
	    	if(rs.next()){
	    		this.setId(ID);
	    		this.setDescripcion(rs.getString("par_desc"));
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
