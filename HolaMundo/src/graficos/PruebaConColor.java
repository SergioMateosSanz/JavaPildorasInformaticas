package graficos;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics2D;
import java.awt.SystemColor;
import java.awt.geom.*;

public class PruebaConColor {
    public static void main(String[] args) {
        MarcoConColor mimarco=new MarcoConColor();
        mimarco.setVisible(true);
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MarcoConColor extends JFrame{
    public MarcoConColor(){
        setSize(400,400);
        setTitle("Prueba de color");
        LaminaConColor miLamina=new LaminaConColor();
        add(miLamina);//para agregar la lamina al marco
        miLamina.setBackground(Color.PINK);
        //miLamina.setBackground(SystemColor.window);
    }
    
}

class LaminaConColor extends JPanel{
    public void paintComponent(Graphics g){
        super.paintComponent(g);//para hacer lo que tiene declarado en JComponent
        Graphics2D g2=(Graphics2D) g;//casting
        
        Rectangle2D rectangulo=new Rectangle2D.Double(100,100,200,150);
        g2.setPaint(Color.BLACK);
        g2.draw(rectangulo);
        g2.setPaint(Color.RED.brighter());
        g2.fill(rectangulo);
        
        Ellipse2D elipse=new Ellipse2D.Double();
        elipse.setFrame(rectangulo);
        Color micolor=new Color(109,172,59);
        g2.setPaint(micolor.brighter());
        g2.fill(elipse);
        
    }
}
