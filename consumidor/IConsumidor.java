package consumidor;

import java.rmi.Remote;

public interface IConsumidor extends Runnable, Remote{
    public void run();
}
