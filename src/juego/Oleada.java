package juego;


public class Oleada {
    private int CantidadDeDragones;
    /*
        Criterio:
        -1 desorden
        0-Selection edad
        1-Insertion velocidad
        2-Quick edad
        3-ABB familias
        4-AVL edad
    */
    private int Formacion;

    private Dragon root;

    public Oleada(int Cantidad) {
        this.CantidadDeDragones=Cantidad;
        //Bloque para generar los dragones automaticamente con un padre asignado a solo 2 de ellos
        this.root =new Dragon();
        genDragones(Cantidad);
        this.Formacion=-1;

    }

    void genDragones(int Cantidad){
        Dragon actual=this.root;
        Dragon tmp;
        Cantidad--;
        while (Cantidad>0){
            tmp=new Dragon();
            actual.setHijoIz(tmp);
            actual=tmp;
            Cantidad--;
        }
    }

    public void Realinear(Dragon muerto){
        //Se elimina el dragón y se le asigna otro padre o otros hijos
        this.Eliminar(muerto);
        this.Formacion++;

        int criterio=Formacion%5;
        //AVL
        if (criterio==4){

        }
        //Familias
        else if(criterio==3){

        }
        //QuickSort
        else if (criterio == 2) {

        }
        //InsertionSort
        else if (criterio == 1) {

        }
        //SelectionSort
        else {

        }
    }

    public void Eliminar(Dragon DragonEliminar){
        Dragon tmp=this.root;
        this.CantidadDeDragones--;
        while (tmp!=null){
            if (tmp==DragonEliminar){
                Dragon tmp2=tmp.getPadre();
                tmp2.setHijoIz(tmp.getHijoIz());
                return;
            }
            tmp=tmp.getHijoIz();
        }
        return;
    }


    public void display(){
        Dragon tmp=this.root;
        while (tmp!=null){
            System.out.print(",\n"+tmp);
            tmp=tmp.getHijoIz();
        }
        System.out.println();

    }


    public Dragon[] toArray() {
        Dragon[] ArrayDragones=new Dragon[CantidadDeDragones];
        Dragon tmp=this.root;
        int i=0;
        while (tmp!=null){
            ArrayDragones[i]=tmp;
            i++;
            tmp=tmp.getHijoIz();
        }
        return ArrayDragones;
    }

    public void aumentarOleada() {
    }

}