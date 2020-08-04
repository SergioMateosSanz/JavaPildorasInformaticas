package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class CargaSecciones {

    private Conexion miConexion;
    private ResultSet rs;

    public CargaSecciones(){

        miConexion = new Conexion();
    }

    public ResultSet ejecutaConsultaSecciones(){

        Connection accesoBBDD = miConexion.dameConexion();

        try{
            Statement secciones = accesoBBDD.createStatement();
            return rs = secciones.executeQuery("SELECT DISTINCTROW SECCION FROM PRODUCTOS");

        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
