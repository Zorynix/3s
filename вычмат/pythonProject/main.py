import os
import sys
import requests  # Для отправки HTTP-запросов
import graphviz as gv
import pydot  # Для работы с DOT-языком и графами

# Функция для чтения аргументов командной строки
def read_args():
    args = []
    for arg in sys.argv[1:]:  # Перебор аргументов, начиная со второго (первый - имя скрипта)
        args.append(arg)
    return args

# Функция для получения зависимостей пакета
def get_dependencies(package_name) -> list:
    url = 'https://pypi.org/pypi/{}/json'
    json = requests.get(url.format(package_name)).json()
    try:
        requirements = json['info']['requires_dist']
    except:
        return []
    data = []
    if requirements is not None:
        for req in requirements:
            data.append(req.split(' ')[0])
    return data

def build_graph_right(name, deps):
    dot = gv.Digraph(comment='Зависимости {}'.format(name))
    dot.node(name, name)  # Добавление узла с именем пакета
    for dep in deps:
        dot.node(dep, dep)
        dot.edge(name, dep)  # Создание связи между пакетом и его зависимостью

    dot.render('output/table.gv', view=True)
    (graph) = pydot.graph_from_dot_file('output/table.gv')
    graph.write_png('output/table.png')

    print(dot.source)

def build_graph(name, deps):
    dot = gv.Digraph(comment='Зависимости {}'.format(name))
    dot.node('A', name)
    i = 'B'

    for dep in deps:
        dot.node(i, dep)
        i = chr(ord(i) + 1)

    i = 'B'  # Сброс i до начального значения

    for dep in deps:
        dot.edge('A', i)  # Создание связи между пакетом и его зависимостью
        i = chr(ord(i) + 1)

    dot.render('output/table.gv', view=True)
    (graph) = pydot.graph_from_dot_file('output/table.gv')
    graph.write_png('output/table.png')

    print(dot.source)

deptree = []

def parse_deps(deps: list, first: bool = True):
    print(deps.__len__())

    if (deps.__len__() != 0):
        for dep in deps:
            deptree.append((dep, get_dependencies(dep)))

def recursiveNodes(graph, name, depth=0, max_depth=3):
    deps = get_dependencies(name)

    if (deps.__len__() == 0 or depth >= max_depth):
        return

    for dep in deps:
        graph.node(dep, dep)
        graph.edge(name, dep)
        recursiveNodes(graph, dep, depth + 1,max_depth)

# Главная функция
def main(args):
    if len(args) < 2:
        print("Не указано название пакета и глубина")
        return

    package_name = args[0]
    depth = int(args[1])
    dot = gv.Digraph(comment='Зависимости {}'.format(package_name))
    dot.node(package_name, package_name)

    recursiveNodes(dot, package_name, max_depth=depth)
    dot.render('output/table.gv', view=True)
    (graph,) = pydot.graph_from_dot_file('output/table.gv')
    graph.write_png('output/table.png')

if __name__ == "__main__":
    main(read_args())
