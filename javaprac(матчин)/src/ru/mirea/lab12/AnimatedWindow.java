package ru.mirea.lab12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

// Класс для анимированного окна
public class AnimatedWindow extends JPanel implements ActionListener {
    private Timer timer;
    private int frameIndex;
    private BufferedImage[] frames;

    // Конструктор, принимающий путь к папке с изображениями
    public AnimatedWindow(String folderPath) {
        frames = new BufferedImage[3];
        for (int i = 0; i < 3; i++) {
            try {
                frames[i] = ImageIO.read(new File(folderPath + "\\frame" + i + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        frameIndex = 0;

        // Создание таймера с интервалом 1000 миллисекунд (1 кадр в секунду)
        timer = new Timer(1000, this);
        timer.start();
    }

    // Метод для отрисовки компонента
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image image = frames[frameIndex];
        g.drawImage(image, 0, 0, this);
    }

    // Обработчик события таймера
    @Override
    public void actionPerformed(ActionEvent e) {
        frameIndex = (frameIndex + 1) % frames.length;
        repaint();
    }

    // Метод main для запуска приложения
    public static void main(String[] args) {
        // Проверка наличия аргумента с путем к папке с изображениями
        if (args.length < 1) {
            System.out.println("Пожалуйста, укажите путь к папке с изображениями в аргументах командной строки.");
            return;
        }

        String folderPath = args[0];

        // Создание и настройка главного окна
        JFrame frame = new JFrame("Анимированное окно");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // Создание и добавление анимированного компонента в окно
        AnimatedWindow animatedWindow = new AnimatedWindow(folderPath);
        frame.add(animatedWindow);

        // Отображение окна
        frame.setVisible(true);
    }
}
