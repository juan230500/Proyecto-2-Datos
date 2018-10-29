package GUI;

import adt.LinkedList;
import juego.Dragon;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 *  Clase: InfoDragon
 * @author Andrey Sanchez
 * @version 26/10/2018
 */

public class InfoDragon extends JPanel {
    public void setNombre(String nombre) {
        this.nombre.setVisible(false);
        this.nombre.setText("Nombre:"+ nombre);
    }
    public void setInfanteria(LinkedList lista) {
        this.infanteria.setVisible(false);
        String temp = " ";
        for (int i=0;i<lista.getSize();i++){
            temp += lista.recorrer(i);
            temp += " ";
        }
        System.out.println(temp);
        this.infanteria.setText("Infanteria:"+ temp);
    }

    /**
     * Setter
     * @param clas
     */

    public void setClase(String clas) {
        this.clase.setVisible(false);
        this.clase.setText("Clase:"+ clas);
    }

    /**
     * Setter
     * @param padre
     */

    public void setPadre(Dragon padre) {
        String p = padre.getNombre();
        this.padre.setVisible(false);
        this.padre.setText("Padre:"+ p);
    }

    /**
     * Setter
     * @param hijoi
     */

    public void setHijoI(Dragon hijoi) {
        String hi = hijoi.getNombre();
        this.hijoI.setVisible(false);
        this.hijoI.setText("Hijo Izquierdo:"+ hi);
    }

    /**
     * Setter
     * @param hijod
     */

    public void setHijoD(Dragon hijod) {
        String hd = hijod.getNombre();
        this.hijoD.setVisible(false);
        this.hijoD.setText("Hijo Derecho:"+ hd);
    }

    /**
     * Setter
     * @param edad
     */

    public void setEdad(int edad) {
        this.edad.setVisible(false);
        String st = Integer.toString(edad);
        this.edad.setText("Edad:"+st);
    }

    /**
     * Setter
     * @param resistencia
     */

    public void setResistencia(int resistencia) {
        this.resistencia.setVisible(false);
        String st = Integer.toString(resistencia);
        this.resistencia.setText("Resistencia:"+st);
    }

    /**
     * Setter
     * @param recarga
     */

    public void setRecarga(int recarga) {
        this.recarga.setVisible(false);
        String st = Integer.toString(recarga);
        this.recarga.setText("Recarga:"+st);
    }
    JLabel nombre=new JLabel("Nombre:");
    JLabel edad=new JLabel("Edad:");
    JLabel resistencia=new JLabel("Resistencia:");
    JLabel recarga=new JLabel("Recarga:");
    JLabel padre=new JLabel("Padre:");
    JLabel hijoI=new JLabel("Hijo Izquierdo:");
    JLabel hijoD=new JLabel("Hijo Derecho:");
    JLabel clase=new JLabel("Clase:");
    JLabel infanteria= new JLabel("Infanteria:");

    /**
     * Default constructor
     */

    public InfoDragon() {
        setLayout(null);
        setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255)), "Información del Dragón", TitledBorder.CENTER, TitledBorder.TOP, null, Color.white));
        setBounds(1366-400, 150, 400, 250);
        addInfo();
        setBackground(Color.darkGray);
        addInfo();
    }

    /**
     * Metodo para setear la informacion de un dragon en el JPanel InfoDragon
     */

    public void addInfo(){
        this.nombre.setBounds(20, 20, 220, 20);
        this.nombre.setForeground(Color.white);
        this.nombre.setVisible(true);
        add(nombre);
        this.edad.setBounds(20, 50, 100, 20);
        this.edad.setForeground(Color.white);
        this.edad.setVisible(true);
        add(edad);
        this.resistencia.setBounds(20, 80, 100, 20);
        this.resistencia.setForeground(Color.white);
        this.resistencia.setVisible(true);
        add(resistencia);
        this.recarga.setBounds(20, 110, 100, 20);
        this.recarga.setForeground(Color.white);
        this.recarga.setVisible(true);
        add(recarga);
        this.padre.setBounds(20, 140, 220, 20);
        this.padre.setForeground(Color.white);
        this.padre.setVisible(true);
        add(padre);
        this.hijoI.setBounds(20, 170, 260, 20);
        this.hijoI.setForeground(Color.white);
        this.hijoI.setVisible(true);
        add(hijoI);
        this.hijoD.setBounds(20, 200, 260, 20);
        this.hijoD.setForeground(Color.white);
        this.hijoD.setVisible(true);
        add(hijoD);
        this.clase.setBounds(130, 50, 100, 20);
        this.clase.setForeground(Color.white);
        this.clase.setVisible(true);
        add(clase);
        this.infanteria.setBounds(20, 230,400,20);
        this.infanteria.setForeground(Color.white);
        this.infanteria.setVisible(true);
        add(infanteria);
    }


}