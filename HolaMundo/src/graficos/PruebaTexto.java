package graficos;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.Document;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PruebaTexto {
    public static void main(String[] args) {
        MarcoTexto mimarco=new MarcoTexto();
        mimarco.setTitle("Prueba Texto");
        mimarco.setBounds(600,300,600,350);
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MarcoTexto extends JFrame{

    public MarcoTexto(){
        LaminaTexto lamina=new LaminaTexto();
        add(lamina);
        setVisible(true);
    }
}

class LaminaTexto extends JPanel{

    public LaminaTexto(){
        JTextField micampo=new JTextField(20);
        EscuchaTexto el_evento=new EscuchaTexto();
        Document midoc=micampo.getDocument();
        midoc.addDocumentListener(el_evento);
        add(micampo);
    }

    private class EscuchaTexto implements DocumentListener{

        @Override
        public void insertUpdate(DocumentEvent e) {
            System.out.println("Has insertado texto");
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            System.out.println("Has borrado texto");
        }

        @Override
        public void changedUpdate(DocumentEvent e) {

        }
    }
}
/*
class LaminaTexto extends JPanel{

    private JTextField campo1;
    private JLabel resultado;

    public LaminaTexto(){
        setLayout(new BorderLayout());//lamina principal con disposición BorderLayout
        JPanel milamina2=new JPanel();
        milamina2.setLayout(new FlowLayout());
        JLabel etiqueta1=new JLabel("Email");
        milamina2.add(etiqueta1);
        campo1=new JTextField(30);
        milamina2.add(campo1);
        JButton miboton=new JButton("Comprobar");
        DameTexto mievento=new DameTexto();
        miboton.addActionListener(mievento);//poner el botón a la escucha
        milamina2.add(miboton);
        add(milamina2,BorderLayout.NORTH);
        resultado=new JLabel("", JLabel.CENTER);
        add(resultado,BorderLayout.CENTER);
    }

    private class DameTexto implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            int correcto=0;
            String email=campo1.getText().trim();//trim para quitar espacios al principio y al final
            for (int i=0;i<email.length();i++){
                if (email.charAt(i)=='@'){
                    correcto=correcto+1;
                }
            }

            if (correcto==1){
                resultado.setText("Email correcto");
            }else {
                resultado.setText("Email incorrecto");
            }
        }
    }
}
*/
