package Streams.leyendo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class AccesoFichero {

    public static void main (String[] args){

        LeerFichero miFichero = new LeerFichero();
        miFichero.lee();
    }
}

class LeerFichero{

    public void lee(){

        try {
            FileReader entrada = new FileReader("C:/Users/n128529/Documents/NetBeansProjects/HolaMundo/src/S" +
                "treams/ejemplo.txt");
            BufferedReader miBuffer = new BufferedReader(entrada);
            String linea = "";
            while (linea != null){
                linea = miBuffer.readLine();
                if (linea != null){
                    System.out.println(linea);
                }
            }
                /*int caracter = entrada.read();
                char letra = (char) caracter;
                while (caracter != -1){
                    System.out.print(letra);
                    caracter = entrada.read();
                    letra = (char) caracter;
                    }*/
            entrada.close();
        } catch (IOException e){
                System.out.println("No se ha encontrado el archivo");
                System.out.println(e.getMessage());
                System.out.println("Se ha generado un error de este tipo: " + e.getClass().getName());
        }
    }
}
