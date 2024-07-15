package ru.mirea.lab5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FootballMatchSimulator extends JFrame implements ActionListener {
    // Переменные для хранения счета
    private int milanScore = 0;
    private int madridScore = 0;

    // Компоненты GUI
    private JButton milanButton;
    private JButton madridButton;
    private JLabel resultLabel;
    private JLabel lastScorerLabel;
    private JLabel winnerLabel;

    // Конструктор класса
    public FootballMatchSimulator() {
        // Настройка фрейма
        setTitle("Football Match Simulator");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Создание компонентов
        milanButton = new JButton("AC Milan");
        madridButton = new JButton("Real Madrid");
        resultLabel = new JLabel("Result: 0 X 0");
        lastScorerLabel = new JLabel("Last Scorer: N/A");
        winnerLabel = new JLabel("Winner: DRAW");

        // Установка layout
        setLayout(new GridLayout(5, 1));

        // Добавление компонентов на панель
        add(milanButton);
        add(madridButton);
        add(resultLabel);
        add(lastScorerLabel);
        add(winnerLabel);

        // Добавление слушателей событий кнопок
        milanButton.addActionListener(this);
        madridButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Обработка нажатий кнопок
        if (e.getSource() == milanButton) {
            milanScore++;
            lastScorerLabel.setText("Last Scorer: AC Milan");
        } else if (e.getSource() == madridButton) {
            madridScore++;
            lastScorerLabel.setText("Last Scorer: Real Madrid");
        }

        // Обновление отображаемого счета
        resultLabel.setText("Result: " + milanScore + " X " + madridScore);

        // Определение победителя
        if (milanScore > madridScore) {
            winnerLabel.setText("Winner: AC Milan");
        } else if (madridScore > milanScore) {
            winnerLabel.setText("Winner: Real Madrid");
        } else {
            winnerLabel.setText("Winner: DRAW");
        }
    }

    public static void main(String[] args) {
        // Запуск приложения
        SwingUtilities.invokeLater(() -> {
            FootballMatchSimulator simulator = new FootballMatchSimulator();
            simulator.setVisible(true);
        });
    }
}
