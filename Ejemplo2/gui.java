package Ejemplo2;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;


public class gui {
    public static void main(String args[]) {      
        ImageIcon opened = new ImageIcon("D:\\cmal1\\Semestre3\\poo\\slingelton\\Ejemplo2\\EAbierto.JPG"), closed = new ImageIcon("D:\\cmal1\\Semestre3\\poo\\slingelton\\Ejemplo2\\ECerrado.JPG");

        Font font = new Font("Arial", Font.PLAIN, 100);
        JFrame frame = new JFrame("Elevadores");  
        Color color =  new Color(128,30,30);    
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      
        frame.setSize(1000,800);
        frame.setResizable(true);     
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(10, 1, 20, 20));
        
        LinkedList<JButton> buttons = new LinkedList<>();
        
        JPanel panel2 = new JPanel();
        
        JLabel piso = new JLabel("Piso: ");
        panel2.add(piso);
        piso.setBackground(Color.GRAY);
        piso.setOpaque(true);
        piso.setForeground(Color.YELLOW);
        piso.setFont(font);

        panel.setBackground(color);
        panel2.setBackground(color);
        frame.add(panel2);
        for(int i = 0; i < 10; i++){
            JButton but = new JButton(Integer.toString(i+1));
            buttons.add(but);
        }

        Collections.reverse(buttons);
        for (JButton jButton : buttons) {
            panel.add(jButton); // Agrega el botón al panel de contenido del marco     
        }
        Collections.reverse(buttons);

        //Imagenes
        JPanel panelElevadores = new JPanel();
        panelElevadores.setLayout(new GridLayout(10,1,20,20));
        ArrayList<ImageIcon> imagenes = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            imagenes.add(new ImageIcon());
            imagenes.get(i).setImage(closed.getImage());

        }
        imagenes.get(0).setImage(opened.getImage());
        for (ImageIcon imageIcon : imagenes) {
            imageIcon = closed;
            panelElevadores.add(new JLabel(imageIcon));
        }

        frame.add(panelElevadores, BorderLayout.CENTER);
        frame.add(panel, BorderLayout.WEST);
        frame.setVisible(true);   

    }
}