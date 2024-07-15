package mirea11;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Введите год, месяц и день
        System.out.print("Введите год: ");
        int year = scanner.nextInt();

        System.out.print("Введите месяц (1-12): ");
        int month = scanner.nextInt();

        System.out.print("Введите день: ");
        int day = scanner.nextInt();

        // Введите часы и минуты
        System.out.print("Введите часы: ");
        int hours = scanner.nextInt();

        System.out.print("Введите минуты: ");
        int minutes = scanner.nextInt(); //

        Calendar calendar = Calendar.getInstance(); // Создаем объект Calendar для работы с датой и временем.getInstance() - текущие время и дата
        calendar.set(year, month-1, day, hours, minutes); // Устанавливаем указанную дату и время в объекте Calendar.

        Date date = calendar.getTime(); // Преобразуем объект Calendar в объект Date.
        System.out.println("Созданная дата и время: " + date); // Выводим созданную дату и время на экран.
    }
}