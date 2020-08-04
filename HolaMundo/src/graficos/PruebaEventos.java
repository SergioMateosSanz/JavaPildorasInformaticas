package graficos;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PruebaEventos {
    public static void main(String[] args) {
        
        MarcoBotones mimarco=new MarcoBotones();
        mimarco.setVisible(true);//por defecto todas son invisibles, hay que indicarles que sea visible
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
}

class MarcoBotones extends JFrame{
    
    public MarcoBotones(){
        setTitle("Botones y Eventos");
        setBounds(700,300,500,300);
        LaminaBotones miLamina=new LaminaBotones();
        add(miLamina);
    }
}

class LaminaBotones extends JPanel {
    
    JButton botonAzul=new JButton("Azul");
    JButton botonAmarillo=new JButton("Amarillo");
    JButton botonRojo=new JButton("Rojo");
    
    public LaminaBotones(){
        add(botonAzul);
        add(botonAmarillo);
        add(botonRojo);
        ColorFondo Azul=new ColorFondo(Color.BLUE);
        ColorFondo Amarillo=new ColorFondo(Color.YELLOW);
        ColorFondo Rojo=new ColorFondo(Color.RED);
        botonAzul.addActionListener(Azul);
        botonAmarillo.addActionListener(Amarillo);
        botonRojo.addActionListener(Rojo);
    }

class ColorFondo implements ActionListener {
    
    private Color colorDeFondo;
    
    public ColorFondo(Color c){
       colorDeFondo=c;
    }
    public void actionPerformed(ActionEvent e){
        setBackground(colorDeFondo);
    }
}
}



/*
class LaminaBotones extends JPanel implements ActionListener {
    
    JButton botonAzul=new JButton("Azul");
    JButton botonAmarillo=new JButton("Amarillo");
    JButton botonRojo=new JButton("Rojo");
    
    public LaminaBotones(){
        add(botonAzul);
        add(botonAmarillo);
        add(botonRojo);
        botonAzul.addActionListener(this);
        botonAmarillo.addActionListener(this);
        botonRojo.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){
        
        Object botonPulsado=e.getSource();
        if (botonPulsado==botonAzul){
            setBackground(Color.BLUE);
        }
        if (botonPulsado==botonAmarillo){
            setBackground(Color.YELLOW);
        }
        if (botonPulsado==botonRojo){
            setBackground(Color.RED);
        }
    }
}
*/