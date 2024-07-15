package mirea21;
//Написать класс, который умеет хранить в себе массив любых типов
//данных (int, long etc.).
public class u2<T> {
    private T[] array;

    public u2(int size) { // размер массива как параметр.
        // Создаем массив объектов, а затем приводим его к типу T.
        array = (T[]) new Object[size];
    }

    public void set(int index, T value) { // Метод для установки значения в массиве по индексу.
        array[index] = value;
    }

    public T get(int index) { // Метод для получения значения из массива по индексу.
        return array[index];
    }

    public int length() { // Метод для получения длины массива.
        return array.length;
    }

    public static void main(String[] args) {
        u2<Integer> intArray = new u2<>(5);

        // Устанавливаем значения в массиве
        intArray.set(0, 10);
        intArray.set(1, 20);
        intArray.set(2, 30);

        System.out.println("Element at index 1: " + intArray.get(1));

        u2<String> stringArray = new u2<>(3);

        stringArray.set(0, "Hello");
        stringArray.set(1, "World");
        stringArray.set(2, "!");

        System.out.println("Element at index 0: " + stringArray.get(0));
    }
}