package mirea12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class u3 extends JPanel implements ActionListener {
    private Timer timer;
    private int currentFrame = 0;
    private int totalFrames = 8; // Общее количество кадров в анимации
    private ImageIcon[] frames;

    public u3() {
        // Загрузка изображений для анимации
        frames = new ImageIcon[totalFrames];
        for (int i = 0; i < totalFrames; i++) {
            frames[i] = new ImageIcon("C:\\Users\\Veronika\\IdeaProjects\\p12\\src\\mirea12\\image_part_00" + i + ".png");
        }


        // Инициализация таймера для анимации
        int delay = 100; // Задержка между кадрами (в миллисекундах)
        timer = new Timer(delay, this);//представляет собой инициализацию объекта Timer в Java,
        // который будет генерировать события с указанной задержкой (delay).
        // В данной строке также устанавливается объект,
        // который будет слушать события таймера и реагировать на них, используя ключевое слово this.
        timer.start();
    }
// последовательная отрисовка компонентов
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (currentFrame < totalFrames) {
            frames[currentFrame].paintIcon(this, g, 0, 0);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        currentFrame = (currentFrame + 1) % totalFrames; // Переход к следующему кадру
        repaint(); // Перерисовываем компонент для отображения нового кадра
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Animation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        u3 animationWindow = new u3();
        frame.add(animationWindow);

        frame.setVisible(true);
    }
}
