package GUI;


import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.concurrent.TimeUnit;
import java.lang.*;

public class Fondo extends JPanel implements KeyListener{

    private boolean juego = true;
    private int c = 0;
    private JLabel label = new JLabel();

    public Fondo() {
        setLayout(null);
        setBounds(0, 0, 800, 600);
        setBackground(Color.cyan);
        setMaximumSize(new Dimension(800, 600));
        addKeyListener(this);
        setFocusable(true);
        //ImageIcon imagen = new ImageIcon("C:/Users/andre/Desktop/fondo.png");
        label.setText("PRUEBA");
        label.setBounds(0, 0-100,1200, 800);
        add(label);
    }
    public void comenzar_juego(){

        while(true){
            label.setLocation(getX()+1 , 0);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyChar() == 'a') {
            label.setLocation(label.getX() - 5, label.getY());
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

