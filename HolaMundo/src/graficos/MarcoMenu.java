package graficos;

import javax.swing.*;

public class MarcoMenu {
    public static void main(String[] args) {
        MenuFrame miMarco=new MenuFrame();
        miMarco.setTitle("Ejemplo Menu");
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        miMarco.setVisible(true);
    }
}

class MenuFrame extends JFrame {

    public MenuFrame() {
        setBounds(500,350,550,400);
        MenuLamina miLamina = new MenuLamina();
        add(miLamina);
    }
}

class MenuLamina extends JPanel {

    public MenuLamina(){
        JMenuBar miBarra = new JMenuBar();

        JMenu archivo = new JMenu("Archivo");
        JMenu edicion = new JMenu("Edición");
        JMenu herramientas = new JMenu("Herramientas");
        JMenu opciones = new JMenu("opciones");

        JMenuItem guardar = new JMenuItem("Guardar");
        JMenuItem guardarComo = new JMenuItem("Guardar Como");

        JMenuItem cortar = new JMenuItem("Cortar", new ImageIcon("src/graficos/cortar.gif"));
        JMenuItem copiar = new JMenuItem("Copiar", new ImageIcon("src/graficos/copiar.gif"));
        copiar.setHorizontalTextPosition(SwingConstants.LEFT);
        JMenuItem pegar = new JMenuItem("Pegar", new ImageIcon("src/graficos/pegar.gif"));

        JMenuItem generales = new JMenuItem("Generales");
        JMenuItem opcion1 = new JMenuItem("Opción 1");
        JMenuItem opcion2 = new JMenuItem("Opción 2");

        archivo.add(guardar);
        archivo.add(guardarComo);
        edicion.add(cortar);
        edicion.add(copiar);
        edicion.add(pegar);
        edicion.addSeparator();
        opciones.add(opcion1);
        opciones.add(opcion2);
        edicion.add(opciones);
        herramientas.add(generales);

        miBarra.add(archivo);
        miBarra.add(edicion);
        miBarra.add(herramientas);

        add(miBarra);
    }
}