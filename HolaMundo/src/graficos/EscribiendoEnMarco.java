package graficos;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.Graphics;

public class EscribiendoEnMarco {
    public static void main(String args []) {
        MarcoConTexto marco1=new MarcoConTexto();
        marco1.setTitle("Primer texto");
        marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MarcoConTexto extends JFrame{
    
    public MarcoConTexto(){
        Toolkit miPantalla=Toolkit.getDefaultToolkit();
        Dimension tamanyoPantalla=miPantalla.getScreenSize();
        int altura=tamanyoPantalla.height;
        int ancho=tamanyoPantalla.width;
        setSize(ancho/2,altura/2);
        setLocation(ancho/4,altura/4);
        setVisible(true);//por defecto todas son invisibles, hay que indicarles que sea visible
        Lamina miLamina=new Lamina();
        add(miLamina);//para agregar la lamina al marco
    }
}
class Lamina extends JPanel{
    public void paintComponent(Graphics g){
        super.paintComponent(g);//para hacer lo que tiene declarado en JComponent
        g.drawString("Estamos aprendiendo Swing", 10, 20);
    }
}