package GUI;


import adt.Node;
import com.panamahitek.ArduinoException;
import com.panamahitek.PanamaHitek_Arduino;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;
import juego.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Random;

/**
 * Esta es la clase es la que se encarga de la logica de que todos los componentes del proyecto
 * funcione conjutamente en la clase pantalla
 * @version 26.10.2018
 */

public class Fondo extends JPanel implements KeyListener {
    private boolean juego = true;
    private int margen;
    private Oleada OleadaDibujar;
    private boolean bandera_inicio = true;

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
    private Pantalla PantallaUso;
    private static int b;

    /**
     * Getter
     * @return h1
     */

    public HiloOleada getH1() {

        return h1;
    }



    private HiloOleada h1;

    Hilo_contrl h5;


    /**
     * Getter
     * @return h3
     */

    public Hilo_Disparos getH3() {

        return h3;
    }


    private Hilo_Disparos h3;


    private Hilo_DE h4;
    private static PanamaHitek_Arduino ino = new PanamaHitek_Arduino();
    private static final SerialPortEventListener listener = new SerialPortEventListener() {

        @Override
        /**
         * este metodo funciona para realizar la comunicacion serial del control con el java
         */
        public void serialEvent(SerialPortEvent serialPortEvent) {
            try {
                if (ino.isMessageAvailable()) {
                    //Se imprime el mensaje recibido en la consola
                    String info=ino.printMessage();
                    String x = info.substring(2,6);
                    x=x.replace("|","");
                    String Y = info.substring(11,15);
                    Y=Y.replace("|","");
                    String boton=info.substring(24);
                    boton=boton.replace(":","");
                    boton=boton.replace("r","");
                    boton=boton.replace("o","");
                    boton=boton.replace("d","");
                    boton=boton.replaceAll("\\s","");
                    //System.out.println(boton);
                    Y=Y.replaceAll("\\s","");
                    x=x.replaceAll("\\s","");
                    b = Integer.parseInt(boton);
                    //contrx = Integer.parseInt(x);
                    //contry = Integer.parseInt(Y);
                    System.out.println(b);

                }
            } catch (SerialPortException | ArduinoException ex) {
                Logger.getLogger(Fondo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    };


    /**
     * Default constructor que recibe la pantalla como argumento  para saber que pantalla lo esta usando
     */

    public Fondo(Pantalla LaPantalla) {
        try {
            ino.arduinoRX("COM10", 9600, listener);
        } catch (ArduinoException | SerialPortException ex) {
            Logger.getLogger(Fondo.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.PantallaUso=LaPantalla;
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
        this.CantidadOriginal=6;
        this.ronda=1;
        this.OleadaDibujar=new Oleada(this.CantidadOriginal,this.ronda, this, this.caballero);
        this.juego=true;
        this.anchoDragon=12;
        this.tamanoLetra=10;
        CicloSetTamanoLetra();
        DrawArray();
        //DrawABB();
        //DrawAVL();
        h5 = new Hilo_contrl(this);
        addKeyListener(this);
        setFocusable(true);

        HiloOleada hilito1=new HiloOleada(this);  //Hilo que crea el movimiento de la oleada
        this.h1 = hilito1;
        this.h3 = new Hilo_Disparos(this);
        add(sidescroller);
    }

    public Pantalla getPantallaUso() {
        return PantallaUso;
    }
    /**
     * este metodo funciona para  crear una nueva oleada incremetada en un 20 %
     */
    public void  reiniciar(){
        h1.stop();

        bandera_inicio = true;

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
        this.PantallaUso.ActulizarArbolB(OleadaDibujar.toArray(),OleadaDibujar.getCantidadDragones());
        HiloOleada hilito1=new HiloOleada(this);  //Hilo que crea el movimiento de la oleada
        this.h1 = hilito1;
        this.h3 = new Hilo_Disparos(this);
        add(sidescroller);
    }
    
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
    public void movercontrol() {
        if (!juego) {
            reiniciar();
            return;
        }
        //JLabel grifo = caballero.getLabel();
        if (caballero.isChoque() == false) {
            if (grifo.getX() + 80 + 5 < largo && grifo.getX() - 5 > -5 && grifo.getY() - 5 > -5 && grifo.getY() + 50 + 5 < alto) {
                if (b == 0&&!fuego) {

                    Disparo d = new Disparo(this.grifo.getX() + this.grifo.getWidth(), this.grifo.getY() + (this.grifo.getHeight() / 2));
                    Dragon toImpact = OleadaDibujar.MasCercanoPorAltura(d.getPosY());
                    this.fuego=true;
                    if (toImpact == null) {
                        caballero.atacar(this);
                    } else {
                        boolean isKill = false;
                        caballero.atacar(toImpact, d,OleadaDibujar,this, fuego);
                    }
                    caballero.getDisparo().setBounds(100, 300, 10, 10);
                    add(caballero.getDisparo());
                }
            }
        }
    }
    /**
     * este metodo funciona para crear el disparo de todos lo enemigos
     */
    public void disparos(){
        Dragon dra;
        Random random = new Random();
        int r1 = random.nextInt(OleadaDibujar.getCantidadDragones());
        dra = OleadaDibujar.toArray()[r1];
        System.out.println(r1);
        ImageIcon img = new ImageIcon("src/MultiMedia/shoot.gif");


        if (dra.getRecarga() <= 33) {
            JLabel disp = new JLabel(img);

            disp.setBounds(dra.getLabel().getX() - 10, dra.getLabel().getY() + 5, 10, 10);

            add(disp);

            Hilo_DE hilitodisp1 = new Hilo_DE(disp, this);
        }
        if ((dra.getRecarga() > 33) && (dra.getRecarga() < 66)) {
            JLabel disp1 = new JLabel(img);
            JLabel disp2 = new JLabel(img);

            disp1.setBounds(dra.getLabel().getX() - 10, dra.getLabel().getY() + 5, 10, 10);
            disp2.setBounds(dra.getLabel().getX() - 40, dra.getLabel().getY() + 5, 10, 10);

            add(disp1);
            add(disp2);

            Hilo_DE hilitodisp1 = new Hilo_DE(disp1, this);
            Hilo_DE hilitodisp2 = new Hilo_DE(disp2, this);
        }
        if (dra.getRecarga() >= 66) {
            JLabel disp1 = new JLabel(img);
            JLabel disp2 = new JLabel(img);
            JLabel disp3 = new JLabel(img);



            disp1.setBounds(dra.getLabel().getX() - 10, dra.getLabel().getY() + 5, 10, 10);
            disp2.setBounds(dra.getLabel().getX() - 40, dra.getLabel().getY() + 5, 10, 10);
            disp3.setBounds(dra.getLabel().getX() - 70, dra.getLabel().getY() + 5, 10, 10);

            add(disp1);
            add(disp2);

            Hilo_DE hilitodisp1 = new Hilo_DE(disp1, this);
            Hilo_DE hilitodisp2 = new Hilo_DE(disp2, this);
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo para que los dragones o enemigos disparen osea para que se mueva
     */


    public void moverDisp(JLabel disp){
        while(juego && disp.getX() > -10){
            if ((disp.getX() > grifo.getX() + grifo.getWidth()) || (disp.getY() > grifo.getY() + grifo.getHeight()) || (disp.getX() < grifo.getX()) || (disp.getY() < grifo.getY())) {
                disp.setLocation(disp.getX() - 5, disp.getY());
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else{
                caballero.recibir_daño();
                System.out.println(caballero.getVida());
                disp.setLocation(1400, 1000);
                JLabel colision = new JLabel();
                ImageIcon img = new ImageIcon("src/MultiMedia/Boom.gif");
                colision.setIcon(img);
                colision.setBounds(grifo.getX()+50, grifo.getY()+5, 50, 21);
                this.add(colision);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                colision.setVisible(false);
            }
        }
        disp.setVisible(false);
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
            if (bandera_inicio){
                D[pos].getLabel().setBounds(xi,yi,100,anchoDragon);

            }


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
        bandera_inicio = false;
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
        int xi=600;

        //cabeza.getLabel().setBounds(xi,yi+20,100,anchoDragon);
        //animar();

        cabeza.setPosY(yi);
        cabeza.setPosX(xi);

        cabeza.getLabel().setVisible(true);

        add(cabeza.getLabel());

        dibujarArbol(cabeza,2,xi,yi);

    }

    public JLabel[] mostrarColores() {
        int criterio = this.OleadaDibujar.getFormacion() % 5;
        JLabel[] array3 = new JLabel[OleadaDibujar.getCantidadDragones()];
        if (criterio == 0 || criterio == 2 || criterio == 4) {
            for (int i = 0; i < OleadaDibujar.getCantidadDragones(); i++) {
                //array1[i].setIcon(imagen);
                Dragon dtmp = (Dragon) OleadaDibujar.toArray()[i];
                array3[i] = new JLabel();
                array3[i].setBounds(dtmp.getLabel().getX(), dtmp.getLabel().getY() - 50, 100, 50);
                //array3[i].setText("RCR: " + dtmp.getRecarga());
                //array3[i].setForeground(coloresEtiquetasVrcr(dtmp.getRecarga()));
                array3[i].setText("Edad: " + dtmp.getEdad());
                array3[i].setForeground(coloresEtiquetasEdad(dtmp.getEdad()));
                add(array3[i]);
            }
        } else if (criterio == 1) {
            for (int i = 0; i < OleadaDibujar.getCantidadDragones(); i++) {
                //array1[i].setIcon(imagen);
                Dragon dtmp = (Dragon) OleadaDibujar.toArray()[i];
                array3[i] = new JLabel();
                array3[i].setBounds(dtmp.getLabel().getX(), dtmp.getLabel().getY() - 50, 50, 50);
                array3[i].setText("RCR: " + dtmp.getRecarga());
                array3[i].setForeground(coloresEtiquetasVrcr(dtmp.getRecarga()));
                add(array3[i]);
                //array3[i].setText("Edad: "+dtmp.getEdad());
                //array3[i].setForeground(coloresEtiquetasEdad(dtmp.getEdad()));
            }
        } else if (criterio == 3) {
            AsignarNivel();
            for (int i = 0; i < OleadaDibujar.getCantidadDragones(); i++) {
                //array1[i].setIcon(imagen);
                Dragon dtmp = (Dragon) OleadaDibujar.toArray()[i];
                array3[i] = new JLabel();
                array3[i].setBounds(dtmp.getLabel().getX(), dtmp.getLabel().getY() - 15, 50, 50);
                array3[i].setText("Gen: " + dtmp.getNivel());
                array3[i].setForeground(coloresEtiquetasGen(dtmp.getNivel()));
                add(array3[i]);
            }
        } return array3;
    }

    public void AsignarNivel(){
        AsignarNivelrec(OleadaDibujar.getRoot(),0);
    }

    public void AsignarNivelrec(Dragon root,int nivel){
        if (root!=null){
            AsignarNivelrec(root.getHijoIz(),nivel+1);
            root.setNivel(nivel);
            AsignarNivelrec(root.getHijoDer(),nivel+1);
        }
    }

    public void quitarColores(JLabel[] array3){
        for (int i = 0; i < array3.length; i++) {
            array3[i].setVisible(false);
        }
    }

    public Color coloresEtiquetasEdad(int edad){
        int r = (edad * 255)/1000;
        Color color = new Color(0+r,255-r,10);
        return color;
    }

    public Color coloresEtiquetasVrcr(int vrcr){
        int r = (vrcr * 255)/100;
        Color color = new Color(0+r,255-r,10);
        return color;
    }

    public Color coloresEtiquetasGen(int gen){
        int r = (gen * 255)/8;
        Color color = new Color(0+r,255-r,10);
        return color;
    }

    public void animar(){
        JLabel[] array3 = mostrarColores();
        h1.pausa = true;
        Dragon[] dragones = OleadaDibujar.toArray();
        float m;
        float b;

        for (int i = 0; i<OleadaDibujar.getCantidadDragones(); i++) {
            Dragon dtmp = (Dragon) dragones[i];

            float x1 = dtmp.getPosXinicial();
            float y1 = dtmp.getPosYinicial();
            float x2 = dtmp.getPosX();
            float y2 = dtmp.getPosY();

            m = (y2 - y1) / (x2 - x1);
            b = y1 - (m * x1);
            //System.out.println(y2-y1);

            float movx = (x2 - x1) / 40;

            float xi = x1;
            float yi;

            while ((xi < x2)) {
                //int movx = (i1 - i2)/20;
                //int movy = (j1 - j2)/20;
                xi += movx;
                yi = m * xi + b;

                dtmp.getLabel().setLocation((int) xi, (int) yi);
                array3[i].setLocation((int)xi, (int)yi-50);
                try {
                  Thread.sleep(5);
           } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        quitarColores(array3);
        h1.pausa = false;

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
        int xi=600;

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