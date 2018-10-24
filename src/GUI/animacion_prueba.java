package GUI;

import javax.swing.*;

public class animacion_prueba extends JFrame {

    private JLabel[] array1 = new JLabel[10];
    private JLabel[] array2 = new JLabel[10];
    private int posicion = 20;

    public static void main (String[] args){

        animacion_prueba frame = new animacion_prueba();
        frame.setVisible(true);
    }

    public animacion_prueba(){

        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(250, 100, 800, 600);
        setResizable(false);
        //ImageIcon imagen = new ImageIcon("C:/Users/andre/Desktop/dragon.gif");


        for (int j = 9; j >= 0; j--){
            array1[j] = new JLabel();
            array2[j] = new JLabel();
        }

        for (int i = 0; i<10; i++){
            //array1[i].setIcon(imagen);
            array1[i].setText("Labels1 "+i);
            array2[i].setText("Labels2 "+i);
            array1[i].setBounds(10,posicion,150,50 );
            array2[i].setBounds(30,posicion+300,60,10);
            add(array1[i]);
            add(array2[i]);
            posicion+=20;
        }

        array2[0].setLocation(380,300);
        array2[1].setLocation(480,250);
        array2[2].setLocation(480,300);
        array2[3].setLocation(480,350);
        array2[4].setLocation(580,200);
        array2[5].setLocation(580,250);
        array2[6].setLocation(580,300);
        array2[7].setLocation(580,350);
        array2[8].setLocation(580,400);
        array2[9].setLocation(680,300);

        Hilo_A hilo_a = new Hilo_A(this);
        System.out.println("aca2");
    }

    public void animar(){
        for (int i = 0; i<10; i++){
            int c = 1;
            //System.out.println("aca1");
            while ((array1[i].getX()!=array2[i].getX()) || (array1[i].getY()!=array2[i].getY())) {
                if (array1[i].getX()>array2[i].getX() && array1[i].getY()>array2[i].getY()) {
                    array1[i].setLocation(array1[i].getX() - 5, array1[i].getY()-5);
                    System.out.println("aca");
                }
                if (array1[i].getX()>array2[i].getX() && array1[i].getY()==array2[i].getY()) {
                    array1[i].setLocation(array1[i].getX() - 5, array1[i].getY());
                }
                if (array1[i].getX()>array2[i].getX() && array1[i].getY()<array2[i].getY()) {
                    array1[i].setLocation(array1[i].getX() - 5, array1[i].getY()+5);
                }
                if (array1[i].getX()==array2[i].getX() && array1[i].getY()>array2[i].getY()) {
                    array1[i].setLocation(array1[i].getX(), array1[i].getY()-5);
                }
                if (array1[i].getX()==array2[i].getX() && array1[i].getY()<array2[i].getY()) {
                    array1[i].setLocation(array1[i].getX(), array1[i].getY()+5);
                }
                if (array1[i].getX()<array2[i].getX() && array1[i].getY()>array2[i].getY()) {
                    array1[i].setLocation(array1[i].getX() + 5, array1[i].getY()-5);
                }
                if (array1[i].getX()<array2[i].getX() && array1[i].getY()==array2[i].getY()) {
                    array1[i].setLocation(array1[i].getX() + 5, array1[i].getY());
                }
                if (array1[i].getX()<array2[i].getX() && array1[i].getY()<array2[i].getY()) {
                    array1[i].setLocation(array1[i].getX() + 5, array1[i].getY()+5);
                }
                c++;

                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
