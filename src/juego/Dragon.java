package juego;

/**
 * 
 */
public class Dragon {

    /**
     * Default constructor
     */
    public Dragon() {
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

    public void setPadre(Dragon padre) {
        this.padre = padre;
    }

    public void setHijoDer(Dragon hijoDernuevo) {
        if(hijoDernuevo!=null)
            hijoDernuevo.setPadre(this);
        this.hijoDer = hijoDernuevo;
    }

    public void setHijoIz(Dragon hijoIznuevo) {
        if(hijoIznuevo!=null)
            hijoIznuevo.setPadre(this);
        this.hijoIz = hijoIznuevo;
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