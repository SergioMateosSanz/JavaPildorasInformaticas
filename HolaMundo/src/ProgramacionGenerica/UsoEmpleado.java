package ProgramacionGenerica;

import java.util.ArrayList;
import java.util.Iterator;

public class UsoEmpleado {

    public static void main(String[] args){

        /*Empleado listaEmpleados[] = new Empleado[3];
        listaEmpleados[0] = new Empleado("Ana",45, 2500);
        listaEmpleados[1] = new Empleado("Antonio",55,2000);
        listaEmpleados[2] = new Empleado("María",25,2600);
        */
        ArrayList<Empleado> listaEmpleados = new ArrayList<Empleado>();
        listaEmpleados.ensureCapacity(11); //le indicamos que tendra 11 elementos
        listaEmpleados.add(new Empleado("Ana", 45, 2500));
        listaEmpleados.add(new Empleado("Antonio", 55, 2000));
        listaEmpleados.add(new Empleado("María",25,2600));
        //listaEmpleados.add(new Empleado("María2",25,2600));
        listaEmpleados.set(1,new Empleado("Olga", 22, 2200));//sustituye el elemento que este en el índice
        System.out.println(listaEmpleados.get(1));
        //listaEmpleados.trimToSize(12); //elimina exceso de memoria, el recolector de basura elimine el espacio

        System.out.println("El número de elementos es: " + listaEmpleados.size());

        /*
        for (Empleado e: listaEmpleados){
            System.out.println(e.dameDatos());
        }
        for (int i=0; i<listaEmpleados.size();i++){
            System.out.println(listaEmpleados.get(i));
        }
        */

        //recorrer el ArrayList con iteradores
        Iterator<Empleado> miIterador = listaEmpleados.iterator();
        while (miIterador.hasNext()){
            //System.out.println(miIterador.next()); para imprimir necesitamos el toString sobreescirto en la clase
            System.out.println(miIterador.next().dameDatos());
        }
    }
}

class Empleado {

    private String nombre;
    private  int edad;
    private double salario;

    public Empleado(String nombre, int edad, double salario){

        this.nombre = nombre;
        this.edad = edad;
        this.salario = salario;
    }

    public String dameDatos(){
        return "El empleado se llama " + nombre + ". Tiene " + edad + " años." + "Y un salario de " + salario;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", salario=" + salario +
                '}';
    }
}
