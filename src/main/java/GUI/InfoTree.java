package GUI;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class InfoTree extends JPanel {

    public InfoTree() {
        setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255)), "Información del Árbol", TitledBorder.CENTER, TitledBorder.TOP, null, Color.white));
        setBackground(Color.darkGray);
        setBounds(1366-400, 400, 400, 768-400);
    }
}