package principal;

import adt.*;
import juego.Dragon;
import juego.Oleada;

import java.util.Arrays;

public class Principal {
    public static void main(String[] args){
        System.out.println("Hola 2");
        Cola C=new Cola();
        C.enqueue(2);
        C.enqueue(3);
        C.dequeue();
        C.enqueue(4);
        C.display();

        Oleada O=new Oleada(6);
        //O.display();

        Dragon[] D=O.toArray();
        System.out.println(Arrays.toString(D));
    }
}


