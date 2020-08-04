package controlador;

import modelo.CargaPaises;
import vista.MarcoAplicacion;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;

public class ControladorCargaPaises extends WindowAdapter {

    CargaPaises obj = new CargaPaises();
    private MarcoAplicacion elMarco;

    public ControladorCargaPaises(MarcoAplicacion elMarco){
        this.elMarco = elMarco;
    }

    @Override
    public void windowOpened(WindowEvent e) {

        ResultSet rs = null;
        try{
            rs = obj.ejecutaConsultaPaises();
            while (rs.next()){
                elMarco.secciones.addItem(rs.getString(1));
            }
        } catch (Exception e2){
            e2.printStackTrace();
        }
    }
}
