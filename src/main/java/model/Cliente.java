package model;
import java.util.*;
import utilidades.*;
/**
 * 
 * Clase del usuario, nos valdrá para usuarios externos a la UPM, será padre de los internos UPM y de los monitores
 *
 */
public class Cliente extends Usuario implements ICliente{
	
	// ATRIBUTOS 
	protected int edad;
	protected int fechaCaducidad;
	protected int peso;
	protected Sexo sexo;
	public LinkedList<Curso> cursos;

	
	// CONSTRUCTOR
	public Cliente(int edad, int fechaCaducidad, int peso, Sexo sexo, String contraseña, String correo, String dni, String nombreCompleto, String nombreUsuario) {
		super(Cifrado.cifrar(contraseña),correo,dni,nombreCompleto,nombreUsuario);
		this.edad = edad;
		this.fechaCaducidad = fechaCaducidad;
		this.peso = peso;
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

	public int getFechaCaducidad() {
		return fechaCaducidad;
	}

	public void setFechaCaducidad(int fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
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

	public String toStringSimple(Cliente cliente){
		return " Nombre: " + cliente.nombreCompleto + 
		", Nombre Usuario: " + cliente.nombreUsuario + 
		", Contraseña: " + cliente.contraseña + 
		", Correo: " + cliente.correo + 
		", DNI: " + cliente.dni + "\n";
	}

	public String toString(Cliente cliente){
		return " Nombre: " + cliente.nombreCompleto + 
		", Nombre Usuario: " + cliente.nombreUsuario + 
		", Contraseña: " + cliente.contraseña + 
		", Correo: " + cliente.correo + 
		", DNI: " + cliente.dni + 
		", Edad: " + cliente.edad + 
		", Peso: " + cliente.peso + 
		", Sexo: " + cliente.sexo + "\n";
	}

}
