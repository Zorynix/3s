package ru.mirea.dashish9;

// Интерфейс Nameable
public interface task1 {
    String getName();
}

// Пример реализации для класса Planet
class Planet implements task1 {
    private String name;

    public Planet(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}

// Пример реализации для класса Car
class Car implements task1 {
    private String modelName;

    public Car(String modelName) {
        this.modelName = modelName;
    }

    @Override
    public String getName() {
        return modelName;
    }
}

// Пример реализации для класса Animal
class Animal implements task1 {
    private String species;

    public Animal(String species) {
        this.species = species;
    }

    @Override
    public String getName() {
        return species;
    }
}

