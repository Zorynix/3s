package ru.mirea.dashish23;

public final class Dish implements Item {
    private final double cost;
    private final String name;
    private final String description;
    private static final int price_null = 0;
    public Dish(String name, String decript) {
        this.name = name;
        this.description = decript;
        this.cost = price_null;
    }

    public Dish(double price, String name, String description) {
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
