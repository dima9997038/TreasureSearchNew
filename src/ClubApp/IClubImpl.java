package ClubApp;

import SeekerApp.ISeeker;
import model.Report;

import java.io.*;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class IClubImpl implements IClub, Serializable {
    private String name;
    private String color;
    private boolean registered;

    public IClubImpl(String name, String color, boolean registered) {
        this.name = name;
        this.color = color;
        this.registered = registered;
    }

    public IClubImpl() throws RemoteException{
    }


    @Override
    public String toString() {
        return "IClubImpl{" +
                "name='" + name + '\'' +
                ", color=" + color +
                ", registered=" + registered +
                '}';
    }

    @Override
    public boolean register(ISeeker ic) throws RemoteException {
        List<String> names = new ArrayList<>();
        try {
            FileReader fr = new FileReader("src/ClubApp/resources/registerSeeker");
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                names.add(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println("File " + "registerSeeker " + "don't found");
        }
        if(names.contains(ic.getName())){
            return false;
        }else {
            try {
                FileWriter writer = new FileWriter("src/ClubApp/resources/registerSeeker",true);
                writer.write(ic.getName() + "\n");
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return true;
        }
    }

    @Override
    public boolean unregister(String seekerName) throws RemoteException {
        List<String> names = new ArrayList<>();
        try {
            FileReader fr = new FileReader("src/ClubApp/resources/registerSeeker");
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                names.add(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println("File " + "registerSeeker " + "don't found");
        }
        if(names.contains(seekerName)){
            names.remove(seekerName);
            try {
                FileWriter writer = new FileWriter("src/ClubApp/resources/registerSeeker");
                for (String s : names) {
                    writer.write(s + System.lineSeparator());
                }
                writer.close();
            } catch (IOException e) {
                System.out.println("File " + "registerSeeker " + "don't found");
            }
            return true;
        }else return false;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean report(Report report, String seekerName) throws RemoteException {
        return false;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean getRegistered() {
        return registered;
    }

    public void setRegistered(boolean registered) {
        this.registered = registered;
    }
}
