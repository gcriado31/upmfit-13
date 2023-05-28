package model;

import java.util.InputMismatchException;

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
	public Monitores monitorDumie;
	public Curso cursosDumie;

	//CONSTRUCTOR
	public  SistemaUPMFIT(){
		this.m_VistaPrincipal=VistaPrincipal.getInstance();
		this.m_ControladorCurso=ControladorCurso.getInstance();
		this.m_ControladorCliente=ControladorCliente.getInstance();
		iniciar();
	}

	//METODOS
	public void finalize() throws Throwable {
		this.m_VistaPrincipal=null;
		this.m_ControladorCliente=null;
		this.m_ControladorCurso=null;
		this.monitorDumie=null;
		this.cursosDumie=null;
	}
	public void iniciar(){
		monitorDumie=new Monitores("Fis2023-13", "j.garcia@gamil.com", "06032636C", "Jose García", "j.garcia");
		cursosDumie= new Curso("0", "Relax", 18, 5, monitorDumie);
		m_ControladorCurso.addCurso(cursosDumie);
		this.menu();
	}

	public void menu(){
		boolean exit=false;
		do{
			m_VistaPrincipal.renderMenu();
			try{
				int elección=m_VistaPrincipal.askOpcion();
				exit=this.switchMenu(elección);
			} catch (InputMismatchException e){
				exit=false;
			}
			
		}while(!exit);
	}

	public boolean switchMenu(int eleccion) {
		boolean exit=false;
		switch (eleccion) {
			case 1:
				m_ControladorCliente.create();
				break;
			case 2:
				m_ControladorCurso.create(monitorDumie);
				break;
			case 3:
				String dniCliente=m_VistaPrincipal.askString("Introduzca el dni del cliente:");
				Cliente cliente=m_ControladorCliente.searchClient(dniCliente);
				if(cliente!=null){
					m_ControladorCurso.requestShowAll();
					String nombreCurso=m_VistaPrincipal.askString("Introduzca el nombre del curso al que se quiere apuntar:");
					m_ControladorCurso.apuntarCliente(nombreCurso, cliente);
				}else{
					m_VistaPrincipal.show("El cliente buscado no se ha encontrado");
				}
				break;
			case 4:
				m_ControladorCurso.requestShowAll();
				break;
			default:
				exit=true;
				break;
		}
		return exit;
	}

	//MAIN
	public static void main(String[] args){
		SistemaUPMFIT s= new SistemaUPMFIT();

	}


}
