package model;

import model.excepciones.*;
import servidor.UPMUsers;

public class ClientFactory implements ClientFactoryMethod{

    public Cliente createCliente(int edad, int peso, Sexo sexo, String contraseña, String correo,
            String dni, String nombreCompleto, String nombreUsuario,UPMUsers tipoClienteUPM) 
            throws IncorrectPasswordFormatException, IncorrectDniFormatException, IncorrectAgeException, IncorrecWeightException, IncorrectNameException, IncorrectNicknameFormatException, IncorrectEmailFormatExcpetion {
        if(tipoClienteUPM!=null){
            return new ClienteUPM(edad, peso, sexo, contraseña, correo, dni, nombreCompleto, nombreUsuario, tipoClienteUPM);        
        }else{
            return new Cliente(edad, peso, sexo, contraseña, correo, dni, nombreCompleto, nombreUsuario);
        }
    }
    
}
