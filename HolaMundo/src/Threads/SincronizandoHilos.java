package Threads;

public class SincronizandoHilos {
    public static void main(String[] args){

        HilosVarios hiloA = new HilosVarios();
        HilosVariosEspera hiloB = new HilosVariosEspera(hiloA);

        //hiloA.start();
        /*
        try {
            hiloA.join();
        } catch (InterruptedException e){
            System.out.println(e.getMessage());
            System.out.println("Se ha generado un error de este tipo: " + e.getClass().getName());
        }
        */
        hiloB.start();
        hiloA.start();
    }
}

class HilosVarios extends Thread{

    @Override
    public void run() {

        for(int i=0;i<15;i++){
            System.out.println("Ejecutando el hilo " + getName());
            try {
                Thread.sleep(400);
            } catch (InterruptedException e){
                System.out.println(e.getMessage());
                System.out.println("Se ha generado un error de este tipo: " + e.getClass().getName());
            }
        }
    }
}

class HilosVariosEspera extends Thread{

    private Thread hilo;

    public HilosVariosEspera(Thread hilo){
        this.hilo = hilo;
    }

    @Override
    public void run() {

        try{
            hilo.join();
        } catch (InterruptedException e){
            System.out.println(e.getMessage());
            System.out.println("Se ha generado un error de este tipo: " + e.getClass().getName());
        }

        for(int i=0;i<15;i++){
            System.out.println("Ejecutando el hilo " + getName());
            try {
                Thread.sleep(400);
            } catch (InterruptedException e){
                System.out.println(e.getMessage());
                System.out.println("Se ha generado un error de este tipo: " + e.getClass().getName());
            }
        }
    }
}
