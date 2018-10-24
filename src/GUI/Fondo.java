package GUI;


import juego.Caballero;
import juego.Dragon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.*;

public class Fondo extends JPanel implements KeyListener {
    private boolean juego = true;

    public void setJuego(boolean juego) {
        this.juego = juego;
    }

    private JLabel lbl = new JLabel();

    public Caballero getCaballero() {
        return caballero;
    }

    private Caballero caballero = new Caballero();
    private JLabel grifo = caballero.getLabel();
    private JLabel etiqueta =new JLabel();
    private JLabel etiqueta2 =new JLabel();
    private int x1=1000;
    private int x2=1000;
    private int largo = 1366-400;
    private int alto = 768;

    public Hilos getH1() {
        return h1;
    }

    public Hilos getH2() {
        return h2;
    }

    private Hilos h1;
    private Hilos h2;

    public Hilo_DR getH3() {
        return h3;
    }

    public Hilo_DE getH4() {
        return h4;
    }

    private Hilo_DR h3;
    private Hilo_DE h4;

    public Fondo() {
        setLayout(null);
        setBounds(0, 0, largo, alto);
        setMaximumSize(new Dimension(800, 600));

        //ImageIcon imagen = new ImageIcon("C:/Users/andre/Desktop/fondo.png");


        lbl.setText("Su madre");
        lbl.setBounds(100,200,20,20);
        add(grifo);
        add(lbl);

        addKeyListener(this);
        setFocusable(true);
        crearLabel();

        Hilos hilito1=new Hilos(this,1, etiqueta);
        this.h1 = hilito1;
        Hilos hilito2=new Hilos(this,2,etiqueta2);
        this.h2 = hilito2;
    }

    public void crearLabel(){

        etiqueta.setText("Dragon");
        etiqueta2.setText("Dragon2");
        etiqueta.setBounds(x1,300,60,60);
        etiqueta2.setBounds(x2,450,60,60);
        this.add(etiqueta);
        this.add(etiqueta2);
        Hilo_DR hilo_dr = new Hilo_DR(etiqueta2, this);
        h3 = hilo_dr;

    }
    public void moverlabel1(){
        etiqueta.setLocation(x1,etiqueta.getY());
        //System.out.println("muevo al dragon 1");
        x1 -= 1;

    }
    public void moverlabel2(){
        etiqueta2.setLocation(x2,etiqueta2.getY());
        System.out.println("muevo al dragon 2");
        x2 -= 1;
    }
    /*public void moverDragon(Dragon dg){
        while(dg.getResistencia()!= 0){
            if(dg.getX() <= -20){
                caballero.setDragonesQuePasaron(caballero.getDragonesQuePasaron()+1);
                return dg.setVisible(false);
            }
            else{
                dg.setLocation(x2,etiqueta2.getY());
                System.out.println("muevo al dragon 1");
                dg.setX(gd.getX() - 1);
            }
        }
    }
    */


    public void disparoDragon(JLabel dra){
        while (juego) {
            JLabel disp = new JLabel();
            disp.setText("O");
            disp.setBounds(dra.getX()-10, dra.getY()+25, 10,10);
            add(disp);
            Hilo_DE hilito4 = new Hilo_DE(disp, this);
            h4 = hilito4;
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void moverDisp(JLabel disp){
        while(juego && disp.getX() > -10){
            if ((disp.getX() > grifo.getX() + grifo.getWidth()) || (disp.getY() > grifo.getY() + grifo.getHeight()) || (disp.getX() < grifo.getX()) || (disp.getY() < grifo.getY())) {
                disp.setLocation(disp.getX() - 5, disp.getY());
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else{
                caballero.recibir_daño();
                disp.setLocation(1400, 1000);
            }
        }
        disp.setLocation(1400, 1000);
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
            //System.out.print(grifo.getX() + "\t");
            //System.out.println(grifo.getY());
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
                    if(etiqueta2.isVisible()){
                        caballero.atacar(etiqueta2);
                    }
                    else{
                        caballero.atacar();
                    }
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