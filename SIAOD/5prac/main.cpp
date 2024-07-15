#include <iostream>
#include <Windows.h>
#include <sstream>
#include "RedBlackTree.hpp"
#include <string>

int main() {
    SetConsoleCP(CP_UTF8);
    SetConsoleOutputCP(CP_UTF8);

    RedBlackTree tree;

    int choice;
    double value;
    std::string input;
    std::istringstream iss; // Поток для разбора введенных значений

    do {
        std::cout << "\n1. Вставить элемент\n"
                  << "2. Провести прямой обход\n"
                  << "3. Провести симметричный обход\n"
                  << "4. Найти сумму значений листьев\n"
                  << "5. Найти среднее арифметическое всех узлов\n"
                  << "0. Выйти\n"
                  << "Выберите действие: ";
        std::cin >> choice;

        switch (choice) {
            case 1:
                std::cout << "Введите значения для вставки через пробел: ";
                std::cin.ignore(INT_MAX, '\n'); // Очищаем буфер ввода
                std::getline(std::cin, input);
                iss.str(input); // Устанавливаем строку для потока iss
                while (iss >> value) {
                    tree.insert(value);
                }
                iss.clear(); // Сбрасываем флаги состояния потока
                break;
            case 2:
                std::cout << "Прямой обход: ";
                tree.inorderTraversal(); // Выполняем прямой обход
                break;
            case 3:
                std::cout << "Симметричный обход:" << std::endl;
                tree.printTree(); // Выполняем симметричный обход
                break;
            case 4:
                std::cout << "Сумма значений листьев: " << tree.sumLeaves() << std::endl;
                break;
            case 5:
                std::cout << "Среднее арифметическое всех узлов: " << tree.average() << std::endl;
                break;
            case 0:
                std::cout << "Выход." << std::endl;
                break;
            default:
                std::cout << "Неверный выбор. Попробуйте снова." << std::endl;
        }

    } while (choice != 0);

    return 0;
}