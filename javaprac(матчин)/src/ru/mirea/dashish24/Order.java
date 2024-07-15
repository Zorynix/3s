package ru.mirea.dashish24;

public interface Order {
    boolean add(Item dish);
    boolean remove(String dishName);
    int removeAll(String dishName);
    Item[] getItems();
    double costTotal();
    String[] itemsName();
    int dishQuantity();
    int dishQuantity(String dishName);
    Item[] sortedItemsByCost();

}
