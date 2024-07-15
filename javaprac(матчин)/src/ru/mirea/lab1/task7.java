package ru.mirea.lab1;

import java.util.Scanner;

public class task7 {
    public static void main(String[] args) {

        // Создаем объект Scanner для ввода данных с клавиатуры
        Scanner scanner = new Scanner(System.in);

        // Запрашиваем у пользователя ввод числа
        System.out.print("Введите число:\n");
        int number = scanner.nextInt();

        // Проверяем, является ли число отрицательным
        if(number<0) {
            // Если число отрицательное, выводим сообщение
            System.out.print("Факториал определен только для неотрицательных чисел");
        } else {
            // Если число неотрицательное, вычисляем его факториал
            long factorial = calculateFactorial(number);
            // Выводим результат на экран
            System.out.print("Факториал числа "+number+" равен "+ factorial);
        }
        // Закрытие сканнера,для избежание утечки ресурсов.
        scanner.close();
    }

    // Метод для вычисления факториала числа n
    public static long calculateFactorial(int n){
        if (n==0){
            return 1;
        }
        // Инициализируем переменную для хранения факториала
        long factorial = 1;

        // Вычисляем факториал с использованием цикла
        for (int i=1;i<=n;i++){
            factorial*=i;
        }

        // Возвращаем результат
        return factorial;
    }
}
