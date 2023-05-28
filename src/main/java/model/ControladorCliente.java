package model;

import java.util.*;

import model.excepciones.*;
import servidor.*;

/** 
 * Controlador de los Clientes
 * 
 */

public class ControladorCliente {
	
	// VARIABLES GLOBALES
	private static final String CLIENTE_CREADO_CORRECTAMENTE="Cliente registrado correctamente";
	private static final String CLIENTE_NOT_FOUND="El cliente buscado no se ha encontrado\n";
	// ATRIBUTOS 
	private VistaCliente m_VistaCliente;
	private LinkedList<Cliente> m_Cliente;
	private ClientFactory creadorClientes;
	private Autenticacion servidorAutenticacion;
	// INSTANCIA
	public static ControladorCliente instance=new ControladorCliente();

	/**Constructor privado para el patron Singleton.*/
	private ControladorCliente(){
		//TODO COMPLETAR METODO
		this.m_Cliente=new LinkedList<Cliente>();
		this.m_VistaCliente=VistaCliente.getInstance();
		this.creadorClientes =new ClientFactory();
		this.servidorAutenticacion= new Autenticacion();
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
		int edad=-1, peso=-1 ;
		String nombreCompleto=null, nombreUsario=null, contraseña=null, correo=null, dni=null;
		Sexo sexo=null; UPMUsers rol=null;
		boolean nombreCorrecto=false, contraseñaCorrecta=false, dniCorrecto=false, nicknameCorrecto=false, correoCorrecto=false, problemas=false, malInfoOpcional=false, opcion=false;
		do{
			// Información basica obligatoria
			if(!nombreCorrecto)nombreCompleto=this.m_VistaCliente.askString("Introduzca nombre completo:");
			if(!contraseñaCorrecta)contraseña=this.m_VistaCliente.askString("Introduzca contraseña: ");
			if(!dniCorrecto)dni=this.m_VistaCliente.askString("Introduzca su DNI:");
			if(!nicknameCorrecto)nombreUsario=this.m_VistaCliente.askString("Introduzca nombre de usuario:");
			if (!correoCorrecto){
				correo=this.m_VistaCliente.askString("Introduzca su correo:");
				// Obtención del rol si es correo de la UPM.
				if(servidorAutenticacion.existeCuentaUPM(correo)){
					rol=ObtencionDeRol.get_UPM_AccountRol(correo);
				}
			}
			try {
				this.checkEmailDB(correo);
				Cliente nuevoCliente=creadorClientes.createCliente(edad, peso, sexo, contraseña, correo, dni, nombreCompleto, nombreUsario,rol);
				int eleccion=0;
				if(!opcion){
					eleccion=m_VistaCliente.askOpcion("¿Desea introducir su sexo, edad y peso como información extra?\n\t1. Si.\nPulse cualquier otra tecla para saltar.");
					opcion=true;
				}
				do{
					if((eleccion==1)){
						this.insertInfoOpcional(nuevoCliente);
					}
				}while(malInfoOpcional);
				this.addClient(nuevoCliente);
				problemas=false;
			} catch (IncorrectPasswordFormatException e) {
				m_VistaCliente.show(e.getMessage());
				problemas=true;
				nombreCorrecto=true; dniCorrecto=true; nicknameCorrecto=true;correoCorrecto=true;
			} catch (IncorrectDniFormatException e) {
				m_VistaCliente.show(e.getMessage());
				problemas=true;
				nombreCorrecto=true; contraseñaCorrecta=true; nicknameCorrecto=true;correoCorrecto=true;
			} catch (IncorrectAgeException | IncorrecWeightException e) {
				m_VistaCliente.show(e.getMessage());
				problemas=true;
				malInfoOpcional=true;
			}  catch (IncorrectNameException e) {
				m_VistaCliente.show(e.getMessage());
				problemas=true;
				contraseñaCorrecta=true; dniCorrecto=true; nicknameCorrecto=true;correoCorrecto=true;
			} catch (IncorrectNicknameFormatException e) {
				m_VistaCliente.show(e.getMessage());
				problemas=true;
				nombreCorrecto=true; dniCorrecto=true; contraseñaCorrecta=true;correoCorrecto=true;
			} catch (IncorrectEmailFormatExcpetion | DuplicateEmailException e) {
				m_VistaCliente.show(e.getMessage());
				problemas=true;
				nombreCorrecto=true; dniCorrecto=true; nicknameCorrecto=true;contraseñaCorrecta=true;
			}
		}while(problemas);
		return CLIENTE_CREADO_CORRECTAMENTE; 
	}

	public void checkEmailDB(String email) throws DuplicateEmailException{
		if(searchClientEmail(email)!=null){
			throw new DuplicateEmailException();
		}
	}

	public void insertInfoOpcional(Cliente cliente) throws IncorrectAgeException, IncorrecWeightException{
		//Información basica opcional
        String opcionSexo = this.m_VistaCliente.askString("¿Cuál es su sexo? \n\tM. Mujer. \n\tH. Hombre. \n\t3. Sin identificar (cualquier otra letra o palabra). \n\t-> ");
		if(opcionSexo.equalsIgnoreCase("M")){
			cliente.setSexo(Sexo.MUJER);
        }else if(opcionSexo.equalsIgnoreCase("H")){
			cliente.setSexo(Sexo.HOMBRE);
		}else{
            cliente.setSexo(Sexo.SIN_DEFINIR);
        }
		cliente.setEdad(this.m_VistaCliente.askInt("Introduzca su edad: "));
		cliente.setPeso(this.m_VistaCliente.askInt("Introduzca su peso: "));
		
	}

	public void addClient(Cliente cliente){
		this.m_Cliente.add(cliente);
	}

	public void eraseClient(String dni){ //TODO AQUI EXCEPCIÓN
		Cliente searched=this.searchClient(dni);
		this.m_Cliente.remove(searched);
	}
	
	public String requestShow(String dni){
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
	public Cliente searchClient(String dni){
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

	public Cliente searchClientEmail(String email){
		boolean stop=false;
		Cliente found=null;
		int iterator=0;
		while (!stop){
			if(m_Cliente.isEmpty() || m_Cliente.size()<iterator){
				stop=true;
			}else if (m_Cliente.get(iterator).getCorreo().equals(email)){
				found=m_Cliente.get(iterator);
				stop=true;
			}else{
				iterator++;
			}
		}
		return found;
	}
}
