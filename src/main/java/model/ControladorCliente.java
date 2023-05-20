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
		int paso=0, edad=0, peso=0, antiguedad=-1;
		String nombreCompleto=null, nombreUsario=null, contraseña=null, correo=null, dni=null, numeroMatricula=null;
		Sexo sexo=null; TipoPersonal tipoPersonal=null;
		
		m_Cliente.add(creadorClientes.createCliente(edad, 0, peso, sexo, contraseña, correo, dni, nombreCompleto, nombreUsario, numeroMatricula, antiguedad, tipoPersonal));
		return CLIENTE_CREADO_CORRECTAMENTE; 
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
