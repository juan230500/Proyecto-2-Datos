package GUI;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
/**
 *  ESta clase se encarga de manejar la informacion del layout de la pantalla de juego
 */
public class InfoLayout extends JPanel {
    JLabel info = new JLabel();

    public InfoLayout(){
        setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255)), "Información del Acomodo", TitledBorder.CENTER, TitledBorder.TOP, null, Color.white));
        setBounds(1366-400, 0, 400, 150);
        setBackground(Color.darkGray);
        setLayout(null);

    }

    public void setInfo(String inf){
        info.setBounds(125,70,200,20);
        info.setText(inf);
        info.setForeground(Color.white);
        add(info);
        info.setVisible(true);
    }

    public void setInfoVisible(boolean bool) {
        info.setVisible(bool);
    }
}