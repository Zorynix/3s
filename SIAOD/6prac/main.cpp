#include <iostream>
#include <vector>
#include <climits>
#include <Windows.h>
#include <map>

using namespace std;

const int V = 9;

// Сопоставление номеров вершин и соответствующих буквенных обозначений
std::map<int, char> vertexMap = {
        {0, 'L'},
        {1, 'B'},
        {2, 'N'},
        {3, 'R'},
        {4, 'M'},
        {5, 'A'},
        {6, 'G'},
        {7, 'S'},
        {8, 'D'}
};

// Находит вершину с минимальным ключом, которая еще не включена в MST
int minKey(std::vector<int>& key, std::vector<bool>& mstSet) {
    int min = INT_MAX, minIndex;

    for (int v = 0; v < V; ++v) {
        if (!mstSet[v] && key[v] < min) {
            min = key[v];
            minIndex = v;
        }
    }

    return minIndex;
}

// Выводит ребра и их веса в остовном дереве
void printEdgesAndWeights(vector<int> parent, int graph[V][V]) {
    std::cout << "Ребро\t\tВес\n";
    for (int i = 1; i < V; ++i) {
        std::cout << vertexMap[i] << " - " << vertexMap[parent[i]] << "\t\t" << graph[i][parent[i]] << "\n";
    }
}

// Выводит вершины и расстояния от начальной вершины в алгоритме Дейкстры
void printVerticesAndDistances(std::vector<int>& dist) {
    std::cout << "Вершина\t\tРасстояние от начальной вершины\n";
    for (int i = 0; i < V; ++i) {
        std::cout << vertexMap[i] << "\t\t" << dist[i] << "\n";
    }
}

// Выводит результат алгоритма Дейкстры без буквенных обозначений вершин
void printDijkstra(std::vector<int>& dist, int V){
    std::cout << "Вершина\t\tРасстояние от начальной вершины\n";
    for (int i = 0; i < V; ++i) {
        std::cout << i << "\t\t" << dist[i] << "\n";
    }
}

// Выводит ребра и их веса в остовном дереве без буквенных обозначений вершин
void printOstovnoe(vector<int> parent, int** graph, int V){
    std::cout << "Ребро\t\tВес\n";
    for (int i = 1; i < V; ++i) {
        std::cout << parent[i] << " - " << i << "\t\t" << graph[i][parent[i]] << "\n";
    }
}

// Алгоритм Прима для построения остовного дерева минимального веса
void prim(int** graph, int V) {
    // Массив, отмечающий, включена ли вершина в MST
    std::vector<bool> mstSet(V, false);
    // Массив, хранящий родительские вершины для построения MST
    std::vector<int> parent(V, -1);
    // Массив ключей, представляющих минимальные веса рёбер
    std::vector<int> key(V, INT_MAX);

    // Начинаем с вершины 0
    key[0] = 0;

    for (int i = 0; i < V - 1; ++i) {
        // Находим вершину с минимальным ключом, еще не включенную в MST
        int u = minKey(key, mstSet);
        // Включаем найденную вершину в MST
        mstSet[u] = true;

        // Обновляем ключи и родительские вершины для смежных вершин
        for (int v = 0; v < V; ++v) {
            if (graph[u][v] && !mstSet[v] && graph[u][v] < key[v]) {
                parent[v] = u;
                key[v] = graph[u][v];
            }
        }
    }
    // Выводим рёбра и их веса в остовном дереве
    printOstovnoe(parent, graph, V);
}

// Алгоритм Дейкстры для поиска кратчайших путей от одной вершины ко всем остальным
void dijkstra(int** graph, int V, int startVertex) {
    // Массив для хранения расстояний от начальной вершины
    std::vector<int> dist(V, INT_MAX);
    // Начальная вершина имеет расстояние 0
    dist[startVertex] = 0;

    // Массив, отмечающий, посещена ли вершина
    std::vector<bool> visited(V, false);

    for (int i = 0; i < V - 1; ++i) {
        // Находим вершину с минимальным расстоянием, еще не посещенную
        int u = minKey(dist, visited);
        // Помечаем вершину как посещенную
        visited[u] = true;

        // Обновляем расстояния для смежных вершин
        for (int v = 0; v < V; ++v) {
            if (!visited[v] && graph[u][v] && dist[u] != INT_MAX &&
                dist[u] + graph[u][v] < dist[v]) {
                dist[v] = dist[u] + graph[u][v];
            }
        }
    }
    // Выводим вершины и расстояния от начальной вершины
    printDijkstra(dist, V);
}

// Алгоритм Прима для построения остовного дерева минимального веса с буквенными обозначениями вершин
void prim_var(int graph[V][V]) {
    // Массив, отмечающий, включена ли вершина в MST
    std::vector<bool> mstSet(V, false);
    // Массив, хранящий родительские вершины для построения MST
    std::vector<int> parent(V, -1);
    // Массив ключей, представляющих минимальные веса рёбер
    std::vector<int> key(V, INT_MAX);

    // Начинаем с вершины 0
    key[0] = 0;

    for (int i = 0; i < V - 1; ++i) {
        // Находим вершину с минимальным ключом, еще не включенную в MST
        int u = minKey(key, mstSet);
        // Включаем найденную вершину в MST
        mstSet[u] = true;

        // Обновляем ключи и родительские вершины для смежных вершин
        for (int v = 0; v < V; ++v) {
            if (graph[u][v] && !mstSet[v] && graph[u][v] < key[v]) {
                parent[v] = u;
                key[v] = graph[u][v];
            }
        }
    }
    // Выводим рёбра и их веса в остовном дереве
    printEdgesAndWeights(parent, graph);
}

// Алгоритм Дейкстры для поиска кратчайших путей от одной вершины ко всем остальным с буквенными обозначениями вершин
void dijkstra_var(int graph[V][V], int startVertex) {
    // Массив для хранения расстояний от начальной вершины
    std::vector<int> dist(V, INT_MAX);
    // Начальная вершина имеет расстояние 0
    dist[startVertex] = 0;

    // Массив, отмечающий, посещена ли вершина
    std::vector<bool> visited(V, false);

    for (int i = 0; i < V - 1; ++i) {
        // Находим вершину с минимальным расстоянием, еще не посещенную
        int u = minKey(dist, visited);
        // Помечаем вершину как посещенную
        visited[u] = true;

        // Обновляем расстояния для смежных вершин
        for (int v = 0; v < V; ++v) {
            if (!visited[v] && graph[u][v] && dist[u] != INT_MAX &&
                dist[u] + graph[u][v] < dist[v]) {
                dist[v] = dist[u] + graph[u][v];
            }
        }
    }
    // Выводим вершины и расстояния от начальной вершины
    printVerticesAndDistances(dist);
}

// Заполнение графа данными, введенными пользователем
void fillGraphFromInput(int** graph, int V) {
    std::cout << "Введите матрицу смежности " << V << "x" << V << ":\n";
    for (int i = 0; i < V; ++i) {
        for (int j = 0; j < V; ++j) {
            std::cin >> graph[i][j];
        }
    }
}

int main() {
    SetConsoleCP(CP_UTF8);
    SetConsoleOutputCP(CP_UTF8);

    // Исходная матрица смежности
    int graph[V][V] = {
            {0, 7, 10, 0, 0, 0, 0, 0, 0},
            {7, 0, 0, 0, 0, 27, 9, 0, 0},
            {10, 0, 0, 31, 0, 0, 8, 0, 0},
            {0, 0, 31, 0, 0, 0, 0, 0, 32},
            {0, 0, 0, 0, 0, 15, 0, 15, 21},
            {0, 27, 0, 0, 15, 0, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 11, 0},
            {0, 0, 0, 0, 15, 0, 11, 0, 17},
            {0, 0, 0, 32, 21, 0, 0, 17, 0}
    };

    int choice;
    int numVertices;
    int** graph2;

    while (true) {
        cout << "Главное меню:\n";
        cout << "1. Работа с матрицей варианта\n";
        cout << "2. Работа с произвольной матрицей\n";
        cout << "3. Выход\n";
        cout << "Выберите действие: ";
        cin >> choice;

        switch (choice) {
            case 1:
                std::cout << "Метод Дейкстры:\n";
                dijkstra_var(graph, 0);

                std::cout << "\nОстовное дерево:\n";
                prim_var(graph);
                break;
            case 2:
                cout << "Введите количество вершин: ";
                cin >> numVertices;

                graph2 = new int*[numVertices];

                for (int i = 0; i < numVertices; ++i) {
                    graph2[i] = new int[numVertices];
                }

                fillGraphFromInput(graph2, numVertices);

                std::cout << "Метод Дейкстры:\n";
                dijkstra(graph2, numVertices, 0);

                std::cout << "\nОстовное дерево:\n";
                prim(graph2, numVertices);

                for (int i = 0; i < numVertices; ++i) {
                    delete[] graph2[i];
                }
                delete[] graph2;
                break;
            case 3:
                return 0;
            default:
                cout << "Неверный выбор. Попробуйте снова.\n";
        }
    }
}