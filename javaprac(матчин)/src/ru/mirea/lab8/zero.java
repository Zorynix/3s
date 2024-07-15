package ru.mirea.lab8; // Пакет, к которому принадлежит класс

import java.util.Scanner; // Импорт класса Scanner из пакета java.util

public class zero { // Объявление класса zero
    public static void main(String[] args) { // Главный метод программы
        Scanner scanner = new Scanner(System.in); // Создание объекта Scanner для чтения ввода пользователя

        System.out.print("Введите количество нулей (a): "); // Печать приглашения пользователю для ввода количества нулей
        int a = scanner.nextInt(); // Считывание количества нулей

        System.out.print("Введите количество единиц (b): "); // Печать приглашения пользователю для ввода количества единиц
        int b = scanner.nextInt(); // Считывание количества единиц

        int[][] dp = new int[a+1][b+1]; // Инициализация двумерного массива dp

        for (int i = 0; i <= a; i++) { // Заполнение базовых случаев, когда один из счетчиков равен 0
            dp[i][0] = 1;
        }
        for (int j = 1; j <= b; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i <= a; i++) { // Заполнение dp таблицы используя рекуррентную формулу
            for (int j = 1; j <= b; j++) {
                dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
            }
        }

        System.out.println("Количество последовательностей: " + dp[a][b]); // Вывод результата
    }
}
