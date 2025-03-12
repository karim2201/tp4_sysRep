import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class TriangleClient {
    
    public static void main(String[] args) {
        try {
           
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            
           
            TriangleInterface stub = (TriangleInterface) registry.lookup("TriangleService");
            
           
            int rows = 5;
            
            System.out.println("Increasing Triangle (Figure a):");
            System.out.println(stub.displayIncreasingTriangle(rows));
            
            System.out.println("Decreasing Triangle (Figure b):");
            System.out.println(stub.displayDecreasingTriangle(rows));
            
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}