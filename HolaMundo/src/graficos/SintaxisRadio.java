package graficos;

import javax.swing.*;

public class SintaxisRadio {
    public static void main(String[] args) {
        MarcoRadio miMarco=new MarcoRadio();
        miMarco.setTitle("Probando Radio Button");
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        miMarco.setVisible(true);
    }
}

class MarcoRadio extends JFrame {

    public MarcoRadio() {
        setBounds(550,300,500,300);
        LaminaRadio miLamina = new LaminaRadio();
        add(miLamina);
    }
}

class LaminaRadio extends JPanel {

    public LaminaRadio() {
        ButtonGroup miGrupo1 = new ButtonGroup();
        ButtonGroup miGrupo2 = new ButtonGroup();
        JRadioButton miBoton1 = new JRadioButton("Azul",true);
        JRadioButton miBoton2 = new JRadioButton("Rojo",false);
        JRadioButton miBoton3 = new JRadioButton("Verde",false);
        JRadioButton miBoton4 = new JRadioButton("Masculino", false);
        JRadioButton miBoton5 = new JRadioButton("Femenino",false);
        miGrupo1.add(miBoton1);
        miGrupo1.add(miBoton2);
        miGrupo1.add(miBoton3);
        miGrupo2.add(miBoton4);
        miGrupo2.add(miBoton5);
        add(miBoton1);
        add(miBoton2);
        add(miBoton3);
        add(miBoton4);
        add(miBoton5);
    }
}
