package graficos;

import javax.swing.*;
import java.awt.event.*;

public class CambioEstado {
    public static void main(String[] args) {
        
        MarcoEstado mimarco=new MarcoEstado();
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
}

class MarcoEstado extends JFrame{
    
    public MarcoEstado(){
        //setTitle("Respondiendo");
        setBounds(300,300,500,350);
        setVisible(true);
            
        CambiaEstado nuevoEstado=new CambiaEstado();//creamos la instancia
        addWindowStateListener(nuevoEstado);

    }
}

class CambiaEstado implements WindowStateListener{
    
    public void windowStateChanged(WindowEvent e){
        //System.out.println("La ventana ha cambiado de estado");
        //System.out.println(e.getNewState());
        if (e.getNewState()==JFrame.MAXIMIZED_BOTH){
            System.out.println("La ventana esta a pantalla completa");
        }else if (e.getNewState()==JFrame.NORMAL) {
            System.out.println("La ventana esta normal");
        }else if (e.getNewState()==JFrame.ICONIFIED){
            System.out.println("La ventana esta a minimizada");
        }
        
    }
}
