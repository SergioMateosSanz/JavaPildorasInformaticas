package graficos;

import javax.swing.*;
import java.awt.event.*;

public class EventosRaton {
    public static void main(String[] args) {
        
        MarcoConRaton mimarco=new MarcoConRaton();
        mimarco.setTitle("Ventana 1");
        mimarco.setBounds(700,300,600,450);
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
    }
}

class MarcoConRaton extends JFrame{
    
    public MarcoConRaton(){
        setVisible(true);
        EventoDeRaton oyente_raton=new EventoDeRaton();
        addMouseListener(oyente_raton);
        EventoDeRaton2 oyente_raton2=new EventoDeRaton2();
        addMouseMotionListener(oyente_raton2);

    }
}

class EventoDeRaton extends MouseAdapter{
    public void mouseClicked(MouseEvent e){
        //System.out.println("Coordenada X:"+e.getX()+"Coordenada Y:"+e.getY());
        //System.out.println(e.getClickCount());
    }
    public void mousePressed(MouseEvent e){
        //System.out.println(e.getModifiersEx());
        if (e.getModifiersEx()==MouseEvent.BUTTON1_DOWN_MASK){
            System.out.println("Ha pulsado el botón izquierdo");
        }else if (e.getModifiersEx()==MouseEvent.BUTTON3_DOWN_MASK){
            System.out.println("Ha pulsado el botón derecho");
        }else if (e.getModifiersEx()==MouseEvent.BUTTON2_DOWN_MASK){
            System.out.println("Ha pulsado la rueda");
        }
    }
}
class EventoDeRaton2 implements MouseMotionListener{

    public void mouseDragged(MouseEvent me) {
        System.out.println("Estas arrastrando el ratón");
    }

    public void mouseMoved(MouseEvent me) {
        System.out.println("Estas moviendo el ratón");
    }
    
}
/*
class EventoDeRaton implements MouseListener{

    public void mouseClicked(MouseEvent e) {
        System.out.println("Ratón pulsado");
    }

    public void mousePressed(MouseEvent e) {
        System.out.println("Ratón presionado");
    }

    public void mouseReleased(MouseEvent e) {
        System.out.println("Ratón soltado");
    }

    public void mouseEntered(MouseEvent e) {
        System.out.println("Acabas de entrar");
    }

    public void mouseExited(MouseEvent e) {
       System.out.println("Acabas de salir");
    }
    
}
*/