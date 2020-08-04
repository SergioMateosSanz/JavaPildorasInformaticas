package FicherosDirectorios;

import java.io.File;

public class AccesoFicheros {

    public static void main(String[] args){

        File ruta = new File("C:/Users/n128529/Documents/NetBeansProjects/HolaMundo");

        System.out.println(ruta.getAbsolutePath());

        String[] nombresArchivo = ruta.list();

        for (String e: nombresArchivo){

            File carpeta = new File(ruta.getAbsolutePath(),e);

            if (carpeta.isDirectory()){
                String[] archivosSubcarpeta = carpeta.list();

                for (int j=0;j<archivosSubcarpeta.length;j++){
                    System.out.println(archivosSubcarpeta[j]);
                }
            } else {
                System.out.println(e);
            }
        }
    }
}
