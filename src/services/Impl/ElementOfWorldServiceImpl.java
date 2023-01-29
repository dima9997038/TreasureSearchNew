package services.Impl;

import model.DTO.ElementsOfWorld;
import services.ElementOfWorldService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ElementOfWorldServiceImpl implements ElementOfWorldService {
    @Override
    public List<ElementsOfWorld> getListOjElementOfWorld() {
        List<ElementsOfWorld> elementsOfWorld = new ArrayList<>();
        try {
            FileReader fr = new FileReader("src/resources/elementsOfWorld");
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                String[] fromFile = line.split(",");
                ElementsOfWorld element = new ElementsOfWorld(Integer.parseInt(fromFile[0]),Integer.parseInt(fromFile[1]),
                        fromFile[2],fromFile[3],fromFile[4],fromFile[5]);
                elementsOfWorld.add(element);
                line = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println("File "+ "elementsOfWorld " + "don't found" );
        }
        return elementsOfWorld;
    }
}
