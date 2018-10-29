package GUI;

import javax.swing.*;

/**
 * esta clase  se utliza para pode crear el ataque   disparo de los enemigos un hilo aparte del hilo principal
 */
public class Hilo_Disparos implements Runnable {
    private boolean game= true;
    private Fondo fondo1;

    /**
     * Default constructor
     * @param fondo
     */

    public Hilo_Disparos(Fondo fondo){
        fondo1 = fondo;
        Thread hilo= new Thread(this);
        hilo.start();
    }
    @Override
    public void run() {
        while(game) {
            System.out.println("funca mierdaa");
            fondo1.disparos();
            try {
                Thread.sleep(2000);
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
