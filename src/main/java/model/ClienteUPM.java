package model;

import model.excepciones.*;
import servidor.UPMUsers;

public class ClienteUPM extends Cliente{
    
    private UPMUsers tipoClienteUPM;

    public ClienteUPM(int edad, int peso, Sexo sexo, String contraseña, String correo,String dni, String nombreCompleto, String nombreUsuario, UPMUsers tipoClienteUPM) 
    throws IncorrectPasswordFormatException, IncorrectDniFormatException, IncorrectAgeException, IncorrecWeightException, IncorrectNameException, IncorrectNicknameFormatException, IncorrectEmailFormatExcpetion{
        super(edad, peso, sexo, contraseña, correo, dni, nombreCompleto, nombreUsuario);
        this.tipoClienteUPM=tipoClienteUPM;
    }
    
    public UPMUsers getTipoClienteUPM(){
        return tipoClienteUPM;
    }
}
