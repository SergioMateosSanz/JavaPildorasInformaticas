package graficos;
import javax.swing.*;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.Image;
public class CreandoMarcoCentrado {
    public static void main(String[] args) {
        MarcoCentrado marco1=new MarcoCentrado();
        marco1.setVisible(true);//por defecto todas son invisibles, hay que indicarles que sea visible
        marco1.setTitle("Marco centrado");
        marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MarcoCentrado extends JFrame{
    
    public MarcoCentrado(){
        Toolkit miPantalla=Toolkit.getDefaultToolkit();
        Dimension tamanyoPantalla=miPantalla.getScreenSize();
        //int altura=(int)tamanyoPantalla.getHeight();
        //int ancho=(int)tamanyoPantalla.getWidth();
        int altura=tamanyoPantalla.height;
        int ancho=tamanyoPantalla.width;
        setSize(ancho/2,altura/2);
        setLocation(ancho/4,altura/4);
        Image miIcono=miPantalla.getImage("src/graficos/icono.gif");
        setIconImage(miIcono);//para cambiar la imagen del marco
    }
}