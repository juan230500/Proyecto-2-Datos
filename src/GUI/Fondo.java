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
    private String LogInfo="1";

    public String addLogger(){
        return LogInfo;
    }

    public void addInfo(String info){
        this.LogInfo = info;
    }

    /**
     * Getter
     * @return OleadaDibujar
     */

    public Oleada getOleadaDibujar() {

        return OleadaDibujar;
    }

    private boolean[] Bloqueos;

    /**
     * Setter
     * @param juego
     */

    public void setJuego(boolean juego) {

        this.juego = juego;
    }

    private JLabel lbl = new JLabel();

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

    /**
     * Getter
     * @return h1
     */

    public HiloOleada getH1() {

        return h1;
    }

    /**
     * Getter
     * @return h2
     */

    public Hilos getH2() {

        return h2;
    }

    private HiloOleada h1;
    private Hilos h2;

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

        //ImageIcon imagen = new ImageIcon("C:/Users/andre/Desktop/fondo.png");


        lbl.setText("Su madre");
        lbl.setBounds(100,200,20,20);
        add(grifo);
        add(lbl);
        this.margen =0;
        this.OleadaDibujar=new Oleada(100);
        this.Bloqueos=new boolean[100];
        DrawArray();
        addKeyListener(this);
        setFocusable(true);

        HiloOleada hilito1=new HiloOleada(this);  //Hilo que crea el movimiento de la oleada
        this.h1 = hilito1;
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
        for (int i = 0; i< OleadaDibujar.getCantidadDragones(); i ++) {
            OleadaDibujar.getDragonesDibujar()[i].setPosX(OleadaDibujar.getDragonesDibujar()[i].getPosX()- 1);
            OleadaDibujar.getDragonesDibujar()[i].getLabel().setLocation(OleadaDibujar.getDragonesDibujar()[i].getPosX(), OleadaDibujar.getDragonesDibujar()[i].getLabel().getY());
            //System.out.println("muevo al dragon 1");
        }
    }

    /*public void moverDragon(Dragon dg){
        while(dg.getResistencia()!= 0){
            if(dg.getX() <= -20){
                caballero.setDragonesQuePasaron(caballero.getDragonesQuePasaron()+1);
                return dg.setVisible(false);
            }
            else{
                dg.setLocation(x2,etiqueta2.getY());
                System.out.println("muevo al dragon 1");
                dg.setX(gd.getX() - 1);
            }
        }
    }
    */

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
        System.out.println("ohh");
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
            //System.out.print(grifo.getX() + "\t");
            //System.out.println(grifo.getY());
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
        //JLabel grifo = caballero.getLabel();
        if (caballero.isChoque()== false) {
            if (grifo.getX()+80 + 5 < largo && grifo.getX() - 5 > -5 && grifo.getY() - 5 > -5 && grifo.getY()+50 + 5 < alto) {
                if (e.getExtendedKeyCode() == KeyEvent.VK_SPACE){
                    Disparo d = new Disparo(this.grifo.getX() + this.grifo.getWidth(), this.grifo.getY() + (this.grifo.getHeight() / 2));
                    addInfo("Ataque nuevo");
                    if(OleadaDibujar.MasCercanoPorAltura(d.getPosY())== null){
                        caballero.atacar();
                    }
                    else {
                        caballero.atacar(OleadaDibujar.MasCercanoPorAltura(d.getPosY()).getLabel(), d);
                    }
                    caballero.getDisparo().setBounds(100,300,10,10);
                    add(caballero.getDisparo());
                    OleadaDibujar.HerirDragon(OleadaDibujar.MasCercanoPorAltura(d.getPosY()));
                    //OleadaDibujar.MasCercanoPorAltura(d.getPosY()+25).getLabel().setVisible(false);
                    //caballero.getDisparo().setLocation(20,20);
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
            System.out.print(grifo.getX() + "\t");
            System.out.println(grifo.getY());
        }
        else{
            caballero.setChoque(false);
        }
        for (int i=0; i<OleadaDibujar.getDragonesDibujar().length;i++) {
            Dragon dg = OleadaDibujar.getDragonesDibujar()[i];
            caballero.colisionEnem(dg.getLabel());
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

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

            int xi=600+ margenlocal *120;
            int yi=100+fila*50;

            D[pos].getLabel().setBounds(xi,yi,100,25);
            D[pos].getLabel().setVisible(true);
            D[pos].setPosY(yi);

            D[pos].setPosX(xi);
            add(D[pos].getLabel());
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

        int yi=275;
        int xi=500;

        cabeza.getLabel().setBounds(xi,yi+20,100,25);

        cabeza.getLabel().setFont(new Font("Calibri", Font.PLAIN, 12));


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

    public void dibujarArbol(Dragon root,int nivel,int x,int y){
        if (root!=null){
            dibujarArbol(root.getHijoDer(),1+nivel,x+200, y-(600)/(int)Math.pow(2,nivel));
            dibujarHijos(root,nivel,x,y);
            dibujarArbol(root.getHijoIz(),1+nivel,x+200, y+(600)/(int)Math.pow(2,nivel));
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
        int xi=x+200;
        int yi;
        if (root.getHijoDer() != null) {
            yi=y-(600)/(int)Math.pow(2,nivel);
            root.getHijoDer().getLabel().setBounds(xi,yi+20,100,25);
            root.getHijoDer().getLabel().setFont(new Font("TimesRoman", Font.PLAIN, 12));

            root.getHijoDer().setPosY(yi);

            root.getHijoDer().setPosX(xi);
            root.getHijoDer().getLabel().setVisible(true);
            add(root.getHijoDer().getLabel());
        }

        if (root.getHijoIz() != null) {
            yi=y+(600)/(int)Math.pow(2,nivel);
            root.getHijoIz().getLabel().setBounds(xi, yi+20, 100, 25);

            root.getHijoIz().getLabel().setFont(new Font("TimesRoman", Font.PLAIN, 12));

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

        int yi=275;
        int xi=600;

        cabeza.key.getLabel().setBounds(xi,yi,100,50);

        cabeza.key.getLabel().setFont(new Font("Calibri", Font.PLAIN, 12));

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
            dibujarArbol(root.right,1+nivel,x+200, y-(600)/(int)Math.pow(2,nivel));
            dibujarHijos(root,nivel,x,y);
            dibujarArbol(root.left,1+nivel,x+200, y+(600)/(int)Math.pow(2,nivel));
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
        int xi=x+200;
        int yi;


        if (node.right != null) {
            yi=y-(600)/(int)Math.pow(2,nivel);


            node.right.key.getLabel().setBounds(xi,yi,100,25);

            node.right.key.getLabel().setFont(new Font("TimesRoman", Font.PLAIN, 12));

            node.right.key.setPosY(yi);

            node.right.key.setPosX(xi);
            node.right.key.getLabel().setVisible(true);
            add(node.right.key.getLabel());
        }


        if (node.left != null) {
            yi=y+(600)/(int)Math.pow(2,nivel);

            node.left.key.getLabel().setBounds(xi,yi,100,25);

            node.right.key.getLabel().setFont(new Font("TimesRoman", Font.PLAIN, 12));

            node.left.key.setPosY(yi);

            node.left.key.setPosX(xi);
            node.left.key.getLabel().setVisible(true);
            add(node.left.key.getLabel());
        }
    }
}