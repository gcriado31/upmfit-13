package model;

import java.util.*;

/**
 * 
 * Controlador  de los cursos.
 * Implementa el patrón Singleton
 *
 */
public class ControladorCurso {
	
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
	}
	public String create(){
		//TODO COMPLETAR METODO
		return "";
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
	private Curso searchCurse(String id){ //TODO Valorar la posibilidad de hacer clase Search
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
