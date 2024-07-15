package ru.mirea.lab1;

import java.util.Scanner;

public class task3 {
    public static void main(String[] args) {
        // Создаем объект Scanner для чтения ввода с клавиатуры
        Scanner scanner = new Scanner(System.in);
        // Создание массива и инициализация его значениями 1, 2, 3, 4, 5, 6
        int[] array = {1,2,3,4,5,6};
        // Цикл для ввода новых значений в массив с клавиатуры
        for (int i=0;i<array.length;i++){
            System.out.print("Введите элемент массива #"+(i+1)+": ");
            array[i]=scanner.nextInt();

        }
        // Вычисление суммы всех элементов массива
        int sum = 0;
        for (int i=0;i< array.length;i++){
            sum+=array[i];
        }

        // Вычисление среднего арифметического элементов массива
        double average = (double) sum / array.length;

        // Вывод суммы и среднего арифметического на экран
        System.out.print("Сумма элементов: "+sum+"\n");
        System.out.print("Среднее арифметическое элементов: "+average+"\n");


        // Закрытие сканнера, чтобы избежать утечки ресурсов.
        scanner.close();
    }
}
