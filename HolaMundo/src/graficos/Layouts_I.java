package graficos;

import java.awt.*;
import javax.swing.*;

public class Layouts_I {
    public static void main(String[] args) {
        
        Marco_Layout mimarco=new Marco_Layout();
        mimarco.setTitle("Prueba Layout");
        mimarco.setBounds(600,350,600,200);
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
    }
}

class Marco_Layout extends JFrame{
    
    public Marco_Layout(){
        Panel_Layout lamina=new Panel_Layout();
        Panel_Layout2 lamina2=new Panel_Layout2();
        add(lamina,BorderLayout.NORTH);
        add(lamina2,BorderLayout.SOUTH);
        setVisible(true);
    }
}

class Panel_Layout extends JPanel{
    
    public Panel_Layout(){
        //setLayout(new FlowLayout(FlowLayout.CENTER,35,50));//cambiar la disposicion de los componentes de la lámina
        setLayout(new FlowLayout(FlowLayout.LEFT));
        add(new JButton("Amarillo"));
        add(new JButton("Rojo"));
        
    }
}

class Panel_Layout2 extends JPanel {
    
    public Panel_Layout2(){
        setLayout(new BorderLayout());
        add(new JButton("Azul"),BorderLayout.WEST);
        add(new JButton("Verde"),BorderLayout.EAST);
        add(new JButton("Negro"),BorderLayout.CENTER);
    }
}