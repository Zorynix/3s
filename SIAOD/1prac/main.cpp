#include <iostream>
#include <bitset>
#include <string>
#include <vector>
#include <chrono>
#include <fstream>
#include <Windows.h>


using namespace std;


unsigned char task_1_a(unsigned char n) {
    // Выводим значение переменной n в десятичной системе счисления
    cout << int(n) << "\n";
    // Выводим бинарное представление переменной n (16 бит)
    cout << bitset<16>(n).to_string() << "\n";
    // Создаем маску с единицей в четвертом бите
    unsigned char mask = 1;
    // Применяем побитовое И и инверсию маски к переменной n
    return n & (~(mask << 4));
}

unsigned char task_1_b(unsigned char n) {
    // Выводим значение переменной n в десятичной системе счисления
    cout << int(n) << "\n";
    // Создаем маску с единицей в седьмом бите
    unsigned char mask = 0b01000000;
    // Выводим бинарное представление переменной n (16 бит)
    cout << bitset<16>(n).to_string() << "\n";
    // Применяем побитовое ИЛИ и инверсию маски к переменной n
    return n | (~(mask << 6));
    // Эквивалентный вариант: return n | 0b00000010;
}

void task_1_c() {
    unsigned int x = 25;
    const int n = sizeof(int) * 8;
    // Создаем маску с единицей в самом старшем бите
    unsigned mask = (1 << (n - 1));
    cout << "Начальный вид маски: " << bitset<n>(mask) << "\n";
    cout << "Результат: ";
    // Печатаем биты числа x в обратном порядке
    for (int i = 1; i <= n; ++i) {
        cout << ((x & mask) >> (n - i));
        mask = mask >> 1; //Сдвигает биты маски вправо на 1 позицию, что эквивалентно делению на 2.
    }
    cout << "\n";
}


void task_2_a() {
    int n;  // Объявление переменной n для хранения количества элементов массива
    cout << "Введите количество элементов массива: \n";
    cin >> n;
    vector<int> arr(n);
    bool flag = false;
    cout << "Введите данные: \n";
    for (auto &el: arr) {
        cin >> el;  // Чтение значения элемента с клавиатуры
        if (el > 7) flag = true;  // Если элемент больше 7, устанавливаем флаг
    }

    if (arr.size() > 8 || flag) {  // Если размер массива больше 8 или флаг установлен
        unsigned long long bit_arr = 0;  // Битовый массив (64 бита)
        for (auto &el: arr) {
            bit_arr |= 1ull << el;  // Установка бита в позиции el
        }
        cout << "Битовый массив: " << bitset<sizeof(bit_arr) * 8>(bit_arr) << "\n";  // Печать битового массива
        unsigned long long mask = 1ull;  // Маска для проверки битов
        cout << "Отсортированный массив: ";
        for (int i = 0; i < (sizeof(bit_arr) * 8); ++i) {  // Цикл по битам
            if (bit_arr & mask) {  // Если бит установлен
                cout << i << " ";  // Печать индекса
            }
            mask = mask << 1;  // Сдвиг маски
        }
    } else {
        unsigned char bit_arr = 0;  // Битовый массив (8 бит)
        for (auto &el: arr) {
            bit_arr |= 1 << el;  // Установка бита в позиции el
        }
        unsigned char mask = 1;  // Маска для проверки битов
        cout << "Битовый массив: " << bitset<sizeof(bit_arr) * 8>(bit_arr) << "\n";  // Печать битового массива
        cout << "Отсортированный массив: ";
        for (int i = 0; i < (sizeof(bit_arr) * 8); ++i) {  // Цикл по битам
            if (bit_arr & mask) {  // Если бит установлен
                cout << i << " ";  // Печать индекса
            }
            mask = mask << 1;  // Сдвиг маски
        }
    }
}

void task_2_b() {
    int n;
    cout << "Введите количество элементов массива: \n";
    cin >> n;
    vector<int> arr(n);
    int max_value = 0;
    cout << "Введите данные: \n";
    for (auto &el: arr) {
        cin >> el;
        if (el > max_value)
            max_value = el;
    }
    constexpr int el_size = sizeof(unsigned long long) * 8;  // Размер элемента в битах
    vector<unsigned long long> bit_arr(max_value / el_size + 1, 0ull);  // Битовый массив
    for (auto &el: arr)
        bit_arr[el / el_size] |= 1ull << (el % el_size);  // Установка бита

    cout << "Битовый массив: ";
    for (int i = 0; i < bit_arr.size(); ++i) {  // Цикл по элементам битового массива
        cout << bitset<el_size>(bit_arr[bit_arr.size() - i - 1]) << " ";  // Печать элемента в бинарном виде
    }
    cout << "\nОтсортированный массив: ";
    for (int i = 0; i < bit_arr.size(); ++i) {
        unsigned long long mask = 1;  // Маска для проверки битов
        for (int j = 0; j < el_size; ++j) {
            if (mask & bit_arr[i]) {  // Если бит установлен
                cout << j + i * el_size << " ";  // Печать индекса
            }
            mask = mask << 1;  // Сдвиг маски
        }
    }
}

void task_2_c() {
    int n;
    cout << "Введите количество элементов массива: \n";
    cin >> n;  // Чтение значения n с клавиатуры
    vector<int> arr(n);
    int max_value = 0;
    cout << "Введите данные: \n";
    for (auto &el: arr) {
        cin >> el;
        if (el > max_value)
            max_value = el;
    }
    constexpr int el_size = sizeof(unsigned char) * 8;  // Размер элемента в битах
    vector<unsigned char> bit_arr(max_value / el_size + 1, 0);  // Битовый массив
    for (auto &el: arr)
        bit_arr[el / el_size] |= 1 << (el % el_size);  // Установка бита

    cout << "Битовый массив: ";
    for (int i = 0; i < bit_arr.size(); ++i) {
        cout << bitset<el_size>(bit_arr[bit_arr.size() - i - 1]) << " ";  // Печать элемента в бинарном виде
    }
    cout << "\nОтсортированный массив: ";
    for (int i = 0; i < bit_arr.size(); ++i) {
        unsigned char mask = 1;  // Маска для проверки битов
        for (int j = 0; j < el_size; ++j) {
            if (mask & bit_arr[i]) {  // Если бит установлен
                cout << j + i * el_size << " ";  // Печать индекса
            }
            mask = mask << 1;  // Сдвиг маски
        }
    }
}

void task_3() {
    string s;  // Объявление строки для хранения имени файла
    constexpr int el_size = sizeof(unsigned char) * 8;  // Размер элемента в битах
    vector<unsigned char> bit_arr;  // Битовый массив
    cout << "Введите имя файла: \n";
    cin >> s;
    ifstream in(s);  // Открытие файла для чтения
    if (in.is_open()) {
        auto start_time = chrono::high_resolution_clock::now();
        int n;  // Переменная для чтения данных из файла
        while (in >> n) {
            while (n >= (bit_arr.size() * el_size)) {  // Если не хватает места в массиве
                bit_arr.push_back(0);
            }
            bit_arr[n / el_size] |= 1 << (n % el_size);  // Устанавливаем бит
        }
        in.close();
        ofstream out("output.txt");
        if (out.is_open()) {
            for (int i = 0; i < bit_arr.size(); ++i) {
                unsigned char mask = 1;  // Маска для проверки битов
                for (int j = 0; j < el_size; ++j) {
                    if (mask & bit_arr[i]) {
                        out << j + i * el_size << " ";  // Записываем индекс в файл
                    }
                    mask = mask << 1;  // Сдвиг маски
                }
            }
            out.close();  // Закрываем файл
        } else {
            cerr << "Ошибка при создании файла";  // Выводим сообщение об ошибке
            return;
        }
        auto end_time = chrono::high_resolution_clock::now();  // Замер времени окончания выполнения
        auto duration = chrono::duration_cast<chrono::milliseconds>(end_time - start_time);  // Вычисление времени выполнения
        cout << "Время выполенения: " << duration.count()
             << " ms\nОбъём оперативной памяти занимаемой битовым массивом: " << bit_arr.size() * el_size << " бит";  // Выводим информацию о времени и объёме памяти
    } else {
        cerr << "Ошибка при открытии файла";  // Выводим сообщение об ошибке
        return;
    }
}


int main() {
    SetConsoleOutputCP(CP_UTF8);
    setlocale(LC_ALL, "ru_RU.UTF-8");
    //taska1();
    //taska2();
    int n;
    cout << "Введите номер задания: \n"
            "1 - 1.а\n"
            "2 - 1.б\n"
            "3 - 1.в\n"
            "4 - 2.а\n"
            "5 - 2.б\n"
            "6 - 2.в\n"
            "7 - 3.а\n";
    cin >> n;
    int temp;
    switch (n) {
        case 1:
            temp = int(task_1_a(255));
            cout << "Result: " << temp << "\n";
            cout << "Result: "<<bitset<16>(temp).to_string() << "\n";
            break;
        case 2:
            temp=int(task_1_b(191));
            cout << "Result: " << temp << "\n";
            cout << "Result: " << bitset<16>(temp).to_string()<<"\n";
            break;
        case 3:
            task_1_c();
            break;
        case 4:
            task_2_a();
            break;
        case 5:
            task_2_b();
            break;
        case 6:
            task_2_c();
            break;
        case 7:
            task_3();
            break;
    }
    return 0;
}
