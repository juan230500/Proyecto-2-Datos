package juego;

import adt.LinkedList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DragonesFabricaTest {

    @Test
    void asignarNombre() {
        Oleada O=new Oleada(0,1);
        DragonesFabrica DF=new DragonesFabrica(0,1,O);
        Dragon D=new Dragon();
        DF.asignarNombre(2,45,D);
        assertEquals("B45",D.getNombre());
    }

    @Test
    void asignarRecarga() {
        Oleada O=new Oleada(0,1);
        DragonesFabrica DF=new DragonesFabrica(0,1,O);
        Dragon D=new Dragon();
        DF.asignarRecarga(D);
        //Genera una recarga random que es cualquier valor menos 0
        assertNotEquals(0,D.getRecarga());
    }

    @Test
    void asignarResistencia() {
        Oleada O=new Oleada(0,1);
        DragonesFabrica DF=new DragonesFabrica(0,1,O);
        Dragon D=new Dragon();
        DF.asignarResistencia(D);
        //Genera una resistencia random que es cualquier valor menos 0
        assertNotEquals(0,D.getResistencia());
    }

    @Test
    void asignarEdad() {
        Oleada O=new Oleada(0,1);
        DragonesFabrica DF=new DragonesFabrica(0,1,O);
        Dragon D=new Dragon();
        DF.asignarEdad(D);
        //Genera una edad random que es cualquier valor menos 0
        assertNotEquals(0,D.getEdad());

        DF=new DragonesFabrica(100,2,O);
        Dragon[] DArray=O.toArray();
        LinkedList L=new LinkedList();
        for (int i=0;i<100;i++){
            if (L.find(DArray[i])!=null){
                fail("Edad repetida");
            }
            else{
                L.insertFirst(DArray[i]);
            }
        }
        assertTrue(true);
    }

    @Test
    void asignarClase() {
        Oleada O=new Oleada(0,1);
        DragonesFabrica DF=new DragonesFabrica(0,1,O);
        Dragon D=new Dragon();
        DF.asignarClase(1,1,D);
        //Genera una clase random que es cualquier valor menos null
        assertNotEquals(null,D.getClase());
    }
}