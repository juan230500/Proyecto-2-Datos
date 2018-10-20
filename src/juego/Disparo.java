package juego;

import javax.swing.*;
import java.util.*;

/**
 * Clase: Disparo
 * @author Andrey Sanchez
 * @version 20.10.2018
 */
public class Disparo {
    private float Velocidad=5;
    private int PosX;
    private int PosY;
    private JLabel bola =new JLabel("o");

    /**
     * Default constructor
     */
    public Disparo(int posX, int posY) {
        this.PosX=posX;
        this.PosY=posY;

    }

    /**
     *Getter
     * @return bola
     */
    public JLabel getBola(){
        return this.bola;
    }

    /**
     *Detecta si una bala colisiona con un dragon
     * @param dragon
     * @return boolean
     */
    public boolean DetectarColision(JLabel dragon) throws InterruptedException {
        while(this.PosX<=500){
            if(this.PosY>= dragon.getY() && this.PosY<= dragon.getY()+dragon.getHeight() && this.PosX>= dragon.getX()){
                this.PosX = 501;
                return true;
            }
            else{
                this.PosX+= this.Velocidad;
                bola.setLocation(this.PosX,this.PosY);
                Thread.sleep(7);
            }
        }
        return false;
    }

}