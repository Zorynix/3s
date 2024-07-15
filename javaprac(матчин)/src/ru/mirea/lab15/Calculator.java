package ru.mirea.lab15;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// Создаем класс-наследник JFrame для построения GUI
public class Calculator extends JFrame {
    // Создание текстовых полей и кнопок
    JTextField jta1 = new JTextField(10); // Поле для первого числа
    JTextField jta2 = new JTextField(10); // Поле для второго числа
    JButton addButton = new JButton("Add"); // Кнопка для сложения
    JButton subButton = new JButton("Subtract"); // Кнопка для вычитания
    JButton mulButton = new JButton("Multiply"); // Кнопка для умножения
    JButton divButton = new JButton("Divide"); // Кнопка для деления

    // Конструктор класса
    Calculator() {
        super("Calculator"); // Устанавливаем заголовок окна
        setLayout(new FlowLayout()); // Устанавливаем менеджер компоновки
        setSize(250, 250); // Устанавливаем размеры окна

        // Добавляем компоненты на форму
        add(new JLabel("1st Number")); // Метка для первого числа
        add(jta1); // Поле ввода для первого числа
        add(new JLabel("2nd Number")); // Метка для второго числа
        add(jta2); // Поле ввода для второго числа

        add(addButton); // Кнопка сложения
        add(subButton); // Кнопка вычитания
        add(mulButton); // Кнопка умножения
        add(divButton); // Кнопка деления

        // Настраиваем обработчики событий для кнопок
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                calculate('+'); // Вызов метода calculate с оператором сложения
            }
        });

        subButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                calculate('-'); // Вызов метода calculate с оператором вычитания
            }
        });

        mulButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                calculate('*'); // Вызов метода calculate с оператором умножения
            }
        });

        divButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                calculate('/'); // Вызов метода calculate с оператором деления
            }
        });

        setVisible(true); // Делаем окно видимым
    }

    // Метод для выполнения арифметических операций
    public void calculate(char operator) {
        try {
            double x1 = Double.parseDouble(jta1.getText().trim()); // Получаем первое число
            double x2 = Double.parseDouble(jta2.getText().trim()); // Получаем второе число
            double result = 0; // Переменная для результата вычислений

            switch (operator) {
                case '+':
                    result = x1 + x2; // Сложение
                    break;
                case '-':
                    result = x1 - x2; // Вычитание
                    break;
                case '*':
                    result = x1 * x2; // Умножение
                    break;
                case '/':
                    if (x2 != 0) {
                        result = x1 / x2; // Деление (проверка деления на ноль)
                    } else {
                        JOptionPane.showMessageDialog(null, "Error: Division by zero!", "Alert", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    break;
            }

            JOptionPane.showMessageDialog(null, "Result = " + result, "Alert", JOptionPane.INFORMATION_MESSAGE); // Вывод результата

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error in Numbers!", "Alert", JOptionPane.ERROR_MESSAGE); // Обработка ошибок
        }
    }

    // Метод main для запуска программы
    public static void main(String[] args) {
        new Calculator(); // Создаем объект класса Calculator
    }
}
