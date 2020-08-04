package FicherosDirectorios;

import java.io.File;

public class ListarDirectoriosRecursividad {

    public static void main(String[] args){

        listarDirectorios(new File("C:/Users/n128529/Documents/NetBeansProjects/HolaMundo"));
    }

    public static void listarDirectorios(File directorio){
        if (!directorio.isDirectory()){
            System.out.println(directorio.getName());
        }
        else {
            String[] dirs=directorio.list();
            for (String dir: dirs){
                File f = new File(directorio.getAbsolutePath(), dir);
                System.out.println(f.getName());
                if (f.isDirectory()){
                    listarDirectorios(f);
                }
            }
        }
    }
}
