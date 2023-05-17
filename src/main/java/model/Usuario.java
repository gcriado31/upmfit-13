package model;

/**
 * 
 * Clase usuario representa a cualquier usuario del sistema. Es el padre de todas las clases de tipo usuario.
 *
 */
public abstract class Usuario { //TODO ¿PORQUÉ ABSTRACTA?
	
	//ATRIBUTOS
	protected String contraseña;
	protected String correo;
	protected String dni;
	protected String nombreCompleto;
	protected String nombreUsuario;
	
	
	//CONSTRUCTOR
	public Usuario(String contraseña, String correo, String dni, String nombreCompleto, String nombreUsuario) {
		this.contraseña = contraseña;
		this.correo = correo;
		this.dni = dni;
		this.nombreCompleto = nombreCompleto;
		this.nombreUsuario = nombreUsuario;
	}

	//SETTERS Y GETTERS
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	

}
