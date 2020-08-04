package poo;

import java.awt.Toolkit;
import javax.swing.Timer;
import java.awt.event.*;
import java.util.*;
import javax.swing.JOptionPane;

public class PruebaTemporizador{
    public static void main(String args []) {
        DameLaHora oyente=new DameLaHora();
        //ActionListener oyente=new DameLaHora();
        Timer mitemporizador=new Timer(5000, oyente);
        mitemporizador.start();
        
        JOptionPane.showMessageDialog(null, "Pulsa aceptar para detener");
        System.exit(0);
    }
}

class DameLaHora implements ActionListener{
    public void actionPerformed(ActionEvent e){
        Date ahora=new Date();
        System.out.println("Te pongo la hora cada 5seg: "+ahora);
        
        Toolkit.getDefaultToolkit().beep();
    }
}
