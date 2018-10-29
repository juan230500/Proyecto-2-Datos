package GUI;

import juego.Dragon;

import javax.swing.*;

/**
 * Clase: Hilo_DR
 * @author Andrey Sanchez
 * @version 26/10/2018
 */

public class Hilo_DR implements Runnable {
    private Dragon dg;
    private Fondo fondo1;
    private boolean game= true;

    /**
     * Default constructor
     * @param f1
     * @param dra
     */

    public Hilo_DR(Fondo f1, Dragon dra){
        Thread hilo= new Thread(this);
        dg= dra;
        fondo1 = f1;
        hilo.start();
    }
    @Override
    public void run() {
        while(dg.getLabel().getX()>=0) {
            //fondo1.disparoDragon(dg);
            System.out.println("Disparo");
            try {
                Thread.sleep(7);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        stop();
    }
    public void stop() {
        game = false;
    }
}
