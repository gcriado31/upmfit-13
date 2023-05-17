package model;

/**
 * 
 * Clase del personal interno PAS o PDI. Hereda de Cliente
 *
 */
public class PersonalUpm extends Cliente{
	
	//ATRIBUTOS
	private int antiguedad;
	private int descuento; //TODO Valorar cambio a float
	private static final int DESCUENTO_MAXIMO=70; //TODO Valorar cambio a float
	private TipoPersonal tipoPersonal;
	
	//CONSTRUCTOR
	public PersonalUpm(int edad, int fechaCaducidad, int peso, String sexo, String contraseña, String correo,
			String dni, String nombreCompleto, String nombreUsuario, int antiguedad,
			TipoPersonal tipoPersonal) {
		super(edad, fechaCaducidad, peso, sexo, contraseña, correo, dni, nombreCompleto, nombreUsuario);
		this.antiguedad = antiguedad;
		calculoDescuento();
		this.tipoPersonal = tipoPersonal;
	}
	
	
	//METODOS
	private void calculoDescuento() { 
		this.descuento=(25+(3*this.antiguedad));
		if(this.descuento>DESCUENTO_MAXIMO) {
			this.descuento=DESCUENTO_MAXIMO;
		}
	}
	
	
}
