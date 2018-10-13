package GUI;

import adt.B_tree;

import javax.swing.*;
import java.awt.*;


public class Pantalla {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        MarcoCliente mimarco=new MarcoCliente();

        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


    public Pantalla() {
    }

    private String Imagen;

    private B_tree ArbolB_edad;

    public void Avanzar() {
        // TODO implement here
    }

    public void Dibujar() {
        // TODO implement here
    }

    public void VerDragon() {
        // TODO implement here
    }

    public void VerArbolB() {
        // TODO implement here
    }

    public void EliminarKey() {
        // TODO implement here
    }

}

class MarcoCliente extends JFrame{

    public MarcoCliente(){
        Toolkit mipanatalla=Toolkit.getDefaultToolkit();

        Image icono=mipanatalla.getImage("Imagenes/icono.png");

        setIconImage(icono);

        Dimension tamano=mipanatalla.getScreenSize();

        int altopantalla= (int) tamano.getHeight();

        int anchopantalla= (int) tamano.getWidth();

        int alto=600;

        int ancho=800;

        setBounds((anchopantalla-ancho)/2,(altopantalla-alto)/2,ancho,alto);

        setVisible(true);

        setTitle("Pruebas");

        Lamina milamina=new Lamina();

        add(milamina);
    }

}

class Lamina extends JPanel{
    public void paintComponent(Graphics g){

        super.paintComponent(g);

        for (int i=0;i<15;i++){
            g.drawRect(100,10+i*35,100,25);

            g.drawString("Hola"+i,120,22+i*35);
        }


    }
}