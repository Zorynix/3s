package ru.mirea.dashish24;

import java.util.HashMap;

public class OrderManager {
    private HashMap orders;
    private HashMap orders_clients;

    public OrderManager() {
        this.orders = new HashMap<Integer, Order>();
        this.orders_clients = new HashMap<String, Order>();
    }

    public boolean setClient(Order order, String client) {
        if (orders.containsValue(order)) {
            orders_clients.put(client,order);
            return true;
        }
        return false;
    }

    public void add(Order order, int tableNumber) {
            if (tableNumber != 0) {
                orders.put(tableNumber, order);
            } else if (!order.getClass().equals(InternetOrder.class))
                throw new IllegalTableNumber(tableNumber);
    }
    public Order getOrder(int tableNumber) {
        return (Order) orders.get(tableNumber);
    };
    public void addDish(Item dish, int tableNumber) {
        if (orders.containsKey(tableNumber) && tableNumber != 0) {
            Order o = (Order) orders.get(tableNumber);
            o.add(dish);
        } else throw new IllegalTableNumber(tableNumber);
    }
    public void removeOrder(int tableNumber) {
        if (orders.containsKey(tableNumber) && tableNumber != 0) {
            orders.remove(tableNumber);
            orders.put(tableNumber, null);
        } else throw new IllegalTableNumber(tableNumber);
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
    public Order[] getOrders() {
        int  c = 0;
        for (Object i : orders.values()) {
            if (i != null) c++;
        }
        Order[] temp = new Order[c];
        c = 0;
        for (Object i : orders.values()) {
            if (i != null) {
                temp[c] = (Order) i;
                c++;
            }
        }
        return temp;
    }
    public double ordersCostSummary() {
        int c = 0;
        for (Object i : orders.values()) {
            if (i != null)
                c += ((Order) i).costTotal();
        }
        return c;
    }
    public int dishQuantity(String dishName) {
        int c = 0;
        for (Object i : orders.values()) {
            if (i != null)
                c  += ((Order) i).dishQuantity(dishName);
        }
        return c;
    }
}
