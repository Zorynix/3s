package mirea15;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class u4 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Калькулятор");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);

        // текстовое поле для отображения и ввода данных
        JTextField display = new JTextField();
        display.setFont(new Font("Arial", Font.PLAIN, 24)); // устанавливаем стиль текста, Font.PLAIN - обычный стиль
        display.setEditable(false); // не редактируемо

        // панель для кнопок
        JPanel buttonPanel = new JPanel(new GridLayout(4, 4, 5, 5)); // 3 и 4 - отступы между столбцами

        String[] buttonLabels = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+"
        };

        // Создаем кнопки и добавляем их на панель
        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.PLAIN, 24));
            button.setFocusPainted(true); //рамка, когда кнопка в фокусе
            button.setBorderPainted(true); //отображение границ
            button.setContentAreaFilled(false); //разрешение заливки фона кнопки
            //button.setBackground(Color.PINK);

            // Добавляем слушателя событий для кнопок
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String text = display.getText();
                    if (label.equals("=")) {
                        try {
                            double result = evaluateExpression(text);
                            display.setText(Double.toString(result));
                        } catch (ArithmeticException ex) {
                            display.setText("Ошибка");
                        }
                    } else {
                        display.setText(text + label);
                    }
                }
            });

            buttonPanel.add(button);
        }

        frame.add(display, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    private static double evaluateExpression(String expression) {
        try {
            return evaluate(expression);
        } catch (ArithmeticException e) {
            throw e;
        } catch (Exception e) {
            throw new ArithmeticException("Ошибка");
        }
    }

    private static double evaluate(String expression) {
        // Удаляем пробелы из выражения
        expression = expression.replaceAll("\\s", "");

        try {
            // Разбиваем выражение на операнды и оператор
            String[] parts = expression.split("[+\\-*/]");

            if (parts.length != 2) {
                throw new IllegalArgumentException("Неправильный формат выражения");
            }

            double operand1 = Double.parseDouble(parts[0]);
            double operand2 = Double.parseDouble(parts[1]);
            char operator = expression.charAt(parts[0].length());

            // Выполняем соответствующую операцию
            switch (operator) {
                case '+':
                    return operand1 + operand2;
                case '-':
                    return operand1 - operand2;
                case '*':
                    return operand1 * operand2;
                case '/':
                    if (operand2 == 0) {
                        throw new ArithmeticException("Деление на ноль");
                    }
                    return operand1 / operand2;
                default:
                    throw new IllegalArgumentException("Неподдерживаемая операция");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Ошибка парсинга чисел");
        }
    }
}