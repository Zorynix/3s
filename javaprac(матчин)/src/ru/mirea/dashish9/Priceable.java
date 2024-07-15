package ru.mirea.dashish9;

// Пример использования интерфейса Priceable
public class Priceable {
    public static void main(String[] args) {
        // Создание объектов различных классов
        Book book = new Book("Java Programming", 25.99);
        Phone phone = new Phone("Samsung", 699.99);
        Fruit apple = new Fruit("Apple", 2.49, 1.5);

        // Проверка метода getPrice() для каждого объекта
        System.out.println("Цена книги: $" + book.getPrice());
        System.out.println("Цена телефона: $" + phone.getPrice());
        System.out.println("Цена яблока за 1.5 кг: $" + apple.getPrice());
    }
}
