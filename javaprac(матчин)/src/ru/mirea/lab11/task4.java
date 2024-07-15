package ru.mirea.lab11;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Запрашиваем у пользователя данные
        System.out.println("Введите дату (ГГГГММДД):");
        String dateInput = scanner.nextLine();
        System.out.println("Введите время (ЧЧмм):");
        String timeInput = scanner.nextLine();

        // Форматы для парсинга даты и времени
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HHmm");

        try {
            // Парсим введенные данные
            Date date = dateFormat.parse(dateInput);
            Date time = timeFormat.parse(timeInput);

            // Создаем объекты Calendar и устанавливаем дату и время
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            Calendar timeCalendar = Calendar.getInstance();
            timeCalendar.setTime(time);

            // Устанавливаем часы и минуты
            calendar.set(Calendar.HOUR_OF_DAY, timeCalendar.get(Calendar.HOUR_OF_DAY));
            calendar.set(Calendar.MINUTE, timeCalendar.get(Calendar.MINUTE));

            // Выводим результаты
            System.out.println("Объект Date: " + date);
            System.out.println("Объект Calendar: " + calendar.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("Ошибка парсинга даты или времени.");
        }
    }
}
