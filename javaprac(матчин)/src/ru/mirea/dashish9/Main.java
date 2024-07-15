package ru.mirea.dashish9;

// Пример использования интерфейса Nameable
public class Main {
    public static void main(String[] args) {
        // Создание объектов различных классов
        Planet earth = new Planet("Earth");
        Car car = new Car("Tesla Model S");
        Animal lion = new Animal("Lion");

        // Проверка метода getName() для каждого объекта
        System.out.println("Имя планеты: " + earth.getName());
        System.out.println("Название автомобиля: " + car.getName());
        System.out.println("Вид животного: " + lion.getName());
    }
}
