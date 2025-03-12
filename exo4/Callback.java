import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Callback extends Remote {
    void doCallback(String chaine) throws RemoteException;
}