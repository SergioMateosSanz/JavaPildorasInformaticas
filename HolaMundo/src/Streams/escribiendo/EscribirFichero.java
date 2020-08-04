package Streams.escribiendo;

import java.io.FileWriter;
import java.io.IOException;

public class EscribirFichero {

    public static void main(String[] args) {

        Escribir esc= new Escribir();
        esc.escritura();
    }

}

class Escribir{

    public void escritura(){

        String texto = "Hola, esto es una segunda prueba de crear un fichero en JAVA";
        try {
            FileWriter archivo = new FileWriter("C:/Users/n128529/Documents/NetBeansProjects/HolaMundo/src/S" +
                    "treams/ejemplo2.txt");

            archivo.write(texto);
            archivo.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Se ha generado un error de este tipo: " + e.getClass().getName());
        }
    }
}
