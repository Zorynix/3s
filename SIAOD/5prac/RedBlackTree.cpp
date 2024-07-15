#include "RedBlackTree.hpp"
#include <iostream>

// Конструктор узла дерева
RedBlackTree::Node::Node(double data) : data(data), left(nullptr), right(nullptr), colour('R'), parent(nullptr) {}

// Конструктор красно-черного дерева
RedBlackTree::RedBlackTree() : root(nullptr), ll(false), rr(false), lr(false), rl(false) {}

// Поворот узла влево
RedBlackTree::Node* RedBlackTree::rotateLeft(Node* node) {
    // Получаем указатели на узлы x и y
    Node* x = node->right;
    Node* y = x->left;
    // Производим поворот
    x->left = node;
    node->right = y;
    node->parent = x;
    if (y != nullptr)
        y->parent = node;
    return x;
}

// Поворот узла вправо
RedBlackTree::Node* RedBlackTree::rotateRight(Node* node) {
    // Получаем указатели на узлы x и y
    Node* x = node->left;
    Node* y = x->right;
    // Производим поворот
    x->right = node;
    node->left = y;
    node->parent = x;
    if (y != nullptr)
        y->parent = node;
    return x;
}

// Вставка узла с рекурсивной помощью
RedBlackTree::Node* RedBlackTree::insertHelp(Node* root, double data) {
    bool f = false;

    if (root == nullptr)
        return new Node(data);
    else if (data < root->data) {
        // Рекурсивно вставляем в левое поддерево
        root->left = insertHelp(root->left, data);
        root->left->parent = root;
        if (root != this->root) {
            if (root->colour == 'R' && root->left->colour == 'R')
                f = true;
        }
    } else {
        // Рекурсивно вставляем в правое поддерево
        root->right = insertHelp(root->right, data);
        root->right->parent = root;
        if (root != this->root) {
            if (root->colour == 'R' && root->right->colour == 'R')
                f = true;
        }
    }

    // Обработка случаев вращения
    if (ll) {
        root = rotateLeft(root);
        root->colour = 'B';
        root->left->colour = 'R';
        ll = false;
    } else if (rr) {
        root = rotateRight(root);
        root->colour = 'B';
        root->right->colour = 'R';
        rr = false;
    } else if (rl) {
        root->right = rotateRight(root->right);
        root->right->parent = root;
        root = rotateLeft(root);
        root->colour = 'B';
        root->left->colour = 'R';
        rl = false;
    } else if (lr) {
        root->left = rotateLeft(root->left);
        root->left->parent = root;
        root = rotateRight(root);
        root->colour = 'B';
        root->right->colour = 'R';
        lr = false;
    }

    // Обработка перекрашивания
    if (f) {
        if (root->parent->right == root) {
            if (root->parent->left == nullptr || root->parent->left->colour == 'B') {
                if (root->left != nullptr && root->left->colour == 'R')
                    rl = true;
                else if (root->right != nullptr && root->right->colour == 'R')
                    ll = true;
            } else {
                root->parent->left->colour = 'B';
                root->colour = 'B';
                if (root->parent != this->root)
                    root->parent->colour = 'R';
            }
        } else {
            if (root->parent->right == nullptr || root->parent->right->colour == 'B') {
                if (root->left != nullptr && root->left->colour == 'R')
                    rr = true;
                else if (root->right != nullptr && root->right->colour == 'R')
                    lr = true;
            } else {
                root->parent->right->colour = 'B';
                root->colour = 'B';
                if (root->parent != this->root)
                    root->parent->colour = 'R';
            }
        }
        f = false;
    }
    return root;
}

// Вставка узла в дерево
void RedBlackTree::insert(double data) {
    if (root == nullptr) {
        root = new Node(data);
        root->colour = 'B';
    } else
        root = insertHelp(root, data);
}

// Вспомогательный метод для обхода дерева (в порядке "возрастания")
void RedBlackTree::inorderTraversalHelper(Node* node) {
    if (node != nullptr) {
        // Рекурсивно обходим левое поддерево
        inorderTraversalHelper(node->left);
        // Выводим данные узла
        std::cout << node->data << " ";
        // Рекурсивно обходим правое поддерево
        inorderTraversalHelper(node->right);
    }
}

// Обход дерева в порядке "возрастания"
void RedBlackTree::inorderTraversal() {
    inorderTraversalHelper(root);
}

// Вспомогательный метод для печати дерева
void RedBlackTree::printTreeHelper(Node* root, int space) {
    if (root != nullptr) {
        space += 10;
        // Рекурсивно печатаем правое поддерево с увеличением отступа
        printTreeHelper(root->right, space);
        std::cout << std::endl;
        for (int i = 10; i < space; i++)
            std::cout << " ";
        // Выводим данные узла
        std::cout << root->data << std::endl;
        // Рекурсивно печатаем левое поддерево с увеличением отступа
        printTreeHelper(root->left, space);
    }
}

// Печать дерева
void RedBlackTree::printTree() {
    printTreeHelper(root, 0);
}

// Рекурсивный метод подсчета суммы листьев
double RedBlackTree::sumLeavesHelper(Node *x) {
    if (x == nullptr) return 0;

    if (x->left == nullptr && x->right == nullptr)
        return x->data;

    // Рекурсивно суммируем листья в левом и правом поддеревьях
    return sumLeavesHelper(x->left) + sumLeavesHelper(x->right);
}

// Подсчет суммы листьев дерева
double RedBlackTree::sumLeaves() {
    return sumLeavesHelper(root);
}

double RedBlackTree::sumAllNodesHelper(Node* x) {
    if (x == nullptr) return 0;

    double sum = x->data;

    // Рекурсивно считаем сумму всех узлов в левом и правом поддеревьях
    sum += sumAllNodesHelper(x->left) + sumAllNodesHelper(x->right);

    return sum;
}

// Вспомогательный метод для подсчета количества узлов
int RedBlackTree::countNodesHelper(Node* node) {
    if (node == nullptr) return 0;
    // Рекурсивно считаем узлы в левом и правом поддеревьях
    return 1 + countNodesHelper(node->left) + countNodesHelper(node->right);
}

// Вычисление среднего значения узлов дерева
double RedBlackTree::average() {
    double sum = sumAllNodesHelper(root);
    int count = countNodesHelper(root);
    // Рассчитываем среднее значение
    return sum / count;
}
