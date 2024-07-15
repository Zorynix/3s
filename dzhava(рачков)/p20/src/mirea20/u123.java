package mirea20;

import java.io.Serializable; // интерфейс Serializable нужен для ограничения типа V.
interface Animal {}

class MyGenericClass<T extends Comparable<T>, V extends Serializable & Animal, K> {
    private T t;
    private V v;
    private K k;

    public MyGenericClass(T t, V v, K k) {
        this.t = t;
        this.v = v;
        this.k = k;
    }

    public T getT() {
        return t;
    }

    public V getV() {
        return v;
    }

    public K getK() {
        return k;
    }

    // Метод для вывода имен классов для переменных.
    public void printClassNames() {
        System.out.println("Type of T: " + t.getClass().getName());
        System.out.println("Type of V: " + v.getClass().getName());
        System.out.println("Type of K: " + k.getClass().getName());
    }


    public static void main(String[] args) {
        MyGenericClass<Integer, Dog, String> myGenericObject = new MyGenericClass<>(42, new Dog(), "Hello");

        myGenericObject.printClassNames();
    }
}

// Создаем класс Dog, который расширяет интерфейс Animal и реализует Serializable.
class Dog implements Animal, Serializable {}
