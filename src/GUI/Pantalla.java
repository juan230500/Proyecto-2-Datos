package GUI;

import adt.B_tree;
import java.awt.*;
import javax.swing.*;
import java.util.*;

/**
 * 
 */
public class Pantalla extends JFrame {

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
        Fondo fondo = new Fondo();
        InfoLayout i_lay = new InfoLayout();
        InfoDragon i_dra = new InfoDragon();
        InfoTree i_tree = new InfoTree();
        JPanel pan = new JPanel();
        add(fondo);
        add(i_lay);
        add(i_dra);
        add(i_tree);
        add(pan);
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