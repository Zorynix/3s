package ru.mirea.lab4.task2;

// Класс для представления штанов, который наследуется от абстрактного класса Clothes и реализует интерфейсы MenClothing и WomenClothing
class Pants extends Clothes implements MenClothing, WomenClothing {

    // Конструктор класса, вызывает конструктор суперкласса Clothes
    public Pants(Size size, double cost, String color) {
        super(size, cost, color);
    }

    // Реализация метода одевания мужчин
    @Override
    public void dressMan() {
        System.out.println("Мужчина одет в штаны");
    }

    // Реализация метода одевания женщин
    @Override
    public void dressWomen() {
        System.out.println("Женщина одета в штаны");
    }

    // Переопределение абстрактного метода для отображения информации о штанах
    @Override
    public void displayInformation() {
        System.out.println("Штаны: Размер - " + getSize() + ", Цвет - " + getColor() + ", Цена - " + getCost());
    }
}
