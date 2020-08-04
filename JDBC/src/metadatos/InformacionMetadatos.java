package metadatos;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class InformacionMetadatos {

    public static void main(String[] args){

        mostrarInformacionDatabase();
        showInformationTables();
    }

    static void mostrarInformacionDatabase() {

        Connection miConexion = null;
        try {
            miConexion= DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas",
                    "root", "");

            //Obtención de metadatos
            DatabaseMetaData datosBBDD = miConexion.getMetaData();
            System.out.println("Gestor de base de datos: " + datosBBDD.getDatabaseProductName());
            System.out.println("Versión del gestor: " + datosBBDD.getDatabaseProductVersion());
            System.out.println("Driver: " + datosBBDD.getDriverName());
            System.out.println("Versión del driver: " + datosBBDD.getDriverVersion());

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                miConexion.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    static void showInformationTables(){

        Connection miConexion = null;
        try {
            miConexion= DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas",
                    "root", "");
            ResultSet miResultSet = null;

            //Obtención de metadatos
            DatabaseMetaData datosBBDD = miConexion.getMetaData();
            System.out.println("Lista de tablas");
            miResultSet = datosBBDD.getTables(null,null,null,null);

            while (miResultSet.next()){
                System.out.println("Nombre tabla: " + miResultSet.getString("TABLE_NAME"));
                ResultSet miResultSet2 = datosBBDD.getColumns(null,null,null,
                        null);
                while (miResultSet2.next()){
                    System.out.println("Nombre de campo: " + miResultSet2.getString("COLUMN_NAME"));
                }
            }


        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                miConexion.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
