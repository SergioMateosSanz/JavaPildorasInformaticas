package Colecciones;


import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class CuentasUsuarios {

    public static void main(String[] args){

        Cliente clienteA = new Cliente("Antonio Banderas", "00001", 200000);
        Cliente clienteB = new Cliente("Rafael Nadal", "00002", 250000);
        Cliente clienteC = new Cliente("Penélope Cruz", "00003", 300000);
        Cliente clienteD = new Cliente("Julio Iglesias", "00004", 5000000);
        Cliente clienteE = new Cliente("Antonio Banderas", "00001", 200000);

        Set<Cliente> clientesBanco = new HashSet<>();

        try {
            clientesBanco.add(clienteA);
            clientesBanco.add(clienteB);
            clientesBanco.add(clienteC);
            clientesBanco.add(clienteD);
            clientesBanco.add(clienteE);//no lo inserta por haber sobreescrito los métodos equals y hashCode
        } catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("Se ha generado un error de este tipo: " + e.getClass().getName());
        }

        Iterator<Cliente> it = clientesBanco.iterator();
        while (it.hasNext()){
            Cliente cliente = it.next();
            System.out.println(cliente.toString());
            if (cliente.getNombre().equals("Julio Iglesias")){
                it.remove();
            }
        }

        for (Cliente cliente: clientesBanco) {
            System.out.println(cliente);
        }

    }
}
