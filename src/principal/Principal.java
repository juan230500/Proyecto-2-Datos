package principal;

import adt.Oleada;
import juego.Dragon;

import java.util.Arrays;

public class Principal {
    public static void main(String[] args){
        System.out.println("Hola 2");

        Oleada O=new Oleada(10);
        Dragon[] D=O.toArray();
        System.out.println(Arrays.toString(D));
        O.display();
        O.traverseInOrder();

        O.HerirDragon(D[0]);
        O.HerirDragon(D[0]);
        O.HerirDragon(D[1]);
        O.HerirDragon(D[1]);
        O.HerirDragon(D[2]);
        O.HerirDragon(D[2]);
        O.HerirDragon(D[3]);
        O.HerirDragon(D[3]);

    }
}


