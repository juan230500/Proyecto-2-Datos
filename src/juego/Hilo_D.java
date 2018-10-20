package juego;

public class Hilo_D implements Runnable {

    private int op;
    Disparo Disparo1 = null;

    public Hilo_D(Disparo d){
        Thread hilo= new Thread(this);
        Disparo1 = d;
        hilo.start();
    }
    @Override
    public void run() {
        while(true) {
            Disparo1.moverDisparo();
            try {
                Thread.sleep(7);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
