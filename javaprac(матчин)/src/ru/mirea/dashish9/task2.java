package ru.mirea.dashish9;

// Интерфейс Priceable
public interface task2 {
    double getPrice();
}

// Пример реализации для класса Book
class Book implements task2 {
    private String title;
    private double price;

    public Book(String title, double price) {
        this.title = title;
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }
}

// Пример реализации для класса Phone
class Phone implements task2 {
    private String brand;
    private double price;

    public Phone(String brand, double price) {
        this.brand = brand;
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }
}

// Пример реализации для класса Fruit
class Fruit implements task2 {
    private String name;
    private double pricePerKg;
    private double weight;

    public Fruit(String name, double pricePerKg, double weight) {
        this.name = name;
        this.pricePerKg = pricePerKg;
        this.weight = weight;
    }

    @Override
    public double getPrice() {
        return pricePerKg * weight;
    }
}

