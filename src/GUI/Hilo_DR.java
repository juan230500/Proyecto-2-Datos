package GUI;

import javax.swing.*;

public class Hilo_DR implements Runnable {
    private JLabel dg;
    private Fondo fondo1;
    private int op;

    public Hilo_DR(JLabel dragon, Fondo f1){
        Thread hilo= new Thread(this);
        dg= dragon;
        fondo1 = f1;
        hilo.start();
    }
    @Override
    public void run() {
        while(true) {
            fondo1.disparoDragon(dg);
            try {
                Thread.sleep(7);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
