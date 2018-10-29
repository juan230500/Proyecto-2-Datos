package ArbolB;
/**
 * La clase Nodo sirve   para la funcionalidad de
 * el arbol B
 * Esta clase fue sacada del repositorio https://github.com/maestro252/Arbol-B
 * @version 1.0
 * @since    3 Dec 2013
 */

public class Nodo
{
    public int []valores;
    public Nodo []nodo;
    public static int numValores;
    public boolean tengoHijos = false;
    public int ocupados = 0;
    public Nodo padre;
    public Nodo(){
        nodo = new Nodo [Raiz.grado * 2 + 3];
        valores = new int [Raiz.grado * 2 + 1];
    }

}