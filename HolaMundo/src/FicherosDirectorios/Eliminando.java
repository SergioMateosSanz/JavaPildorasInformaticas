package FicherosDirectorios;

import java.io.File;

public class Eliminando {

    public static void main(String[] args){

        File ruta = new File("C:/Users/n128529/Documents/NetBeansProjects/HolaMundo/nuevoDirectorio/" +
                "prueba.txt");

        ruta.delete();
    }
}
