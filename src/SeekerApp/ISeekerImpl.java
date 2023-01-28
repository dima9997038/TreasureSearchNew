package SeekerApp;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ISeekerImpl extends UnicastRemoteObject implements ISeeker{
    protected ISeekerImpl() throws RemoteException {
    }

    @Override
    public boolean exploreTask(String sector, String field) throws RemoteException {
        return false;
    }

    @Override
    public String getName() throws RemoteException {
        return null;
    }
}
