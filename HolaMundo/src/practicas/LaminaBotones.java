package practicas;

import javax.swing.*;

public class LaminaBotones extends JPanel {

    private ButtonGroup grupoBotones;

    public LaminaBotones(String titulo, String [] opciones){

        setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), titulo));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        grupoBotones = new ButtonGroup();

        for (int i = 0; i < opciones.length; i++){
            JRadioButton boton = new JRadioButton(opciones[i]);
            boton.setActionCommand(opciones[i]);
            add(boton);
            grupoBotones.add(boton);
            boton.setSelected(i==0);
        }
    }

    public String dameSeleccion(){

        /*
        ButtonModel miBoton = grupoBotones.getSelection();
        String texto = miBoton.getActionCommand();
        return texto; */
        return grupoBotones.getSelection().getActionCommand();
    }
}
