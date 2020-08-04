package Colecciones;

import java.util.LinkedList;
import java.util.ListIterator;

public class PruebaListaEnlazada {

    public static void main(String[] args){

        LinkedList<String> paises = new LinkedList<String>();
        LinkedList<String> capitales = new LinkedList<String>();

        paises.add("España");
        paises.add("Colombia");
        paises.add("Mexico");
        paises.add("Perú");

        capitales.add("Madrid");
        capitales.add("Bogotá");
        capitales.add("D.F");
        capitales.add("Lima");

        System.out.println(paises);
        System.out.println(capitales);

        ListIterator<String> itPaises = paises.listIterator();
        ListIterator<String> itCapitales = capitales.listIterator();

        //Añadir capitales a los paises
        while (itCapitales.hasNext()){
            if (itPaises.hasNext()){
                itPaises.next();
                itPaises.add(itCapitales.next());
            }
        }

        System.out.println(paises);

        itCapitales = capitales.listIterator();//el iterador apunta al inicio de la LinkedList
        while (itCapitales.hasNext()){
            itCapitales.next();
            if(itCapitales.hasNext()){
                itCapitales.next();
                itCapitales.remove();
            }
        }

        System.out.println(capitales);//la LinkedList con posiciones impares eliminadas

        paises.removeAll(capitales);
        System.out.println(paises);
    }
}
