package ru.mirea.lab1;

public class task5 {
    public static void main(String[] args) {
        // Цикл для перебора аргументов командной строки
        for (int i=0;i<args.length;i++){
            // Выводим номер и значение каждого аргумента
            System.out.print(" Arg "+(i+1)+": "+args[i]);
        }
    }
}
