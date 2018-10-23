package GUI;
public class Hilos implements Runnable {
    private int op;
    Fondo fondo1;
    public  Hilos(Fondo f ,int opcion){
        Thread hilo= new Thread(this);
        op=opcion;
        fondo1 = f;
        hilo.start();


    }
    @Override
    public void run() {
        if (op==1){
            while(true){
                fondo1.moverlabel1();
                System.out.println("muevo el dragon1");
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        if (op==2){
            while(true){
                fondo1.moverlabel2();
                System.out.println("muevo el dragon2");
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
