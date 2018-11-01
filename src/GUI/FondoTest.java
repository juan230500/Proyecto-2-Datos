package GUI;

import adt.Node;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import juego.Caballero;
import juego.Dragon;
import juego.Oleada;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Andrey
 */
public class FondoTest {

    /**
     * Test of getOleadaDibujar method, of class Fondo.
     */
    @Test
    public void testGetOleadaDibujar() {
        System.out.println("getOleadaDibujar");
        Fondo instance = new Fondo(new Pantalla());
        Oleada expResult = new Oleada(100,1,instance,instance.getCaballero());
        Oleada result = instance.getOleadaDibujar();
        assertEquals(expResult.getCantidadDragones(), result.getCantidadDragones());
        // TODO review the generated test code and remove the default call to fail.
        if (result.getCantidadDragones()!= expResult.getCantidadDragones()) {
            fail("The test case is a prototype.");
        }
    }


    /**
     * Test of getCaballero method, of class Fondo.
     */
    @Test
    public void testGetCaballero() {
        System.out.println("getCaballero");
        Fondo instance = new Fondo(new Pantalla());
        Caballero expResult = new Caballero();
        Caballero result = instance.getCaballero();
        assertEquals(expResult.getVida(), result.getVida());
        // TODO review the generated test code and remove the default call to fail.
        if (result.getVida() != (expResult.getVida())) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of reiniciar method, of class Fondo.
     */
    @Test
    public void testReiniciar() {
        System.out.println("reiniciar");
        Fondo instance = new Fondo(new Pantalla());
        instance.reiniciar();
        // TODO review the generated test code and remove the default call to fail.
        if (instance.getOleadaDibujar().getCantidadDragones() != 120) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of moverlabel method, of class Fondo.
     */
    @Test
    public void testMoverlabel() {
        System.out.println("moverlabel");
        Fondo instance = new Fondo(new Pantalla());
        instance.moverlabel();
        Dragon[] DragonesADibujar=instance.getOleadaDibujar().toArray();
        // TODO review the generated test code and remove the default call to fail.
        if (DragonesADibujar[0].getPosX() <= 0) {
            fail("The test case is a prototype.");
        }
    }


    /**
     * Test of DrawArray method, of class Fondo.
     */
    @Test
    public void testDrawArray() {
        System.out.println("DrawArray");
        Fondo instance = new Fondo(new Pantalla());
        instance.DrawArray();
        // TODO review the generated test code and remove the default call to fail.
        if (instance.getOleadaDibujar().getFormacion()%5 != -1) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of DrawABB method, of class Fondo.
     */
    @Test
    public void testDrawABB() {
        System.out.println("DrawABB");
        Fondo instance = new Fondo(new Pantalla());
        instance.DrawABB();
        // TODO review the generated test code and remove the default call to fail.
        if (instance.getOleadaDibujar().getFormacion()%5 != 3) {
            fail("The test case is a prototype.");
        }
        //Ocurre la condicion debido a que no se han eliminado dragones, por lo que la formacion es diferente a 3
    }


    /**
     * Test of DrawAVL method, of class Fondo.
     */
    @Test
    public void testDrawAVL() {
        System.out.println("DrawAVL");
        Fondo instance = new Fondo(new Pantalla());
        instance.DrawAVL();
        // TODO review the generated test code and remove the default call to fail.
        if (instance.getOleadaDibujar().getFormacion()%5 != 4) {
            fail("The test case is a prototype.");
        }
        //Ocurre la condicion debido a que no se han eliminado dragones, por lo que la formacion es diferente a 3
    }

}