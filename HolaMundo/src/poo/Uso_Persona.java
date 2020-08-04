package poo;

import java.util.Date;
import java.util.GregorianCalendar;

public class Uso_Persona {
    public static void main(String args []) {
        Persona[] lasPersonas=new Persona[2];
        
        lasPersonas[0]=new Empleado2("Luis Conde",30000,1999,8,01);
        lasPersonas[1]=new Alumno("Ana López","Biología");
        
        for (Persona p:lasPersonas){
            System.out.println(p.dameDescripcion());
        }
    }
}
abstract class Persona{
    private String nombre;
    
    public Persona(String nom){
        nombre=nom;
    }
    
    public String get_nombre(){
        return nombre;
    }
    public abstract String dameDescripcion();
}
 
class Empleado2 extends Persona{
    
    private double sueldo;
    private Date altaContrato;
    private static int IdSiguiente;
    private int Id;
    
    public Empleado2(String nom, double sue, int anyo, int mes, int dia){
        super(nom);
        sueldo=sue;
        GregorianCalendar calendario=new GregorianCalendar(anyo,mes-1,dia);
        altaContrato=calendario.getTime();
        ++IdSiguiente;
        Id=IdSiguiente;
    }
    public String dameDescripcion(){
        return "El empleado "+super.get_nombre()+ " tiene un id="+Id+". Con un sueldo="+sueldo;
    }
    public double get_sueldo(){
        return sueldo;
    }
    public Date get_fecha_contrato(){
        return altaContrato;
    }
        public void subeSueldo(double porcentaje){
        double aumento=sueldo*porcentaje/100;
        sueldo=sueldo+aumento;
    }
}
class Alumno extends Persona{
    
    private String carrera;
    
    public Alumno(String nom, String car){
        super(nom);
        carrera=car;
    }
    
    public String dameDescripcion(){
        return "El alumno "+super.get_nombre()+" esta estudiando "+carrera;
    }
}
