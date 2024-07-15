package ru.mirea.lab11;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class task1 {
    public static class Main {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);


            //30-11-2022 13:40:20

            // Фамилия разработчика
            String surname = "Солобай";

            // Получение текущей даты и времени
            Date currentDate = new Date();

            // Получение даты и времени задания от пользователя
            System.out.print("Введите дату и время получения задания (в формате dd-MM-yyyy HH:mm:ss): ");
            String receivedDateStr = scanner.nextLine();

            // Преобразование строки в дату
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            Date taskReceivedDate = null;

            try {
                taskReceivedDate = dateFormat.parse(receivedDateStr);
            } catch (Exception e) {
                System.out.println("Ошибка при парсинге даты: " + e.getMessage());
                return;
            }

            // Дата и время сдачи задания
            System.out.print("Введите дату и время сдачи задания (в формате dd-MM-yyyy HH:mm:ss): ");
            String submissionDateStr = scanner.nextLine();

            Date taskSubmissionDate = null;

            try {
                taskSubmissionDate = dateFormat.parse(submissionDateStr);
            } catch (Exception e) {
                System.out.println("Ошибка при парсинге даты: " + e.getMessage());
                return;
            }

            // Вывод информации
            System.out.println("Фамилия разработчика: " + surname);
            System.out.println("Дата и время получения задания: " + taskReceivedDate);
            System.out.println("Дата и время сдачи задания: " + taskSubmissionDate);
        }
    }
}


