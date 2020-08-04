package ProgramacionGenerica;

import java.util.GregorianCalendar;

public class MetodosGenericos {

    public static void main(String[] args){

        String nombres[] = {"José", "María", "Pepe"};
        System.out.println(MisMatrices.numeroElementos(nombres));

        Empleado listaEmpleados[] = {new Empleado("Ana",45, 2500),
            new Empleado("Juan", 36, 2300)};
        System.out.println(MisMatrices.numeroElementos(listaEmpleados));

        System.out.println(MisMatrices.obtenerMenor(nombres));

        GregorianCalendar fechas[] = {new GregorianCalendar(2015,07,12),
                    new GregorianCalendar(2015,05,12),
                    new GregorianCalendar(2015,04,12)};
        System.out.println(MisMatrices.obtenerMenor(fechas).getTime());
    }
}

class MisMatrices{

    public static <T> String numeroElementos(T[]entrada){

        return "El array tiene " + entrada.length + " elementos";
    }

    public static <T extends Comparable> T obtenerMenor(T[] entrada){

        if (entrada == null || entrada.length == 0){
            return null;
        } else{
            T elementoMenor = entrada[0];
            for (int i=1;i<entrada.length;i++){
                if (elementoMenor.compareTo(entrada[i])>0){
                    elementoMenor = entrada[i];
                }
            }
            return elementoMenor;
        }
    }
}