package GUI;

import juego.Dragon;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class InfoDragon extends JPanel {
    public void setNombre(String nombre) {
        this.nombre.setVisible(false);
        JLabel n = new JLabel("Nombre:"+ nombre);
        this.nombre = n;
    }
    public void setClase(String clas) {
        this.clase.setVisible(false);
        JLabel n = new JLabel("Clase:"+ clas);
        this.clase = n;
    }
    public void setPadre(Dragon padre) {
        String p = padre.getNombre();
        this.padre.setVisible(false);
        JLabel n = new JLabel("Padre:"+ p);
        this.padre = n;
    }
    public void setHijoI(Dragon hijoi) {
        String hi = hijoi.getNombre();
        this.hijoI.setVisible(false);
        JLabel n = new JLabel("Hijo Izquierdo:"+ hi);
        this.hijoI = n;
    }
    public void setHijoD(Dragon hijod) {
        String hd = hijod.getNombre();
        this.hijoD.setVisible(false);
        JLabel n = new JLabel("Hijo Derecho:"+ hd);
        this.hijoD = n;
    }

    public void setEdad(int edad) {
        this.edad.setVisible(false);
        String st = Integer.toString(edad);
        JLabel n = new JLabel("Edad:"+st);
        this.edad = n;
    }

    public void setResistencia(int resistencia) {
        this.resistencia.setVisible(false);
        String st = Integer.toString(resistencia);
        JLabel n = new JLabel("Resistencia:"+st);
        this.resistencia = n;
    }

    public void setRecarga(int recarga) {
        this.recarga.setVisible(false);
        String st = Integer.toString(recarga);
        JLabel n = new JLabel("Recarga:"+st);
        this.recarga = n;
    }
    JLabel nombre=new JLabel("Nombre:");
    JLabel edad=new JLabel("Edad:");
    JLabel resistencia=new JLabel("Resistencia:");
    JLabel recarga=new JLabel("Recarga:");
    JLabel padre=new JLabel("Padre:");
    JLabel hijoI=new JLabel("Hijo Izquierdo:");
    JLabel hijoD=new JLabel("Hijo Derecho:");
    JLabel clase=new JLabel("Clase:");


    public InfoDragon() {
        setLayout(null);
        setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255)), "Información del Dragón", TitledBorder.CENTER, TitledBorder.TOP, null, Color.white));
        setBounds(1366-400, 150, 400, 250);
        addInfo();
        setBackground(Color.darkGray);
        addInfo();
    }
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
        this.clase.setBounds(20, 230, 100, 20);
        this.clase.setForeground(Color.white);
        this.clase.setVisible(true);
        add(clase);
    }


}