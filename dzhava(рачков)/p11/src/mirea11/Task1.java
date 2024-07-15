package mirea11;

import java.util.Date;

public class Task1 {
    public static void main(String[] args) {
        // Фамилия разработчика
        String developerSurname = "Иванов";

        // Дата и время получения задания
        Date taskReceivedDate = new Date();  // текущая дата и время

        // Дата и время сдачи задания (через 7 дней)
        Date taskSubmissionDate = new Date(taskReceivedDate.getTime() + 7 * 24 * 60 * 60 * 1000);
        // текущее время getTime()

        // Выводим информацию на консоль
        System.out.println("Фамилия разработчика: " + developerSurname);
        System.out.println("Дата и время получения задания: " + taskReceivedDate);
        System.out.println("Дата и время сдачи задания: " + taskSubmissionDate);
    }
}
