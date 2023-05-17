package model;

import java.util.*;

/**
 * 
 * Clase de que representa a los cursos.
 *
 */

public class Curso implements ICurso{
	
	//ATRIBUTOS
	private String idCurso;
	private String nombreCurso;
	public LinkedList<Sesiones> sesiones;
	// Estas dos variables de abajo son las que subimos de la clase sesión
	private int numPersonasMax;
	private int numPersonasApuntadas; 
	
	//CONSTRUCTOR 
	public Curso() {
		//TODO COMPLETAR CONSTRUCTOR
	}
	
	//SETTERS Y GETTERS
	public String getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(String idCurso) {
		this.idCurso = idCurso;
	}
	public String getNombreCurso() {
		return nombreCurso;
	}
	public void setNombreCurso(String nombreCurso) {
		this.nombreCurso = nombreCurso;
	}
	
	
	
	
}
