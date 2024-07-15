#include "HashTable.hpp"

// Конструктор по умолчанию для записи (Entry)
HashTable::Entry::Entry() : key(-1), book_index(-1), occupied(false) {}

// Квадратичное пробирование
long long HashTable::QuadraticProbe(long long hash, long long attempt) const {
    return (hash + attempt + attempt * attempt) % capacity_;
}

// Функция хэширования
long long HashTable::Hash(const long long int &key) const {
    return key % capacity_;
}

// Функция перехеширования
void HashTable::rehash() {
    long long new_capacity = capacity_ * 2;
    auto *newTable = new Entry[new_capacity];
    for (long long i = 0; i < capacity_; i++) {
        if (table_[i].occupied) {
            long long hashed_key = Hash(table_[i].key);
            long long index = hashed_key;
            long long attempt = 0;
            while (newTable[index].occupied) {
                attempt++;
                index = QuadraticProbe(hashed_key, attempt);
            }
            newTable[index].key = table_[i].key;
            newTable[index].book_index = table_[i].book_index;
            newTable[index].occupied = true;
        }
    }
    delete[] table_;
    table_ = newTable;
    capacity_ = new_capacity;
}

// Конструктор с параметром
HashTable::HashTable(long long int initial_capacity) : capacity_(initial_capacity), size_(0), load_factor_(0.75) {
    table_ = new Entry[capacity_];
}

// Деструктор
HashTable::~HashTable() {
    delete[] table_;
}

// Вставка записи
void HashTable::insert(long long int isbn, const std::string &author, const std::string &title) {
    if ((size_ / capacity_) >= load_factor_) {
        rehash();
    }
    long long hashed_key = Hash(isbn);
    long long index = hashed_key;
    long long attempt = 0;
    while (table_[index].occupied) {
        attempt++;
        index = QuadraticProbe(hashed_key, attempt);
    }

    table_[index].key = isbn;
    data_.push_back({isbn, author, title});
    table_[index].book_index = data_.size() - 1;
    table_[index].occupied = true;
    size_++;
}

// Удаление записи по ISBN
void HashTable::remove(long long isbn) {
    long long hashed_key = Hash(isbn);
    long long index = hashed_key;
    long long attempt = 0;
    while (table_[index].occupied) {
        if (table_[index].key == isbn) {
            table_[index].occupied = false;
            size_--;
            return;
        }
        attempt++;
        index = QuadraticProbe(hashed_key, attempt);
    }
}

// Поиск записи по ISBN
long long HashTable::find(long long isbn) {
    long long hashed_key = Hash(isbn);
    long long index = hashed_key;
    long long attempt = 0;
    while (table_[index].occupied) {
        if (table_[index].key == isbn) {
            return table_[index].book_index;
        }
        attempt++;
        index = QuadraticProbe(hashed_key, attempt);
    }
    return -1;
}

// Вывод содержимого хэш-таблицы
void HashTable::display() {
    for (long long i = 0; i < capacity_; i++) {
        if (table_[i].occupied) {
            std::cout << "ISBN: " << data_[table_[i].book_index].isbn
                      << ", Author: " << data_[table_[i].book_index].author
                      << ", Title: " << data_[table_[i].book_index].title << "\n";
        }
    }
}
