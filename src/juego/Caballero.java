package juego;

import adt.LinkedList;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Clase: Caballero
 * @author Andrey Sanchez
 * @version 18.10.2018
 */
public class Caballero extends JPanel implements KeyListener {
    private JLabel grifo = new JLabel("Prueba");

    /**
     * Default constructor
     */

    public Caballero() {
        addKeyListener(this);
        setFocusable(true);
        add(grifo);
    }
    /**
     *Verifica cuando se tocan las teclas W,A,S,D que se usan como direccionales y cuando se tocan dos de estas al mismo tiempo
     * @param e
     */

    @Override
    public void keyTyped(KeyEvent e) {
        if (grifo.getX() + 5 < 380 && grifo.getX() - 5 > -5 && grifo.getY() - 5 > -4 && grifo.getY() + 5 < 380) {
            if (e.getKeyChar() == 'w' && e.getKeyChar() == 'd') {
                grifo.setLocation(grifo.getX()+5, grifo.getY() - 5);
            }
            if (e.getKeyChar() == 'w' && e.getKeyChar() == 'a') {
                grifo.setLocation(grifo.getX()- 5, grifo.getY() - 5);
            }
            if (e.getKeyChar() == 's' && e.getKeyChar() == 'd') {
                grifo.setLocation(grifo.getX()+5, grifo.getY() + 5);
            }
            if (e.getKeyChar() == 's' && e.getKeyChar() == 'a') {
                grifo.setLocation(grifo.getX()-5, grifo.getY() + 5);
            }
            else if (e.getKeyChar() == 'w') {
                grifo.setLocation(grifo.getX(), grifo.getY() - 5);
            }
            else if (e.getKeyChar() == 's') {
                grifo.setLocation(grifo.getX(), grifo.getY() + 5);
            }
            else if (e.getKeyChar() == 'a') {
                grifo.setLocation(grifo.getX()-5, grifo.getY());
            }
            else if (e.getKeyChar() == 'd') {
                grifo.setLocation(grifo.getX()+5, grifo.getY() + 5);
            }
        }else {
            if(grifo.getX() + 5 >= 380) {
                grifo.setLocation(374, grifo.getY());
            }
            else if(grifo.getX() - 5 <= -4) {
                grifo.setLocation(2, grifo.getY());
            }
            else if(grifo.getY() + 5 >= 380) {
                grifo.setLocation(grifo.getX(), 374);
            }
            else if(grifo.getY() - 5 <= -4) {
                grifo.setLocation(grifo.getX(), 6);
            }
        }
        System.out.print(grifo.getX() + "\t");
        System.out.println(grifo.getY());
    }

    /**
     * Verifica cuando se tocan las flechas y cuando se tocan dos de estas al mismo tiempo
     * @param e
     */
    public void keyPressed(KeyEvent e) {
        if (grifo.getX() + 5 < 380 && grifo.getX() - 5 > -5 && grifo.getY() - 5 > -4 && grifo.getY() + 5 < 380) {

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
            }
            else if (e.getExtendedKeyCode() == KeyEvent.VK_UP) {
                grifo.setLocation(grifo.getX(), grifo.getY() - 5);
            }
            else if (e.getExtendedKeyCode() == KeyEvent.VK_DOWN) {
                grifo.setLocation(grifo.getX(), grifo.getY() + 5);
            }
            else if (e.getExtendedKeyCode() == KeyEvent.VK_LEFT) {
                grifo.setLocation(grifo.getX() - 5, grifo.getY());
            }
            else if (e.getExtendedKeyCode() == KeyEvent.VK_RIGHT) {
                grifo.setLocation(grifo.getX() + 5, grifo.getY());
            }
        } else {
            if(grifo.getX() + 5 >= 380) {
                grifo.setLocation(374, grifo.getY());
            }
            else if(grifo.getX() - 5 <= -4) {
                grifo.setLocation(2, grifo.getY());
            }
            else if(grifo.getY() + 5 >= 380) {
                grifo.setLocation(grifo.getX(), 374);
            }
            else if(grifo.getY() - 5 <= -4) {
                grifo.setLocation(grifo.getX(), 6);
            }
        }
        System.out.print(grifo.getX() + "\t");
        System.out.println(grifo.getY());
    }


    @Override
    public void keyReleased(KeyEvent e) {

    }
    private LinkedList dragonesQuePasaron;

    /**
     * 
     */
    public void atacar() {
        // TODO implement here
    }

    /**
     * 
     */
    public void recibir_daño() {
        // TODO implement here
    }

    /**
     * 
     */
    public void DetectarDragonPasado() {
        // TODO implement here
    }

}