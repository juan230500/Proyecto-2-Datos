package GUI;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.concurrent.TimeUnit;
import java.lang.*;

public class Fondo extends JPanel implements MouseListener {

    private boolean juego = true;
    private int var_x = 0;

    public Fondo() {
        setBounds(0, 0, 1100, 600);
        setBackground(Color.cyan);
        setMaximumSize(new Dimension(1100, 600));

        }

    public void paintComponent(Graphics g) {

        super.paintComponents(g);

        g.setColor(Color.black);
        g.drawRect(550, 300, 10, 10);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        juego = false;
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

