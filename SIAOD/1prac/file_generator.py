def create_number_file(filename, start, end):
    try:
        with open(filename, 'w') as file:
            for number in range(end, start - 1, -1):
                file.write(str(number) + ' ')
        print(f"Файл {filename} успешно создан.")
    except IOError:
        print(f"Произошла ошибка при создании файла {filename}.")
filename = 'cmake-build-debug/test.txt'
start_number = 0
end_number = 8388607

create_number_file(filename, start_number, end_number)