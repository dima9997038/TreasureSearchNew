package OfficeApp;

import model.DTO.ElementsOfWorld;
import services.ElementOfWorldService;
import services.Impl.ElementOfWorldServiceImpl;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.awt.event.*;

public class SectorElements extends JComponent {
    ElementOfWorldService elementOfWorldService = new ElementOfWorldServiceImpl();


    public SectorElements() {
        enableEvents(AWTEvent.MOUSE_EVENT_MASK);
    }

    @Override
    protected void processMouseEvent(MouseEvent mouseEvent) {
        super.processMouseEvent(mouseEvent);
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        drawGrid(graphics);
        drawInformationInElement(graphics);
    }

    void drawGrid(Graphics graphics) {
        int w = getWidth();
        int h = getHeight();
        int dw = w / 8;
        int dh = h / 8;
        graphics.setColor(Color.BLUE);
        for (int i = 0; i < 8; i++) {
            graphics.drawLine(0, dh * i, w, dh * i);
            graphics.drawLine(dw * i, 0, dw * i, h);
        }
    }

    void drawInformationInElement(Graphics graphics) {
        List<ElementsOfWorld> el = elementOfWorldService.getListOjElementOfWorld();
        int w = getWidth() / 8;
        int h = getHeight() / 8;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                int finalI = i;
                int finalJ = j;
                ElementsOfWorld e = el.stream()
                        .filter(elementsOfWorld -> elementsOfWorld.getI().equals(finalI))
                        .filter(elementsOfWorld -> elementsOfWorld.getJ().equals(finalJ))
                        .findFirst().orElse(null);
                graphics.drawString( e.getNameOfElements(), w * i + 20, h * j + 20);
                if(!e.getArtifact().equals("null")){
                    graphics.drawString( e.getArtifact(), w * i +20, h * j + 50);
                    graphics.drawString( e.getNameOfSector(), w * i +20, h * j + 60);
                    graphics.drawString( e.getTypeOfArtifact(), w * i +20, h * j + 90);
                }
            }
        }

    }

}
