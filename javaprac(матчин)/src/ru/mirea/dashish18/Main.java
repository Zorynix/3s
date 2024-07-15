package ru.mirea.dashish18;

public class Main {
    public static void main(String[] args) {
        // Пример использования CustomClass
        CustomClass<Integer, Cat, String> customObject = new CustomClass<>(10, new Cat(), "Hello");
        System.out.println("Value of T: " + customObject.getT());
        System.out.println("Value of V: " + customObject.getV());
        System.out.println("Value of K: " + customObject.getK());
        customObject.printClassNames();

        // Пример использования Matrix
        Integer[][] data1 = {{1, 2}, {3, 4}};
        Integer[][] data2 = {{5, 6}, {7, 8}};

        Matrix<Integer> matrix1 = new Matrix<>(data1);
        Matrix<Integer> matrix2 = new Matrix<>(data2);

        System.out.println("Matrix 1:");
        matrix1.printMatrix();

        System.out.println("Matrix 2:");
        matrix2.printMatrix();

        Matrix<Integer> sumMatrix = matrix1.add(matrix2);

        System.out.println("Sum Matrix:");
        sumMatrix.printMatrix();

        // Пример работы с MinMax
        Integer[] intArray = {3, 1, 5, 2, 4};
        MinMax<Integer> intMinMax = new MinMax<>(intArray);
        System.out.println("Min: " + intMinMax.findMin());
        System.out.println("Max: " + intMinMax.findMax());

        // Пример работы с Calculator
        System.out.println("Sum: " + Calculator.sum(5, 3));
        System.out.println("Multiplication: " + Calculator.multiply(5, 3));
        System.out.println("Division: " + Calculator.divide(5, 3));
        System.out.println("Subtraction: " + Calculator.subtract(5, 3));
    }
}
