package conectaDB;

import java.sql.*;

public class ConsultasPreparadas {
    public static void main(String[] args){

        try{
            //1. crear conexión
            Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/nombreDataBase",
                    "root", "");
            //2. preparar consulta
            PreparedStatement miSentencia = miConexion.prepareStatement("SELECT * FROM PRODUCTO WHERE " +
                    "SECCION=? AND PAISDEORIGEN=?");
            //3. establecer los parámetros de la consulta
            miSentencia.setString(1,"DEPORTES");
            miSentencia.setString(2,"SPAIN");
            //4. ejecutar y recorrer la consulta

            ResultSet miResultSet = miSentencia.executeQuery();

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