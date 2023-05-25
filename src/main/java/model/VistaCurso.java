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
		//TODO COMPLETAR METODO
		this.input=Input.getInstance();
	}

	/**
	 * Este método nos devuelve la instancia de la clase VistaCurso implementando así el patrón Singleton.
	 * @return instancia de VistaCurso.
	 */
	public static VistaCurso getInstance(){
		return instance;
	}

	//METODOS 
	public String renderShow(ICurso curso){// TODO ¿PORQUÉ ICURSO?
		//TODO COMPLETAR METODO
		return "";
	}

	public void show(String msg){
		System.out.print(msg);
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

	/**
	 * Devuelve todos los clientes de el curso en concreto con su respectivo String 
	 * dependiendo de sus datos (ya que edad, peso y sexo son opcionales).
	 * @param curso Curso que se desa saber la información
	 */
	public void visualizacionCursos(Curso curso) {
		this.show("Curso: " + curso.getNombreCurso() + "\n Clientes que se encuentran inscritos: ");
		for (Cliente cliente : curso.listaClientes) {
			this.show("\t"+cliente.toStringSimple());
		}
    }


}
