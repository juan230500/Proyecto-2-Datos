package juego;


import GUI.Fondo;

import javax.swing.*;

import GUI.Pantalla;
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
public class CaballeroTest {


    /**
     * Test of getVida method, of class Caballero.
     */
    @Test
    public void testGetVida() {
        System.out.println("getVida");
        Caballero instance = new Caballero();
        int expResult = 5;
        int result = instance.getVida();
        assertEquals(expResult, result);
            // TODO review the generated test code and remove the default call to fail.
        if (result!=expResult) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setVida method, of class Caballero.
     */
    @Test
    public void testSetVida() {
        System.out.println("setVida");
        int vida = 4;
        Caballero instance = new Caballero();
        instance.setVida(vida);
        // TODO review the generated test code and remove the default call to fail.
        if (vida!=instance.getVida()) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of isChoque method, of class Caballero.
     */
    @Test
    public void testIsChoque() {
        System.out.println("isChoque");
        Caballero instance = new Caballero();
        boolean expResult = false;
        boolean result = instance.isChoque();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (result!=expResult) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setChoque method, of class Caballero.
     */
    @Test
    public void testSetChoque() {
        System.out.println("setChoque");
        boolean choque = false;
        Caballero instance = new Caballero();
        instance.setChoque(choque);
        // TODO review the generated test code and remove the default call to fail.
        if (choque!=instance.isChoque()) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getLabel method, of class Caballero.
     */
    @Test
    public void testGetLabel() {
        System.out.println("getLabel");
        Caballero instance = new Caballero();
        ImageIcon img = new ImageIcon("src/MultiMedia/Grifo.gif");
        JLabel expResult = new JLabel("Prueba");
        expResult.setBounds(20,100,80,50);
        expResult.setIcon(img);
        JLabel result = instance.getLabel();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if(expResult!=result) {
            fail("The test case is a prototype.");
        }
        /*Se genera un error el cual al clickear donde se indica para ver las diferencias dice que no existen diferencias.
         *Probable error de referencia.
         */
    }

    /**
     * Test of getDisparo method, of class Caballero.
     */
    @Test
    public void testGetDisparo() {
        System.out.println("getDisparo");
        Caballero instance = new Caballero();
        JLabel expResult = null;
        JLabel result = instance.getDisparo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (expResult!=result) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setDragonesQuePasaron method, of class Caballero.
     */
    @Test
    public void testSetDragonesQuePasaron() {
        System.out.println("setDragonesQuePasaron");
        int dragonesQuePasaron = 0;
        Caballero instance = new Caballero();
        instance.setDragonesQuePasaron(dragonesQuePasaron);
        // TODO review the generated test code and remove the default call to fail.
        if (dragonesQuePasaron!=instance.getDragonesQuePasaron()) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getDragonesQuePasaron method, of class Caballero.
     */
    @Test
    public void testGetDragonesQuePasaron() {
        System.out.println("getDragonesQuePasaron");
        Caballero instance = new Caballero();
        int expResult = 0;
        int result = instance.getDragonesQuePasaron();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (expResult!=result) {
            fail("The test case is a prototype.");
        }
    }


    /**
     * Test of atacar method, of class Caballero.
     */
    @Test
    public void testAtacar_Fondo() {
        System.out.println("atacar");
        Fondo fondo = new Fondo(new Pantalla());
        Caballero instance = new Caballero();
        instance.atacar(fondo);
        // TODO review the generated test code and remove the default call to fail.
        if (instance.getDisparo().getX()>=fondo.getX()+800) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getResistencia method, of class Caballero.
     */
    @Test
    public void testGetResistencia() {
        System.out.println("getResistencia");
        Caballero instance = new Caballero();
        int expResult = 5;
        int result = instance.getResistencia();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (expResult!=result) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setResistencia method, of class Caballero.
     */
    @Test
    public void testSetResistencia() {
        System.out.println("setResistencia");
        int resistencia = 0;
        Caballero instance = new Caballero();
        instance.setResistencia(resistencia);
        // TODO review the generated test code and remove the default call to fail.
        if (resistencia!=instance.getResistencia()) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of recibir_daÃ±o method, of class Caballero.
     */
    @Test
    public void testRecibir_daño() {
        System.out.println("recibir_da\u00f1o");
        Caballero instance = new Caballero();
        instance.recibir_daño();
        // TODO review the generated test code and remove the default call to fail.
        if (instance.getVida()!=4) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of colisionEnem method, of class Caballero.
     */
    @Test
    public void testColisionEnem() {
        System.out.println("colisionEnem");
        JLabel cho = new JLabel("dragon");
        cho.setBounds(10,100,10,10);
        Caballero instance = new Caballero();
        boolean expResult = true;
        boolean result = instance.colisionEnem(cho);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (expResult!=result) {
            fail("The test case is a prototype.");
        }
    }

}
