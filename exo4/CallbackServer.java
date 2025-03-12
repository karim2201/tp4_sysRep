import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class CallbackServer {
    public static void main(String[] args) {
        try {
            CallbackImpl obj = new CallbackImpl();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("Callback", obj);
            System.out.println("Callback Server is ready.");
        } catch (Exception e) {
            System.err.println("Callback Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}