package GUI;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class InfoLayout extends JPanel {

    public InfoLayout(){
        setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255)), "Información del Acomodo", TitledBorder.CENTER, TitledBorder.TOP, null, Color.white));
        setBounds(1366-400, 0, 400, 150);
        setBackground(Color.darkGray);
    }
}