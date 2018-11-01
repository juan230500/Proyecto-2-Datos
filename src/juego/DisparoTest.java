package juego;

import GUI.Fondo;
import GUI.Pantalla;
import org.junit.*;

import javax.swing.*;

import static org.junit.Assert.*;

public class DisparoTest {

    /**
     * Test of isDisparar method, of class Disparo.
     */
    @Test
    public void testIsDisparar() {
        System.out.println("isDisparar");
        Disparo instance = new Disparo(0,0);
        boolean expResult = false;
        boolean result = instance.isDisparar();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if(result != expResult) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getPosY method, of class Disparo.
     */
    @Test
    public void testGetPosY() {
        System.out.println("getPosY");
        Disparo instance = new Disparo(0,0);
        int expResult = 0;
        int result = instance.getPosY();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if(result != expResult) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getPosX method, of class Disparo.
     */
    @Test
    public void testGetPosX() {
        System.out.println("getPosX");
        Disparo instance = new Disparo(0,0);
        int expResult = 0;
        int result = instance.getPosX();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if(result != expResult) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getBola method, of class Disparo.
     */
    @Test
    public void testGetBola() {
        System.out.println("getBola");
        Disparo instance = new Disparo(0,0);
        ImageIcon img = new ImageIcon("src/MultiMedia/shoot.gif");
        JLabel expResult = new JLabel("o");
        expResult.setIcon(img);
        JLabel result = instance.getBola();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if(result != expResult) {
            fail("The test case is a prototype.");
        }
        /*Se genera un error el cual al clickear donde se indica para ver las diferencias dice que no existen diferencias.
         *Probable error de referencia.
         */

    }

    /**
     * Test of moverDisparo method, of class Disparo.
     */
    @Test
    public void testMoverDisparo_JLabel() {
        System.out.println("moverDisparo");
        JLabel enem = new JLabel();
        enem.setBounds(50,0,10,10);
        Disparo instance = new Disparo(0,0);
        instance.moverDisparo(enem);
        // TODO review the generated test code and remove the default call to fail.
        if(enem.getX() != instance.getPosX()+45) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of moverDisparo method, of class Disparo.
     */
    @Test
    public void testMoverDisparo_Fondo() {
        System.out.println("moverDisparo");
        Fondo fondo1 = new Fondo(new Pantalla());
        Disparo instance = new Disparo(0,0);
        instance.moverDisparo(fondo1);
        // TODO review the generated test code and remove the default call to fail.
        if(fondo1.getX()+800 == instance.getPosX()) {
            fail("The test case is a prototype.");
        }
    }

}