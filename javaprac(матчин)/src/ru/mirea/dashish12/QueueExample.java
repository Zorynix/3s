package ru.mirea.dashish12;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();

        // Добавление элементов в очередь
        queue.add("Элемент 1");
        queue.add("Элемент 2");
        queue.add("Элемент 3");

        // Удаление элемента из очереди
        String removed = queue.poll();
        System.out.println("Удаленный элемент из очереди: " + removed);

        // Получение первого элемента без удаления
        String peeked = queue.peek();
        System.out.println("Первый элемент очереди: " + peeked);
    }
}
