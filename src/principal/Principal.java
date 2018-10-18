package principal;

import juego.Dragon;
import juego.Oleada;

import java.util.Arrays;

public class Principal {
    public static void main(String[] args){
        System.out.println("Hola 2");
        Oleada G=new Oleada(8);

        Dragon[] D=G.toArray();
        System.out.println(Arrays.toString(D));
        G.display();
        G.HerirDragon(D[0]);
        G.HerirDragon(D[0]);
        G.HerirDragon(D[0]);
        G.HerirDragon(D[1]);
        G.HerirDragon(D[1]);
        G.HerirDragon(D[1]);
    }
}


