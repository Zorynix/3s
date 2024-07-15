package mirea22;

import java.util.Stack;

public class RPNCalculator {
    private int maxDecimalPlaces = 0;
    public double calculate(String expression) {
        Stack<Double> stack = new Stack<>(); // стек для хранения чисел в выражении

        String[] tokens = expression.split(" ");

        for (String token : tokens) {
            if (token.matches("-?\\d+(\\.\\d+)?")) { // Если текущий токен является числом (целым или с точкой)
                double number = Double.parseDouble(token);
                stack.push(number); // Преобразуем его в double и помещаем в стек

                // Вычисляем количество знаков после точки в текущем числе
                String[] decimalParts = token.split("\\.");
                if (decimalParts.length == 2) {
                    int decimalPlaces = decimalParts[1].length();
                    if (decimalPlaces > maxDecimalPlaces) {
                        maxDecimalPlaces = decimalPlaces;
                    }
                }
            } else if (token.matches("[+\\-*/]")) {
                double b = stack.pop();
                double a = stack.pop();

                switch (token) {
                    case "+":
                        stack.push(a + b);
                        break;
                    case "-":
                        stack.push(a - b);
                        break;
                    case "*":
                        stack.push(a * b);
                        break;
                    case "/":
                        stack.push(a / b);
                        break;
                }
            }
        }
        return stack.pop();
    }
    public int getMaxDecimalPlaces() {
        return maxDecimalPlaces;
    }
}