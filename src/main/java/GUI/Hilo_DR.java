package GUI;

import javax.swing.*;

public class Hilo_DR implements Runnable {
    private JLabel dg;
    private Fondo fondo1;
    private boolean game= true;

    public Hilo_DR(JLabel dragon, Fondo f1){
        Thread hilo= new Thread(this);
        dg= dragon;
        fondo1 = f1;
        hilo.start();
    }
    @Override
    public void run() {
        while(game) {
            fondo1.disparoDragon(dg);
            try {
                Thread.sleep(7);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void stop() {
        game = false;
    }
}
