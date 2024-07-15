#pragma once

#include <string>
#include <vector>
#include <iostream>
#include "Book.hpp"

class HashTable {
private:
    // Структура для хранения записей в хэш-таблице
    struct Entry {
        long long key;       // Ключ (в данном случае ISBN)
        long long book_index; // Индекс книги в векторе data_
        bool occupied;      // Флаг, указывающий, что ячейка занята

        Entry();  // Конструктор по умолчанию для инициализации полей
    };

    Entry *table_;         // Указатель на массив записей (хэш-таблицу)
    long long capacity_;   // Емкость хэш-таблицы (количество ячеек)
    long long size_;       // Текущий размер (количество занятых ячеек)
    double load_factor_;   // Фактор загрузки (отношение занятых ячеек к общему количеству ячеек)

    long long Hash(const long long &key) const; // Функция хеширования

    long long QuadraticProbe(long long index, long long attempt) const; // Квадратичное пробирование

    void rehash(); // Функция перехеширования

public:
    std::vector<Book> data_; // Вектор для хранения книг

    explicit HashTable(long long initial_capacity); // Конструктор с параметром

    ~HashTable(); // Деструктор

    void insert(long long isbn, const std::string &author, const std::string &title); // Вставка записи

    void remove(long long isbn); // Удаление записи по ISBN

    long long find(long long isbn); // Поиск записи по ISBN

    void display(); // Вывод содержимого хэш-таблицы
};
