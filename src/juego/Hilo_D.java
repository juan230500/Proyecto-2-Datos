package juego;

import javax.swing.*;

import GUI.Fondo;

public class Hilo_D implements Runnable {
    private  Dragon dg;
    private JLabel dLabel;
    Disparo Disparo1 = null;
    private  Oleada OleadaDibujar;
    private Fondo fondo;

    public Hilo_D(Disparo d, Dragon dragon,Oleada OleadaDibujar,Fondo fondo){
        Thread hilo= new Thread(this);
        Disparo1 = d;
        dLabel= dragon.getLabel();
        this.dg=dragon;
        this.OleadaDibujar=OleadaDibujar;
        this.fondo=fondo;
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
            int criterio=OleadaDibujar.HerirDragon(dg);
            if (dg.getResistencia()==0){
                dLabel.setVisible(false);
                if (criterio<3) {
                	this.fondo.DrawArray();
                }
                else if (criterio==4) {
                	this.fondo.DrawAVL();
                }
                else {
                	this.fondo.DrawABB();
                }

                if (OleadaDibujar.getCantidadDragones()==0){
                    fondo.setJuego(false);
                }
            }
            stop();
        }
        else{
            Disparo1.moverDisparo();
        }
    }
    public void stop(){
        return;
    }
    
}
