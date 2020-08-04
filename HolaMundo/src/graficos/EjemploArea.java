package graficos;

import javax.swing.*;
import java.awt.event.*;

public class EjemploArea {
    public static void main(String[] args) {
        MarcoArea mimarco=new MarcoArea();
        mimarco.setTitle("");
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MarcoArea extends JFrame{

    public MarcoArea(){
        setBounds(500,300,500,350);
        LaminaArea lamina=new LaminaArea();
        add(lamina);
        setVisible(true);
    }
}

class LaminaArea extends JPanel{
    private JTextArea miArea;

    public LaminaArea(){
        miArea = new JTextArea(8,20);
        JScrollPane laminaBarras = new JScrollPane(miArea);
        miArea.setLineWrap(true);//no se ensancha el cuadro de texto
        add(laminaBarras);
        JButton miBoton = new JButton("Dale");
        miBoton.addActionListener(new GestionArea());
        add(miBoton);
    }

    private class GestionArea implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(miArea.getText());
        }
    }
}