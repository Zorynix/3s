package mirea15;
//Разработайте программу выбора меню как на рис. 15.8 ниже. Вам
//понадобится JComboBox.
import javax.swing.*;             // для создания графического интерфейса
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class u2 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Выбор меню");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);

        // Создаем панель для размещения компонентов
        JPanel panel = new JPanel();
        frame.add(panel);

        JLabel label = new JLabel("Информация о стране:");
        panel.add(label); // Добавляем метку на панель

        // Создаем выпадающий список
        String[] countries = {"Россия", "США", "Германия", "Франция", "Япония"};
        JComboBox<String> comboBox = new JComboBox<>(countries);  // Создаем выпадающий список
        panel.add(comboBox);

        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedCountry = (String) comboBox.getSelectedItem();  // Получаем выбранную страну из списка

                // Обновляем метку с информацией о стране
                label.setText("Информация о стране: " + selectedCountry);              }
        });


        frame.setVisible(true);
    }
}