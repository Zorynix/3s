import matplotlib.pyplot as plt
import numpy as np
import scipy.optimize as opt

# Заданные параметры a и b
a = 1.5  # 1 |2.5
b = 2.21  # 2.16 | 2.49
epsilon = 10 ** (-3)
interval_simple_iteration = [-3.21, -1.6726213173888271]  # -3.16,0.8786151641107001] | -3.49, 3.8766084459023515
interval_chord_secant = [-1.71, -0.5]  # -1,66 | -1.99
interval_newton = [0.1992879312259923, 2]  # -2.1607566146331054 | -6.458738445902346


# Уравнение F(x) = ax^3 + bax^2 – ax – ba
def F(x):
    return a * x ** 3 + b * a * x ** 2 - a * x - b * a



# Производная функции F(x)
def F_prime(x):
    return 3 * a * x ** 2 + 2 * b * a * x - a


# Функция для нахождения минимума функции F(x)
def find_minimum_value(x):
    return F(x)


# для нахождения максимума функции F(x)
def find_maximum_value(x):
    return -F(x)


# Находим точки минимума и максимума
min_point = opt.minimize(find_minimum_value, 0)
max_point = opt.minimize(find_maximum_value, 0)

# Значения функции в точках минимума и максимума
min_value = min_point.fun
max_value = -max_point.fun

# Выводим результаты
print(f"Минимум функции: значение F(xmin) = {min_value}, x = {min_point.x[0]}")
print(f"Максимум функции: значение F(xmax) = {max_value}, x = {max_point.x[0]}")


# Метод простой итерации
def simple_iteration_method(max_iterations=1000):
    x0 = -3.21  # Начальное значение
    xi = 0
    iterations = 0

    x_values = [x0]
    y_values = [F(x0)]

    while iterations < max_iterations:
        xi = x_values[iterations] - F(x_values[iterations]) * ((b - a) / (F(b) - F(a)))
        print(f"xi = {xi}, F(xi) = {F(xi)}, Проверка = {F(xi - epsilon) * F(xi + epsilon)}")
        x_values.append(xi)
        y_values.append(F(xi))
        iterations += 1

        if F(xi - epsilon) * F(xi + epsilon) < 0:
            break

    return xi, iterations, x_values, y_values


def chord_method(max_iterations=100):
    x0 = a
    xi = 0
    iterations = 0

    x_values = [x0]
    y_values = [F(x0)]

    while iterations < max_iterations:
        xi = x_values[iterations] - F(x_values[iterations]) * (
                (b - x_values[iterations]) / (F(b) - F(x_values[iterations])))
        print(f"xi = {xi}, F(xi) = {F(xi)}, Проверка = {F(xi - epsilon) * F(xi + epsilon)}")
        x_values.append(xi)
        y_values.append(F(xi))
        iterations += 1

        if F(xi - epsilon) * F(xi + epsilon) < 0:
            break
            # print(xi)

    return xi, iterations, x_values, y_values


# Метод касательных (метод Ньютона)
def newton_method(max_iterations=1000):
    x0 = a  # Начальное значение
    iterations = 0
    xi = 0
    x_values = [x0]
    y_values = [F(x0)]

    while iterations < max_iterations:
        xi = x_values[iterations] - (F(x_values[iterations]) / F_prime(x_values[iterations]))
        #print(x_values[iterations],F(x_values[iterations]),F_prime(x_values[iterations]))
        #print(f"xi = {xi}, F(xi) = {F(xi)}, Проверка = {F(xi - epsilon) * F(xi + epsilon)}")
        #print(xi, F(xi), F(xi - epsilon) * F(xi + epsilon))
        x_values.append(xi)
        y_values.append(F(xi))
        iterations += 1

        if F(xi - epsilon) * F(xi + epsilon) < 0:
            break

    return xi, iterations, x_values, y_values


# Решение уравнения и получение результатов
result_simple_iteration = simple_iteration_method(100)
result_chord = chord_method(100)
result_newton = newton_method(100)

# Вывод результатов
print(
    f"Метод простой итерации: корень = {result_simple_iteration[0]}, количество итераций = {result_simple_iteration[1]}")
print(f"Метод хорд: корень = {result_chord[0]}, количество итераций = {result_chord[1]}")
print(f"Метод касательных (метод Ньютона): корень = {result_newton[0]}, количество итераций = {result_newton[1]}")

# Построение графика

# Рисуем оси абсцисс и ординат
plt.axhline(0, color='black', linewidth=0.5)
plt.axvline(0, color='black', linewidth=0.5)
x_values = np.linspace(-3, 2, 1000)
y_values = F(x_values)

plt.plot(x_values, y_values, label='F(x)')
plt.plot(result_simple_iteration[2], result_simple_iteration[3], label='Simple Iteration', marker='o')
plt.plot(result_chord[2], result_chord[3], label='Chord', marker='o')
plt.plot(result_newton[2], result_newton[3], label='Newton', marker='o')

plt.xlabel('x')
plt.ylabel('|xi-xi-1|')
plt.legend()
plt.show()
