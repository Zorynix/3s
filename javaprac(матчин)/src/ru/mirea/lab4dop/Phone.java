package ru.mirea.lab4dop;

public class Phone {
    private String number;
    private String model;
    private double weight;

    // Конструктор с тремя параметрами
    public Phone(String number, String model, double weight) {
        this.number = number;
        this.model = model;
        this.weight = weight;
    }

    // Конструктор с двумя параметрами
    public Phone(String number, String model) {
        this(number, model, 0.0); // Вызываем конструктор с тремя параметрами
    }

    // Конструктор без параметров
    public Phone() {
        this("", "", 0.0); // Вызываем конструктор с тремя параметрами
    }

    // Метод receiveCall с одним параметром
    public void receiveCall(String callerName) {
        System.out.println("Звонит " + callerName);
    }

    // Перегруженный метод receiveCall с двумя параметрами
    public void receiveCall(String callerName, String callerNumber) {
        System.out.println("Звонит " + callerName + ", номер: " + callerNumber);
    }

    // Метод getNumber
    public String getNumber() {
        return number;
    }

    // Метод sendMessage с аргументами переменной длины
    public void sendMessage(String... numbers) {
        System.out.println("Отправить сообщение на следующие номера:");
        for (String number : numbers) {
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        // Создаем экземпляры класса Phone
        Phone phone1 = new Phone("123456789", "Model1", 150);
        Phone phone2 = new Phone("987654321", "Model2");
        Phone phone3 = new Phone();

        // Выводим значения переменных объектов
        System.out.println("Phone 1: Number - " + phone1.getNumber() + ", Model - " + phone1.model + ", Weight - " + phone1.weight);
        System.out.println("Phone 2: Number - " + phone2.getNumber() + ", Model - " + phone2.model + ", Weight - " + phone2.weight);
        System.out.println("Phone 3: Number - " + phone3.getNumber() + ", Model - " + phone3.model + ", Weight - " + phone3.weight);

        // Вызываем метод receiveCall для каждого объекта
        phone1.receiveCall("John Doe");
        phone2.receiveCall("Jane Doe");
        phone3.receiveCall("Unknown Caller");

        // Вызываем перегруженный метод receiveCall
        phone1.receiveCall("James Smith", "555-1234");

        // Вызываем метод sendMessage
        phone1.sendMessage("555-1111", "555-2222", "555-3333");
    }
}
