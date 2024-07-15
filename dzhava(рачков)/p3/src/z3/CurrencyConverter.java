package z3;

public class CurrencyConverter {
    private double[] exchangeRates;

    // Конструктор класса, принимающий массив обменных курсов
    public CurrencyConverter(double[] exchangeRates) {
        this.exchangeRates = exchangeRates;
    }

    // Метод для конвертации валюты
    public double convert(double amount, int fromCurrencyIndex, int toCurrencyIndex) {
        if (fromCurrencyIndex == toCurrencyIndex) {
            return amount; // Если исходная и целевая валюты совпадают, возвращаем сумму без изменений
        }
        if (fromCurrencyIndex >= 0 && fromCurrencyIndex < exchangeRates.length &&
                toCurrencyIndex >= 0 && toCurrencyIndex < exchangeRates.length) {
            return amount * exchangeRates[toCurrencyIndex] / exchangeRates[fromCurrencyIndex];
            // Иначе производим конвертацию, учитывая обменные курсы
        } else {
            throw new IllegalArgumentException("Invalid currency index");
            // В случае недопустимых индексов валют выбрасываем исключение
        }
    }

    public static void main(String[] args) {
        double[] exchangeRates = {1.0, 0.85, 110.72}; // Обменные курсы для USD, EUR и JPY
        CurrencyConverter converter = new CurrencyConverter(exchangeRates);

        double amountInUSD = 100.0;
        double amountInEUR = converter.convert(amountInUSD, 0, 1);
        double amountInJPY = converter.convert(amountInUSD, 0, 2);

        // Вывод результатов конвертации валюты
        System.out.printf("%.2f USD is equivalent to %.2f EUR%n", amountInUSD, amountInEUR);
        System.out.printf("%.2f USD is equivalent to %.2f JPY%n", amountInUSD, amountInJPY);
    }
}