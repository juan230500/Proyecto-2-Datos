package adt;

import juego.Dragon;

public class Oleada {
    private Dragon root;
    private int CantidadDragones;
    private int Formacion;
    private int edadt;

    /**
     * Constructor de las oleadas que toma la cantidad deseada y se apoya en genDragones
     * La oleada solo guarda la referencia a su dragon Head (sin padre) el resto se acceden desde sus padres
     * @param Cantidad numero de dragones que se espera en la oleada inicial
     */
    public Oleada(int Cantidad) {
        this.CantidadDragones=0;
        //Bloque para generar los dragones automaticamente con un padre asignado a solo 2 de ellos
        this.Formacion=-1;
        this.edadt=0;
        genDragones(Cantidad);
    }

    /**
     * Método que toma la cabeza de la oleada y se asegura de crear el resto de dragones con un padre
     * y que los padres tengan menos de un hijo
     * @param Cantidad
     */
    private void genDragones(int Cantidad){
        while (Cantidad>0){
            add(new Dragon());
            Cantidad--;
        }
    }

    /**
     * Se activa cuando un dragón es impactado y recurre a uno de sus métodos
     * para reducir su resistencia y si muere se aplica una eliminación y se realinea la oleada
     * @param Herido
     */
    public void HerirDragon(Dragon Herido){
        if (Herido==null){
            return;
        }
        boolean Realinear=Herido.RecibirDano();
        if (Realinear){
            //Se elimina el dragón y se le asigna otro padre o otros hijos
            delete(Herido);
            this.CantidadDragones--;
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
            //Display de familias
            displayFamilias();
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
     * Hace un print de la edad del dragon y su respectivo padre para asegurarse que lo muestra correctamente
     */
    public void displayFamilias() {
        displayFamilias(this.root,0);
        System.out.println();
    }

    public void displayFamilias(Dragon node, int nivel) {
        if (node != null) {
            displayFamilias(node.getHijoIz(),nivel+1);
            System.out.print(" " + node.getEdad()+"("+node.getPadre()+")");
            displayFamilias(node.getHijoDer(),nivel+1);
        }
    }

    /**
     * Imprime todos los dragones actuales y sus caracteristicas importantes
     */
    public void display() {
        display(this.root,0);
        System.out.println();
    }

    public void display(Dragon node, int nivel) {
        if (node != null) {
            display(node.getHijoIz(),nivel+1);
            System.out.println(node
                    +" Edad: "+node.getEdad()
                    +" Recarga "+node.getRecarga()
                    +" Resistencia "+node.getResistencia()
                    +" Hijo de "+node.getPadre());
            display(node.getHijoDer(),nivel+1);
        }
    }


    Dragon addRecursive(Dragon current, Dragon value) {
        if (current == null) {
            return value;
        }
        if (value.getEdad() < current.getEdad()) {
            current.setHijoIz(addRecursive(current.getHijoIz(), value));
        } else if (value.getEdad() > current.getEdad()) {
            current.setHijoDer(addRecursive(current.getHijoDer(), value));
        } else {
            this.CantidadDragones--;
            return current;
        }
        return current;
    }

    public void add(Dragon value) {
        root = addRecursive(root, value);
        this.CantidadDragones++;
    }

    boolean containsNodeRecursive(Dragon current, Dragon value) {
        if (current == null) {
            return false;
        }
        if (value == current) {
            return true;
        }
        return value.getEdad() < current.getEdad()
                ? containsNodeRecursive(current.getHijoIz(), value)
                : containsNodeRecursive(current.getHijoDer(), value);
    }

    public boolean containsNode(Dragon value) {
        return containsNodeRecursive(root, value);
    }


    public void delete(Dragon Herido){
        Dragon padre=Herido.getPadre();
        boolean isHijoIz=true;

        if (padre!=null){
            if (padre.getHijoIz()==Herido){
                isHijoIz=true;
            }
            else{
                isHijoIz=false;
            }
        }

        if (Herido.getHijoDer()==null && Herido.getHijoIz()==null){
            if (padre==null){
                this.root=null;
            }
            else if (isHijoIz){
                padre.setHijoIz(null);
            }
            else {
                padre.setHijoDer(null);
            }
            return;
        }

        if (Herido.getHijoDer()==null){
            if (padre==null){
                this.root=Herido.getHijoIz();
                this.root.setPadre(null);
            }
            else if (isHijoIz){
                padre.setHijoIz(Herido.getHijoIz());
            }
            else{
                padre.setHijoDer(Herido.getHijoIz());
            }
            return;
        }
        if (Herido.getHijoIz()==null){
            if (padre==null){
                this.root=Herido.getHijoDer();
                this.root.setPadre(null);
            }
            else if (isHijoIz){
                padre.setHijoIz(Herido.getHijoDer());
            }
            else{
                padre.setHijoDer(Herido.getHijoDer());
            }
        }

        else{
            Dragon minv = Herido.getHijoDer();
            while (minv.getHijoIz() != null)
            {
                minv = minv.getHijoIz();
            }
            delete(minv);
            minv.setHijoDer(Herido.getHijoDer());
            minv.setHijoIz(Herido.getHijoIz());

            if (padre==null){
                minv.setPadre(null);
                this.root=minv;
            }
            else if (isHijoIz){
                padre.setHijoIz(minv);
            }
            else{
                padre.setHijoDer(minv);
            }

        }
    }


    public void traverseInOrder() {
        traverseInOrder(this.root,0);
        System.out.println();
    }

    public void traverseInOrder(Dragon node,int nivel) {
        if (node != null) {
            traverseInOrder(node.getHijoIz(),nivel+1);
            System.out.print(" " + node.getEdad()+"("+nivel+")");
            traverseInOrder(node.getHijoDer(),nivel+1);
        }
    }


    /**
     * Pasa los dragones acutales de la oleada a un Array
     * para realizar los ordenamientos selection,quicksort...
     * @return Array de los dragones actuales
     */
    public Dragon[] toArray(){
        Dragon[] ArrayDragones=new Dragon[this.CantidadDragones];
        if (this.root == null) {
            return ArrayDragones;
        }
        extractValues(this.root,ArrayDragones,0);
        return ArrayDragones;
    }

    public void makeArray(Dragon node, int i, Dragon [] BSTarray ) {
        if (node != null) {
            BSTarray[i] = root;
            makeArray(node.getHijoIz(), 2*i+1, BSTarray);
            makeArray(node.getHijoDer(), 2*i+2, BSTarray);
        }
    }

    private static int extractValues(Dragon n, Dragon[] results, int index) {
        if (n.getHijoIz() != null) {
            index = extractValues(n.getHijoIz(), results, index);
        }

        if (n.getHijoDer() != null) {
            index = extractValues(n.getHijoDer(), results, index);
        }

        results[index] = n;

        return index + 1;
    }

    /**
     * Sirve para insertar todos los elementos de la oleada desde el HEAD
     * en un AVL que los ordenará automáticamente
     */
    private void InsertarEnAVlrecursivo(Dragon node,AVLTree tree) {
        if (node != null) {
            InsertarEnAVlrecursivo(node.getHijoIz(),tree);
            tree.insert(node);
            InsertarEnAVlrecursivo(node.getHijoDer(),tree);
        }
    }

    /**
     * Sirve para insertar todos los elementos de la oleada desde el HEAD
     * en un AVL que los ordenará automáticamente
     * @param tree
     */
    public void InsertarEnAVl(AVLTree tree){
        InsertarEnAVlrecursivo(this.root,tree);
    }

    public int getCantidadDragones() {
        return CantidadDragones;
    }

    public Dragon getRoot() {
        return root;
    }
}

