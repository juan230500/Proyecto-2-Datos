package juego;

import javax.swing.*;

public class Hilo_D implements Runnable {
    private JLabel dg;
    private int op;
    Disparo Disparo1 = null;
    private boolean wh= true;

    public Hilo_D(Disparo d, JLabel dragon){
        Thread hilo= new Thread(this);
        Disparo1 = d;
        dg= dragon;
        hilo.start();
    }
    @Override
    public void run() {
        if (dg != null) {
            while (Disparo1.getPosX() <= dg.getX()) {
                Disparo1.moverDisparo(dg);
                try {
                    Thread.sleep(7);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Disparo1.getBola().setVisible(false);
            dg.setVisible(false);
            stop();
        }
        else{
            Disparo1.moverDisparo();
            stop();
        }
    }
    public void stop(){
        return;
    }
}
