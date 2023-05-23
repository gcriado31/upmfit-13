package model;

/**
 * 
 * Clase de las sesiones. Pueden componer un curso o una individual.
 *
 */
public class Sesiones {
	
	//ATRIBUTOS
	private Actividad actividades;
	private String horaFinal; 
	private String horaIncio;
	private String idSesiones;

	//CONSTRUCTOR
	public Sesiones(Actividad actividades, String horaIncio, String horaFinal, String idSesiones){
		//TODO COMPLETAR CONSTRUCTOR
		this.actividades=actividades;
		this.horaIncio=horaIncio;
		this.horaFinal=horaFinal;
		this.idSesiones=idSesiones;
	}

	// TODO ¿SETTERS Y GETTERS?
	
	//MÉTODOS
	public void finalize() throws Throwable {
		//TODO COMPLETAR METODO
	}
	
	//TODO ¿MÉTODO INCREMENTAR NUMERO PERSONAS?

}
