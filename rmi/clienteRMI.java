package rmi;

import java.rmi.Naming;
import consumidor.IConsumidor;
import produtor.IProdutor;

public class clienteRMI {
    public static void main(String[] args) throws Exception{
        String linkAcessoProdutor = "rmi://localhost:2311/produtor";
        String linkAcessoConsumidor1 = "rmi://localhost:2311/consumidor1";
        String linkAcessoConsumidor2 = "rmi://localhost:2311/consumidor2";

        IProdutor produtor = (IProdutor) Naming.lookup(linkAcessoProdutor);
        IConsumidor consumidor1 = (IConsumidor) Naming.lookup(linkAcessoConsumidor1);
        IConsumidor consumidor2 = (IConsumidor) Naming.lookup(linkAcessoConsumidor2);
        
        Thread ProdutorThread = new Thread(produtor);
        Thread ConsumidorThread1 = new Thread(consumidor1);
        Thread ConsumidorThread2 = new Thread(consumidor2);

        ProdutorThread.start();
        ConsumidorThread1.start();
        ConsumidorThread2.start();
    }
}
