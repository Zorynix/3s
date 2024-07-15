package ru.mirea.dashish12;

import java.util.Stack;

public class StackExample {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        // Добавление элементов в стек
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // Удаление элемента из стека
        int popped = stack.pop();
        System.out.println("Удаленный элемент из стека: " + popped);

        // Получение верхнего элемента без удаления
        int peeked = stack.peek();
        System.out.println("Верхний элемент стека: " + peeked);
    }
}
