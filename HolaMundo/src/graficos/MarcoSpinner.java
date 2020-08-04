package graficos;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class MarcoSpinner {
    public static void main(String[] args) {
        FrameSpinner miMarco=new FrameSpinner();
        miMarco.setTitle("Ejemplo Spinner");
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        miMarco.setVisible(true);
    }
}

class FrameSpinner extends JFrame {

    public FrameSpinner() {
        setBounds(550,350,550,350);
        LaminaSpinner miLamina = new LaminaSpinner();
        add(miLamina);
    }
}

class LaminaSpinner extends JPanel {

    private JLabel rotulo;
    private JSpinner control;
    /*
    public LaminaSpinner(){
        //JSpinner control = new JSpinner(new SpinnerDateModel());//para representar fechas
        /*
        String lista[] = {"Lunes", "Martes","Miércoles","Jueves","Viernes","Sábado","Domingo"};
        JSpinner control = new JSpinner(new SpinnerListModel(lista));
        Dimension miDim = new Dimension(100,20);
        control.setPreferredSize(miDim);//para especificar el tamaño
        add(control);
        String lista2[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        JSpinner control2 = new JSpinner(new SpinnerListModel(lista2));
        Dimension miDim2 = new Dimension(250,20);
        control2.setPreferredSize(miDim2);
        add(control2);

        JSpinner control = new JSpinner(new SpinnerNumberModel(5,0,10,1));
        add(control);
    }    */
    public LaminaSpinner(){
        setLayout(new BorderLayout());
        rotulo=new JLabel("En un lugar de la Mancha de cuyo nombre.... ");
        add(rotulo, BorderLayout.CENTER);

        //Primero un Array objeto String que almacena todos los tipos de letra de nuestro PC
        String lista[]=GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        //Segundo pasamos por parámetro el objeto String " lista "
        control=new JSpinner(new SpinnerListModel(lista));
        //Tercero. Creación de un objeto Dimension
        Dimension d=new Dimension(200,20);//Creamos un tamaño para pasarselo a nuestro control
        control.setPreferredSize(d);

        EventoSpinner mievento=new EventoSpinner();
        control.addChangeListener(mievento);

        JPanel laminaSlider=new JPanel();
        laminaSlider.add(control);
        add(laminaSlider, BorderLayout.NORTH);
    }

    private class EventoSpinner implements ChangeListener {

        @Override
        public void stateChanged(ChangeEvent e) {
            String valor = (String) control.getValue();
            rotulo.setFont(new Font(valor, Font.PLAIN, 17));
        }
    }
}
