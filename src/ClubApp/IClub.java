package ClubApp;

import SeekerApp.ISeeker;
import model.Report;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IClub extends Remote {

    boolean register(ISeeker ic) throws RemoteException;

    boolean unregister(String seekerName) throws RemoteException;

    String getName() throws RemoteException;

    boolean report(Report report, String seekerName) throws RemoteException;

}
