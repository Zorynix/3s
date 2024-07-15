package ru.mirea.lab4.task2;

// Класс для представления юбки, который наследуется от абстрактного класса Clothes и реализует интерфейс WomenClothing
class Skirt extends Clothes implements WomenClothing {

    // Конструктор класса, вызывает конструктор суперкласса Clothes
    public Skirt(Size size, double cost, String color) {
        super(size, cost, color);
    }

    // Реализация метода одевания женщин
    @Override
    public void dressWomen() {
        System.out.println("Женщина одета в юбку");
    }

    // Переопределение абстрактного метода для отображения информации о юбке
    @Override
    public void displayInformation() {
        System.out.println("Юбка: Размер - " + getSize() + ", Цвет - " + getColor() + ", Цена - " + getCost());
    }
}
