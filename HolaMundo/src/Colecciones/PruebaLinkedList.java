package Colecciones;

import java.util.LinkedList;
import java.util.ListIterator;

public class PruebaLinkedList {

    public static void main(String[] args){

        LinkedList<String> personas = new LinkedList<String>();
        personas.add(0,"Pepe");
        personas.add("Sandra");
        personas.add("Ana");
        personas.add("Laura");

        System.out.println(personas.size());

        //personas.add(2,"Juan");

        ListIterator<String> it = personas.listIterator();

        it.next();
        it.add("Juan");

        for (String persona: personas){
            System.out.println(persona);
        }
    }
}
