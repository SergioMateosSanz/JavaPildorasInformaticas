package graficos;

import javax.swing.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Graphics;

public class FocoEvento {
    public static void main(String[] args) {
        
        MarcoFoco mimarco=new MarcoFoco();
        mimarco.setTitle("marco foco");
        mimarco.setBounds(700,300,600,450);
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
    }
}

class MarcoFoco extends JFrame{
    
    public MarcoFoco(){
        setVisible(true);
        add(new LaminaFoco());

    }
}

class LaminaFoco extends JPanel{
    JTextField cuadro1;
    JTextField cuadro2;

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        setLayout(null);
        cuadro1=new JTextField();
        cuadro2=new JTextField();
        cuadro1.setBounds(120,10,150,20);
        cuadro2.setBounds(120,50,150,20);
        add(cuadro1);
        add(cuadro2);
        LanzaFocos oyente_foco=new LanzaFocos();
        cuadro1.addFocusListener(oyente_foco);
    }

    private class LanzaFocos implements FocusListener{//clase interna

        public void focusGained(FocusEvent e) {
            System.out.println("He ganado el foco");
        }

        public void focusLost(FocusEvent e) {
            String email=cuadro1.getText();
            boolean comprobacion=false;
            for (int i=0;i<email.length();i++){
                if (email.charAt(i)=='@'){
                    comprobacion=true;
                }
            }
            if (comprobacion==true){
                System.out.println("Es correcto");
            }else{
                System.out.println("No es correcto");
            }
        }
    
    }
}