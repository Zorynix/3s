cmake_minimum_required(VERSION 3.26)
project(3prac)

set(CMAKE_CXX_STANDARD 23)

add_executable(3prac main.cpp
        HashTable.hpp
        HashTable.cpp
        Book.hpp
        Book.cpp)
