package trabalhothreads;

import java.util.LinkedList;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Leonardo Simões
 */
public class ThreadConsumidor extends Thread {

    private int id;
    private LinkedList<Integer> fila;
    private final int maxFila;
    private Semaphore semaforo;

    public ThreadConsumidor(int id,  Semaphore semaforo, LinkedList<Integer> fila, int maxFila) {
        this.id = id;
        this.semaforo = semaforo;
        this.fila = fila;
        this.maxFila = maxFila;
    }

    public void run() {
        try {
            semaforo.acquire();
            if (!this.fila.isEmpty()) {
                System.out.println("Thread Consumidor " + this.id +" removeu " + this.fila.removeLast());
            }else{
                System.out.println("Thread Consumidor " + this.id + " tentou remover mas a fila está vazia");
            }
        } catch (InterruptedException e) {
        }finally{
            semaforo.release();
        }
    }

}
