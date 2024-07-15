package ru.mirea.dashish24;

public class IllegalTableNumber extends RuntimeException {
    public IllegalTableNumber(int n) {
        super("Не существует столика с номером " + n);
    }
}
