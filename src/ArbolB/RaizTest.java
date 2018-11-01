package ArbolB;

import static org.junit.jupiter.api.Assertions.*;

class RaizTest {

    @org.junit.jupiter.api.Test
    void tamano() {
        Raiz test1=new Raiz(100);
        int espera=20;
        int recibido=test1.tamano(100);
        assertEquals(espera,recibido);
    }

    @org.junit.jupiter.api.Test
    void serializarTexto() {
        Raiz raiz1=new Raiz(100);
        String recibido=raiz1.serializarTexto("[111]","A");
        String esperado="@\n" +
                "A111@";
        assertEquals(esperado,recibido);

    }

    @org.junit.jupiter.api.Test
    void recorrido() {
        Raiz test1=new Raiz(100);
        test1.insertar(1);
        String recibido=test1.Recorrido();
        String esperado="[ 1,  ]\n" +
                "\n" +
                "[  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ]";
        assertEquals(esperado,recibido);

    }

    @org.junit.jupiter.api.Test
    void dameInfo() {
        Raiz test1=new Raiz(100);
        test1.insertar(1);
        String recibido=test1.dameInfo(0,"A");
        recibido=recibido.replaceAll("\\s","");
        String esperado="A1,";
        assertEquals(esperado,recibido);
    }
    @org.junit.jupiter.api.Test
    void llamarRecorrer() {
        Raiz test1=new Raiz(100);
        String esperado="\n" + "[  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ]   \n";
        String recibido=test1.llamarRecorrer();
        assertEquals(esperado,recibido);

    }
}