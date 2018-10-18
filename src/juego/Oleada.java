package juego;


import adt.AVLTree;
import adt.SortArray;

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

    /**
     * Constructor de las oleadas que toma la cantidad deseada y se apoya en genDragones
     * La oleada solo guarda la referencia a su dragon Head (sin padre) el resto se acceden desde sus padres
     * @param Cantidad numero de dragones que se espera en la oleada inicial
     */
    public Oleada(int Cantidad) {
        this.CantidadDeDragones=Cantidad;
        //Bloque para generar los dragones automaticamente con un padre asignado a solo 2 de ellos
        this.root =new Dragon();
        this.Formacion=-1;
        genDragones(Cantidad);
    }

    /**
     * Método que toma la cabeza de la oleada y se asegura de crear el resto de dragones con un padre
     * y que los padres tengan menos de un hijo
     * @param Cantidad
     */
    private void genDragones(int Cantidad){
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

    /**
     * Sirve para insertar todos los elementos de la oleada desde el HEAD
     * en un AVL que los ordenará automáticamente
     * @param tree
     */
    private void InsertarEnAVl(AVLTree tree){
        Dragon tmp=this.root;
        while (tmp!=null){
            tree.insert(tmp);
            tmp=tmp.getHijoIz();
        }
    }

    /**
     * Se activa cuando un dragón es impactado y recurre a uno de sus métodos
     * para reducir su resistencia y si muere se aplica una eliminación y se realinea la oleada
     * @param Herido
     */
    public void HerirDragon(Dragon Herido){
        boolean Realinear=Herido.RecibirDano();
        if (Realinear){
            //Se elimina el dragón y se le asigna otro padre o otros hijos
            this.Eliminar(Herido);
            Realinear();
        }
    }

    /**
     * Dada la formacción actual con el dragon ya eliminado
     * decide cual será el siguiente criterio de ordenamiento
     * por ahora imprime la alineacion de dragones resultante
     * pero no cambia nada de los dragones ya que no es necesario
     */
    public void Realinear(){
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

    /**
     * Tomando como partida el Head busca el Dragon a eliminar
     * y quita su referencia y reduce la catnidad de dragones
     * @param DragonEliminar dragon muerto
     */
    private void Eliminar(Dragon DragonEliminar){
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
    }

    /**
     * Hace un print de la edad del dragon y su respectivo padre para asegurarse que lo muestra correctamente
     */
    private void displayFamilia(){
        Dragon tmp=this.root;
        while (tmp!=null){
            System.out.print(tmp.getEdad()+" Hijo de "+tmp.getPadre()+" - ");
            tmp=tmp.getHijoIz();
        }
        System.out.println();
    }

    /**
     * Imprime todos los dragones actuales y sus caracteristicas importantes
     */
    public void display(){
        Dragon tmp=this.root;
        while (tmp!=null){
            System.out.println(tmp
                    +" Edad: "+tmp.getEdad()
                    +" Recarga "+tmp.getRecarga()
                    +" Resistencia "+tmp.getResistencia()
                    +" Hijo de "+tmp.getPadre());
            tmp=tmp.getHijoIz();
        }
    }

    /**
     * Pasa los dragones acutales de la oleada a un Array
     * para realizar los ordenamientos selection,quicksort...
     * @return Array de los dragones actuales
     */
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