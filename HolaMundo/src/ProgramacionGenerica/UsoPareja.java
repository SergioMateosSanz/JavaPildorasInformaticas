package ProgramacionGenerica;

public class UsoPareja {

    public static void main(String[] args){

        Pareja<String> unaPareja = new Pareja<String>();
        unaPareja.setPrimero("Juan");
        System.out.println(unaPareja);
        System.out.println(unaPareja.getPrimero());

        Persona personaUno = new Persona("Ana");
        Pareja<Persona> otraPareja = new Pareja<Persona>();
        otraPareja.setPrimero(personaUno);
        System.out.println(otraPareja.getPrimero());
    }
}

class Persona{

    private String nombre;

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}
