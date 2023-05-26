package model.excepciones;

public class IncorrecWeightException extends Exception{

    private static final String EXCEPTION_MESSAGE="El peso introducido sobrepasa el intervalo de edad permitido (50-180)";

    public IncorrecWeightException(){
        super(EXCEPTION_MESSAGE);
    }

}
