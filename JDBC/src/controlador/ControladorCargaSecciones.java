package controlador;

import modelo.CargaSecciones;
import vista.MarcoAplicacion;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;

public class ControladorCargaSecciones extends WindowAdapter {

    CargaSecciones obj = new CargaSecciones();
    private MarcoAplicacion elMarco;

    public ControladorCargaSecciones(MarcoAplicacion elMarco){

        this.elMarco = elMarco;
    }

    @Override
    public void windowOpened(WindowEvent e) {

        ResultSet rs = null;
        try{
            rs = obj.ejecutaConsultaSecciones();
            while (rs.next()){
                elMarco.secciones.addItem(rs.getString(1));
            }
        } catch (Exception e2){
            e2.printStackTrace();
        }
    }
}
