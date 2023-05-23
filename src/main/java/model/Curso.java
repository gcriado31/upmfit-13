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
	public ArrayList<Sesiones> sesiones;
	// Estas dos variables de abajo son las que subimos de la clase sesión
	private int numPersonasMax;
	private int numPersonasApuntadas; 
	
	//CONSTRUCTOR 
	public Curso(String idCurso, String nombreCurso, int numPersonasMax, int numSesiones) {
		//TODO COMPLETAR CONSTRUCTOR
		this.idCurso=idCurso;
		this.nombreCurso=nombreCurso;
		this.numPersonasMax=numPersonasMax;
		this.sesiones=new ArrayList<>(numSesiones);
		this.numPersonasApuntadas=0;
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

	public int getNumPersonasMax(){
		return numPersonasMax;
	}

	public void setNumPersonasMax(int numPersonasMax){
		this.numPersonasMax=numPersonasMax;
	}
	
	// METODOS
	public void apuntarCliente(){
		this.numPersonasApuntadas++;
	}
	
	
}
