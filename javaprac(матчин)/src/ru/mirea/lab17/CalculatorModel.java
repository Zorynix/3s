package ru.mirea.lab17;

public class CalculatorModel {
    private double result;

    public void add(double x, double y) {
        result = x + y;
    }

    public void subtract(double x, double y) {
        result = x - y;
    }

    public void multiply(double x, double y) {
        result = x * y;
    }

    public void divide(double x, double y) {
        if (y != 0) {
            result = x / y;
        } else {
            result = Double.NaN; // Обработка деления на ноль
        }
    }

    public double getResult() {
        return result;
    }
}
