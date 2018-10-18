package principal;

import juego.Dragon;
import juego.Oleada;

import java.util.Arrays;

public class Principal {
    public static void main(String[] args){
        System.out.println("Hola 2");
        Oleada G=new Oleada(15);

        Dragon[] D=G.toArray();
        System.out.println(Arrays.toString(D));
        G.Eliminar(D[2]);
        G.display();
    }
}


