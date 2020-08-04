package graficos;

import javax.swing.*;
import java.awt.*;

public class LibreDisposicion {

    public static void main(String[] args) {

        MarcoLibre miMarco=new MarcoLibre();
        miMarco.setTitle("Ejemplo Disposicion Libre");
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}

class MarcoLibre extends JFrame {

    public MarcoLibre(){

        setBounds(450,250,500,400);
        LaminaLibre miLaminaLibre = new LaminaLibre();
        add(miLaminaLibre);
        setVisible(true);
    }
}

class LaminaLibre extends JPanel {

    public LaminaLibre() {

        setLayout(new EnColumnas());
        JLabel nombre = new JLabel("Nombre");
        JLabel apellido = new JLabel("Apellido");
        JLabel edad = new JLabel("Edad");
        JLabel telefono = new JLabel("Teléfono");
        JTextField cuadroNombre = new JTextField();
        JTextField cuadroApellido = new JTextField();
        JTextField cuadroEdad = new JTextField();
        JTextField cuadroTelefono = new JTextField();

        /*nombre.setBounds(20,20,80,10);
        cuadroNombre.setBounds(100,17,100,20);
        apellido.setBounds(20,60,80,15);
        cuadroApellido.setBounds(100,55,100,20); */

        add(nombre);
        add(cuadroNombre);
        add(apellido);
        add(cuadroApellido);
        add(edad);
        add(cuadroEdad);
        add(telefono);
        add(cuadroTelefono);

        /*JButton botonA = new JButton("Boton 1");
        JButton botonB = new JButton("Boton 2");
        botonA.setBounds(50,50,150,50);
        botonB.setBounds(50,120,150,50);
        add(botonA);
        add(botonB);
        */
    }
}

class EnColumnas implements LayoutManager {

    private int x;
    private int y;

    @Override
    public void addLayoutComponent(String name, Component comp) {

    }

    @Override
    public void removeLayoutComponent(Component comp) {

    }

    @Override
    public Dimension preferredLayoutSize(Container parent) {
        return null;
    }

    @Override
    public Dimension minimumLayoutSize(Container parent) {
        return null;
    }

    @Override
    public void layoutContainer(Container parent) {

        y = 20;

        int dimesionContenedor = parent.getWidth();
        x = dimesionContenedor / 2;
        int contador = 0;
        int numeroComponentesAgregados = parent.getComponentCount();

        for (int i=0;i<numeroComponentesAgregados;i++){
            contador = contador + 1;
            Component componente = parent.getComponent(i);
            componente.setBounds(x-100,y,100,20);
            x = x + 100;
            if (contador%2 == 0){
                x = dimesionContenedor/2;
                y = y + 40;
            }
        }
    }
}