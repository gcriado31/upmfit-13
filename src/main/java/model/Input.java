package model;

import java.util.Scanner;

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
    public String scanString(){
        return this.scanner.nextLine();
    }

    public int scanInt() {
        return this.scanner.nextInt();
    }
}
