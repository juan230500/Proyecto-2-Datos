package juego;

import GUI.Fondo;
import GUI.Hilo_F;
import adt.LinkedList;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Clase: Caballero
 * @author Andrey Sanchez
 * @version 20.10.2018
 */

public class Caballero {
    private JLabel grifo = new JLabel("Prueba");
    private boolean choque = false;
    private JLabel disparo = null;
    private int resistencia = 5;
    private int vida= 3;
    private int dragonesQuePasaron = 0;
    ImageIcon img = new ImageIcon("src/MultiMedia/Grifo.gif");


    /**
     * Default constructor
     */

    public Caballero() {
        /*
        addKeyListener(this);
        setLayout(null);
        setFocusable(true);
        add(grifo);
        */
        grifo.setBounds(20,100, 80,50);
        grifo.setIcon(img);
    }

    /**
     * Crea un objeto Disparo, verifica si este colisiono con un dragon y si lo hizo disminuye la vida de dicho dragon
     */
    public void atacar(Dragon dragonX, Disparo d,Oleada OleadaDibujar,Fondo fondo, boolean fuego) {

        this.disparo = d.getBola();

        Hilo_D hilo2 = new Hilo_D(d,dragonX,OleadaDibujar,fondo);

    }

    public void atacar(Fondo fondo) {

        Disparo d = new Disparo(this.grifo.getX() + this.grifo.getWidth(), this.grifo.getY() + (this.grifo.getHeight() / 2));
        this.disparo = d.getBola();

        Hilo_DS hilo2 = new Hilo_DS(d, fondo);
    }

    /**
     *Verifica si el caballero colisiona con un enemigo
     * @param cho
     * @return boolean
     */

    public boolean colisionEnem(JLabel cho){
        if(cho.getHeight()>this.grifo.getHeight()) { //Delimita quien es mas grande, si ek caballero o el enemigo
            if (this.grifo.getY() >= cho.getY() && this.grifo.getY() <= cho.getY() + cho.getHeight() && (cho.getX()<=this.grifo.getX()+this.grifo.getWidth()) && (this.grifo.getX()<=cho.getX()+cho.getWidth())) { //Setea los limites de colision en base a quien sea mas pequeño
                grifo.setLocation(20, 20);
                System.out.println("Colisiono");
                this.recibir_daño();
                return this.choque = true;
            } else {
                return this.choque = false;
            }
        }
        else {
            if (cho.getY() >= this.grifo.getY() && cho.getY() <= this.grifo.getY() + this.grifo.getHeight() && (cho.getX()<=this.grifo.getX()+this.grifo.getWidth()) && (this.grifo.getX()<=cho.getX()+cho.getWidth())) {
                grifo.setLocation(20, 20);
                System.out.println("Colisiono");
                this.recibir_daño();
                return this.choque = true;
            } else {
                return this.choque = false;
            }
        }
    }

    public int getResistencia() {

        return resistencia;
    }

    public void setResistencia(int resistencia) {

        this.resistencia = resistencia;
    }

    /**
     * 
     */
    public void DetectarDragonPasado() {
        // TODO implement here
    }

    public void setChoque(boolean choque) {

        this.choque = choque;
    }

    public boolean isChoque() {

        return choque;
    }
    public void recibir_daño() {
        this.vida -= 1;
        // TODO implement here
    }

    public int getVida() {
        return vida;
    }
    public JLabel getLabel(){

        return this.grifo;
    }
    public JLabel getDisparo() {

        return disparo;
    }
    public void setDragonesQuePasaron(int dragonesQuePasaron) {

        this.dragonesQuePasaron = dragonesQuePasaron;
    }

    public int getDragonesQuePasaron(){
        return dragonesQuePasaron;
    }

}