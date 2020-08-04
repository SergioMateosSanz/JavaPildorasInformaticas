package graficos;

import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics2D;
import java.awt.geom.*;

public class PruebaDibujo {
    public static void main(String[] args) {
        MarcoConDibujos mimarco=new MarcoConDibujos();
        mimarco.setVisible(true);
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MarcoConDibujos extends JFrame{
    public MarcoConDibujos(){
        setSize(400,400);
        setTitle("Prueba de dibujo");
        LaminaConFiguras miLamina=new LaminaConFiguras();
        add(miLamina);//para agregar la lamina al marco
    }
    
}

class LaminaConFiguras extends JPanel{
    public void paintComponent(Graphics g){
        super.paintComponent(g);//para hacer lo que tiene declarado en JComponent
        //g.drawRect(50, 50, 200, 200);
        //g.drawLine(50, 50, 250, 250);
        //g.drawArc(50, 50, 200, 200, 120, 150);
        Graphics2D g2=(Graphics2D) g;
        Rectangle2D rectangulo=new Rectangle2D.Double(100,100,200,150);
        g2.draw(rectangulo);
        Ellipse2D elipse=new Ellipse2D.Double();
        elipse.setFrame(rectangulo);
        g2.draw(elipse);
        g2.draw(new Line2D.Double(100,100,300,250));
        
        double CentroenX=rectangulo.getCenterX();
        double CentroenY=rectangulo.getCenterY();
        double radio=150;
        Ellipse2D circulo=new Ellipse2D.Double();
        circulo.setFrameFromCenter(CentroenX, CentroenY, CentroenX+radio, CentroenY+radio);
        g2.draw(circulo);
    }
}