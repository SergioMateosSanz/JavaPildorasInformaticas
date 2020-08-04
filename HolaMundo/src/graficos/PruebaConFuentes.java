package graficos;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class PruebaConFuentes {
    public static void main(String[] args) {
        MarcoConFuentes mimarco=new MarcoConFuentes();
        mimarco.setVisible(true);
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MarcoConFuentes extends JFrame{
    public MarcoConFuentes(){
        setSize(400,400);
        setTitle("Prueba de fuentes");
        LaminaConFuentes miLamina=new LaminaConFuentes();
        add(miLamina);//para agregar la lamina al marco
        miLamina.setForeground(Color.BLUE);
    }
}

class LaminaConFuentes extends JPanel{
    public void paintComponent(Graphics g){
        super.paintComponent(g);//para hacer lo que tiene declarado en JComponent
        Graphics2D g2=(Graphics2D) g;//casting
        
        Font miFuente=new Font("Courier",Font.BOLD,26);
        g2.setFont(miFuente);
        //g2.setColor(Color.BLUE);
        g2.drawString("Juan", 100, 100);
        
        g2.setFont(new Font("Arial",Font.ITALIC,24));
        //g2.setColor(Color.BLACK);
        g2.drawString("Curso de Java", 100, 200);

    }
}