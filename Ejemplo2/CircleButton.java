package Ejemplo2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JButton;

public class CircleButton extends JButton {
    public CircleButton(String s) {
        super(s);
        this.setBackground(new Color(128,30,30));
        this.setForeground(Color.WHITE);
        this.setPreferredSize(new Dimension(100, 100));
        this.setSize(getPreferredSize());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw a circle.
        g.setColor(Color.YELLOW);
        g.fillOval(0, 0, this.getWidth(), this.getHeight());
    }
}

