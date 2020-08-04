package Streams.LeyendoYEscribiendoBytes;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class LecturaEscrituraBytes {

    public static void main(String[] args){

        int contador = 0;

        try{
            FileInputStream archivoLectura = new FileInputStream("C:/Users/n128529/Documents/NetBeansProjects/" +
                    "HolaMundo/src/Streams/imagen.jpg");
            int tamanyo= (int) archivoLectura.getChannel().size();
            System.out.println("Tamaño: " + tamanyo);
            int datosEntrada[] = new int[tamanyo];

            boolean finalImagen = false;
            while (!finalImagen){
                int bytesEntrada = archivoLectura.read();

                if (bytesEntrada == -1){
                    finalImagen = true;
                } else{
                    datosEntrada[contador] = bytesEntrada;
                }
                contador++;
            }

            archivoLectura.close();

            creaFichero(datosEntrada);
        } catch (IOException e){
            System.out.println(e.getMessage());
            System.out.println("Se ha generado un error de este tipo: " + e.getClass().getName());
        }
    }

    static void creaFichero(int datosNuevoFichero[]){

        try {
            FileOutputStream archivoEscritura = new FileOutputStream("C:/Users/n128529/Documents/NetBeansProjects/" +
                    "HolaMundo/src/Streams/imagenCopia.jpg");

            for (int i=0;i<datosNuevoFichero.length;i++){
                archivoEscritura.write(datosNuevoFichero[i]);
            }
            archivoEscritura.close();
        } catch (IOException e){
            System.out.println(e.getMessage());
            System.out.println("Se ha generado un error de este tipo: " + e.getClass().getName());
        }
    }
}
