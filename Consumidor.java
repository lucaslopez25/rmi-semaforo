import java.util.concurrent.BlockingQueue;

public class Consumidor implements Runnable{

     BlockingQueue<String> blockingQueue = null;
    public Consumidor(BlockingQueue<String> queue) {
        this.blockingQueue = queue;
    }

    @Override
    public void run() {

        while (true){
            try{
                String elemento = this.blockingQueue.take();
                String texto = Thread.currentThread().getName() + "consumido" + elemento;
                System.out.println(texto);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

    }
}
