package model;

/**
 * 
 * Clase del sistema. Es la clase principal del software desarrollado.
 * @version 1.3
 *
 */
public class SistemaUPMFIT {
	
	//ATRIBUTOS
	public VistaPrincipal m_VistaPrincipal;
	public  ControladorCurso m_ControladorCurso;
	public ControladorCliente m_ControladorCliente;

	//CONSTRUCTOR
	public  SistemaUPMFIT(){
		//TODO COMPLETAR CONSTRUCTOR
		this.m_VistaPrincipal=VistaPrincipal.getInstance();
		this.m_ControladorCliente=ControladorCliente.getInstance();
		this.m_ControladorCurso=ControladorCurso.getInstance();
	}

	//METODOS
	public void finalize() throws Throwable {
		//TODO COMPLETAR METODO
	}
	public void iniciar(){
		//TODO COMPLETAR METODO
	}

	//MAIN
	public void main(){
		Cliente cliente= new Cliente(18, 20/3/2027,100, "M", "AAAA","d","","","");

	}


}
