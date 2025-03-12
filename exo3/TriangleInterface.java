import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TriangleInterface extends Remote {
    String displayIncreasingTriangle(int rows) throws RemoteException;
    String displayDecreasingTriangle(int rows) throws RemoteException;
}