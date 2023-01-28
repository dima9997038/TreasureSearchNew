package ClubApp;

import model.Report;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class IClubImpl extends UnicastRemoteObject implements IClub {
    protected IClubImpl() throws RemoteException {
    }

    @Override
    public boolean unregister(String seekerName) throws RemoteException {
        return false;
    }

    @Override
    public String getName() throws RemoteException {
        return null;
    }

    @Override
    public boolean report(Report report, String seekerName) throws RemoteException {
        return false;
    }
}
