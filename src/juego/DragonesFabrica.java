package juego;

import adt.LinkedList;
import adt.ABB;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Random;
/**
 * ESta calse se encarga de asignar las caracteristicas a los dragones de la oleada
 */
public class DragonesFabrica {
    private LinkedList dragonestmp = new LinkedList();
    private ABB arbol_edades = new ABB();
    private HashMap letras = new HashMap();
    private Dragon capi_aux;
    /**
     * este metodo es el constructor de la clase
     * @param cantidad es la cantidad de dragones a crear
     * @param ronda este establece   la ronda  en la cual se van a crear los dragones
     * @param oleada este es el  valor de la oleada entrante
     */
    public DragonesFabrica(int cantidad, int ronda, Oleada oleada){
        letras.put("voc","AEIOU");
        letras.put("con","BCDFGJKLMNPRSTVWYZ");
        letras.put("abc", "ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        int c = 1;

        while (cantidad > 0){
            Dragon dragon = new Dragon();

            asignarNombre(ronda, c, dragon);
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
        }
    }

    /**
     * este metodo funciona para realizar  las asiganciones de nombre a los dragones
     * @param ronda  sirve para ver en cual ronda se van a generar los nombres
     * @param dragon es el obejto dragon al cual se le va asignar el nombre
     * @param c ayuda a le genracion de nombre concantenando
     */
    public  void asignarNombre(int ronda, int c, Dragon dragon){
        Random random = new Random();
        String gen = letras.get("abc").toString().substring(ronda-1, ronda);
        String res = gen.concat(Integer.toString(c));
        dragon.setNombre(res);
    }
    /**
     * este metodo funciona para realizar las asignaciones de recarga a los dragones
     * @param dragon es el obejto dragon al cual se le va asignar el  valor
     */
    public void asignarRecarga(Dragon dragon){
        Random random = new Random();
        dragon.setRecarga(random.nextInt(100) + 1);
    }
    /**
     * este metodo funciona para realizar las asignaciones de resitencia a los dragones
     * @param dragon es el obejto dragon al cual se le va asignar el  valor
     */
    public void asignarResistencia(Dragon dragon) {
        Random random = new Random();
        dragon.setResistencia(random.nextInt(3) + 1);
    }
    /**
     * este metodo funciona para realizar las asignaciones de edad a los dragones
     * @param dragon es el obejto dragon al cual se le va asignar el  valor
     */
    public void asignarEdad(Dragon dragon){
        Random random = new Random();
        int edad = (random.nextInt(1000) + 1);
        while (arbol_edades.buscar(edad) != null){
            edad = (random.nextInt(1000) + 1);
        }
        arbol_edades.insertar(edad);
        dragon.setEdad(edad);
    }
    /**
     * este metodo funciona para realizar las asignaciones de clase a los dragones
     * @param dragon es el obejto dragon al cual se le va asignar el  valor
     */
    public void asignarClase(int c, int cantidad, Dragon dragon){
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

}
