package Ejemplo2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class gui2 {

    
    public static void main(String args[]) {
        ArrayList<JLabel> labels = new ArrayList<>();
        JButtonM.setLabels(labels);
        ImageIcon opened = new ImageIcon("Ejemplo2\\EAbierto.JPG");
        ImageIcon closed = new ImageIcon("Ejemplo2\\ECerrado.JPG");
        
        // Escalar las imágenes a un tamaño más pequeño
        int scaledWidth = 84;
        int scaledHeight = 76;

        Image openedImage = opened.getImage().getScaledInstance(scaledWidth, scaledHeight, Image.SCALE_SMOOTH);
        Image closedImage = closed.getImage().getScaledInstance(scaledWidth, scaledHeight, Image.SCALE_SMOOTH);

        opened = new ImageIcon(openedImage);
        closed = new ImageIcon(closedImage);
        JButtonM.opened1 = opened;
        JButtonM.closed1 = closed;
        final ImageIcon closed1 = closed;
        final ImageIcon opened1 = opened;

        Font font = new Font("Arial", Font.PLAIN, 100);
        JFrame frame = new JFrame("Elevadores");
        Color color = new Color(128, 30, 30);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(140, 800);
        frame.setResizable(true);
        frame.getContentPane().setBackground(color);
        frame.setLocationRelativeTo(null); 
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(11, 1, 20, 20));

        LinkedList<JButtonM> buttons = new LinkedList<>();

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
        for (int i = 0; i < 10; i++) {
            JButtonM but = new JButtonM(Integer.toString(i + 1));
            buttons.add(but);
        }

        ActionListener bListener2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                ElevatorControlGui control = ElevatorControlGui.getInstance();
                close(labels, closed1);
                int next = control.getNextFloor();
                open(labels.get(next),opened1);
            }
        };

        Collections.reverse(buttons);
        for (JButtonM jButtonM : buttons) {
            panel.add(jButtonM); // Agrega el botón al panel de contenido del marco
        }
        JButtonM butC = new JButtonM("><");
        butC.addActionListener(bListener2);
        panel.add(butC);
        Collections.reverse(buttons);

        // Imagenes
        JPanel panelElevadores = new JPanel();
        panelElevadores.setLayout(new BoxLayout(panelElevadores, BoxLayout.Y_AXIS));

        for (int i = 0; i < 10; i++) {
            labels.add(new JLabel());
            labels.get(i).setIcon(closed);
            panelElevadores.add(labels.get(i));
        }
        
        //labels.get(9).setIcon(opened);
        
        //panelElevadores.setBounds(1000, 0,panelElevadores.getWidth(), panelElevadores.getHeight());
        
        frame.add(panelElevadores, BorderLayout.CENTER);
        frame.add(panel, BorderLayout.WEST);
        frame.setVisible(true);
    
    }

    public static void open(JLabel label, Icon icon){
        label.setIcon(icon);
    }

    public static void close(ArrayList<JLabel> labels, ImageIcon closed){
        labels.get(ElevatorControlGui.current).setIcon(closed);
    }

}
