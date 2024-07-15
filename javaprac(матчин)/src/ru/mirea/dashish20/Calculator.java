package ru.mirea.dashish20;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator implements ActionListener {
    JFrame frame; // Главное окно приложения
    JTextField TextField; // Поле для ввода/вывода чисел и результата
    JTextField historyField; // Поле для отображения истории операций
    JButton[] numberButtons = new JButton[10]; // Массив кнопок с цифрами
    JButton[] functionButtons = new JButton[9]; // Массив кнопок с операциями
    JButton addButton,subButton,mulButton,divButton; // Кнопки арифметических операций
    JButton decButton, equButton, delButton, clrButton, negButton; // Кнопки для десятичной точки, равно, удаления, очистки и смены знака
    JPanel panel; // Панель для размещения кнопок

    Font myFont = new Font("Times New Roman", Font.BOLD, 30); // Настройки шрифта

    double num1=0,num2=0,result=0; // Переменные для хранения чисел и результата
    char operator; // Переменная для хранения оператора

    Calculator() {

        // Настройки главного окна приложения
        frame = new JFrame("Calculator");
        frame.setSize(420, 550);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);

        // Поле для ввода/вывода чисел и результата
        TextField = new JTextField();
        TextField.setBounds(50, 45, 300, 50);
        TextField.setFont(myFont);
        TextField.setEditable(false); // Не редактируется пользователем
        TextField.setHorizontalAlignment(SwingConstants.RIGHT); // Выравнивание текста по правому краю

        // Поле для отображения истории операций
        historyField = new JTextField();
        historyField.setBounds(50, 15, 300, 25);
        historyField.setEditable(false); // Не редактируется пользователем
        historyField.setBorder(null); // Убрать границу поля
        historyField.setHorizontalAlignment(SwingConstants.RIGHT); // Выравнивание текста по правому краю

        historyField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        historyField.setForeground(Color.DARK_GRAY);

        // Создание кнопок для операций
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("X");
        clrButton = new JButton("C");
        negButton = new JButton("(-)");

        // Сохранение кнопок операций в массиве для удобства обработки
        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;

        // Настройка свойств кнопок операций
        for (int i = 0; i < 9; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false); // Убрать фокус (не подсвечиваться)
        }

        // Создание кнопок с цифрами и настройка их свойств
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false); // Убрать фокус (не подсвечиваться)
        }

        // Расположение кнопок на панели
        negButton.setBounds(50, 430, 100, 50);
        delButton.setBounds(150, 430, 100, 50);
        clrButton.setBounds(250, 430, 100, 50);

        // Создание панели для кнопок и настройка её расположения
        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4,4,10,10));

        // Добавление кнопок и полей на панель
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);

        // Установка расположения компонентов в окне
        frame.setLocationRelativeTo(null);
        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(TextField);
        frame.add(historyField);
        frame.setVisible(true);

        frame.repaint(); // Перерисовать окно

    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Обработка нажатий на кнопки с цифрами
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                TextField.setText(TextField.getText().concat(String.valueOf(i)));
            }
        }

        // Обработка нажатия на кнопку с десятичной точкой
        if (e.getSource() == decButton) {
            String currentText = TextField.getText();
            if (!currentText.contains(".")) {
                TextField.setText(currentText + ".");
            }
        }

        // Обработка нажатия на кнопку сложения
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(TextField.getText());
            operator = '+';
            TextField.setText("");
            historyField.setText(num1 + " + ");
        }

        // Обработка нажатия на кнопку вычитания
        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(TextField.getText());
            operator = '-';
            TextField.setText("");
            historyField.setText(num1 + " - ");
        }

        // Обработка нажатия на кнопку умножения
        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(TextField.getText());
            operator = '*';
            TextField.setText("");
            historyField.setText(num1 + " * ");
        }

        // Обработка нажатия на кнопку деления
        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(TextField.getText());
            operator = '/';
            TextField.setText("");
            historyField.setText(num1 + " / ");
        }

        // Обработка нажатия на кнопку равенства
        if (e.getSource() == equButton) {
            if (TextField.getText().isEmpty()) {
                historyField.setText("");
            } else {
                num2 = Double.parseDouble(TextField.getText());
                // Выполнение операции в зависимости от выбранного оператора
                switch (operator) {
                    case '+' -> result = num1 + num2;
                    case '-' -> result = num1 - num2;
                    case '*' -> result = num1 * num2;
                    case '/' -> result = num1 / num2;
                }

                // Вывод результата истории операций
                TextField.setText(String.valueOf(result));
                historyField.setText(historyField.getText().concat(String.valueOf(num2 + " =")));
                num1 = result; // Сохранение результата для дальнейших вычислений
            }
        }

        // Обработка нажатия на кнопку очистки
        if (e.getSource() == clrButton) {
            TextField.setText("");
            historyField.setText("");
        }

        // Обработка нажатия на кнопку удаления последнего символа
        if (e.getSource() == delButton) {
            String string = TextField.getText();
            TextField.setText("");
            for (int i = 0; i < string.length() - 1; i++) {
                TextField.setText(TextField.getText() + string.charAt(i));
            }
        }

        // Обработка нажатия на кнопку смены знака
        if (e.getSource() == negButton) {
            if (TextField.getText().length() == 0) {
                TextField.setText("-");
            } else {
                double temp = Double.parseDouble(TextField.getText());
                temp *= -1;
                TextField.setText(String.valueOf(temp));
            }
        }
    }
}