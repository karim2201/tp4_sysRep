import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CallbackClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            Callback stub = (Callback) registry.lookup("Callback");

            System.out.println("Démarrage de l’appel");
            stub.doCallback("Bonjour");
            Thread.sleep(5000);
            stub.doCallback("J’utilise Java RMI");
            Thread.sleep(5000);
            stub.doCallback("Fin");
        } catch (Exception e) {
            System.err.println("Callback Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}