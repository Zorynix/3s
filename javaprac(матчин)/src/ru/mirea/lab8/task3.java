package ru.mirea.lab8;

import java.util.Scanner;

public class task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число (десятичная запись без нулей): ");
        int n = scanner.nextInt();

        int reversed = reverseNumber(n);
        System.out.println("Число с противоположным порядком цифр: " + reversed);
    }

    // Метод для переворачивания числа
    public static int reverseNumber(int n) {
        if (n < 10) { // Если число меньше 10, оно уже перевернуто
            return n;
        } else {
            int lastDigit = n % 10; // Получаем последнюю цифру числа
            int remainingDigits = n / 10; // Получаем все остальные цифры числа
            int numberOfDigits = (int) Math.log10(remainingDigits) + 1; // Получаем количество цифр в оставшейся части числа
            return lastDigit * (int) Math.pow(10, numberOfDigits) + reverseNumber(remainingDigits); // Рекурсивно вызываем метод для оставшихся цифр
        }
    }
}
