package mirea13;

import java.io.*;
import java.util.*;

public class u6 {
    public static void main(String[] args) throws IOException {
        // Чтение имени файла с консоли
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Введите имя файла: ");
        String fileName = reader.readLine();
        reader.close();

        // Чтение слов из файла
        List<String> words = readWordsFromFile(fileName);

        if (words.isEmpty()) {
            System.out.println("Файл не содержит слов.");
            return;
        }

        // Получение цепочки слов
        List<String> wordChain = getWordChain(words);

        if (wordChain.isEmpty()) {
            System.out.println("Невозможно составить цепочку слов.");
        } else {
            // Вывод цепочки слов на консоль
            for (String word : wordChain) {
                System.out.print(word + " ");
            }
        }
    }

    // Метод для чтения слов из файла
    private static List<String> readWordsFromFile(String fileName) {
        List<String> words = new ArrayList<>();

        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = fileReader.readLine()) != null) {
                String[] lineWords = line.split(" ");
                words.addAll(Arrays.asList(lineWords));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return words;
    }

    // Метод для получения цепочки слов
    private static List<String> getWordChain(List<String> words) {
        List<String> wordChain = new ArrayList<>();
        if (words.isEmpty()) {
            return wordChain;
        }

        // Используем StringBuilder для составления цепочки слов
        StringBuilder sb = new StringBuilder();
        sb.append(words.get(0));
        words.remove(0);

        while (!words.isEmpty()) {
            char lastChar = sb.charAt(sb.length() - 1);
            boolean found = false;

            for (int i = 0; i < words.size(); i++) {
                String word = words.get(i);

                if (Character.toLowerCase(lastChar) == Character.toLowerCase(word.charAt(0))) {
                    sb.append(" ").append(word);
                    words.remove(i);
                    found = true;
                    break;
                }
            }

            if (!found) {
                // Не удалось найти следующее слово для цепочки
                break;
            }
        }

        String[] chainWords = sb.toString().split(" ");
        wordChain.addAll(Arrays.asList(chainWords));
        return wordChain;
    }
}
