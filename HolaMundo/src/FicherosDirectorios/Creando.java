package FicherosDirectorios;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Creando {

    public static void main(String[] args){

        //File ruta = new File("C:/Users/n128529/Documents/NetBeansProjects/HolaMundo/nuevoDirectorio");
        //ruta.mkdir();
        File ruta = new File("C:/Users/n128529/Documents/NetBeansProjects/HolaMundo/nuevoDirectorio/" +
                "prueba.txt");
        String archivoDestino = ruta.getAbsolutePath();

        try{
            ruta.createNewFile();
        } catch (IOException e){
            System.out.println(e.getMessage());
            System.out.println("Se ha generado un error de este tipo: " + e.getClass().getName());
        }

        Escribiendo accede = new Escribiendo();
        accede.Escribir(archivoDestino);
    }
}

class Escribiendo{

    public void Escribir(String rutaArchivo){

        String frase = "probando a escribir dentro de un fichero";

        try{
            FileWriter escritura = new FileWriter(rutaArchivo);
            for (int i=0;i<frase.length();i++){
                escritura.write(frase.charAt(i));
            }
            escritura.close();
        } catch (IOException e){
            System.out.println(e.getMessage());
            System.out.println("Se ha generado un error de este tipo: " + e.getClass().getName());
        }
    }
}