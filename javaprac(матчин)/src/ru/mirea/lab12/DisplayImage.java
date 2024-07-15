package ru.mirea.lab12;

import javax.swing.*;
import java.awt.*;

// Класс для отображения изображения
public class DisplayImage extends JPanel {
    private ImageIcon imageIcon; // Объект для хранения изображения

    // Конструктор, принимающий путь к изображению
    public DisplayImage(String imagePath) {
        imageIcon = new ImageIcon(imagePath); // Загрузка изображения по указанному пути
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image image = imageIcon.getImage(); // Получение объекта Image из ImageIcon
        g.drawImage(image, 0, 0, this); // Отображение изображения в панели
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Пожалуйста, укажите путь к изображению как аргумент командной строки.");
            return;
        }

        String imagePath = args[0]; // Получение пути к изображению из аргумента командной строки

        JFrame frame = new JFrame("Отображение изображения"); // Создание нового окна
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Установка действия при закрытии окна
        frame.setSize(800, 600); // Установка размеров окна

        DisplayImage displayImage = new DisplayImage(imagePath); // Создание объекта для отображения изображения
        frame.add(displayImage); // Добавление объекта в окно

        frame.setVisible(true); // Отображение окна
    }
}
