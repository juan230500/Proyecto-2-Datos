package GUI;

public class Hilo_F implements Runnable {
    private int op;
    Fondo Fondo1;
    public  Hilo_F(Fondo fondo){
        Thread hilo= new Thread(this);
        Fondo1 = fondo;
        hilo.start();

    }
    @Override
    public void run() {
        while(true){
            Fondo1.comenzar_juego();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}