package juego;

import adt.LinkedList;

public class Dragones {

    private LinkedList lista_dragones = new LinkedList();

    public Dragones(int cantidad){

        while (cantidad > 0){
            Dragon dragon = new Dragon();
            cantidad --;
        }
    }
}
