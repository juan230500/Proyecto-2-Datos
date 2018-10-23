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
    private JLabel etiqueta =new JLabel();
    private JLabel etiqueta2 =new JLabel();
    private int x1=1000;
    private int x2=1000;
    private int largo = 1366-400;
    private int alto = 768;

    public Fondo() {
        setLayout(null);
        setBounds(0, 0, largo, alto);
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
        crearLabel();

        Hilos hilito1=new Hilos(this,1);
        Hilos hilito2=new Hilos(this,2);
        Hilo_F hilo = new Hilo_F(this);

    }

    public void crearLabel(){

        etiqueta.setText("Dragon");
        etiqueta2.setText("Dragon2");
        etiqueta.setBounds(x1,300,60,60);
        etiqueta2.setBounds(x2,450,60,60);
        this.add(etiqueta);
        this.add(etiqueta2);

    }
    public void moverlabel1(){
        etiqueta.setLocation(x1,etiqueta.getY());
        System.out.println("muevo al dragon 1");
        x1 -= 1;

    }
    public void moverlabel2(){
        etiqueta2.setLocation(x2,etiqueta2.getY());
        System.out.println("muevo al dragon 1");
        x2 -= 1;

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
            if (grifo.getX()+80 + 5 < largo && grifo.getX() - 5 > -5 && grifo.getY() - 5 > -5 && grifo.getY()+50 + 5 < alto) {
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
                if (grifo.getX()+80 + 5 >= largo) {
                    grifo.setLocation(largo-86, grifo.getY());
                } else if (grifo.getX() - 5 <= -5) {
                    grifo.setLocation(1, grifo.getY());
                } else if ( grifo.getY()+50 + 5  >= alto) {
                    grifo.setLocation(grifo.getX(), alto-56);
                } else if (grifo.getY() - 5 <= -5) {
                    grifo.setLocation(grifo.getX(), 1);
                }
            }
            System.out.print(grifo.getX() + "\t");
            System.out.println(grifo.getY());
            caballero.colisionEnem(etiqueta);
            caballero.colisionEnem(etiqueta2);
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
            if (grifo.getX()+80 + 5 < largo && grifo.getX() - 5 > -5 && grifo.getY() - 5 > -5 && grifo.getY()+50 + 5 < alto) {
                if (e.getExtendedKeyCode() == KeyEvent.VK_SPACE){
                    caballero.atacar(etiqueta2);
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
                if (grifo.getX()+80 + 5 >= largo) {
                    grifo.setLocation(largo-86, grifo.getY());
                } else if (grifo.getX() - 5 <= -5) {
                    grifo.setLocation(1, grifo.getY());
                } else if ( grifo.getY()+50 + 5  >= alto) {
                    grifo.setLocation(grifo.getX(), alto-56);
                } else if (grifo.getY() - 5 <= -5) {
                    grifo.setLocation(grifo.getX(), 1);
                }
            }
            System.out.print(grifo.getX() + "\t");
            System.out.println(grifo.getY());
            caballero.colisionEnem(etiqueta);
            caballero.colisionEnem(etiqueta2);
        }
        else{
            caballero.setChoque(false);
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}