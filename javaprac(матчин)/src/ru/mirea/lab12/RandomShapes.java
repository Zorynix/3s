package ru.mirea.lab12;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

// Абстрактный класс фигуры
abstract class Shape {
    protected Color color;    // Цвет фигуры
    protected Point position; // Позиция фигуры

    // Конструктор абстрактной фигуры
    public Shape(Color color, Point position) {
        this.color = color;
        this.position = position;
    }

    abstract void draw(Graphics g); // Абстрактный метод отрисовки фигуры
}

// Пример конкретной фигуры (круг)
class Circle extends Shape {
    private int radius; // Радиус круга

    // Конструктор круга
    public Circle(Color color, Point position, int radius) {
        super(color, position);
        this.radius = radius;
    }

    @Override
    void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(position.x - radius, position.y - radius, 2 * radius, 2 * radius);
    }
}

// Пример конкретной фигуры (прямоугольник)
class Rectangle extends Shape {
    private int width;  // Ширина прямоугольника
    private int height; // Высота прямоугольника

    // Конструктор прямоугольника
    public Rectangle(Color color, Point position, int width, int height) {
        super(color, position);
        this.width = width;
        this.height = height;
    }

    @Override
    void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(position.x, position.y, width, height);
    }
}

public class RandomShapes extends JPanel {
    private final int NUM_SHAPES = 20; // Количество случайных фигур
    private final Random random = new Random(); // Генератор случайных чисел

    private Shape[] shapes; // Массив для хранения фигур

    public RandomShapes() {
        shapes = new Shape[NUM_SHAPES];
        for (int i = 0; i < NUM_SHAPES; i++) {
            int x = random.nextInt(600); // Рандомные координаты в пределах панели
            int y = random.nextInt(400);
            int red = random.nextInt(256); // Рандомный красный компонент цвета
            int green = random.nextInt(256); // Рандомный зеленый компонент цвета
            int blue = random.nextInt(256); // Рандомный синий компонент цвета
            Color color = new Color(red, green, blue); // Случайный цвет

            if (i % 2 == 0) {
                int radius = random.nextInt(50); // Рандомный радиус для круга
                shapes[i] = new Circle(color, new Point(x, y), radius);
            } else {
                int width = random.nextInt(100); // Рандомные ширина и высота для прямоугольника
                int height = random.nextInt(100);
                shapes[i] = new Rectangle(color, new Point(x, y), width, height);
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Shape shape : shapes) {
            shape.draw(g);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Random Shapes"); // Создание главного окна
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600); // Установка размеров окна
        frame.add(new RandomShapes()); // Добавление панели с фигурами в окно
        frame.setVisible(true); // Отображение окна
    }
}
