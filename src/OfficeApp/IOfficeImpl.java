package OfficeApp;

import model.Report;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class IOfficeImpl extends UnicastRemoteObject implements IOffice {

    protected IOfficeImpl() throws RemoteException {
    }

    @Override
    public boolean unregister(String clubName) throws RemoteException {
        return false;
    }

    @Override
    public boolean permissionRequest(String clubName, String sector) throws RemoteException {
        return false;
    }

    @Override
    public boolean permissionEnd(String clubName, String sector) throws RemoteException {
        return false;
    }

    @Override
    public boolean report(List<Report> reports, String clubName) throws RemoteException {
        return false;
    }
}
