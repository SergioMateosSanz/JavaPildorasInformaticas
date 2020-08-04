package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class CargaPaises {

    private Conexion miConexion;
    private ResultSet rs;

    public CargaPaises(){

        miConexion = new Conexion();
    }

    public ResultSet ejecutaConsultaPaises(){

        Connection accesoBBDD = miConexion.dameConexion();

        try{
            Statement secciones = accesoBBDD.createStatement();
            return rs = secciones.executeQuery("SELECT DISTINCTROW PAISDEORIGEN FROM PRODUCTOS");

        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
