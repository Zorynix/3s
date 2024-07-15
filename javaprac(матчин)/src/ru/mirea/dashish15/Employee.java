package ru.mirea.dashish15;

// Класс Employee (Модель)
public class Employee {
    private String name; // Имя сотрудника
    private double hourlyRate; // Почасовая ставка
    private int hoursWorked; // Количество отработанных часов

    // Конструктор класса
    public Employee(String name, double hourlyRate, int hoursWorked) {
        this.name = name;
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    // Метод для получения имени сотрудника
    public String getName() {
        return name;
    }

    // Метод для получения почасовой ставки
    public double getHourlyRate() {
        return hourlyRate;
    }

    // Метод для получения количества отработанных часов
    public int getHoursWorked() {
        return hoursWorked;
    }

    // Метод для расчета заработной платы
    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }
}
