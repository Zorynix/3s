package ru.mirea.dashish24;

public class OrderAlreadyAddedException extends Exception {
    public OrderAlreadyAddedException() {
        super("С указанным столиком уже связан заказ");
    }
}
