package OfficeApp;

import ClubApp.IClub;
import ClubApp.IClubImpl;
import model.Report;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class IOfficeImpl extends UnicastRemoteObject implements IOffice {

    protected IOfficeImpl() throws RemoteException {
    }

    @Override
    public boolean register(IClub ic) throws RemoteException {
        List<IClubImpl> clubs = new ArrayList<>();
        try {
            FileReader fr = new FileReader("src/resources/clubs");
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                String[] fromFile = line.split(",");
                IClubImpl club = new IClubImpl(fromFile[0], fromFile[1], Boolean.parseBoolean(fromFile[2]));
                clubs.add(club);
                line = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println("File " + "clubs " + "don't found");
        }

        for (IClubImpl c : clubs) {
            if (c.getName().equals(ic.getName())) {
                c.setRegistered(true);
            }
        }
        clubs.forEach(System.out::println);
        try {
            FileWriter writer = new FileWriter("src/resources/clubs");
            for (IClubImpl club : clubs) {
                String s = club.getName() + "," + club.getColor() + "," + club.getRegistered();
                writer.write(s + System.lineSeparator());
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("File " + "clubs " + "don't found");
        }
        return true;
    }

    @Override
    public boolean unregister(String clubName) throws RemoteException {
        List<IClubImpl> clubs = new ArrayList<>();
        try {
            FileReader fr = new FileReader("src/resources/clubs");
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                String[] fromFile = line.split(",");
                IClubImpl club = new IClubImpl(fromFile[0], fromFile[1], Boolean.parseBoolean(fromFile[2]));
                clubs.add(club);
                line = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println("File " + "clubs " + "don't found");
        }

        for (IClubImpl c : clubs) {
            if (c.getName().equals(clubName)) {
                c.setRegistered(false);
            }
        }
        try {
            FileWriter writer = new FileWriter("src/resources/clubs");
            for (IClubImpl club : clubs) {
                String s = club.getName() + "," + club.getColor() + "," + club.getRegistered();
                writer.write(s + System.lineSeparator());
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("File " + "clubs " + "don't found");
        }
        return false;
    }

    @Override
    public boolean permissionRequest(String clubName, String sector) throws RemoteException {
        int countOfPermissionForClub = 0;
        try {
            FileReader fr = new FileReader("src/resources/permissionClubs");
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                String[] fromFile = line.split(",");
                if (fromFile[1].equals(clubName)) {
                    countOfPermissionForClub++;
                }
                line = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println("File " + "permissionClubs " + "don't found");
        }

        if (countOfPermissionForClub >= 2) {
            return false;
        }
        try {
            FileWriter writer = new FileWriter("src/resources/permissionClubs", true);
            writer.write(sector + "," + clubName + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("File " + "permissionClubs " + "don't found");
        }
        return true;
    }

    @Override
    public boolean permissionEnd(String clubName, String sector) throws RemoteException {
        int countOfPermissionForClub = 0;
        List<PermissionClub> permissionClubs = new ArrayList<>();
        try {
            FileReader fr = new FileReader("src/resources/permissionClubs");
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                String[] fromFile = line.split(",");
                if (!((fromFile[0].equals(sector))&&(fromFile[1].equals(clubName)))){
                    PermissionClub club=new PermissionClub(fromFile[1],fromFile[0]);
                    permissionClubs.add(club);
                } else {countOfPermissionForClub++;}
                    line = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println("File " + "permissionClubs " + "don't found");
        }
        if(countOfPermissionForClub!=0){
            permissionClubs.forEach(System.out::println);
            try {
                FileWriter writer = new FileWriter("src/resources/permissionClubs");
                for (PermissionClub p : permissionClubs) {
                    String s = p.getSector()+","+p.getClubName();
                    writer.write(s + System.lineSeparator());
                }
                writer.close();
            } catch (IOException e) {
                System.out.println("File " + "permissionClubs " + "don't found");
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean report(List<Report> reports, String clubName) throws RemoteException {
        return false;
    }

    @Override
    public List<IClub> getClubs() throws RemoteException {
        List<IClub> clubs = new ArrayList<>();
        try {
            FileReader fr = new FileReader("src/resources/clubs");
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                String[] fromFile = line.split(",");
                IClubImpl club = new IClubImpl(fromFile[0], fromFile[1], Boolean.parseBoolean(fromFile[2]));
                clubs.add(club);
                line = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println("File " + "clubs " + "don't found");
        }
        return clubs;
    }
}
