package GUI;
public class Hilos implements Runnable {
    private int op;
    Marco Marco;
    public  Hilos(Marco Marco1,int opcion){
        Thread hilo= new Thread(this);
        op=opcion;
        Marco=Marco1;
        hilo.start();


    }
    @Override
    public void run() {
        if (op==1){
            while(true){
                Marco.moverlabel1();
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
                Marco.moverlabel2();
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
