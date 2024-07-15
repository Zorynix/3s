package ru.mirea.dashish23;

public class Test {
    public static void main(String[] args) {
        InternetOrder o = new InternetOrder();
        o.add(new Dish(17,"Rak","Rak 1"));
        o.add(new Dish(102,"Cow","Cow 1"));
        o.add(new Dish(102,"Cow","Cow 2"));
        o.add(new Drink(15,"Juice",""));
        o.add(new Drink(15,"Juice",""));
        o.add(new Dish(17,"Rak","Rak 2"));
        o.testPrint();

        o.removeAll("Rak");
        o.remove("Cow");
        System.out.println("----Удаление-----");
        o.testPrint();

        System.out.println("----Заказанные блюда-----");
        for (Item i : o.getItems())
            System.out.println(i.getName());

        System.out.println("Стоимость заказа: " + o.costTotal());
        System.out.println("Кол-во заказанных блюд Cow: " + o.dishQuantity("Cow"));
        System.out.println("Кол-во заказанных напитков Juice: " + o.dishQuantity("Juice"));
        System.out.println("Кол-во позиций заказа: " + o.dishQuantity());
        System.out.println("----Заказанные блюда (без повтора)-----");
        for (String i : o.itemsName())
            System.out.println(i);

        System.out.println("----Позиции заказа (убывающие)-----");
        for (Item i : o.sortedItemsByCost())
            System.out.println(i.getName() + ", cost = " + i.getCost());

        System.out.println("---Заказы---");
        TablesOrderManager t = new TablesOrderManager();
        InternetOrder o2 = new InternetOrder();
        o2.add(new Dish(170,"Mango",""));

        t.add(o,1);
        t.add(o2,1);
        t.add(o2,2);
        for (InternetOrder i : t.getOrders())
            System.out.println("Стоимость: " + i.costTotal());
        System.out.println("Стоимость заказа за столом 1: " + t.getOrder(1).costTotal());
        t.addDish(new Drink(200, "Apple Juice",""),2);
        System.out.println("В заказ стола 2 добавлена 1 позиция: Apple Juice, 200");
        System.out.println("Стоимость заказа за столом 2: " + t.getOrder(2).costTotal());
        t.removeOrder(1);
        System.out.println("---Заказы после удаления---");
        for (InternetOrder i : t.getOrders())
            System.out.println("Стоимость: " + i.costTotal());
        System.out.println("Свободный стол: " + t.freeTableNumber());
        t.removeOrder(2);
        System.out.println("---Свободные столы---");
        for (int i : t.freeTableNumbers())
            System.out.println(i);

        InternetOrder o3 = new InternetOrder();
        o3.add(new Dish(260,"Tomato",""));
        o3.add(new Drink(160,"Tomato Super",""));
        InternetOrder o4 = new InternetOrder();
        o4.add(new Drink(180,"Tomato Super",""));

        t.add(o3,3);
        t.add(o4,5);

        System.out.println("---Заказы после добавления---");
        for (InternetOrder i : t.getOrders())
            System.out.println("Стоимость: " + i.costTotal());
        System.out.println("Сумма по всем заказам: " + t.ordersCostSummary());
        System.out.println("Кол-во блюд Tomato Super по заказам: " + t.dishQuantity("Tomato Super"));
    }
}
