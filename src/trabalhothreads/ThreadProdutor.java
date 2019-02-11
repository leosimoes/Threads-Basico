package trabalhothreads;

import java.util.LinkedList;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Leonardo Simões
 */
public class ThreadProdutor extends Thread {

    private int id;
    private LinkedList<Integer> fila;
    private Semaphore semaforo;
    private final int maxFila;

    public ThreadProdutor(int id, Semaphore semaforo, LinkedList<Integer> fila, int maxFila) {
        this.id = id;
        this.fila = fila;
        this.maxFila = maxFila;
        this.semaforo = semaforo;
    }

    public void run() {
        try {
            semaforo.acquire();
            if (this.fila.size() >= this.maxFila) {
                System.out.println("Thread Produtor " + this.id + " tentou adicionor mas a fila está cheia");
            } else if (this.fila.isEmpty()) {
                this.fila.add(new Integer(1));
            } else {
                this.fila.add(this.fila.getLast() + 1);
            }
            System.out.println("Thread Produtor " + this.id + " adicionou " + this.fila.getLast());
        } catch (InterruptedException e) {
        } finally {
            semaforo.release();
        }
    }
}
