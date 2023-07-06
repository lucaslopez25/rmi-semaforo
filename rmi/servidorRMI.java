package rmi;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.rmi.server.UnicastRemoteObject;

import consumidor.*;
import produtor.*;


public class servidorRMI extends UnicastRemoteObject {
    protected servidorRMI() throws RemoteException {
        super();
        //TODO Auto-generated constructor stub
    }

    public static void main(String[] args) throws RemoteException {
        try {
            BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        
            IProdutor produtor = new Produtor(blockingQueue);
            IConsumidor consumidor1 = new Consumidor(blockingQueue);
            IConsumidor consumidor2 = new Consumidor(blockingQueue);

            LocateRegistry.createRegistry(2311);

            String linkAcessoProdutor = "rmi://localhost/produtor";
            Naming.rebind(linkAcessoProdutor, produtor);

            String linkAcessoConsumidor1 = "rmi://localhost/consumidor1";
            Naming.rebind(linkAcessoConsumidor1, consumidor1);

            String linkAcessoConsumidor2 = "rmi://localhost/consumidor2";
            Naming.rebind(linkAcessoConsumidor2, consumidor2);

            System.out.println("Servidor aguardando contato...");
        }
        catch (Exception e) {
            e.printStackTrace();    
        }
    }
}
