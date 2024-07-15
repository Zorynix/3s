#include <iostream>
#include <Windows.h>
#include "HashTable.hpp"

using namespace std;

int main() {
    SetConsoleCP(CP_UTF8);
    SetConsoleOutputCP(CP_UTF8);
    HashTable hash_table(10);

    hash_table.insert(123456789012, "Author 1", "Author 1");
    hash_table.insert(234567890123, "Author 2", "Author 2");
    hash_table.insert(345678901234, "Author 3", "Author 3");
    hash_table.insert(456789012345, "Author 4", "Author 4");
    hash_table.insert(567890123456, "Author 5", "Author 5");

    while (true) {
        std::cout << "Choose action:\n"
                     "1 - Insert book\n"
                     "2 - Delete book\n"
                     "3 - Find book\n"
                     "4 - Display books\n"
                     "5 - Exit\n";
        int choice;
        std::cin >> choice;
        switch (choice) {
            case 1: {
                long long isbn;
                std::string author, title;
                std::cout << "Input book ISBN, author and title:\n";
                std::cin >> isbn >> author >> title;
                hash_table.insert(isbn, author, title);
                break;
            }
            case 2: {
                long long isbn;
                std::cout << "Input book ISBN to remove:\n";
                std::cin >> isbn;
                hash_table.remove(isbn);
                break;
            }
            case 3: {
                long long isbn;
                std::cout << "Input book ISBN to find:\n";
                std::cin >> isbn;
                long long book_index = hash_table.find(isbn);
                if (book_index != -1) {
                    std::cout << "Book found: " << "ISBN: " << hash_table.data_[book_index].isbn
                              << ", Title: " << hash_table.data_[book_index].title
                              << ", Author: " << hash_table.data_[book_index].author
                              << "\n";
                } else {
                    std::cout << "Book not found\n";
                }
                break;
            }
            case 4:
                hash_table.display();
                break;
            case 5:
                return 0;
            default:
                std::cout << "Incorrect choose. Try again.\n";
                break;
        }
    }
    return 0;
}