package graficos;

import javax.swing.*;
import java.awt.event.*;

public class TiposCuadrosDialogos {

    public static void main(String[] args) {

        MarcoDialogo miMarco=new MarcoDialogo();
        miMarco.setTitle("Ejemplo Cuadros Dialogos");
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        miMarco.setVisible(true);
    }
}

class MarcoDialogo extends JFrame {

    public MarcoDialogo(){

        setBounds(500,300,400,250);
        add(new LaminaCuadroDialogos());
    }
}

class LaminaCuadroDialogos extends JPanel {

    private JButton boton1, boton2, boton3, boton4;

    public LaminaCuadroDialogos(){

        boton1=new JButton("boton 1");
        boton2=new JButton("boton2");
        boton3=new JButton("boton3");
        boton4=new JButton("boton4");

        boton1.addActionListener(new AccionBotones());
        boton2.addActionListener(new AccionBotones());
        boton3.addActionListener(new AccionBotones());
        boton4.addActionListener(new AccionBotones());

        add(boton1);
        add(boton2);
        add(boton3);
        add(boton4);
    }

    private class AccionBotones implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            if(e.getSource()==boton1){
                //JOptionPane.showMessageDialog(LaminaCuadroDialogos.this,"Hola caracola");
                JOptionPane.showMessageDialog(LaminaCuadroDialogos.this,"Hola caracola",
                        "Aviso",2);
            }else if(e.getSource()==boton2){
                //JOptionPane.showInputDialog("Introduce tu nombre");
                JOptionPane.showInputDialog(LaminaCuadroDialogos.this,"Introduce tu nombre",
                        "Introducción de datos",1);
            }else if(e.getSource()==boton3){
                JOptionPane.showConfirmDialog(LaminaCuadroDialogos.this,"Elige una opción",
                        "Desea confirmar?",2);
            }else{
                JOptionPane.showOptionDialog(LaminaCuadroDialogos.this,"Elige","Opciones",
                        1,2,null,null,null);
            }
        }
    }
}
