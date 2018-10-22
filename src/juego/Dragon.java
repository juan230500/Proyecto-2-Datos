package juego;

import adt.LinkedList;

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
    private LinkedList hijos = new LinkedList();
    private LinkedList dragones_asignados = new LinkedList();

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
        try {
            return padre;
        } catch (NullPointerException exception){
            return null;
        }
    }


    public void setPadre(Dragon padre) {
        this.padre = padre;
    }


    public LinkedList getHijos() {
        return hijos;
    }


    public void setHijo(Dragon hijo) {
        this.hijos.insertFirst(hijo);
    }

    public LinkedList getDragones_asignados(){
        return dragones_asignados;
    }

    public void setDragones_asignados(Dragon asignar){
        this.dragones_asignados.insertFirst(asignar);
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