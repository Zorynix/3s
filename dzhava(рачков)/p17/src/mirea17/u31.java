package mirea17;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

// Модель
class TaskModel {
    private List<String> tasks = new ArrayList<>(); // Список задач

    public void addTask(String task) {
        tasks.add(task); // Метод для добавления задачи в список
    }

    public List<String> getTasks() {
        return tasks; // Метод для получения списка задач
    }
}

// Представление (графический интерфейс пользователя)
class TaskView extends JFrame {
    private DefaultListModel<String> listModel; // Модель для списка задач
    private JList<String> taskList;             // Список задач на GUI
    private JTextField taskField;               // Поле для ввода новой задачи
    private JButton addButton;                  // Кнопка для добавления задачи

    public TaskView() {
        setTitle("To-Do List");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);
        taskField = new JTextField(20);
        addButton = new JButton("Add Task");

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(taskField, BorderLayout.CENTER);
        panel.add(addButton, BorderLayout.EAST);

        add(taskList, BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);
    }

    // Метод для получения текста новой задачи из поля ввода и очистки поля
    public String getNewTask() {
        String newTask = taskField.getText();
        taskField.setText("");
        return newTask;
    }

    // Метод для установки списка задач в представлении
    public void setTaskList(List<String> tasks) {
        listModel.clear();
        for (String task : tasks) {
            listModel.addElement(task);
        }
    }

    // Метод для добавления слушателя кнопки
    public void addAddButtonListener(ActionListener listener) {
        addButton.addActionListener(listener);
    }
}

// Контроллер
class TaskController {
    private TaskModel model;
    private TaskView view;

    public TaskController(TaskModel model, TaskView view) {
        this.model = model;
        this.view = view;

        view.addAddButtonListener(new AddButtonListener());
    }

    // Слушатель кнопки добавления задачи
    class AddButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String newTask = view.getNewTask(); // Получаем текст новой задачи из поля ввода
            if (!newTask.isEmpty()) {
                model.addTask(newTask); // Добавляем задачу в модель
                view.setTaskList(model.getTasks()); // Обновляем список задач в представлении
            }
        }
    }
}


public class u31 {
    public static void main(String[] args) {
        TaskModel model = new TaskModel();
        TaskView view = new TaskView();
        TaskController controller = new TaskController(model, view);

        view.setVisible(true);
    }
}