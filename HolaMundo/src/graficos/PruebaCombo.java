package graficos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PruebaCombo {
    public static void main(String[] args) {
        MarcoCombo miMarco=new MarcoCombo();
        miMarco.setTitle("Ejemplo Combo Box");
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        miMarco.setVisible(true);
    }
}

class MarcoCombo extends JFrame {

    public MarcoCombo() {
        setBounds(550,300,500,400);
        LaminaCombo miLamina = new LaminaCombo();
        add(miLamina);
    }
}

class LaminaCombo extends JPanel {
    private JLabel texto;
    private JComboBox miCombo;

    public LaminaCombo(){
        setLayout(new BorderLayout());
        texto = new JLabel("En un lugar de la mancha de cuyo nombre...");
        texto.setFont(new Font("Serif", Font.PLAIN, 18));
        add(texto, BorderLayout.CENTER);
        JPanel laminaNorte = new JPanel();
        miCombo = new JComboBox();
        miCombo.addItem("Serif");
        miCombo.addItem("SansSerif");
        miCombo.addItem("Monospaced");
        miCombo.addItem("Dialog");
        miCombo.setEditable(true);//para poder escribir dentro del combo
        laminaNorte.add(miCombo);
        ActionListener miEvento = new EventoCombo();
        miCombo.addActionListener(miEvento);
        add(laminaNorte,BorderLayout.NORTH);
    }

    private class EventoCombo implements ActionListener  {
        @Override
        public void actionPerformed(ActionEvent e) {
            texto.setFont(new Font( (String) miCombo.getSelectedItem(),Font.PLAIN,18));
        }
    }
}