package Serializacion;

import java.io.*;
import java.util.Date;
import java.util.GregorianCalendar;

public class Serializando {

    public static void main(String[] args) {

        Administrador jefe=new Administrador("Juan", 80000, 2005,12,15);
        jefe.setIncentivo(5000);

        Empleado[] personal=new Empleado[3];
        personal[0]=jefe;
        personal[1]=new Empleado("Ana", 25000, 2008, 10,1);
        personal[2]=new Empleado("Luis", 18000, 2012, 9,15);

        try{
            ObjectOutputStream escribiendoFichero = new ObjectOutputStream(new FileOutputStream("C:/Users/" +
                    "n128529/Documents/NetBeansProjects/HolaMundo/src/Serializacion/empleado.dat"));
            escribiendoFichero.writeObject(personal);
            escribiendoFichero.close();
            ObjectInputStream leyendoFichero = new ObjectInputStream(new FileInputStream("C:/Users/" +
                    "n128529/Documents/NetBeansProjects/HolaMundo/src/Serializacion/empleado.dat"));
            Empleado[] personalRecuperado = (Empleado[]) leyendoFichero.readObject();
            leyendoFichero.close();

            //for (int i=0;i<personalRecuperado.length;i++){
              //  personalRecuperado[i].toString();
            //}
            for (Empleado e : personalRecuperado){
                System.out.println(e);
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("Se ha generado un error de este tipo: " + e.getClass().getName());
        }
    }
}

class Empleado implements Serializable {

    //private static final long serialVersionUID = 1L;
    private String nombre;
    private double sueldo;
    private Date fechaContrato;

    public Empleado(String nombreEntrada, double sueldoEntrada, int agno, int mes, int dia){

        nombre=nombreEntrada;
        sueldo=sueldoEntrada;
        GregorianCalendar calendario=new GregorianCalendar(agno, mes-1,dia);
        fechaContrato=calendario.getTime();
    }

    public String getNombre() {
        return nombre;
    }

    public double getSueldo() {
        return sueldo;
    }

    public Date getFechaContrato() {
        return fechaContrato;
    }

    public void subirSueldo(double porcentaje){

        double aumento=sueldo*porcentaje/100;
        sueldo+=aumento;
    }

    public String toString(){

        return "El Nombre es =" + nombre + ",y su sueldo es =" + sueldo + ", fecha de contrato=" + fechaContrato;
    }
}

class Administrador extends Empleado{

    //private static final long serialVersionUID = 1L;
    private double incentivo;

    public Administrador(String n, double s, int agno, int mes, int dia){

        super(n,s,agno,mes,dia);
        incentivo=0;
    }

    public double getSueldo(){

        double sueldoBase=super.getSueldo();
        return sueldoBase + incentivo;
    }

    public void setIncentivo(double b){

        incentivo=b;
    }


    public String toString(){

        return super.toString() + " Incentivo=" + incentivo;
    }
}
