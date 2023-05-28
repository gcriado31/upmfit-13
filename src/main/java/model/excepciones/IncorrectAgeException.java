package model.excepciones;


public class IncorrectAgeException extends Exception {
    
    private static final String EXCEPTION_MESSAGE="La edad introducida sobrepasa el intervalo de edad permitido (18-90)";

    public IncorrectAgeException(){
        super(EXCEPTION_MESSAGE);
    }

}
