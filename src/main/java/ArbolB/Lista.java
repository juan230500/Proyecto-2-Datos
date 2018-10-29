package ArbolB;

import java.util.ArrayList;
/**
 * La clase Lista sirve tener un ArrayList para
 * el arbol B
 * Esta clase fue sacada del repositorio https://github.com/maestro252/Arbol-B
 * @version 1.0
 * @since    3 Dec 2013
 */
public class Lista
{
    // instance variables - replace the example below with your own
    public static ArrayList<Integer> ingresados;

    /**
     * Este metodo es el constructor para crear objetos de la clase Lista
     *
     */
    public Lista()
    {
        ingresados = new ArrayList<Integer>();
    }
    public boolean buscar(int valor){
        boolean esta = false;
        for (int i = 0; i < ingresados.size() && !esta; i++){
            if (ingresados.get(i) == valor){
                esta = true;

            }
        }
        return esta;

    }
}