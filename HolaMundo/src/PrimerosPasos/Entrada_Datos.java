package PrimerosPasos;//import java.util.Scanner;
import javax.swing.JOptionPane;
public class Entrada_Datos {
    public static void main(String args []) {
        /*
        Scanner entrada=new Scanner(System.in);
        
        System.out.println("Introduce tu nombre, por favor");
        String nombre_usuario=entrada.nextLine();
        System.out.println("Introduce tu edad, por favor");
        int edad=entrada.nextInt();
        
        System.out.println("Hola "+nombre_usuario+". El año que viene tendrás "+(edad+1)+ " años");
        */
        String nombre_usuario=JOptionPane.showInputDialog("Introudce tu nombre, por favor");
        String edad=JOptionPane.showInputDialog("Introduce tu edad, por favor");
        int edad_num=Integer.parseInt(edad);
        System.out.println("Hola "+nombre_usuario+ ". El año que viene tendrás "+(edad_num+1)+ " años");
    }
}
