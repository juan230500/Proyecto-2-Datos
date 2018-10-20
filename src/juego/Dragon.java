package juego;

import java.util.concurrent.ThreadLocalRandom;

/**
 * 
 */
public class Dragon {

    /**
     * Default constructor
     */

    public Dragon(int edadt) {
        //para probar lógica
        this.edad= edadt=ThreadLocalRandom.current().nextInt(1, 1000);
        this.recarga=ThreadLocalRandom.current().nextInt(1, 100);
        //Probar eliminación
        this.resistencia=ThreadLocalRandom.current().nextInt(1,3);
    }

    /**
     * 
     */
    private String nombre;

    /**
     * 
     */
    private int recarga;

    /**
     * 
     */
    private int edad;

    /**
     * 
     */
    private int resistencia;

    /**
     * 
     */
    private String clase;

    /**
     * 
     */
    private Dragon padre;

    /**
     * 
     */
    private Dragon hijoDer;

    private Dragon hijoIz;

    public int getRecarga() {
        return recarga;
    }

    public int getEdad() {
        return edad;
    }


    public Dragon getPadre() {
        return padre;
    }

    public Dragon getHijoDer() {
        return hijoDer;
    }

    public Dragon getHijoIz() {
        return hijoIz;
    }

    public int getResistencia() {
        return resistencia;
    }

    public void setPadre(Dragon padre) {
        this.padre = padre;
    }

    public void setHijoDer(Dragon hijoDernuevo) {
        if (hijoDernuevo!=null)
            hijoDernuevo.setPadre(this);
        this.hijoDer = hijoDernuevo;
    }

    public void setHijoIz(Dragon hijoIznuevo) {
        if (hijoIznuevo!=null)
            hijoIznuevo.setPadre(this);
        this.hijoIz = hijoIznuevo;
    }

    /**
     * Baja la resistencia y devuelve un booleano acerca de si se debe eliminar o no
     * @return true si murió, false sino
     */
    public boolean RecibirDano(){
        this.resistencia--;
        return this.resistencia==0;
    }

    /**
     * 
     */
    public void lanzarFuego() {
        // TODO implement here
    }

    /**
     * 
     */
    public void avanzar() {
        // TODO implement here
    }

    /**
     * 
     */
    public void clickear() {
        // TODO implement here
    }

}