package adt;

import juego.Dragon;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortArrayTest {
    @Test
    void getArr() {
        Dragon D1=new Dragon(34,54);
        Dragon D2=new Dragon(23,1);
        Dragon D3=new Dragon(54,23);
        Dragon[] Array= {D1,D2,D3};
        SortArray A=new SortArray(Array);

        assertArrayEquals(Array,A.getArr());
    }

    @Test
    void selectionSort() {
        Dragon[] Array1= {};
        SortArray A1=new SortArray(Array1);
        A1.SelectionSort();

        Dragon D1=new Dragon(34,54);
        Dragon D2=new Dragon(23,1);
        Dragon D3=new Dragon(54,23);
        Dragon[] Array2= {D1,D2,D3};
        SortArray A2=new SortArray(Array2);
        A2.SelectionSort();

        assertEquals(23,A2.getArr()[0].getEdad());
        assertEquals(54,A2.getArr()[2].getEdad());

        try{
            Dragon[] Array3= {D1,D2,D3,null};
            SortArray A3=new SortArray(Array3);
            A3.SelectionSort();
            fail("Debería haber un NullPointer");
        }
        catch (NullPointerException e){
            assertTrue(true);
        }
    }

    @Test
    void insertionSort() {
        Dragon[] Array1= {};
        SortArray A1=new SortArray(Array1);
        A1.InsertionSort();

        Dragon D1=new Dragon(34,54);
        Dragon D2=new Dragon(23,1);
        Dragon D3=new Dragon(54,23);
        Dragon[] Array2= {D1,D2,D3};
        SortArray A2=new SortArray(Array2);
        A2.InsertionSort();

        assertEquals(1,A2.getArr()[0].getRecarga());
        assertEquals(54,A2.getArr()[2].getRecarga());

        try{
            Dragon[] Array3= {D1,D2,D3,null};
            SortArray A3=new SortArray(Array3);
            A3.InsertionSort();
            fail("Debería haber un NullPointer");
        }
        catch (NullPointerException e){
            assertTrue(true);
        }
    }

    @Test
    void quickSort() {
        Dragon[] Array1= {};
        SortArray A1=new SortArray(Array1);
        A1.quickSort();

        Dragon D1=new Dragon(34,54);
        Dragon D2=new Dragon(23,1);
        Dragon D3=new Dragon(54,23);
        Dragon[] Array2= {D1,D2,D3};
        SortArray A2=new SortArray(Array2);
        A2.quickSort();

        assertEquals(23,A2.getArr()[0].getEdad());
        assertEquals(54,A2.getArr()[2].getEdad());

        try{
            Dragon[] Array3= {D1,D2,D3,null};
            SortArray A3=new SortArray(Array3);
            A3.quickSort();
            fail("Debería haber un NullPointer");
        }
        catch (NullPointerException e){
            assertTrue(true);
        }
    }

}