package ru.mirea.lab11;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DateComparison {
    public static void main(String[] args) {
        // Получаем текущую дату и время
        Date currentDate = new Date();

        // Форматируем дату в строку
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String currentDateString = dateFormat.format(currentDate);

        System.out.println("Текущая дата и время: " + currentDateString);

        // Получаем дату от пользователя
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите дату в формате dd-MM-yyyy HH:mm:ss: ");
        String userDateString = scanner.nextLine();

        // Преобразуем строку пользователя в дату
        Date userDate = null;
        try {
            userDate = dateFormat.parse(userDateString);
        } catch (Exception e) {
            System.out.println("Ошибка при парсинге даты: " + e.getMessage());
            return;
        }

        // Сравниваем даты
        if (currentDate.compareTo(userDate) > 0) {
            System.out.println("Текущая дата и время позже введенной пользователем.");
        } else if (currentDate.compareTo(userDate) < 0) {
            System.out.println("Текущая дата и время раньше введенной пользователем.");
        } else {
            System.out.println("Введенная пользователем дата и текущая дата совпадают.");
        }
    }
}
