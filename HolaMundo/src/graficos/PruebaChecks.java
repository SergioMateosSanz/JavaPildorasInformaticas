package graficos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PruebaChecks {
    public static void main(String[] args) {
        MarcoCheck miMarco=new MarcoCheck();
        miMarco.setTitle("Probando Check Button");
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        miMarco.setVisible(true);
    }
}

class MarcoCheck extends JFrame {

    public MarcoCheck() {
        setBounds(500,300,500,350);
        LaminaCheck miLamina = new LaminaCheck();
        add(miLamina);
    }
}

class LaminaCheck extends JPanel {
    private JLabel texto;
    private JCheckBox check1;
    private JCheckBox check2;

    public LaminaCheck() {
        setLayout(new BorderLayout());
        Font miLetra = new Font("Serif",Font.PLAIN, 24);
        texto = new JLabel("En un lugar de la Mancha de cuyo nombre...");
        texto.setFont(miLetra);
        JPanel laminaTexto = new JPanel();
        laminaTexto.add(texto);
        add(laminaTexto, BorderLayout.CENTER);

        check1 = new JCheckBox("Negrita");
        check2 = new JCheckBox("Cursiva");
        check1.addActionListener(new ManejaChecks());
        check2.addActionListener(new ManejaChecks());
        JPanel laminaCheck = new JPanel();
        laminaCheck.add(check1);
        laminaCheck.add(check2);
        add(laminaCheck, BorderLayout.SOUTH);
    }

    private class ManejaChecks implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int tipo = 0;
            if (check1.isSelected()) {
                tipo = tipo + Font.BOLD;
            }
            if (check2.isSelected()) {
                tipo = tipo + Font.ITALIC;
            }
            texto.setFont(new Font("Serif", tipo, 24));
        }
    }
}
