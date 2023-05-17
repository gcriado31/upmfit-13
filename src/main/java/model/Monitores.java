package model;

import java.util.*;

/**
 * 
 * Clase de los monitores. Hereda del usuario.
 *
 */
public class Monitores extends Usuario {
	
	//ATRIBUTOS
	private int numeroCuenta; //TODO ¿Long? o ¿String?
	public LinkedList<Curso> m_Curso;
	
	//CONSTRUCTORES
	public Monitores(String contraseña, String correo, String dni, String nombreCompleto, String nombreUsuario,
			int numeroCuenta, LinkedList<Curso> m_Curso) {
		super(contraseña, correo, dni, nombreCompleto, nombreUsuario);
		this.numeroCuenta = numeroCuenta;
		this.m_Curso = m_Curso;
	}

	//TODO ¿SETTERS Y GETTERS?

	//TODO METODOS AÑADIR CURSO Y MÁS 

}
