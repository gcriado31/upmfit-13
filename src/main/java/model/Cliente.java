package model;
import java.util.*;

import model.excepciones.*;
import utilidades.*;
/**
 * 
 * Clase del usuario, nos valdrá para usuarios externos a la UPM, será padre de los internos UPM y de los monitores
 *
 */
public class Cliente extends Usuario implements ICliente{
	
	// ATRIBUTOS 
	protected int edad;
	protected int peso;
	protected Sexo sexo;
	protected LinkedList<Curso> cursos;

	
	// CONSTRUCTOR
	public Cliente(int edad, int peso, Sexo sexo, String contraseña, String correo, String dni, String nombreCompleto, String nombreUsuario) 
	throws IncorrectPasswordFormatException, IncorrectDniFormatException, IncorrectAgeException, IncorrecWeightException, IncorrectNameException, IncorrectNicknameFormatException, IncorrectEmailFormatExcpetion {

		super(Checker.checkContraseña(contraseña),Checker.checkEmail(correo),Checker.checkDNI(dni),Checker.checkName(nombreCompleto),Checker.checkNickname(nombreUsuario));
		this.edad = Checker.checkEdad(edad);
		this.peso = Checker.checkPeso(peso)	;
		this.sexo = sexo;
		this.cursos=new LinkedList();
	}
	
	// SETTERS Y GETTERS
	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public String toStringSimple(){
		return " Nombre: " + this.nombreCompleto + "\n" +
		"Nombre Usuario: " + this.nombreUsuario + "\n" +
		"Contraseña: " + this.contraseña + "\n" +
		"Correo: " + this.correo + "\n" +
		"DNI: " + this.dni + "\n" ;
	}

	public String toStringCompleto(){
		return " Nombre: " + this.nombreCompleto + "\n" +
		"Nombre Usuario: " + this.nombreUsuario + "\n" +
		"Contraseña: " + this.contraseña + "\n" +
		"Correo: " + this.correo + "\n" +
		"DNI: " + this.dni + "\n" +
		"Edad: " + this.edad + "\n" +
		"Peso: " + this.peso + "\n" +
		"Sexo: " + this.sexo + "\n";
	}

}
