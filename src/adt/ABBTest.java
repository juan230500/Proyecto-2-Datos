package adt;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ABBTest {
    @Test
    void getHd() {
        ABB tree=new ABB();
        tree.insertar(1);
        tree.insertar(2);
        tree.insertar(0);
        tree.insertar(7);
        tree.insertar(4);
        tree.insertar(5);
        assertEquals(2,tree.raiz.getHd().raiz.getDato());
    }

    @Test
    void getHi() {
        ABB tree=new ABB();
        tree.insertar(1);
        tree.insertar(2);
        tree.insertar(0);
        tree.insertar(7);
        tree.insertar(4);
        tree.insertar(5);
        assertEquals(0,tree.raiz.getHi().raiz.getDato());
    }

    @Test
    void getDato() {
        ABB tree=new ABB();
        tree.insertar(1);
        tree.insertar(2);
        tree.insertar(0);
        tree.insertar(7);
        tree.insertar(4);
        tree.insertar(5);
        assertEquals(1,tree.raiz.getDato());
    }


    @Test
    void insertar() {
        ABB tree=new ABB();
        tree.insertar(2);
        assertEquals(2,tree.raiz.getDato());
        tree.insertar(0);
        assertEquals(0,tree.raiz.getHi().raiz.getDato());
        tree.insertar(1);
        assertEquals(1,tree.raiz.getHi().raiz.getHd().raiz.getDato());
        //Todo se inserta donde se espera en un ABB
    }

    @Test
    void buscar() {
        ABB tree=new ABB();
        tree.insertar(1);
        tree.insertar(2);
        tree.insertar(0);
        tree.insertar(7);
        tree.insertar(4);
        tree.insertar(5);
        assertEquals(5,tree.buscar(5).raiz.getDato());
        try {
            tree.buscar(8).raiz.getDato();
            fail("debería tirar una axcepción si el dato no está");
        }
        catch (NullPointerException e){
            assertTrue(true);
        }
    }

    @Test
    void buscarMin() {
        ABB tree=new ABB();
        tree.insertar(1);
        tree.insertar(2);
        tree.insertar(0);
        tree.insertar(7);
        tree.insertar(4);
        tree.insertar(5);
        assertEquals(0,tree.buscarMin());

        tree.insertar(-1);
        assertEquals(-1,tree.buscarMin());
    }

    @Test
    void esHoja() {
        ABB tree=new ABB();
        tree.insertar(1);
        tree.insertar(2);
        tree.insertar(0);
        assertTrue(!tree.esHoja());
        assertTrue(tree.raiz.getHd().esHoja());
    }
}