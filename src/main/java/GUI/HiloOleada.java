package GUI;

import javax.swing.*;

public class HiloOleada implements Runnable {
    private boolean correr  = true;
    Fondo fondo1;
    public  HiloOleada(Fondo f){
        Thread hilo= new Thread(this);
        fondo1 = f;
        hilo.start();


    }
    @Override
    public void run() {
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

    public void stop(){
        correr = false;
    }
}