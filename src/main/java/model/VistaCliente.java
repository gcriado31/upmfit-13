package model;

/**
 * 
 * Clase que renderiza los clientes.
 * Esta clase implementa el patrón Singleton.
 *
 */
public class VistaCliente {
	
	//TODO POSIBLES ATRIBUTOS SON STRINGS FIJOS TIPO "NO EXISTE ESE CLIENTE"

	//ATRIBUTOS
	private static VistaCliente instance=new VistaCliente();
	
	/**Constructor privado para el patron Singleton.*/
	private VistaCliente(){ }

	/**
	 * Este método nos devuelve la instancia de la clase VistaCliente implementando así el patrón Singleton.
	 * @return instancia de VistaCliente.
	 */
	public static VistaCliente getInstance() {
		return instance;
	}

	//METODOS 
	public String rendershow(ICliente cliente){ // TODO ¿PORQUÉ ICLIENTE?
		//TODO COMPLETAR METODO
		return "";
	}

}
