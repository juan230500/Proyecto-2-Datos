package GUI;

import javax.swing.*;

public class Sala_de_pruebas {
    public static void main(String[] args){

        Marco marco1=new Marco();
        marco1.setVisible(true);
        marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int x=10;
        int y=100;
        Hilos hilito1=new Hilos(marco1,1);
        Hilos hilito2=new Hilos(marco1,2);

        //marco1.mover(1);
        //marco1.mover(2);


    }

    public  void crear_label(){

    }
}