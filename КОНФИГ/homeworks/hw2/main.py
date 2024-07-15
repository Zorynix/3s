# Импорт необходимых модулей
import os  # Для работы с операционной системой
import sys  # Для работы с параметрами командной строки
import requests  # Для отправки HTTP-запросов
import graphviz as gv  # Для создания графов
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

deptree = []

def parse_deps(deps: list, first: bool = True):
    print(deps.__len__())

    if (deps.__len__() != 0):
        for dep in deps:
            deptree.append((dep, get_dependencies(dep)))

def recursiveNodes(graph, name, depth=0):
    deps = get_dependencies(name)

    if (deps.__len__() == 0 or depth > 1):
        return

    for dep in deps:
        graph.node(dep, dep)
        graph.edge(name, dep)
        recursiveNodes(graph, dep, depth + 1)

# Главная функция
def main(args):
    if len(args) == 0:
        print("Не указано название пакета")
        return

    dot = gv.Digraph(comment='Зависимости {}'.format(args[0]))  # Создание графа с комментарием
    dot.node(args[0], args[0])  # Добавление узла с именем первого пакета

    recursiveNodes(dot, args[0])

    dot.render('output/table.gv', view=True)
    (graph,) = pydot.graph_from_dot_file('output/table.gv')
    graph.write_png('output/table.png')

if __name__ == "__main__":
    main(read_args())
