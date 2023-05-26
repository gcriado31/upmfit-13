package model.excepciones;

public class IncorrectNameException extends Exception{
    private static final String EXCEPTION_MESSAGE="El nombre introducido sobrepasa el intervalo de caracteres permitido (10-75)";

    public IncorrectNameException(){
        super(EXCEPTION_MESSAGE);
    }
}
