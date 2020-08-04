package graficos;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionListener;

public class MarcoSliders {
    public static void main(String[] args) {
        FrameSliders miMarco=new FrameSliders();
        miMarco.setTitle("Ejemplo Sliders");
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        miMarco.setVisible(true);
    }
}

class FrameSliders extends JFrame {

    public FrameSliders() {
        setBounds(550,400,550,350);
        LaminaSliders miLamina = new LaminaSliders();
        add(miLamina);
    }
}

class LaminaSliders extends JPanel {
    private JLabel rotulo;
    private JSlider control;

    public LaminaSliders(){
        setLayout(new BorderLayout());
        rotulo = new JLabel("En un lugar de la mancha de cuyo nombre...");
        add(rotulo,BorderLayout.CENTER);

        control = new JSlider(8,50,12);
        control.setMajorTickSpacing(10);
        control.setMinorTickSpacing(5);
        control.setPaintTicks(true);
        control.setPaintLabels(true);
        control.setFont(new Font("Serif", Font.ITALIC,12));

        JPanel laminaSlider = new JPanel();
        laminaSlider.add(control);
        add(laminaSlider,BorderLayout.NORTH);

        control.addChangeListener(new EventoSlider());

        /*ejemplo del vídeo 96 (sin campos de clase)
        //JSlider control = new JSlider(); constructor por defecto sin parámetros
        JSlider control = new JSlider(SwingConstants.HORIZONTAL,0,100,50);
        //control.setOrientation(SwingConstants.VERTICAL);//otra forma para cambiar la horientación
        control.setMajorTickSpacing(25);
        control.setMinorTickSpacing(5);
        control.setPaintTicks(true);//para pintar las marcas
        control.setFont(new Font("Serif", Font.ITALIC,12));//para cambiar la fuente
        control.setPaintLabels(true);//para pintar los números
        control.setSnapToTicks(true);//para que al moverse se quede en una marca y no en medio
        add(control);

         */
    }

    private class EventoSlider implements ChangeListener{
        @Override
        public void stateChanged(ChangeEvent e) {
            int valor=control.getValue();
            rotulo.setFont(new Font("Serif", Font.PLAIN, valor));
            if(valor>=20){
                control.setBackground(Color.YELLOW);
                control.setForeground(Color.BLACK);
            }else {
                control.setBackground(Color.RED);
                control.setForeground(Color.WHITE);
            }
        }
    }
}

