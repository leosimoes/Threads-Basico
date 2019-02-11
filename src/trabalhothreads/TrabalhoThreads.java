package trabalhothreads;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Leonardo Simões
 */
public class TrabalhoThreads {

    
    public static void Corrida(){
        //LinkedList<Integer> fila = new LinkedList<Integer>();
        int numeroDeParesDeProcessos = 10;
        Thread[] processos = new Thread[numeroDeParesDeProcessos];
        for (int i = 0; i < numeroDeParesDeProcessos; i++) {
            processos[i] = new ThreadCorredora(i + 1);
            processos[i].start();
        }
    }
    
    
    public static void ProdutorConsumidor() {
        LinkedList<Integer> fila = new LinkedList<Integer>();
        int maxFila = 4;
        Semaphore semaforo = new Semaphore(1);
        int numeroDeParesDeProcessos = 15;
        Thread[] processos = new Thread[numeroDeParesDeProcessos];
        for (int i = 0; i < numeroDeParesDeProcessos; ++i) {
            processos[i] = new ThreadProdutor(i + 1, semaforo, fila, maxFila);
            processos[i].start();
            processos[i] = new ThreadConsumidor(i + 1, semaforo, fila, maxFila);
            processos[i].start();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int opcao = 0;
        Scanner entrada = new Scanner(System.in);
        do{
            System.out.println("------------------Trabalho de Thread------------------");
            System.out.println(" \nEscolha um dos problemas:");
            System.out.println("1 para Corrida \n2 para Produtor e Consumidor");
            //Entrada do valor da opcao
            try{
            opcao = entrada.nextInt();
            }catch(Exception e){
                System.out.println("");
            }
            //Execucao da opercao selecionada
            if(opcao==1){
                Corrida();
            }else if(opcao==2){
                ProdutorConsumidor();
            }
        }while(opcao!=1 && opcao!=2);

    }

}
