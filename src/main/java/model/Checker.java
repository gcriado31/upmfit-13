package model;

import java.util.regex.*;

import model.excepciones.IncorrecWeightException;
import model.excepciones.IncorrectAgeException;
import model.excepciones.IncorrectDniFormatException;
import model.excepciones.IncorrectNameException;
import model.excepciones.IncorrectPasswordFormatException;

public class Checker {

    private static final int MIN_CHAR_PASSWORD= 8;
    private static final int MAX_CHAR_PASSWORD= 12;
    private static final int CHAR_DNI= 9;
    private static final int PART_NUM_DNI= 8;
    private static final int MIN_AGE= 18;
    private static final int MAX_AGE= 90;
    private static final int MIN_WEIGHT= 50;
    private static final int MAX_WEIGHT= 180;
    private static final int MIN_CHAR_NAME= 10;
    private static final int MAX_CHAR_NAME= 75;
    
    /**
     * Comprueba que la contraseña tiene las carecterísticas específicas.
     * @param contraseña Contraseña que queremos comprobar.
     * @return Devuelve la contraseña si está todo correcto.
     * @throws IncorrectPasswordFormatException Saltará si la contrseña o tiene el formato carrecto.
     */
    public static String checkContraseña(String contraseña) throws IncorrectPasswordFormatException{
        if (contraseña.length() > MIN_CHAR_PASSWORD && contraseña.length()<MAX_CHAR_PASSWORD) { //Una contraseña tiene más de 8 caracteres y menos12 caracteres.
            boolean mayuscula = false;
            boolean numero = false;
            boolean letraOsimbolo = false;
            boolean especial = false;
    
            //Define caracteres especiales
            Pattern special = Pattern.compile("[!#$%&'()*+,-./:;<=>?@^_`{|}~]");
            Matcher hasSpecial = special.matcher(contraseña);

            for (int i = 0; i < contraseña.length(); i++) {
                char l = contraseña.charAt(i);
    
                if (Character.isDigit(l)) {//Mínimo un número. 
                    numero = true;
                }
                if (Character.isLetter(l)) {//Contiene letras o símbolos 
                    letraOsimbolo = true;
                }
                if (Character.isUpperCase(l)) { //Mínimo una letra mayúscula 
                    mayuscula = true;
                }
                if (hasSpecial.find()) { //Valida "caracteres especiales".       
                    especial = true;
                }
            }
    
            if (!(numero && mayuscula && letraOsimbolo && especial)) {
                throw new IncorrectPasswordFormatException();
            }else{
                return contraseña;
            }
        } else {
            throw new IncorrectPasswordFormatException();
        }
    }

    /**
     * Comprueba que el DNI tenga el formato correcto.
     * @param dni DNI a comprobar.
     * @return Devuelve el DNI si todo está bien.
     * @throws IncorrectDniFormatException Saltará si no tiene el formato correcto.
     */
    public static String checkDNI(String dni) throws IncorrectDniFormatException{
        if(dni.length()==CHAR_DNI){
            boolean noLettersInNumberPartDNI=true;
            for (int i = 0; i < PART_NUM_DNI; i++) {
                if(Character.isDigit(dni.charAt(i))==false){
                    noLettersInNumberPartDNI=false;
                }
            }
            if(!noLettersInNumberPartDNI){
                throw new IncorrectDniFormatException();
            }else{
                return dni;
            }
        }else{
            throw new IncorrectDniFormatException();
        }
    }

    public static int checkEdad(int edad) throws IncorrectAgeException{
        if(edad<MIN_AGE || edad>MAX_AGE){
            throw new IncorrectAgeException();
        }else{
            return edad;
        }
    }

    public static int checkPeso(int peso) throws IncorrecWeightException{
        if(peso<MIN_WEIGHT || peso>MAX_WEIGHT){
            throw new IncorrecWeightException();
        }else{
            return peso;
        }
    }

    public static String checkName(String name) throws IncorrectNameException{
        if(name.length()<MIN_CHAR_NAME || name.length()>MAX_CHAR_NAME){
            throw new IncorrectNameException();
        }else{
            return name;
        }
    }

}
