package Ejemplo2;

import javax.swing.*;

import java.awt.event.*;
import java.util.ArrayList;


public class JButtonM extends JButton{
    
    static ImageIcon opened1;
    static ImageIcon closed1;
    static ArrayList<JLabel> labels;
    public static JButtonM last = null;

    public static void setLabels(ArrayList<JLabel> label){
        labels = label;
    }

    public JButtonM(String s){
        super(s);
        this.addActionListener(bListener1);
    }

    ActionListener bListener1 = new ActionListener() {
        @Override 
        public void actionPerformed(ActionEvent e){
            JButtonM src = (JButtonM) e.getSource();
            int floor = Integer.parseInt(src.getText());
            ElevatorControlGui control = ElevatorControlGui.getInstance();
            control.addToQueue(10-floor);
        
        }
    };

}
