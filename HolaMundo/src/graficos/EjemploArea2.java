package graficos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EjemploArea2 {
    public static void main(String[] args) {
        MarcoArea2 miMarco=new MarcoArea2();
        miMarco.setTitle("Probando área de texto");
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        miMarco.setVisible(true);
    }
}

// todo en una única clase aunque no es lo recomendable
class MarcoArea2 extends JFrame{

    private JPanel laminaBotones;
    private JButton botonInsertar;
    private JButton botonSaltoLinea;
    private JTextArea areaTexto;
    private JScrollPane laminaConBarras;
    private JButton botonLimpiar;

    public MarcoArea2(){
        setBounds(500,300,500,350);
        setLayout(new BorderLayout());
        laminaBotones = new JPanel();
        botonInsertar = new JButton("Insertar");
        botonInsertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                areaTexto.append("En un lugar de la Mancha de cuyo nombre no quiero acordarme.");
            }
        });
        laminaBotones.add(botonInsertar);
        botonSaltoLinea = new JButton("Salto línea");
        botonSaltoLinea.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean saltar = !areaTexto.getLineWrap();
                areaTexto.setLineWrap(saltar);
                /*
                if (saltar == true) {
                    botonSaltoLinea.setText("Quitar salto");
                } else {
                    botonSaltoLinea.setText("Salto línea");
                }

                 */
                botonSaltoLinea.setText(saltar ? "Quitar salto" : "Salto línea");//operador ternario
            }
        });
        laminaBotones.add(botonSaltoLinea);
        //add(laminaBotones,BorderLayout.SOUTH);
        areaTexto = new JTextArea(8,20);
        laminaConBarras = new JScrollPane(areaTexto);
        add(laminaConBarras,BorderLayout.CENTER);
        botonLimpiar = new JButton("Borrar texto");
        botonLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                areaTexto.setText("");
            }
        });
        laminaBotones.add(botonLimpiar);
        add(laminaBotones,BorderLayout.SOUTH);
    }
}