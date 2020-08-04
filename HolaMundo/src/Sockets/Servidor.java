package Sockets;

import javax.swing.*;
import java.awt.*;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Servidor {

    public static void main(String[] args) {

        MarcoServidor mimarco=new MarcoServidor();
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}

class MarcoServidor extends JFrame implements Runnable {

    private	JTextArea areatexto;

    public MarcoServidor(){

        setBounds(1200,300,280,350);
        JPanel milamina = new JPanel();
        milamina.setLayout(new BorderLayout());
        areatexto = new JTextArea();
        milamina.add(areatexto,BorderLayout.CENTER);
        add(milamina);
        setVisible(true);
        Thread hiloA = new Thread(this);
        hiloA.start();
    }

    @Override
    public void run() {
        //System.out.println("Estoy a la escucha");
        try {
            ServerSocket miServidor = new ServerSocket(9999);//se pone a la escucha
            String nick, ip, mensaje;
            PaqueteEnvio paqueteRecibido;
            while (true) {//bucle para que este continuamente aceptamos conexiones
                Socket miSocket = miServidor.accept();//para que acepte las conexiones del exterior

                // ------- para detectar las conexiones entrantes -------
                InetAddress localizacion = miSocket.getInetAddress();
                System.out.println( "Online " + localizacion.getHostAddress());
                // ---------------------
                ObjectInputStream paqueteDatos = new ObjectInputStream(miSocket.getInputStream());
                paqueteRecibido = (PaqueteEnvio) paqueteDatos.readObject();
                nick = paqueteRecibido.getNick();
                ip = paqueteRecibido.getIp();
                mensaje = paqueteRecibido.getMensaje();
                areatexto.append(nick + ": " + mensaje + " para " + ip + "\n");

                Socket enviaDestinatario = new Socket(ip,9090);
                ObjectOutputStream paqueteReenvio = new ObjectOutputStream(enviaDestinatario.getOutputStream());
                paqueteReenvio.writeObject(paqueteRecibido);
                //paqueteReenvio.close();
                enviaDestinatario.close();

                /*DataInputStream flujoEntrada = new DataInputStream(miSocket.getInputStream());
                String mensajeTexto = flujoEntrada.readUTF();
                areatexto.append(mensajeTexto + "\n"); */
                miSocket.close();//cerramos la conexión
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("Se ha generado un error de este tipo: " + e.getClass().getName());
        }
    }
}

