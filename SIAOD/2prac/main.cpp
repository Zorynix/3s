#include <iostream>
#include <random>
#include <fstream>
#include <Windows.h>
#include <chrono>

using namespace std;

const char *alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
const int N[] = {100, 1000, 10000};

random_device r;
default_random_engine generator(r());
uniform_int_distribution<int> number_distribution(0, INT_MAX);
uniform_int_distribution<int> char_index_distribution(0, (int) strlen(alphabet) - 1);

// Определение структуры пациента
struct ClinicPatient {
    int card_number;
    int disease_code;
    char doctors_name[20];
};

// Структура для таблицы индексов
struct TableEntry {
    int key;
    int offset;
};

// Функция проверки существования карточки с заданным номером
bool IsCardNumberExists(auto &arr, const int &n, const int &card_number) {
    for (int i = 0; i < n; ++i)
        if (arr[i].card_number == card_number) return true;
    return false;
}

// Функция генерации массива данных
void GenerateArray(auto &arr, const int &n) {
    for (int i = 0; i < n; ++i) {
        int card_number = number_distribution(generator);
        while (IsCardNumberExists(arr, n, card_number))
            card_number = number_distribution(generator);
        arr[i].card_number = card_number;
        arr[i].disease_code = number_distribution(generator);
        for (int j = 0; j < 19; ++j) {
            arr[i].doctors_name[j] = alphabet[char_index_distribution(generator)];
        }
        arr[i].doctors_name[19] = '\0';
    }
}

// Функция чтения последней записи из файла
ClinicPatient GetLastRecord(auto file, const int &n) {
    fseek(file, (n - 1) * sizeof(ClinicPatient), SEEK_SET);
    ClinicPatient temp = {};
    fread(&temp, sizeof(ClinicPatient), 1, file);
    return temp;
}

// Задача 1
inline void Task1() {
    FILE *file;
    fopen_s(&file, "data.bin", "wb"); // Открытие файла для записи в бинарном режиме
    auto arr = new ClinicPatient[N[0]]; // Выделение памяти под массив
    GenerateArray(arr, N[0]); // Генерация данных
    fwrite(arr, sizeof(ClinicPatient), N[0], file); // Запись в файл
    fclose(file); // Закрытие файла

    fopen_s(&file, "data.bin", "rb"); // Открытие файла для чтения в бинарном режиме
    auto last_record = GetLastRecord(file, N[0]); // Получение последней записи
    cout << "Всего записей: " << N[0] << "\n"; // Вывод информации
    cout << "Всего байт: " << N[0] * sizeof(ClinicPatient) << "\n";
    cout << "Последняя запись: " << "\n";
    cout << "   номер карточки: " << last_record.card_number << "\n";
    cout << "   код заболевания: " << last_record.disease_code << "\n";
    cout << "   имя доктора: " << last_record.doctors_name << "\n";
}

// Функция линейного поиска
ClinicPatient LinearSearch(auto file, const int n, auto key) {
    ClinicPatient temp = {};
    for (int i = 0; i < n; ++i) {
        auto read = fread(&temp, sizeof(ClinicPatient), 1, file);
        if (read == 0)
            return {};
        if (temp.card_number == key) {
            return temp;
        }
    }
    return {};
}

// Функция интерполяционного поиска
size_t InterpolationSearch(const vector<TableEntry> &table, const int &key) {
    size_t left = 0;
    size_t right = table.size() - 1;
    while (left <= right && key >= table[left].key && key <= table[right].key) {
        cout << left << " " << right << " " << key << "\n";
        size_t mid = left + ((key - table[left].key) * (right - left)) / (table[right].key - table[left].key);
        if (table[mid].key == key) {
            return mid;
        }
        if (table[mid].key < key) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    if (table[left].key == key) {
        return left;
    } else if (table[right].key == key) {
        return right;
    } else {
        return -1;
    }
}

// Задача 2
inline void Task2() {
    auto start_time = chrono::high_resolution_clock::now();
    for (int i: N) {
        FILE *file;
        fopen_s(&file, "data.bin", "wb"); // Открытие файла для записи в бинарном режиме
        auto arr = new ClinicPatient[i]; // Выделение памяти под массив
        GenerateArray(arr, i); // Генерация данных
        fwrite(arr, sizeof(ClinicPatient), i, file); // Запись в файл
        fclose(file); // Закрытие файла

        fopen_s(&file, "data.bin", "rb"); // Открытие файла для чтения в бинарном режиме

        auto last_record = GetLastRecord(file, i); // Получение последней записи

        // Вывод информации
        cout << "Всего записей: " << i << "\n";
        cout << "Всего байт: " << i * sizeof(ClinicPatient) << "\n";
        cout << "Последняя запись: " << "\n";
        cout << "   номер карточки: " << last_record.card_number << "\n";
        cout << "   код заболевание: " << last_record.disease_code << "\n";
        cout << "   имя доктора: " << last_record.doctors_name << "\n";
        cout << "\n";
        cout << "Введите ключ для поиска:\n";
        int key;
        cin >> key;
        fseek(file, 0, SEEK_SET); // Установка указателя файла в начало
        auto start_time = chrono::high_resolution_clock::now(); // Замер времени начала операции
        auto record = LinearSearch(file, i, key); // Линейный поиск
        ClinicPatient emptyPatient = {};
        if (record.card_number == emptyPatient.card_number &&
            record.disease_code == emptyPatient.disease_code &&
            strcmp(record.doctors_name, emptyPatient.doctors_name) == 0) {
            cout << "Такого ключа не существует\n\n";
            fclose(file); // Закрытие файла
            delete[] arr; // Освобождение памяти
            continue;
        }
        auto end_time = chrono::high_resolution_clock::now(); // Замер времени окончания операции
        auto duration = chrono::duration_cast<chrono::nanoseconds>(end_time - start_time); // Вычисление длительности операции
        cout << "Найденная запись: " << "\n";
        cout << "   номер карточки: " << record.card_number << "\n";
        cout << "   код заболевания: " << record.disease_code << "\n";
        cout << "   имя доктора: " << record.doctors_name << "\n";
        cout << "Время поиска: " << duration.count() << " наносекунд \n\n"; // Вывод времени поиска
        fclose(file); // Закрытие файла
        delete[] arr; // Освобождение памяти
    }
}

// Функция чтения записи из файла по смещению
ClinicPatient ReadRecordFromFile(auto file, const int &offset) {
    fseek(file, offset, SEEK_SET); // Установка указателя файла на заданное смещение
    ClinicPatient temp = {};
    fread(&temp, sizeof(ClinicPatient), 1, file); // Чтение записи
    return temp;
}

// Задача 3
inline void Task3() {
    for (int i: N) {
        vector<TableEntry> table(i); // Создание таблицы индексов
        FILE *file;
        fopen_s(&file, "data.bin", "wb"); // Открытие файла для записи в бинарном режиме
        auto arr = new ClinicPatient[i]; // Выделение памяти под массив
        GenerateArray(arr, i); // Генерация данных
        for (int j = 0; j < i; ++j) {
            table[j].key = arr[j].card_number; // Заполнение таблицы индексов
            table[j].offset = j * int(sizeof(ClinicPatient));
        }
        fwrite(arr, sizeof(ClinicPatient), i, file); // Запись в файл
        fclose(file); // Закрытие файла

        fopen_s(&file, "data.bin", "rb"); // Открытие файла для чтения в бинарном режиме

        auto last_record = GetLastRecord(file, i); // Получение последней записи

        // Вывод информации
        cout << "Всего записей: " << i << "\n";
        cout << "Всего байт: " << i * sizeof(ClinicPatient) << "\n";
        cout << "Последняя запись: " << "\n";
        cout << "   номер карточки: " << last_record.card_number << "\n";
        cout << "   код заболевания: " << last_record.disease_code << "\n";
        cout << "   имя доктора: " << last_record.doctors_name << "\n";
        cout << "\n";
        cout << "Введите ключ для поиска:\n";
        int key;
        cin >> key;
        fseek(file, 0, SEEK_SET); // Установка указателя файла в начало
        auto start_time = chrono::high_resolution_clock::now(); // Замер времени начала операции
        sort(table.begin(), table.end(), [](const TableEntry &a, const TableEntry &b) {
            return a.key < b.key; // Сортировка таблицы индексов
        });
        int found_record_index = int(InterpolationSearch(table, key)); // Интерполяционный поиск
        if (found_record_index == -1) {
            cout << "Такого ключа не существует\n\n";
            fclose(file); // Закрытие файла
            delete[] arr; // Освобождение памяти
            continue;
        }
        ClinicPatient record = ReadRecordFromFile(file, table[found_record_index].offset); // Чтение записи по индексу
        auto end_time = chrono::high_resolution_clock::now(); // Замер времени окончания операции
        auto duration = chrono::duration_cast<chrono::nanoseconds>(end_time - start_time); // Вычисление длительности операции
        cout << "Найденная запись: " << "\n";
        cout << "   номер карточки: " << record.card_number << "\n";
        cout << "   код заболевания: " << record.disease_code << "\n";
        cout << "   имя доктора: " << record.doctors_name << "\n";
        cout << "Время поиска: " << duration.count() << " наносекунд \n\n";
        fclose(file);
        delete[] arr; // Освобождение памяти
    }
}

// Главная функция
int main() {
    int task_number;
    SetConsoleCP(CP_UTF8);
    SetConsoleOutputCP(CP_UTF8);
    cout << "Задание 1 - 1\n"
            "Задание 2 - 2\n"
            "Задание 3 - 3\n"
            "Введите номер задачи:";
    cin >> task_number;
    switch (task_number) {
        case 1:
            Task1();
            break;
        case 2:
            Task2();
            break;
        case 3:
            Task3();
            break;
        default:
            cout << "Вы ввели неверный номер задания!";
    }
    return 0;
}
