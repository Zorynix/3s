package mirea24;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Интерфейс для всех типов документов
interface IDocument {
    void open();
    void save();
}

// Конкретная реализация текстового документа
class TextDocument implements IDocument {
    @Override
    public void open() {
        System.out.println("Открыт текстовый документ");
    }

    @Override
    public void save() {
        System.out.println("Сохранен текстовый документ");
    }
}

// Фабрика для создания текстовых документов
interface ICreateDocument {
    IDocument createNew();
    IDocument createOpen();
}

// Конкретная реализация фабрики для текстовых документов
class CreateTextDocument implements ICreateDocument {
    @Override
    public IDocument createNew() {
        return new TextDocument();
    }

    @Override
    public IDocument createOpen() {
        return new TextDocument();
    }
}

// Главное окно приложения Swing
class MainFrame extends JFrame {
    private Editor textEditor;

    public MainFrame() {
        // Создаем фабрику для текстовых документов
        ICreateDocument textDocumentFactory = new CreateTextDocument();

        // Создаем редактор с фабрикой для текстовых документов
        textEditor = new Editor(textDocumentFactory);

        // Создаем меню File
        JMenu fileMenu = new JMenu("File");
        JMenuItem newMenuItem = new JMenuItem("New");
        JMenuItem openMenuItem = new JMenuItem("Open");
        JMenuItem saveMenuItem = new JMenuItem("Save");
        JMenuItem exitMenuItem = new JMenuItem("Exit");

        // Добавляем обработчики событий для пунктов меню
        newMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // создание нового документа
                textEditor.openDocument();
            }
        });

        openMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // открытие существующего документа
                textEditor.openDocument();
            }
        });

        saveMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // сохранение документа
                textEditor.saveDocument();
            }
        });

        exitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        fileMenu.add(newMenuItem);
        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.add(exitMenuItem);

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(fileMenu);

        setJMenuBar(menuBar);

        setTitle("Текстовый Редактор");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

// Каркас приложения - редактор
class Editor {
    private IDocument document;
    private ICreateDocument documentFactory;

    public Editor(ICreateDocument factory) {
        this.documentFactory = factory;
        this.document = documentFactory.createNew();
    }

    public void openDocument() {
        document.open();
    }

    public void saveDocument() {
        document.save();
    }
}

// Запуск приложения
public class u3 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame();
            }
        });
    }
}