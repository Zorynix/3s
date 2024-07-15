package mirea11;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Task5 {
    public static void main(String[] args) {
        int n = 1000; // Количество элементов в коллекциях.

        // Создаем ArrayList.
        List<Integer> arrayList = new ArrayList<>();

        // Измеряем время вставки в начало ArrayList.
        long startTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            arrayList.add(0, i);
        }
        long endTime = System.nanoTime();
        long arrayListInsertionTime = endTime - startTime;

        // Создаем LinkedList.
        List<Integer> linkedList = new LinkedList<>();

        // Измеряем время вставки в начало LinkedList.
        startTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            linkedList.add(0, i);
        }
        endTime = System.nanoTime();
        long linkedListInsertionTime = endTime - startTime;

        // Измеряем время удаления из середины ArrayList.
        startTime = System.nanoTime();
        arrayList.remove(arrayList.size() / 2);
        endTime = System.nanoTime();
        long arrayListDeletionTime = endTime - startTime;

        // Измеряем время удаления из середины LinkedList.
        startTime = System.nanoTime();
        linkedList.remove(linkedList.size() / 2);
        endTime = System.nanoTime();
        long linkedListDeletionTime = endTime - startTime;

        // Измеряем время добавления в конец ArrayList.
        startTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            arrayList.add(i);
        }
        endTime = System.nanoTime();
        long arrayListAppendTime = endTime - startTime;

        // Измеряем время добавления в конец LinkedList.
        startTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            linkedList.add(i);
        }
        endTime = System.nanoTime();
        long linkedListAppendTime = endTime - startTime;

        // Измеряем время поиска элемента по значению в ArrayList.
        int searchValue = n / 2;
        startTime = System.nanoTime();
        arrayList.contains(searchValue);
        endTime = System.nanoTime();
        long arrayListSearchTime = endTime - startTime;

        // Измеряем время поиска элемента по значению в LinkedList.
        startTime = System.nanoTime();
        linkedList.contains(searchValue);
        endTime = System.nanoTime();
        long linkedListSearchTime = endTime - startTime;

        // Выводим результаты.
        System.out.println("ArrayList вставка в начало: " + arrayListInsertionTime + " наносекунд");
        System.out.println("LinkedList вставка в начало: " + linkedListInsertionTime + " наносекунд");
        System.out.println("ArrayList удаление из середины: " + arrayListDeletionTime + " наносекунд");
        System.out.println("LinkedList удаление из середины: " + linkedListDeletionTime + " наносекунд");
        System.out.println("ArrayList добавление в конец: " + arrayListAppendTime + " наносекунд");
        System.out.println("LinkedList добавление в конец: " + linkedListAppendTime + " наносекунд");
        System.out.println("ArrayList поиск по значению: " + arrayListSearchTime + " наносекунд");
        System.out.println("LinkedList поиск по значению: " + linkedListSearchTime + " наносекунд");
    }
}