package juego;

import GUI.Fondo;
/**
 *  ESta clase se encarga de manejar el incono del disparo enmeigo y correrlo en otro hilo aparte
 */

public class Hilo_DS implements Runnable {
    private Disparo Disparo1;
    private Fondo fondo1;

    public Hilo_DS(Disparo d, Fondo fondo){
        Thread hilo= new Thread(this);
        Disparo1 = d;
        fondo1 = fondo;
        hilo.start();
    }
    @Override
    public void run() {
        while(Disparo1.getBola().getX()<970) {
            System.out.println(Disparo1.getBola().getX());
            Disparo1.moverDisparo(fondo1);
        }
        System.out.println("oye fuego");
        try {
            Thread.sleep(7);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
