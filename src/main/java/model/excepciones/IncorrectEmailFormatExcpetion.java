package model.excepciones;

public class IncorrectEmailFormatExcpetion extends Exception {
    private static final String EXCEPTION_MESSAGE="El email introducido tiene el formato incorrecto";

    public IncorrectEmailFormatExcpetion(){
        super(EXCEPTION_MESSAGE);
    }
}
