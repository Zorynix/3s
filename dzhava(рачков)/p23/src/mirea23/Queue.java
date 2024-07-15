package mirea23;

public interface Queue<T> {
    // Добавление элемента в очередь
    void enqueue(T element);

    // Извлечение элемента из очереди
    T dequeue();

    // Проверка, пуста ли очередь
    boolean isEmpty();

    // Получение размера очереди
    int size();
}
