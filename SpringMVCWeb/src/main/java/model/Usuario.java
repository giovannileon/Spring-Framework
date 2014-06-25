package model;

public class Usuario {

	private Integer idUsuario;
	private String username;
	private String password;
	
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", username=" + username
				+ ", password=" + password + "]";
	}
	
	
}
