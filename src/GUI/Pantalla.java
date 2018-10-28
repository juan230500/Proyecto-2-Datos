package GUI;

import ArbolB.Raiz;
import adt.BTree;
import juego.Dragon;
import juego.Oleada;

import java.awt.*;
import javax.swing.*;
import java.util.*;

/**
 * Clase: Pantalla
 * @author Andrey Sanchez
 * @version 26/10/2018
 */

public class Pantalla extends JFrame {
    private boolean juego = true;
    private JLabel label = new JLabel();
    private JLabel label2 = new JLabel();
    private Fondo fondo;
    private InfoLayout i_layP ;
    private InfoDragon i_draP ;
    private InfoTree i_treeP ;
    private Hilo_F hPrin;
    private String raiz;
    private String pag1="";
    private String pag2="";
    private String pag3="";
    private String pag4="";
    private Raiz ArbolB;
    //private JTextArea areaTexto=null;
    private Raiz raiz1;
    private int Oleadasize=0;
    private JTextArea areaTexto=new JTextArea();
    private JScrollPane scroll=new JScrollPane(areaTexto);
    //******************************************************************
    public String raizEnPartes(int valor){
        String numero="";
        int comaEncontrada=0;
        for (int i = 0; i < raiz.length(); i++) {
            numero+=raiz.charAt(i);
            if (raiz.charAt(i)==','&&comaEncontrada==valor){

                return numero;
            }
            if (raiz.charAt(i)==','&&comaEncontrada<valor){

                numero="";
                comaEncontrada+=1;
            }
        }
        return "";
    }
    //********************************************************************
    public String decieQueInfoMuestro() {
        if (pag4.equals("") && pag3.equals("") && pag2.equals("") && pag1.equals("")) {
            String info = "ARBOLB CON LOS NOMBRES DE DRAGONES" +
                    "\n" + "Raiz             Branches                      Paginas\n" +
                    "\n" + raiz;
            return info;
        } else if (!pag4.equals("") && !pag3.equals("") && !pag2.equals("") && !pag1.equals("")) {
            String info = "ARBOLB CON LOS NOMBRES DE DRAGONES" +
                    "\n" + "Raiz             Branches                      Paginas\n" +
                    "\n" +
                    "\n" + "  ______________________________ " + pag1 + "\n" + raizEnPartes(0) +
                    "\n" + "  ______________________________ " + pag2 + raizEnPartes(1) +
                    "\n" + "  ______________________________ " + pag3 + raizEnPartes(2) +
                    "\n" + "  ______________________________ " + pag4;
            return info;
        } else if (pag4.equals("") && !pag3.equals("") && !pag2.equals("") && !pag1.equals("")) {
            String info = "ARBOLB CON LOS NOMBRES DE DRAGONES" +
                    "\n" + "Raiz             Branches                      Paginas\n" +
                    "\n" +
                    "\n" + "  ______________________________ " + pag1 + "\n" + raizEnPartes(0) +
                    "\n" + "  ______________________________ " + pag2 + raizEnPartes(1) +
                    "\n" + "  ______________________________ " + pag3 + raizEnPartes(2);
            return info;
        } else if (pag4.equals("") && pag3.equals("") && !pag2.equals("") && !pag1.equals("")) {
            String info = "ARBOLB CON LOS NOMBRES DE DRAGONES" +
                    "\n" + "Raiz             Branches                      Paginas\n" +
                    "\n" +
                    "\n" + "  ______________________________ " + pag1 + "\n" + raizEnPartes(0) +
                    "\n" + "  ______________________________ " + pag2 + raizEnPartes(1);
            return info;
        }
        return "";

    }
    //************************************************8
    public void dibujarArbolB(String Oleada,Raiz raiz1){
        ArbolB=raiz1;
        raiz =(ArbolB.dameInfo(0,Oleada));
        pag1=(ArbolB.dameInfo(1,Oleada)).replaceAll("\\s","");
        pag2=(ArbolB.dameInfo(2,Oleada)).replaceAll("\\s","");
        pag3=(ArbolB.dameInfo(3,Oleada)).replaceAll("\\s","");
        pag4=(ArbolB.dameInfo(4,Oleada)).replaceAll("\\s","");
        establecerPaginas();
        //setBounds(1366-400,400,400,768-400);
        //areaTexto=new JTextArea();
        areaTexto.setText(decieQueInfoMuestro());
        //JScrollPane scroll=new JScrollPane(areaTexto);
        scroll.setBounds(1366-400,400,400,768-430);
        areaTexto.setBackground(Color.darkGray);
        areaTexto.setForeground(Color.white);
        this.add(scroll);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public void cambiarOLeadaArbolB(int tamanoOleada){
        this.Oleadasize=tamanoOleada;

    }
    public void ActulizarArbolB(Dragon Dragones[],int oleada){
        this.Oleadasize=oleada;
      raiz1=new Raiz(Oleadasize);
      raiz1.llenar(Dragones);
       dibujarArbolB(raiz1.oleada,raiz1);
    }
    public void establecerPaginas(){
        if (raizEnPartes(1).replaceAll(",","").equals("")){
            pag3="";
            pag4="";
        }
        if (raizEnPartes(2).replaceAll(",","").equals("")){
            pag4="";
        }
    }
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
        Fondo fond = new Fondo(this);
        fondo = fond;
        InfoLayout i_lay = new InfoLayout();
        InfoDragon i_dra = new InfoDragon();
        InfoTree i_tree = new InfoTree();
        i_layP=i_lay;
        i_draP=i_dra;
        i_treeP=i_tree;
         raiz1 = new Raiz(fond.getOleadaDibujar().getCantidadDragones());
        raiz1.llenar(fond.getOleadaDibujar().toArray());
        //raiz1.oleada="A";
        dibujarArbolB(raiz1.oleada,raiz1);
        //JPanel pan = new JPanel();
        add(fondo);
        add(i_layP);
        add(i_draP);
        add(i_treeP);
        //add(pan);
        Hilo_F xd = new Hilo_F(this);
        hPrin= xd;
    }


    /**
     * Metodo usado por Hilo_F para verificar constantemente si se clickea un dragon y si se cumple alguna condicion de finalizado
     */

    public void comenzar_juego(){

            if(fondo.getCaballero().getDragonesQuePasaron()>=3 || fondo.getCaballero().getVida() == 0){
                hPrin.stop();
                JLabel end = new JLabel("PERDISTEEEEEE");
                end.setFont(new Font("Comic Sans MS", Font.PLAIN, 50));
                end.setBounds(100, 100, 400, 400);
                end.setLocation(100, 100);
                fondo.add(end);
                juego = false;
                fondo.setFocusable(false);
                fondo.setJuego(false);
                fondo.getH1().stop();
                //fondo.getH4().stop();
            }
                for (int i = 0; i< fondo.getOleadaDibujar().toArray().length;i++){
                    Dragon dg = (Dragon) fondo.getOleadaDibujar().toArray()[i];
                    if(dg.getClick()){
                        i_draP.setNombre(dg.getNombre());
                        i_draP.setRecarga(dg.getRecarga());
                        i_draP.setEdad(dg.getEdad());
                        i_draP.setResistencia(dg.getResistencia());
                        i_draP.setInfanteria(dg.getDragones_asignados());
                        i_draP.nombre.setBounds(20, 20, 220, 20);
                        i_draP.add(i_draP.nombre);
                        i_draP.recarga.setBounds(20, 110, 100, 20);
                        i_draP.add(i_draP.recarga);
                        i_draP.resistencia.setBounds(20, 80, 100, 20);
                        i_draP.add(i_draP.resistencia);
                        i_draP.edad.setBounds(20, 50, 100, 20);
                        i_draP.add(i_draP.edad);
                        i_draP.infanteria.setBounds(20, 230,400,20);
                        i_draP.add(i_draP.infanteria);
                        if(dg.getPadre()== null){
                            i_draP.padre.setVisible(false);
                            i_draP.padre= new JLabel("Padre:No tengo");
                        }
                        else{
                            i_draP.setPadre(dg.getPadre());
                        }
                        if(dg.getHijoIz()== null){
                            i_draP.hijoI.setVisible(false);
                            i_draP.hijoI= new JLabel("Hijo Izquierdo:No tengo");
                        }
                        else{
                            i_draP.setHijoI(dg.getHijoIz());
                        }
                        if(dg.getHijoDer()== null){
                            i_draP.hijoD.setVisible(false);
                            i_draP.hijoD= new JLabel("Hijo Derecho:No tengo");
                        }
                        else {
                            i_draP.setHijoD(dg.getHijoDer());
                        }
                        i_draP.setClase(dg.getClase());
                        i_draP.padre.setBounds(20, 140, 220, 20);
                        add(i_draP.padre);
                        i_draP.hijoI.setBounds(20, 170, 260, 20);
                        add(i_draP.hijoI);
                        i_draP.hijoD.setBounds(20, 200, 260, 20);
                        add(i_draP.hijoD);
                        i_draP.clase.setBounds(130, 50, 100, 20);
                        add(i_draP.clase);
                        i_draP.addInfo();
                        dg.setClick(false);
                    }
                }
        Dragon[] ArrayDragones=fondo.getOleadaDibujar().toArray();
        for (int i=0; i<ArrayDragones.length;i++) {
            Dragon dg = ArrayDragones[i];
            fondo.getCaballero().colisionEnem(dg.getLabel());
        }

    }

    /**
     * 
     */
    private String Imagen;

    /**
     * 
     */
    private BTree ArbolB_edad;
















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