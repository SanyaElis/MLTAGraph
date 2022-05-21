package com.company;

import com.company.util.SwingUtils;

import javax.swing.*;
import java.awt.*;

public class GraphicPanel extends JPanel {
    private Color graphicColor = Color.GREEN;
    private int width;
    private int height;
    private int a = 3;
    private int tempColor = 0;
    private static final Color[] COLORS = {
            Color.BLUE,
            Color.RED,
            Color.YELLOW,
            Color.GREEN,
            Color.PINK,
            Color.MAGENTA,
            Color.CYAN,
            Color.ORANGE,
            Color.GRAY,
            Color.pink
    };

    public void paint(Graphics g) {
        super.paint(g);
        width = getWidth(); // сохраняем текущую ширину панели
        height = getHeight(); // и высоту

        drawGrid(g); // рисуем сетку
        drawAxis(g); // рисуем оси
        drawGraphic(g);
    }

    private void drawGrid(Graphics g) {
        g.setColor(Color.LIGHT_GRAY);  //задаем серый цвет

        for (int x = width / 2; x < width; x += 30) {  // цикл от центра до правого края
            g.drawLine(x, 0, x, height);    // вертикальная линия
        }

        for (int x = width / 2; x > 0; x -= 30) {  // цикл от центра до леваого края
            g.drawLine(x, 0, x, height);   // вертикальная линия
        }

        for (int y = height / 2; y < height; y += 30) {  // цикл от центра до верхнего края
            g.drawLine(0, y, width, y);    // горизонтальная линия
        }

        for (int y = height / 2; y > 0; y -= 30) {  // цикл от центра до леваого края
            g.drawLine(0, y, width, y);    // горизонтальная линия
        }
    }

    private void drawAxis(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawLine(width / 2, 0, width / 2, height);
        g.drawLine(0, height / 2, width, height / 2);
    }

    private void drawGraphic(Graphics g) {
        g.setColor(graphicColor); // устанавливаем цвет графика

        for (int x = 0; x < width; x++) {           // делаем цикл с левой стороны экрана до правой
            int realX = x - width / 2;   // так, как слева от оси OX минус, то отнимаем от текущей точки центральную точку
            int x2 = (int) Math.pow(realX, 3) / 2 * a - realX;
            if(x2 >= 0){
                int y = (int) Math.sqrt(x2) / 30;
                g.drawOval(x,height / 2 -  y, 2, 2);   // рисуем кружок в этой точке
                g.drawOval(x, height / 2 + y, 2, 2);   // рисуем кружок в этой точке
            }
        }
    }
    public void setAAndColor(int a, String color) {
        try {
            this.a = a;
        }catch (Exception e ){
            this.graphicColor = Color.RED;
        }
        this.graphicColor = COLORS[tempColor];
        tempColor+=  (tempColor < COLORS.length - 1) ? 1 : - tempColor;
        drawGraphic(super.getGraphics());
    }
}
