package ru.mirea.lab1;

public class task6 {
    public static void main(String[] args) {

        System.out.print("Первые 10 чисел гармонического ряда:\n");

        // Цикл для вычисления и вывода первых 10 чисел гармонического ряда
        for (int i=1;i<=10;i++){
            // Вычисляем очередное значение гармонического ряда по формуле
            double harmonic=1.0/i;

            // Выводим результат с форматированием до 4 знаков после запятой
            System.out.printf("H(%d)=%.4f%n",i,harmonic);
        }
    }
}
