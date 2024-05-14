import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MyClient {
    public static void main (String[] args) throws NotBoundException, RemoteException {
        Registry registry = LocateRegistry.getRegistry();
        AdderService server = (AdderService) registry.lookup("AdderService");
        System.out.println(server.add(2, 3));
    }
}
