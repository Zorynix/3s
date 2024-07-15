import decimal
from fractions import Fraction

import numpy as np

print("МЕТОД ГАУССА")

# Создаем левую часть матрицы
left_matrix = np.array([[1, 2, 1], [5, -4, -7], [2, 1, -1]], dtype=float)
# Создаем правую часть матрицы
right_side = np.array([8, 0, 7], dtype=float)

print("1 ИТЕРАЦИЯ")


def forward_elimination(matrix, right_side, step):
    n = matrix.shape[0]

    # Находим коэффициенты c11, c12, c13, g1
    c = matrix[step, step]
    for j in range(n):
        matrix[step, j] /= c
        print(f'c{step + 1}{j + 1} = {matrix[step, j]}')
    right_side[step] /= c
    print(f'g{step + 1} = {right_side[step]}')

    # Применяем операции к остальным строкам
    for i in range(n):
        if i != step:
            factor = matrix[i, step]
            for j in range(n):
                matrix[i, j] -= factor * matrix[step, j]
            right_side[i] -= factor * right_side[step]

            # Вычисляем и выводим коэффициенты x для второй строки
            # x = matrix[i, step] - (matrix[i, step] * (matrix[step, step] / matrix[step, step]))
            # print(f'x{i + 1}{step + 1} = {x}')
            #
            # # Вычисляем и выводим коэффициенты y для третьей строки
            # y = matrix[i, step + 1] - (matrix[i, step] * (matrix[step, step + 1] / matrix[step, step]))
            # print(f'y{i + 1}{step + 2} = {y}')

    return matrix, right_side


# Выводим элементы преобразованной матрицы
print("Коэффициенты преобразованной матрицы:")

# Применяем функцию для первой итерации
left_matrix, right_side = forward_elimination(left_matrix, right_side, 0)

# Выводим элементы преобразованной матрицы в строчку
print(f'a21 = {left_matrix[1, 0]}, a22 = {left_matrix[1, 1]}, a23 = {left_matrix[1, 2]}, b2 = {right_side[1]}, '
      f'\na31 = {left_matrix[2, 0]}, a32 = {left_matrix[2, 1]}, a33 = {left_matrix[2, 2]}, b3 = {right_side[2]}')

print("\nПреобразованная расширенная матрица:")
print(np.column_stack((left_matrix, right_side)))
print("\n")

print("2 ИТЕРАЦИЯ")


def second_iteration(matrix, right_side, step):
    n = matrix.shape[0]

    c = matrix[step, step]
    for j in range(n):
        matrix[step, j] /= c
        print(f'c{step + 1}{j + 1} = {matrix[step, j]}')
    right_side[step] /= c
    print(f'g{step + 1} = {right_side[step]}')

    # Применяем операции к остальным строкам
    for i in range(1, n):
        if i != step:
            factor = matrix[i, step]
            for j in range(n):
                matrix[i, j] -= factor * matrix[step, j]
            right_side[i] -= factor * right_side[step]

    return matrix, right_side


# Применяем функцию для второй итерации
left_matrix, right_side = second_iteration(left_matrix, right_side, 1)

# Выводим элементы преобразованной матрицы в строчку
print(f'a32 = {left_matrix[2, 1]}, a33 = {left_matrix[2, 2]}, b3 = {right_side[2]}')

print("\nПреобразованная расширенная матрица:")
print(np.column_stack((left_matrix, right_side)))
print("\n")

print("3 ИТЕРАЦИЯ")


def third_iteration(matrix, right_side, step):
    n = matrix.shape[0]

    c = matrix[step, step]
    for j in range(n):
        matrix[step, j] /= c
        print(f'c{step + 1}{j + 1} = {matrix[step, j]}')
    right_side[step] /= c
    print(f'g{step + 1} = {right_side[step]}')

    # Применяем операции к остальным строкам
    for i in range(2, n):
        if i != step:
            factor = matrix[i, step]
            for j in range(n):
                matrix[i, j] -= factor * matrix[step, j]
            right_side[i] -= factor * right_side[step]

    return matrix, right_side


# Применяем функцию для третьей итерации
left_matrix, right_side = third_iteration(left_matrix, right_side, 2)

# Выводим элементы преобразованной матрицы в строчку
print(f'a31 = {left_matrix[2, 0]}, a32 = {left_matrix[2, 1]}, a33 = {left_matrix[2, 2]}, b3 = {right_side[2]}')

# Выводим преобразованную расширенную матрицу
print("Преобразованная расширенная матрица:")
print(np.column_stack((left_matrix, right_side)))

print("\nОбратный ход")


def backward_substitution(matrix, right_side):
    n = matrix.shape[0]
    x = np.zeros(n)

    for i in range(n - 1, -1, -1):
        x[i] = right_side[i]
        for j in range(i + 1, n):
            x[i] -= matrix[i, j] * x[j]

    return x


# Применяем обратный ход
solutions = backward_substitution(left_matrix, right_side)

# Выводим корни
for i, sol in enumerate(solutions):
    print(f"x{i + 1} = {sol}")



# Метод ортогонализации
# Создаем левую часть матрицы


print("\nМЕТОД ОРТОГОНАЛИЗАЦИИ")


def to_fraction(decimal):
    return f"{Fraction(decimal).limit_denominator()}"


def vector_to_fraction(vector):
    return [f"{Fraction(element).limit_denominator().numerator}/{Fraction(element).limit_denominator().denominator}" for
            element in vector]


# left_matrix = np.array([[1, 1, -1], [2, 1, 1], [1, -1, 1]], dtype=float)
# # Создаем правую часть матрицы
# right_side = np.array([0, 7, 2], dtype=float)

left_matrix = np.array([[1, 2, 1], [5, -4, -7], [2, 1, -1]], dtype=float)
# Создаем правую часть матрицы
right_side = np.array([8, 0, 7], dtype=float)

# Задаем vec(r1) как первый столбец матрицы
vec_r1 = left_matrix[:, 0]

# Задаем vec(a1) как первый столбец матрицы
vec_a1 = left_matrix[:, 0]

# Задаем vec(a2) как второй столбец матрицы
vec_a2 = left_matrix[:, 1]

# Задаем vec(a3) как третий столбец матрицы
vec_a3 = left_matrix[:, 2]

print("\nВектор r1:")
print(vector_to_fraction(vec_r1))

# Вычисляем t12
t12 = np.dot(vec_r1, vec_a2) / np.dot(vec_r1, vec_r1)
print(f'\nt12={to_fraction(t12)}')

# Вычисляем vec(r2) и преобразуем к обыкновенной дроби
vec_r2 = vec_a2 - t12 * vec_r1

# Вычисляем t13
t13 = np.dot(vec_r1, vec_a3) / np.dot(vec_r1, vec_r1)

# Вычисляем t23
t23 = np.dot(vec_r2, vec_a3) / np.dot(vec_r2, vec_r2)

# Выводим результаты
print("\nВектор r2:")
print(vector_to_fraction(vec_r2))

# Выводим результаты
print(f'\nt13={to_fraction(t13)}')
print(f'\nt23={to_fraction(t23)}')

# Вычисляем vec(r3)
vec_r3 = vec_a3 - t13 * vec_r1 - t23 * vec_r2

# Выводим результаты
print("\nВектор r3:")
print(vector_to_fraction(vec_r3))

# Создаем матрицу R
rvecr1 = vector_to_fraction(vec_r1)
rvecr2 = vector_to_fraction(vec_r2)
rvecr3 = vector_to_fraction(vec_r3)
R = np.column_stack((rvecr1, rvecr2, rvecr3))

# Создаем матрицу T
tt12 = to_fraction(t12)
tt13 = to_fraction(t13)
tt23 = to_fraction(t23)
T = np.array([[1, tt12, tt13],
              [0, 1, tt23],
              [0, 0, 1]])

# Выводим матрицу A в виде A = R * T
print(f"A=R*T :\n {R} \n\n\t\t* \n\n {T}")

# Создаем вектор b
vec_b = right_side
# Вычисляем x3
x3 = round(np.dot(vec_r3, vec_b) / np.dot(vec_r3, vec_a3), 3)

# Выводим результаты
print(f"\nx3: {x3}")

# Вычисляем новый вектор b1
b1 = vec_b - vec_a3 * x3

# Выводим результаты
print("\nВектор b1:")
print(b1)

# Вычисляем x2
x2 = round(np.dot(vec_r2, b1) / np.dot(vec_r2, vec_a2), 3)

# Выводим результаты
print(f"\nx2: {x2}")

# Вычисляем новый вектор b2
b2 = b1 - vec_a2 * x2

# Выводим результаты
print("\nВектор b2:")
print(b2)

# Вычисляем x1
x1 = round(np.dot(vec_r1, b2) / np.dot(vec_r1, vec_a1), 3)

# Выводим результаты
print(f"\nx1: {x1}")
