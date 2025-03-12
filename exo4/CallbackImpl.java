import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class CallbackImpl extends UnicastRemoteObject implements Callback {

    protected CallbackImpl() throws RemoteException {
        super();
    }

    @Override
    public void doCallback(String chaine) throws RemoteException {
        System.out.println(chaine);
    }
}