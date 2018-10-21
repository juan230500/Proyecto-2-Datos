package juego;

import javax.swing.*;

public class Hilo_D implements Runnable {
    private JLabel dg;
    private int op;
    Disparo Disparo1 = null;

    public Hilo_D(Disparo d, JLabel dragon){
        Thread hilo= new Thread(this);
        Disparo1 = d;
        dg= dragon;
        hilo.start();
    }
    @Override
    public void run() {
        while(true) {
            Disparo1.moverDisparo(dg);
            try {
                Thread.sleep(7);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
