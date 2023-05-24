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
	private Input input;
	
	/**Constructor privado para el patron Singleton.*/
	private VistaCliente(){ this.input=Input.getInstance(); }

	/**
	 * Este método nos devuelve la instancia de la clase VistaCliente implementando así el patrón Singleton.
	 * @return instancia de VistaCliente.
	 */
	public static VistaCliente getInstance() {
		return instance;
	}

	//METODOS 
	public String renderShow(ICliente cliente){ // TODO ¿PORQUÉ ICLIENTE?
		//TODO COMPLETAR METODO
		return "";
	}


	public void show(String msg){
		System.out.println(msg);
	}

    public String askString(String msg) {
		this.show(msg);
        return input.scanString();
    }

	public int askOpcion(String msg) {
		this.show(msg);
		return input.scanInt(); //TODO scanOption
	}

	public int askInt(String msg) {
		this.show(msg);
		return input.scanInt();
	}

}
