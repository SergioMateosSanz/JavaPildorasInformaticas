package ProgramacionGenerica;

public class Pareja<T> {

    private T primero;

    public Pareja(){

        primero = null;
    }

    public void setPrimero(T primero) {
        this.primero = primero;
    }

    public T getPrimero() {
        return primero;
    }

    @Override
    public String toString() {
        return "Pareja{" +
                "primero=" + primero +
                '}';
    }

    public static void imprimirTrabajador(Pareja<? extends Empleado> p){//tipo comodin para herencia clases genericas

        Empleado primero = p.getPrimero();
        System.out.println(primero);
    }
}
