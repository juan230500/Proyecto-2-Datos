package juego;


import adt.Cola;
import adt.LinkedList;

public class Oleada {


    public Oleada(int Cantidad) {
        this.CantidadDeDragones=Cantidad;
        this.ListaDragones=new LinkedList();

        //Bloque para generar los dragones automaticamente con un padre asignado a solo 2 de ellos
        Dragon D1=new Dragon();
        this.Head=D1;
        Cantidad--;
        ListaDragones.insertFirst(D1);

        Cola PadresConEspacio=new Cola();
        PadresConEspacio.enqueue(D1);

        Dragon Dtmp;

        while (Cantidad>1){
            Dragon Dpadre = (Dragon) PadresConEspacio.dequeue();

            Dtmp=new Dragon();
            Dpadre.setHijoIz(Dtmp);
            PadresConEspacio.enqueue(Dtmp);
            ListaDragones.insertFirst(Dtmp);

            Dtmp=new Dragon();
            Dpadre.setHijoDer(Dtmp);
            PadresConEspacio.enqueue(Dtmp);
            ListaDragones.insertFirst(Dtmp);

            Cantidad-=2;
        }

        if (Cantidad==1){
            Dragon Dpadre = (Dragon) PadresConEspacio.dequeue();
            Dtmp=new Dragon();
            Dpadre.setHijoIz(Dtmp);
            ListaDragones.insertFirst(Dtmp);
        }

    }

    private int CantidadDeDragones;

    private String Formacion;

    private Dragon Head;

    private LinkedList ListaDragones;

    public Dragon getHead() {
        return Head;
    }


    public void Realinear(int criterio, Oleada Oleada,Dragon muerto){
        /*
        Criterio:
        0-Selection edad
        1-Insertion velocidad
        2-Quick edad
        3-ABB familias
        4-AVL edad
         */

        if (criterio==3){
            Dragon root=Oleada.getHead();
        }
        else if(criterio==4){

        }
        else{

        }

    }

    public void display() {
        display(this.Head);
    }

    public void display(Dragon head){
        if (head!=null){
            display(head.getHijoIz());
            System.out.print(" "+head+" ");
            display((head.getHijoDer()));
        }
    }


    public Dragon[] toArray() {
        Dragon[] D=new Dragon[CantidadDeDragones];
        toArray(this.Head,D,0 );
        return D;
    }

    public int toArray(Dragon n, Dragon[] results, int index) {
        if (n.getHijoIz() != null) {
            index = toArray(n.getHijoIz(), results, index);
        }

        if (n.getHijoDer() != null) {
            index = toArray(n.getHijoDer(), results, index);
        }

        results[index] = n;

        return index + 1;
    }



    public void aumentarOleada() {
    }

    public void cambiarFormacion() {
    }

}