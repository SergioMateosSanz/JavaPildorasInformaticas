package Colecciones;

import java.util.Comparator;
import java.util.TreeSet;

public class PruebaTreeSet {

    public static void main(String[] args){

        TreeSet<String> ordenaPersona = new TreeSet<String>();//se ordena automáticamente porque implementa la interfaz
        //comparable
        ordenaPersona.add("Sandra");
        ordenaPersona.add("Amanda");
        ordenaPersona.add("Diana");

        for (String s: ordenaPersona) {
            System.out.println(s);
        }

        Articulo primero = new Articulo(1,"Primer artículo");
        Articulo segundo = new Articulo(20,"Segundo artículo");
        Articulo tercero = new Articulo(3, "Tercer artículo");
        TreeSet<Articulo> ordenaArticulos = new TreeSet<Articulo>();
        ordenaArticulos.add(segundo);
        ordenaArticulos.add(tercero);
        ordenaArticulos.add(primero);

        for (Articulo a: ordenaArticulos) {
            System.out.println(a);
        }

        Articulo comparadorArticulos = new Articulo();
        TreeSet<Articulo> ordenaArticulos2 = new TreeSet<Articulo>(comparadorArticulos);
        ordenaArticulos2.add(tercero);
        ordenaArticulos2.add(primero);
        ordenaArticulos2.add(segundo);

        for (Articulo ar: ordenaArticulos2) {
            System.out.println(ar);
        }

        //la clase Articulo2 no implementa la interfaz Comparable (ejemplo clases no creadas por nosotros)
        Articulo2 primerArticulo = new Articulo2(1,"Primer artículo");
        Articulo2 segundoArtículo = new Articulo2(20,"Segundo artículo");
        Articulo2 tercerArticulo = new Articulo2(3, "Tercer artículo");
        //utilizamos una clase interna anónima
        TreeSet<Articulo2>  ordenaArticulos3 = new TreeSet<Articulo2>(new Comparator<Articulo2>() {
            @Override
            public int compare(Articulo2 o1, Articulo2 o2) {
                String descripcionA = o1.getDescripcion();
                String descripcionB = o2.getDescripcion();
                return descripcionA.compareTo(descripcionB);
            }
        });
        ordenaArticulos3.add(tercerArticulo);
        ordenaArticulos3.add(segundoArtículo);
        ordenaArticulos3.add(primerArticulo);

        for (Articulo2 art: ordenaArticulos3) {
            System.out.println(art);
        }
    }
}

class Articulo implements Comparable<Articulo>, Comparator<Articulo> {

    private int numero;
    private String descripcion;

    public Articulo(){

    }

    public Articulo(int numero, String descripcion){
        this.numero = numero;
        this.descripcion = descripcion;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Articulo{" +
                "numero=" + numero +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }

    @Override
    public int compareTo(Articulo o) {
        return numero - o.getNumero();
    }

    @Override
    public int compare(Articulo o1, Articulo o2) {
        String descripcionA = o1.getDescripcion();
        String descripcionB = o2.getDescripcion();
        return descripcionA.compareTo(descripcionB);
    }
}

class Articulo2 {

    private int numero;
    private String descripcion;

    public Articulo2(int numero, String descripcion) {
        this.numero = numero;
        this.descripcion = descripcion;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Articulo2{" +
                "numero=" + numero +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}


