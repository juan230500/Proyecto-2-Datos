package GUI;
public class Hilo_contrl implements Runnable{
    private Fondo fondo1;
    private boolean game = true;

    public Hilo_contrl(Fondo fondo){
        Thread hilo= new Thread(this);
        fondo1 = fondo;
        hilo.start();
    }

    @Override
    public void run() {
        while(game){
            fondo1.movercontrol();
            //fondo1.moverDisp(disparo);
            try {
                Thread.sleep(7);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stop(){
        game = false;
    }
}
