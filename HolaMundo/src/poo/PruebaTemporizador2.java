package poo;

import javax.swing.Timer;
import java.awt.event.*;
import java.util.*;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

public class PruebaTemporizador2 {
    public static void main(String args []) {
        Reloj mireloj=new Reloj();
        mireloj.enMarcha(3000,true);
        
        JOptionPane.showMessageDialog(null, "Pulsa aceptar para detener");
        System.exit(0);
    }
}

class Reloj{
        
    public void enMarcha(int intervalo, final boolean sonido){
                
        class DameLaHora2 implements ActionListener{//clase interna_local
            public void actionPerformed(ActionEvent evento){
                Date ahora=new Date();
                System.out.println("Te pongo la hora cada 3seg: "+ahora);
        
                if (sonido==true){
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        }
        ActionListener oyente=new DameLaHora2();
        Timer mitemporizador=new Timer(intervalo, oyente);
        mitemporizador.start();
    }
}