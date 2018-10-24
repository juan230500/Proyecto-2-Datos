package GUI;

import adt.Node;
import juego.Oleada;
import juego.Dragon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Pantallaprueba {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        MarcoCliente mimarco=new MarcoCliente();

        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


    public Pantallaprueba() {
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
    	this.setLayout(null);
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
    private int criterio;

    public Pane(){
        setBounds(0,0,800,600);
        setVisible(true);
        setLayout(null);

        next = new JButton("Next");
        next.setBounds(10,10,100,30);
        next.addActionListener(this);
        add(next);

        this.margen =0;
        this.OleadaDibujar=new Oleada(25);
        this.Bloqueos=new boolean[25];
        DrawArray();
        //OleadaDibujar.display();
    }

    public void actionPerformed (ActionEvent e){
        Object source = e.getSource();
        if (source == next){
            Graphics g = this.getGraphics();
            criterio=OleadaDibujar.HerirDragon(OleadaDibujar.getRoot());
            OleadaDibujar.display();
            
            if (criterio==5){

            }
            else if (criterio==4){
                DrawAVL(g);
            }
            else if (criterio==3){
                DrawABB(g);
            }
            else if(criterio>=0) {
                DrawArray();
            }
            else{

            }
            System.out.println("###"+criterio);
        }
    }

    public void paintComponent(Graphics g){

    }

    public void DrawABB(Graphics g){
        g.setColor(Color.WHITE);
        g.fillRect(0,0,800,600);

        g.setColor(Color.BLACK);

        Dragon cabeza=OleadaDibujar.getRoot();

        if (cabeza==null){
            return;
        }

        int yi=275;
        int xi=margen*120;

        g.drawRect(xi,yi,100,25);

        g.setFont(new Font("Calibri", Font.PLAIN, 12));

        g.drawString(""+cabeza.getEdad(),xi,yi+20);

        cabeza.setPosY(yi);

        cabeza.setPosX(xi);

        dibujarArbol(g,cabeza,2,xi,yi);

    }

    public void dibujarArbol(Graphics g,Dragon root,int nivel,int x,int y){
        if (root!=null){
            dibujarArbol(g,root.getHijoDer(),1+nivel,x+200, y-(600)/(int)Math.pow(2,nivel));
            dibujarHijos(g,root,nivel,x,y);
            dibujarArbol(g,root.getHijoIz(),1+nivel,x+200, y+(600)/(int)Math.pow(2,nivel));
        }
    }

    public void dibujarHijos(Graphics g,Dragon root,int nivel,int x,int y){
        int xi=x+200;
        int yi;

        if (root.getHijoDer() != null) {
            yi=y-(600)/(int)Math.pow(2,nivel);

            g.drawRect(xi,yi,100,25);

            g.setFont(new Font("TimesRoman", Font.PLAIN, 12));

            g.drawString(""+root.getHijoDer().getEdad(),xi,yi+20);

            root.getHijoDer().setPosY(yi);

            root.getHijoDer().setPosX(xi);
        }

        if (root.getHijoIz() != null) {
            yi=y+(600)/(int)Math.pow(2,nivel);

            g.drawRect(xi,yi,100,25);

            g.setFont(new Font("TimesRoman", Font.PLAIN, 12));

            g.drawString(""+root.getHijoIz().getEdad(),xi,yi+20);

            root.getHijoIz().setPosY(yi);

            root.getHijoIz().setPosX(xi);
        }
    }

    public void DrawAVL(Graphics g){
        g.setColor(Color.WHITE);
        g.fillRect(0,0,800,600);

        g.setColor(Color.BLACK);

        Node cabeza=OleadaDibujar.getRootAVL();

        if (cabeza==null){
            return;
        }

        int yi=275;
        int xi=margen*120;

        g.drawRect(xi,yi,100,25);

        g.setFont(new Font("Calibri", Font.PLAIN, 12));

        g.drawString(""+cabeza.key.getEdad(),xi,yi+20);

        cabeza.key.setPosY(yi);

        cabeza.key.setPosX(xi);

        dibujarArbol(g,cabeza,2,xi,yi);

    }

    public void dibujarArbol(Graphics g,Node root,int nivel,int x,int y){
        if (root!=null){
            dibujarArbol(g,root.right,1+nivel,x+200, y-(600)/(int)Math.pow(2,nivel));
            dibujarHijos(g,root,nivel,x,y);
            dibujarArbol(g,root.left,1+nivel,x+200, y+(600)/(int)Math.pow(2,nivel));
        }
    }

    public void dibujarHijos(Graphics g, Node node, int nivel, int x, int y){
        int xi=x+200;
        int yi;


        if (node.right != null) {
            yi=y-(600)/(int)Math.pow(2,nivel);

            g.drawString(""+node.right.key.getEdad(),xi,yi+20);

            g.drawRect(xi,yi,100,25);

            g.setFont(new Font("TimesRoman", Font.PLAIN, 12));

            node.right.key.setPosY(yi);

            node.right.key.setPosX(xi);
        }


        if (node.left != null) {
            yi=y+(600)/(int)Math.pow(2,nivel);

            g.drawString(""+node.left.key.getEdad(),xi,yi+20);

            g.drawRect(xi,yi,100,25);

            g.setFont(new Font("TimesRoman", Font.PLAIN, 12));

            node.left.key.setPosY(yi);

            node.left.key.setPosX(xi);
        }
    }

    public void DrawArray(){
        Dragon[] D= OleadaDibujar.getDragonesDibujar();
        int largo=D.length;
        int margenlocal=margen;
        int pos=0;
        int fila=0;

        while (pos<largo){
        	
        	int xi=100+ margenlocal *120;
        	int yi=10+fila*50;

            D[pos].getLabel().setBounds(xi,yi,100,25);
            D[pos].getLabel().setVisible(true);
            D[pos].setPosY(yi);

            D[pos].setPosX(xi);

            if (Bloqueos[pos]){
                fila+=2;
            }
            else{
                fila++;
            }
            add(D[pos].getLabel());
            pos++;

            if (fila>9){
                fila=0;
                margenlocal++;
            }
        }
        //this.margen++;
    }

}