package GUI;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class InfoDragon extends JPanel {

    public InfoDragon() {
        setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255)), "Información del Dragón", TitledBorder.CENTER, TitledBorder.TOP, null, Color.white));
        setBounds(1366-400, 150, 400, 250);
        setBackground(Color.darkGray);

    }
}