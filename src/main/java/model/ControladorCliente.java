package model;

import java.util.*;

/** 
 * Controlador de los Clientes
 * 
 */

public class ControladorCliente {
	
	// VARIABLES GLOBALES
	private static final String CLIENTE_CREADO_CORRECTAMENTE="Cliente registrado correctamente";
	// ATRIBUTOS 
	public VistaCliente m_VistaCliente;
	private Input input;
	public LinkedList<Cliente> m_Cliente;
	public ClientFactory creadorClientes;
	// INSTANCIA
	public static ControladorCliente instance=new ControladorCliente();

	/**Constructor privado para el patron Singleton.*/
	private ControladorCliente(){
		//TODO COMPLETAR METODO
		this.m_Cliente=new LinkedList<Cliente>();
		this.m_VistaCliente=VistaCliente.getInstance();
		this.creadorClientes =new ClientFactory();
		this.input=new Input();
	}

	/**
	 * Nos devuelve la instancia de ControladorCliente.
	 * @return la instancia de la clase.
	 */
	public static ControladorCliente getInstance(){
		return instance;
	}

	// MÉTODOS
	public void finalize() throws Throwable {
		//TODO COMPLETAR METODO
	}
	public String create(){
		//TODO FALTA TRATAMIENTO DE EXCEPCIONES Y REVISAR COMO MODULARIZAR EL MÉTODO
		int paso=0, edad=0, peso=0;
		String nombreCompleto="", nombreUsario="", contraseña="", correo="", dni="";
		Sexo sexo=null;
		this.comunInfo(paso, nombreCompleto, nombreUsario, edad, peso, sexo, contraseña, correo, dni);
		m_VistaCliente.renderRegister(paso);
		int tipo=input.scanInt();
		switch(tipo){
			case 1: //Estudiante 
				m_VistaCliente.show("Introduzca el número de matrícula:");
				String numeroMatricula=input.scanString();
				m_Cliente.add(creadorClientes.createCliente(edad, edad, peso, sexo, contraseña, correo, dni, nombreCompleto, nombreUsario, numeroMatricula, -1, null));
				break;
			case 2: // Personal UPM
				m_VistaCliente.show("Introduzca la antigüedad:");
				int antiguedad=input.scanInt();
				m_VistaCliente.show("Seleccione tipo de personal:\n\t1. PAS.\n\t2.PDI.");
				int seleccion=input.scanInt();
				TipoPersonal tipoPersonal=null;
				switch(seleccion){
					case 1:
						tipoPersonal=TipoPersonal.PAS;
						break;
					case 2:
						tipoPersonal=TipoPersonal.PDI;
				}
				m_Cliente.add(creadorClientes.createCliente(edad, 0, peso, sexo, contraseña, correo, dni, nombreCompleto, nombreUsario, null, antiguedad, tipoPersonal));
				break;
			default: // Cliente externo
				m_Cliente.add(creadorClientes.createCliente(edad, 0, peso, sexo, contraseña, correo, dni, nombreCompleto, nombreUsario, null, -1, null));
				break;
		}
		return CLIENTE_CREADO_CORRECTAMENTE; 
	}

	private void comunInfo(int paso,String nombreCompleto, String nombreUsuario, int edad, int peso, Sexo sexo, String contraseña, String correo, String dni){
			// Pedir nombre completo
			m_VistaCliente.renderRegister(paso);
			nombreCompleto=input.scanString();
			paso++;
			// Pedir nombre usuario
			m_VistaCliente.renderRegister(paso);
			nombreUsuario=input.scanString();
			paso++;
			// Pedir edad
			m_VistaCliente.renderRegister(paso);
			edad=input.scanInt();
			paso++;
			// Pedir peso
			m_VistaCliente.renderRegister(paso);
			peso=input.scanInt();
			paso++;
			// Pedir Sexo 
			m_VistaCliente.renderRegister(paso);
			int opcion=input.scanInt();
			switch (opcion) {
				case 1:
					sexo=Sexo.HOMBRE;
					break;
				case 2:
					sexo=Sexo.MUJER;
				default:
					sexo=Sexo.SIN_DEFINIR;
					break;
			}
			paso++;
			// Pedir contraseña
			m_VistaCliente.renderRegister(paso);
			contraseña=input.scanString();
			paso++;
			// Pedir correo
			m_VistaCliente.renderRegister(paso);
			correo=input.scanString();
			paso++;
			// Pedir DNI
			m_VistaCliente.renderRegister(paso);
			dni=input.scanString();
			paso++;
	
	}
	
	public String requestShow(String dni){
		// TODO SABER SI ESTA BIEN HECHO.
		// TODO EN CLASE VISTACLIENTE MIRAR SI REQUESTED ES NULL
		Cliente show=this.searchClient(dni);
		return m_VistaCliente.rendershow(show);
	}

	/**
	 * Método para buscar el cliente con el dni en la lista de clientes.
	 * @param dni DNI del usuario buscado.
	 * @return Devolverá el cliente con el DNI pasado. Si no encuentra el cliente devolverá null.
	 */
	private Cliente searchClient(String dni){//TODO Valorar la posibilidad de hacer clase Search
		boolean stop=false;
		Cliente found=null;
		int iterator=0;
		while (!stop){
			if(m_Cliente.isEmpty() || m_Cliente.size()<iterator){
				stop=true;
			}else if (m_Cliente.get(iterator).getDni().equals(dni)){
				found=m_Cliente.get(iterator);
				stop=true;
			}else{
				iterator++;
			}
		}
		return found;
	}
}
