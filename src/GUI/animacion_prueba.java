package GUI;

import adt.LinkedList;
import juego.Dragon;
import juego.Dragones;

import javax.swing.*;
import java.awt.*;

public class animacion_prueba extends JFrame {
    private Dragones dragons = new Dragones(10, 1);
    private JLabel[] array1 = new JLabel[10];
    private JLabel[] array2 = new JLabel[10];
    private JLabel[] array3 = new JLabel[10];
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
        setBounds(0,0,800,600);
        setVisible(true);
        setLayout(null);
        //ImageIcon imagen = new ImageIcon("C:/Users/andre/Desktop/dragon.gif");


        for (int j = 9; j >= 0; j--){
            array1[j] = new JLabel();
            array2[j] = new JLabel();
            array3[j] = new JLabel();
        }

        for (int i = 0; i<10; i++){
            //array1[i].setIcon(imagen);
            Dragon dtmp = (Dragon) dragons.getLista_dragones().recorrer(i);
            dtmp.getLabel().setText("Labels1 "+i);
            array2[i].setText("        "+i);
            dtmp.getLabel().setBounds(10,posicion,150,50 );
            array2[i].setBounds(30,posicion+300,60,10);
            array3[i].setBounds(dtmp.getLabel().getX(),dtmp.getLabel().getY()-15,50,50);
            array3[i].setText("RCR: "+dtmp.getRecarga());
            array3[i].setForeground(coloresEtiquetasVrcr(dtmp.getRecarga()));
            //array3[i].setText("Edad: "+dtmp.getEdad());
            //array3[i].setForeground(coloresEtiquetasEdad(dtmp.getEdad()));

            add(dtmp.getLabel());
            add(array2[i]);
            add(array3[i]);
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


    public Color coloresEtiquetasEdad(int edad){
        int r = (edad * 255)/1000;
        Color color = new Color(0+r,255-r,10);
        return color;
    }

    public Color coloresEtiquetasVrcr(int vrcr){
        int r = (vrcr * 255)/100;
        Color color = new Color(0+r,255-r,10);
        return color;
    }

//    public Color coloresEtiquetasPadre(LinkedList lista) {
//        for (int i = lista.size(); i >= 0; i--){
//            if (i == lista.size()){
//
//            }
//        }
//        int r = (9 * 255) / 100;
//        Color color = new Color(0 + r, 255 - r, 10);
//        return color;
//    }

    public void animar(){
        float m;
        float b;

        for (int i = 0; i<10; i++){
            Dragon dtmp = (Dragon) dragons.getLista_dragones().recorrer(i);

            float x1 = dtmp.getLabel().getX();
            float y1 = dtmp.getLabel().getY();
            float x2 = array2[i].getX();
            float y2 = array2[i].getY();

            m = (y2 - y1)/(x2 - x1);
            b = y1 - (m * x1);
            //System.out.println(y2-y1);

            float movx = (x2-x1)/40;

            float xi=x1;
            float yi;

            while ((xi<x2)) {
                //int movx = (i1 - i2)/20;
                //int movy = (j1 - j2)/20;
                xi+=movx;
                yi=m*xi+b;

                dtmp.getLabel().setLocation((int)xi, (int)yi);
                array3[i].setLocation((int)xi, (int)yi-20);


            /*
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
                */

                try {
                    Thread.sleep(7);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*public void paint(Graphics g) {
        Dragon h1;
        Dragon h2;
        Dragon drag;
        g.setColor(Color.black);
        for (int i = 0; i < 10; i++) {
            drag = (Dragon) dragons.getLista_dragones().recorrer(i);
            h1 = drag.getHijoDer();
            h2 = drag.getHijoIz();
            System.out.println("ciclo" + i);
            if (h1 != null) {
                g.drawLine(drag.getLabel().getX(), drag.getLabel().getY(), h1.getLabel().getX(), h1.getLabel().getY());
            } else if (h2 != null) {
                g.drawLine(drag.getLabel().getX(), drag.getLabel().getY(), h2.getLabel().getX(), h2.getLabel().getY());
            }
        }
    }*/
}
