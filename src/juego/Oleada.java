package juego;


import adt.AVLTree;
import adt.SortArray;

import java.util.Arrays;

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
        this.Formacion=-1;
        genDragones(Cantidad);
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

    void InsertarEnAVl(AVLTree tree){
        Dragon tmp=this.root;
        while (tmp!=null){
            tree.insert(tmp);
            tmp=tmp.getHijoIz();
        }
    }

    public void Realinear(Dragon muerto){
        //Se elimina el dragón y se le asigna otro padre o otros hijos
        this.Eliminar(muerto);
        this.Formacion++;

        int criterio=Formacion%5;
        //AVL
        if (criterio==4){
            AVLTree tree=new AVLTree();
            InsertarEnAVl(tree);
            //No es necesario hacer delete en AVL porque simplemente ese dragón no se inserta en el nuevo AVL
            tree.preOrder();
            //display de AVL
        }
        //Familias
        else if(criterio==3){
            displayFamilia();
            //Display de familias

        }

        else {
            SortArray ArrayOrdenar=new SortArray(this.toArray());
            //QuickSort
            if (criterio == 2) {
                System.out.println("ANTES DE QUICK: "+ArrayOrdenar.toString());
                ArrayOrdenar.quickSort();
                System.out.println("DESPUÉS DE QUICK: "+ArrayOrdenar.toString());
            }
            //InsertionSort
            else if (criterio == 1) {
                System.out.println("ANTES DE INSERTION: "+ArrayOrdenar.toString());
                ArrayOrdenar.InsertionSort();
                System.out.println("DESPUÉS DE INSERTION: "+ArrayOrdenar.toString());
            }
            //SelectionSort
            else {
                System.out.println("ANTES DE SELECTION: "+ArrayOrdenar.toString());
                ArrayOrdenar.SelectionSort();
                System.out.println("DESPUÉS DE SELECTION: "+ArrayOrdenar.toString());
            }
            //Display del array (lineal)
        }
    }

    public void Eliminar(Dragon DragonEliminar){
        this.CantidadDeDragones--;
        if (DragonEliminar==this.root){
            this.root=this.root.getHijoIz();
            this.root.setPadre(null);
            return;
        }
        Dragon tmp=this.root;
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

    void displayFamilia(){
        Dragon tmp=this.root;
        while (tmp!=null){
            System.out.print(tmp.getEdad()+" Hijo de "+tmp.getPadre()+" - ");
            tmp=tmp.getHijoIz();
        }
        System.out.println();
    }

    public void display(){
        Dragon tmp=this.root;
        while (tmp!=null){
            System.out.println(tmp+" Edad: "+tmp.getEdad()+" Recarga "+tmp.getRecarga()+" Hijo de "+tmp.getPadre());
            tmp=tmp.getHijoIz();
        }
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