package principal;

import adt.AVLTree;
import adt.Node;
import juego.Dragon;
import juego.Oleada;

import java.util.Arrays;

public class Principal {
    public static void main(String[] args){
        System.out.println("Hola 2");
        Oleada G=new Oleada(10);

        Dragon[] D=G.toArray();
        System.out.println(Arrays.toString(D));
        G.display();
        G.Realinear(D[0]);
        G.Realinear(D[1]);
        G.Realinear(D[2]);
        G.Realinear(D[3]);
        G.Realinear(D[4]);
        G.Realinear(D[5]);
    }
}


