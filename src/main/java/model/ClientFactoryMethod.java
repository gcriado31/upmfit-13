package model;

public interface ClientFactoryMethod {
    public Cliente createCliente(int edad, int fechaCaducidad, int peso, String sexo, String contraseña, String correo, String dni, String nombreCompleto, String nombreUsuario, String numeroMatricula,  int antiguedad,
    TipoPersonal tipoPersonal,String numeroCuenta);
}
