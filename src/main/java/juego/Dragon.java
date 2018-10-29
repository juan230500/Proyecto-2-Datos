package juego;

import adt.LinkedList;
import javax.swing.JLabel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.*;
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
    private int PosXinicial;
    private int PosYinicial;
    private int PosX;
    private int PosY;
    private int nivel;
    private int id;
    ImageIcon img = new ImageIcon("src/MultiMedia/dg.gif");
    
    public Dragon copy() {
    	final Dragon D=new Dragon();
    	D.setNombre(this.nombre);
    	D.setRecarga(this.getResistencia());
    	D.setEdad(this.getEdad());
    	D.setResistencia(this.getResistencia());
    	D.setClase(this.getClase());
    	D.setDragones_asignados(this.getDragones_asignados());
    	D.getLabel().setText(D.getNombre());
        D.getLabel().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                D.setClick(true);
            }
        });
    	return D;
    }


    public boolean getCruce() {
        return cruce;
    }

    public void setCruce(boolean cruce) {
        this.cruce = cruce;
    }

    private boolean cruce=false;

    public boolean getClick() {
        return click;
    }

    public void setClick(boolean click) {
        this.click = click;
    }

    private boolean click = false;

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

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
        getLabel().setIcon(img);
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
    	if (hijoDer!=null) {
    		hijoDer.setPadre(this);
    	}
        this.hijoDer = hijoDer;
    }

    public Dragon getHijoIz() {
        return hijoIz;
    }

    public void setHijoIz(Dragon hijoIz) {
    	if (hijoIz!=null) {
    		hijoIz.setPadre(this);
    	}
        this.hijoIz = hijoIz;
    }

    public int getPosXinicial() {
        return PosXinicial;
    }

    public void setPosXinicial(int posXinicial) {
        PosXinicial = posXinicial;
    }

    public int getPosYinicial() {
        return PosYinicial;
    }

    public void setPosYinicial(int posYinicial) {
        PosYinicial = posYinicial;
    }

    public int getPosX() {
        return PosX;
    }

    public void setPosX(int posXfinal) {
        PosX = posXfinal;
    }

    public int getPosY() {
        return PosY;
    }

    public void setPosY(int posYfinal) {
        PosY = posYfinal;
    }

    public LinkedList getDragones_asignados(){
        return dragones_asignados;
    }

    public void AddDragones_asignados(Dragon asignar){
        this.dragones_asignados.insertFirst(asignar);
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
    public void getInfo() {
        System.out.println(nombre +" " + Integer.toString(recarga) +" " + Integer.toString(edad) +" " + Integer.toString(resistencia) );
    }

	public JLabel getLabel() {
		return Label;
	}

	public void setDragones_asignados(LinkedList dragones_asignados) {
		this.dragones_asignados = dragones_asignados;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

}