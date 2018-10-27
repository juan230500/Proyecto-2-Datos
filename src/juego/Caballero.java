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

    public int getVida() {
        return vida;
    }

    private int vida= 3;

    public void setVida(int vida) {
        this.vida = vida;
    }

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
    }

    public boolean isChoque() {
        return choque;
    }

    public void setChoque(boolean choque) {
        this.choque = choque;
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

    public int getDragonesQuePasaron() {
        return dragonesQuePasaron;
    }

    /**
     *Verifica cuando se tocan las teclas W,A,S,D que se usan como direccionales y cuando se tocan dos de estas al mismo tiempo
     * @param e
     */

    /*
    @Override
    public void keyTyped(KeyEvent e) {
        if (this.choque== false) {
            if (grifo.getX() + 5 < 380 && grifo.getX() - 5 > -5 && grifo.getY() - 5 > -4 && grifo.getY() + 5 < 380) {
                if (e.getKeyChar() == 'w' && e.getKeyChar() == 'd') {
                    grifo.setLocation(grifo.getX() + 5, grifo.getY() - 5);
                }
                if (e.getKeyChar() == 'w' && e.getKeyChar() == 'a') {
                    grifo.setLocation(grifo.getX() - 5, grifo.getY() - 5);
                }
                if (e.getKeyChar() == 's' && e.getKeyChar() == 'd') {
                    grifo.setLocation(grifo.getX() + 5, grifo.getY() + 5);
                }
                if (e.getKeyChar() == 's' && e.getKeyChar() == 'a') {
                    grifo.setLocation(grifo.getX() - 5, grifo.getY() + 5);
                } else if (e.getKeyChar() == 'w') {
                    grifo.setLocation(grifo.getX(), grifo.getY() - 5);
                } else if (e.getKeyChar() == 's') {
                    grifo.setLocation(grifo.getX(), grifo.getY() + 5);
                } else if (e.getKeyChar() == 'a') {
                    grifo.setLocation(grifo.getX() - 5, grifo.getY());
                } else if (e.getKeyChar() == 'd') {
                    grifo.setLocation(grifo.getX() + 5, grifo.getY());
                }
            } else {
                if (grifo.getX() + 5 >= 380) {
                    grifo.setLocation(374, grifo.getY());
                } else if (grifo.getX() - 5 <= -4) {
                    grifo.setLocation(2, grifo.getY());
                } else if (grifo.getY() + 5 >= 380) {
                    grifo.setLocation(grifo.getX(), 374);
                } else if (grifo.getY() - 5 <= -4) {
                    grifo.setLocation(grifo.getX(), 6);
                }
            }
            System.out.print(grifo.getX() + "\t");
            System.out.println(grifo.getY());
            colisionEnem(new JLabel());
        }
        else{
            this.choque = false;
        }
    }

    /**
     * Verifica cuando se tocan las flechas y cuando se tocan dos de estas al mismo tiempo, verifica que no exista colision y si la hay "resetea" al caballero y detecta cuando se ataca
     * @param e
     */
    /*
    public void keyPressed(KeyEvent e) {
        if (this.choque== false) {
            if (grifo.getX() + 5 < 380 && grifo.getX() - 5 > -5 && grifo.getY() - 5 > -4 && grifo.getY() + 5 < 380) {
                if (e.getExtendedKeyCode() == KeyEvent.VK_SPACE){
                    try {
                        atacar();
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                }
                if (e.getExtendedKeyCode() == KeyEvent.VK_UP && e.getExtendedKeyCode() == KeyEvent.VK_LEFT) {
                    grifo.setLocation(grifo.getX() - 5, grifo.getY() - 5);
                }
                if (e.getExtendedKeyCode() == KeyEvent.VK_DOWN && e.getExtendedKeyCode() == KeyEvent.VK_LEFT) {
                    grifo.setLocation(grifo.getX() - 5, grifo.getY() + 5);
                }
                if (e.getExtendedKeyCode() == KeyEvent.VK_UP && e.getExtendedKeyCode() == KeyEvent.VK_RIGHT) {
                    grifo.setLocation(grifo.getX() + 5, grifo.getY() - 5);
                }
                if (e.getExtendedKeyCode() == KeyEvent.VK_DOWN && e.getExtendedKeyCode() == KeyEvent.VK_RIGHT) {
                    grifo.setLocation(grifo.getX() + 5, grifo.getY() + 5);
                } else if (e.getExtendedKeyCode() == KeyEvent.VK_UP) {
                    grifo.setLocation(grifo.getX(), grifo.getY() - 5);
                } else if (e.getExtendedKeyCode() == KeyEvent.VK_DOWN) {
                    grifo.setLocation(grifo.getX(), grifo.getY() + 5);
                } else if (e.getExtendedKeyCode() == KeyEvent.VK_LEFT) {
                    grifo.setLocation(grifo.getX() - 5, grifo.getY());
                } else if (e.getExtendedKeyCode() == KeyEvent.VK_RIGHT) {
                    grifo.setLocation(grifo.getX() + 5, grifo.getY());
                }
            } else {
                if (grifo.getX() + 5 >= 380) {
                    grifo.setLocation(374, grifo.getY());
                } else if (grifo.getX() - 5 <= -4) {
                    grifo.setLocation(2, grifo.getY());
                } else if (grifo.getY() + 5 >= 380) {
                    grifo.setLocation(grifo.getX(), 374);
                } else if (grifo.getY() - 5 <= -4) {
                    grifo.setLocation(grifo.getX(), 6);
                }
            }
            System.out.print(grifo.getX() + "\t");
            System.out.println(grifo.getY());
            colisionEnem(new JLabel());
        }
        else{
            this.choque = false;
        }
    }


    @Override
    public void keyReleased(KeyEvent e) {

    }
    */
    private int dragonesQuePasaron = 0;

    /**
     * Crea un objeto Disparo, verifica si este colisiono con un dragon y si lo hizo disminuye la vida de dicho dragon
     */
    public void atacar(Dragon dragonX, Disparo d,Oleada OleadaDibujar,Fondo fondo) {

        this.disparo = d.getBola();

        Hilo_D hilo2 = new Hilo_D(d,dragonX,OleadaDibujar,fondo);

/*
        if (d.DetectarColision(dragonX)) {
            System.out.println("lo mató xd");
        } else {
            System.out.println("nelson jejeps");
        }
        */
    }
    public void atacar() {

        Disparo d = new Disparo(this.grifo.getX() + this.grifo.getWidth(), this.grifo.getY() + (this.grifo.getHeight() / 2));
        this.disparo = d.getBola();

        Hilo_DS hilo2 = new Hilo_DS(d);
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
    public void recibir_daño() {
        this.vida -= 1;
        // TODO implement here
    }

    /**
     * 
     */
    public void DetectarDragonPasado() {
        // TODO implement here
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

}