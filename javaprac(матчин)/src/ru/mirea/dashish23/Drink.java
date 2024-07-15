package ru.mirea.dashish23;

public final class Drink implements Item {
    private final double cost;
    private final String name;
    private final String description;
    private static final int price_null = 0;
    public Drink(String name, String decript) {
        this.name = name;
        this.description = decript;
        this.cost = price_null;
    }

    public Drink(double price, String name, String description) {
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
