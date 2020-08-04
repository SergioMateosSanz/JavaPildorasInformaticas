package ProgramacionGenerica;

public class HerenciaGenericos {

    public static void main(String[] args){

        /*Empleado administrativa = new Empleado("Elena", 45, 1500);
        Jefe directoraComercial = new Jefe("Ana", 27,3500);
        Empleado nuevoEmpleado = directoraComercial;*/

        Pareja<Empleado> administrativa = new Pareja<Empleado>();
        Pareja<Jefe> directoraComercial = new Pareja<Jefe>();
        //Pareja<Empleado> nuevoEmpleado = directoraComercial;//en clases genericas no funciona la herencia de igual forma

        Pareja.imprimirTrabajador(administrativa);
        Pareja.imprimirTrabajador(directoraComercial);//con tipo comodin en el método soluciono la herencia de clases genericas
    }
}
