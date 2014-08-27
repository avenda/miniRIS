package com.eims.ris.core;

/*import com.trolltech.qt.sql.QJdbc;
import com.trolltech.qt.sql.QSqlDatabase;
import com.trolltech.qt.sql.QSqlQuery;*/

import com.trolltech.qt.core.QByteArray;
import com.trolltech.qt.core.QCryptographicHash;
import com.trolltech.qt.core.QDate;
import com.trolltech.qt.gui.QComboBox;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Properties;



/**
 * Clase proveedora de utilidades para manipulación de base de datos
 */
public class DBUtils{
	/**
	 * Método para establecer la conexión con BD PostgreSQL
	 * @return un objeto de tipo Connection
	 */
	private static String _CNNstring;
	private static String server;
	
	public static Connection getConnection(){
		Connection cnn = null;
		try{
			cnn = DriverManager.getConnection(_CNNstring, "userRIS", "userRIS");
		}catch (SQLException e) {
			showSQLException(e);
		}
		return cnn;
	}
	
	public static Connection connectDB(){
		final String DRIVER = "org.postgresql.Driver";
		//_CNNstring = String.format("jdbc:postgresql://%1$s/dbRIS?ssl=true&sslfactory=org.postgresl.ssl.NonValidatingFactory", getServer());
		_CNNstring = String.format("jdbc:postgresql://%1$s/dbRIS", getServer());
        try{
        	Class.forName(DRIVER).newInstance();
        }catch(Exception ex){
        	return null;
        }
        Connection cnn = getConnection();
        return cnn;
		/*java.security.Security.addProvider(new org.metastatic.jessie.provider.Jessie()); 

		Class.forName("org.postgresql.Driver"); 
		String url = "jdbc:postgresql://server/database"; 
		Properties props = new Properties(); 
		props.setProperty("user","na"); 
		props.setProperty("password","na"); 
		props.setProperty("ssl","true"); 
		props.setProperty("sslfactory", "org.postgresql.ssl.NonValidatingFactory"); 
		Connection conn = DriverManager.getConnection(url, props); 
		return conn;*/
    }
	
	/*public static boolean connectDB(){
		QJdbc.initialize();
		QSqlDatabase db = QSqlDatabase.addDatabase("QJDBC");
		//db.setDatabaseName("jdbc:postgresql://localhost:5432/dbRIS?schema=RIS");
		db.setDatabaseName("jdbc:postgresql://localhost:5433/dbRIS");
		
		db.setUserName("ris");
		db.setPassword("ris");
		if (db.open()) {
			System.out.println("Conectado!");
			QSqlQuery query = new QSqlQuery("SELECT * FROM miniris.usuarios;");
			//if(query.isValid())
			if(query.next())
				System.out.println("Query OK!");
			else{
				System.out.println("Query cueck!");
				System.out.println(query.lastError().text());
			}
		}else{
			System.out.println("Error al conectar: " + db.lastError().text());
			return false;
		}
		return true;
	}*/
	
	/**
	 * Método para verificar el acceso del usuario
	 * @param userName : string con el ID del usuario
	 * @param pwd : string con la contraseña del usuario
	 * @return valor booleano con resultado de la verificación
	 */
	public static boolean verificaLogin(String userName, String pwd){
		boolean login = false;
		Connection cnn = connectDB();
		System.out.println("cnx: " +cnn);
		if(cnn != null){
			String sql = String.format("SELECT usu_id FROM miniris.usuarios WHERE usu_acco='%1$s' AND usu_pass='%2$s' AND usu_vige=TRUE", userName, pwd);
			System.out.println(sql);
			try{
	        	PreparedStatement s = cnn.prepareStatement(sql);
	        	ResultSet rs = s.executeQuery();
	        	if(rs.next()) login = true;
	        }catch(SQLException e){
	        	showSQLException(e);
	        	login = false;
	        }
		}else{
			System.out.println("No hay conexion al server, verificar driver");
			login = false;
		}
		return login;
	}
	
	/**
	 * Método para realizar encriptación por el método MD5
	 * @param strToEncrypt : string a encriptar
	 * @return un string encriptado en formato MD5
	 */
	public static String encryptMD5(String strToEncrypt){
		QByteArray hash = QCryptographicHash.hash(new QByteArray(strToEncrypt), QCryptographicHash.Algorithm.Md5);
		return String.format("%1$s", hash.toHex());
	}
	
	/**
	 * Método para ejecutar una consulta con devolución de un conjunto de registros
	 * @param sql : string con la consulta
	 * @return un ResultSet con el conjunto de registros de la consulta
	 */
	public static ResultSet getResultSet(String sql){
		Connection cnn = DBUtils.connectDB();
		try{
			//PreparedStatement ps = cnn.prepareStatement(sql);
			Statement stmt = cnn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);//, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmt.executeQuery(sql);
			cnn.close();
			return rs;
		}catch(SQLException e){
			showSQLException(e);
			return null;
		}/*finally{
			ps.close();
			cnn.close();
		}*/
	}
	/**
	 * Método para ejecutar un query sin devolución de registros
	 * @param sql : string con la consulta
	 * @return valor booleano con éxito de la consulta
	 */
	public static boolean executeNonQuery(String sql){
		Connection cnn = DBUtils.connectDB();
		try{
			PreparedStatement ps = cnn.prepareStatement(sql);
			ps.execute();
			cnn.close();
			return true;
		}catch(SQLException e){
			showSQLException(e);
			return false;
		}
	}
	
	public static String getTableField(String sql){
		String result = "";
		try{
		    ResultSet query = getResultSet(sql);
		    query.next();
		    //System.out.println(query.getString(1));
		    result = query.getString(1) == null ? "" : query.getString(1);
		}catch (SQLException e) {
			showSQLException(e);
		}
		return result;
	}
	/**
	 * Método estático para cargar un QComboBox, el orden de los campos en el sql es:
	 * Identificador y luego la Descripción
	 * @return void el QComboBox es pasado por valor
	 */
	public static void loadComboBox(QComboBox cbox, String sql)
	{
		int row = 0;
	    cbox.clear();
	    try{
	    	ResultSet query = DBUtils.getResultSet(sql);
	    	//Object obj = null;
	    	while(query.next()){
	    		cbox.addItem(query.getString(2).trim());
	    		//obj = query.getObject(1);
	    		//if(obj instanceof java.lang.String)
	    			cbox.setItemData(row++,query.getString(1).trim());
	    		//else
	    			//cbox.setItemData(row++,query.getInt(1));
		    }
	    	cbox.setCurrentIndex(-1);
	    }catch (SQLException e){
	    	e.printStackTrace();
	    	DBUtils.showSQLException(e);
	    }
	}
	/**
	 * Método que obtiene la edad actual del paciente
	 * @param fNac OBjeto de tipo QDate
	 * @return Objeto de Tipo String
	 */
	public static String ObtenerEdad(QDate fNac)
	{
		Connection cnn = connectDB();
		String sql = String.format("SELECT NOW()");
		try{
			
			PreparedStatement ps = cnn.prepareStatement(sql);
			ps.execute();
		    ResultSet rs = ps.executeQuery();
		    rs.next();
		    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		    QDate fActual = QDate.fromString(sdf.format(rs.getDate("now")).toString());
		    int dias = -(fNac.daysTo(fActual));
		    int a, m, d;
		    a = m = d = 0;
		    if(dias > 0){
		        if(dias>365) a = dias / 365;
		        m = (dias % 365) / 3;
		        d = fActual.day();
		        if(d>=fNac.day())
		            d -= fNac.day();
		        else{
		            d = fActual.daysInMonth() - (fNac.day() - d);
		            
		            if(m>0) m--;
		        }
		    }
		    return String.format(a+" "+m+" "+d);    
		}
		catch(SQLException e){
			e.printStackTrace();
			return "falla";
		}
	}
	public static int getNumRows(ResultSet query){
		int numRows = 0;
		try{
			if(query.last()) numRows = query.getRow();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return numRows;
	}
	
	public static long getLastIDRecepcion(){
	    try{
		    ResultSet query = DBUtils.getResultSet("SELECT TO_CHAR(NOW(),'YYMM');");
		    query.next();
		    String lID = query.getString(1)+"000000";
		    query = DBUtils.getResultSet("SELECT MAX(eps_id) FROM miniris.prestsol_enc;");
		    if(query.next()){
		        if(Integer.parseInt(lID) < query.getInt(1))
		            return query.getInt(1) + 1;
		    }
		    return (Integer.parseInt(lID) + 1);
	    }catch (SQLException e) {
			DBUtils.showSQLException(e);
		}
	    return -1;
	}
	
	public static void showSQLException(SQLException e){
		System.out.println(e);
		Utils.MessageBox(Enumeradores.Message.Error, e.getMessage());
	}

	public static String getServer() {
		return server;
	}

	public static void setServer(String server) {
		DBUtils.server = server;
	}
}