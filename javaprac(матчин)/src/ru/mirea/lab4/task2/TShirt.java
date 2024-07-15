package ru.mirea.lab4.task2;

// Класс для представления футболки, который наследуется от абстрактного класса Clothes и реализует интерфейсы MenClothing и WomenClothing
class TShirt extends Clothes implements MenClothing, WomenClothing {

    // Конструктор класса, вызывает конструктор суперкласса Clothes
    public TShirt(Size size, double cost, String color) {
        super(size, cost, color);
    }

    // Реализация метода одевания мужчин
    @Override
    public void dressMan() {
        System.out.println("Мужчина одет в футболку");
    }

    // Реализация метода одевания женщин
    @Override
    public void dressWomen() {
        System.out.println("Женщина одета в футболку");
    }

    // Переопределение абстрактного метода для отображения информации о футболке
    @Override
    public void displayInformation() {
        System.out.println("Футболка: Размер - " + getSize() + ", Цвет - " + getColor() + ", Цена - " + getCost());
    }
}
