import argparse
from argparse import ArgumentParser
import hashlib
import os
import json


class SmartFormatter(argparse.HelpFormatter):

    def _split_lines(self, text, width):
        if text.startswith('R|'):
            return text[2:].splitlines()
        return argparse.HelpFormatter._split_lines(self, text, width)

class minimake:
    def __init__(self):
        # Инициализация базовых структур данных
        self.tasks = {}  # Словарь задач (имя -> информация о задаче)
        self.task_status = {}  # Словарь статусов задач (имя -> выполнена или нет)
        self.file_hashes = {}  # Словарь хэшей файлов (имя файла -> хэш)

    def taska(self, name, depends=None):
        def decorator(func):
            # Добавление информации о задаче в словарь
            self.tasks[name] = {
                'func': func,  # Сохранение функции задачи
                'depends': depends if depends else [],  # Сохранение зависимостей (если есть)
            }
            self.task_status[name] = False  # Инициализация статуса задачи как невыполненной
            return func

        return decorator

    def hash_file(self, filename):
        # Вычисление хэша файла с использованием SHA-256
        hasher = hashlib.sha256()
        with open(filename, 'rb') as file:
            while True:
                data = file.read(4096)
                if not data:
                    break
                hasher.update(data)
        return hasher.hexdigest()

    def execute_task(self, task_name):
        if not self.task_status[task_name]:
            task_info = self.tasks[task_name]
            dependencies = task_info['depends']
            for dependency in dependencies:
                if dependency not in self.file_hashes:
                    # Если зависимость не была ранее обработана, вычисляем её хэш
                    if os.path.exists(dependency):  # Проверка существования файла
                        self.file_hashes[dependency] = self.hash_file(dependency)
                    else:
                        print(f"Зависимость '{dependency}' не найдена.")
                        return

                current_hash = self.hash_file(dependency)
                if current_hash != self.file_hashes[dependency]:
                    print(f"Задача '{task_name}' устарела. Пересчет...")
                    break
            else:
                print(f"Выполнение задачи: {task_name}")
                task_info['func']()
                self.task_status[task_name] = True

    def build(self, target):
        execution_order = []

        def dfs(node):
            # Рекурсивный обход в глубину для определения порядка выполнения задач
            for dependency in self.tasks[node]['depends']:
                if not self.task_status[dependency]:
                    dfs(dependency)
            execution_order.append(node)

        dfs(target)

        for task_name in execution_order:
            self.execute_task(task_name)


if __name__ == "__main__":
    make = minimake()


    @make.taska("input.txt")
    def create_input():
        print("Создание input.txt...")
        with open("civgraph.txt","r") as infile:
            data = infile.read()
        with open("input.txt", "w") as f:
            f.write(data)


    @make.taska("result.txt", depends=["input.txt"])
    def process_input():
        print("Обработка input.txt...")
        with open("input.txt", "r") as infile:
            data = infile.read()
            processed_data = data.upper()
        with open("result.txt", "w") as outfile:
            outfile.write(processed_data)


    @make.taska("result_backup.txt", depends=["result.txt"])
    def backup_result():
        print("Создание резервной копии result.txt...")
        with open("result.txt", "r") as f:
            data = f.read()
        with open("result_backup.txt", "w") as f:
            f.write(data)


    @make.taska("modify_result", depends=["result.txt"])
    def modify_result():
        print("Изменение файла result.txt...")
        with open("result.txt", "r") as f:
            data = f.read()
        modified_data = data + "\nIKBO-12-22\ndfsdjfjsdfjsjf\n123\n567"
        with open("result.txt", "w") as f:
            f.write(modified_data)

    @make.taska("clean")
    def clean():
        print("Очистка...")
        if os.path.exists("result.txt") or os.path.exists("input.txt") or os.path.exists("result_backup.txt"):
            os.remove("result.txt")
            os.remove("input.txt")
            os.remove("result_backup.txt")


    @make.taska("restore", depends=["result_backup.txt"])
    def restore_from_backup():
        print("Восстановление result.txt из резервной копии...")
        with open("result_backup.txt", "r") as f:
            data = f.read()
        with open("result.txt", "w") as f:
            f.write(data)


    parser = ArgumentParser(description='Справка', formatter_class=SmartFormatter)

    parser.add_argument('command', default='create_input',
                        help="R| Option \t\tDescription\n"
                             " create_input - создать входной файл\n"
                             " process_input - создать выходной файл\n"
                             " backup_result - создать бэкап выходного файла\n"
                             " modify_result - изменить выходной файл\n"
                             " clean - удалить входной и выходной файлы\n"
                             " restore - восстановить выходной файл из бэкапа\n")

    args = parser.parse_args()

    parser.parse_args()

    command = args.command

    if command == "create_input":
        make.build("input.txt")
    elif command == "process_input":
        make.build("result.txt")
    elif command == "backup_result":
        make.build("result_backup.txt")
    elif command == "modify_result":
        make.build("modify_result")
    elif command == "run":
        make.build("run")
    elif command == "clean":
        make.build("clean")
    elif command == "restore":
        make.build("restore")
    else:
        print(f"Неизвестная команда: {command}")
