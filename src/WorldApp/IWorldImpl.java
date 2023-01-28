package WorldApp;

import model.Artifact;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class IWorldImpl extends UnicastRemoteObject implements IWorld{
    protected IWorldImpl() throws RemoteException {
    }

    @Override
    public Artifact explore(String seekerName, String sector, String field) throws RemoteException {
        return null;
    }
}
