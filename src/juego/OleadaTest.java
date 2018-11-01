package juego;

import adt.AVLTree;
import adt.Node;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class OleadaTest {

    @Test
    void getFormacion() {
        Oleada O=new Oleada(1,1);
        O.setFormacion(3);
        assertEquals(3,O.getFormacion());
    }

    @Test
    void getCantidadDragones() {
        Oleada O=new Oleada(6,1);
        assertEquals(6,O.getCantidadDragones());
    }

    @Test
    void getRoot() {
        Oleada O=new Oleada(1,1);
        Dragon D=new Dragon();
        O.setRoot(D);
        assertEquals(D,O.getRoot());
    }

    @Test
    void getDragonesDibujar() {
        Oleada O=new Oleada(1,1);
        Dragon D[]=new Dragon[0];
        O.setDragonesDibujar(D);
        assertArrayEquals(D,O.getDragonesDibujar());
    }

    @Test
    void getRootAVL() {
        Oleada O=new Oleada(1,1);
        Dragon D=new Dragon();
        Node root=new Node(D);
        O.setRootAVL(root);
        assertEquals(root,O.getRootAVL());
    }


    @Test
    void displayFamilias() {
        //Se debe verificar en el print porque el método no retorna ni cambia nada, solo consulta
        Oleada O=new Oleada(6,1);
        O.displayFamilias();
    }

    @Test
    void addRoot() {
        Oleada O=new Oleada(0,1);
        Dragon D1=new Dragon(34);
        O.add(D1);
        assertEquals(34,O.getRoot().getEdad());

    }

    @Test
    void addHijos() {
        Oleada O=new Oleada(0,1);

        Dragon D1=new Dragon(34);
        O.add(D1);
        assertEquals(34,O.getRoot().getEdad());

        Dragon D2=new Dragon(23);
        O.add(D2);
        assertEquals(23,O.getRoot().getHijoIz().getEdad());

        Dragon D3=new Dragon(50);
        O.add(D3);
        assertEquals(50,O.getRoot().getHijoDer().getEdad());
    }


    @Test
    void filtrarPorAltura() {
        Oleada O=new Oleada(0,1);

        Dragon D1=new Dragon(34);
        D1.setPosY(35);
        O.add(D1);

        Dragon D2=new Dragon(23);
        D2.setPosY(-35);
        O.add(D2);

        Dragon D3=new Dragon(50);
        D3.setPosY(135);
        O.add(D3);

        assertEquals(D1,O.FiltrarPorAltura(30,20).get(0));
    }

    @Test
    void masCercanoPorAltura() {
        Oleada O=new Oleada(0,1);

        Dragon D1=new Dragon(34);
        D1.setPosY(35);
        D1.setPosX(35);
        O.add(D1);

        Dragon D2=new Dragon(23);
        D2.setPosY(35);
        D2.setPosX(10);
        O.add(D2);

        Dragon D3=new Dragon(50);
        D3.setPosY(35);
        D3.setPosX(50);
        O.add(D3);

        assertEquals(D2,O.MasCercanoPorAltura(30));

    }

    @Test
    void toArray() {
        Oleada O=new Oleada(0,1);

        Dragon D1=new Dragon(34);
        O.add(D1);

        Dragon D2=new Dragon(23);
        O.add(D2);

        Dragon D3=new Dragon(50);
        O.add(D3);

        Dragon[] D=O.toArray();

        Dragon[] Esperado={D2,D3,D1};

        assertArrayEquals(Esperado,D);
    }

    @Test
    void insertarEnAVl() {
        Oleada O=new Oleada(0,1);

        Dragon D1=new Dragon(34);
        O.add(D1);

        Dragon D2=new Dragon(23);
        O.add(D2);

        Dragon D3=new Dragon(50);
        O.add(D3);

        AVLTree tree=new AVLTree();

        O.InsertarEnAVl(tree);

        assertEquals(50,tree.getRoot().right.key.getEdad());
    }

    @Test
    void delete() {
        Oleada O=new Oleada(0,1);

        Dragon D1=new Dragon(34);
        O.add(D1);

        Dragon D2=new Dragon(23);
        O.add(D2);

        Dragon D3=new Dragon(50);
        O.add(D3);

        Dragon D4=new Dragon(10);
        O.add(D4);

        assertEquals(D2,O.getRoot().getHijoIz());

        O.delete(D2);

        assertEquals(D4,O.getRoot().getHijoIz());
    }

    @Test
    void realinear() {
        Oleada O=new Oleada(0,1);

        Dragon D1=new Dragon(34);
        O.add(D1);

        Dragon D2=new Dragon(23);
        O.add(D2);

        Dragon D3=new Dragon(50);
        O.add(D3);

        Dragon D4=new Dragon(10);
        O.add(D4);

        Dragon[] Esperado={D4,D2,D1,D3};

        O.Realinear();

        assertArrayEquals(Esperado,O.getDragonesDibujar());
    }

    @Test
    void herirDragon() {

        Oleada O=new Oleada(0,1);

        Dragon D1=new Dragon(34);
        O.add(D1);

        Dragon D2=new Dragon(23);
        D2.setResistencia(2);
        O.add(D2);

        Dragon D3=new Dragon(50);
        O.add(D3);

        Dragon D4=new Dragon(10);
        O.add(D4);

        assertEquals(5,O.HerirDragon(D2));

        assertEquals(0,O.HerirDragon(D2));

        Dragon[] Esperado={D4,D1,D3};

        assertArrayEquals(Esperado,O.getDragonesDibujar());

    }






}