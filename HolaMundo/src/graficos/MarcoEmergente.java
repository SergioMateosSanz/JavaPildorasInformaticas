package graficos;

import javax.swing.*;
import javax.swing.text.StyledEditorKit;
import java.awt.*;

public class MarcoEmergente {

    public static void main(String[] args) {

        MenuEmergenteM miMarco=new MenuEmergenteM();
        miMarco.setTitle("Menu Emergente");
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        miMarco.setVisible(true);
    }
}

class MenuEmergenteM extends JFrame {

    public MenuEmergenteM() {

        setBounds(500,350,550,400);
        LaminaEmergenteM miLamina = new LaminaEmergenteM();
        add(miLamina);
    }
}

class LaminaEmergenteM extends JPanel {

    private JTextPane miArea;
    private JMenu fuente, estilo, tamanyo;

    public LaminaEmergenteM(){

        setLayout(new BorderLayout());

        JPanel laminaMenu = new JPanel();

        JMenuBar miBarra = new JMenuBar();

        fuente = new JMenu("Fuente");
        estilo = new JMenu("Estilo");
        tamanyo = new JMenu("Tamaño");

        miBarra.add(fuente);
        miBarra.add(estilo);
        miBarra.add(tamanyo);

        laminaMenu.add(miBarra);

        add(laminaMenu,BorderLayout.NORTH);

        miArea = new JTextPane();
        add(miArea,BorderLayout.CENTER);

        JPopupMenu emergente = new JPopupMenu();

        JMenuItem opcion1 = new JMenuItem("Opción 1");
        JMenuItem opcion2 = new JMenuItem("Opción 2");
        emergente.add(opcion1);
        emergente.add(opcion2);

        //setComponentPopupMenu(emergente);
        miArea.setComponentPopupMenu(emergente);
    }
}
