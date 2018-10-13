package GUI;

import adt.B_tree;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


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

        Pane pane = new Pane();

        add(pane);


    }

}

class Pane extends JPanel implements ActionListener {

    private JButton next;
    private int col;

    public Pane(){
        setBounds(0,0,800,600);
        setVisible(true);
        setLayout(null);
        repaint();

        next = new JButton("Next");
        next.setBounds(125,125,100,30);
        next.addActionListener(this);
        add(next);

        this.col=0;

    }

    public void actionPerformed (ActionEvent e){
        Object source = e.getSource();
        if (source == next){
            Graphics g = this.getGraphics();
            drawing(g,col);
        }
    }

    public void paintComponent(Graphics g){

    }

    public void drawing(Graphics g,int col){
        int aco=100;
        for (int i=0;i<15;i++){
            g.drawRect(100+col*100,10+i*35,100,25);

            g.drawString("Hola"+aco,120+col*100,22+i*35);

            aco+=aco*.2;
        }
        this.col++;
    }

}