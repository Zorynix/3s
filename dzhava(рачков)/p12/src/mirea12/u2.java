package mirea12;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.net.URL;

public class u2 {
    public static void main(String[] args) {
        // Путь к изображению
        String imagePath = "https://fikiwiki.com/uploads/posts/2022-02/1644827830_12-fikiwiki-com-p-prikolnie-i-smeshnie-kartinki-pro-sessiyu-16.jpg";

        // Создаем окно
        JFrame frame = new JFrame("Изображение");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Загружаем изображение из URL (в данном случае, из интернета)
        BufferedImage image = null;
        try {
            URL imageUrl = new URL(imagePath); //Создается объект URL на основе пути к изображению imagePath.
            image = ImageIO.read(imageUrl);//Изображение загружается из указанного URL-адреса с помощью ImageIO.read() и сохраняется в переменной image.
        } catch (IOException e) {//Если произойдет ошибка ввода-вывода
            e.printStackTrace();// Выводится информация об ошибке в консоль для отладки.
            System.err.println("Не удалось загрузить изображение.");
            return;
        }

        // Создаем компонент для отображения изображения
        JLabel imageLabel = new JLabel(new ImageIcon(image));

        // Добавляем компонент на панель содержимого окна
        Container contentPane = frame.getContentPane();
        contentPane.add(imageLabel);

        // Устанавливаем размер окна
        frame.pack();

        // Отображаем окно
        frame.setVisible(true);
    }
}