package GUI;

import adt.LinkedList;
import adt.Oleada;
import juego.Dragon;

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
    private int margen;
    private Oleada OleadaDibujar;
    private boolean[] Bloqueos;
    private int Formacion;

    public Pane(){
        setBounds(0,0,800,600);
        setVisible(true);
        setLayout(null);
        repaint();

        next = new JButton("Next");
        next.setBounds(125,125,100,30);
        next.addActionListener(this);
        add(next);

        this.margen =0;
        this.OleadaDibujar=new Oleada(25);
        this.Bloqueos=new boolean[25];
        Bloqueos[2]=true;
        Bloqueos[5]=true;

        OleadaDibujar.display();
    }

    public void actionPerformed (ActionEvent e){
        Object source = e.getSource();
        if (source == next){
            Graphics g = this.getGraphics();
            if (Formacion<3){
                Formacion++;
                drawing(g);
            }
            else {
                Formacion=0;
                drawing2(g);
            }
        }
    }

    public void paintComponent(Graphics g){

    }

    public void drawing2(Graphics g){
        g.setColor(Color.WHITE);
        g.fillRect(0,0,800,600);

        g.setColor(Color.BLACK);

        Dragon cabeza=OleadaDibujar.getRoot();

        int margenlocal=margen;

        g.drawRect(100+ margenlocal *120,200,100,25);

        g.setFont(new Font("TimesRoman", Font.PLAIN, 10));

        g.drawString(""+cabeza,110+ margenlocal *120,200);

    }

    public void dibujarHijos(Graphics g){

    }

    public void drawing(Graphics g){
        g.setColor(Color.WHITE);
        g.fillRect(0,0,800,600);

        g.setColor(Color.BLACK);

        OleadaDibujar.HerirDragon(OleadaDibujar.getRoot());
        Dragon[] D=OleadaDibujar.toArray();
        int largo=D.length;
        int margenlocal=margen;
        int pos=0;
        int fila=0;

        while (pos<largo){

            g.drawRect(100+ margenlocal *120,10+fila*50,100,25);

            g.setFont(new Font("TimesRoman", Font.PLAIN, 10));

            g.drawString(""+D[pos],110+ margenlocal *120,22+fila*50);

            if (Bloqueos[pos]){
                fila+=2;
            }
            else{
                fila++;
            }

            pos++;

            if (fila>9){
                fila=0;
                margenlocal++;
            }
        }
        OleadaDibujar.display();
        //this.margen++;
    }

}