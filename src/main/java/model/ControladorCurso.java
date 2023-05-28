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
	private static final String CURSO_NOT_FOUND="El curso buscado no se ha encontrado";
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

	public void apuntarCliente(String nombreCurso, Cliente cliente){
		Curso curso=this.searchCurseByName(nombreCurso);
		if(curso!=null){
			curso.apuntarCliente(cliente);
		}else{
			m_VistaCurso.show(CURSO_NOT_FOUND);
		}
	}

	public String create(Monitores monitor){
		//TODO COMPLETAR METODO
		String nombreCurso=m_VistaCurso.askString("Introduzca el nombre del curso:");
		int numPersonasMax=m_VistaCurso.askInt("Introduzca el número máximo de personas: ");
		int numSesiones=m_VistaCurso.askInt("Introduzca el numero se sesiones que tendrá el curso: ");
		Actividad actividad=this.askActividad();
		String id=this.generateID();
		Curso nuevoCurso=new Curso(id,nombreCurso,numPersonasMax, numSesiones,monitor);
		nuevoCurso.setSesiones(this.generateSesiones(numSesiones, actividad));
		m_Curso.add(nuevoCurso);	
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
			if (this.searchCurse(id)==null){
				repetir=false;
			}
		}while(repetir);
		return id;
	}
	
	private ArrayList<Sesiones> generateSesiones(int numSesiones, Actividad actividad){
		ArrayList<Sesiones> devuelto=new ArrayList<>(numSesiones);
		for (int i = 0; i < numSesiones; i++) {
			devuelto.add(new Sesiones(actividad));
		}
		return devuelto;
	}

	private Actividad askActividad(){
		try{
			int eleccion=m_VistaCurso.askOpcion("Seleccione la actividad que se va realizar en el curso\n\t1.Gimnasia.\n\t2.Bicicleta\n\t3.Natacion\n\t4.Baile\n\t5.Relax\nPulse cualquier otra tecla para General");
			switch (eleccion) {
				case 1:
					return Actividad.Gimnasia;
				case 2:
					return Actividad.Bicicleta;
				case 3:
					return Actividad.Natacion;
				case 4:
					return Actividad.Baile;
				case 5:
					return Actividad.Relax;
				default:
					return Actividad.General;
			}
		} catch(InputMismatchException e){
			return Actividad.General;
		}
	}

	public void addCurso(Curso curso) {
		this.m_Curso.add(curso);
		
	}

	public void ereaseCurso(String id){
		Curso ereased=this.searchCurse(id);
		if(ereased!=null){
			this.m_Curso.remove(ereased);
		}else{
			m_VistaCurso.show(CURSO_NOT_FOUND);
		}
	}

	public String requestShow(String id){
		// TODO SABER SI ESTA BIEN HECHO.
		// TODO EN CLASE VISTACURSO MIRAR SI REQUESTED ES NULL
		Curso requested=this.searchCurse(id);
		if(requested!=null){
			return m_VistaCurso.renderShow(requested);
		}else{
			return (CURSO_NOT_FOUND);
		}
		
	}

	/**
	 * Método que muesta todos los cursos creados, y por cada curso muestra todos sus clientes 
	 * con sus datos correspondientes.
	 */
	public void requestShowAll(){
		for (Curso curso : m_Curso) {
			m_VistaCurso.visualizacionCursos(curso);
		}
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
		if(!m_Curso.isEmpty()){
			while (!stop){
				if(m_Curso.isEmpty() || m_Curso.size()<=iterator){
					stop=true;
				}else if (m_Curso.get(iterator).getIdCurso().equals(id)){
					found=m_Curso.get(iterator);
					stop=true;
				}else{
					iterator++;
				}
			}
		}
		return found;
	}

	/**
	 * Método que busca el curso con el id pasado.
	 * @param nombre Nombre del curso que estamos buscando.
	 * @return Devolverá el curso con id igual al pasado. En caso de no encontrarlo devolverá null
	 */
	private Curso searchCurseByName(String nombre){ 
		boolean stop=false;
		Curso found=null;
		int iterator=0;
		while (!stop){
			if(m_Curso.isEmpty() || m_Curso.size()<iterator){
				stop=true;
			}else if (m_Curso.get(iterator).getNombreCurso().equals(nombre)){
				found=m_Curso.get(iterator);
				stop=true;
			}else{
				iterator++;
			}
		}
		return found;
	}

}
