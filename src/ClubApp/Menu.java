package ClubApp;


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
                    Registry registry = LocateRegistry.getRegistry(1099);
                    IOffice iOffice = (IOffice) registry.lookup("OfficeApp");
                    IClub iClub = new IClubImpl(ClubMain.NAME_CLUB, ClubMain.NAME_COLOR, true);
                    System.out.println(iOffice.register(iClub));
                }

                case 2 -> {
                    Registry registry = LocateRegistry.getRegistry(1099);
                    IOffice iOffice = (IOffice) registry.lookup("OfficeApp");
                    System.out.println(iOffice.unregister(ClubMain.NAME_CLUB));
                }
                case 3 -> {
                    System.out.println("Enter number of sector A1...H8");
                    Registry registry = LocateRegistry.getRegistry(1099);
                    IOffice iOffice = (IOffice) registry.lookup("OfficeApp");
                    String sector = in.next().toUpperCase();
                    byte[] b= sector.getBytes();
                    if ((b.length==2)&&((b[1]>=49)&&(b[1]<=56))&&((b[0]>=65)&&(b[0]<=72))){
                        System.out.println(iOffice.permissionRequest(ClubMain.NAME_CLUB, sector));
                    }else System.out.println("Un correct sector");
                }
                case 4->{
                    System.out.println("Enter number of sector A1...H8");
                    Registry registry = LocateRegistry.getRegistry(1099);
                    IOffice iOffice = (IOffice) registry.lookup("OfficeApp");
                    String sector = in.next().toUpperCase();
                    byte[] b= sector.getBytes();
                    if ((b.length==2)&&((b[1]>=49)&&(b[1]<=56))&&((b[0]>=65)&&(b[0]<=72))){
                        System.out.println(iOffice.permissionEnd(ClubMain.NAME_CLUB,sector));
                    }else System.out.println("Un correct sector");
                }

                case 0 -> MenuProgram.menuProgram();
                default -> System.out.println("Enter correct number");
            }
        } while (menu != 90);
    }
}
