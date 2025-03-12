import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class FibonacciImpl extends UnicastRemoteObject implements Fibonacci {

    protected FibonacciImpl() throws RemoteException {
        super();
    }

    @Override
    public int[] calculateFibonacci(int n) throws RemoteException {
        int[] fib = new int[n];
        fib[0] = 0;
        if (n > 1) {
            fib[1] = 1;
            for (int i = 2; i < n; i++) {
                fib[i] = fib[i - 1] + fib[i - 2];
            }
        }
        return fib;
    }
}