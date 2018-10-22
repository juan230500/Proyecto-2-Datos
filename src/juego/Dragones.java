package juego;

import adt.LinkedList;

import java.util.HashMap;
import java.util.Random;

public class Dragones {

    private LinkedList lista_dragones = new LinkedList();
    private LinkedList edades = new LinkedList();
    private HashMap letras = new HashMap();

    public Dragones(int cantidad){
        letras.put("voc","AEIOU");
        letras.put("con","BCDFGJKLMNPRSTVWYZ");
        int c = 1;

        while (cantidad > 0){
            Dragon dragon = new Dragon();

            asignarNombre(dragon);
            asignarPadres(c,dragon);
            asignarRecarga(dragon);
            asignarResistencia(dragon);
            asignarEdad(dragon);

            cantidad --;
            c++;

            lista_dragones.insertLast(dragon);
        }
    }

    private void asignarPadres(int c, Dragon dragon){
        if (c == 1){
            dragon.setPadre(null);

        }else{
            Random random = new Random();
            Dragon aleatorio = (Dragon) lista_dragones.recorrer(random.nextInt(lista_dragones.getSize()));
            if (aleatorio.getHijos().getSize() < 2) {
                dragon.setPadre(aleatorio);
                aleatorio.setHijo(dragon);
            } else{
                asignarPadres(c,dragon);
            }
        }

    }

    public  void asignarNombre(Dragon dragon){
        Random random = new Random();
        String res = "";
        for (int i = 3; i > 0; i--){
            int r1 = random.nextInt(17);
            int r2 = random.nextInt(4);
            String letra1 = letras.get("con").toString().substring(r1, r1 + 1);
            String letra2 = letras.get("voc").toString().substring(r2, r2 + 1);
            String letras = letra1.concat(letra2);
            res = res.concat(letras);
        }
        dragon.setNombre(res);
    }

    private void asignarRecarga(Dragon dragon){
        Random random = new Random();
        dragon.setRecarga(random.nextInt(100)+1);
    }

    private void asignarResistencia(Dragon dragon) {
        Random random = new Random();
        dragon.setResistencia(random.nextInt(3) + 1);
    }

    private void asignarEdad(Dragon dragon){
        Random random = new Random();
        int edad = (random.nextInt(1000)+1);
        dragon.setEdad(edad);
    }

    public LinkedList getLista_dragones() {
        return lista_dragones;
    }
}
