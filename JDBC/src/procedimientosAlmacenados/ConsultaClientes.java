package procedimientosAlmacenados;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class ConsultaClientes {

    public static void main(String[] args){

        try{
            Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/nombreDataBase",
                    "root", "");

            CallableStatement miSentencia = miConexion.prepareCall("{call PROCEDIMIENTO(?,?)}");
            miSentencia.setInt(1, 134);
            miSentencia.setString(2, "segundo parametro");

            ResultSet rs = miSentencia.executeQuery();

            while (rs.next()){
                System.out.println(rs.getString(1) + " " + rs.getString(2) + " " +
                        rs.getString(3));
            }
            rs.close();

        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
