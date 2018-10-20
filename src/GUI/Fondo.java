package GUI;


import juego.Caballero;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.*;

public class Fondo extends JPanel implements KeyListener {

    private boolean juego = true;
    private JLabel label = new JLabel();
    private JLabel label2 = new JLabel();
    private JLabel lbl = new JLabel();
    private Caballero caballero = new Caballero();
    private JLabel grifo = caballero.getLabel();

    public Fondo() {
        setLayout(null);
        setBounds(0, 0, 1366-400, 768);
        setMaximumSize(new Dimension(800, 600));

        //ImageIcon imagen = new ImageIcon("C:/Users/andre/Desktop/fondo.png");

        label.setText("FONDO DE PRUEBA");
        label.setFont(new Font("Comic Sans MS", Font.PLAIN, 40));
        //label.setIcon(imagen);
        label.setBounds(0, -100,1200, 800);

        label2.setText("FONDO DE PRUEBA");
        label2.setFont(new Font("Comic Sans MS", Font.PLAIN, 40));
        //label2.setIcon(imagen);
        label2.setBounds(1200,-100,1200,800);

        lbl.setText("Su madre");
        lbl.setBounds(100,200,20,20);

        add(label);
        add(label2);
        add(lbl);
        add(grifo);

        addKeyListener(this);
        setFocusable(true);

        Hilo_F hilo = new Hilo_F(this);

    }
    public void comenzar_juego(){

        while(juego){
            if (label.getX() <= -1200){
                label.setLocation(label2.getX()+1200,label2.getY());
            }
            if (label2.getX() <= -1200){
                label2.setLocation(label.getX()+1200,label.getY());
            }
            label.setLocation(label.getX() - 5, label.getY());
            label2.setLocation(label2.getX() - 5, label2.getY());
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     *Verifica cuando se tocan las teclas W,A,S,D que se usan como direccionales y cuando se tocan dos de estas al mismo tiempo
     * @param e
     */
    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("ohh");
        //JLabel grifo = caballero.getLabel();
        if (caballero.isChoque()== false) {
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
            caballero.colisionEnem(new JLabel());
        }
        else{
            caballero.setChoque(false);
        }
    }

    /**
     * Verifica cuando se tocan las flechas y cuando se tocan dos de estas al mismo tiempo, verifica que no exista colision y si la hay "resetea" al caballero y detecta cuando se ataca
     * @param e
     */
    @Override
    public void keyPressed(KeyEvent e) {
        //JLabel grifo = caballero.getLabel();
        if (caballero.isChoque()== false) {
            if (grifo.getX() + 5 < 380 && grifo.getX() - 5 > -5 && grifo.getY() - 5 > -4 && grifo.getY() + 5 < 380) {
                if (e.getExtendedKeyCode() == KeyEvent.VK_SPACE){
                    caballero.atacar(lbl);
                    caballero.getDisparo().setBounds(100,300,10,10);
                    add(caballero.getDisparo());
                    //caballero.getDisparo().setLocation(20,20);
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
            caballero.colisionEnem(new JLabel());
        }
        else{
            caballero.setChoque(false);
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}