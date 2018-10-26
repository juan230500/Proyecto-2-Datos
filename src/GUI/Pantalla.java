package GUI;

import adt.BTree;
import juego.Dragon;
import juego.Oleada;

import java.awt.*;
import javax.swing.*;
import java.util.*;

/**
 * 
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
        Fondo fond = new Fondo();
        fondo = fond;
        InfoLayout i_lay = new InfoLayout();
        InfoDragon i_dra = new InfoDragon();
        InfoTree i_tree = new InfoTree();
        i_layP=i_lay;
        i_draP=i_dra;
        i_treeP=i_tree;
        JPanel pan = new JPanel();
        add(fondo);
        add(i_layP);
        add(i_draP);
        add(i_treeP);
        add(pan);
        Hilo_F xd = new Hilo_F(this);
        hPrin= xd;
    }
    public void comenzar_juego(){

        while(juego){
            if(fondo.getCaballero().getDragonesQuePasaron()==2 || fondo.getCaballero().getVida() == 2){
                JLabel end = new JLabel("PERDISTEEEEEE");
                end.setFont(new Font("Comic Sans MS", Font.PLAIN, 50));
                end.setBounds(100, 100, 400, 400);
                end.setLocation(100, 100);
                fondo.add(end);
                juego = false;
                fondo.setFocusable(false);
                fondo.setJuego(false);
                fondo.getH1().stop();
                fondo.getH2().stop();
                fondo.getH3().stop();
                fondo.getH4().stop();
                hPrin.stop();
            }
                for (int i = 0; i< fondo.getOleadaDibujar().toArray().length;i++){
                    Dragon dg = (Dragon) fondo.getOleadaDibujar().toArray()[i];
                    if(dg.getClick()){
                        i_draP.setNombre(dg.getNombre());
                        i_draP.setRecarga(dg.getRecarga());
                        i_draP.setEdad(dg.getEdad());
                        i_draP.setResistencia(dg.getResistencia());
                        i_draP.nombre.setBounds(20, 20, 220, 20);
                        i_draP.add(i_draP.nombre);
                        i_draP.recarga.setBounds(20, 110, 100, 20);
                        i_draP.add(i_draP.recarga);
                        i_draP.resistencia.setBounds(20, 80, 100, 20);
                        i_draP.add(i_draP.resistencia);
                        i_draP.edad.setBounds(20, 50, 100, 20);
                        i_draP.add(i_draP.edad);
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
                        i_draP.clase.setBounds(20, 230, 100, 20);
                        add(i_draP.clase);
                        i_draP.addInfo();
                        dg.setClick(false);
                    }
                }
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