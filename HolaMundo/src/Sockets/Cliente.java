package Sockets;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {
    public static void main(String[] args){

        MarcoCliente mimarco=new MarcoCliente();
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MarcoCliente extends JFrame{

    public MarcoCliente(){

        setBounds(600,300,280,350);
        LaminaMarcoCliente milamina=new LaminaMarcoCliente();
        add(milamina);
        setVisible(true);
        addWindowListener(new EnvioOnline());
    }

}

class LaminaMarcoCliente extends JPanel implements Runnable{

    private JTextField campo1, ip;
    private JLabel nick;
    private JButton miboton;
    private JTextArea campoChat;

    public LaminaMarcoCliente(){

        String nickUsuario = JOptionPane.showInputDialog("Nick: ");
        JLabel nNick = new JLabel("Nick: ");
        add(nNick);
        nick = new JLabel(nickUsuario);
        add(nick);
        JLabel texto = new JLabel("-CHAT-");
        add(texto);
        ip = new JTextField(8);
        add(ip);

        campoChat = new JTextArea(12,20);
        add(campoChat);

        campo1 = new JTextField(20);
        add(campo1);

        miboton = new JButton("Enviar");
        EnviaTexto miEvento = new EnviaTexto();
        miboton.addActionListener(miEvento);
        add(miboton);

        Thread miHilo = new Thread(this);
        miHilo.start();
    }

    private class EnviaTexto implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            //System.out.println(campo1.getText());
            //campoChat.append(campo1.getText() + "\n");
            try {
                Socket miSocket = new Socket("180.112.20.180",9999);
                PaqueteEnvio datos = new PaqueteEnvio();
                datos.setNick(nick.getText());
                datos.setIp(ip.getText());
                datos.setMensaje(campo1.getText());

                ObjectOutputStream paqueteDatosEnvio = new ObjectOutputStream(miSocket.getOutputStream());
                paqueteDatosEnvio.writeObject(datos);
                miSocket.close();

                /*DataOutputStream flujoSalida = new DataOutputStream(miSocket.getOutputStream());
                flujoSalida.writeUTF(campo1.getText());
                flujoSalida.close();//cerramos la conexión */
            } catch (IOException e1){
                System.out.println(e1.getMessage());
                System.out.println("Se ha generado un error de este tipo: " + e1.getClass().getName());
            }
        }
    }

    @Override
    public void run() {
        try {
            ServerSocket servidorCliente = new ServerSocket(9090);//se pone a la escucha
            Socket socketCliente;
            PaqueteEnvio paqueteRecibido;
            while (true) {//bucle para que este continuamente aceptando conexiones
                socketCliente = servidorCliente.accept();
                ObjectInputStream flujoEntrada = new ObjectInputStream(socketCliente.getInputStream());
                paqueteRecibido = (PaqueteEnvio) flujoEntrada.readObject();
                campoChat.append(paqueteRecibido.getNick() + ": " + paqueteRecibido.getMensaje() + "\n");
                socketCliente.close();
            }
        } catch (IOException | ClassNotFoundException e){
            System.out.println(e.getMessage());
            System.out.println("Se ha generado un error de este tipo: " + e.getClass().getName());
        }
    }
}

class PaqueteEnvio implements Serializable {

    private String nick, ip, mensaje;

    public PaqueteEnvio() {
        super();
    }

    public PaqueteEnvio(String nick, String ip, String mensaje) {
        this.nick = nick;
        this.ip = ip;
        this.mensaje = mensaje;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}

// ----- envío de señal online al servidor para decirle que estamos conectados ------
class EnvioOnline extends WindowAdapter{

    @Override
    public void windowOpened(WindowEvent e) {
        try{
            Socket miSocket = new Socket("180.112.20.180", 9999);
            PaqueteEnvio datos = new PaqueteEnvio();
            datos.setMensaje("online");
            ObjectOutputStream paqueteDatos = new ObjectOutputStream(miSocket.getOutputStream());
            paqueteDatos.writeObject(datos);
            miSocket.close();
        } catch (Exception e1){
            System.out.println(e1.getMessage());
            System.out.println("Se ha generado un error de este tipo: " + e1.getClass().getName());
        }
    }
}