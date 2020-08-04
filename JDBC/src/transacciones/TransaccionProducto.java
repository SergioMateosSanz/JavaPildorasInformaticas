package transacciones;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TransaccionProducto {

    public static void main(String[] args) {

        Connection miConexion = null;

        try{
            miConexion= DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas",
                    "root", "");

            miConexion.setAutoCommit(false);

            Statement miStatement =miConexion.createStatement();

            String instruccionSql_1="DELETE FROM PRODUCTOS WHERE PAISDEORIGEN='ITALIA'";
            String instruccionSql_2="DELETE FROM PRODUCTOS WHERE PRECIO>300";
            String instruccionSql_3="UPDATE PRODUCTOS SET PRECIO=PRECIO*1.15";

            boolean ejecutar = ejecutarTransaccion();
            if (ejecutar){
                miStatement.executeUpdate(instruccionSql_1);
                miStatement.executeUpdate(instruccionSql_2);
                miStatement.executeUpdate(instruccionSql_3);

                miConexion.commit();
            }

            miConexion.close();

        }catch(Exception e){
            try{
                miConexion.rollback();
            } catch (SQLException e1){
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
    }

    static boolean ejecutarTransaccion() {

        String confirmacion = JOptionPane.showInputDialog("¿Quiere actualizar la base de datos? (S/N)");

        if (confirmacion.equals("S")){
            return true;
        } else {
            return false;
        }

    }
}


