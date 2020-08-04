package poo;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Arrays;
//en el mismo archivo definimos la clase y su uso (pero se recomienda hacerlo como en
//el ejemplo del coche. Una clase para definir y otra para su utilización
public class Uso_empleado {
    public static void main(String args []) {
        
        Jefatura jefe_RRHH=new Jefatura("Jefazo",45000,1990,12,17);
        jefe_RRHH.set_Incentivo(3400);
        
        Empleado[] misEmpleados=new Empleado[6];
        misEmpleados[0]=new Empleado("Alberto Martín",25000,1990,12,17);
        misEmpleados[1]=new Empleado("Ana Álvarez",27000,1995,06,02);
        misEmpleados[2]=new Empleado("María García",30000,2002,03,15);
        misEmpleados[3]=new Empleado("Juan Sanz");
        misEmpleados[4]=jefe_RRHH;//polimorfismo. Principio de sustitución
        misEmpleados[5]=new Jefatura("María",95000,1999,05,26);
        
        Jefatura jefa_Finanzas=(Jefatura)misEmpleados[5];//Casting de objetos
        jefa_Finanzas.set_Incentivo(55000);
        System.out.println(jefa_Finanzas.tomar_decisiones("Subir el sueldo un 5%"));  
        jefa_Finanzas.establece_bonus(500);
//método para ordenar objetos, pero hemos de implementar la interface Comparable en la clase
        Arrays.sort(misEmpleados);
        
        for (int i=0; i<misEmpleados.length; i++){
            System.out.print("Nombre: "+misEmpleados[i].get_nombre());
            System.out.print(".Fecha de alta: "+misEmpleados[i].get_fecha_contrato());
            System.out.println(".Sueldo: "+misEmpleados[i].get_sueldo());
        }
       
              
        /*
        Empleado empleado1=new Empleado("Alberto Martín",25000,1990,12,17);
        Empleado empleado2=new Empleado("Ana Álvarez",27000,1995,06,02);
        Empleado empleado3=new Empleado("María García",30000,2002,03,15);
        
        empleado1.subeSueldo(5);
        empleado2.subeSueldo(5);
        empleado3.subeSueldo(5);
        
        System.out.println("Nombre: "+empleado1.get_nombre());
        System.out.println("Fecha de alta: "+empleado1.get_fecha_contrato());
        System.out.println("Sueldo: "+empleado1.get_sueldo());
        
        System.out.println("Nombre: "+empleado2.get_nombre());
        System.out.println("Fecha de alta: "+empleado2.get_fecha_contrato());
        System.out.println("Sueldo: "+empleado2.get_sueldo());
        
        System.out.println("Nombre: "+empleado3.get_nombre());
        System.out.println("Fecha de alta: "+empleado3.get_fecha_contrato());
        System.out.println("Sueldo: "+empleado3.get_sueldo());
        */
    }
}

class Empleado implements Comparable,Trabajadores{
    
    public Empleado(String nom, double sue, int anyo, int mes, int dia){
        nombre=nom;
        sueldo=sue;
        GregorianCalendar calendario=new GregorianCalendar(anyo,mes-1,dia);
        altaContrato=calendario.getTime();
        ++IdSiguiente;
        Id=IdSiguiente;
    }
    public Empleado(String nom){//sobrecarga de constructores
        this( nom, 20000, 2000, 01, 01);
    }
    
    public final String get_nombre(){//para que ningún método de clase que herede de 
                                     //Empleado pueda llamarse igual
        return nombre + " Id: "+Id;
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
    
    public int compareTo(Object miObjeto){
        Empleado otroEmpleado=(Empleado) miObjeto;
        if (this.sueldo<otroEmpleado.sueldo){
            return -1;
        }
        if (this.sueldo>otroEmpleado.sueldo){
            return 1;
        }else{
            return 0;
        }
    }
    public double establece_bonus(double gratificacion){
        return Trabajadores.bonus_base+gratificacion;
    }
    
    private String nombre;
    private double sueldo;
    private Date altaContrato;
    private static int IdSiguiente;
    private int Id;
}

final class Jefatura extends Empleado implements Jefes{//con el final se termina la herencia
    
    private double Incentivo;
            
    public Jefatura(String nom, double sue, int anyo, int mes, int dia){
        super(nom,sue,anyo,mes,dia);
        Incentivo=0;
    }
    public void set_Incentivo(double Incentivo){
        this.Incentivo=Incentivo;
    }
    public double get_sueldo(){
        double sueldoJefe=super.get_sueldo();
        return sueldoJefe+Incentivo;
    }
    //implementar método de la interfaz
    public String tomar_decisiones(String decision){
        return "Un miembro de la dirección ha tomado la decisión de: "+decision;
    }
    public double establece_bonus(double gratificacion){
        double prima=2000;
        return Trabajadores.bonus_base+gratificacion+prima;
    }
} 


