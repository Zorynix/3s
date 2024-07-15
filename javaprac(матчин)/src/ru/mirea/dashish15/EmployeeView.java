package ru.mirea.dashish15;

// Класс EmployeeView (Представление)
public class EmployeeView {
    public void printEmployeeDetails(String name, double hourlyRate, int hoursWorked, double salary) {
        System.out.println("Имя: " + name);
        System.out.println("Часовая ставка: " + hourlyRate);
        System.out.println("Отработано часов: " + hoursWorked);
        System.out.println("Заработная плата: " + salary);
    }
}
