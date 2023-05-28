package model.excepciones;

public class IncorrectPasswordFormatException extends Exception{

    private static final String EXCEPTION_MESSAGE="La contraseña introducida tiene el formato incorrecto";
    
    public IncorrectPasswordFormatException(){
        super(EXCEPTION_MESSAGE);
    }
}
