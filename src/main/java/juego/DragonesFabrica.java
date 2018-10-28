package juego;

import adt.LinkedList;
import adt.ABB;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Random;

public class DragonesFabrica {

    private LinkedList lista_dragones = new LinkedList();
    private LinkedList dragonestmp = new LinkedList();
    private ABB arbol_edades = new ABB();
    private HashMap letras = new HashMap();
    private Dragon capi_aux;

    public DragonesFabrica(int cantidad, int ronda, Oleada oleada){
        letras.put("voc","AEIOU");
        letras.put("con","BCDFGJKLMNPRSTVWYZ");
        letras.put("abc", "ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        int c = 1;

        while (cantidad > 0){
            final Dragon dragon = new Dragon();

            asignarNombre(ronda, c, dragon);
            asignarPadres(c,dragon);
            asignarRecarga(dragon);
            asignarResistencia(dragon);
            asignarEdad(dragon);
            asignarClase(c, cantidad, dragon);
            dragon.getLabel().setText(dragon.getNombre());
            dragon.getLabel().addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                    dragon.setClick(true);
                }
            });
            cantidad --;
            c++;

            oleada.add(dragon);
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

    public  void asignarNombre(int ronda, int c, Dragon dragon){
        Random random = new Random();
        String gen = letras.get("abc").toString().substring(ronda-1, ronda);
        String res = gen.concat(Integer.toString(c)+"_");
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
        dragon.setRecarga(random.nextInt(100) + 1);
    }

    private void asignarResistencia(Dragon dragon) {
        Random random = new Random();
        dragon.setResistencia(random.nextInt(3) + 1);
    }

    private void asignarEdad(Dragon dragon){
        Random random = new Random();
        int edad = (random.nextInt(1000) + 1);
        while (arbol_edades.buscar(edad) != null){
            edad = (random.nextInt(1000) + 1);
        }
        arbol_edades.insertar(edad);
        dragon.setEdad(edad);
    }

    private void asignarClase(int c, int cantidad, Dragon dragon){
        if ((cantidad == 1) && (dragonestmp.size() != 0)){
            for (int i = 0; i < dragonestmp.getSize(); i++) {
                Dragon tmp = (Dragon) dragonestmp.recorrer(i);
                capi_aux.setDragones_asignados(tmp);
            }
        }else{
            if (c == 1) {
                dragon.setClase("General");
            } else {
                if ((c % 5) == 0) {
                    if (c == 5) {
                        dragon.setClase("Capitán");
                        capi_aux = dragon;
                        for (int i = 0; i < dragonestmp.getSize(); i++) {
                            Dragon tmp = (Dragon) dragonestmp.recorrer(i);
                            dragon.setDragones_asignados(tmp);
                        }
                        dragonestmp = new LinkedList();
                    } else {
                        dragon.setClase("Capitán");
                        for (int i = 0; i < dragonestmp.getSize(); i++) {
                            Dragon tmp = (Dragon) dragonestmp.recorrer(i);
                            dragon.setDragones_asignados(tmp);
                        }
                        dragonestmp = new LinkedList();
                    }
                } else {
                    dragon.setClase("Infantería");
                    dragonestmp.insertFirst(dragon);
                }
            }
        }
    }

    public LinkedList getLista_dragones() {
        return lista_dragones;
    }
}
