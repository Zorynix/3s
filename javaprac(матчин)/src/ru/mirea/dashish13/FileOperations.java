package ru.mirea.dashish13;

import java.io.*;
import java.util.Scanner;

public class FileOperations {
    public static void main(String[] args) {
        writeToTextFile();
        readFromTextFile();
        replaceInTextFile();
        appendToTextFile();
    }

    public static void writeToTextFile() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("file.txt"));
            Scanner scanner = new Scanner(System.in);

            System.out.println("Введите информацию для записи в файл:");
            String input = scanner.nextLine();

            writer.write(input);
            writer.close();
            System.out.println("Информация успешно записана в файл.");
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }

    public static void readFromTextFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("file.txt"));
            String line;

            System.out.println("Информация из файла:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            reader.close();
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }

    public static void replaceInTextFile() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("file.txt"));
            Scanner scanner = new Scanner(System.in);

            System.out.println("Введите новую информацию для замены в файле:");
            String input = scanner.nextLine();

            writer.write(input);
            writer.close();
            System.out.println("Информация успешно заменена в файле.");
        } catch (IOException e) {
            System.out.println("Ошибка при замене информации в файле: " + e.getMessage());
        }
    }

    public static void appendToTextFile() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("file.txt", true));
            Scanner scanner = new Scanner(System.in);

            System.out.println("Введите текст для добавления в файл:");
            String input = scanner.nextLine();

            writer.newLine(); // Добавляем новую строку перед вводом текста
            writer.write(input);
            writer.close();
            System.out.println("Текст успешно добавлен в файл.");
        } catch (IOException e) {
            System.out.println("Ошибка при добавлении текста в файл: " + e.getMessage());
        }
    }
}
