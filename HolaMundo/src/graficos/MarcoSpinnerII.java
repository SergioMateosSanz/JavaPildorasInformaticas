package graficos;

import javax.swing.*;
import java.awt.*;

public class MarcoSpinnerII {
    public static void main(String[] args) {
        FrameSpinnerII miMarco=new FrameSpinnerII();
        miMarco.setTitle("Ejemplo Spinner");
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        miMarco.setVisible(true);
    }
}

class FrameSpinnerII extends JFrame {

    public FrameSpinnerII() {
        setBounds(550,350,550,350);
        LaminaSpinnerII miLamina = new LaminaSpinnerII();
        add(miLamina);
    }
}

class LaminaSpinnerII extends JPanel {
    public LaminaSpinnerII(){
        //JSpinner control = new JSpinner(new SpinnerNumberModel(5,0,10,1));
        JSpinner control = new JSpinner(new MiModeloJSpinner());//para utilizar nuestro modelo
        Dimension d = new Dimension(200,20);
        control.setPreferredSize(d);
        add(control);
    }
    private class MiModeloJSpinner extends SpinnerNumberModel {
        public MiModeloJSpinner(){
            super(5,0,10,1);
        }

        @Override
        public Object getNextValue() {
            return super.getPreviousValue();
        }

        @Override
        public Object getPreviousValue() {
            return super.getNextValue();
        }
    }
}
