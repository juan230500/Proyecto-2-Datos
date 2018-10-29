package GUI;
/**
 * La clase Hilo_control sirve para tener un hilo ejecutando la validacion de
 * que si disparo o no y si es verdadero lo muestra en pantalla
 *
 * @version 1.0
 * @since    28 de octubre 2018
 */
public class Hilo_contrl extends Thread{
    private Fondo fondo1;

    public Hilo_contrl(Fondo fondo){
        Thread hilo= new Thread(this);
        fondo1 = fondo;
        hilo.start();
    }

    @Override
    public void run() {
        while(true){
            fondo1.movercontrol();
            //fondo1.moverDisp(disparo);
            try {
                Thread.sleep(7);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
