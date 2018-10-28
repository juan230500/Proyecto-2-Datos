package GUI;


import adt.Node;
import juego.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.*;

/**
 * Clase: Fondo
 * @author Andrey Sanchez
 * @version 26.10.2018
 */

public class Fondo extends JPanel implements KeyListener {
    private boolean juego = true;
    private int margen;
    private Oleada OleadaDibujar;

    /**
     * Getter
     * @return OleadaDibujar
     */

    public Oleada getOleadaDibujar() {

        return OleadaDibujar;
    }

    public void setFuego(boolean valor){
        this.fuego = valor;
    }

    /**
     * Setter
     * @param juego
     */

    public void setJuego(boolean juego) {

        this.juego = juego;
    }

    private JLabel sidescroller = new JLabel();

    /**
     * Getter
     * @return caballero
     */

    public Caballero getCaballero() {

        return caballero;
    }

    private Caballero caballero = new Caballero();
    private JLabel grifo = caballero.getLabel();
    private JLabel etiqueta2 =new JLabel();
    private int x1=1000;
    private int x2=1000;
    private int largo = 1366-400;
    private int alto = 768;
    private int CantidadOriginal;
    private int ronda;
    private int anchoDragon;
    private int tamanoLetra;
    private boolean fuego = false;

    /**
     * Getter
     * @return h1
     */

    public HiloOleada getH1() {

        return h1;
    }



    private HiloOleada h1;


    /**
     * Getter
     * @return h3
     */

    public Hilo_DR getH3() {

        return h3;
    }

    /**
     * Getter
     * @return h4
     */

    public Hilo_DE getH4() {

        return h4;
    }

    private Hilo_DR h3;
    private Hilo_DE h4;

    /**
     * Default constructor
     */

    public Fondo() {
        setLayout(null);
        setBounds(0, 0, largo, alto);
        setMaximumSize(new Dimension(800, 600));
        setBackground(new Color(150,220,255));

        ImageIcon imagen = new ImageIcon("src/MultiMedia/MontanasFondo.gif");
        //ImageIcon imagen2 = new ImageIcon("C:/Users/andre/Desktop/nubes1.gif");

        //JLabel nubes = new JLabel(imagen2);
        //nubes.setBounds(0, 0,largo,alto);
        sidescroller.setIcon(imagen);
        sidescroller.setBounds(10,270,1300,alto);
        add(grifo);
        this.margen =0;
        this.CantidadOriginal=100;
        this.ronda=1;
        this.OleadaDibujar=new Oleada(this.CantidadOriginal,this.ronda, this, this.caballero);
        this.juego=true;
        this.anchoDragon=12;
        this.tamanoLetra=10;
        CicloSetTamanoLetra();
        DrawArray();
        //DrawABB();
        //DrawAVL();
        addKeyListener(this);
        setFocusable(true);

        HiloOleada hilito1=new HiloOleada(this);  //Hilo que crea el movimiento de la oleada
        this.h1 = hilito1;
        add(sidescroller);
        //add(nubes);
    }

    public void  reiniciar(){
        h1.stop();
        caballero.setDragonesQuePasaron(0);
        setBackground(new Color(150,220,255));
        this.margen =0;
        this.CantidadOriginal*=1.2;
        this.ronda++;
        this.OleadaDibujar=new Oleada(this.CantidadOriginal,this.ronda, this, this.caballero);
        this.juego=true;
        DrawArray();
        addKeyListener(this);
        setFocusable(true);

        HiloOleada hilito1=new HiloOleada(this);  //Hilo que crea el movimiento de la oleada
        this.h1 = hilito1;
        add(sidescroller);
    }

    /*public void crearLabel(){

        etiqueta2.setText("Dragon2");
        etiqueta2.setBounds(x2,450,60,60);
        this.add(etiqueta2);
        Hilo_DR hilo_dr = new Hilo_DR(etiqueta2, this);
        h3 = hilo_dr;

    }*/

    /**
     * Metodo usado por el HiloOleada para mover la oleada en conjunto
     */

    public void moverlabel(){
        int largo=OleadaDibujar.getCantidadDragones();
        Dragon[] DragonesADibujar=OleadaDibujar.toArray();
        for (int i = 0; i< largo; i ++) {
            DragonesADibujar[i].setPosX(DragonesADibujar[i].getPosX()- 1);
            DragonesADibujar[i].getLabel().setLocation(DragonesADibujar[i].getPosX(), DragonesADibujar[i].getPosY());

        }
    }


    /**
     * Metodo para que los dragones o enemigos disparen
     * @param dra
     */

    public void disparoDragon(JLabel dra){
        JLabel disp = new JLabel();
        disp.setText("O");
        disp.setBounds(dra.getX() - 10, dra.getY() + 25, 10, 10);
            add(disp);
            if ((disp.getX() > grifo.getX() + grifo.getWidth()) || (disp.getY() > grifo.getY() + grifo.getHeight()) || (disp.getX() < grifo.getX()) || (disp.getY() < grifo.getY())) {
                disp.setBounds(disp.getX() - 5, disp.getY(), 10, 10);
            } else {
                caballero.recibir_daño();
                disp.setBounds(1400, 1000, 10, 10);
            }
            disp.setVisible(true);
    }


    /**
     *Verifica cuando se tocan las teclas W,A,S,D que se usan como direccionales y cuando se tocan dos de estas al mismo tiempo
     * @param e
     */
    @Override
    public void keyTyped(KeyEvent e) {
        if (!juego){
            reiniciar();
            return;
        }
        //JLabel grifo = caballero.getLabel();
        if (caballero.isChoque()== false) {
            if (grifo.getX()+80 + 5 < largo && grifo.getX() - 5 > -5 && grifo.getY() - 5 > -5 && grifo.getY()+50 + 5 < alto) {
                if (e.getKeyChar() == 'w' && e.getKeyChar() == 'd') {
                    grifo.setLocation(grifo.getX() + 5, grifo.getY() - 5);
                }
                if (e.getKeyChar() == 'w' && e.getKeyChar() == 'a') {
                    grifo.setLocation(grifo.getX() - 5, grifo.getY() - 5);
                }
                if (e.getKeyChar() == 's' && e.getKeyChar() == 'd') {
                    grifo.setLocation(grifo.getX() + 5, grifo.getY() + 5);
                }
                if (e.getKeyChar() == 's' && e.getKeyChar() == 'a') {
                    grifo.setLocation(grifo.getX() - 5, grifo.getY() + 5);
                } else if (e.getKeyChar() == 'w') {
                    grifo.setLocation(grifo.getX(), grifo.getY() - 5);
                } else if (e.getKeyChar() == 's') {
                    grifo.setLocation(grifo.getX(), grifo.getY() + 5);
                } else if (e.getKeyChar() == 'a') {
                    grifo.setLocation(grifo.getX() - 5, grifo.getY());
                } else if (e.getKeyChar() == 'd') {
                    grifo.setLocation(grifo.getX() + 5, grifo.getY());
                }
            } else {
                if (grifo.getX()+80 + 5 >= largo) {
                    grifo.setLocation(largo-86, grifo.getY());
                } else if (grifo.getX() - 5 <= -5) {
                    grifo.setLocation(1, grifo.getY());
                } else if ( grifo.getY()+50 + 5  >= alto) {
                    grifo.setLocation(grifo.getX(), alto-56);
                } else if (grifo.getY() - 5 <= -5) {
                    grifo.setLocation(grifo.getX(), 1);
                }
            }
            caballero.colisionEnem(etiqueta2);
        }
        else{
            caballero.setChoque(false);
        }
    }





    /**
     * Verifica cuando se tocan las flechas y cuando se tocan dos de estas al mismo tiempo, verifica que no exista colision y si la hay "resetea" al caballero y detecta cuando se ataca
     * @param e
     */
    @Override
    public void keyPressed(KeyEvent e) {
        if (!juego){
            reiniciar();
            return;
        }
        //JLabel grifo = caballero.getLabel();
        if (caballero.isChoque()== false) {
            if (grifo.getX()+80 + 5 < largo && grifo.getX() - 5 > -5 && grifo.getY() - 5 > -5 && grifo.getY()+50 + 5 < alto) {
                if ((e.getExtendedKeyCode() == KeyEvent.VK_SPACE) && !fuego){
                    Disparo d = new Disparo(this.grifo.getX() + this.grifo.getWidth(), this.grifo.getY() + (this.grifo.getHeight() / 2));
                    Dragon toImpact = OleadaDibujar.MasCercanoPorAltura(d.getPosY());
                    fuego = true;
                    if(toImpact== null){
                        caballero.atacar(this);
                    }
                    else {
                        boolean isKill=false;
                        caballero.atacar(toImpact, d,OleadaDibujar,this, fuego);
                    }
                    caballero.getDisparo().setBounds(100,300,10,10);
                    add(caballero.getDisparo());
                }
                if (e.getExtendedKeyCode() == KeyEvent.VK_UP && e.getExtendedKeyCode() == KeyEvent.VK_LEFT) {
                    grifo.setLocation(grifo.getX() - 5, grifo.getY() - 5);
                }
                if (e.getExtendedKeyCode() == KeyEvent.VK_DOWN && e.getExtendedKeyCode() == KeyEvent.VK_LEFT) {
                    grifo.setLocation(grifo.getX() - 5, grifo.getY() + 5);
                }
                if (e.getExtendedKeyCode() == KeyEvent.VK_UP && e.getExtendedKeyCode() == KeyEvent.VK_RIGHT) {
                    grifo.setLocation(grifo.getX() + 5, grifo.getY() - 5);
                }
                if (e.getExtendedKeyCode() == KeyEvent.VK_DOWN && e.getExtendedKeyCode() == KeyEvent.VK_RIGHT) {
                    grifo.setLocation(grifo.getX() + 5, grifo.getY() + 5);
                } else if (e.getExtendedKeyCode() == KeyEvent.VK_UP) {
                    grifo.setLocation(grifo.getX(), grifo.getY() - 5);
                } else if (e.getExtendedKeyCode() == KeyEvent.VK_DOWN) {
                    grifo.setLocation(grifo.getX(), grifo.getY() + 5);
                } else if (e.getExtendedKeyCode() == KeyEvent.VK_LEFT) {
                    grifo.setLocation(grifo.getX() - 5, grifo.getY());
                } else if (e.getExtendedKeyCode() == KeyEvent.VK_RIGHT) {
                    grifo.setLocation(grifo.getX() + 5, grifo.getY());
                }
            } else {
                if (grifo.getX()+80 + 5 >= largo) {
                    grifo.setLocation(largo-86, grifo.getY());
                } else if (grifo.getX() - 5 <= -5) {
                    grifo.setLocation(1, grifo.getY());
                } else if ( grifo.getY()+50 + 5  >= alto) {
                    grifo.setLocation(grifo.getX(), alto-56);
                } else if (grifo.getY() - 5 <= -5) {
                    grifo.setLocation(grifo.getX(), 1);
                }
            }
        }
        else{
            caballero.setChoque(false);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
    
    public void CicloSetTamanoLetra() {
    	Dragon[] D= OleadaDibujar.getDragonesDibujar();
    	int largo=D.length;
    	for (int i=0;i<largo;i++) {
    		D[i].getLabel().setFont(new Font("Calibri", Font.PLAIN, tamanoLetra));
    	}
    }

    /**
     * Metodo para dibujar en pantalla la oleada como un Array
     */

    public void DrawArray(){
        Dragon[] D= OleadaDibujar.getDragonesDibujar();
        int largo=D.length;
        int margenlocal=margen;
        int pos=0;
        int fila=0;

        while (pos<largo){

            int xi=600+ margenlocal *100;
            int yi=40+fila*55;

            D[pos].getLabel().setBounds(xi,yi,100,anchoDragon);

            D[pos].setPosY(yi);
            D[pos].setPosX(xi);

            add(D[pos].getLabel());


            fila++;

            pos++;

            if (fila>11){
                fila=0;
                margenlocal++;
            }
        }
        //this.margen++;
    }

    /**
     * Metodo para dibujar en pantalla la oleada como un ABB
     */

    public void DrawABB(){
        Dragon cabeza=OleadaDibujar.getRoot();
        if (cabeza==null){
            return;
        }

        int yi=alto/2;
        int xi=200;

        cabeza.getLabel().setBounds(xi,yi+20,100,anchoDragon);

        cabeza.setPosY(yi);
        cabeza.setPosX(xi);

        cabeza.getLabel().setVisible(true);

        add(cabeza.getLabel());

        dibujarArbol(cabeza,2,xi,yi);

    }

    /**
     * Metodo auxiliar de DrawABB
     * @param root
     * @param nivel
     * @param x
     * @param y
     */
    
    int altoseparacion=700;

    public void dibujarArbol(Dragon root,int nivel,int x,int y){
        if (root!=null){
            dibujarArbol(root.getHijoDer(),1+nivel,x+100, y-(alto)/(int)Math.pow(2,nivel));
            dibujarHijos(root,nivel,x,y);
            dibujarArbol(root.getHijoIz(),1+nivel,x+100, y+(alto)/(int)Math.pow(2,nivel));
        }
    }

    /**
     * Metodo auxiliar de DrawABB
     * @param root
     * @param nivel
     * @param x
     * @param y
     */

    public void dibujarHijos(Dragon root,int nivel,int x,int y){
        int xi=x+100;
        int yi;
        if (root.getHijoDer() != null) {
            yi=y-(altoseparacion)/(int)Math.pow(2,nivel);
            root.getHijoDer().getLabel().setBounds(xi,yi,100,anchoDragon);

            root.getHijoDer().setPosY(yi);
            root.getHijoDer().setPosX(xi);
            
            root.getHijoDer().getLabel().setVisible(true);
            add(root.getHijoDer().getLabel());
        }

        if (root.getHijoIz() != null) {
            yi=y+(altoseparacion)/(int)Math.pow(2,nivel);
            root.getHijoIz().getLabel().setBounds(xi, yi, 100, anchoDragon);

            root.getHijoIz().setPosY(yi);
            root.getHijoIz().setPosX(xi);
            
            root.getHijoIz().getLabel().setVisible(true);
            add(root.getHijoIz().getLabel());
        }

    }

    /**
     * Metodo para dibujar la oleada como un arbol AVL
     */

    public void DrawAVL(){

        Node cabeza=OleadaDibujar.getRootAVL();

        if (cabeza==null){
            return;
        }

        int yi=alto/2-12;
        int xi=100;

        cabeza.key.getLabel().setBounds(xi,yi,100,anchoDragon);


        cabeza.key.setPosY(yi);

        cabeza.key.setPosX(xi);
        cabeza.key.getLabel().setVisible(true);
        add(cabeza.key.getLabel());
        dibujarArbol(cabeza,2,xi,yi);

    }

    /**
     * Metodo auxiliar de DrawAVL
     * @param root
     * @param nivel
     * @param x
     * @param y
     */

    public void dibujarArbol(Node root,int nivel,int x,int y){
        if (root!=null){
            dibujarArbol(root.right,1+nivel,x+100, y-(altoseparacion)/(int)Math.pow(2,nivel));
            dibujarHijos(root,nivel,x,y);
            dibujarArbol(root.left,1+nivel,x+100, y+(altoseparacion)/(int)Math.pow(2,nivel));
        }
    }

    /**
     * Metodo auxiliar de DrawAVL
     * @param node
     * @param nivel
     * @param x
     * @param y
     */

    public void dibujarHijos(Node node, int nivel, int x, int y){
        int xi=x+100;
        int yi;


        if (node.right != null) {
            yi=y-(altoseparacion)/(int)Math.pow(2,nivel);


            node.right.key.getLabel().setBounds(xi,yi,100,anchoDragon);


            node.right.key.setPosY(yi);

            node.right.key.setPosX(xi);
            node.right.key.getLabel().setVisible(true);
            add(node.right.key.getLabel());
        }


        if (node.left != null) {
            yi=y+(altoseparacion)/(int)Math.pow(2,nivel);

            node.left.key.getLabel().setBounds(xi,yi,100,anchoDragon);


            node.left.key.setPosY(yi);

            node.left.key.setPosX(xi);
            node.left.key.getLabel().setVisible(true);
            add(node.left.key.getLabel());
        }
    }


}