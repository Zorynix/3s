package ru.mirea.dashish12;

import java.util.LinkedList;
import java.util.List;

public class DoubleListExample {
    public static void main(String[] args) {
        List<String> doubleList = new LinkedList<>();

        // Добавление элементов в двусвязный список
        doubleList.add("Первый");
        doubleList.add("Второй");
        doubleList.add("Третий");

        // Получение элемента по индексу
        String element = doubleList.get(1);
        System.out.println("Элемент по индексу 1: " + element);
    }
}