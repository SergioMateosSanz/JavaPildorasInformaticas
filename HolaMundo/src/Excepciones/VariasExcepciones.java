package Excepciones;

import javax.swing.*;

public class VariasExcepciones {

    public static void main(String[] args){

        //capturar excepciones No controladas se considera una mala práctica de programación, ya que son errores que se
        //originan por una mala codificación
        try{
            division();
        } catch (ArithmeticException e){
            System.out.println("No se puede dividir por 0");
        } catch (NumberFormatException e){
            System.out.println("Debe introducir un número entero");
            System.out.println(e.getMessage());
            System.out.println("Se ha generado un error de este tipo: " + e.getClass().getName());
        }
    }

    static void division(){

        int numero1 = Integer.parseInt(JOptionPane.showInputDialog("Introduce el dividendo"));
        int numero2 = Integer.parseInt(JOptionPane.showInputDialog("Introduce el divisor"));

        System.out.println("El resultado es: " + numero1/numero2);
    }
}
