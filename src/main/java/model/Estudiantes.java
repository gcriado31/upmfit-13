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
	public Estudiantes(int edad, int fechaCaducidad, int peso, String sexo, String contraseña, String correo,
			String dni, String nombreCompleto, String nombreUsuario, String numeroMatricula) {
		super(edad, fechaCaducidad, peso, sexo, contraseña, correo, dni, nombreCompleto, nombreUsuario);
		this.numeroMatricula = numeroMatricula;
	}
	
	//TODO ¿SETTERS Y GETTERS?
	

	
	

}
