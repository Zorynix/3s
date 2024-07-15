package ru.mirea.lab2;

import java.util.Objects;

public class Circle {
    private double radius;

    // Конструктор класса Circle для инициализации радиуса окружности
    public Circle(double radius) {
        this.radius = radius;
    }

    // Геттер для получения радиуса окружности
    public double getRadius() {
        return radius;
    }

    // Сеттер для установки радиуса окружности
    public void setRadius(double radius) {
        this.radius = radius;
    }

    // Метод для вычисления площади круга
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    // Метод для вычисления длины окружности
    public double calculateCircumference() {
        return 2 * Math.PI * radius;
    }

    // Метод для сравнения двух окружностей
    public boolean equals(Circle otherCircle) {
        if (otherCircle == null) {
            return false;
        }
        return Double.compare(this.radius, otherCircle.radius) == 0;
    }

    // Переопределенный метод equals для сравнения окружностей по радиусу
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // Проверка на идентичность объектов
        if (o == null || getClass() != o.getClass()) return false; // Проверка на класс
        Circle circle = (Circle) o; // Приведение к Circle
        return Double.compare(circle.radius, radius) == 0;
    }

    // Переопределенный метод hashCode для вычисления хеш-кода по радиусу
    @Override
    public int hashCode() {
        return Objects.hash(radius); // Вычисление хеш-кода по радиусу
    }

    // Переопределенный метод toString для строкового представления окружности
    @Override
    public String toString() {
        return "Circle [radius=" + radius + "]"; // Строковое представление окружности
    }
}
