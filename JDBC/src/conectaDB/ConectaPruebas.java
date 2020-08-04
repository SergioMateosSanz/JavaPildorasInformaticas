package conectaDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConectaPruebas {
    public static void main(String[] args){

        // 1. Crear la conexión a la bbdd, capturando la excepción
        try{
            Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/nombreDataBase",
                    "root", "");
            // 2. Crear el objeto statement
            Statement miStatement = miConexion.createStatement();
            // 3. Ejecutar la instrucción sql
            //executeUpdate para INSERT, UPDATE y DELETE
            ResultSet miResultSet = miStatement.executeQuery("SELECT * FROM PRODUCTO");
            // 4. Leer el ResultSet
            while(miResultSet.next()){
                System.out.println("Aquí imprimiríamos los campos recuperados, por ejemplo");
                System.out.println(miResultSet.getString("NOMBREPRODUCTO"));
            }
            miResultSet.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
