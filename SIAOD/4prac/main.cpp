#include <iostream>
#include <vector>
#include <string>
#include <fstream>
#include <Windows.h>

const int N[3] = {10000, 100000, 1000000};

std::vector<int> PrefixFunction(const std::string &str) {
    auto m = str.length();
    std::vector<int> prefix(m, 0);
    int k = 0; // Индекс последнего совпавшего символа в текущем префиксе
    for (int q = 1; q < m; q++) {
        while (k > 0 && str[k] != str[q]) {
            // Пока не найден подходящий префикс или не достигнут конец строки
            k = prefix[k - 1];
        }
        if (str[k] == str[q]) {
            k++;
        }
        prefix[q] = k; // Присваиваем текущему элементу префикс-функции значение k
    }
    return prefix; // Возвращаем вектор значений префикс-функции
}


int main() {
    SetConsoleCP(CP_UTF8);
    SetConsoleOutputCP(CP_UTF8);

    std::ifstream input_file("test.txt");
    if (!input_file.is_open()) {
        std::cerr << "Failed to open the file!" << std::endl;
        return 1;
    }
    std::string file_contents;
    std::string line;
    while (std::getline(input_file, line)) {
        file_contents += line + '\n';
    }
    input_file.close();
    std::cout << "Choose task:\n"
                 "1 - First task\n"
                 "2 - Second task\n";
    int choice;
    std::cin >> choice;
    if (choice == 1) {
    for (int i: N) {
        std::string str = file_contents.substr(0, i);
        bool sentence_end = false;
        bool word_flag = false;
        bool sentence_flag = false;
        std::string str_out;
        for (char c: str) {
            if (std::isspace(c) || c == '-' || c == ';' || c == ':' || c == ',') {
                if (sentence_end) {
                    if (!sentence_flag) {
                        str_out += "  "; // Добавляем двойной пробел, если предложение уже закончено
                        sentence_flag = true;
                    }
                } else {
                    if (!word_flag) {
                        str_out += ' '; // Добавляем пробел, если слово уже началось
                        word_flag = true;
                    }
                }
            } else if (c == '.' || c == '!' || c == '?') {
                sentence_end = true; // Обозначаем, что предложение закончено
                str_out += c; // Добавляем знак препинания
            } else {
                sentence_flag = false;
                word_flag = false;
                sentence_end = false;
                str_out += c; // Добавляем символ к текущему слову
            }
        }
            std::cout << str_out;
        }
    } else if (choice == 2) {
        for (int i: N) {
            std::string str = file_contents.substr(0, N[1]);
            std::vector<int> prefix = PrefixFunction(str);
            std::ofstream output_file("prefix_" + std::to_string(i) + ".txt"); // Открываем файл для записи
            output_file << "π[i] = [";
            for (auto j = 0; j < prefix.size() - 1; ++j) {
                output_file << prefix[j] << ", "; // Записываем значения префикс-функции
            }
            output_file << prefix[prefix.size() - 1] << "]"; // Записываем последний элемент
            output_file.close();
        }
    }
    return 0;
}