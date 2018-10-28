package ArbolB;

public class Sala_de_pruebas {
    public static void main(String[] args) throws InterruptedException {

        /*Marco marco1=new Marco();
        marco1.setVisible(true);
        marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int x=10;
        int y=100;*/
        Raiz raiz1 = new Raiz(100);
        for(int i=100;i>1;i--){
            raiz1.insertar(i);
        }
        System.out.println(raiz1.dameInfo(1,"A"));
        PanelArbolB arbolB=new PanelArbolB(raiz1);
        arbolB.dibujarArbolB("A");
        raiz1=new Raiz(100);
        Thread.sleep(1000);
        for(int i=100;i>1;i--){
            if(i!=38){
                raiz1.insertar(i);
            }
            else{
                System.out.println("hola"+i);
            }

        }
        arbolB=new PanelArbolB(raiz1);
        arbolB.dibujarArbolB("B");
        System.out.println(raiz1.dameInfo(1,"A"));




    }
    public  void crear_label(){
    }
}