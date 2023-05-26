package model.excepciones;

/**
 * Excepción que saltará cuando el DNI del usuario tenga un formato incorrecto.
 */
public class IncorrectDniFormatException extends Exception{
    
    private static final String EXCEPTION_MESSAGE="El DNI introducido tiene el formato incorrecto";
    
    public IncorrectDniFormatException(){
        super(EXCEPTION_MESSAGE);
    }
}
