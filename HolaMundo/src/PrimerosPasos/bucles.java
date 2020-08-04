package PrimerosPasos;

import javax.swing.JOptionPane;
import java.util.Scanner;
public class bucles {
    public static void main(String args []) {
        Long resultado=1L;
        int numero=Integer.parseInt(JOptionPane.showInputDialog("Introduce el número"));
        
        for (int i=numero;i>0;i--){
            resultado=resultado*i;
        }
        
        System.out.println("El factorial de "+numero+ " es "+resultado);
        /*
        String email=JOptionPane.showInputDialog("Introduce tu email");
        int arroba=0;
        boolean punto=false;
        
        for (int i=0;i<email.length();i++){
            if (email.charAt(i)=='@'){
                arroba++;
            }
            if (email.charAt(i)=='.'){
                punto=true;
            }
        }
        if (arroba==1 && punto==true){
            System.out.println("Su email es correcto");
        }
        else{
            System.out.println("Su email no es válido");
        }
   
        
        System.out.println("Fila - Columna");
        for (int i=1;i<5;i++){
            System.out.print("  "+i+"   ");
            for (int j=1;j<5;j++){
                System.out.print(" "+j);
            }
            System.out.println();
        }
        
        String genero="";
        do{
            genero=JOptionPane.showInputDialog("Introduce tu genero ('M'/'F')");
        }while (genero.equalsIgnoreCase("M")==false && genero.equalsIgnoreCase("F")==false);
        
        int altura=Integer.parseInt(JOptionPane.showInputDialog("Introduce tu altura"));
        int pesoIdeal=0;
        
        if (genero.equalsIgnoreCase("M")){
            pesoIdeal=altura-110;
        }else{
            pesoIdeal=altura-120;
        }
        System.out.println("Tu peso ideal es "+pesoIdeal+" Kg");
        
        int aleatorio=(int)(Math.random()*100);
        Scanner entrada=new Scanner(System.in);
        int numero=0;
        int intentos=0;
        do{
            System.out.println("Introduce un número, por favor");
            numero=entrada.nextInt();
            
            if (aleatorio<numero){
                System.out.println("El número es menor");
            }
            else{
                System.out.println("El número es mayor");
            }
            intentos++;
        }while (numero!=aleatorio);
        System.out.println("Acerto el número "+aleatorio+" en "+intentos+" intentos");
        entrada.close();

        
        String clave="Sergio";
        String pass="";
        while (clave.equals(pass) == false){
            pass=JOptionPane.showInputDialog("Introduzca la contraseña, por favor");
            if (clave.equals(pass)==false){
                System.out.println("Contraseña incorrecta");
            }
        }
        System.out.println("Contraseña correcta, acceso permitido");
        */
    }
}
