package mirea15;

import java.awt.*;
import java.awt.event.*;

public class u1 {
    private static Choice resultSystemChoice;
    private static Choice num1SystemChoice;
    private static Choice num2SystemChoice;

    public static void main(String[] args) {
        Frame f = new Frame("Калькулятор");

        final TextField tf1 = new TextField();
        final TextField tf2 = new TextField();
        final TextField resultField = new TextField();

        Button addBtn = new Button("Сложить");
        Button subtractBtn = new Button("Вычесть");
        Button multiplyBtn = new Button("Умножить");
        Button divideBtn = new Button("Разделить");

        num1SystemChoice = new Choice();
        num1SystemChoice.add("Десятичная");
        num1SystemChoice.add("Двоичная");

        num2SystemChoice = new Choice();
        num2SystemChoice.add("Десятичная");
        num2SystemChoice.add("Двоичная");

        resultSystemChoice = new Choice();
        resultSystemChoice.add("Десятичная");
        resultSystemChoice.add("Двоичная");

        tf1.setBounds(200, 50, 100, 20);
        tf2.setBounds(200, 80, 100, 20);
        resultField.setBounds(50, 150, 250, 20);
        addBtn.setBounds(50, 120, 80, 30);
        subtractBtn.setBounds(150, 120, 80, 30);
        multiplyBtn.setBounds(50, 180, 80, 30);
        divideBtn.setBounds(150, 180, 80, 30);
        num1SystemChoice.setBounds(50, 50, 100, 20);
        num2SystemChoice.setBounds(50, 80, 100, 20);
        resultSystemChoice.setBounds(50, 210, 100, 20);

        addBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double num1 = convertToDouble(tf1.getText(), num1SystemChoice);
                double num2 = convertToDouble(tf2.getText(), num2SystemChoice);
                double result = num1 + num2;
                resultField.setText(convertToString(result, resultSystemChoice));
            }
        });

        subtractBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double num1 = convertToDouble(tf1.getText(), num1SystemChoice);
                double num2 = convertToDouble(tf2.getText(), num2SystemChoice);
                double result = num1 - num2;
                resultField.setText(convertToString(result, resultSystemChoice));
            }
        });

        multiplyBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double num1 = convertToDouble(tf1.getText(), num1SystemChoice);
                double num2 = convertToDouble(tf2.getText(), num2SystemChoice);
                double result = num1 * num2;
                resultField.setText(convertToString(result, resultSystemChoice));
            }
        });

        divideBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double num1 = convertToDouble(tf1.getText(), num1SystemChoice);
                double num2 = convertToDouble(tf2.getText(), num2SystemChoice);
                if (num2 != 0) {
                    double result = num1 / num2;
                    resultField.setText(convertToString(result, resultSystemChoice));
                } else {
                    resultField.setText("Ошибка: деление на ноль");
                }
            }
        });

        f.add(tf1);
        f.add(tf2);
        f.add(resultField);
        f.add(addBtn);
        f.add(subtractBtn);
        f.add(multiplyBtn);
        f.add(divideBtn);
        f.add(num1SystemChoice);
        f.add(num2SystemChoice);
        f.add(resultSystemChoice);

        f.setSize(350, 300);
        f.setLayout(null);
        f.setVisible(true);
    }

    private static double convertToDouble(String input, Choice systemChoice) {
        try {
            if (systemChoice.getSelectedItem().equals("Десятичная")) {
                return Double.parseDouble(input);
            } else {
                return Integer.parseInt(input, 2);
            }
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }

    private static String convertToString(double value, Choice systemChoice) {
        if (systemChoice.getSelectedItem().equals("Десятичная")) {
            return "Результат: " + value;
        } else {
            return "Результат (двоичная): " + Integer.toBinaryString((int) value);
        }
    }
}