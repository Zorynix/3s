#pragma once
#include <istream>

struct Book {
    long long isbn;
    std::string author;
    std::string title;

    Book(long long isbn, std::string author, std::string title);
};
