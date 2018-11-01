package GUI;

import adt.LinkedList;
import juego.Dragon;
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
public class InfoDragonTest {

    /**
     * Test of setNombre method, of class InfoDragon.
     */
    @Test
    public void testSetNombre() {
        System.out.println("setNombre");
        String nombre = "A1";
        InfoDragon instance = new InfoDragon();
        instance.setNombre(nombre);
        // TODO review the generated test code and remove the default call to fail.
        if (!("Nombre:"+nombre).equals(instance.nombre.getText())) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setInfanteria method, of class InfoDragon.
     */
    @Test
    public void testSetInfanteria() {
        System.out.println("setInfanteria");
        LinkedList lista = new LinkedList();
        Dragon n= new Dragon();
        n.setNombre("test");
        lista.insertFirst(n);
        InfoDragon instance = new InfoDragon();
        instance.setInfanteria(lista);
        // TODO review the generated test code and remove the default call to fail.
        if (!("Infanteria: " +n.getNombre()+" ").equals(instance.infanteria.getText())) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setClase method, of class InfoDragon.
     */
    @Test
    public void testSetClase() {
        System.out.println("setClase");
        String clas = "";
        InfoDragon instance = new InfoDragon();
        instance.setClase(clas);
        // TODO review the generated test code and remove the default call to fail.
        if (!("Clase:" +clas).equals(instance.clase.getText())) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setPadre method, of class InfoDragon.
     */
    @Test
    public void testSetPadre() {
        System.out.println("setPadre");
        Dragon padre = new Dragon();
        padre.setNombre("test");
        InfoDragon instance = new InfoDragon();
        instance.setPadre(padre);
        // TODO review the generated test code and remove the default call to fail.
        if (!("Padre:" +padre.getNombre()).equals(instance.padre.getText())) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setHijoI method, of class InfoDragon.
     */
    @Test
    public void testSetHijoI() {
        System.out.println("setHijoI");
        Dragon hijoi = new Dragon();
        hijoi.setNombre("test");
        InfoDragon instance = new InfoDragon();
        instance.setHijoI(hijoi);
        // TODO review the generated test code and remove the default call to fail.
        if (!("Hijo Izquierdo:" +hijoi.getNombre()).equals(instance.hijoI.getText())) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setHijoD method, of class InfoDragon.
     */
    @Test
    public void testSetHijoD() {
        System.out.println("setHijoD");
        Dragon hijod = new Dragon();
        InfoDragon instance = new InfoDragon();
        instance.setHijoD(hijod);
        // TODO review the generated test code and remove the default call to fail.
        if (!("Hijo Derecho:" +hijod.getNombre()).equals(instance.hijoD.getText())) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setEdad method, of class InfoDragon.
     */
    @Test
    public void testSetEdad() {
        System.out.println("setEdad");
        int edad = 0;
        InfoDragon instance = new InfoDragon();
        instance.setEdad(edad);
        // TODO review the generated test code and remove the default call to fail.
        if (!("Edad:" + Integer.toString(edad)).equals(instance.edad.getText())) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setResistencia method, of class InfoDragon.
     */
    @Test
    public void testSetResistencia() {
        System.out.println("setResistencia");
        int resistencia = 0;
        InfoDragon instance = new InfoDragon();
        instance.setResistencia(resistencia);
        // TODO review the generated test code and remove the default call to fail.
        if (!("Resistencia:" + Integer.toString(resistencia)).equals(instance.resistencia.getText())) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setRecarga method, of class InfoDragon.
     */
    @Test
    public void testSetRecarga() {
        System.out.println("setRecarga");
        int recarga = 0;
        InfoDragon instance = new InfoDragon();
        instance.setRecarga(recarga);
        // TODO review the generated test code and remove the default call to fail.
        if (!("Recarga:" + Integer.toString(recarga)).equals(instance.recarga.getText())) {
            fail("The test case is a prototype.");
        }
    }

}
