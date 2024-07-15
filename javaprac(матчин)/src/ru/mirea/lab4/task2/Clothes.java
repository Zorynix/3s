package ru.mirea.lab4.task2;

// Шаг 3: Создаем абстрактный класс Clothes
abstract class Clothes {
    private Size size;    // Размер одежды
    private double cost;  // Стоимость одежды
    private String color; // Цвет одежды

    // Конструктор класса Clothes
    public Clothes(Size size, double cost, String color) {
        this.size = size;
        this.cost = cost;
        this.color = color;
    }

    // Геттер для получения размера
    public Size getSize() {
        return size;
    }

    // Геттер для получения стоимости
    public double getCost() {
        return cost;
    }

    // Геттер для получения цвета
    public String getColor() {
        return color;
    }

    // Абстрактный метод, который должен быть переопределен в подклассах
    public abstract void displayInformation();
}
