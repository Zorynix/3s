package ru.mirea.lab3;

public class task3 {
    public static void main(String[] args) {
        // Задание 1.1: Создание объектов класса Double с использованием методов valueOf()
        Double doubleObj1 = Double.valueOf(3.14);
        Double doubleObj2 = Double.valueOf("2.718");

        // Задание 1.2: Преобразование значения типа String к типу double
        String strValue = "1.618";
        double doubleValue = Double.parseDouble(strValue);
        System.out.println("Преобразование строки в double: " + doubleValue);

        // Задание 1.3: Преобразование объекта Double ко всем примитивным типам
        double doublePrimitive = doubleObj1.doubleValue();
        float floatPrimitive = doubleObj1.floatValue();
        int intPrimitive = doubleObj1.intValue();
        long longPrimitive = doubleObj1.longValue();
        short shortPrimitive = doubleObj1.shortValue();
        byte bytePrimitive = doubleObj1.byteValue();

        // Вывод всех примитивных значений
        System.out.println("doublePrimitive: " + doublePrimitive);
        System.out.println("floatPrimitive: " + floatPrimitive);
        System.out.println("intPrimitive: " + intPrimitive);
        System.out.println("longPrimitive: " + longPrimitive);
        System.out.println("shortPrimitive: " + shortPrimitive);
        System.out.println("bytePrimitive: " + bytePrimitive);

        // Задание 1.4: Вывод значения объекта Double на консоль
        System.out.println("Значение объекта doubleObj1: " + doubleObj1);

        // Задание 1.5: Преобразование литерала типа double к строке
        String d = Double.toString(3.14);
        System.out.println("Строка d: " + d);
    }
}
