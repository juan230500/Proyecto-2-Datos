package GUI;
import javax.swing.*;
public class Marco  extends JFrame {
    JPanel panel1=new JPanel();
    JLabel etiqueta =new JLabel();
    JLabel etiqueta2 =new JLabel();
    JLabel labelMovil;
    int velocidad;
    int x1=1000;
    int x2=1000;

    public Marco(){
        setBounds(200,350,600,600);
        iniciarComponentes();
    }
    public void iniciarComponentes(){
        
        panel1.setLayout(null);
        setContentPane(panel1);

        crearLabel();
    }
    public void crearLabel(){

        etiqueta.setText("Dragon");
        etiqueta2.setText("Dragon2");
        etiqueta.setBounds(x1,100,60,60);
        etiqueta2.setBounds(x2,150,60,60);
        panel1.add(etiqueta);
        panel1.add(etiqueta2);

    }
    public void moverlabel1(){
        etiqueta.setLocation(x1,etiqueta.getY());
        System.out.println("muevo al dragon 1");
        x1 -= 1;

    }
    public void moverlabel2(){
        etiqueta2.setLocation(x2,etiqueta2.getY());
        System.out.println("muevo al dragon 1");
        x2 -= 1;

    }

}
