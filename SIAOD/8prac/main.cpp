#include <iostream>
#include <Windows.h>
#include <chrono>

using namespace std;

//Метод динамического программирования
long long countSequences(int n, long long& counter) {
    if (n <= 0) {
        return 0;
    }

    // Создаем динамический двумерный массив для хранения результатов подзадач.
    // dp[i][j] будет содержать количество последовательностей длины i с последним битом j.
    long long **dp = new long long *[n + 1];
    for (int i = 0; i <= n; ++i) {
        dp[i] = new long long[2];
    }

    // Изначально у нас есть одна последовательность длины 1 для каждого бита.
    dp[1][0] = 1;
    dp[1][1] = 1;

    // Заполняем таблицу динамического программирования.
    for (int i = 2; i <= n; ++i) {
        dp[i][0] = dp[i - 1][0] + dp[i - 1][1];
        dp[i][1] = dp[i - 1][0];
        counter += 2;  // Увеличиваем счетчик на количество выполненных операций
    }

    // Итоговый ответ - сумма последних битов во всех последовательностях длины n.
    long long result = dp[n][0] + dp[n][1];

    // Освобождаем выделенную память для массива.
    for (int i = 0; i <= n; ++i) {
        delete[] dp[i];
    }
    delete[] dp;

    return result;
}

// Рекурсивная функция для метода "в лоб".
long long countSequencesNaive(int n, long long& counter) {
    if (n == 0) {
        return 1;
    }

    long long a = 1;
    long long b = 1;

    for (int i = 2; i <= n; ++i) {
        long long temp = a;
        a = a + b;
        b = temp;
        counter += 3;  // Увеличиваем счетчик на количество выполненных операций
    }

    return a + b;
}

int main() {

    SetConsoleCP(CP_UTF8);
    SetConsoleOutputCP(CP_UTF8);

    int n;

    cout << "Введите длину последовательности (n): ";
    cin >> n;

    long long counterNaive = 0;
    long long resultNaive = countSequencesNaive(n, counterNaive);

    cout << "\nЧисло последовательностей (в лоб): " << resultNaive << endl;
    cout << "Количество операций (в лоб): " << counterNaive << endl;

    long long counterDP = 0;
    long long resultDP = countSequences(n, counterDP);

    cout << "\nЧисло последовательностей (динамическое программирование): " << resultDP << endl;
    cout << "Количество операций (динамическое программирование): " << counterDP << endl;

    return 0;
}