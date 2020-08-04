package graficos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EjemploRadio {
    public static void main(String[] args) {
        MarcoEjemploRadio miMarco=new MarcoEjemploRadio();
        miMarco.setTitle("Ejemplo Radio Button");
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        miMarco.setVisible(true);
    }
}

class MarcoEjemploRadio extends JFrame {

    public MarcoEjemploRadio() {
        setBounds(550,300,500,300);
        LaminaEjemploRadio miLamina = new LaminaEjemploRadio();
        add(miLamina);
    }
}

class LaminaEjemploRadio extends JPanel {
    private JLabel texto;
    private JRadioButton boton1, boton2, boton3, boton4;
    private ButtonGroup miGrupo;
    private JPanel laminaBotones;

    public LaminaEjemploRadio() {
        setLayout(new BorderLayout());

        texto = new JLabel("En un lugar de la mancha de cuyo nombre...");
        texto.setFont(new Font("Serif",Font.PLAIN,12));
        add(texto,BorderLayout.CENTER);
        miGrupo = new ButtonGroup();
        laminaBotones = new JPanel();
        colocarBotones("Pequeño",false, 10);
        colocarBotones("Mediano",true, 12);
        colocarBotones("Grande",false, 18);
        colocarBotones("Muy grande",false, 24);
        add(laminaBotones,BorderLayout.SOUTH);
    }
    public void colocarBotones(String nombre, boolean seleccionado, final int tamanyo){//obliga a ser final porque se utiliza en el objeto interior
        JRadioButton boton= new JRadioButton(nombre,seleccionado);
        miGrupo.add(boton);
        laminaBotones.add(boton);
        ActionListener miEvento = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                texto.setFont(new Font("Serif",Font.PLAIN,tamanyo));
            }
        };
        boton.addActionListener(miEvento);
    }

}