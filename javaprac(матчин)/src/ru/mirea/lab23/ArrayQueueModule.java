package ru.mirea.lab23;

import java.util.Arrays;

public class ArrayQueueModule {
    private static int[] queue = new int[10];
    private static int front = 0;
    private static int rear = -1;
    private static int size = 0;

    // Добавить элемент в очередь
    public static void enqueue(int element) {
        if (size == queue.length)
            resize();
        rear = (rear + 1) % queue.length;
        queue[rear] = element;
        size++;
    }

    // Получить первый элемент в очереди
    public static int element() {
        if (isEmpty())
            throw new IllegalStateException("Queue is empty");
        return queue[front];
    }

    // Удалить и вернуть первый элемент в очереди
    public static int dequeue() {
        if (isEmpty())
            throw new IllegalStateException("Queue is empty");
        int removedElement = queue[front];
        front = (front + 1) % queue.length;
        size--;
        return removedElement;
    }

    // Получить текущий размер очереди
    public static int size() {
        return size;
    }

    // Проверить, является ли очередь пустой
    public static boolean isEmpty() {
        return size == 0;
    }

    // Очистить все элементы из очереди
    public static void clear() {
        queue = new int[10];
        front = 0;
        rear = -1;
        size = 0;
    }

    // Увеличить размер массива при необходимости
    private static void resize() {
        int[] newQueue = new int[queue.length * 2];
        int index = 0;
        for (int i = front; i <= rear; i++) {
            newQueue[index++] = queue[i % queue.length];
        }
        queue = newQueue;
        front = 0;
        rear = size - 1;
    }
}

