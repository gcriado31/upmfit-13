package model;

/**
 * 
 * Clase que renderiza los cursos.
 * Esta clase implementa el patrón Singleton.
 */
public class VistaCurso {
	
	//TODO POSIBLES ATRIBUTOS SON STRINGS FIJOS TIPO "NO EXISTE ESE CURSO"

	//ATRIBUTOS
	private static VistaCurso instance=new VistaCurso();
	private Input input;
	/**Constructor privado para el patron Singleton.*/
	private VistaCurso(){
		this.input=new Input();
	}

	/**
	 * Este método nos devuelve la instancia de la clase VistaCurso implementando así el patrón Singleton.
	 * @return instancia de VistaCurso.
	 */
	public static VistaCurso getInstance(){
		return instance;
	}

	//METODOS 
	public String renderShow(ICurso curso){
		return curso.toString();
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

	public int askOpcion(String msg) {
		this.show(msg);
		int opcion=input.scanInt();
		input.reset();
		return opcion;
	}

	public int askInt(String msg) {
		this.show(msg);
		int integer=input.scanInt();
		input.reset();
		return integer;
	}

	/**
	 * Devuelve todos los clientes de el curso en concreto con su respectivo String 
	 * dependiendo de sus datos (ya que edad, peso y sexo son opcionales).
	 * @param curso Curso que se desa saber la información
	 */
	public void visualizacionCursos(Curso curso) {
		this.show("Curso: " + curso.getNombreCurso() +"\nMonitor a cargo: "+curso.getMonitor().getNombreCompleto()+ "\nClientes que se encuentran inscritos("+curso.getNumPersonasApuntadas()+"/"+curso.getNumPersonasMax()+"):\n ");
		for (Cliente cliente : curso.listaClientes) {
			this.show("\t"+cliente.toStringSimple());
		}
    }


}
