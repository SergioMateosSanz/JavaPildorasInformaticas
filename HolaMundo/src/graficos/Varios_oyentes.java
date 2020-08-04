package graficos;

import javax.swing.*;
import java.awt.event.*;

public class Varios_oyentes {
    public static void main(String[] args) {
        
        Marco_Principal mimarco=new Marco_Principal();
        mimarco.setTitle("Prueba Varios");
        mimarco.setBounds(1300,100,300,200);
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
    }
}

class Marco_Principal extends JFrame{
    
    public Marco_Principal(){
        LaminaPrincipal lamina=new LaminaPrincipal();
        add(lamina);
        setVisible(true);
    }
}

class LaminaPrincipal extends JPanel{
    
    JButton boton_cerrar;
    
    public LaminaPrincipal(){
        JButton boton_nuevo=new JButton("Nuevo");
        add(boton_nuevo);
        boton_cerrar=new JButton("Cerrar Todo");
        add(boton_cerrar);
        OyenteNuevo mioyente=new OyenteNuevo();
        boton_nuevo.addActionListener(mioyente);
    }
    
    private class OyenteNuevo implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            Marco_Emergente marco=new Marco_Emergente(boton_cerrar);
            marco.setVisible(true);
        }
        
    }
}

class Marco_Emergente extends JFrame{
    
    private static int contador=0;
    
    public Marco_Emergente(JButton boton_de_principal){
        contador=contador+1;//contador++;
        setTitle("Ventana "+contador);
        setBounds(40*contador,40*contador,300,150);
        CierraTodos oyenteCerrar=new CierraTodos();
        boton_de_principal.addActionListener(oyenteCerrar);
    }
    
    private class CierraTodos implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            dispose();
            contador=0;
        }
        
    }
}