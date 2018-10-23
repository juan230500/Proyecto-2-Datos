package juego;

import javax.swing.*;
import java.util.*;

/**
 * Clase: Disparo
 * @author Andrey Sanchez
 * @version 20.10.2018
 */
public class Disparo {
    private float Velocidad = 5;
    private int PosX;
    private int PosY;
    private JLabel bola = new JLabel("o");
    private boolean en_aire;

    /**
     * Default constructor
     */
    public Disparo(int posX, int posY) {
        this.PosX = posX;
        this.PosY = posY;
        this.en_aire = false;

    }

    /**
     * Getter
     *
     * @return bola
     */
    public JLabel getBola() {
        return this.bola;
    }
/*
    /**
     * Detecta si una bala colisiona con un dragon
     *
     * @param dragon
     * @return boolean
     
    public boolean DetectarColision(JLabel dragon) {
        while (this.PosX <= 1366-400) {
            if (this.PosY >= dragon.getY() && this.PosY <= dragon.getY() + dragon.getHeight() && this.PosX >= dragon.getX()) {
                this.PosX = 1400;
                en_aire = false;
                return true;
            }
        }
        en_aire = true;
        return false;
    }
*/
    public void moverDisparo(JLabel enem) {
        if (PosY<enem.getY() || PosY>enem.getY()+60)  {
            while (PosX <= 1366-400) {
                this.PosX += this.Velocidad;
                bola.setLocation(this.PosX, this.PosY);
                try {
                    Thread.sleep(7);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(PosX);
            }
            bola.setVisible(false);
        }else{
                while (PosX+10<=enem.getX()){
                    this.PosX += this.Velocidad;
                    bola.setLocation(this.PosX, this.PosY);
                    try {
                        Thread.sleep(7);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(PosX);
                }
                //enem.setResistencia(enem.getResistencia-1);
                bola.setVisible(false);
        }
        bola.setLocation(PosX,PosY);
    }
    public void moverDisparo() {
        while (PosX <= 1366-400) {
            this.PosX += this.Velocidad;
            bola.setLocation(this.PosX, this.PosY);
            try {
                Thread.sleep(7);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(PosX);
            bola.setLocation(PosX,PosY);
        }
        bola.setVisible(false);
    }

}