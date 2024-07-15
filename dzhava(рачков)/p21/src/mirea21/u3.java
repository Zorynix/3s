package mirea21;
//Реализовать метод, который возвращает любой элемент массива по
//индексу
public class u3<T> {
    private T[] array;

    public u3(int size) {
        // Создаем массив объектов типа T с заданным размером (неявное приведение к T[]).
        array = (T[]) new Object[size];
    }

    public void set(int index, T value) {
        array[index] = value;
    }

    public T get(int index) {
        return array[index];
    }

    public int length() {
        return array.length;
    }

    public static void main(String[] args) {
        u3<Integer> intArray = new u3<>(5);
        intArray.set(0, 10);
        intArray.set(1, 20);
        intArray.set(2, 30);

        System.out.println("Element at index 1: " + intArray.get(1));

        u3<String> stringArray = new u3<>(3);

        stringArray.set(0, "Hello");
        stringArray.set(1, "World");
        stringArray.set(2, "!");

        System.out.println("Element at index 0: " + stringArray.get(0));
    }
}
