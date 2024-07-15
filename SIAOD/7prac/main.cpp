#include <iostream>
#include <fstream>
#include <vector>
#include <algorithm>
#include <map>
#include <unordered_map>
#include <locale>
#include <codecvt>
#include <Windows.h>

using namespace std;

// Структура для представления узла в дереве Шеннона–Фано и Хаффмана
struct Node {
    char symbol;        // Символ
    int frequency;      // Частота символа в тексте
    string code;        // Код символа в дереве
    Node* left;         // Левый потомок
    Node* right;        // Правый потомок

    Node(char s, int f) : symbol(s), frequency(f), code(""), left(nullptr), right(nullptr) {}
};

// Структура для представления токена в алгоритме LZ77
struct LZ77Token {
    int offset;         // Смещение на подстроку в словаре
    int length;         // Длина подстроки
    char nextChar;      // Следующий символ после подстроки
};

// Функция сравнения узлов для сортировки
bool compareNodes(const Node* a, const Node* b) {
    return a->frequency > b->frequency;
}

// Рекурсивная функция для построения кодов символов в дереве
void buildCodes(Node* node, string code, map<char, string>& codes) {
    if (node) {
        node->code = code;
        if (node->symbol != '\0') {
            codes[node->symbol] = code;
        }
        buildCodes(node->left, code + "0", codes);
        buildCodes(node->right, code + "1", codes);
    }
}

// Функция для сжатия текста с использованием кодов символов
void compressText(string input, map<char, string>& codes, string& compressed) {
    for (char c : input) {
        compressed += codes[c];
    }
}

// Функция для декомпрессии текста с использованием дерева
void decompressText(Node* root, string compressed, string& decompressed) {
    Node* current = root;
    for (char bit : compressed) {
        if (bit == '0') {
            current = current->left;
        } else {
            current = current->right;
        }

        if (current->symbol != '\0') {
            decompressed += current->symbol;
            current = root;
        }
    }
}

// Функция для построения дерева Шеннона–Фано из списка узлов
Node* buildShannonFanoTree(vector<Node*>& nodes) {
    while (nodes.size() > 1) {
        sort(nodes.begin(), nodes.end(), compareNodes);
        Node* mergedNode = new Node('\0', nodes[nodes.size() - 2]->frequency + nodes[nodes.size() - 1]->frequency);
        mergedNode->left = nodes[nodes.size() - 2];
        mergedNode->right = nodes[nodes.size() - 1];
        nodes.pop_back();
        nodes.pop_back();
        nodes.push_back(mergedNode);
    }
    return nodes[0];
}

// Функция для построения дерева Хаффмана из списка узлов
Node* buildHuffmanTree(vector<Node*>& nodes) {
    while (nodes.size() > 1) {
        sort(nodes.begin(), nodes.end(), compareNodes);
        Node* mergedNode = new Node('\0', nodes[nodes.size() - 2]->frequency + nodes[nodes.size() - 1]->frequency);
        mergedNode->left = nodes[nodes.size() - 2];
        mergedNode->right = nodes[nodes.size() - 1];
        nodes.pop_back();
        nodes.pop_back();
        nodes.push_back(mergedNode);
    }
    return nodes[0];
}

// Функция для сжатия текста с использованием алгоритма LZ78
std::vector<std::tuple<int, char>> compressLZ78(const std::string &input) {
    std::vector<std::tuple<int, char>> compressed;
    std::unordered_map<std::string, int> dictionary;
    int nextCode = 1;
    std::string currentMatch;

    for (char c : input) {
        currentMatch += c;
        if (dictionary.find(currentMatch) == dictionary.end()) {
            compressed.push_back(std::make_tuple(dictionary[currentMatch.substr(0, currentMatch.length() - 1)], c));
            dictionary[currentMatch] = nextCode++;
            currentMatch = "";
        }
    }

    if (!currentMatch.empty()) {
        compressed.push_back(std::make_tuple(dictionary[currentMatch], '\0'));
    }

    return compressed;
}

// Функция для вывода сжатых данных алгоритма LZ78
void printCompressedLZ78(const std::vector<std::tuple<int, char>> &compressed) {
    for (const auto &entry : compressed) {
        std::cout << "(" << std::get<0>(entry) << ", " << std::get<1>(entry) << ") ";
    }
    std::cout << std::endl;
}

// Функция для сжатия текста с использованием алгоритма LZ77
std::string compressLZ77(const string &input, vector<LZ77Token> vector1) {
    std::string compressed;
    size_t inputLength = input.length();
    size_t currentIndex = 0;

    while (currentIndex < inputLength) {
        size_t longestMatchLength = 0;
        size_t longestMatchIndex = 0;

        for (size_t i = 0; i < currentIndex; ++i) {
            size_t j = i;
            size_t k = currentIndex;
            size_t matchLength = 0;

            while (k < inputLength && input[j] == input[k]) {
                ++j;
                ++k;
                ++matchLength;
            }

            if (matchLength > longestMatchLength) {
                longestMatchLength = matchLength;
                longestMatchIndex = i;
            }
        }

        if (longestMatchLength > 0) {
            compressed += "(" + std::to_string(currentIndex - longestMatchIndex) + "," +
                          std::to_string(longestMatchLength) + ")";
            currentIndex += longestMatchLength;
        } else {
            compressed += input[currentIndex];
            ++currentIndex;
        }
    }

    return compressed;  // Возвращает сжатую строку
}

// Функция для чтения данных из файла
std::string readFile(const std::string &filename) {
    std::ifstream file(filename);
    if (!file.is_open()) {
        cerr << "Unable to open the file.\n";
        exit(1);
    }

    std::string content((istreambuf_iterator<char>(file)), istreambuf_iterator<char>());
    file.close();

    return content;
}


int main() {

    //SetConsoleCP(1251);
    //SetConsoleOutputCP(1251);

    cout << "Choose compression method:\n";
    cout << "1. Shannon-Fano\n";
    cout << "2. Huffman\n";
    cout << "3. LZ77\n";
    cout << "4. LZ78\n";
    int choice;
    cin >> choice;

    if (choice < 1 || choice > 4) {
        cerr << "Invalid choice.\n";
        return 1;
    }

    ifstream inputFile("input.txt");
    if (!inputFile.is_open()) {
        cerr << "Unable to open the file.\n";
        return 1;
    }

    string inputText((istreambuf_iterator<char>(inputFile)), istreambuf_iterator<char>());
    inputFile.close();

    map<char, int> frequencies;
    for (char c : inputText) {
        frequencies[c]++;
    }

    vector<Node*> nodes;
    for (auto& entry : frequencies) {
        nodes.push_back(new Node(entry.first, entry.second));
    }

    ifstream lz77file("input2.txt");
    if (!lz77file.is_open()) {
        cerr << "Unable to open the file.\n";
        return 1;
    }

    string lz77text((istreambuf_iterator<char>(lz77file)), istreambuf_iterator<char>());
    lz77file.close();

    Node* root;
    if (choice == 1) {
        // Строим дерево Шеннона–Фано
        root = buildShannonFanoTree(nodes);
    } else if (choice == 2) {
        // Строим дерево Хаффмана
        root = buildHuffmanTree(nodes);
    } else if (choice == 3) {
        // Сжимаем с использованием LZ77
        vector<LZ77Token> compressedLZ77;
        string compressedText = compressLZ77(lz77text, compressedLZ77);

        ofstream compressedLZ77File("compressed_lz77.txt");
        if (!compressedLZ77File.is_open()) {
            cerr << "Unable to create the compressed LZ77 text file.\n";
            return 1;
        }

        compressedLZ77File << compressedText;  // Записываем сжатую строку в файл

        compressedLZ77File.close();
        cout << "LZ77 compressing completed. Result saved in compressed_lz77.txt\n";
        return 0;

    } else if (choice == 4){
        string lz78Input = readFile("input3.txt"); // Используйте свой входной файл
        vector<tuple<int, char>> compressedLZ78 = compressLZ78(lz78Input);

        cout << "LZ78 compressed data:\n";
        printCompressedLZ78(compressedLZ78);

        ofstream compressedLZ78File("compressed_lz78.txt");
        if (!compressedLZ78File.is_open()) {
            cerr << "Unable to create the compressed LZ78 text file.\n";
            return 1;
        }

        for (const auto& entry : compressedLZ78) {
            compressedLZ78File << "(" << std::get<0>(entry) << ", " << std::get<1>(entry) << ") ";
        }

        compressedLZ78File.close();
        cout << "LZ78 compressing completed. Result saved in compressed_lz78.txt\n";

        return 0;
    }

    map<char, string> codes;
    buildCodes(root, "", codes);

    ofstream compressedFile("compressed_text.txt");
    if (!compressedFile.is_open()) {
        cerr << "Unable to create the compressed text file.\n";
        return 1;
    }

    string compressedText;
    compressText(inputText, codes, compressedText);

    for (char c : compressedText) {
        compressedFile.put(c);
    }
    compressedFile.close();

    ofstream decompressedFile("decompressed_text.txt");
    if (!decompressedFile.is_open()) {
        cerr << "Unable to create the decompressed text file.\n";
        return 1;
    }

    string decompressedText;
    decompressText(root, compressedText, decompressedText);

    decompressedFile << decompressedText;
    decompressedFile.close();


    ofstream characterCodesFile("character_codes.txt");
    if (!characterCodesFile.is_open()) {
        cerr << "Unable to create the character codes file.\n";
        return 1;
    }


    characterCodesFile << "Character codes:\n";
    for (auto& entry : codes) {
        characterCodesFile << entry.first << ": " << entry.second << "\n";
    }
    characterCodesFile.close();

    for (Node* node : nodes) {
        delete node;
    }

    // Открываем файл compressed_text.txt для чтения
    ifstream compressedTextFile("compressed_text.txt");
    if (!compressedTextFile.is_open()) {
        cerr << "Unable to open the compressed text file.\n";
        return 1;
    }

    // Открываем файл input.txt для чтения
    ifstream inputFileBitCount("input.txt");
    if (!inputFileBitCount.is_open()) {
        cerr << "Unable to open the input text file.\n";
        return 1;
    }

    // Считываем все байты из файла и подсчитываем количество бит
    int bitCount = 0;
    char byte;
    while (inputFileBitCount.get(byte)) {
        bitCount += CHAR_BIT; // CHAR_BIT - количество бит в байте (обычно 8)
    }

    // Закрываем файл
    inputFileBitCount.close();

    // Выводим количество бит на экран
    cout << "Number of bits unencoded phrase: " << bitCount << endl;

    int count = 0;
    char ch;
    while (compressedTextFile.get(ch)) {
        count++;
    }

    // Закрываем файл
    compressedTextFile.close();

    // Выводим количество битов в файле на экран
    cout << "Bits in encoded phrase: " << count << endl;

    // Рассчитываем коэффициент сжатия в процентах
    double compressionRatio = count / static_cast<double>(bitCount) * 100;

    // Выводим коэффициент сжатия на экран
    cout << "Compression ratio: " << compressionRatio << "%" << endl;

    return 0;
}
