package juego;

import javax.swing.*;

public class Hilo_DS implements Runnable {
    private JLabel dg;
    private int op;
    Disparo Disparo1 = null;

    public Hilo_DS(Disparo d){
        Thread hilo= new Thread(this);
        Disparo1 = d;
        hilo.start();
    }
    @Override
    public void run() {
        while(true) {
            Disparo1.moverDisparo();
            try {
                Thread.sleep(7);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
