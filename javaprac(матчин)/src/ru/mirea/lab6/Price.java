package ru.mirea.lab6;

// Интерфейс Priceable
interface Priceable {
    double getPrice(); // Метод, возвращающий цену объекта.
}

// Примеры классов, реализующих интерфейс Priceable
class Product implements Priceable {
    private double price;

    // Конструктор класса Product
    public Product(double price) {
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price; // Возвращает цену продукта
    }
}

class Service implements Priceable {
    private double hourlyRate;
    private int hours;

    // Конструктор класса Service
    public Service(double hourlyRate, int hours) {
        this.hourlyRate = hourlyRate;
        this.hours = hours;
    }

    @Override
    public double getPrice() {
        return hourlyRate * hours; // Возвращает стоимость услуги
    }
}

public class Price {
    public static void main(String[] args) {
        // Создаем объекты классов, реализующих интерфейс Priceable
        Priceable product = new Product(50.0);
        Priceable service = new Service(20.0, 3);

        // Выводим цены продукта и услуги
        System.out.println("Product price: $" + product.getPrice());
        System.out.println("Service price: $" + service.getPrice());
    }
}
