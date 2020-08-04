package Excepciones;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class LeerImagen {
    public static void main(String[] args) {
        MarcoImagen mimarco=new MarcoImagen();
        mimarco.setVisible(true);
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MarcoImagen extends JFrame{
    public MarcoImagen(){
        setTitle("Marco con imagen");
        setBounds(50,30,1200,700);
        LaminaConImagen miLamina=new LaminaConImagen();
        add(miLamina);//para agregar la lamina al marco
    }
}

class LaminaConImagen extends JPanel {

    private Image imagen;

    public LaminaConImagen() {
        try {
            imagen = ImageIO.read(new File("src/Excepciones/bola.gif"));
        } catch (IOException e) {
            System.out.println("La imagen no se encuentra");
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);//para hacer lo que tiene declarado en JComponent

        if (imagen == null){
            g.drawString("No podemos cargar la imagen", 10 , 10);
        } else {
            g.drawImage(imagen, 0, 0, null);
            for (int i = 0; i < 1200; i++) {
                for (int j = 0; j < 700; j++) {
                    //g.copyArea(0, 0, 220, 220, 220*i, 220*j);
                    g.copyArea(0, 0, imagen.getWidth(this), imagen.getHeight(this), imagen.getWidth(this) * i,
                            imagen.getHeight(this) * j);
                }
            }
        }
    }

}
