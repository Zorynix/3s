package ru.mirea.lab4.task2;

// Импортируем необходимые классы из пакета ru.mirea.lab4.task2

class Atelier {

    // Метод для одевания мужчин
    public static void dressMan(MenClothing[] clothes) {
        for (MenClothing item : clothes) {
            item.dressMan(); // Вызываем метод для одевания мужчин из класса MenClothing
            ((Clothes)item).displayInformation(); // Показываем информацию о одежде с помощью метода displayInformation из класса Clothes
        }
    }

    // Метод для одевания женщин
    public static void dressWomen(WomenClothing[] clothes) {
        for (WomenClothing item : clothes) {
            item.dressWomen(); // Вызываем метод для одевания женщин из класса WomenClothing
            ((Clothes)item).displayInformation(); // Показываем информацию о одежде с помощью метода displayInformation из класса Clothes
        }
    }
}
