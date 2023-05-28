package model;
/**
 * 
 * Clase que renderiza la vista del menú.
 *
 */
public class VistaPrincipal { //TODO NO SE PA QUE SIRVE ESTO

	//ATRIBUTOS
	private static final String textoBienvenida="Bienvenido a UPMFit\n"+"===================";
	private static final String textoOpcion1= "\n\t1: Alta de cliente.";
	private static final String textoOpcion2= "\n\t2: Alta de curso.";
	private static final String textoOpcion3= "\n\t3: Inscripción de un cliente a un curso.";
	private static final String textoOpcion4= "\n\t4: Visualización de los detalles de un curso.";
	private static final String textoOpcion5= "\nPulse cualqier otra tecla para salir. -> ";
	private static VistaPrincipal instance=new VistaPrincipal();
	private Input input;

	/**Constructor privado para el patron Singleton.*/
	private VistaPrincipal(){
		this.input=new Input();
	}


	/**
	 * Este método nos devuelve la instancia de la clase VistaPrincipal implementando así el patrón Singleton.
	 * @return instancia de VistaPrincipal.
	 */
	public static VistaPrincipal getInstance(){
		return instance;
	}

	public void renderMenu(){
		this.show(textoBienvenida);
		this.show(textoOpcion1);
		this.show(textoOpcion2);
		this.show(textoOpcion3);
		this.show(textoOpcion4);
		this.show(textoOpcion5);
	}
		
	public int askOpcion() {
		int opcion=input.scanInt();
		input.reset();
		return opcion;
	}

	public void show(String msg){
		System.out.print(msg);
	}

	public String askString(String msg) {
		this.show(msg);
		String devuelto=input.scanString();
		input.reset();
        return devuelto;
    }
}
