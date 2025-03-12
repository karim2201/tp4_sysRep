import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class FibonacciClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1098);
            Fibonacci stub = (Fibonacci) registry.lookup("Fibonacci");
            int[] result = stub.calculateFibonacci(20);
            System.out.println("First 20 Fibonacci numbers:");
            for (int i : result) {
                System.out.print(i + " ");
            }
        } catch (Exception e) {
            System.err.println("Fibonacci Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}