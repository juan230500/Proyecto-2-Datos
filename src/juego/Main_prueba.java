package juego;

import adt.LinkedList;

public class Main_prueba {
    public static void main(String args[]) {

        Dragones dragones = new Dragones(10);
        LinkedList lista = dragones.getLista_dragones();

        for (int i=1; i < lista.size(); i++) {

            Dragon d1 = (Dragon) lista.recorrer(i);
            Dragon d2 = d1.getPadre();

            System.out.println("El padre de " + d1.getNombre() + " es " + d2.getNombre());
            System.out.println("recarga; "+d1.getRecarga()+ " resistencia: "+d1.getResistencia()+ " edad: "+d1.getEdad());
        }
    }
}
