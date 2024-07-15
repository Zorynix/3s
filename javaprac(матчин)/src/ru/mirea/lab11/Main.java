package ru.mirea.lab11;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите дату рождения (в формате dd-MM-yyyy): ");
        String birthDateStr = scanner.nextLine();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date birthDate;

        try {
            birthDate = dateFormat.parse(birthDateStr);
        } catch (Exception e) {
            System.out.println("Ошибка при парсинге даты: " + e.getMessage());
            return;
        }

        Student student = new Student("Иванов", birthDate);

        System.out.println("Дата рождения в коротком формате: " + student.getFormattedBirthDate("dd-MM-yyyy"));
        System.out.println("Дата рождения в среднем формате: " + student.getFormattedBirthDate("dd-MMM-yyyy"));
        System.out.println("Дата рождения в полном формате: " + student.getFormattedBirthDate("dd-MM-yyyy HH:mm:ss"));
    }
}
