package poo;

public class Constantes {
    public static void main(String args []) {
        Empleados trabajador1=new Empleados("Roberto");
        Empleados trabajador2=new Empleados("María");
        Empleados trabajador3=new Empleados("Juan");
        Empleados trabajador4=new Empleados("Víctor");
        
        trabajador2.set_seccion("Ventas");
        
        System.out.println(trabajador1.devuelve_datos());
        System.out.println(trabajador2.devuelve_datos());
        System.out.println(trabajador3.devuelve_datos());
        System.out.println(trabajador4.devuelve_datos());
        
        System.out.println(Empleados.devuelve_IdSiguiente());
    }
}

class Empleados{
    private final String nombre;//final para que no se pueda cambiar el contenido de la propiedad
    private String seccion;
    private int Id;
    private static int IdSiguiente=1;
    
    public Empleados(String nom){
        nombre=nom;
        seccion="Administración";
        Id=IdSiguiente;
        IdSiguiente=IdSiguiente+1;
    }
    public void set_seccion(String seccion){
        this.seccion=seccion;
    }
    public String get_nombre(){
        return nombre;
    }
    public String get_seccion(){
        return seccion;
    }
    public String devuelve_datos(){
        return "El nombre es "+nombre+", seccion "+seccion+" Id="+Id;
    }
    public static String devuelve_IdSiguiente(){
        return "El IdSiguiente es "+IdSiguiente;
    }
}
