package juego;

/**
 * 
 */
public class Dragon {

    private String nombre;
    private int recarga;
    private int edad;
    private int resistencia;
    private String clase;
    private Dragon padre;
    private Dragon hijos;

    /**
     * Default constructor
     */
    public Dragon() {
        /*
        this.setClase();
        this.setEdad();
        this.setHijos();
        this.setNombre();
        this.setPadre();
        this.setRecarga();
        this.setResistencia();
    */}


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public int getRecarga() {
        return recarga;
    }


    public void setRecarga(int recarga) {
        this.recarga = recarga;
    }


    public int getEdad() {
        return edad;
    }


    public void setEdad(int edad) {
        this.edad = edad;
    }


    public int getResistencia() {
        return resistencia;
    }


    public void setResistencia(int resistencia) {
        this.resistencia = resistencia;
    }


    public String getClase() {
        return clase;
    }


    public void setClase(String clase) {
        this.clase = clase;
    }


    public Dragon getPadre() {
        return padre;
    }


    public void setPadre(Dragon padre) {
        this.padre = padre;
    }


    public Dragon getHijos() {
        return hijos;
    }


    public void setHijos(Dragon hijos) {
        this.hijos = hijos;
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