package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class EjecutaConsultas {

    private Conexion miConexion;
    private ResultSet rs;
    private final String consultaSeccion = "SELECT NOMBREARTICULO, SECCION, PRECIO, PAISDEORIGEN FROM PRODUCTOS " +
            "WHERE SECCION=?";
    private final String consultaPais = "SELECT NOMBREARTICULO, SECCION, PRECIO, PAISDEORIGEN FROM PRODUCTOS " +
            "WHERE PAISDEORIGEN=?";
    private final String consultaAmbos = "SELECT OMBREARTICULO, SECCION, PRECIO, PAISDEORIGEN FROM PRODUCTOS " +
            "WHERE SECCION=? AND PAISDEORIGEN=?";
    private PreparedStatement enviaConsulta;


    public EjecutaConsultas(){

        miConexion = new Conexion();
    }

    public ResultSet filtraBBDD(String seccion, String pais){

        try{
            Connection conecta = miConexion.dameConexion();

            rs = null;

            if (!seccion.equals("Todos") && (pais.equals("Todos"))) {
                enviaConsulta = conecta.prepareStatement(consultaSeccion);
                enviaConsulta.setString(1, seccion);
                rs = enviaConsulta.executeQuery();
            } else if (seccion.equals("Todos") && (!pais.equals("Todos"))) {
                enviaConsulta = conecta.prepareStatement(consultaPais);
                enviaConsulta.setString(1,pais);
                rs = enviaConsulta.executeQuery();
            } else if (!seccion.equals("Todos") && (!pais.equals("Todos"))) {
                enviaConsulta = conecta.prepareStatement(consultaAmbos);
                enviaConsulta.setString(1,seccion);
                enviaConsulta.setString(2,pais);
                rs = enviaConsulta.executeQuery();
            }
        } catch (Exception e) {
        e.printStackTrace();
    }
        return rs;
    }
}
