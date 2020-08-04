package Colecciones;

public class UsoLibro {

    public static void main(String[] args){

        Libro libroA = new Libro("P en Java", "Juan", 25);
        Libro libroB = new Libro("P en Java", "Juan", 25);

        if (libroA.equals(libroB)){
            System.out.println("Es el mismo libro");
        } else {
            System.out.println("No es el mismo libro");
        }
        System.out.println(libroA.hashCode());
        System.out.println(libroB.hashCode());
    }
}
