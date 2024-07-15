package ru.mirea.dashish19;

public class ArrayElementGetter {
    public static <T> T getElement(T[] array, int index) {
        if (index >= 0 && index < array.length) {
            return array[index];
        } else {
            throw new IndexOutOfBoundsException("Индекс вышел за пределы");
        }
    }
}
