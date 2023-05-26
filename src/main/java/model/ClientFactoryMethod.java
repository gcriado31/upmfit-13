package model;

import model.excepciones.*;

public interface ClientFactoryMethod {
    public Cliente createCliente(int edad, int peso, Sexo sexo, String contraseña, String correo, String dni, String nombreCompleto, String nombreUsuario, String numeroMatricula,  int antiguedad,
    TipoPersonal tipoPersonal)throws IncorrectPasswordFormatException, IncorrectDniFormatException, IncorrectAgeException, IncorrecWeightException, IncorrectNameException  ;
}
