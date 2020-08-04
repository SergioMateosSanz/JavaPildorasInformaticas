package graficos;

import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import javax.swing.JFrame;

public class FocoVentana extends JFrame implements WindowFocusListener {
    public static void main(String[] args) {
         FocoVentana miventana=new FocoVentana();
         miventana.iniciar();
    }
     
    public void iniciar(){
        marco1=new FocoVentana();
        marco2=new FocoVentana();
        marco1.setVisible(true);
        marco2.setVisible(true);
        marco1.setBounds(300, 100, 600, 350);
        marco2.setBounds(900, 100, 600, 350);
        marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco1.addWindowFocusListener(this);
        marco2.addWindowFocusListener(this);
    } 
    public void windowGainedFocus(WindowEvent e) {
        if (e.getSource()==marco1){
            marco1.setTitle("Tengo el foco");
        }
        if (e.getSource()==marco2){
            marco2.setTitle("Tengo el foco");
        }
    }

    public void windowLostFocus(WindowEvent e) {
        if (e.getSource()==marco1){
            marco1.setTitle("");
        }
        if (e.getSource()==marco2){
            marco2.setTitle("");
        }
    }
    FocoVentana marco1;
    FocoVentana marco2;
}
