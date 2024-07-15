package ru.mirea.lab15; // Пакет, в котором находится класс

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class task1 {
    private static JTextField textField; // Объявление текстового поля

    public static void main(String[] args) {
        JFrame frame = new JFrame("Моя программа"); // Создание главного окна
        frame.setSize(300, 200); // Установка размеров окна
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Установка операции по закрытию

        JMenuBar menuBar = new JMenuBar(); // Создание строки меню

        // Меню "Файл"
        JMenu fileMenu = new JMenu("Файл"); // Создание меню "Файл"
        JMenuItem saveItem = new JMenuItem("Сохранить"); // Пункт меню "Сохранить"
        saveItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Реализация сохранения файла
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showSaveDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    String filename = fileChooser.getSelectedFile().getName();
                    JOptionPane.showMessageDialog(frame, "Файл '" + filename + "' сохранен");
                }
            }
        });

        JMenuItem exitItem = new JMenuItem("Выйти"); // Пункт меню "Выйти"
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Выход из программы
            }
        });

        fileMenu.add(saveItem); // Добавление пункта "Сохранить" в меню "Файл"
        fileMenu.add(exitItem); // Добавление пункта "Выйти" в меню "Файл"

        // Меню "Правка"
        JMenu editMenu = new JMenu("Правка"); // Создание меню "Правка"
        JMenuItem copyItem = new JMenuItem("Копировать"); // Пункт меню "Копировать"
        JMenuItem cutItem = new JMenuItem("Вырезать"); // Пункт меню "Вырезать"
        JMenuItem pasteItem = new JMenuItem("Вставить"); // Пункт меню "Вставить"

        copyItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Реализация копирования
                textField.copy(); // Копирование текста из текстового поля
            }
        });

        cutItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Реализация вырезания
                textField.cut(); // Вырезание текста из текстового поля
            }
        });

        pasteItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Реализация вставки
                textField.paste(); // Вставка текста в текстовое поле
            }
        });

        editMenu.add(copyItem); // Добавление пункта "Копировать" в меню "Правка"
        editMenu.add(cutItem); // Добавление пункта "Вырезать" в меню "Правка"
        editMenu.add(pasteItem); // Добавление пункта "Вставить" в меню "Правка"

        JMenu helpMenu = new JMenu("Справка"); // Создание меню "Справка"

        menuBar.add(fileMenu); // Добавление меню "Файл" в строку меню
        menuBar.add(editMenu); // Добавление меню "Правка" в строку меню
        menuBar.add(helpMenu); // Добавление меню "Справка" в строку меню

        frame.setJMenuBar(menuBar); // Установка строки меню в главном окне

        JPanel panel = new JPanel(); // Создание панели
        JButton button1 = new JButton("Кнопка 1"); // Создание кнопки "Кнопка 1"
        JButton button2 = new JButton("Кнопка 2"); // Создание кнопки "Кнопка 2"
        textField = new JTextField(10); // Создание текстового поля

        panel.add(button1); // Добавление кнопки "Кнопка 1" на панель
        panel.add(button2); // Добавление кнопки "Кнопка 2" на панель
        panel.add(textField); // Добавление текстового поля на панель

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Обработчик для кнопки 1 (добавьте свой функционал здесь)
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Обработчик для кнопки 2 (добавьте свой функционал здесь)
            }
        });

        frame.add(panel); // Добавление панели в главное окно

        frame.setVisible(true); // Установка видимости главного окна
    }
}
