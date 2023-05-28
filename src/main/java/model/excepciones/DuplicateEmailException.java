package model.excepciones;

public class DuplicateEmailException extends Exception{

    private static final String EXCEPTION_MESSAGE="El DNI introducido ya se encuentra vinculado a nuestra base de datos";

    public DuplicateEmailException(){
        super(EXCEPTION_MESSAGE);
    }
    
}
