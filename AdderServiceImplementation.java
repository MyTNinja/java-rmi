import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class AdderServiceImplementation implements AdderService{
    public int add(int num1, int num2) {
        return num1+num2;
    }

    public static void main(String[] args) throws RemoteException {
        AdderService server = new AdderServiceImplementation();

        AdderService stub = (AdderService) UnicastRemoteObject.exportObject((AdderService) server, 0);

        Registry registry = LocateRegistry.createRegistry(1099);
        registry.rebind("AdderService", stub);
    }
}

