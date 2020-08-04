package graficos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PruebaAcciones {
    public static void main(String[] args) {
        
        MarcoAccion mimarco=new MarcoAccion();
        mimarco.setTitle("Prueba Acciones");
        mimarco.setBounds(600,350,600,300);
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
    }
}

class MarcoAccion extends JFrame{
    
    public MarcoAccion(){
        PanelAccion lamina=new PanelAccion();
        add(lamina);
        setVisible(true);
    }
}

class PanelAccion extends JPanel{
    
    public PanelAccion(){
        AccionColor accionAmarillo=new AccionColor("Amarillo",new ImageIcon("src/graficos/bola_amarilla.gif"),Color.YELLOW);
        AccionColor accionAzul=new AccionColor("Azul",new ImageIcon("src/graficos/bola_azul.gif"),Color.BLUE);
        AccionColor accionRojo=new AccionColor("Rojo",new ImageIcon("src/graficos/bola_roja.gif"),Color.RED);
        JButton botonAmarillo=new JButton(accionAmarillo);
        add(botonAmarillo);
        add(new JButton(accionAzul));
        add(new JButton(accionRojo));
        
        /*JButton botonAmarillo=new JButton("Amarillo");
        JButton botonAzul=new JButton("Azul");
        JButton botonRojo=new JButton("Rojo");
        add(botonAzul);
        add(botonAmarillo);
        add(botonRojo);*/
        
        InputMap mapaEntrada=getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);//creamos el mapa de entrada
        KeyStroke teclaAmarillo=KeyStroke.getKeyStroke("ctrl Y");//creamos la combinación de teclas
        mapaEntrada.put(teclaAmarillo, "fondo_amarillo");//asignamos la combinación de teclas a un objeto
        mapaEntrada.put(KeyStroke.getKeyStroke("ctrl B"), "fondo_azul");//creamos la combinación de teclas y asignamos la combinación de teclas a un objeto
        mapaEntrada.put(KeyStroke.getKeyStroke("ctrl R"), "fondo_rojo");//creamos la combinación de teclas y asignamos la combinación de teclas a un objeto
        ActionMap mapaAccion=getActionMap();
        mapaAccion.put("fondo_amarillo", accionAmarillo);//asignamos objeto a acción
        mapaAccion.put("fondo_azul", accionAzul);//asignamos objeto a acción
        mapaAccion.put("fondo_rojo", accionRojo);//asignamos objeto a acción
    }
    
    private class AccionColor extends AbstractAction{

        public AccionColor (String nombre, Icon icono, Color color_boton){
            putValue(Action.NAME, nombre);
            putValue(Action.SMALL_ICON, icono);
            putValue(Action.SHORT_DESCRIPTION, "Poner la lámina de color "+nombre);
            putValue("color_de_fondo",color_boton);
        }
    
        public void actionPerformed(ActionEvent e) {
            Color c=(Color)getValue("color_de_fondo");
            setBackground(c);
            System.out.println("Nombre: "+getValue(Action.NAME)+" Descripción: "+getValue(Action.SHORT_DESCRIPTION));
        } 
    }
}


