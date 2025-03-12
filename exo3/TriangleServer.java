import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class TriangleServer implements TriangleInterface {
    
    public TriangleServer() {}
    
    @Override
    public String displayIncreasingTriangle(int rows) throws RemoteException {
        StringBuilder triangle = new StringBuilder();
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                triangle.append("* ");
            }
            triangle.append("\n");
        }
        return triangle.toString();
    }
    
    @Override
    public String displayDecreasingTriangle(int rows) throws RemoteException {
        StringBuilder triangle = new StringBuilder();
        for (int i = rows; i >= 1; i--) {
            for (int j = 1; j <= 2*i - 1; j++) {
                triangle.append("*");
            }
            triangle.append("\n");
        }
        return triangle.toString();
    }
    
    public static void main(String[] args) {
        try {
            TriangleServer server = new TriangleServer();
            TriangleInterface stub = (TriangleInterface) UnicastRemoteObject.exportObject(server, 0);
            
            Registry registry = LocateRegistry.createRegistry(1099);
            
            registry.bind("TriangleService", stub);
            
            System.out.println("TriangleServer ready");
        } catch (java.rmi.AlreadyBoundException e) {
            System.err.println("Service already bound. Trying to rebind...");
            try {
                Registry registry = LocateRegistry.getRegistry(1099);
                
                TriangleServer server = new TriangleServer();
                TriangleInterface stub = (TriangleInterface) UnicastRemoteObject.exportObject(server, 0);
                registry.rebind("TriangleService", stub);
                
                System.out.println("TriangleServer ready (rebind successful)");
            } catch (Exception ex) {
                System.err.println("Server rebind exception: " + ex.toString());
                ex.printStackTrace();
            }
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}