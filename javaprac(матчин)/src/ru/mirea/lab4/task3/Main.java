package ru.mirea.lab4.task3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        OnlineStore store = new OnlineStore(); // Создаем экземпляр интернет-магазина

        Scanner scanner = new Scanner(System.in); // Создаем объект для ввода с клавиатуры

        System.out.print("Введите имя пользователя: ");
        String username = scanner.nextLine(); // Запрашиваем имя пользователя

        System.out.print("Введите пароль: ");
        String password = scanner.nextLine(); // Запрашиваем пароль

        if (store.authenticate(username, password)) { // Проверяем аутентификацию пользователя
            System.out.println("Авторизация успешна"); // Если успешно, выводим сообщение об успешной авторизации

            while (true) { // Запускаем бесконечный цикл для обработки действий пользователя
                System.out.println("Выберите действие:");
                System.out.println("1. Посмотреть каталоги");
                System.out.println("2. Выбрать каталог");
                System.out.println("3. Посмотреть товары в каталоге");
                System.out.println("4. Добавить товар в корзину");
                System.out.println("5. Посмотреть корзину");
                System.out.println("6. Купить товары");
                System.out.println("0. Выйти");

                int choice = scanner.nextInt(); // Получаем выбор пользователя
                scanner.nextLine(); // Очищаем буфер

                switch (choice) {
                    case 1:
                        store.viewCatalogs(); // Показываем каталоги товаров
                        break;
                    case 2:
                        System.out.print("Введите имя каталога: ");
                        String catalogName = scanner.nextLine(); // Запрашиваем у пользователя имя каталога
                        Catalog selectedCatalog = Catalog.valueOf(catalogName.toUpperCase()); // Преобразуем в enum
                        store.selectCatalog(selectedCatalog); // Выбираем каталог
                        break;
                    case 3:
                        store.viewProductsInSelectedCatalog(); // Показываем товары в выбранном каталоге
                        break;
                    case 4:
                        store.addToCartFromConsole(); // Добавляем товар в корзину
                        break;
                    case 5:
                        store.showShoppingCart(); // Показываем содержимое корзины
                        break;
                    case 6:
                        store.purchase(); // Покупаем товары
                        break;
                    case 0:
                        System.out.println("До свидания!"); // Выводим прощальное сообщение
                        return; // Завершаем выполнение программы
                    default:
                        System.out.println("Неверный выбор. Попробуйте снова."); // Сообщение о неверном выборе
                }
            }
        } else {
            System.out.println("Ошибка авторизации"); // Сообщение об ошибке авторизации
        }
    }
}
