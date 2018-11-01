package juego;

import adt.LinkedList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DragonTest {
    Dragon Prueba1=new Dragon();

    @Test
    void getCruce() {
        Prueba1.setCruce(true);
        assertEquals(true,Prueba1.getCruce());
    }

    @Test
    void getClick() {
        Prueba1.setClick(true);
        assertEquals(true,Prueba1.getClick());
    }

    @Test
    void getNivel() {
        Prueba1.setNivel(1);
        assertEquals(1,Prueba1.getNivel());
    }

    @Test
    void getNombre() {
        Prueba1.setNombre("Manuel");
        assertEquals("Manuel",Prueba1.getNombre());
    }

    @Test
    void getRecarga() {
        Prueba1.setRecarga(2);
        assertEquals(2,Prueba1.getRecarga());
    }

    @Test
    void getEdad() {
        Prueba1.setEdad(2);
        assertEquals(2,Prueba1.getEdad());
    }

    @Test
    void getResistencia() {
        Prueba1.setResistencia(2);
        assertEquals(2,Prueba1.getResistencia());
    }

    @Test
    void getClase() {
        Prueba1.setClase("Capitan");
        assertEquals(2,Prueba1.getClase());
    }
    @Test
    void getPadre() {
        Dragon padre=new Dragon();
        Prueba1.setPadre(padre);
        assertEquals(padre,Prueba1.getPadre());
    }
    @Test
    void getHijos() {
        Dragon hijo=new Dragon();
        Prueba1.setHijo(hijo);
        assertEquals(hijo,Prueba1.getHijos().getHead().getData());
    }

    @Test
    void getHijoDer() {
        Dragon hijoD=new Dragon();
        Prueba1.setHijoDer(hijoD);
        assertEquals(hijoD,Prueba1.getHijoDer());
    }

    @Test
    void getHijoIz() {
        Dragon hijo=new Dragon();
        Prueba1.setHijoIz(hijo);
        assertEquals(hijo,Prueba1.getHijoIz());
    }

    @Test
    void getPosXinicial() {
       // Dragon hijo=new Dragon();
        Prueba1.setPosXinicial(12);
        assertEquals(12,Prueba1.getPosXinicial());
    }
    @Test
    void getPosYinicial() {
        Prueba1.setPosYinicial(12);
        assertEquals(12,Prueba1.getPosYinicial());
    }

    @Test
    void getPosX() {
        Prueba1.setPosX(12);
        assertEquals(12,Prueba1.getPosX());
    }

    @Test
    void getPosY() {
        Prueba1.setPosY(12);
        assertEquals(12,Prueba1.getPosY());
    }

    @Test
    void getDragones_asignados() {
        Dragon hijo=new Dragon();
        Prueba1.setDragones_asignados(hijo);
        assertEquals(hijo,Prueba1.getDragones_asignados().getHead().getData());
    }

    @Test
    void recibirDano() {
        assertEquals(false, Prueba1.RecibirDano());
    }

}