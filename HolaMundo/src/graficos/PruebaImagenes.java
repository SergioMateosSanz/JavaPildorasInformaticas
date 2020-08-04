package graficos;

import javax.swing.*;
import java.awt.*;
import javax.imageio.*;
import java.io.*;

public class PruebaImagenes {
    public static void main(String[] args) {
        MarcoImagen mimarco=new MarcoImagen();
        mimarco.setVisible(true);
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MarcoImagen extends JFrame{   
    public MarcoImagen(){
        setTitle("Marco con imagen");
        setBounds(0,0,1200,700);
        LaminaConImagen miLamina=new LaminaConImagen();
        add(miLamina);//para agregar la lamina al marco
    }
}

class LaminaConImagen extends JPanel{
    
    public LaminaConImagen(){
        try{
        imagen = ImageIO.read(new File("src/graficos/bola.gif"));
        }catch(IOException e){
            System.out.println("La imagen no se encuentra");
        }
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);//para hacer lo que tiene declarado en JComponent   
        
        g.drawImage(imagen, 0, 0, null);
        System.out.println("Anchura:"+imagen.getWidth(this));
        System.out.println("Altura:"+imagen.getHeight(this));
        for (int i=0;i<1200;i++){
            for (int j=0;j<700;j++){
                //g.copyArea(0, 0, 220, 220, 220*i, 220*j);
                g.copyArea(0, 0, imagen.getWidth(this),imagen.getHeight(this),imagen.getWidth(this)*i,
                        imagen.getHeight(this)*j);
            }
        }
                
    }
    private Image imagen;
}