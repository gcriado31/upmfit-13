package model;

import java.util.*;
import utilidades.*;
import servidor.*;

/** 
 * Controlador de los Clientes
 * 
 */

public class ControladorCliente {
	
	// VARIABLES GLOBALES
	private static final String CLIENTE_CREADO_CORRECTAMENTE="Cliente registrado correctamente";
	private static final String CLIENTE_NOT_FOUND="El cliente buscado no se ha encontrado";
	// ATRIBUTOS 
	public VistaCliente m_VistaCliente;
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
		this.m_Cliente.clear();
		this.m_Cliente=null;
		this.m_VistaCliente=null;
		this.creadorClientes=null;
	}
	public String create(){
		//TODO FALTA TRATAMIENTO DE EXCEPCIONES Y VARIABLES GLOBALES
		this.m_VistaCliente.show("NUEVO CLIENTE\n"+"============");
		int edad=-1, peso=-1, antiguedad=-1;
		String nombreCompleto=null, nombreUsario=null, contraseña=null, correo=null, dni=null, numeroMatricula=null;
		Sexo sexo=null; TipoPersonal tipoPersonal=null;
		// Información basica
		nombreCompleto=this.m_VistaCliente.askString("Introduzca nombre completo: ");
		dni=this.m_VistaCliente.askString("Introduzca su DNI: ");
		nombreUsario=this.m_VistaCliente.askString("Introduzca nombre de usuario: ");
		correo=this.m_VistaCliente.askString("Introduzca su correo: ");
		contraseña=this.m_VistaCliente.askString("Introduzca contraseña: ");
		//Información basica opcional
		switch(m_VistaCliente.askOpcion("¿Desea introducir su sexo, edad y peso como información extra?\n\t1. Si.\n\t2. No.")){
			case 1:
                String opcionSexo = this.m_VistaCliente.askString("¿Cuál es su sexo? \n\t1. Mujer (introduce M). \n\t2. Hombre (introduce H). \n\t3. Sin identificar (cualquier otra letra o palabra). \n\t-> ");
				if(opcionSexo.equalsIgnoreCase("M")){
					sexo = Sexo.MUJER;
                }else if(opcionSexo.equalsIgnoreCase("H")){
					sexo = Sexo.HOMBRE;
				}else{
                    sexo = Sexo.SIN_DEFINIR;
                }
				edad = this.m_VistaCliente.askInt("Introduzca su edad: ");
				peso = this.m_VistaCliente.askInt("Introduzca su peso: ");
			break;
		}
		// Información específica
		int tipo=this.m_VistaCliente.askOpcion("¿Cómo se quiere registrar usted?\n\t1. Usuario externo.\n\t2. Personal interno UPM\n\t3. Estudiante");
		switch (tipo) {
			case 2:
				this.m_VistaCliente.show("Personal Interno UPM");
				antiguedad=m_VistaCliente.askInt("Introduzca su antigüedad:");
				int eleccion=m_VistaCliente.askOpcion("¿Qué tipo de personal es usted?\n\t1. PAS.\n\t2. PDI");
				switch (eleccion) {
					case 1:
						tipoPersonal=TipoPersonal.PAS;
						break;
				
					case 2:
						tipoPersonal=TipoPersonal.PDI;
						break;
				}
				break;
		
			case 3:
				this.m_VistaCliente.show("Estudiante UPM");
				numeroMatricula=m_VistaCliente.askString("Introduzca el número de matrícula:");
				break;
		}
		this.addClient(creadorClientes.createCliente(edad, 0, peso, sexo, contraseña, correo, dni, nombreCompleto, nombreUsario, numeroMatricula, antiguedad, tipoPersonal));
		return CLIENTE_CREADO_CORRECTAMENTE; 
	}

	public void addClient(Cliente cliente){
		this.m_Cliente.add(cliente);
	}

	public void eraseClient(String dni){ //TODO AQUI EXCEPCIÓN
		Cliente searched=this.searchClient(dni);
		this.m_Cliente.remove(searched);
	}
	
	public String requestShowSimple(String dni){
		// TODO SABER SI ESTA BIEN HECHO.
		// TODO EN CLASE VISTACLIENTE MIRAR SI REQUESTED ES NULL
		Cliente show=this.searchClient(dni);
		if(show!=null){
			return m_VistaCliente.renderShowSimple(show);
		}else{
			return (CLIENTE_NOT_FOUND);
		}
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
