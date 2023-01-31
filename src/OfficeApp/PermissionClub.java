package OfficeApp;

public class PermissionClub {
    private String clubName;
    private String sector;

    public PermissionClub(String clubName, String sector) {
        this.clubName = clubName;
        this.sector = sector;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    @Override
    public String toString() {
        return "PermissionClub{" +
                "clubName='" + clubName + '\'' +
                ", sector='" + sector + '\'' +
                '}';
    }
}
