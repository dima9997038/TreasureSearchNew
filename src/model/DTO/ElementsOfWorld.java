package model.DTO;

public class ElementsOfWorld {
    private Integer i;
    private Integer j;
    private String nameOfElements;
    private String Artifact;
    private String nameOfSector;
    private String typeOfArtifact;

    public ElementsOfWorld(int i, int j, String nameOfElements, String artifact, String nameOfSector, String typeOfArtifact) {
        this.i = i;
        this.j = j;
        this.nameOfElements = nameOfElements;
        Artifact = artifact;
        this.nameOfSector = nameOfSector;
        this.typeOfArtifact = typeOfArtifact;
    }


    public String getNameOfElements() {
        return nameOfElements;
    }

    public void setNameOfElements(String nameOfElements) {
        this.nameOfElements = nameOfElements;
    }

    public String getArtifact() {
        return Artifact;
    }

    public void setArtifact(String artifact) {
        Artifact = artifact;
    }

    public String getNameOfSector() {
        return nameOfSector;
    }

    public void setNameOfSector(String nameOfSector) {
        this.nameOfSector = nameOfSector;
    }

    public String getTypeOfArtifact() {
        return typeOfArtifact;
    }

    public void setTypeOfArtifact(String typeOfArtifact) {
        this.typeOfArtifact = typeOfArtifact;
    }

    public Integer getI() {
        return i;
    }

    public void setI(Integer i) {
        this.i = i;
    }

    public Integer getJ() {
        return j;
    }

    public void setJ(Integer j) {
        this.j = j;
    }
}
