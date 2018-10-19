package GUI;
import javax.swing.*;
public class Marco  extends JFrame {
    JPanel panel1=new JPanel();
    JLabel etiqueta =new JLabel();
    JLabel etiqueta2 =new JLabel();
    JLabel labelMovil;
    int velocidad;
    int x=10;
    int y=100;
    public Marco(){
        setBounds(200,350,600,600);
        iniciarComponentes();
    }
    public void iniciarComponentes(){
        //JPanel panel1=new JPanel();
        panel1.setLayout(null);
        this.getContentPane().add(panel1);
        //crearLabel();
        crearLabel();
    }
    public void crearLabel(){

        etiqueta.setText("Dragon");
        etiqueta2.setText("Dragon2");
        etiqueta.setBounds(100,100,60,60);
        etiqueta2.setBounds(150,100,60,60);
        panel1.add(etiqueta);
        panel1.add(etiqueta2);

    }
    public void moverlabel1(){
        etiqueta.setLocation(x,y);
        System.out.println("muevo al dragon 1");
        x=x+5;

    }
    public void moverlabel2(){
        etiqueta2.setLocation(x,y+50);
        System.out.println("muevo al dragon 1");
        x=x+5;

    }

}
