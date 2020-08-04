package controlador;

import modelo.EjecutaConsultas;
import vista.MarcoAplicacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ControladorBotonEjecuta implements ActionListener {

    private MarcoAplicacion elMarco;
    private EjecutaConsultas obj = new EjecutaConsultas();
    private ResultSet resultadoConsulta;

    public ControladorBotonEjecuta(MarcoAplicacion elMarco){

        this.elMarco = elMarco;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String seleccionSeccion = (String) elMarco.secciones.getSelectedItem();
        String seleccionPais = (String) elMarco.paises.getSelectedItem();

        resultadoConsulta = obj.filtraBBDD(seleccionSeccion,seleccionPais);
        elMarco.resultado.setText("");

        try {
            while (resultadoConsulta.next()){
                elMarco.resultado.append(resultadoConsulta.getString(1));
                elMarco.resultado.append(resultadoConsulta.getString(2));
                elMarco.resultado.append(resultadoConsulta.getString(3));
                elMarco.resultado.append(resultadoConsulta.getString(4));
                elMarco.resultado.append("\n");
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}
