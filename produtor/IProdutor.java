package produtor;

import java.rmi.Remote;

public interface IProdutor extends Runnable, Remote{
    public void run();
}
