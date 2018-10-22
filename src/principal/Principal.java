package principal;

import adt.Oleada;
import juego.Dragon;

import java.util.Arrays;

public class Principal {
    public static void main(String[] args){
        System.out.println("Hola 2");

        Oleada O=new Oleada(4);
        Dragon[] D=O.toArray();
        System.out.println(Arrays.toString(D));
        O.display();
        /*int i=5;
        while (i>0){
            O.HerirDragon(O.getRoot());
            O.HerirDragon(O.getRoot());
            O.display();
            i--;
        }*/

        D[0].setPosY(60);
        System.out.println(O.MasCercanoPorAltura(30));

    }
}


