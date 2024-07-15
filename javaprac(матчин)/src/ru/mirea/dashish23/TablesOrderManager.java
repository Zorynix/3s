package ru.mirea.dashish23;

import java.util.HashMap;

public class TablesOrderManager {
    private HashMap orders;

    public TablesOrderManager() {
        this.orders = new HashMap<Integer, InternetOrder>();
    }

    public void add(InternetOrder order, int tableNumber) {
        if (!orders.containsKey(tableNumber) && tableNumber != 0) {
            orders.put(tableNumber, order);
        }
        else System.out.println("Adding error");
    }
    public InternetOrder getOrder(int tableNumber) {
        return (InternetOrder) orders.get(tableNumber);
    };
    public void addDish(Item dish, int tableNumber) {
        InternetOrder o = (InternetOrder) orders.get(tableNumber);
        o.add(dish);
    }
    public void removeOrder(int tableNumber) {
        orders.remove(tableNumber);
        orders.put(tableNumber, null);
    }
    public int freeTableNumber() {
        for (Object i : orders.keySet()) {
            if (orders.get(i) == null) return (Integer) i;
        }
        return 0;
    }
    public int[] freeTableNumbers() {
        int c = 0;
        for (Object i : orders.keySet()) {
            if (orders.get(i) == null) {
                c++;
            };
        }
        int[] temp = new int[c];
        c = 0;
        for (Object i : orders.keySet()) {
            if (orders.get(i) == null) {
                temp[c] = (Integer) i;
                c++;
            };
        }
        return temp;
    }
    public InternetOrder[] getOrders() {
        int  c = 0;
        for (Object i : orders.values()) {
            if (i != null) c++;
        }
        InternetOrder[] temp = new InternetOrder[c];
        c = 0;
        for (Object i : orders.values()) {
            if (i != null) {
                temp[c] = (InternetOrder) i;
                c++;
            }
        }
        return temp;
    }
    public double ordersCostSummary() {
        int c = 0;
        for (Object i : orders.values()) {
            if (i != null)
                c += ((InternetOrder) i).costTotal();
        }
        return c;
    }
    public int dishQuantity(String dishName) {
        int c = 0;
        for (Object i : orders.values()) {
            if (i != null)
                c  += ((InternetOrder) i).dishQuantity(dishName);
        }
        return c;
    }
}
