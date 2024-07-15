from zipfile import ZipFile
import sys
import argparse


def delete_symbol(path):
    '''Обрезает абсолютный путь'''
    for letter in path:
        if letter == "/":
            path = path[1:]
        else:
            break
    return path


def ls(path, files, folder=None):
    """Функция ls как в bash Linux"""
    path = delete_symbol(path)
    items = set()

    for file in files:
        if folder:
            if folder in file.filename:
                file_names = file.filename[len(folder):].split("/")
            else:
                continue
        else:
            if path in file.filename:
                file_names = file.filename[len(path):].split("/")
            else:
                continue

        file_names = list(filter(None, file_names))
        if len(file_names) > 1 or not file_names:
            continue
        items.add(file_names[0])

    for item in sorted(items):
        print("\033[33m{}\033[0m".format(item))



def cd(path, extension_path, files):
    global local_path
    """Функция cd как в bash Linux"""
    # print(path)
    flag = False
    for file in files:
        if file.filename.startswith(local_path + extension_path):
            flag = True
            break
    if "root:" in extension_path:
        '''Обработка случая если введен абсолютный путь до файла'''
        path = extension_path[len("root:"):]
    else:
        if extension_path == "~":
            path = ""
        else:
            path += extension_path + "/"
    path = delete_symbol(path)

    if path == "":
        local_path = ""
        return True

    if ".." in path:
        tmp = local_path.split("/")[:-1]
        if len(tmp) == 1 and "/".join(tmp) == tmp[0]:
            local_path = ""
        else:
            local_path = "/".join(tmp)
        # local_path = "/".join(local_path.split("/")[:-1])
        # local_path = #local_path[:len(local_path) - len(local_path.split("/")[-1]) - 1]
        return True
    if not flag:
        return False

    for file in files:
        if path in file.filename:
            local_path = path
            return True
    return False


def cat(path, extension_path, zip_file):
    """Функция cat как в bash Linux"""

    if not extension_path:
        print("\033[31m{}\033[0m".format("No file specified"))
        return

    if "root:" in extension_path:
        path = extension_path[len("root:"):]
    else:
        path += extension_path
    path = delete_symbol(path)

    try:
        with ZipFile(zip_file) as files:
            with files.open(path, 'r') as file:
                for line in file.readlines():
                    print(line.decode('utf8').strip())
    except (KeyError, IndexError):
        print("\033[31m{}\033[0m".format("Can't open this file"))



if __name__ == '__main__':
    parser = argparse.ArgumentParser()
    parser.add_argument('zipfile', type=str, help='The ZIP file to work with')
    parser.add_argument('--script', type=str, help='Read commands from a file and execute them')

    args = parser.parse_args()

    zipfile = ZipFile(args.zipfile)
    ROOT_PATH = "root:"
    local_path = ""

    all_files = zipfile.filelist

    # try:
    #     sys.argv[1]
    # except IndexError:
    #     exit(0)
    # zipfile = ZipFile(sys.argv[1])
    # ROOT_PATH = "root:"
    # local_path = ""

    if args.script:
        try:
            with open(args.script, 'r') as script_file:
                for command in script_file:
                    command = command.strip().split(" ")
                    if command[0] == "pwd":
                        print("\033[32m{}\033[0m".format("  " + ROOT_PATH + ("/" if not local_path else local_path)))
                    elif command[0] == "ls":
                        if len(command) == 1:
                            ls(local_path, all_files)
                        elif len(command) == 2:
                            if command[1] != "ls":
                                ls(local_path, all_files, command[1])
                        elif len(command) == 3:
                            ls(local_path, all_files, command[1] + '/' + command[2])
                    elif command[0] == "cd":
                        if cd(local_path, command[1], all_files):
                            pass
                        else:
                            print("\033[31m{}\033[0m".format("The path does not exist"))
                    elif command[0] == "cat":
                        if len(command) < 2:
                            print("\033[31m{}\033[0m".format("No file specified"))
                        else:
                            cat(local_path, command[1], sys.argv[1])

                else:
                        print("\033[31m{}\033[0m".format("Don`t know this command"))
        except IOError as e:
            if e.errno == 2:
                print("\033[31m{}\033[0m".format(f"The file '{args.script}' does not exist"))
            else:
                raise e

    else:
        command = input(ROOT_PATH + "/> ")
        all_files = zipfile.filelist
        while command != "exit":
            command = command.split(" ")
            if command[0] == "pwd":
                # ("/" if not local_path else local_path) проверка пуст ли local_path
                print("\033[32m{}\033[0m".format("  " + ROOT_PATH + ("/" if not local_path else local_path)))

            elif command[0] == "ls":
                if (len(command) == 1):
                    ls(local_path, all_files)
                else:
                    ls(local_path, all_files, command[1])

            elif command[0] == "cd":
                try:
                    command[1]
                except IndexError:
                    print("\033[31m{}\033[0m".format("Don`t know this command"))
                if cd(local_path, command[1], all_files):
                    pass
                else:
                    print("\033[31m{}\033[0m".format("The path does not exist"))

            elif command[0] == "cat":
                if len(command) < 2:
                    print("\033[31m{}\033[0m".format("No file specified"))
                else:
                    cat(local_path, command[1], sys.argv[1])

            else:
                print("\033[31m{}\033[0m".format("Don`t know this command"))

            command = input(ROOT_PATH + ("/" if not local_path else local_path) + "> ")
