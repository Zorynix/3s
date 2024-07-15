#pragma once

#include <string>

class RedBlackTree {
private:
    struct Node {
        double data;
        Node *left;
        Node *right;
        char colour;
        Node *parent;

        Node(double data);
    };

    Node *root;
    bool ll;   // Флаг для левого вращения
    bool rr;   // Флаг для правого вращения
    bool lr;   // Флаг для двойного вращения (левый затем правый)
    bool rl;   // Флаг для двойного вращения (правый затем левый)

    Node *rotateLeft(Node *node);
    Node *rotateRight(Node *node);

    Node *insertHelp(Node *root, double data); // Вставка с рекурсивной помощью

    void inorderTraversalHelper(Node *node); // Вспомогательный метод для прямого обхода

    void printTreeHelper(Node *root, int space); // Вспомогательный метод для печати дерева

    double sumAllNodesHelper(Node *node);

    double sumLeavesHelper(Node *node); // Вспомогательный метод для суммы значений листьев

    int countNodesHelper(Node *node); // Вспомогательный метод для подсчета узлов

public:
    RedBlackTree();

    void insert(double data);

    void inorderTraversal();

    void printTree();

    double sumLeaves();

    double average();
};
