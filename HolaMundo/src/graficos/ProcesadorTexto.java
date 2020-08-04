package graficos;

//import javafx.scene.input.KeyCode;

import javax.swing.*;
import javax.swing.text.StyledEditorKit;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class ProcesadorTexto {
    public static void main(String[] args) {
        MenuProcesador miMarco=new MenuProcesador();
        miMarco.setTitle("Ejemplo Procesador de Texto");
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        miMarco.setVisible(true);
    }
}

class MenuProcesador extends JFrame {

    public MenuProcesador() {
        setBounds(400,300,650,500);
        LaminaProcesador miLamina = new LaminaProcesador();
        add(miLamina);
    }
}

class LaminaProcesador extends JPanel {

    private JTextPane miArea;
    private JMenu fuente, estilo, tamanyo;
    private Font letras;
    private JButton negritaBarra, cursivaBarra, subrayadoBarra, azulBarra, amarilloBarra, rojoBarra,
                    alineacionIzquierda, centrado, alineacionDerecha, justificado;
    private JToolBar barra;

    public LaminaProcesador() {

        setLayout(new BorderLayout());

        JPanel laminaMenu = new JPanel();

        JMenuBar miBarra = new JMenuBar();

        fuente = new JMenu("Fuente");
        estilo = new JMenu("Estilo");
        tamanyo = new JMenu("Tamaño");

        configuraMenu("Arial", "Fuente", "Arial",9,10,"");
        configuraMenu("Courier", "Fuente", "Courier",9,10,"");
        configuraMenu("Verdana", "Fuente", "Verdana",9,10,"");

        configuraMenu("Negrita", "Estilo", "", Font.BOLD,12,
                "src/graficos/cortar.gif");
        configuraMenu("Cursiva", "Estilo", "", Font.ITALIC,12,
                "src/graficos/pegar.gif");
        /*JCheckBoxMenuItem negrita = new JCheckBoxMenuItem("negrita");
        JCheckBoxMenuItem cursiva = new JCheckBoxMenuItem("cursiva");
        negrita.addActionListener(new StyledEditorKit.BoldAction());
        cursiva.addActionListener(new StyledEditorKit.ItalicAction());
        estilo.add(negrita);
        estilo.add(cursiva); */

        // configuraMenu("12", "Tamaño", "",9,12,"");
        // configuraMenu("16", "Tamaño", "",9,16,"");
        // configuraMenu("20", "Tamaño", "",9,20,"");
        // configuraMenu("24", "Tamaño", "",9,24,"");
        ButtonGroup tamanyoLetra = new ButtonGroup();
        JRadioButtonMenuItem doce = new JRadioButtonMenuItem("12");
        JRadioButtonMenuItem dieciseis = new JRadioButtonMenuItem("16");
        JRadioButtonMenuItem veinte = new JRadioButtonMenuItem("20");
        JRadioButtonMenuItem veinticuatro = new JRadioButtonMenuItem("24");

        //veinticuatro.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_DOWN_MASK));

        tamanyoLetra.add(doce);
        tamanyoLetra.add(dieciseis);
        tamanyoLetra.add(veinte);
        tamanyoLetra.add(veinticuatro);

        doce.addActionListener(new StyledEditorKit.FontSizeAction("cambia tamaño",12));
        dieciseis.addActionListener(new StyledEditorKit.FontSizeAction("cambia tamaño",16));
        veinte.addActionListener(new StyledEditorKit.FontSizeAction("cambia tamaño",20));
        veinticuatro.addActionListener(new StyledEditorKit.FontSizeAction("cambia tamaño",24));

        tamanyo.add(doce);
        tamanyo.add(dieciseis);
        tamanyo.add(veinte);
        tamanyo.add(veinticuatro);

        miBarra.add(fuente);
        miBarra.add(estilo);
        miBarra.add(tamanyo);

        laminaMenu.add(miBarra);

        add(laminaMenu,BorderLayout.NORTH);

        miArea = new JTextPane();
        add(miArea,BorderLayout.CENTER);

        JPopupMenu emergente = new JPopupMenu();

        JMenuItem negritaE = new JMenuItem("Negrita");
        JMenuItem cursivaE = new JMenuItem("Cursiva");

        negritaE.addActionListener(new StyledEditorKit.BoldAction());
        cursivaE.addActionListener(new StyledEditorKit.ItalicAction());

        emergente.add(negritaE);
        emergente.add(cursivaE);

        miArea.setComponentPopupMenu(emergente);

        /*
        JToolBar barra = new JToolBar();

        JButton botonNegrita = new JButton(new ImageIcon("src/graficos/negrita.gif"));
        JButton botonCursiva = new JButton(new ImageIcon("src/graficos/cursiva.gif"));
        JButton botonSubrayado = new JButton(new ImageIcon("src/graficos/subrayado.gif"));
        JButton botonAzulBarra = new JButton(new ImageIcon("src/graficos/bola_azul.gif"));
        JButton botonAmarilloBarra = new JButton(new ImageIcon("src/graficos/bola_amarilla.gif"));
        JButton botonRojoBarra = new JButton(new ImageIcon("src/graficos/bola_roja.gif"));
        JButton botonIzquierda = new JButton(new ImageIcon("src/graficos/izquierda.gif"));
        JButton botonCentrar = new JButton(new ImageIcon("src/graficos/centrar.gif"));
        JButton botonDerecha = new JButton(new ImageIcon("src/graficos/derecha.gif"));
        JButton botonJustificar = new JButton(new ImageIcon("src/graficos/justificar.gif"));

        botonNegrita.addActionListener(new StyledEditorKit.BoldAction());
        botonCursiva.addActionListener(new StyledEditorKit.ItalicAction());
        botonSubrayado.addActionListener(new StyledEditorKit.UnderlineAction());
        botonAzulBarra.addActionListener(new StyledEditorKit.ForegroundAction("poner azul",Color.BLUE));
        botonAmarilloBarra.addActionListener(new StyledEditorKit.ForegroundAction("poner amarillo",Color.YELLOW));
        botonRojoBarra.addActionListener(new StyledEditorKit.ForegroundAction("poner rojo",Color.RED));
        botonIzquierda.addActionListener(new StyledEditorKit.AlignmentAction("alinear izquierda",0));
        botonCentrar.addActionListener(new StyledEditorKit.AlignmentAction("centrar",1));
        botonDerecha.addActionListener(new StyledEditorKit.AlignmentAction("alinear derecha",2));
        botonJustificar.addActionListener(new StyledEditorKit.AlignmentAction("justificar",3));

        barra.add(botonNegrita);
        barra.add(botonCursiva);
        barra.add(botonSubrayado);
        barra.add(botonAzulBarra);
        barra.add(botonAmarilloBarra);
        barra.add(botonRojoBarra);
        barra.add(botonIzquierda);
        barra.add(botonCentrar);
        barra.add(botonDerecha);
        barra.add(botonJustificar);

         */

        barra = new JToolBar();

        configurarBarra("src/graficos/negrita.gif").addActionListener(new StyledEditorKit.BoldAction());
        configurarBarra("src/graficos/cursiva.gif").addActionListener(new StyledEditorKit.ItalicAction());
        configurarBarra("src/graficos/subrayado.gif").addActionListener(new StyledEditorKit.UnderlineAction());
        barra.addSeparator();
        configurarBarra("src/graficos/bola_azul.gif").addActionListener(
                new StyledEditorKit.ForegroundAction("poner azul",Color.BLUE));
        configurarBarra("src/graficos/bola_amarilla.gif").addActionListener(
                new StyledEditorKit.ForegroundAction("poner amarillo",Color.YELLOW));
        configurarBarra("src/graficos/bola_roja.gif").addActionListener(
                new StyledEditorKit.ForegroundAction("poner rojo",Color.RED));
        barra.addSeparator();
        configurarBarra("src/graficos/izquierda.gif").addActionListener(
                new StyledEditorKit.AlignmentAction("alinear izquierda",0));
        configurarBarra("src/graficos/centrar.gif").addActionListener(
                new StyledEditorKit.AlignmentAction("centrar",1));
        configurarBarra("src/graficos/derecha.gif").addActionListener(
                new StyledEditorKit.AlignmentAction("alinear derecha",2));
        configurarBarra("src/graficos/justificar.gif").addActionListener(
                new StyledEditorKit.AlignmentAction("justificar",3));

        barra.setOrientation(1);
        add(barra,BorderLayout.WEST);
    }

    public JButton configurarBarra(String ruta){

        JButton boton = new JButton(new ImageIcon(ruta));

        barra.add(boton);

        return boton;
    }

    public void configuraMenu (String rotulo, String menu, String tipoLetra, int estilos, int tamanyoFuente,
                               String rutaIcono) {

        JMenuItem elemMenu = new JMenuItem(rotulo, new ImageIcon(rutaIcono));

        if (menu == "Fuente") {
            fuente.add(elemMenu);
            elemMenu.addActionListener(new StyledEditorKit.FontFamilyAction("cambia letra",tipoLetra));
        } else if (menu == "Estilo") {
            estilo.add(elemMenu);
            if (estilos == Font.BOLD){
                elemMenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
                elemMenu.addActionListener(new StyledEditorKit.BoldAction());
            } else if (estilos == Font.ITALIC){
                elemMenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, InputEvent.CTRL_DOWN_MASK));
                elemMenu.addActionListener(new StyledEditorKit.ItalicAction());
            }
        } /* else if (menu == "Tamaño") {
            tamanyo.add(elemMenu);
            elemMenu.addActionListener(new StyledEditorKit.FontSizeAction("cambia tamaño",tamanyoFuente));
        } */

    }


}