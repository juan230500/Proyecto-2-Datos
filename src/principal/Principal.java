package principal;

import adt.Binary_tree;

public class Principal {
    public static void main(String[] args){
        System.out.println("Hola 2");
        Binary_tree B1=new Binary_tree();
        B1.insert(1);
        B1.insert(2);
        B1.insert(0);
        B1.display(B1.root);
    }
}
