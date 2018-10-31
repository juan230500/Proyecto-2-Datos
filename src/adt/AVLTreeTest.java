package adt;

import juego.Dragon;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AVLTreeTest {

    @Test
    void getRoot() {
        AVLTree tree = new AVLTree();
        tree.insert(new Dragon(1));
        //insertar bien en la raiz de un arbol nuevo
        assertEquals(1, tree.getRoot().key.getEdad());
    }

    @Test
    void insertSimple() {
        AVLTree tree = new AVLTree();
        tree.insert(new Dragon(1));
        tree.insert(new Dragon(2));
        tree.insert(new Dragon(0));
        tree.insert(new Dragon(3));
        //Insertar como en un ABB donde el tres de bebe ser derecho del 2 y el 2 derech del 1 (raiz)
        assertEquals(3, tree.getRoot().right.right.key.getEdad());
    }

    @Test
    void insertRR() {
        AVLTree tree=new AVLTree();
        tree.insert(new Dragon(1));
        tree.insert(new Dragon(2));
        tree.insert(new Dragon(0));
        tree.insert(new Dragon(3));
        tree.insert(new Dragon(4));
        //Realiza correctamente la rotación RR
        assertEquals(3,tree.getRoot().right.key.getEdad());

    }

    @Test
    void insertLL() {
        AVLTree tree=new AVLTree();
        tree.insert(new Dragon(1));
        tree.insert(new Dragon(0));
        tree.insert(new Dragon(4));
        tree.insert(new Dragon(3));
        tree.insert(new Dragon(2));
        //En este caso se prueba una LL
        assertEquals(3,tree.getRoot().right.key.getEdad());
    }

    @Test
    void insertRL() {
        AVLTree tree=new AVLTree();
        tree.insert(new Dragon(4));
        tree.insert(new Dragon(0));
        tree.insert(new Dragon(2));
        tree.insert(new Dragon(1));
        tree.insert(new Dragon(3));
        //En este caso se prueba una RL
        assertEquals(2,tree.getRoot().key.getEdad());
    }

}