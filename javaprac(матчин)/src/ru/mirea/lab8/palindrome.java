package ru.mirea.lab8;  // Пакет, к которому принадлежит класс

import java.util.Scanner;  // Импорт класса Scanner из пакета java.util

public class palindrome {  // Объявление класса palindrome
    public static void main(String[] args) {  // Главный метод программы
        Scanner scanner = new Scanner(System.in);  // Создание объекта Scanner для чтения ввода пользователя
        System.out.print("Введите слово: \n");  // Печать приглашения пользователю
        String word = scanner.nextLine();  // Считывание введенного слова

        if (isPalindrome(word)) {  // Если введенное слово палиндром
            System.out.println("YES");  // Печать "YES"
        } else {  // В противном случае
            System.out.println("NO");  // Печать "NO"
        }
    }

    public static boolean isPalindrome(String word) {  // Метод для проверки, является ли слово палиндромом
        if (word.length() <= 1) {  // Если длина слова меньше или равна 1
            return true;  // Возвращаем true, так как односимвольное слово считается палиндромом
        } else {  // В противном случае
            char firstChar = word.charAt(0);  // Получаем первый символ слова
            char lastChar = word.charAt(word.length() - 1);  // Получаем последний символ слова
            if (firstChar == lastChar) {  // Если первый и последний символы совпадают
                String subWord = word.substring(1, word.length() - 1);  // Создаем подстроку без первого и последнего символов
                return isPalindrome(subWord);  // Рекурсивно вызываем isPalindrome для этой подстроки
            } else {  // Если первый и последний символы не совпадают
                return false;  // Возвращаем false, так как слово не является палиндромом
            }
        }
    }
}
