package juego;

import javax.swing.*;

public class Hilo_D implements Runnable {
    private  Dragon dg;
    private JLabel dLabel;
    Disparo Disparo1 = null;
    private  Oleada OleadaDibujar;

    public Hilo_D(Disparo d, Dragon dragon,Oleada OleadaDibujar){
        Thread hilo= new Thread(this);
        Disparo1 = d;
        dLabel= dragon.getLabel();
        this.dg=dragon;
        this.OleadaDibujar=OleadaDibujar;
        hilo.start();
    }
    @Override
    public void run() {
        if (dg != null) {
            while (Disparo1.getPosX() <= dLabel.getX()) {
                Disparo1.moverDisparo(dLabel);
                try {
                    Thread.sleep(7);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Disparo1.getBola().setVisible(false);
            OleadaDibujar.HerirDragon(dg);
            if (dg.getResistencia()==0){
                dLabel.setVisible(false);
            }
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
