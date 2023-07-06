import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import produtor.Produtor;
import consumidor.Consumidor;

public class Main {
    public static void main(String[] args) {

        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        Produtor produtor = new Produtor(blockingQueue);
        Consumidor consumidor1 = new Consumidor(blockingQueue);
        Consumidor consumidor2 = new Consumidor(blockingQueue);

        Thread ProdutorThread = new Thread(produtor);
        Thread ConsumidorThred1 = new Thread(consumidor1);
        Thread ConsumidorThred2 = new Thread(consumidor2);

        ProdutorThread.start();
        ConsumidorThred1.start();
        ConsumidorThred2.start();



    }
}