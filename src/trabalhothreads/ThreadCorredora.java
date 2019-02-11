package trabalhothreads;

import java.util.LinkedList;

/**
 *
 * @author Leonardo Simões
 */
public class ThreadCorredora extends Thread{
    private int id;

    public ThreadCorredora(int id) {
        this.id = id;

    }
    
        
    public void run() {
        for(int i=0; i<5000; ++i){
            //Corrida
        }
        System.out.println("Thread " + this.id + " terminou a corrida");
    }
}
