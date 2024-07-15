package z1;

import java.util.Arrays; //метод toString() для вывода массива на экран
import java.util.Random;

class Point { // класс Point, представляющий точку на плоскости
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}

class Circle { // класс Circle, представляющий окружность
    private Point center; // экземпляр класса
    private double radius; // Объявляем переменную radius для хранения радиуса окружности

    public Circle(Point center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    public Point getCenter() {
        return center;
    }

    public double getRadius() {
        return radius;
    }

    public double getCircumference() { // Метод для вычисления длины окружности
        return 2 * Math.PI * radius;
    }
}

class Tester {
    private Circle[] circles; // массив объектов Circle
    private int numCircles; // количество элементов в массиве

    public Tester(int maxSize) {
        circles = new Circle[maxSize];
        numCircles = 0; // Устанавливаем начальное количество элементов в массиве (0)
    }

    public void addCircle(Circle circle) { // Метод для добавления окружности в массив, принимает окружность
        if (numCircles < circles.length) { // Проверяем, есть ли место для добавления в массиве
            circles[numCircles] = circle; // Присваиваем элементу массива значение окружности
            numCircles++; // Увеличиваем количество элементов в массиве
        } else {
            System.out.println("Массив окружностей полон, нельзя добавить новую окружность.");
        }
    }

    public Circle findSmallestCircle() { // Метод для поиска самой маленькой окружности
        if (numCircles == 0) { // Проверяем, есть ли элементы в массиве
            return null;
        }

        Circle smallestCircle = circles[0]; // Инициализируем переменную smallestCircle первым элементом массива

        for (int i = 1; i < numCircles; i++) {
            if (circles[i].getRadius() < smallestCircle.getRadius()) {
                smallestCircle = circles[i]; //
            }
        }

        return smallestCircle;
    }

    public Circle findLargestCircle() { // Метод для поиска самой большой окружности
        if (numCircles == 0) { // Проверяем, есть ли элементы в массиве
            return null;
        }

        Circle largestCircle = circles[0];

        for (int i = 1; i < numCircles; i++) {
            if (circles[i].getRadius() > largestCircle.getRadius()) {
                largestCircle = circles[i];
            }
        }

        return largestCircle;
    }
}