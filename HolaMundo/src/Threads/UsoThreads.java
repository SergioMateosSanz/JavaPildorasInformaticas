package Threads;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

/*
Pasos para crear hilos de ejecución:
1. Crear clase que implemente la interfaz Runnable (método run)
2. Escribir el código de la tarea dentro del método run
3. Instanciar la clase creada y almacenar la instancia en variable de tipo Runnable
4. Crear instancia de la clase Thread pasando como parámetro al constructor de Thread el objeto Runnable anterior
5. Poner en marcha el hilo de ejecución con el método start() de la clase Thread
 */

public class UsoThreads {

    public static void main(String[] args){

        JFrame marco = new MarcoRebote();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setVisible(true);
    }
}

class PelotaHilos implements Runnable{

    private Pelota pelota;
    private Component componente;

    public PelotaHilos(Pelota unaPelota, Component unComponente){

        pelota = unaPelota;
        componente = unComponente;
    }

    @Override
    public void run() {

        System.out.println("Estado del hilo al comenzar: " + Thread.currentThread().isInterrupted());
        //for (int i=1; i<=3000; i++){
        //while (!Thread.interrupted()){
        while (!Thread.currentThread().isInterrupted()){
            pelota.mueve_pelota(componente.getBounds());
            //componente.paint(componente.getGraphics());
            componente.repaint();
            try {
                Thread.sleep(2);
            } catch (InterruptedException e){
                System.out.println(e.getMessage());
                System.out.println("Se ha generado un error de este tipo: " + e.getClass().getName());
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Estado del hilo al finalizar: " + Thread.currentThread().isInterrupted());
    }
}

class Pelota{

    private static final int TAMX=15;
    private static final int TAMY=15;
    private double x=0;
    private double y=0;
    private double dx=1;
    private double dy=1;

    // Mueve la pelota invirtiendo posición si choca con límites
    public void mueve_pelota(Rectangle2D limites){

        x+=dx;
        y+=dy;

        if(x<limites.getMinX()){
            x=limites.getMinX();
            dx=-dx;
        }

        if(x + TAMX>=limites.getMaxX()){
            x=limites.getMaxX() - TAMX;
            dx=-dx;
        }

        if(y<limites.getMinY()){
            y=limites.getMinY();
            dy=-dy;
        }

        if(y + TAMY>=limites.getMaxY()){
            y=limites.getMaxY()-TAMY;
            dy=-dy;
        }
    }

    //Forma de la pelota en su posición inicial
    public Ellipse2D getShape(){

        return new Ellipse2D.Double(x,y,TAMX,TAMY);
    }
}

// Lámina que dibuja las pelotas----------------------------------------------------------------------
class LaminaPelota extends JPanel{

    private ArrayList<Pelota> pelotas=new ArrayList<Pelota>();

    //Añadimos pelota a la lámina
    public void add(Pelota b){
        pelotas.add(b);
    }

    public void paintComponent(Graphics g){

        super.paintComponent(g);
        revalidate();
        Graphics2D g2=(Graphics2D)g;
        for(Pelota b: pelotas){
            g2.fill(b.getShape());
        }
    }

}


//Marco con lámina y botones------------------------------------------------------------------------------
class MarcoRebote extends JFrame{

    private LaminaPelota lamina;
    private Thread hiloA, hiloB, hiloC;
    private JButton arrancaA, arrancaB, arrancaC, detenerA, detenerB, detenerC;

    public MarcoRebote(){

        setBounds(600,300,600,350);
        setTitle ("Rebotes");
        lamina = new LaminaPelota();
        add(lamina, BorderLayout.CENTER);
        JPanel laminaBotones = new JPanel();

        arrancaA = new JButton("Hilo 1");
        arrancaA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comienza_el_juego(e);
            }
        });
        arrancaB = new JButton("Hilo 2");
        arrancaB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comienza_el_juego(e);
            }
        });
        arrancaC = new JButton("Hilo 3");
        arrancaC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comienza_el_juego(e);
            }
        });
        detenerA = new JButton("Parar 1");
        detenerA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                detener(e);
            }
        });
        detenerB = new JButton("Parar 2");
        detenerB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                detener(e);
            }
        });
        detenerC = new JButton("Parar 3");
        detenerC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                detener(e);
            }
        });
        laminaBotones.add(arrancaA);
        laminaBotones.add(arrancaB);
        laminaBotones.add(arrancaC);
        laminaBotones.add(detenerA);
        laminaBotones.add(detenerB);
        laminaBotones.add(detenerC);

        add(laminaBotones, BorderLayout.SOUTH);
    }


    //Añade pelota y la bota 1000 veces
    public void comienza_el_juego (ActionEvent e){

        Pelota pelota = new Pelota();
        lamina.add(pelota);

        Runnable r = new PelotaHilos(pelota,lamina);
        if (e.getSource().equals(arrancaA)){
            hiloA = new Thread(r);
            hiloA.start();
        } else if (e.getSource().equals(arrancaB)){
            hiloB = new Thread(r);
            hiloB.start();
        } else if (e.getSource().equals(arrancaC)) {
            hiloC = new Thread(r);
            hiloC.start();
        }

        /*try {
            e.start();
        } catch (IllegalThreadStateException e){
            System.out.println(e.getMessage());
            System.out.println("Se ha generado un error de este tipo: " + e.getClass().getName());
        }*/
    }

    public void detener(ActionEvent e){
        if (e.getSource().equals(detenerA)){
            hiloA.interrupt();
        }else if (e.getSource().equals(detenerB)){
            hiloB.interrupt();
        } else if (e.getSource().equals(detenerC)){
            hiloC.interrupt();
        }
    }

}
