package GUI;

import javax.swing.*;
import juego.Disparo;

public class Hilo_F implements Runnable {
    private int op;
    Fondo Fondo1 = null;
    Disparo Disparo1 = null;
    public  Hilo_F(Fondo fondo){
        Thread hilo= new Thread(this);
        Fondo1 = fondo;
        hilo.start();
    }

    public Hilo_F(Disparo d){
        Thread hilo= new Thread(this);
        Disparo1 = d;
        hilo.start();
    }
    @Override
    public void run() {
        if (Disparo1 == null) {
            while(true){
                Fondo1.comenzar_juego();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } else {
            while(true) {
                Disparo1.moverDisparo();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}