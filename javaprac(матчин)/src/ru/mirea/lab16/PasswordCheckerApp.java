package ru.mirea.lab16;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;

public class PasswordCheckerApp extends JFrame {
    private JTextField serviceField, usernameField;
    private JPasswordField passwordField;
    private JButton checkButton;

    public PasswordCheckerApp() {
        // Настройка окна приложения
        setTitle("Проверка пароля");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Создание компонентов
        JLabel serviceLabel = new JLabel("Service:");
        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");

        serviceField = new JTextField(20);
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);

        checkButton = new JButton("Проверить");
        checkButton.addActionListener(e -> checkPassword());

        // Настройка Layout менеджера
        setLayout(new GridLayout(4, 2));

        // Добавление компонентов в окно
        add(serviceLabel);
        add(serviceField);
        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(new JLabel()); // Пустая ячейка для разделения
        add(checkButton);

        // Отображение окна
        setVisible(true);
    }

    private void checkPassword() {
        String service = serviceField.getText();
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        // Загрузка данных из файла
        try {
            File file = new File("C:\\Users\\Alex\\Desktop\\3sem\\javaprac\\src\\ru\\mirea\\lab16\\passwords.csv");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                String storedService = parts[0];
                String storedUsername = parts[1];
                String storedPassword = parts[2];

                if (service.equals(storedService) && username.equals(storedUsername) && password.equals(storedPassword)) {
                    JOptionPane.showMessageDialog(this, "Пароль верный!");
                    return;
                }
            }

            JOptionPane.showMessageDialog(this, "Пароль неверный.");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new PasswordCheckerApp();
    }
}

