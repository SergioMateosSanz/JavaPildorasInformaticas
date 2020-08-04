package Colecciones;

import java.util.HashMap;
import java.util.Map;

public class PruebaMap {
    public static void main(String[] args){

        HashMap<String,Empleado> personal = new HashMap<String, Empleado>();
        personal.put("Director", new Empleado("Alfredo"));
        personal.put("Subdirector", new Empleado("José María"));
        personal.put("Administrativo", new Empleado("Juan Antonio"));
        personal.put("Administrativo", new Empleado("Felipe"));

        System.out.println(personal);

        personal.remove("Subdirector");
        System.out.println(personal);

        //System.out.println(personal.entrySet());

        for (Map.Entry<String,Empleado> entrada: personal.entrySet()) {
          String clave = entrada.getKey();
          Empleado valor = entrada.getValue();
          System.out.println("Clave= " + clave + ". Valor= " + valor);
        }
    }
}

class Empleado{

    private String nombre;
    private double sueldo;

    public Empleado(String nombre) {
        this.nombre = nombre;
        sueldo = 2000;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", sueldo=" + sueldo +
                '}';
    }
}
