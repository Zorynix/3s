package ru.mirea.dashish21;

public class ArrayQueueADT {
    private int[] queue;
    private int front;
    private int rear;
    private int size;

    // Создать новую очередь
    public static ArrayQueueADT createQueue() {
        ArrayQueueADT newQueue = new ArrayQueueADT();
        newQueue.queue = new int[10];
        newQueue.front = 0;
        newQueue.rear = -1;
        newQueue.size = 0;
        return newQueue;
    }

    // Добавить элемент в очередь
    public void enqueue(int element) {
        if (size == queue.length)
            resize();
        rear = (rear + 1) % queue.length;
        queue[rear] = element;
        size++;
    }

    // Получить первый элемент в очереди
    public int element() {
        if (isEmpty())
            throw new IllegalStateException("Queue is empty");
        return queue[front];
    }

    // Удалить и вернуть первый элемент в очереди
    public int dequeue() {
        if (isEmpty())
            throw new IllegalStateException("Queue is empty");
        int removedElement = queue[front];
        front = (front + 1) % queue.length;
        size--;
        return removedElement;
    }

    // Получить текущий размер очереди
    public int size() {
        return size;
    }

    // Проверить, является ли очередь пустой
    public boolean isEmpty() {
        return size == 0;
    }

    // Очистить все элементы из очереди
    public void clear() {
        queue = new int[10];
        front = 0;
        rear = -1;
        size = 0;
    }

    // Увеличить размер массива при необходимости
    private void resize() {
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

