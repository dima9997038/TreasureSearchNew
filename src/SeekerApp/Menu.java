package SeekerApp;

import ClubApp.IClub;
import OfficeApp.IOffice;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Menu {
    public static void startMenu() throws RemoteException, NotBoundException {
        int menu;
        Scanner in = new Scanner(System.in);
        MenuProgram.menuProgram();
        do {
            menu = in.nextInt();
            switch (menu) {
                case 1 -> {
                    Registry registry = LocateRegistry.getRegistry(1070);
                    IClub iClub = (IClub) registry.lookup("ClubApp");
                    ISeeker iSeeker=new ISeekerImpl();
                    System.out.println(iClub.register(iSeeker));
                }
                case 2 -> {
                    Registry registry = LocateRegistry.getRegistry(1070);
                    IClub iClub = (IClub) registry.lookup("ClubApp");
                    System.out.println(iClub.unregister(SeekerMain.NAME_SEEKER));
                }
                case 3 -> {
                    Registry registry = LocateRegistry.getRegistry(1099);
                    IOffice iOffice = (IOffice) registry.lookup("OfficeApp");
                    iOffice.getClubs().forEach(System.out::println);
                }
                case 4->{

                }

                case 0 -> MenuProgram.menuProgram();
                default -> System.out.println("Enter correct number");
            }
        } while (menu != 90);
    }
}
