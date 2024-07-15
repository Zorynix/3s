package ru.mirea.lab11;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class task5 {
    public static void main(String[] args) {
        final int SIZE = 100000; // Размер коллекции для тестирования

        // Тестирование операций с ArrayList
        List<Integer> arrayList = new ArrayList<>();
        long startTime = System.nanoTime();

        // Вставка в конец
        for (int i = 0; i < SIZE; i++) {
            arrayList.add(i);
        }

        // Удаление элемента
        arrayList.remove(SIZE / 2);

        // Вставка в середину
        arrayList.add(SIZE / 2, 999);

        // Поиск элемента
        int index = arrayList.indexOf(999);

        long endTime = System.nanoTime();
        System.out.println("ArrayList: " + (endTime - startTime) + " наносекунд");

        // Тестирование операций с LinkedList
        List<Integer> linkedList = new LinkedList<>();
        startTime = System.nanoTime();

        // Вставка в конец
        for (int i = 0; i < SIZE; i++) {
            linkedList.add(i);
        }

        // Удаление элемента
        linkedList.remove(SIZE / 2);

        // Вставка в середину
        linkedList.add(SIZE / 2, 999);

        // Поиск элемента
        index = linkedList.indexOf(999);

        endTime = System.nanoTime();
        System.out.println("LinkedList: " + (endTime - startTime) + " наносекунд");
    }
}
