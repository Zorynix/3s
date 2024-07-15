package ru.mirea.lab4.task3;

import java.util.*;

class OnlineStore {
    private List<User> users;  // Список пользователей
    private Map<Catalog, List<Product>> products;  // Словарь для хранения каталогов товаров
    private List<Product> shoppingCart;  // Список для хранения товаров в корзине
    private Catalog selectedCatalog;  // Выбранный каталог

    // Конструктор для инициализации данных интернет-магазина
    public OnlineStore() {
        users = new ArrayList<>();  // Инициализация списка пользователей
        products = new HashMap<>();  // Инициализация словаря с каталогами
        shoppingCart = new ArrayList<>();  // Инициализация корзины

        // Добавление пользователей и товаров
        users.add(new User("user1", "password1"));
        users.add(new User("user2", "password2"));

        List<Product> electronics = new ArrayList<>();
        electronics.add(new Product("Laptop", 1000.0));
        electronics.add(new Product("Phone", 700.0));
        products.put(Catalog.ELECTRONICS, electronics);

        List<Product> clothing = new ArrayList<>();
        clothing.add(new Product("T-Shirt", 20.0));
        clothing.add(new Product("Jeans", 50.0));
        products.put(Catalog.CLOTHING, clothing);

        List<Product> books = new ArrayList<>();
        books.add(new Product("Java Programming", 40.0));
        books.add(new Product("History of Science", 30.0));
        products.put(Catalog.BOOKS, books);
    }

    // Метод для аутентификации пользователя
    public boolean authenticate(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;  // Если пользователь найден, возвращаем true
            }
        }
        return false;  // Если пользователь не найден, возвращаем false
    }

    // Метод для просмотра списка каталогов
    public void viewCatalogs() {
        for (Catalog catalog : products.keySet()) {
            System.out.println(catalog);
        }
    }

    // Метод для выбора каталога
    public void selectCatalog(Catalog catalog) {
        if (products.containsKey(catalog)) {
            selectedCatalog = catalog;
            System.out.println("Выбранный каталог: " + catalog);
        } else {
            System.out.println("Каталог не найден");
        }
    }

    // Метод для просмотра товаров в выбранном каталоге
    public void viewProductsInSelectedCatalog() {
        if (selectedCatalog != null) {
            List<Product> productList = products.get(selectedCatalog);
            for (Product product : productList) {
                System.out.println(product);
            }
        } else {
            System.out.println("Ни один каталог не выбран");
        }
    }

    // Метод для добавления товара в корзину
    public void addToCart(Product product) {
        shoppingCart.add(product);
    }

    // Метод для совершения покупки
    public void purchase() {
        double total = 0.0;
        for (Product product : shoppingCart) {
            total += product.getPrice();
        }
        System.out.println("Общая стоимость вашей корзины: $" + total);
        shoppingCart.clear();  // Очистка корзины после покупки
    }

    // Метод для отображения содержимого корзины
    public void showShoppingCart() {
        if (shoppingCart.isEmpty()) {
            System.out.println("Корзина пуста");
        } else {
            System.out.println("Товары в корзине:");
            for (Product product : shoppingCart) {
                System.out.println(product);
            }
        }
    }

    // Метод для добавления товара в корзину через консольный ввод
    public void addToCartFromConsole() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите каталог и товар для добавления в корзину:");
        viewCatalogs();

        System.out.print("Введите имя каталога: ");
        String catalogName = scanner.nextLine();

        Catalog selectedCatalog = Catalog.valueOf(catalogName.toUpperCase());
        selectCatalog(selectedCatalog);

        viewProductsInSelectedCatalog();

        System.out.print("Введите имя товара: ");
        String productName = scanner.nextLine();

        List<Product> productList = products.get(selectedCatalog);
        boolean found = false;

        for (Product product : productList) {
            if (product.getName().equalsIgnoreCase(productName)) {
                addToCart(product);
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("Товар добавлен в корзину");
        } else {
            System.out.println("Товар не найден");
        }
    }
}
