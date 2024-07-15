package mirea12;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Абстрактный класс для представления фигур
abstract class Shape {
    protected Color color;
    protected int x, y, width, height;

    public Shape(Color color, int x, int y, int width, int height) {
        this.color = color;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    // Абстрактный метод для отрисовки фигуры
    public abstract void draw(Graphics g);
}

// Класс для представления круга
class Circle extends Shape {
    public Circle(Color color, int x, int y, int diameter) {
        super(color, x, y, diameter, diameter);
    }

    // Метод для отрисовки круга
    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, width, height);
    }
}

// Класс для представления треугольника
class Triangle extends Shape {
    public Triangle(Color color, int x, int y, int width, int height) {
        super(color, x, y, width, height);
    }

    // Метод для отрисовки треугольника
    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        int[] xPoints = {x, x + width, x + width / 2};
        int[] yPoints = {y + height, y + height, y};
        g.fillPolygon(xPoints, yPoints, 3);
    }
}

// Класс для представления прямоугольника
class MyRectangle extends Shape {
    public MyRectangle(Color color, int x, int y, int width, int height) {
        super(color, x, y, width, height);
    }

    // Метод для отрисовки прямоугольника
    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }
}


public class u1 {
    private static final int NUM_SHAPES = 20;
    private static final int PANEL_WIDTH = 600;
    private static final int PANEL_HEIGHT = 600;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Random Shapes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// при закрытии окна, программа будет завершена

        // Создаем графическую панель
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {  // переопределяем метод
                super.paintComponent(g); //обеспечить правильное очистку и отрисовку фона панели
                drawRandomShapes(g);
            }
        };

        // Устанавливаем размер графической панели
        panel.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));//предпочтительные размеры панели
        //panel.setSize(PANEL_WIDTH,PANEL_HEIGHT);
        frame.add(panel);

        // Устанавливаем размер окна и делаем его видимым
        frame.pack();
        frame.setVisible(true);
    }

    // Метод для создания и отрисовки случайных фигур
    private static void drawRandomShapes(Graphics g) {
        // Создаем список для хранения фигур
        List<Shape> shapes = new ArrayList<>();
        Random rand = new Random();

        // Генерируем случайные фигуры и добавляем их в список
        for (int i = 0; i < NUM_SHAPES; i++) {
            int x = rand.nextInt(PANEL_WIDTH - 50);
            int y = rand.nextInt(PANEL_HEIGHT - 50);
            int width = rand.nextInt(50) + 20;
            int height = rand.nextInt(50) + 20;
            Color color = new Color(rand.nextFloat(), rand.nextFloat(), rand.nextFloat());

            int shapeType = rand.nextInt(3);
            if (shapeType == 0) {
                shapes.add(new Circle(color, x, y, Math.min(width, height)));
            } else if (shapeType == 1) {
                shapes.add(new Triangle(color, x, y, width, height));
            } else {
                shapes.add(new MyRectangle(color, x, y, width, height));
            }
        }

        // Отрисовываем все фигуры на графической панели
        for (Shape shape : shapes) {
            shape.draw(g);
        }
    }
}