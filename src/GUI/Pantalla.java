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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1100, 600);
        setResizable(false);
        Fondo fondo = new Fondo();
        add(fondo);
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