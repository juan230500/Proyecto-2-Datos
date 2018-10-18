package juego;

import java.util.concurrent.ThreadLocalRandom;

/**
 * 
 */
public class Dragon {

    /**
     * Default constructor
     */
    public Dragon() {
        //para probar lógica
        this.edad= ThreadLocalRandom.current().nextInt(0, 100);
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


    Dragon getPadre() {
        return padre;
    }

    Dragon getHijoDer() {
        return hijoDer;
    }

    Dragon getHijoIz() {
        return hijoIz;
    }

    int getResistencia() {
        return resistencia;
    }

    void setPadre(Dragon padre) {
        this.padre = padre;
    }

    public void setHijoDer(Dragon hijoDernuevo) {
        hijoDernuevo.setPadre(this);
        this.hijoDer = hijoDernuevo;
    }

    void setHijoIz(Dragon hijoIznuevo) {
        hijoIznuevo.setPadre(this);
        this.hijoIz = hijoIznuevo;
    }

    /**
     * Baja la resistencia y devuelve un booleano acerca de si se debe eliminar o no
     * @return true si murió, false sino
     */
    boolean RecibirDano(){
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