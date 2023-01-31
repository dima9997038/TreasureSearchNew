package ClubApp;


import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClubMain {

    public final static String NAME_CLUB="firstClub";
    public final static String NAME_COLOR="yellow";
    public static void main(String[] args) throws RemoteException, NotBoundException, AlreadyBoundException {
        Registry registry = LocateRegistry.createRegistry(1070);
        registry.bind("ClubApp",new IClubImpl());
        Menu.startMenu();
    }


}
