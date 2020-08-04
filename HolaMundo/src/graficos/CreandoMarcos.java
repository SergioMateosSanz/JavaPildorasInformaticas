package graficos;

import java.awt.Frame;
import javax.swing.*;

public class CreandoMarcos {
    public static void main(String[] args) {
        
        miMarco marco1=new miMarco();
        marco1.setVisible(true);//por defecto todas son invisibles, hay que indicarles que sea visible
        marco1.setTitle("Prueba ventana emergente");
        marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
}

class miMarco extends JFrame{
    
    public miMarco(){
        //setSize(500,300);
        //setLocation(400,260);
        setBounds(400,260,500,300);//este método unifica los dos anteriores
        //setResizable(false);//para no permitir cambiar el tamaño
        //setExtendedState(Frame.MAXIMIZED_BOTH);//para abrir el marco en pantalla completa
    }
}