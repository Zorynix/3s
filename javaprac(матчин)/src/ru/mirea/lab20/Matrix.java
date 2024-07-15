package ru.mirea.lab20;

import java.io.Serializable;

// Класс Cat наследуется от Animal и реализует интерфейс Serializable
class Cat extends Animal implements Serializable {
    private static final String species = "";

    // Конструктор по умолчанию
    public Cat() {
        super(species);
    }
}

// Интерфейс для объектов, которые имеют имя
interface Nameable {
    String getName(); // Метод возвращает имя объекта, реализующего интерфейс.
}

// Класс Animal реализует интерфейс Nameable
class Animal implements Nameable {
    private String species;

    // Конструктор класса Animal
    public Animal(String species) {
        this.species = species;
    }

    @Override
    public String getName() {
        return species; // Возвращает вид животного
    }
}

// Параметризированный класс с тремя типами
class CustomClass<T, V extends Animal & Serializable, K extends Comparable<K>> {
    private T t;
    private V v;
    private K k;

    // Конструктор класса CustomClass
    public CustomClass(T t, V v, K k) {
        this.t = t;
        this.v = v;
        this.k = k;
    }

    // Геттеры
    public T getT() {
        return t;
    }

    public V getV() {
        return v;
    }

    public K getK() {
        return k;
    }

    // Метод выводит типы объектов
    public void printClassNames() {
        System.out.println("Type of T: " + t.getClass().getName());
        System.out.println("Type of V: " + v.getClass().getName());
        System.out.println("Type of K: " + k.getClass().getName());
    }
}

// Параметризированный класс для работы с матрицами
public class Matrix<T extends Number> {
    private T[][] data;

    // Конструктор класса Matrix
    public Matrix(T[][] data) {
        this.data = data;
    }

    // Геттеры и сеттеры
    public T[][] getData() {
        return data;
    }

    public void setData(T[][] data) {
        this.data = data;
    }

    // Метод для печати матрицы
    public void printMatrix() {
        for (T[] row : data) {
            for (T element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    // Метод для сложения матриц
    public Matrix<T> add(Matrix<T> other) {
        if (data.length != other.data.length || data[0].length != other.data[0].length) {
            throw new IllegalArgumentException("Matrices must have the same dimensions for addition.");
        }

        // Создаем новую матрицу для результата
        T[][] result = (T[][]) new Number[data.length][data[0].length];

        // Складываем соответствующие элементы
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                result[i][j] = (T) (Double) (data[i][j].doubleValue() + other.data[i][j].doubleValue());
            }
        }

        return new Matrix<>(result);
    }
}
