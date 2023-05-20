package model;
/**
 * 
 * Clase de los estudiantes de la UPM. Hereda de la clase Cliente 
 *
 */
public class Estudiantes extends Cliente {
	
	//ATRIBUTOS
	private static final int DESCUENTO_ESTUDIANTE=50; //TODO Valorar cambio a float
	private String numeroMatricula;
	
	//CONSTRUCTOR
	public Estudiantes(int edad, int fechaCaducidad, int peso, Sexo sexo, String contraseña, String correo,
			String dni, String nombreCompleto, String nombreUsuario, String numeroMatricula) {
		super(edad, fechaCaducidad, peso, sexo, contraseña, correo, dni, nombreCompleto, nombreUsuario);
		this.numeroMatricula = numeroMatricula;
	}
	
	//SETTERS Y GETTERS
	public String getNumeroMatricula() {
		return numeroMatricula;
	}

	public void setNumeroMatricula(String numeroMatricula) {
		this.numeroMatricula = numeroMatricula;
	}

	public static int getDescuentoEstudiante() {
		return DESCUENTO_ESTUDIANTE;
	}
	

	
	

}
