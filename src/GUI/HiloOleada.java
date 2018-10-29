package GUI;

import juego.Dragon;

import javax.swing.*;

/**
 * Esta clase se encarga de mover la oleada y verificar los choque de los dragones con el jugador
 */

public class HiloOleada implements Runnable {
    private boolean correr  = true;
    public boolean pausa = false;
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
            if (!pausa){
                fondo1.moverlabel();
                int num;
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for(int i=0; i<fondo1.getOleadaDibujar().getDragonesDibujar().length;i++){
                    if (fondo1.getOleadaDibujar().getDragonesDibujar()[i].getCruce()== false && fondo1.getOleadaDibujar().getDragonesDibujar()[i].getLabel().getX()<=-70){
                        fondo1.getCaballero().setDragonesQuePasaron(fondo1.getCaballero().getDragonesQuePasaron()+1);
                        fondo1.getOleadaDibujar().getDragonesDibujar()[i].setCruce(true);
                        if(fondo1.getOleadaDibujar().getCantidadDragones()<= 2){
                            fondo1.reiniciar();
                        }
                    }
                }
            } else {
                System.out.println("");
            }


        }
        //correr = false;
    }

    public void stop(){
        correr = false;
    }
}