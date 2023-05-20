package model;
/**
 * 
 * Clase que renderiza la vista del menú.
 *
 */
public class VistaPrincipal { //TODO NO SE PA QUE SIRVE ESTO

	//ATRIBUTOS
	private static final String textoBienvenida=" Bienvenido a UPMFit\n"+"===================";
	private static final String textoOpcion1= "1: Alta de cliente.";
	private static final String textoOpcion2= "2: Alta de curso.";
	private static final String textoOpcion3= "3: Inscripción de un cliente a un curso.";
	private static final String textoOpcion4= "4: Visualización de los detalles de un curso.";
	private static VistaPrincipal instance=new VistaPrincipal();

	/**Constructor privado para el patron Singleton.*/
	private VistaPrincipal(){}


	/**
	 * Este método nos devuelve la instancia de la clase VistaPrincipal implementando así el patrón Singleton.
	 * @return instancia de VistaPrincipal.
	 */
	public static VistaPrincipal getInstance(){
		return instance;
	}

	public void renderError(){

	}

	public void renderMenu(){
		System.out.println(textoBienvenida);
		System.out.println(textoOpcion1);
		System.out.println(textoOpcion2);
		System.out.println(textoOpcion3);
		System.out.println(textoOpcion4);
	}
		
	
}
