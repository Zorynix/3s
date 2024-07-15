#include "Book.hpp"
#include <string>

Book::Book(long long isbn, std::string author, std::string title) : isbn(isbn), author(std::move(author)),
                                                                    title(std::move(title)) {}