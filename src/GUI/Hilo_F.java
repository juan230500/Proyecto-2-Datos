package GUI;

import javax.swing.*;
import juego.Disparo;

/**
 * Clase: Hilo_F
 * @author Andrey Sanchez
 * @version 26/10/2018
 */

public class Hilo_F implements Runnable {
    Pantalla SideScroller = null;
    private boolean juego = true;

    /**
     * Default constructor
     * @param sidescroller
     */

    public  Hilo_F(Pantalla sidescroller){
        Thread hilo= new Thread(this);
        SideScroller = sidescroller;
        hilo.start();
    }

    @Override
    public void run() {
        while(juego) {
            SideScroller.comenzar_juego();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void stop(){
        juego = false;
    }
}