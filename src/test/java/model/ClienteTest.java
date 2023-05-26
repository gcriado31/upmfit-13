package model;

import static org.junit.jupiter.api.Assertions.*;



import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import model.excepciones.*;

public class ClienteTest {

    private static int V1, V2, N1, N2, N3, N4;
    private static Sexo V3, V4, V5,  N5;
    private static String V6, V7, V8, V9, V10, N6, N7, N8, N9, N10, N11, N12, N13, N14, N15;

    @BeforeAll
    public static void setUpClass(){
        //EDAD
        V1=19;
        N1=17;N2=99;
        //PESO
        V2=74;
        N3=49;N4=181;
        //SEXO
        V3=Sexo.MUJER;V4=Sexo.HOMBRE;V5=Sexo.SIN_DEFINIR;
        //NOMBRE COMPLETO
        V6="Pepe Perez";
        N6="AAAA AAA";N7="Muvaffakiyetsizleştiricileştiriveremeyebileceklerimizdenmişsinizcesinesiniza";
        //NOMBRE USUARIO
        V7="Dios";
        N8="OK";N9="NOMEACUERDO";
        //DNI
        V8="53049703L";
        N10="6032635B";N11="02692104KJ";
        //CONTRASEÑA
        V9="Fis2023-13";
        N12="estonos";N13="PASSWORDno224";
        //CORREO
        V10="monicagb@alumnos.upm.es";
        N14="no@dos.com";N15="mepasedelcorreo@alumnos.es";

    }

   
    @Test
    public void casoPrueba1(){
        assertDoesNotThrow(() ->new Cliente(V1, V2, V3, V9, V10, V8, V6, V7));
    }

    @Test
    public void casoPrueba2(){
        assertDoesNotThrow(() ->new Cliente(V1, V2, V4, V9, V10, V8, V6, V7));
    }

    @Test
    public void casoPrueba3(){
        assertDoesNotThrow(() ->new Cliente(V1, V2, V5, V9, V10, V8, V6, V7));
    }

    @Test
    public void casoPrueba4(){
        assertThrows(IncorrectAgeException.class, () ->new Cliente(N1, V2, V5, V9, V10, V8, V6, V7));
    }

    @Test
    public void casoPrueba5(){
        assertThrows(IncorrectAgeException.class, () ->new Cliente(N2, V2, V5, V9, V10, V8, V6, V7));
    }

    @Test
    public void casoPrueba6(){
        assertThrows(IncorrecWeightException.class, () ->new Cliente(V1, N3, V5, V9, V10, V8, V6, V7));
    }

    @Test
    public void casoPrueba7(){
        assertThrows(IncorrecWeightException.class, () ->new Cliente(V1, N4, V5, V9, V10, V8, V6, V7));
    }

    @Test
    public void casoPrueba8(){
        //TODO test sexo
    }

    @Test
    public void casoPrueba9(){
        assertThrows(IncorrectNameException.class, () -> new Cliente(V1, V2, V5, V9, V10, V8, N6, V7));
    }

    @Test
    public void casoPrueb10(){
        assertThrows(IncorrectNameException.class, () -> new Cliente(V1, V2, V5, V9, V10, V8, N7, V7));
    }

}
