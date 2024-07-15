package mirea23;

import java.util.Arrays;

class ArrayQueue {
    private static final int DEFAULT_CAPACITY = 10;
    private int[] queue;
    private int size;
    private int front; // Индекс начала очереди
    private int rear;  // Индекс конца очереди

    public ArrayQueue() {
        this.queue = new int[DEFAULT_CAPACITY];
        this.size = 0;
        this.front = 0;
        this.rear = -1;
    }

    // Добавление элемента в конец очереди
    public void enqueue(int item) {
        if (size == queue.length) {
            resize();
        }
        rear = (rear + 1) % queue.length;
        queue[rear] = item;
        size++;
    }

    // Получение первого элемента в очереди без удаления
    public int element() {
        if (isEmpty()) {
            throw new IllegalStateException("Очередь пуста");
        }
        return queue[front];
    }

    // Удаление и возврат первого элемента в очереди
    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Очередь пуста");
        }
        int removedItem = queue[front];
        front = (front + 1) % queue.length;
        size--;
        return removedItem;
    }

    // Получение текущего размера очереди
    public int size() {
        return size;
    }

    // Проверка, является ли очередь пустой
    public boolean isEmpty() {
        return size == 0;
    }

    // Очистка очереди
    public void clear() {
        Arrays.fill(queue, 0);
        size = 0;
        front = 0;
        rear = -1;
    }

    // Вспомогательный метод для изменения размера массива при необходимости
    private void resize() {
        int newCapacity = queue.length * 2;
        queue = Arrays.copyOf(queue, newCapacity);
    }
}

// Пример использования класса ArrayQueue
public class u1 {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println("Размер очереди: " + queue.size()); // Выводит 3
        System.out.println("Первый элемент: " + queue.element()); // Выводит 1

        int removed = queue.dequeue();
        System.out.println("Удаленный элемент: " + removed); // Выводит 1
        System.out.println("Размер очереди после удаления: " + queue.size()); // Выводит 2

        queue.clear();
        System.out.println("Очередь очищена. Пуста ли очередь: " + queue.isEmpty()); // Выводит true
    }
}
/*
public class ArrayQueueModule {
    private static final int DEFAULT_CAPACITY = 10;
    private static int[] queue = new int[DEFAULT_CAPACITY];
    private static int size = 0;
    private static int front = 0;
    private static int rear = -1;

    public static void enqueue(int item) {
        if (size == queue.length) {
            resize();
        }
        rear = (rear + 1) % queue.length;
        queue[rear] = item;
        size++;
    }

    public static int element() {
        if (isEmpty()) {
            throw new IllegalStateException("Очередь пуста");
        }
        return queue[front];
    }

    public static int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Очередь пуста");
        }
        int removedItem = queue[front];
        front = (front + 1) % queue.length;
        size--;
        return removedItem;
    }

    public static int size() {
        return size;
    }

    public static boolean isEmpty() {
        return size == 0;
    }

    public static void clear() {
        Arrays.fill(queue, 0);
        size = 0;
        front = 0;
        rear = -1;
    }

    private static void resize() {
        int newCapacity = queue.length * 2;
        queue = Arrays.copyOf(queue, newCapacity);
    }
}
*/
/*
public class ArrayQueueADT {
    private int[] queue;
    private int size;
    private int front;
    private int rear;

    public ArrayQueueADT() {
        this.queue = new int[10];
        this.size = 0;
        this.front = 0;
        this.rear = -1;
    }

    public static void enqueue(ArrayQueueADT queue, int item) {
        // Реализация метода enqueue для ArrayQueueADT
    }

    public static int element(ArrayQueueADT queue) {
        // Реализация метода element для ArrayQueueADT
    }

    public static int dequeue(ArrayQueueADT queue) {
        // Реализация метода dequeue для ArrayQueueADT
    }

    public static int size(ArrayQueueADT queue) {
        // Реализация метода size для ArrayQueueADT
    }

    public static boolean isEmpty(ArrayQueueADT queue) {
        // Реализация метода isEmpty для ArrayQueueADT
    }

    public static void clear(ArrayQueueADT queue) {
        // Реализация метода clear для ArrayQueueADT
    }

    private void resize() {
        // Реализация метода resize для ArrayQueueADT
    }
}*/

//enqueue(item): Добавить элемент в конец очереди.
//
//Предусловие: Очередь должна существовать.
//Постусловие: Элемент добавлен в конец очереди.
//element(): Получить первый элемент в очереди без его удаления.
//
//Предусловие: Очередь не пуста.
//Постусловие: Состояние очереди остается неизменным.
//dequeue(): Удалить и вернуть первый элемент в очереди.
//
//Предусловие: Очередь не пуста.
//Постусловие: Первый элемент удален из очереди и возвращен.
//size(): Получить текущий размер очереди.
//
//Постусловие: Состояние очереди остается неизменным.
//isEmpty(): Проверить, является ли очередь пустой.
//
//Постусловие: Состояние очереди остается неизменным.
//clear(): Удалить все элементы из очереди.
//
//Постусловие: Очередь становится пустой.




//Классы для реализации очереди:
//ArrayQueueModule:
//
//Реализация очереди с использованием переменных класса.
//Методы и переменные класса должны быть статическими.
//ArrayQueueADT:
//
//Реализация очереди в виде абстрактного типа данных.
//Необходимо передавать ссылку на экземпляр очереди.
//ArrayQueue:
//
//Реализация очереди в виде класса с неявной передачей ссылки на экземпляр очереди.