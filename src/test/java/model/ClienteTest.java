package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import model.excepciones.IncorrectAgeException;

public class ClienteTest {


    @Test
    public void casoPrueba1(){
        assertDoesNotThrow(() ->new Cliente(19,74,Sexo.MUJER,"Fis2023-13","monicagb@alumnos.upm.es","53049703L","Pepe Perez", "Dios"));
    }

    @Test
    public void casoPrueba2(){
        assertDoesNotThrow(() ->new Cliente(19,74,Sexo.HOMBRE,"Fis2023-13","monicagb@alumnos.upm.es","53049703L","Pepe Perez", "Dios"));
    }

    @Test
    public void casoPrueba3(){
        assertDoesNotThrow(() -> new Cliente(19, 74, Sexo.SIN_DEFINIR, "Fis2023-13", "monicagb@alumnos.upm.es", "53049703L", "Pepe Perez", "Dios") );
    }

    @Test
    public void casoPrueba4(){
        assertThrows(IncorrectAgeException.class, () -> new Cliente(17, 74, Sexo.SIN_DEFINIR, "Fis2023-13", "monicagb@alumnos.upm.es", "53049703L", "Pepe Perez", "Dios"));
    }
    
}
