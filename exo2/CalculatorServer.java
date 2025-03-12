import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CalculatorServer {
    public static void main(String[] args) {
        try {
            CalculatorImpl obj = new CalculatorImpl();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("Calculator", obj);
            System.out.println("Calculator Server is ready.");
        } catch (Exception e) {
            System.err.println("Calculator Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}