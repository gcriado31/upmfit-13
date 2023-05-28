package model;

import model.excepciones.*;
import servidor.UPMUsers;

public interface ClientFactoryMethod {
    public Cliente createCliente(int edad, int peso, Sexo sexo, String contraseña, String correo, String dni, String nombreCompleto, String nombreUsuario, UPMUsers tipoClienteUPM)
    throws IncorrectPasswordFormatException, IncorrectDniFormatException, IncorrectAgeException, IncorrecWeightException, IncorrectNameException, IncorrectNicknameFormatException, IncorrectEmailFormatExcpetion  ;
}
