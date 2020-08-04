package graficos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class BarraHerramientas {
    public static void main(String[] args) {

        MarcoBarra mimarco=new MarcoBarra();
        mimarco.setTitle("Marco con barra");
        mimarco.setBounds(500,300,600,450);
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mimarco.setVisible(true);
    }
}

class MarcoBarra extends JFrame{

    private JPanel lamina;

    public MarcoBarra(){

        lamina = new JPanel();
        add(lamina);

        Action accionAmarillo=new AccionColor("Amarillo",new ImageIcon("src/graficos/bola_amarilla.gif"), Color.YELLOW);
        Action accionAzul=new AccionColor("Azul",new ImageIcon("src/graficos/bola_azul.gif"),Color.BLUE);
        Action accionRojo=new AccionColor("Rojo",new ImageIcon("src/graficos/bola_roja.gif"),Color.RED);
        Action accionSalir = new AbstractAction("Salir", new ImageIcon("src/graficos/salir.gif")) {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        };

        JMenu menu = new JMenu("Color");
        menu.add(accionAmarillo);
        menu.add(accionAzul);
        menu.add(accionRojo);

        JMenuBar barraMenu = new JMenuBar();
        barraMenu.add(menu);
        setJMenuBar(barraMenu);

        JToolBar barraHerramientas = new JToolBar();
        barraHerramientas.add(accionAmarillo);
        barraHerramientas.add(accionAzul);
        barraHerramientas.add(accionRojo);
        barraHerramientas.addSeparator();
        barraHerramientas.add(accionSalir);
        add(barraHerramientas,BorderLayout.NORTH);
    }

    private class AccionColor extends AbstractAction{

        public AccionColor (String nombre, Icon icono, Color color_boton){

            putValue(Action.NAME, nombre);
            putValue(Action.SMALL_ICON, icono);
            putValue(Action.SHORT_DESCRIPTION, "Color de fondo..."+nombre);
            putValue("Color",color_boton);
        }

        public void actionPerformed(ActionEvent e) {

            Color c=(Color)getValue("Color");
            lamina.setBackground(c);
        }
    }
}