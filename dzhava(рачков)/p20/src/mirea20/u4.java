package mirea20;

public class u4 {
    public static void main(String[] args) {
        Integer[] intArray = {3, 1, 5, 7, 2};
        MinMax<Integer> intMinMax = new MinMax<>(intArray);

        System.out.println("Min Integer: " + intMinMax.findMin());
        System.out.println("Max Integer: " + intMinMax.findMax());

        Double[] doubleArray = {3.5, 1.2, 5.7, 7.1, 2.8};
        MinMax<Double> doubleMinMax = new MinMax<>(doubleArray);

        System.out.println("Min Double: " + doubleMinMax.findMin());
        System.out.println("Max Double: " + doubleMinMax.findMax());

        int num1 = 10, num2 = 5;
        System.out.println("Sum: " + Калькулятор.sum(num1, num2));
        System.out.println("Multiply: " + Калькулятор.multiply(num1, num2));
        System.out.println("Divide: " + Калькулятор.divide(num1, num2));
        System.out.println("Subtraction: " + Калькулятор.subtraction(num1, num2));
    }
}

// Обобщенный класс MinMax для поиска минимума и максимума в массиве
class MinMax<T extends Comparable<T>> {
    private T[] array;

    public MinMax(T[] array) {
        this.array = array;
    }

    public T findMin() {
        if (array == null || array.length == 0) {
            return null;
        }

        T min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i].compareTo(min) < 0) {
                min = array[i];
            }
        }
        return min;
    }

    public T findMax() {
        if (array == null || array.length == 0) {
            return null;
        }

        T max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i].compareTo(max) > 0) {
                max = array[i];
            }
        }
        return max;
    }
}

// Класс Калькулятор с обобщенными статическими методами для математических операций
class Калькулятор {
    public static <T extends Number> T sum(T a, T b) {
        // Проверяем типы чисел и выполняем сложение
        if (a instanceof Integer && b instanceof Integer) {
            return (T) Integer.valueOf(a.intValue() + b.intValue());
        } else if (a instanceof Double && b instanceof Double) {
            return (T) Double.valueOf(a.doubleValue() + b.doubleValue());
        } else {
            throw new IllegalArgumentException("Unsupported data type");
        }
    }

    public static <T extends Number> T multiply(T a, T b) {
        if (a instanceof Integer && b instanceof Integer) {
            return (T) Integer.valueOf(a.intValue() * b.intValue());
        } else if (a instanceof Double && b instanceof Double) {
            return (T) Double.valueOf(a.doubleValue() * b.doubleValue());
        } else {
            throw new IllegalArgumentException("Unsupported data type");
        }
    }

    public static <T extends Number> T divide(T a, T b) {
        if (a instanceof Integer && b instanceof Integer) {
            return (T) Integer.valueOf(a.intValue() / b.intValue());
        } else if (a instanceof Double && b instanceof Double) {
            return (T) Double.valueOf(a.doubleValue() / b.doubleValue());
        } else {
            throw new IllegalArgumentException("Unsupported data type");
        }
    }

    public static <T extends Number> T subtraction(T a, T b) {
        if (a instanceof Integer && b instanceof Integer) {
            return (T) Integer.valueOf(a.intValue() - b.intValue());
        } else if (a instanceof Double && b instanceof Double) {
            return (T) Double.valueOf(a.doubleValue() - b.doubleValue());
        } else {
            throw new IllegalArgumentException("Unsupported data type");
        }
    }
}
