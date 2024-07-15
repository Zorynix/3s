package ru.mirea.lab3;

import java.util.Scanner;

public class CurrencyConverter {

    // Метод для конвертации рублей в доллары
    public static double convertRublesToDollars(double rubles) {
        double exchangeRate = 0.010; // Устанавливаем курс обмена
        return rubles * exchangeRate; // Возвращаем результат конвертации
    }

    // Метод для конвертации рублей в евро
    public static double convertRublesToEuros(double rubles) {
        double exchangeRate = 0.0095; // Устанавливаем курс обмена
        return rubles * exchangeRate; // Возвращаем результат конвертации
    }

    // Метод для конвертации евро в рубли
    public static double convertEurosToRubles(double euros) {
        double exchangeRate = 105.45; // Устанавливаем курс обмена
        return euros * exchangeRate; // Возвращаем результат конвертации
    }

    // Метод для конвертации долларов в рубли
    public static double convertDollarsToRubles(double dollars) {
        double exchangeRate = 98.5; // Устанавливаем курс обмена
        return dollars * exchangeRate; // Возвращаем результат конвертации
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите операцию:");
        System.out.println("1 - Рубли в Доллары");
        System.out.println("2 - Рубли в Евро");
        System.out.println("3 - Евро в Рубли");
        System.out.println("4 - Доллары в Рубли");

        int choice = scanner.nextInt(); // Считываем выбор пользователя
        System.out.println("Введите сумму:");
        double amount = scanner.nextDouble(); // Считываем сумму для конвертации

        double result = 0; // Переменная для хранения результата

        switch (choice) { // Проверяем выбор пользователя
            case 1:
                result = convertRublesToDollars(amount); // Вызываем метод для конвертации рублей в доллары
                System.out.println(amount + " рублей = " + result + " долларов");
                break;
            case 2:
                result = convertRublesToEuros(amount); // Вызываем метод для конвертации рублей в евро
                System.out.println(amount + " рублей = " + result + " евро");
                break;
            case 3:
                result = convertEurosToRubles(amount); // Вызываем метод для конвертации евро в рубли
                System.out.println(amount + " евро = " + result + " рублей");
                break;
            case 4:
                result = convertDollarsToRubles(amount); // Вызываем метод для конвертации долларов в рубли
                System.out.println(amount + " долларов = " + result + " рублей");
                break;
            default:
                System.out.println("Некорректный выбор операции.");
        }
    }
}
