package PrimerosPasos;

import java.util.Scanner;
import javax.swing.JOptionPane;
public class Condicionales {
    public static void main(String args []) {
        Scanner entrada=new Scanner(System.in);
        
        System.out.println("Elige una opción: \n1: Cuadrado \n2: Rectángulo \n3: Triángulo \n4: Círculo");
        
        int figura=entrada.nextInt();
        switch (figura){
            case 1:
                String lado_cuadrado=JOptionPane.showInputDialog("Introduce el lado del cuadrado");
                int lado=Integer.parseInt(lado_cuadrado);
                System.out.println("El área del cuadrado es: "+Math.pow(lado, 2));
                break;
            case 2:
                String base_rectangulo=JOptionPane.showInputDialog("Introduce la base del rectángulo");
                int base_rect=Integer.parseInt(base_rectangulo);
                String altura_rectangulo=JOptionPane.showInputDialog("Introduce la altura del rectángulo");
                int altura_rect=Integer.parseInt(altura_rectangulo);
                System.out.println("El área del rectángulo es: "+(base_rect*altura_rect));
                break;
            case 3:
                double base_tria=Double.parseDouble(JOptionPane.showInputDialog("Introduce la base del triángulo"));
                double altura_tria=Double.parseDouble(JOptionPane.showInputDialog("Introduce la altura del triángulo"));
                System.out.println("El área del triángulo es: "+(base_tria*altura_tria)/2);
                break;
            case 4:
                int radio=Integer.parseInt(JOptionPane.showInputDialog("Introduce el radio del círculo"));
                System.out.print("El área del círculo es: ");
                System.out.printf("%1.2f", Math.PI*(Math.pow(radio, 2)));
                System.out.println();
                break;
            default:
                System.out.println("La opción elegida no es correcta");
        }

        
        
        
        /*
        Scanner entrada=new Scanner(System.in);
        System.out.println("Introduce tu edad, por favor");
        int edad=entrada.nextInt();
        if (edad<18){
            System.out.println("Eres un adolescente");
        }
        else if (edad<40){
            System.out.println("Eres joven");
        }
        else if (edad<65){
            System.out.println("Eres maduro");
        }
        else{
            System.out.println("Cuidate!!");
        }
        */
    }
}
