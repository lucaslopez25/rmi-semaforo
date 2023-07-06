import java.util.concurrent.BlockingQueue;

import static java.lang.Thread.sleep;

public class Produtor implements Runnable{

    BlockingQueue<String> blockingQueue = null;


    public Produtor(BlockingQueue<String> queue) {
        this.blockingQueue = queue;
    }

    @Override
    public void run() {
        while (true){
              long tempoEmMilissegundo = System.currentTimeMillis();
              try {
                  this.blockingQueue.put("" + tempoEmMilissegundo);
              }catch (InterruptedException e){
                  System.out.println("Produtor foi interrompido");
              }
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
