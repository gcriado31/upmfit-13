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
	private VistaCliente(){ this.input= Input.getInstance(); }

	/**
	 * Este método nos devuelve la instancia de la clase VistaCliente implementando así el patrón Singleton.
	 * @return instancia de VistaCliente.
	 */
	public static VistaCliente getInstance() {
		return instance;
	}

	//METODOS 
	public String renderShowSimple(ICliente cliente){ 
		return cliente.toStringSimple();
	}


	public void show(String msg){
		System.out.println(msg);
	}

    public String askString(String msg) {
		this.show(msg);
		String devuelto=input.scanString();
        return devuelto;
    }

	public int askOpcion(String msg) {
		this.show(msg);
		int opcion=input.scanInt();
		return opcion; 
	}

	public int askInt(String msg) {
		this.show(msg);
		int integer=input.scanInt();
		return integer;
	}

	public void cleanInput(){
		input.clean();
	}

}
