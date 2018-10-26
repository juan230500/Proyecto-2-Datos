package GUI;

import javax.swing.*;

public class Hilo_DE implements Runnable {
    private Fondo fondo1;
    private JLabel disparo;
    private boolean game=true;

    public Hilo_DE(JLabel d, Fondo f1){
        Thread hilo= new Thread(this);
        disparo = d;
        fondo1 = f1;
        hilo.start();
    }
    @Override
    public void run() {
        while(game){
            fondo1.moverDisp(disparo);
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