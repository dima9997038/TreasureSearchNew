package OfficeApp;

import ClubApp.IClub;
import model.Report;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IOffice extends Remote {

    boolean register(IClub ic) throws RemoteException;

    boolean unregister(String clubName) throws RemoteException;

    boolean permissionRequest(String clubName, String sector) throws RemoteException;

    boolean permissionEnd(String clubName, String sector) throws RemoteException;

    boolean report(List<Report> reports, String clubName) throws RemoteException;

    List<IClub> getClubs() throws RemoteException;
}
