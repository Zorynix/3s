package ru.mirea.dashish12;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeExample {
    public static void main(String[] args) {
        Deque<String> deque = new ArrayDeque<>();

        // Добавление элементов в начало и конец очереди
        deque.addFirst("Первый");
        deque.addLast("Последний");

        // Удаление элементов из начала и конца очереди
        String first = deque.pollFirst();
        String last = deque.pollLast();

        System.out.println("Удаленные элементы из очереди: " + first + ", " + last);
    }
}

