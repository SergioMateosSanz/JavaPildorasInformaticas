package PrimerosPasos;

public class claseString {
    public static void main(String args []) {
        String nombre="Sergio";
        System.out.println("El nombre es: "+nombre);
        System.out.println("La longitud es de "+nombre.length()+" letras.");
        System.out.println("La primera letra de "+nombre+" es la "+nombre.charAt(0));
        int ultima_letra;
        ultima_letra=nombre.length();
        System.out.println("La última letra de "+nombre+" es la "+nombre.charAt(ultima_letra-1));
        
        String frase="Hoy es un día estupendo para aprender a programar en Java";
        String frase_resumen=frase.substring(29,frase.length());
        System.out.println(frase_resumen);
        
        String alumno1="David",alumno2="david";
        
        System.out.println(alumno1.equals(alumno2));
        System.out.println(alumno1.equalsIgnoreCase(alumno2));
    }
}
