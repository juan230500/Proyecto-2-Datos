package GUI;

import javax.swing.*;

/**
 * Clase: Hilo_DR
 * @author Andrey Sanchez
 * @version 26/10/2018
 */

public class Hilo_DR implements Runnable {
    private JLabel dg;
    private Fondo fondo1;
    private boolean game= true;

    /**
     * Default constructor
     * @param dragon
     * @param f1
     */

    public Hilo_DR(JLabel dragon, Fondo f1){
        Thread hilo= new Thread(this);
        dg= dragon;
        fondo1 = f1;
        hilo.start();
    }
    @Override
    public void run() {
        while(dg.getX()>=0) {
            fondo1.disparoDragon(dg);
            System.out.println("Movimiento de Disparo");
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
