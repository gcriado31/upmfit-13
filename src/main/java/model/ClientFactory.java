package model;

import model.excepciones.*;

public class ClientFactory implements ClientFactoryMethod{

    public Cliente createCliente(int edad, int peso, Sexo sexo, String contraseña, String correo,
            String dni, String nombreCompleto, String nombreUsuario, String numeroMatricula, int antiguedad,
            TipoPersonal tipoPersonal) throws IncorrectPasswordFormatException, IncorrectDniFormatException, IncorrectAgeException {
        if(numeroMatricula!=null && antiguedad==-1 && tipoPersonal==null){
            return new Estudiantes(edad, peso, sexo, contraseña, correo, dni, nombreCompleto, nombreUsuario, numeroMatricula);
        }else if (antiguedad!=-1 && tipoPersonal!=null && numeroMatricula==null){
            return new PersonalUpm(edad, peso, sexo, contraseña, correo, dni, nombreCompleto, nombreUsuario, antiguedad, tipoPersonal);
        }else{
            return new Cliente(antiguedad, peso, sexo, contraseña, correo, dni, nombreCompleto, nombreUsuario);
        }
    }
    
}
