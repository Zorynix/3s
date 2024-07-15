package ru.mirea.dashish24;

public final class Dish implements Item {
    private final double cost;
    private final String name;
    private final String description;
    private static final int price_null = 0;
    public Dish(double price, String name, String description) {
        if (price < 0 | name.isEmpty() | description.isEmpty()) throw new IllegalArgumentException();
        this.cost = price;
        this.name = name;
        this.description = description;
    }

    public double getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
