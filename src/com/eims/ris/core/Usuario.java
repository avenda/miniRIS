package com.eims.ris.core;

public class Usuario{
	/**
	 * @uml.property  name="_Id"
	 */
	private int _Id;
	/**
	 * @uml.property  name="_Account"
	 */
	private String _Account;
	/**
	 * @uml.property  name="_Password"
	 */
	private String _Password;
	/**
	 * @uml.property  name="_Nombres"
	 */
	private String _Nombres;
	/**
	 * @uml.property  name="_APaterno"
	 */
	private String _APaterno;
	/**
	 * @uml.property  name="_AMaterno"
	 */
	private String _AMaterno;
	/**
	 * @uml.property  name="_Descripcion"
	 */
	private String _Descripcion;
	/**
	 * @uml.property  name="_FechaUltAcceso"
	 */
	private String _FechaUltAcceso;
	/**
	 * @uml.property  name="_Tipo"
	 */
	private int _Tipo;
	/**
	 * @uml.property  name="_Vigente"
	 */
	private boolean _Vigente;
	
	/* Métodos Getter & Setter para obtener y establecer los atributos */
	public int getId() {
		return _Id;
	}
	public void setId(int id) {
		this._Id = id;
	}
	public String getAccount() {
		return _Account;
	}
	public void setAccount(String account) {
		this._Account = account;
	}
	public String getPassword() {
		return _Password;
	}
	public void setPassword(String password) {
		this._Password = password;
	}
	public String getNombres() {
		return _Nombres;
	}
	public void setNombres(String nombres) {
		this._Nombres = nombres;
	}
	public String getAPaterno() {
		return _APaterno;
	}
	public void setAPaterno(String apaterno) {
		this._APaterno = apaterno;
	}
	public String getAMaterno() {
		return _AMaterno;
	}
	public void setAMaterno(String amaterno) {
		this._AMaterno = amaterno;
	}
	public String getDescripcion() {
		return _Descripcion;
	}
	public void setDescripcion(String descripcion) {
		this._Descripcion = descripcion;
	}
	public String getFechaUltAcceso() {
		return _FechaUltAcceso;
	}
	public void setFechaUltAcceso(String fechaultacceso) {
		this._FechaUltAcceso = fechaultacceso;
	}
	public int getTipo() {
		return _Tipo;
	}
	public void setTipo(int tipo) {
		this._Tipo = tipo;
	}
	public boolean isVigente() {
		return _Vigente;
	}
	public void setVigente(boolean vigente) {
		this._Vigente = vigente;
	}
	
	public boolean Insertar(){
		//Connection cnn = DBUtils.connectDB();
		String sql = String.format("INSERT INTO miniris.usuarios (usu_acco,usu_pass,usu_nomb,usu_apat,usu_amat,usu_desc,usu_tipo,usu_vige) VALUES('%1$s', '%2$s', '%3$s', '%4$s', '%5$s', '%6$s', %7$s, %8$s);", this._Account, this._Password, this._Nombres, this._APaterno, this._AMaterno, this._Descripcion, this._Tipo, this._Vigente);
		return DBUtils.executeNonQuery(sql);
		/*try{
			PreparedStatement ps = cnn.prepareStatement(sql);
			ps.execute();
			//cnn.commit();  
			ps.close();
			cnn.close();
			return true;
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}*/
	}
	public boolean Modificar(){
		//Connection cnn = DBUtils.connectDB();
		String sql = String.format("UPDATE miniris.usuarios SET usu_nomb='%1$s', usu_apat='%2$s', usu_amat='%3$s', usu_desc='%4$s', usu_tipo=%5$s, usu_vige=%6$s WHERE usu_id=%7$s", this._Nombres, this._APaterno, this._AMaterno, this._Descripcion, this._Tipo, this._Vigente, this._Id);
		return DBUtils.executeNonQuery(sql);
		/*System.out.print(sql);
		try{
			PreparedStatement ps = cnn.prepareStatement(sql);
			ps.execute();
			//cnn.commit();
			ps.close();
			cnn.close();
			return true;
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}*/
	}
	public boolean Eliminar(){
		//Connection cnn = DBUtils.connectDB();
		String sql = String.format("DELETE FROM miniris.usuarios WHERE usu_id=%1$i;", this._Id);
		return DBUtils.executeNonQuery(sql);
		/*try{
			PreparedStatement ps = cnn.prepareStatement(sql);
			ps.execute();
			//cnn.commit();
			ps.close();
			cnn.close();
			return true;
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}*/
	}
	/*private boolean Actualizar(){
		Connection cnn = DBUtils.connectDB();
		String sql = "{call miniRIS.FN_SAVE_SISTSALUD(?,?,?)}";
		//System.out.print("ID: "+this.getId()+" - Desc: "+this.getDescripcion()+" - Vige: "+this.isVigente());
		try{
			//PreparedStatement ps = cnn.prepareCall(sql);
			CallableStatement cs = cnn.prepareCall(sql);
			cs.setInt("id", this.getId());
			cs.setString("descripcion", this.getDescripcion());
			cs.setBoolean("vigente", this.isVigente());
			cs.execute();
			cs.close();
			cnn.close();
			return true;
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}*/
}