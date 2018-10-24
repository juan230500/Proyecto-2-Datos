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

        for (int j = 9; j >= 0; j--){
            array1[j] = new JLabel();
            array2[j] = new JLabel();
        }

        for (int i = 0; i<10; i++){
            array1[i].setText("Labels1 "+i);
            array2[i].setText("Labels2 "+i);
            array1[i].setBounds(10,posicion,60,10 );
            array2[i].setBounds(30,posicion+300,60,10);
            add(array1[i]);
            add(array2[i]);
            posicion+=20;
        }
        Hilo_A hilo_a = new Hilo_A(this);
        System.out.println("aca2");
    }

    public void animar(){
        for (int i = 0; i<10; i++){
            int c = 1;
            System.out.println("aca1");
            while ((array1[i].getX()!=array2[i].getX()) || (array1[i].getY()!=array2[i].getY())) {
                if (array1[i].getX()>array2[i].getX() && array1[i].getY()>array2[i].getY()) {
                    array1[i].setLocation(array1[i].getX() - 1, array1[i].getY()-1);
                    System.out.println("aca");
                }
                if (array1[i].getX()>array2[i].getX() && array1[i].getY()==array2[i].getY()) {
                    array1[i].setLocation(array1[i].getX() - 1, array1[i].getY());
                }
                if (array1[i].getX()>array2[i].getX() && array1[i].getY()<array2[i].getY()) {
                    array1[i].setLocation(array1[i].getX() - 1, array1[i].getY()+1);
                }
                if (array1[i].getX()==array2[i].getX() && array1[i].getY()>array2[i].getY()) {
                    array1[i].setLocation(array1[i].getX(), array1[i].getY()-1);
                }
                if (array1[i].getX()==array2[i].getX() && array1[i].getY()<array2[i].getY()) {
                    array1[i].setLocation(array1[i].getX(), array1[i].getY()+1);
                }
                if (array1[i].getX()<array2[i].getX() && array1[i].getY()>array2[i].getY()) {
                    array1[i].setLocation(array1[i].getX() + 1, array1[i].getY()-1);
                }
                if (array1[i].getX()<array2[i].getX() && array1[i].getY()==array2[i].getY()) {
                    array1[i].setLocation(array1[i].getX() + 1, array1[i].getY());
                }
                if (array1[i].getX()<array2[i].getX() && array1[i].getY()<array2[i].getY()) {
                    array1[i].setLocation(array1[i].getX() + 1, array1[i].getY()+1);
                }
                c++;

                try {
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
