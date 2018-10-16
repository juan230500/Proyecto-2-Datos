package juego;


import adt.Cola;
import adt.LinkedList;

public class Oleada {


    public Oleada(int Cantidad) {
        this.CantidadDeDragones=Cantidad;

        //Bloque para generar los dragones automaticamente con un padre asignado a solo 2 de ellos
        Dragon D1=new Dragon();
        this.Head=D1;
        Cantidad--;

        Cola PadresConEspacio=new Cola();
        PadresConEspacio.enqueue(D1);

        Dragon Dtmp;

        while (Cantidad>1){
            Dragon Dpadre = (Dragon) PadresConEspacio.dequeue();

            Dtmp=new Dragon();
            Dpadre.setHijoIz(Dtmp);
            PadresConEspacio.enqueue(Dtmp);

            Dtmp=new Dragon();
            Dpadre.setHijoDer(Dtmp);
            PadresConEspacio.enqueue(Dtmp);

            Cantidad-=2;
        }

        if (Cantidad==1){
            Dragon Dpadre = (Dragon) PadresConEspacio.dequeue();
            Dtmp=new Dragon();
            Dpadre.setHijoIz(Dtmp);
        }

    }

    private int CantidadDeDragones;

    private String Formacion;

    private Dragon Head;

    public Dragon getHead() {
        return Head;
    }

    public void Realinear(int criterio, Dragon muerto){
        //Se elimina el dragón y se le asigna otro padre o otros hijos
        this.delete(muerto);

        /*
        Criterio:
        0-Selection edad
        1-Insertion velocidad
        2-Quick edad
        3-ABB familias
        4-AVL edad
         */
        if (criterio==3){

        }
        else if(criterio==4){

        }
        else{

        }

    }

    public void delete(Dragon DragonEliminar){
        Dragon padre;
        Dragon actual=this.Head;
        LinkedList pendientes=new LinkedList();
        while (pendientes!=null){
            while (actual!=null){
                if (actual==DragonEliminar){
                    pendientes=null;
                    break;
                }
                else{
                    pendientes.insertFirst(actual.getHijoDer());
                    actual=actual.getHijoIz();
                }
            }
            if (pendientes!=null)
            actual= (Dragon) pendientes.deleteFirst().getData();
        }
        padre=actual.getPadre();
        System.out.println(actual);
        System.out.println(padre);

        //Caso 1
        if (actual.getHijoDer()==null && actual.getHijoIz()==null){
            if (actual==this.Head){
                this.Head=null;
            }
            else if (padre.getHijoIz()==actual){
                padre.setHijoIz(null);
            }
            else{
                padre.setHijoDer(null);
            }
        }
        //Caso 2
        else if (actual.getHijoIz()==null){
            if (actual==this.Head){
                this.Head=actual.getHijoIz();
            }
            else if (padre.getHijoIz()==actual){
                padre.setHijoIz(actual.getHijoDer());
            }
            else{
                padre.setHijoDer(actual.getHijoDer());
            }
        }
        else if (actual.getHijoDer()==null){
            if (actual==this.Head){
                this.Head=actual.getHijoDer();
            }
            else if (padre.getHijoIz()==actual){
                padre.setHijoIz(actual.getHijoIz());
            }
            else{
                padre.setHijoDer(actual.getHijoIz());
            }
        }
        //Caso 3
        else{
            Dragon tmpPadre=padre;
            Dragon tmpHijo=actual;

            actual=actual.getHijoDer();
            while (actual.getHijoIz()!=null){
                actual=actual.getHijoIz();
            }

            padre=actual.getPadre();
            if (actual==this.Head){
                this.Head=actual.getHijoIz();
            }
            else if (padre.getHijoIz()==actual){
                padre.setHijoIz(actual.getHijoDer());
            }
            else{
                padre.setHijoDer(actual.getHijoDer());
            }
            actual.setHijoDer(tmpHijo.getHijoDer());
            actual.setHijoIz(tmpHijo.getHijoIz());

            if (tmpPadre != null) {
                if (tmpPadre.getHijoIz()==tmpHijo){
                    tmpPadre.setHijoIz(actual);
                }
                else{
                    tmpPadre.setHijoDer(actual);
                }
            }
            else{
                this.Head=actual;
            }
        }
        CantidadDeDragones--;
    }

    public void display() {
        System.out.println("CABEZA: "+this.Head);
        display(this.Head);
    }

    public void display(Dragon head){
        if (head!=null){
            display(head.getHijoIz());
            System.out.println(head+" Hijo derecho: "+head.getHijoDer()+ " Hijo izquierdo: "+ head.getHijoIz());
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

}