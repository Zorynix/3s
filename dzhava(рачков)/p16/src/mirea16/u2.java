import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class u2 {
    private JFrame frame;
    private JTextArea textArea;

    public u2() {
        createUI();
        addEventHandlers();
    }

    private void createUI() {
        frame = new JFrame("Текстовый редактор");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        textArea = new JTextArea();
        textArea.setFont(new Font("Times New Roman", Font.PLAIN, 14));

        JMenuBar menuBar = new JMenuBar();
        JMenu colorMenu = new JMenu("Цвет");
        JMenu fontMenu = new JMenu("Шрифт");

        JMenuItem[] colorItems = {new JMenuItem("Синий"), new JMenuItem("Красный"), new JMenuItem("Черный")};
        JMenuItem[] fontItems = {new JMenuItem("Times New Roman"), new JMenuItem("MS Sans Serif"), new JMenuItem("Courier New")};

        colorMenu.add(colorItems[0]);
        colorMenu.add(colorItems[1]);
        colorMenu.add(colorItems[2]);

        fontMenu.add(fontItems[0]);
        fontMenu.add(fontItems[1]);
        fontMenu.add(fontItems[2]);

        menuBar.add(colorMenu);
        menuBar.add(fontMenu);

        frame.setJMenuBar(menuBar);

        // Добавляем кнопку "Сохранить"
        JButton saveButton = new JButton("Сохранить");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveTextToFile(); // Вызываем метод для сохранения текста в файл
            }
        });
        frame.add(saveButton, BorderLayout.SOUTH);

        frame.add(new JScrollPane(textArea));
        frame.setVisible(true);
    }

    private void addEventHandlers() {
        JMenuItem[] colorItems = {new JMenuItem("Синий"), new JMenuItem("Красный"), new JMenuItem("Черный")};
        JMenuItem[] fontItems = {new JMenuItem("Times New Roman"), new JMenuItem("MS Sans Serif"), new JMenuItem("Courier New")};

        // Добавляем обработчики событий для пунктов меню выбора цвета
        for (int i = 0; i < colorItems.length; i++) {
            final int index = i;
            colorItems[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    changeTextColor(index); // Вызываем метод для изменения цвета текста
                }
            });
        }

        // Добавляем обработчики событий для пунктов меню выбора шрифта
        for (int i = 0; i < fontItems.length; i++) {
            final int index = i;
            fontItems[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    changeTextFont(index); // Вызываем метод для изменения шрифта текста
                }
            });
        }
    }

    private void changeTextColor(int index) {
        Color[] colors = {Color.BLUE, Color.RED, Color.BLACK};
        textArea.setForeground(colors[index]);
    }

    private void changeTextFont(int index) {
        String[] fontNames = {"Times New Roman", "MS Sans Serif", "Courier New"};
        textArea.setFont(new Font(fontNames[index], Font.PLAIN, 14));
    }

    private void saveTextToFile() {
        String filePath = System.getProperty("user.home") + "/Desktop/text.txt";
        File fileToSave = new File(filePath);
        try (FileWriter writer = new FileWriter(fileToSave)) {
            writer.write(textArea.getText());
            JOptionPane.showMessageDialog(frame, "Текст успешно сохранен в файл!");
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Произошла ошибка при сохранении текста.");
        }
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new u2();
            }
        });
    }
}