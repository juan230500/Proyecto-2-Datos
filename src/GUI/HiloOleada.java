package GUI;

import juego.Dragon;

import javax.swing.*;

/**
 * Clase: HiloOleada
 * @author Andrey Sanchez
 * @version 26/10/2108
 */

public class HiloOleada implements Runnable {
    private boolean correr  = true;
    Fondo fondo1;

    /**
     * Default constructor
     * @param f
     */

    public  HiloOleada(Fondo f){
        Thread hilo= new Thread(this);
        fondo1 = f;
        hilo.start();


    }
    @Override
    public void run() {
        while(correr) {
            fondo1.moverlabel();
            int num;
            /*num =(int) (Math.random()*fondo1.getOleadaDibujar().getDragonesDibujar().length);
            //fondo1.disparoDragon(fondo1.getOleadaDibujar().getDragonesDibujar()[num].getLabel());

            Hilo_DR n= new Hilo_DR(fondo1.getOleadaDibujar().getDragonesDibujar()[num].getLabel(),fondo1);
            */
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for(int i=0; i<fondo1.getOleadaDibujar().getDragonesDibujar().length;i++){
                if (fondo1.getOleadaDibujar().getDragonesDibujar()[i].getCruce()== false && fondo1.getOleadaDibujar().getDragonesDibujar()[i].getLabel().getX()<=0){
                    fondo1.getCaballero().setDragonesQuePasaron(fondo1.getCaballero().getDragonesQuePasaron()+1);
                    fondo1.getOleadaDibujar().getDragonesDibujar()[i].setCruce(true);
                }
            }

        }
        correr = false;
    }

    public void stop(){
        correr = false;
    }
}