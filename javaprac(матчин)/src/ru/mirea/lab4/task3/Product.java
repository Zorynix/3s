package ru.mirea.lab4.task3;

// Класс, представляющий продукт в интернет-магазине
class Product {
    private String name;    // Наименование продукта
    private double price;   // Цена продукта

    // Конструктор, инициализирующий имя и цену продукта
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // Метод для получения имени продукта
    public String getName() {
        return name;
    }

    // Метод для получения цены продукта
    public double getPrice() {
        return price;
    }

    // Переопределение метода toString для красивого отображения продукта в виде строки
    @Override
    public String toString() {
        return name + " - $" + price;
    }
}
