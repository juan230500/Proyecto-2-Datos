package juego;

import adt.AVLTree;
import adt.LinkedList;
import adt.Node;
import adt.SortArray;
import juego.Dragon;
import juego.DragonesFabrica;
import servidor.Cliente;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JLabel;

import org.jdom2.JDOMException;

import GUI.Fondo;

public class Oleada {
    private Dragon root;
    private int CantidadDragones;
    private int Formacion;
    private int edadt;
    private Dragon[] DragonesDibujar;
    private Node rootAVL;
    private boolean EdadRepetida;
	private Fondo fondo1;
	private Caballero caballero;


    /**
     * Constructor de las oleadas que toma la cantidad deseada y se apoya en genDragones
     * La oleada solo guarda la referencia a su dragon Head (sin padre) el resto se acceden desde sus padres
     * @param Cantidad numero de dragones que se espera en la oleada inicial
     */
    public Oleada(int Cantidad,int ronda, Fondo fondo, Caballero jugador) {
        this.CantidadDragones=0;
        //Bloque para generar los dragones automaticamente con un padre asignado a solo 2 de ellos
        this.Formacion=-1;
        this.edadt=0;
        this.fondo1 = fondo;
        this.caballero = jugador;
        new DragonesFabrica(Cantidad, ronda, this);

        
        this.DragonesDibujar = toArray();
        
        AVLTree tree=new AVLTree();
        InsertarEnAVl(tree);
        rootAVL=tree.getRoot();
    }
    
    public Oleada(int Cantidad,int ronda) {
        this.CantidadDragones=0;
        //Bloque para generar los dragones automaticamente con un padre asignado a solo 2 de ellos
        this.Formacion=-1;
        this.edadt=0;
        new DragonesFabrica(Cantidad, ronda, this);
        this.DragonesDibujar = toArray();
        AVLTree tree=new AVLTree();
        InsertarEnAVl(tree);
        rootAVL=tree.getRoot();
    }
    
    public Oleada() {
    	this.DragonesDibujar=new Dragon[0];
    }
    

    /**
     * Método que toma la cabeza de la oleada y se asegura de crear el resto de dragones con un padre
     * y que los padres tengan menos de un hijo
     * @param Cantidad
     */
    private void genDragones(int Cantidad){
        while (Cantidad>0){
            this.EdadRepetida=false;
            add(new Dragon());
            if (!EdadRepetida)
                Cantidad--;
        }
    }

    public int getFormacion() {
        return Formacion;
    }

    /**
     * Se activa cuando un dragón es impactado y recurre a uno de sus métodos
     * para reducir su resistencia y si muere se aplica una eliminación y se realinea la oleada
     * @param Herido
     */
    public int HerirDragon(Dragon Herido){
        if (Herido==null){
            return -1;
        }
        boolean Realinear=Herido.RecibirDano();
        if (Realinear){
        	this.Formacion++;
        	int criterio=this.Formacion%5;
        	Cliente C2=new Cliente(false);
    		
    		Oleada O=this;
    		
    		O.display();
    		
    		Dragon D[]=O.toArray();
    		
    		System.out.println(Arrays.toString(D));
    		
			System.out.println(O.getCantidadDragones());
			Oleada nueva=new Oleada();
			try {
				nueva = C2.RequestAlineacion(O, criterio, Herido);
			} catch (JDOMException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("@@@");
			Dragon[] ArrayD=nueva.getDragonesDibujar();
			Node RootAVL=nueva.getRootAVL();
			
			if (nueva.getCantidadDragones()==1) {
				O.setDragonesDibujar(ArrayD);
				O.setRootAVL(nueva.getRootAVL());
			}
			else {
				if (ArrayD!=null) {
					O.setDragonesDibujar(ArrayD);
				}
				if (RootAVL!=null) {
					O.setRootAVL(nueva.getRootAVL());
				}
			}
			O.setCantidadDragones(nueva.getCantidadDragones());
			O.setRoot(nueva.getRoot());
            //Se elimina el dragón y se le asigna otro padre o otros hijos
        	
            /*delete(Herido);
            this.CantidadDragones--;
            if (this.CantidadDragones==0) {
            	return 5;
            }*/
			
            return criterio;
            //return Realinear(this.Formacion%5);
        }
        return 5;
    }

    public Dragon[] getDragonesDibujar() {
        return DragonesDibujar;
    }

    public Node getRootAVL() {
        return rootAVL;
    }

    /**
     * Dada la formacción actual con el dragon ya eliminado
     * decide cual será el siguiente criterio de ordenamiento
     * por ahora imprime la alineacion de dragones resultante
     * pero no cambia nada de los dragones ya que no es necesario
     */
    public int Realinear(int criterio){
        //AVL
        if (criterio==4){
            AVLTree tree=new AVLTree();
            InsertarEnAVl(tree);
            //No es necesario hacer delete en AVL porque simplemente ese dragón no se inserta en el nuevo AVL
            tree.preOrder();
            //display de AVL
            rootAVL=tree.getRoot();
            return 4;
        }
        //Familias
        else if(criterio==3){
            //Display de familias
            displayFamilias();
            return 3;
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
            DragonesDibujar=ArrayOrdenar.getArr();
            return 0;
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
            if (node.getPadre()==null){
                System.out.println(node.getNombre()
                        +" Edad: "+node.getEdad()
                        +" Recarga "+node.getRecarga()
                        +" Resistencia "+node.getResistencia()
                        +" Hijo de "+node.getPadre()
                        +" Y: "+node.getPosY()
                        +" Nivel: "+node.getPosX());
            }
            else{
                System.out.println(node.getNombre()
                        +" Edad: "+node.getEdad()
                        +" Recarga "+node.getRecarga()
                        +" Resistencia "+node.getResistencia()
                        +" Hijo de "+node.getPadre().getEdad()
                        +" Y: "+node.getPosY()
                        +" Nivel: "+node.getPosX());
            }

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
            this.EdadRepetida=true;
            return current;
        }
        return current;
    }

    public void add(Dragon value) {
        this.CantidadDragones++;
        root = addRecursive(root, value);
    }

    public Dragon MasCercanoPorAltura(int Y){
        int AnchoDefault=25;
        List<Dragon> ListaDragones= FiltrarPorAltura(Y,AnchoDefault);
        int largo=ListaDragones.size();
        if (largo==0){
            return null;
        }
        Dragon MasCercano=ListaDragones.get(0);
        Dragon DragonAux;
        for (int i=0;i<largo;i++){
            DragonAux=ListaDragones.get(i);
            if (DragonAux.getLabel().getX()<MasCercano.getLabel().getX())
                MasCercano=DragonAux;
        }
        return MasCercano;
    }

    private List<Dragon> FiltrarPorAltura(int Y, int ancho){
        List<Dragon> ListaDragones=new ArrayList<>();
        AddPorAltura(Y,ancho,this.root,ListaDragones);
        return ListaDragones;
    }

    private void AddPorAltura(int Y,int ancho,Dragon root,List<Dragon> ListaDragones){
        if (root!=null){
            AddPorAltura(Y,ancho,root.getHijoIz(),ListaDragones);
            int altura=root.getPosY();

            if (Y>=altura-5 && Y<=altura+ancho){
                ListaDragones.add(root);
            }
            AddPorAltura(Y,ancho,root.getHijoDer(),ListaDragones);
        }
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

    public void ataqueDragones(){
        for(int i = 0; i < CantidadDragones; i++){
            JLabel dragon = this.toArray()[i].getLabel();
            MoverDisparo(dragon, caballero, fondo1);
        }
    }

    public void MoverDisparo (JLabel dra, Caballero caballero, Fondo fondo) {
        JLabel grifo = caballero.getLabel();
        JLabel disp = new JLabel();
        disp.setText("O");
        System.out.println("disparo");
        disp.setBounds(dra.getX() - 10, dra.getY() + 25, 10, 10);
        fondo.add(disp);
        if ((disp.getX() > grifo.getX() + grifo.getWidth()) || (disp.getY() > grifo.getY() + grifo.getHeight()) || (disp.getX() < grifo.getX()) || (disp.getY() < grifo.getY())) {
            disp.setBounds(disp.getX() - 5, disp.getY(), 10, 10);
        } else {
            caballero.recibir_daño();
            disp.setBounds(1400, 1000, 10, 10);
        }
        disp.setVisible(true);
    }

	public void setRoot(Dragon root) {
		this.root = root;
	}

	public void setCantidadDragones(int cantidadDragones) {
		CantidadDragones = cantidadDragones;
	}

	public void setDragonesDibujar(Dragon[] dragonesDibujar) {
		DragonesDibujar = dragonesDibujar;
	}

	public void setRootAVL(Node rootAVL) {
		this.rootAVL = rootAVL;
	}
    
    
}

