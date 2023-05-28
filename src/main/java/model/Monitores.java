package model;

import java.util.*;

/**
 * 
 * Clase de los monitores. Hereda del usuario.
 *
 */
public class Monitores extends Usuario {
	
	//ATRIBUTOS
	public LinkedList<Curso> m_Curso;
	
	//CONSTRUCTORES
	public Monitores(String contraseña, String correo, String dni, String nombreCompleto, String nombreUsuario) {
		super(contraseña, correo, dni, nombreCompleto, nombreUsuario);
		this.m_Curso = new LinkedList<>();
	}

	//SETTERS Y GETTERS

	public LinkedList<Curso> getM_Curso() {
		return m_Curso;
	}

	public void setM_Curso(LinkedList<Curso> m_Curso) {
		this.m_Curso = m_Curso;
	}


}
