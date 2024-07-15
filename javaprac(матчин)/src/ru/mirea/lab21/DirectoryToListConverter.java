package ru.mirea.lab21;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DirectoryToListConverter {
    public static void main(String[] args) {
        File directory = new File("C:\\Users\\Alex\\Pictures\\Screenshots");
        List<String> fileList = convertDirectoryToList(directory);

        // Вывод первых 5 элементов списка на экран
        System.out.println("Первые 5 элементов списка:");
        for (int i = 0; i < Math.min(5, fileList.size()); i++) {
            System.out.println(fileList.get(i));
        }
    }

    public static List<String> convertDirectoryToList(File directory) {
        List<String> fileList = new ArrayList<>();
        if (directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    fileList.add(file.getName());
                }
            }
        }
        return fileList;
    }
}
