package GUI;

import javax.swing.*;

/**
 *  Clase: Hilos
 * @author Andrey Sanchez
 * @version 26/10/2018
 */

public class Hilos implements Runnable {
    private int op;
    private boolean correr  = true;
    private JLabel drag;
    Fondo fondo1;

    /**
     * Default constructor
     * @param f
     * @param dg
     * @param opcion
     */

    public  Hilos(Fondo f , int opcion, JLabel dg){
        Thread hilo= new Thread(this);
        op=opcion;
        fondo1 = f;
        drag= dg;
        hilo.start();


    }
    @Override
    public void run() {
        if (op==1){
            while(drag.getX()> -70){
                while(correr) {
                    fondo1.moverlabel();
                    System.out.println("muevo el dragon2");
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                correr = false;
            }
        }
        if (op==2){
            while(drag.getX()> -70){
                while(correr) {
                    //fondo1.moverlabel2();
                    System.out.println("muevo el dragon2");
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                correr = false;
            }
        }
    }
    public void stop(){

        correr = false;
    }
}
