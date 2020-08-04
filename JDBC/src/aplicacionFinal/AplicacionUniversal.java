package aplicacionFinal;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;


public class AplicacionUniversal {

    public static void main(String[] args) {

        MarcoBBDD miMarco = new MarcoBBDD();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        miMarco.setVisible(true);
    }

}

class MarcoBBDD extends JFrame{

    public MarcoBBDD(){

        setBounds(300,300,700,700);
        LaminaBBDD milamina = new LaminaBBDD();
        add(milamina);
    }

}

class LaminaBBDD extends JPanel{

    private JComboBox comboTablas;
    private JTextArea areaInformacion;
    private Connection miConexion;
    private FileReader entrada;

    public LaminaBBDD(){

        setLayout(new BorderLayout());
        comboTablas = new JComboBox();
        areaInformacion = new JTextArea();
        add(areaInformacion,BorderLayout.CENTER);

        conectarBBDD();
        obtenerTablas();

        comboTablas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String nombreTabla = ((String)comboTablas.getSelectedItem());
                mostrarInfoTabla(nombreTabla);
            }
        });
        add(comboTablas, BorderLayout.NORTH);

    }

    public void conectarBBDD(){

        miConexion = null;

        String datos[] = new String[3];

        try {
            // en un fichero de configuración en 3 líneas, el driver de BBDD, el usuario y la password
            entrada = new FileReader("C:/Users/Juan/Desktop/datos_config.txt");

        } catch (IOException e) {
            //JOptionPane.showMessageDialog(this,"No se ha encontrado el archivo de conexión" );
            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("archivo de texto",
                    "txt");
            chooser.setFileFilter(filter);
            int returnVal = chooser.showOpenDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                try {
                    entrada = new FileReader(chooser.getSelectedFile().getAbsolutePath());
                } catch (FileNotFoundException e1){
                    e1.printStackTrace();
            }
        }

            try {
                BufferedReader miBuffer = new BufferedReader(entrada);
                for (int i = 0; i <= 2; i++) {
                    datos[i] = miBuffer.readLine();
                }
                miConexion = DriverManager.getConnection(datos[0], datos[1], datos[2]);
                entrada.close();
            } catch (Exception e2){
                e2.printStackTrace();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void obtenerTablas(){

        ResultSet miResultSet = null;

        try {
            DatabaseMetaData datosBBDD = miConexion.getMetaData();

            miResultSet = datosBBDD.getTables(null,null,null,null);

            while(miResultSet.next()){
                comboTablas.addItem(miResultSet.getString("TABLE_NAME"));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void mostrarInfoTabla(String tabla){

        ArrayList<String> campos = new ArrayList<String>();
        String consulta = "SELET * FROM " + tabla;

        try {
            areaInformacion.setText("");
            Statement miStatement = miConexion.createStatement();
            ResultSet miResultSet = miStatement.executeQuery(consulta);
            ResultSetMetaData rsBBDD = miResultSet.getMetaData();

            for (int i=1;i<rsBBDD.getColumnCount();i++){
                campos.add(rsBBDD.getColumnLabel(i));
            }

            while (miResultSet.next()){
                for (String nombreCampo:campos){
                    areaInformacion.append(miResultSet.getString(nombreCampo) + " ");
                }
                areaInformacion.append("\n");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
