package ru.mirea.dashish12;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите 5 карт игрока 1");
        if (!scanner.hasNextInt()) {
            System.out.println("Ошибка при вводе.");
            return;
        }
        String firstPlayer = scanner.nextLine();
        System.out.println("Введите 5 карт игрока 2");
        if (!scanner.hasNextInt()) {
            System.out.println("Ошибка при вводе");
            return;
        }
        String secondPlayer = scanner.nextLine();
        if (firstPlayer.length() != 5 || secondPlayer.length() != 5) {
            System.out.println("Ошибка при вводе.");
            return;
        }
        int p1 = Integer.parseInt(firstPlayer);
        int p2 = Integer.parseInt(secondPlayer);
        int[] cardsCount = new int[10];
        for (int i = 0; i < 5; i++) {
            cardsCount[p1 % 10] += 1;
            cardsCount[p2 % 10] += 1;
            p1 /= 10;
            p2 /= 10;
        }
        for (int i = 0; i < cardsCount.length; i++) {
            if (cardsCount[i] != 1) {
                System.out.println("Ошибка при вводе");
                return;
            }
        }
        Queue<Integer> firstPlayerQueue = new LinkedList<>();
        Queue<Integer> secondPlayerQueue = new LinkedList<>();

        for (int i = 0; i < 5; i++) {
            firstPlayerQueue.add(Integer.valueOf(firstPlayer.charAt(i)));
            secondPlayerQueue.add(Integer.valueOf(secondPlayer.charAt(i)));
        }
        int count = 0;
        while (count <= 106) {
            int firstPlayerCard = firstPlayerQueue.poll();
            int secondPlayerCard = secondPlayerQueue.poll();
            if (firstPlayerCard == '0' && secondPlayerCard == '9') {
                firstPlayerQueue.add(firstPlayerCard);
                firstPlayerQueue.add(secondPlayerCard);
            } else if (firstPlayerCard == '9' && secondPlayerCard == '0') {
                secondPlayerQueue.add(secondPlayerCard);
                secondPlayerQueue.add(firstPlayerCard);
            } else if (firstPlayerCard > secondPlayerCard) {
                firstPlayerQueue.add(firstPlayerCard);
                firstPlayerQueue.add(secondPlayerCard);
            } else if (secondPlayerCard > firstPlayerCard) {
                secondPlayerQueue.add(secondPlayerCard);
                secondPlayerQueue.add(firstPlayerCard);
            }
            count++;

            if (firstPlayerQueue.isEmpty()) {
                System.out.println("second " + count);
                return;
            }
            if (secondPlayerQueue.isEmpty()) {
                System.out.println("first " + count);
                return;
            }
        }
        System.out.println("botva");
    }
}
