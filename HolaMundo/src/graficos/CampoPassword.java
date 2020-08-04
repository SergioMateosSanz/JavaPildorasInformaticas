package graficos;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class CampoPassword {
    public static void main(String[] args) {
        MarcoPassword mimarco=new MarcoPassword();
        mimarco.setTitle("");
        mimarco.setBounds(400,300,550,400);
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MarcoPassword extends JFrame{

    public MarcoPassword(){
        LaminaPassword lamina=new LaminaPassword();
        add(lamina);
        setVisible(true);
    }
}

class LaminaPassword extends JPanel{

    private JPasswordField c_contra;

    public LaminaPassword(){
        setLayout(new BorderLayout());
        JPanel lamina_superior=new JPanel();
        lamina_superior.setLayout(new GridLayout(2,2));
        add(lamina_superior,BorderLayout.NORTH);
        JLabel etiqueta1=new JLabel("Usuario");
        JLabel etiqueta2=new JLabel("Contraseña (entre 8 y 12 caracteres)");
        JTextField c_usuario=new JTextField(15);
        c_usuario.setToolTipText("Ingrese Usuario");
        c_contra=new JPasswordField(15);
        c_contra.setToolTipText("Ingrese Contraseña");
        Comprueba_pass mi_evento=new Comprueba_pass();
        c_contra.getDocument().addDocumentListener(mi_evento);
        lamina_superior.add(etiqueta1);
        lamina_superior.add(c_usuario);
        lamina_superior.add(etiqueta2);
        lamina_superior.add(c_contra);
        JButton enviar=new JButton("Enviar");
        add(enviar,BorderLayout.SOUTH);
    }

    private class Comprueba_pass implements DocumentListener{

        @Override
        public void insertUpdate(DocumentEvent e) {
            char [] pass;
            pass=c_contra.getPassword();
            if (pass.length<8 || pass.length>12){
                c_contra.setForeground(Color.RED);
            }else{
                c_contra.setForeground(Color.BLACK);
            }
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            char [] pass;
            pass=c_contra.getPassword();
            if (pass.length<8 || pass.length>12){
                c_contra.setForeground(Color.RED);
            }else{
                c_contra.setForeground(Color.BLACK);
            }
        }

        @Override
        public void changedUpdate(DocumentEvent e) {

        }
    }
}
