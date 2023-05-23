package model;

public class ClientFactory implements ClientFactoryMethod{

    public Cliente createCliente(int edad, int fechaCaducidad, int peso, Sexo sexo, String contraseña, String correo,
            String dni, String nombreCompleto, String nombreUsuario, String numeroMatricula, int antiguedad,
            TipoPersonal tipoPersonal) {
        if(numeroMatricula!=null && antiguedad==-1 && tipoPersonal==null){
            return new Estudiantes(edad, fechaCaducidad, peso, sexo, contraseña, correo, dni, nombreCompleto, nombreUsuario, numeroMatricula);
        }else if (antiguedad!=-1 && tipoPersonal!=null && numeroMatricula==null){
            return new PersonalUpm(edad, fechaCaducidad, peso, sexo, contraseña, correo, dni, nombreCompleto, nombreUsuario, antiguedad, tipoPersonal);
        }else{
            return new Cliente(antiguedad, fechaCaducidad, peso, sexo, contraseña, correo, dni, nombreCompleto, nombreUsuario);
        }
    }
    
}
