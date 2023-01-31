package SeekerApp;


import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class SeekerMain {
    public static final String NAME_SEEKER="John";
    public static void main(String[] args) throws RemoteException, NotBoundException {

        Menu.startMenu();
    }
}
