package GUI;


import javax.swing.*;
import java.awt.*;
import java.lang.*;

public class Fondo extends JPanel{

    private boolean juego = true;
    private JLabel label = new JLabel();
    private JLabel label2 = new JLabel();

    public Fondo() {
        setLayout(null);
        setBounds(0, 0, 1366-400, 768);
        setMaximumSize(new Dimension(800, 600));

        //ImageIcon imagen = new ImageIcon("C:/Users/andre/Desktop/fondo.png");

        label.setText("FONDO DE PRUEBA");
        label.setFont(new Font("Comic Sans MS", Font.PLAIN, 40));
        //label.setIcon(imagen);
        label.setBounds(0, -100,1200, 800);

        label2.setText("FONDO DE PRUEBA");
        label2.setFont(new Font("Comic Sans MS", Font.PLAIN, 40));
        //label2.setIcon(imagen);
        label2.setBounds(1200,-100,1200,800);

        add(label);
        add(label2);

        Hilo_F hilo = new Hilo_F(this);

    }
    public void comenzar_juego(){

        while(juego){
            if (label.getX() <= -1200){
                label.setLocation(label2.getX()+1200,label2.getY());
            }
            if (label2.getX() <= -1200){
                label2.setLocation(label.getX()+1200,label.getY());
            }
            label.setLocation(label.getX() - 5, label.getY());
            label2.setLocation(label2.getX() - 5, label2.getY());
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}