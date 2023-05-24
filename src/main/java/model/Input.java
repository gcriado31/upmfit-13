package model;

import java.util.*;

/**
 * Esta calse nos servirá para escanear lo que le usuario meta por pantalla.
 * Aplicará el patrón Singleton.
 */
public class Input {
    
    //ATRIBUTOS
    private Scanner scanner;
    //INSTANCIA
    private static Input instance= new Input();

    /**
     * Constructor privado para patron Singleton
     */
    private Input(){
        this.scanner=new Scanner(System.in);
    }

    //GETTER
    public static Input getInstance(){
        return instance;
    }

    // METODOS
    /**
     * Escanea un String.
     * @return Devuelve el String escaneado
     */
    public String scanString(){
        return this.scanner.nextLine();
    }

   /**
    * Escanea un valor de tipo int
    * @return Devuelve el valor en int.
    * @throws InputMismatchException En caso que se introdujese algo que no fuera tipo int saltará esta excepción.
    */
    public int scanInt() throws InputMismatchException {
        return this.scanner.nextInt();
    }
}
