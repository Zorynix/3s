package ru.mirea.lab4.task2;

// Пример использования
public class Main {
    public static void main(String[] args) {
        // Создаем массивы с конкретными предметами одежды
        MenClothing[] menClothes = {
                new TShirt(Size.XS, 25.0, "Red"),   // Мужская футболка, размер XS, стоимость 25.0, красная
                new Pants(Size.M, 50.0, "Blue"),    // Мужские штаны, размер M, стоимость 50.0, синие
                new Tie(Size.L, 15.0, "Striped")    // Галстук, размер L, стоимость 15.0, полосатый
        };

        WomenClothing[] womenClothes = {
                new TShirt(Size.XS, 25.0, "Pink"),   // Женская футболка, размер XS, стоимость 25.0, розовая
                new Skirt(Size.S, 40.0, "Black")    // Юбка, размер S, стоимость 40.0, черная
        };

        // Передаем массивы в методы ателье для одевания
        Atelier.dressMan(menClothes);   // Одеваем мужчин
        Atelier.dressWomen(womenClothes); // Одеваем женщин
    }
}
