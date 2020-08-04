package graficos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculadora {
    public static void main(String[] args) {
        MarcoCalculadora mimarco=new MarcoCalculadora();
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mimarco.setVisible(true);
    }
}

class MarcoCalculadora extends JFrame {

    public MarcoCalculadora(){
        setTitle("Calculadora");
        setBounds(500,300,450,300);
        LaminaCalculadora milamina=new LaminaCalculadora();
        add(milamina);
        //pack(); //para que se adapte al tamaño por defecto del contenido
    }
}

class LaminaCalculadora extends JPanel{
    private JPanel milamina2;
    private JButton pantalla;
    private boolean principio;
    private double resultado;
    private String ultimaOperacion;

    public LaminaCalculadora(){
        principio=true;
        setLayout(new BorderLayout());
        pantalla=new JButton("0");
        pantalla.setEnabled(false);
        add(pantalla,BorderLayout.NORTH);
        milamina2=new JPanel();
        milamina2.setLayout(new GridLayout(4,4));
        ActionListener insertar=new InsertaNumero();
        ActionListener orden=new AccionOrden();
        PonerBoton("7",insertar);
        PonerBoton("8",insertar);
        PonerBoton("9",insertar);
        PonerBoton("/",orden);
        PonerBoton("4",insertar);
        PonerBoton("5",insertar);
        PonerBoton("6",insertar);
        PonerBoton("*",orden);
        PonerBoton("1",insertar);
        PonerBoton("2",insertar);
        PonerBoton("3",insertar);
        PonerBoton("-",orden);
        PonerBoton("0",insertar);
        PonerBoton(".",insertar);
        PonerBoton("+",orden);
        PonerBoton("=",orden);
        add(milamina2,BorderLayout.CENTER);
        ultimaOperacion="=";
    }
    private void PonerBoton(String rotulo,ActionListener oyente){
        JButton boton=new JButton(rotulo);
        boton.addActionListener(oyente);
        milamina2.add(boton);
    }
    private class InsertaNumero implements ActionListener{

        public void actionPerformed (ActionEvent e){
            String entrada=e.getActionCommand();
            if (principio==true){
                pantalla.setText("");
                principio=false;
            }
            pantalla.setText(pantalla.getText()+entrada);
        }
    }
    private class AccionOrden implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String operacion=e.getActionCommand();
            Calcular(Double.parseDouble(pantalla.getText()));
            ultimaOperacion=operacion;
            principio = true;
        }

        public void Calcular(double num) {
            if (ultimaOperacion.equals("+")){
                resultado=resultado+num;
            } else if (ultimaOperacion.equals("-")){
                resultado=resultado-num;
            } else if (ultimaOperacion.equals("*")){
                resultado=resultado*num;
            } else if (ultimaOperacion.equals("/")){
                resultado=resultado/num;
            } else if (ultimaOperacion.equals("=")){
                resultado=num;
            }
            pantalla.setText(""+resultado);
        }
    }
}
