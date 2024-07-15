package ru.mirea.lab16;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextEditorApp extends JFrame {
    private JTextArea textArea;
    private JMenu colorMenu;
    private JMenu fontMenu;

    public TextEditorApp() {
        // Настройка окна приложения
        setTitle("Текстовый редактор");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Создание текстовой области
        textArea = new JTextArea();
        textArea.setFont(new Font("Times New Roman", Font.PLAIN, 12));

        // Создание меню выбора цвета
        colorMenu = new JMenu("Цвет");
        JMenuItem blueItem = new JMenuItem("Синий");
        JMenuItem redItem = new JMenuItem("Красный");
        JMenuItem blackItem = new JMenuItem("Черный");

        blueItem.addActionListener(new ColorMenuItemListener(Color.BLUE));
        redItem.addActionListener(new ColorMenuItemListener(Color.RED));
        blackItem.addActionListener(new ColorMenuItemListener(Color.BLACK));

        colorMenu.add(blueItem);
        colorMenu.add(redItem);
        colorMenu.add(blackItem);

        // Создание меню выбора шрифта
        fontMenu = new JMenu("Шрифт");
        JMenuItem timesNewRomanItem = new JMenuItem("Times New Roman");
        JMenuItem msSansSerifItem = new JMenuItem("MS Sans Serif");
        JMenuItem courierNewItem = new JMenuItem("Courier New");

        timesNewRomanItem.addActionListener(new FontMenuItemListener("Times New Roman"));
        msSansSerifItem.addActionListener(new FontMenuItemListener("MS Sans Serif"));
        courierNewItem.addActionListener(new FontMenuItemListener("Courier New"));

        fontMenu.add(timesNewRomanItem);
        fontMenu.add(msSansSerifItem);
        fontMenu.add(courierNewItem);

        // Создание строки меню
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(colorMenu);
        menuBar.add(fontMenu);

        // Установка строки меню в окно приложения
        setJMenuBar(menuBar);

        // Добавление текстовой области в окно
        getContentPane().add(new JScrollPane(textArea));

        // Отображение окна
        setVisible(true);
    }

    // Обработчик событий для выбора цвета
    private class ColorMenuItemListener implements ActionListener {
        private Color color;

        public ColorMenuItemListener(Color color) {
            this.color = color;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            textArea.setForeground(color);
        }
    }

    // Обработчик событий для выбора шрифта
    private class FontMenuItemListener implements ActionListener {
        private String fontName;

        public FontMenuItemListener(String fontName) {
            this.fontName = fontName;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            textArea.setFont(new Font(fontName, Font.PLAIN, 18));
        }
    }

    public static void main(String[] args) {
        new TextEditorApp();
    }
}
