package ru.mirea.lab4.task2;

// Класс для представления галстука, который наследуется от абстрактного класса Clothes и реализует интерфейс MenClothing
class Tie extends Clothes implements MenClothing {

    // Конструктор класса, вызывает конструктор суперкласса Clothes
    public Tie(Size size, double cost, String color) {
        super(size, cost, color);
    }

    // Реализация метода одевания мужчин
    @Override
    public void dressMan() {
        System.out.println("Мужчина носит галстук");
    }

    // Переопределение абстрактного метода для отображения информации о галстуке
    @Override
    public void displayInformation() {
        System.out.println("Галстук: Размер - " + getSize() + ", Цвет - " + getColor() + ", Цена - " + getCost());
    }
}
