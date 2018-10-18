package juego;

import adt.LinkedList;
import javax.swing.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

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
     * 
     */
    private LinkedList dragonesQuePasaron;

    /**
     *Verifica cuando se tocan las teclas W,A,S,D que se usan como direccionales
     * @param e
     */
    @Override
    public void keyTyped(KeyEvent e) {
        if(e.getKeyChar()== 'w'){
            grifo.setLocation(grifo.getX(),grifo.getY()-5);
        }
        if(e.getKeyChar()== 's'){
            grifo.setLocation(grifo.getX(),grifo.getY()+5);
        }
        if(e.getKeyChar()== 'a'){
            grifo.setLocation(grifo.getX()-5,grifo.getY());
        }
        if(e.getKeyChar()== 'd'){
            grifo.setLocation(grifo.getX()+5,grifo.getY());
        }
    }

    /**
     * Verifica cuando se tocan las flechas y cuando se tocan dos de estas al mismo tiempo
     * @param e
     */
    @Override
    public void keyPressed(KeyEvent e) {
        if (grifo.getX() + 2 < 268 && grifo.getX() - 2 > 0 && grifo.getY() - 2 > -3 && grifo.getY() + 2 < 247) {

            if (e.getExtendedKeyCode() == KeyEvent.VK_UP && e.getExtendedKeyCode() == KeyEvent.VK_LEFT) {
                grifo.setLocation(grifo.getX() - 2, grifo.getY() - 2);
            }
            if (e.getExtendedKeyCode() == KeyEvent.VK_DOWN && e.getExtendedKeyCode() == KeyEvent.VK_LEFT) {
                grifo.setLocation(grifo.getX() - 2, grifo.getY() + 2);
            }
            if (e.getExtendedKeyCode() == KeyEvent.VK_UP && e.getExtendedKeyCode() == KeyEvent.VK_RIGHT) {
                grifo.setLocation(grifo.getX() + 2, grifo.getY() + 2);
            }
            if (e.getExtendedKeyCode() == KeyEvent.VK_DOWN && e.getExtendedKeyCode() == KeyEvent.VK_RIGHT) {
                grifo.setLocation(grifo.getX() + 2, grifo.getY() + 2);
            } else if (e.getExtendedKeyCode() == KeyEvent.VK_UP) {
                grifo.setLocation(grifo.getX(), grifo.getY() - 2);
            } else if (e.getExtendedKeyCode() == KeyEvent.VK_DOWN) {
                grifo.setLocation(grifo.getX(), grifo.getY() + 2);
            } else if (e.getExtendedKeyCode() == KeyEvent.VK_LEFT) {
                grifo.setLocation(grifo.getX() - 2, grifo.getY());
            } else if (e.getExtendedKeyCode() == KeyEvent.VK_RIGHT) {
                grifo.setLocation(grifo.getX() + 2, grifo.getY());
            }
            System.out.print(grifo.getX() + "\t");
            System.out.println(grifo.getY());
        } else {
            if(grifo.getX() + 2 == 268) {
                grifo.setLocation(264, grifo.getY());
            }
            else if(grifo.getX() - 2 == 0) {
                grifo.setLocation(4, grifo.getY());
            }
            else if(grifo.getY() + 2 == 247) {
                grifo.setLocation(grifo.getX(), 243);
            }
            else if(grifo.getY() - 2 == -3) {
                grifo.setLocation(grifo.getX(), 1);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

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