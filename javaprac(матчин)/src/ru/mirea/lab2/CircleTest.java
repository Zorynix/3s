package ru.mirea.lab2;

public class CircleTest {
    public static void main(String[] args) {
        // Создаем две окружности
        Circle circle1 = new Circle(5.0);
        Circle circle2 = new Circle(7.0);

        // Выводим информацию о первой окружности
        System.out.println("Circle 1: " + circle1.toString());
        System.out.println("Radius: " + circle1.getRadius());
        System.out.println("Area: " + circle1.calculateArea());
        System.out.println("Circumference: " + circle1.calculateCircumference());

        // Выводим информацию о второй окружности
        System.out.println("\nCircle 2: " + circle2.toString());
        System.out.println("Radius: " + circle2.getRadius());
        System.out.println("Area: " + circle2.calculateArea());
        System.out.println("Circumference: " + circle2.calculateCircumference());

        // Сравниваем две окружности
        boolean isEqual = circle1.equals(circle2);
        System.out.println("\nCircle 1 equals Circle 2: " + isEqual);
    }
}
