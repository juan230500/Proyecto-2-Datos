package GUI;

import adt.B_tree;
import java.awt.*;
import javax.swing.*;
import java.util.*;

/**
 * 
 */
public class Pantalla extends JFrame {
    private boolean juego = true;
    private JLabel label = new JLabel();
    private JLabel label2 = new JLabel();
    private Fondo fondo;
    private Hilo_F hFond;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {

        Pantalla frame = new Pantalla();
        frame.setVisible(true);
    }

    /**
     * Default constructor
     */
    public Pantalla() {
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 1366, 768);
        setResizable(false);
        Fondo fond = new Fondo();
        fondo = fond;
        InfoLayout i_lay = new InfoLayout();
        InfoDragon i_dra = new InfoDragon();
        InfoTree i_tree = new InfoTree();
        JPanel pan = new JPanel();
        add(fondo);
        add(i_lay);
        add(i_dra);
        add(i_tree);
        add(pan);
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
        hFond = hilo;
    }
    public void comenzar_juego(){

        while(juego){
            if(fondo.getCaballero().getDragonesQuePasaron()==2 || fondo.getCaballero().getVida() == 2){
                JLabel end = new JLabel("PERDISTEEEEEE");
                end.setFont(new Font("Comic Sans MS", Font.PLAIN, 50));
                end.setBounds(100, 100, 400, 400);
                end.setLocation(100, 100);
                fondo.add(end);
                juego = false;
                fondo.setFocusable(false);
                fondo.setJuego(false);
                fondo.getH1().stop();
                fondo.getH2().stop();
                fondo.getH3().stop();
                fondo.getH4().stop();
                hFond.stop();
            }
            else if (label.getX() <= -1200){
                label.setLocation(label2.getX()+1200,label2.getY());
            }
            else if (label2.getX() <= -1200){
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

    /**
     * 
     */
    private String Imagen;

    /**
     * 
     */
    private B_tree ArbolB_edad;
















    /**
     * 
     */
    public void Avanzar() {
        // TODO implement here
    }

    /**
     * 
     */
    public void Dibujar() {
        // TODO implement here
    }

    /**
     * 
     */
    public void VerDragon() {
        // TODO implement here
    }

    /**
     * 
     */
    public void VerArbolB() {
        // TODO implement here
    }

    /**
     * 
     */
    public void EliminarKey() {
        // TODO implement here
    }

}