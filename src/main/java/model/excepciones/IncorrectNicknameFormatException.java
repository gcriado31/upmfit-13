package model.excepciones;

public class IncorrectNicknameFormatException extends Exception{
    private static final String EXCEPTION_MESSAGE="El nombre de usuario introducido tiene el formato incorrecto";

    public IncorrectNicknameFormatException(){
        super(EXCEPTION_MESSAGE);
    }
}
