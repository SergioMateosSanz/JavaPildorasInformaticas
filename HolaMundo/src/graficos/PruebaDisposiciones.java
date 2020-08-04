package graficos;

import javax.swing.*;
import java.awt.*;

public class PruebaDisposiciones {

    public static void main(String[] args) {
        MarcoCaja miMarco=new MarcoCaja();
        miMarco.setTitle("Ejemplo Disposicion Box");
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        miMarco.setVisible(true);
    }
}

class MarcoCaja extends JFrame {

    public MarcoCaja() {
        setBounds(600,350,200,200);

        JLabel rotulo1 = new JLabel("Nombre");
        JTextField texto1 = new JTextField(10);
        texto1.setMaximumSize(texto1.getPreferredSize());

        Box cajaHorizontal1 = Box.createHorizontalBox();
        cajaHorizontal1.add(rotulo1);
        cajaHorizontal1.add(Box.createHorizontalStrut(10));
        cajaHorizontal1.add(texto1);

        JLabel rotulo2 = new JLabel("Contraseña");
        JTextField texto2 = new JTextField(10);
        texto2.setMaximumSize(texto2.getPreferredSize());

        Box cajaHorizontal2 = Box.createHorizontalBox();
        cajaHorizontal2.add(rotulo2);
        cajaHorizontal2.add(Box.createHorizontalStrut(10));
        cajaHorizontal2.add(texto2);

        JButton botonOk = new JButton("Ok");
        JButton botonCancelar = new JButton("Cancelar");

        Box cajaHorizontal3 = Box.createHorizontalBox();
        cajaHorizontal3.add(botonOk);
        cajaHorizontal3.add(Box.createGlue());
        cajaHorizontal3.add(botonCancelar);

        Box cajaVertical = Box.createVerticalBox();
        cajaVertical.add(cajaHorizontal1);
        cajaVertical.add(Box.createVerticalStrut(10));
        cajaVertical.add(cajaHorizontal2);
        cajaVertical.add(Box.createVerticalStrut(10));
        cajaVertical.add(cajaHorizontal3);

        add(cajaVertical, BorderLayout.CENTER);
    }
}