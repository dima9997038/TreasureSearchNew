package SeekerApp;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ISeeker extends Remote {

    boolean exploreTask(String sector, String field) throws RemoteException;

    String getName() throws RemoteException;
}
