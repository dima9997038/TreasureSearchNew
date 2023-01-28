package OfficeApp;

import javax.swing.*;
import java.awt.*;

public class SectorElements extends JComponent {

    @Override
    protected void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        drawGrid(graphics);
    }

    void drawGrid(Graphics graphics){
        int w=getWidth();
        int h=getHeight();
        int dw=w/8;
        int dh=h/8;
        graphics.setColor(Color.BLUE);
        for (int i = 0; i < 8; i++) {
            graphics.drawLine(0,dh*i,w,dh*i);
            graphics.drawLine(dw*i,0,dw*i,h);
        }
    }

}
