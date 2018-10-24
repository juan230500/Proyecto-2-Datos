package juego;

import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JLabel;

/**
 * 
 */
public class Dragon {

    /**
     * Default constructor
     */

    public Dragon() {
        //para probar lógica
        this.edad= ThreadLocalRandom.current().nextInt(1, 1000);
        this.recarga=ThreadLocalRandom.current().nextInt(1, 100);
        //Probar eliminación
        this.resistencia=ThreadLocalRandom.current().nextInt(1,3);
        
        this.Label=new JLabel();
        this.Label.setBounds(0, 0, 50, 50);
        this.Label.setText(""+this);
    }

    /**
     * Default constructor
     */

    public Dragon(int edadt) {
        this.edad= edadt;
        this.recarga=ThreadLocalRandom.current().nextInt(1, 100);
        //Probar eliminación
        this.resistencia=ThreadLocalRandom.current().nextInt(1,3);
    }
    
    
    
    
    private int PosY;

    private int PosX;

    private String nombre;

    private int recarga;

    private int edad;

    private int resistencia;

    private String clase;

    private Dragon padre;

    private Dragon hijoDer;

    private Dragon hijoIz;
    
    private JLabel Label;

    public int getRecarga() {
        return recarga;
    }

    public int getEdad() {
        return edad;
    }


    public Dragon getPadre() {
        return padre;
    }

    public Dragon getHijoDer() {
        return hijoDer;
    }

    public Dragon getHijoIz() {
        return hijoIz;
    }

    public int getResistencia() {
        return resistencia;
    }

    public void setPadre(Dragon padre) {
        this.padre = padre;
    }

    public void setHijoDer(Dragon hijoDernuevo) {
        if (hijoDernuevo!=null)
            hijoDernuevo.setPadre(this);
        this.hijoDer = hijoDernuevo;
    }

    public void setHijoIz(Dragon hijoIznuevo) {
        if (hijoIznuevo!=null)
            hijoIznuevo.setPadre(this);
        this.hijoIz = hijoIznuevo;
    }

    public void setPosY(int posY) {
        PosY = posY;
    }

    public int getPosY() {
        return PosY;
    }

    public int getPosX() {
        return PosX;
    }

    public void setPosX(int nivel) {
        PosX = nivel;
    }

    /**
     * Baja la resistencia y devuelve un booleano acerca de si se debe eliminar o no
     * @return true si murió, false sino
     */
    public boolean RecibirDano(){
        this.resistencia--;
        return this.resistencia==0;
    }

    /**
     * 
     */
    public void lanzarFuego() {
        // TODO implement here
    }

    /**
     * 
     */
    public void avanzar() {
        // TODO implement here
    }

    /**
     * 
     */
    public void clickear() {
        // TODO implement here
    }

	public JLabel getLabel() {
		return Label;
	}

}