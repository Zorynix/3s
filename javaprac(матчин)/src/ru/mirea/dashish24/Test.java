package ru.mirea.dashish24;

public class Test {
    public static void main(String[] args) {
        InternetOrder io = new InternetOrder();
        RestaurantOrder ro = new RestaurantOrder();

        io.add(new Dish(120,"Картофель по-деревенски","Состав: картофель..."));
        io.add(new Dish(200,"Свинина пикантная","Состав: свинина..."));
        io.add(new Dish(200,"Свинина пикантная","Состав: свинина..."));
        io.add(new Drink(20,"Смузи","Состав: молоко..."));
        io.add(new Dish(200,"Свинина пикантная","Состав: свинина..."));
        ro.add(new Dish(500,"Стейк из говядины","Прожарка средняя"));
        ro.add(new Drink(100,"Сок яблочный","С мякотью"));

        System.out.println("--- Заказ ----");
        ro.testPrint();
        System.out.println("--- Интернет-заказ ----");
        io.testPrint();

        io.removeAll("Свинина пикантная");
        System.out.println("----Удаление блюда 'Свинина пикантная' из интернет-заказа -----");
        io.testPrint();

        System.out.println("----Заказанные блюда (интернет-заказ)-----");
        for (Item i : io.getItems())
            System.out.println(i.getName());

        System.out.println("Стоимость заказа  (заказ): " + ro.costTotal());
        System.out.println("Стоимость заказа  (интернет-заказ): " + io.costTotal());


        System.out.println("----Позиции заказа (убывающие) для интернет-заказа-----");
        for (Item i : ro.sortedItemsByCost())
            System.out.println(i.getName() + ", итог = " + i.getCost());


        System.out.println("---- Менеджер заказов -----");

        OrderManager t = new OrderManager();

        t.add(ro,2);
        System.out.println("Интернет-заказ привязан к столу 1");
        t.add(io,1);
        System.out.println("Заказ привязан к столу 1");
        if (t.setClient(ro,"Иванов А.А.")) System.out.println("Заказ выполнен клиентом Иванов А.А.");

        for (Order i : t.getOrders())
            System.out.println("Общая сумма по заказам: " + i.costTotal());

        System.out.println("Стоимость заказа за столом 1: " + t.getOrder(1).costTotal());
        System.out.println("Стоимость заказа за столом 2: " + t.getOrder(2).costTotal());
        t.removeOrder(1);
        System.out.println("Освобожден стол 1");
        System.out.println("Свободный стол: " + t.freeTableNumber());
        t.removeOrder(2);
        System.out.println("Освобожден стол 2");
        System.out.println("---Свободные столы---");
        for (int i : t.freeTableNumbers())
            System.out.println(i);
    }
}
