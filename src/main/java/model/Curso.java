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
	protected ArrayList<Cliente> listaClientes;
	private int numPersonasMax;
	private int numPersonasApuntadas;
	private Monitores monitor; 
	
	//CONSTRUCTOR 
	public Curso(String idCurso, String nombreCurso, int numPersonasMax, int numSesiones, Monitores monitor) {
		//TODO COMPLETAR CONSTRUCTOR
		this.idCurso=idCurso;
		this.nombreCurso=nombreCurso;
		this.numPersonasMax=numPersonasMax;
		this.sesiones=new ArrayList<>(numSesiones);
		this.listaClientes=new ArrayList<>(numPersonasMax);
		this.numPersonasApuntadas=0;
		this.monitor=monitor;
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

	public Monitores getMonitor(){
		return monitor;
	}
	
	public void setSesiones(ArrayList<Sesiones> sesiones){
		this.sesiones=sesiones;
	}

	public int getNumPersonasApuntadas() {
		return numPersonasApuntadas;
	}
	// METODOS
	public void apuntarCliente(Cliente cliente){
		this.numPersonasApuntadas++;
		listaClientes.add(cliente);
	}	
	
}
