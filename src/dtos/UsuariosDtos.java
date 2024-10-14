package dtos;

/**
 * Clase que contendra todos los atributos que compondran a un usuario.
 * @author dmn 101024
 */

public class UsuariosDtos {

	long id_usuarios;
	
	String apellidos_usuarioString = "aaaaa";

	String dni_usuario = "aaaaa";

	String telefono_usuario ;

	String email_usuario = "aaaaa";
	
	String nombre_usuarioString = "aaaaa";
	
	public UsuariosDtos(long id_usuarios, String nombre_usuarioString, String apellidos_usuarioString, String dni_usuario,
			String telefono_usuario, String email_usuario) {
		super();
		this.id_usuarios = id_usuarios;
		this.nombre_usuarioString = nombre_usuarioString;
		this.apellidos_usuarioString = apellidos_usuarioString;
		this.dni_usuario = dni_usuario;
		this.telefono_usuario = telefono_usuario;
		this.email_usuario = email_usuario;
	}


	
	public UsuariosDtos() {
		super();
	}
	

	public long getId_usuarios() {
		return id_usuarios;
	}



	public void setId_usuarios(long id_usuarios) {
		this.id_usuarios = id_usuarios;
	}



	public String getApellidos_usuarioString() {
		return apellidos_usuarioString;
	}



	public void setApellidos_usuarioString(String apellidos_usuarioString) {
		this.apellidos_usuarioString = apellidos_usuarioString;
	}



	public String getDni_usuario() {
		return dni_usuario;
	}



	public void setDni_usuario(String dni_usuario) {
		this.dni_usuario = dni_usuario;
	}



	public String getTelefono_usuario() {
		return telefono_usuario;
	}



	public void setTelefono_usuario(String telefono_usuario) {
		this.telefono_usuario = telefono_usuario;
	}



	public String getEmail_usuario() {
		return email_usuario;
	}



	public void setEmail_usuario(String email_usuario) {
		this.email_usuario = email_usuario;
	}



	public String getNombre_usuarioString() {
		return nombre_usuarioString;
	}



	public void setNombre_usuarioString(String nombre_usuarioString) {
		this.nombre_usuarioString = nombre_usuarioString;
	}

}
