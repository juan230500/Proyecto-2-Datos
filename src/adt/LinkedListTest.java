package adt;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @Test
    void getHead() {
        LinkedList L=new LinkedList();
        assertNull(L.getHead());

        L.insertFirst(1);
        assertEquals(1,L.getHead().getData());
    }

    @Test
    void insertFirst() {
        LinkedList L=new LinkedList();
        L.insertFirst(1);
        L.insertFirst(2);
        L.insertFirst(4);
        assertEquals(1,L.getHead().getNext().getNext().getData());

        L.insertFirst(null);
        assertNull(L.getHead().getData());
    }

    @Test
    void insertLast(){
        LinkedList L=new LinkedList();
        L.insertLast(1);
        L.insertLast(2);
        L.insertLast(4);
        assertEquals(4,L.getHead().getNext().getNext().getData());
    }

    @Test
    void getSize() {
        LinkedList L=new LinkedList();
        L.insertFirst(1);
        L.insertFirst(2);
        L.insertFirst(4);
        L.insertFirst(1);
        L.insertFirst(2);
        L.insertFirst(4);
        assertEquals(6,L.getSize());
    }


    @Test
    void deleteFirst() {
        LinkedList L=new LinkedList();
        L.insertFirst(1);
        L.insertFirst(2);
        L.insertFirst(4);
        assertEquals(4,L.deleteFirst().getData());
        assertEquals(2,L.getHead().getData());
    }

    @Test
    void find() {
        LinkedList L=new LinkedList();
        L.insertFirst(1);
        L.insertFirst(2);
        L.insertFirst(4);
        assertEquals(1,L.find(1).getData());
        assertNull(L.find(5));
    }

    @Test
    void delete() {
        LinkedList L=new LinkedList();
        L.insertFirst(1);
        L.insertFirst(2);
        L.insertFirst(4);
        L.insertFirst(5);
        L.insertFirst(0);

        L.delete(4);

        assertEquals(2,L.getHead().getNext().getNext().getData());
    }
}