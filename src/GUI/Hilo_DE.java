package GUI;

import GUI.Fondo;

import javax.swing.*;

/**
 * Este clase sirve para tener un hilo aparte el movimiento de los ataque enemigos y generar una oleada nueva
 * cuando se  elimina un dragon
 */

public class Hilo_DE implements Runnable {
    private Fondo fondo1;
    private JLabel disparo;
    private boolean game=true;

    /**
     * Default constructor
     * @param d
     * @param f1
     */

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