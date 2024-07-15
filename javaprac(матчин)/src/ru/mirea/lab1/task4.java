package ru.mirea.lab1;

import java.util.Scanner;

public class task4 {
    public static void main(String[] args) {
        // Создаем объект Scanner для ввода данных с клавиатуры
        Scanner scanner = new Scanner(System.in);

        // Запрашиваем у пользователя размер массива
        System.out.print("Введите размер массива\n");

        // Создаем массив с указанным размером
        int size = scanner.nextInt();
        int[] array = new int[size];


        // Заполняем массив элементами, введенными пользователем
        for (int i=0;i<size;i++){
            System.out.print("Введите элемент массива #"+(i+1)+": ");
            array[i]=scanner.nextInt();
        }

        // Вычисляем сумму элементов массива с использованием do-while цикла
        int sumDoWhile=0;
        int doWhileIndex=0;
        do {
            sumDoWhile+=array[doWhileIndex];
            doWhileIndex++;
        } while(doWhileIndex<size);


        // Вычисляем сумму элементов массива с использованием while цикла
        int sumWhile=0;
        int whileIndex=0;
        while(whileIndex<size){
            sumWhile+=array[whileIndex];
            whileIndex++;
        }
        System.out.print("Сумма элементов с использованием do-while: "+sumDoWhile+"\n");
        System.out.print("Сумма элементов с использованием while: "+sumWhile+"\n");


        int maxim=array[0];
        int minim=array[0];
        // Находим максимальное и минимальное значения в массиве
        for (int i=1;i<size;i++){
            if(array[i]>maxim){
                maxim=array[i];
            }
            if (array[i]<minim){
                minim=array[i];
            }
        }

        System.out.print("Максимальный элемент массива: "+maxim+"\n");
        System.out.print("Минимальный элемент массива: "+minim+"\n");

        // Закрытие сканнера,для избежание утечки ресурсов.
        scanner.close();
    }
}
