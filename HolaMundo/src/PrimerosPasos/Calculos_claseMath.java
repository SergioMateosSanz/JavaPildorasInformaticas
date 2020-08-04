package PrimerosPasos;

public class Calculos_claseMath {
     public static void main(String args []) {
        
        double raiz=Math.sqrt(9);
        System.out.println(raiz);
        
        double num1=5.85;
        long resultado=Math.round(num1);
        System.out.println(resultado);
        float num2=5.85F;
        int resultado2=Math.round(num2);
        System.out.println(resultado2);
        //refundicion o casteo
        double num3=5.85;
        int resultado3=(int)Math.round(num3);
        System.out.println(resultado3);
        
        double base=5;
        double exponente=3;
        double resultado4=Math.pow(base, exponente);
        System.out.println("El resultado de "+(int)base+" elevado a "+(int)exponente+" es: "+resultado4);
    }
}
