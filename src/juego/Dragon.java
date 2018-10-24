package juego;

import adt.LinkedList;
import javax.swing.JLabel;
import java.util.Random;


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
    private Dragon hijoDer;
    private Dragon hijoIz;
    private LinkedList hijos = new LinkedList();
    private LinkedList dragones_asignados = new LinkedList();
    private JLabel Label = new JLabel();
    private int PosX;
    private int PosY;


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
        */
        Random random = new Random();
        this.edad = random.nextInt(1000);
        this.recarga = random.nextInt(1000);
        this.resistencia=2;
    }


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

    public Dragon getHijoDer(){
        return hijoDer;
    }

    public void setHijoDer(Dragon hijoDer) {
        this.hijoDer = hijoDer;
    }

    public Dragon getHijoIz() {
        return hijoIz;
    }

    public void setHijoIz(Dragon hijoIz) {
        this.hijoIz = hijoIz;
    }

    public int getPosX() {
        return PosX;
    }

    public void setPosX(int posX) {
        PosX = posX;
    }

    public int getPosY() {
        return PosY;
    }

    public void setPosY(int posY) {
        PosY = posY;
    }

    public LinkedList getDragones_asignados(){
        return dragones_asignados;
    }

    public void setDragones_asignados(Dragon asignar){
        this.dragones_asignados.insertFirst(asignar);
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

	public JLabel getLabel() {
		return Label;
	}

}