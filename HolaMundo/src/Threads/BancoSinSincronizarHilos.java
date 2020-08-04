package Threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BancoSinSincronizarHilos {
    public static void main(String[] args){

        Banco miBanco = new Banco();
        //System.out.printf("Saldo total: %10.2f%n" , miBanco.getSaldoTotal());
        for(int i=0;i<100;i++){
            EjecucionTransferencia r = new EjecucionTransferencia(miBanco, i, 2000);
            Thread t = new Thread(r);
            t.start();
        }
    }
}

class Banco{

    private final double[] CUENTAS;
    //private Lock cierreBanco = new ReentrantLock();
    //private Condition saldoSuficiente;

    public Banco() {

        CUENTAS = new double[100];

        for(int i=0;i<CUENTAS.length;i++){
            CUENTAS[i] = 2000;
        }
        //saldoSuficiente = cierreBanco.newCondition();
    }

    public synchronized void transferencia(int cuentaOrigen, int cuentaDestino, double importe) throws InterruptedException{

        //cierreBanco.lock();
        //try {
            while (CUENTAS[cuentaOrigen] < importe) {
                //System.out.println("-------------- CANTIDAD INSUFICIENTE---------: " + cuentaOrigen);
                //System.out.println("SALDO: " + CUENTAS[cuentaOrigen] + " no podemos transferir " + importe + " euros.");
                //return;

                //saldoSuficiente.await();
                wait();
                System.out.println(Thread.currentThread());
            }
            System.out.println(Thread.currentThread());

            CUENTAS[cuentaOrigen] = CUENTAS[cuentaOrigen] - importe;
            System.out.printf("%10.2f de %d para %d", importe, cuentaOrigen, cuentaDestino);
            CUENTAS[cuentaDestino] = CUENTAS[cuentaDestino] + importe;
            System.out.printf(" Saldo total: %10.2f%n", getSaldoTotal());

            notifyAll();
            //saldoSuficiente.signalAll();
        /*
        } finally {
            cierreBanco.unlock();
        } */
    }

    public double getSaldoTotal(){

        double acumulado = 0;

        for(double a: CUENTAS){
            acumulado = acumulado + a;
        }

        return acumulado;
    }
}

class EjecucionTransferencia implements Runnable{

    private Banco banco;
    private int cuentaOrigen;
    private double importeMaximo;

    @Override
    public void run() {

        try {
            while(true){
                int cuentaDestino = (int) (100*Math.random());
                double cantidad = importeMaximo * Math.random();
                banco.transferencia(cuentaOrigen, cuentaDestino, cantidad);
                Thread.sleep(200);
            }
        } catch (InterruptedException e){
            System.out.println(e.getMessage());
            System.out.println("Se ha generado un error de este tipo: " + e.getClass().getName());
        }
    }

    public EjecucionTransferencia(Banco banco, int cuentaOrigen , double importeMaximo){

        this.banco = banco;
        this.cuentaOrigen = cuentaOrigen;
        this.importeMaximo = importeMaximo;
    }
}
