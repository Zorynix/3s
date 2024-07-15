package ru.mirea.lab6;

// Интерфейс Nameable
interface Nameable {
    String getName(); // Метод возвращает имя объекта, реализующего интерфейс.
}

// Примеры классов, реализующих интерфейс Nameable
class Planet implements Nameable {
    private String name;

    // Конструктор класса Planet
    public Planet(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name; // Возвращает имя планеты
    }
}

class Car implements Nameable {
    private String brand;

    // Конструктор класса Car
    public Car(String brand) {
        this.brand = brand;
    }

    @Override
    public String getName() {
        return brand; // Возвращает марку автомобиля
    }
}

class Animal implements Nameable {
    private String species;

    // Конструктор класса Animal
    public Animal(String species) {
        this.species = species;
    }

    @Override
    public String getName() {
        return species; // Возвращает вид животного
    }
}

public class Main {
    public static void main(String[] args) {
        // Создаем объекты классов, реализующих интерфейс Nameable
        Nameable planet = new Planet("Earth");
        Nameable car = new Car("Toyota");
        Nameable animal = new Animal("Lion");

        // Выводим наименования объектов
        System.out.println("Planet name: " + planet.getName());
        System.out.println("Car brand: " + car.getName());
        System.out.println("Animal species: " + animal.getName());
    }
}
