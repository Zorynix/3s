package mirea13;

import java.util.StringTokenizer;

public class u3 {
    private String country; // страна
    private String region;  // регион
    private String city;    // город
    private String street;  // улица
    private String house;   // дом
    private String building;// корпус
    private String apartment;// квартира

    public u3(String addressString, String delimiter) {
        if (delimiter.equals(",")) {
            String[] parts = addressString.split(delimiter);
            if (parts.length >= 7) {
                country = parts[0].trim();
                region = parts[1].trim();
                city = parts[2].trim();
                street = parts[3].trim();
                house = parts[4].trim();
                building = parts[5].trim();
                apartment = parts[6].trim();
                //trim() - удаляет пробелы в начале и конце строки
            }
        } else if (delimiter.matches("[.,;]")) { //matches - ищет соответствие регулярке
            // Разбиение строки с использованием класса StringTokenizer
            StringTokenizer tokenizer = new StringTokenizer(addressString, delimiter);
            if (tokenizer.countTokens() >= 7) {
                country = tokenizer.nextToken().trim();
                region = tokenizer.nextToken().trim();
                city = tokenizer.nextToken().trim();
                street = tokenizer.nextToken().trim();
                house = tokenizer.nextToken().trim();
                building = tokenizer.nextToken().trim();
                apartment = tokenizer.nextToken().trim();
            }
        }
    }

    public String getCountry() {
        return country;
    }

    public String getRegion() {
        return region;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getHouse() {
        return house;
    }

    public String getBuilding() {
        return building;
    }

    public String getApartment() {
        return apartment;
    }

    public static void main(String[] args) {
        String addressString1 = "Россия, Московская область, Москва, Ленинский проспект, 123, 2, 45";
        String addressString2 = "США; Калифорния; Лос-Анджелес; Главная улица; 456; ; 789";

        // Создание объектов u3 с разными разделителями
        u3 address1 = new u3(addressString1, ",");
        u3 address2 = new u3(addressString2, "[.,;]");

        System.out.println("Адрес 1:");
        System.out.println("Страна: " + address1.getCountry());
        System.out.println("Регион: " + address1.getRegion());
        System.out.println("Город: " + address1.getCity());
        System.out.println("Улица: " + address1.getStreet());
        System.out.println("Дом: " + address1.getHouse());
        System.out.println("Корпус: " + address1.getBuilding());
        System.out.println("Квартира: " + address1.getApartment());

        System.out.println("\nАдрес 2:");
        System.out.println("Страна: " + address2.getCountry());
        System.out.println("Регион: " + address2.getRegion());
        System.out.println("Город: " + address2.getCity());
        System.out.println("Улица: " + address2.getStreet());
        System.out.println("Дом: " + address2.getHouse());
        System.out.println("Корпус: " + address2.getBuilding());
        System.out.println("Квартира: " + address2.getApartment());
    }
}
