package model;

import java.util.*;

/**
 * 
 * Controlador  de los cursos.
 * Implementa el patrón Singleton
 *
 */
public class ControladorCurso {
	
	// VARIABLES GLOBALES
	private static final String CURSO_CREADO_CORRECTAMENTE="Curso registrado correctamente";
	//ATRIBUTOS
	public  VistaCurso m_VistaCurso;
	public LinkedList<Curso> m_Curso;
	//INSTANCIA
	private static ControladorCurso instance=new ControladorCurso();

	/**Constructor privado para el patron Singleton.*/
	private ControladorCurso(){
		this.m_Curso=new LinkedList<>();
		this.m_VistaCurso=VistaCurso.getInstance();
	}

	/**
	 * Nos devuelve la instancia de ControladorCurso.
	 * @return la instancia de la clase.
	 */
	public static ControladorCurso getInstance(){
		return instance;
	}
	
	//METODOS
	public void finalize() throws Throwable {
		//TODO COMPLETAR METODO
		this.m_Curso.clear();
		this.m_Curso=null;
		this.m_VistaCurso=null;
	}
	public String create(){
		//TODO COMPLETAR METODO
		String nombreCurso=m_VistaCurso.askString("Introduzca el nombre del curso:");
		int numPersonasMax=m_VistaCurso.askInt("Introduzca el número máximo de personas: ");
		int numSesiones=m_VistaCurso.askInt("Introduzca el numero se sesiones que tendrá el curso: ");
		String id=this.generateID();
		m_Curso.add(new Curso(id,nombreCurso,numPersonasMax, numSesiones));	
		return CURSO_CREADO_CORRECTAMENTE;
	}

	private String generateID(){
		boolean repetir=true;
		int idNumber=0;
		String id;
		do{
			Random idGenator=new Random();
			idNumber=idGenator.nextInt(100); //TODO PENSAR NÚMERO PARA PONER
			id=Integer.toString(idNumber);
			if (searchCurse(id)==null){
				repetir=false;
			}
		}while(repetir);
		return id;
	}
	
	public void addCurso(Curso curso) {
		this.m_Curso.add(curso);
		
	}

	public String requestShow(String id){
		// TODO SABER SI ESTA BIEN HECHO.
		// TODO EN CLASE VISTACURSO MIRAR SI REQUESTED ES NULL
		Curso requested=this.searchCurse(id);
		return m_VistaCurso.renderShow(requested);
	}

	/**
	 * Método que busca el curso con el id pasado.
	 * @param id Id del curso que estamos buscando.
	 * @return Devolverá el curso con id igual al pasado. En caso de no encontrarlo devolverá null
	 */
	private Curso searchCurse(String id){ 
		boolean stop=false;
		Curso found=null;
		int iterator=0;
		while (!stop){
			if(m_Curso.isEmpty() || m_Curso.size()<iterator){
				stop=true;
			}else if (m_Curso.get(iterator).getIdCurso().equals(id)){
				found=m_Curso.get(iterator);
				stop=true;
			}else{
				iterator++;
			}
		}
		return found;
	}

}
