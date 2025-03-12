import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class FibonacciServer {
    public static void main(String[] args) {
        try {
            FibonacciImpl obj = new FibonacciImpl();
            Registry registry = LocateRegistry.createRegistry(1098);
            registry.rebind("Fibonacci", obj);
            System.out.println("Fibonacci Server is ready.");
        } catch (Exception e) {
            System.err.println("Fibonacci Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}