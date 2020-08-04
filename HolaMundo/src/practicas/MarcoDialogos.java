package practicas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.util.Date;

public class MarcoDialogos extends JFrame {

    private LaminaBotones laminaTipo, laminaTipoMensaje, laminaMensaje, laminaTipoOpcion, laminaOpciones, laminaEntrada;
    private String cadenaMensaje = "Mensaje";
    private Icon iconoMensaje = new ImageIcon("src/graficos/bola_azul.gif");
    private Object objetoMensaje = new Date();
    private Component componenteMensaje = new LaminaEjemplo();

    public MarcoDialogos(){

        setTitle("Prueba de diálogos");
        setBounds(300,200,600,450);
        JPanel laminaCuadricula = new JPanel();
        laminaCuadricula.setLayout(new GridLayout(2,3));

        String primero [] = {"Mensaje", "Confirmar", "Opción", "Entrada"};
        laminaTipo = new LaminaBotones("Tipo", primero);

        laminaTipoMensaje = new LaminaBotones("Tipo de Mensaje", new String []{
           "ERROR_MESSAGE", "INFORMATION_MESSAGE", "WARNING_MESSAGE", "QUESTION_MESSAGE", "PLAIN_MESSAGE"
        });
        laminaMensaje = new LaminaBotones("Mensaje", new String []{
            "Cadena", "Icono", "Componente", "Otros", "Object[]"
        });
        laminaTipoOpcion = new LaminaBotones("Confirmar", new String[]{
                "DEFAULT_OPTION", "YES_NO_OPTION", "YES_NO_CANCEL_OPTION", "OK_CANCEL_OPTION"
        });
        laminaOpciones = new LaminaBotones("Opción", new String[]{
                "String[]", "Icon[]", "Object[]"
        });
        laminaEntrada = new LaminaBotones("Entrada", new String[]{
           "Campo de texto", "Combo"
        });

        setLayout(new BorderLayout());

        laminaCuadricula.add(laminaTipo);
        laminaCuadricula.add(laminaTipoMensaje);
        laminaCuadricula.add(laminaMensaje);
        laminaCuadricula.add(laminaTipoOpcion);
        laminaCuadricula.add(laminaOpciones);
        laminaCuadricula.add(laminaEntrada);

        JPanel laminaMostrar = new JPanel();
        JButton botonMostrar = new JButton("Mostrar");
        botonMostrar.addActionListener(new ActionMostrar());
        laminaMostrar.add(botonMostrar);

        add(laminaCuadricula, BorderLayout.CENTER);
        add(laminaMostrar, BorderLayout.SOUTH);
    }

    public Object dameMensaje(){

        String seleccion = laminaMensaje.dameSeleccion();

        if (seleccion.equals("Cadena")){
            return cadenaMensaje;
        } else if (seleccion.equals("Icono")){
            return iconoMensaje;
        } else if (seleccion.equals("Componente")){
            return componenteMensaje;
        } else if (seleccion.equals("Otros")){
            return objetoMensaje;
        } else if (seleccion.equals("Object[]")){
            return new Object[]{cadenaMensaje,iconoMensaje,componenteMensaje,objetoMensaje};
        } else {
            return null;
        }
    }

    public int dameTipoMensaje(){

        String seleccion = laminaTipoMensaje.dameSeleccion();

        if (seleccion.equals("ERROR_MESSAGE")){
            return JOptionPane.ERROR_MESSAGE;
        } else if (seleccion.equals("INFORMATION_MESSAGE")){
            return JOptionPane.INFORMATION_MESSAGE;
        } else if (seleccion.equals("WARNING_MESSAGE")){
            return JOptionPane.WARNING_MESSAGE;
        } else if (seleccion.equals("QUESTION_MESSAGE")){
            return JOptionPane.QUESTION_MESSAGE;
        } else {
            return JOptionPane.PLAIN_MESSAGE;
        }
    }

    public int dameTipoOpcion(){

        String seleccion = laminaTipoOpcion.dameSeleccion();

        if (seleccion.equals("DEFAULT_OPTION")){
            return JOptionPane.DEFAULT_OPTION;
        } else if (seleccion.equals("YES_NO_OPTION")){
            return JOptionPane.YES_NO_OPTION;
        } else if (seleccion.equals("YES_NO_CANCEL_OPTION")){
            return JOptionPane.YES_NO_CANCEL_OPTION;
        } else if (seleccion.equals("OK_CANCEL_OPTION")){
            return JOptionPane.OK_CANCEL_OPTION;
        } else {
            return 0;
        }
    }

    public Object[] dameOpciones (LaminaBotones lamina) {

        String seleccion = lamina.dameSeleccion();

        if (seleccion.equals("String[]")){
            return new String[]{"Amarillo", "Azul", "Rojo"};
        } else if (seleccion.equals("Icon[]")){
            return new Object[]{new ImageIcon("src/graficos/bola_amarilla.gif"),
                new ImageIcon("src/graficos/bola_azul.gif"),
                new ImageIcon("src/graficos/bola_roja.gif")};
        } else if (seleccion.equals("Object[]")){
            return new Object[]{cadenaMensaje,iconoMensaje,componenteMensaje,objetoMensaje};
        }
         else{
            return null;
        }
    }

    private class ActionMostrar implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            if (laminaTipo.dameSeleccion().equals("Mensaje")){
                JOptionPane.showMessageDialog(MarcoDialogos.this, dameMensaje(),"Título",
                        dameTipoMensaje());
            } else if (laminaTipo.dameSeleccion().equals("Confirmar")){
                JOptionPane.showConfirmDialog(MarcoDialogos.this, dameMensaje(), "Título",
                        dameTipoOpcion(), dameTipoMensaje());
            } else if (laminaTipo.dameSeleccion().equals("Entrada")){
                if (laminaEntrada.dameSeleccion().equals("Campo de texto")){
                    JOptionPane.showInputDialog(MarcoDialogos.this, dameMensaje(),
                            "Título", dameTipoMensaje(), null, null, null);
                } else {
                    JOptionPane.showInputDialog(MarcoDialogos.this, dameMensaje(),
                            "Título", dameTipoMensaje(), null, new String[]{"Amarillo", "Azul", "Rojo"},
                            "Azul");
                }
            } else if (laminaTipo.dameSeleccion().equals("Opción")){
                JOptionPane.showOptionDialog(MarcoDialogos.this, dameMensaje(), "Título",
                        1, dameTipoMensaje(),null, dameOpciones(laminaOpciones),
                        null);
            }
        }
    }
}

class LaminaEjemplo extends JPanel{

    public LaminaEjemplo(){

        this.setBackground(Color.YELLOW);

    }
    /*public void PaintComponent(Graphics g){

        super.paintComponents(g);
        Graphics2D g2 = (Graphics2D) g;
        Rectangle2D rectangulo = new Rectangle2D.Double(0,0,getWidth(),getHeight());
        g2.setPaint(Color.YELLOW);
        g2.fill(rectangulo);
    } */
}