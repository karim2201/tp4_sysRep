import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Fibonacci extends Remote {
    int[] calculateFibonacci(int n) throws RemoteException;
}