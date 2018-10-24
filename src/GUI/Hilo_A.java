package GUI;

public class Hilo_A implements Runnable {
    animacion_prueba ani1;

    public  Hilo_A(animacion_prueba a){
        Thread hilo = new Thread(this);
        ani1 = a;
        hilo.start();
    }
    @Override
    public void run() {
        System.out.println("aca3");
        while (true) {
            ani1.animar();
        }
    }
}
