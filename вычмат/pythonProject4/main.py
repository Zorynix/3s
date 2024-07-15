import numpy as np
import matplotlib.pyplot as plt

K = 2.6
L = 1.4
#L = 1.2 #пример
#K = 2.2 #пример
a = (K - L) / 2  # 0.5
b = K + L  # 3.8

I = ((1/2) * np.log(b**2 + b + K) + (L - (1/2))/(np.sqrt(K - (1/4))) * np.arctan((b + 1/2)/(np.sqrt(K - 1/4)))) - ((1/2) * np.log(a**2 + a + K) + (L - 1/2)/(np.sqrt(K - 1/4)) * np.arctan((a + 1/2)/(np.sqrt(K - 1/4))));

print(f"Точное значение: {round(I, 5)}")

n_values = [4, 6]


def f(x):
    result = (x + L) / (x ** 2 + x + K)
    return result


print("\nМетод трапеций:")

restrap = []


def trapezoidal_method():
    results = []
    for n_value in n_values:
        h = (b - a) / n_value
        x_values = [a + i * h for i in range(n_value + 1)]
        f_values = [f(x) for x in x_values]
        fraction = round((round(f_values[0], 4) + round(f_values[-1], 4)) / 2, 4)
        amount = round(sum(f_values[1:-1]), 4)
        total = fraction + amount
        trapezoidal_result = round(h, 4) * round(total, 4)
        results.append(f"Результат для n={n_value}: {round(trapezoidal_result, 7)}, "
                       f"{', '.join([f'f(x{i}) = {round(f(x), 3)}' for i, x in enumerate(x_values)])}, "
                       f"h = {round(h, 3)}, x_i = {x_values}")
        restrap.append(round(trapezoidal_result, 7))
    return results


trapezoidal_results = trapezoidal_method()
for result in trapezoidal_results:
    print(result)

print("\nМетод парабол: ")

respar = []


def parabolic_method():
    results = []

    for n_value in n_values:
        h = (b - a) / (2 * n_value)

        x_values = [a + i * h for i in range(2 * n_value + 1)]
        f_values = [f(x) for x in x_values]

        multiplier = round(h, 5) / 3
        amount = round(f_values[0], 3) + round(f_values[-1], 3) + (2 * round(sum(f_values[2:-1:2]), 3)) + (
                    4 * round(sum(f_values[1:-1:2]), 3))
        parabolic_result = multiplier * amount
        # print(f"То что на 2: {sum(f_values[2:-1:2])}, То что на 4: {sum(f_values[1:-1:2])}")
        results.append(f"Результат для n={n_value}: {round(parabolic_result, 7)}, "
                       f"{', '.join([f'f(x{i}) = {round(f(x), 3)}' for i, x in enumerate(x_values)])}, "
                       f"h = {round(h, 4)}, x_i = {x_values}")
        respar.append(round(parabolic_result, 7))
    return results


parabolic_results = parabolic_method()
for result in parabolic_results:
    print(result)

print("\nМетод Гаусса: ")

resgau = []


def gauss_method():
    global a
    results = []

    ti_values = {
        4: (-0.861136, -0.339981, 0.339981, 0.861136),
        6: (-0.932464, -0.661209, -0.238619, 0.238619, 0.661209, 0.932464),
        #8: (-0.960289, -0.796666, -0.525532, -0.183434, 0.183434, 0.525532, 0.796666, 0.960289)
    }

    ai_values = {
        4: (0.347854, 0.652145, 0.652145, 0.347854),
        6: (0.171324, 0.360761, 0.467913, 0.467913, 0.360761, 0.171324),
        #8: (0.101228, 0.222381, 0.313706, 0.362683, 0.362683, 0.313706, 0.222381, 0.101228)
    }

    for n_value in n_values:
        arg_values = [(a + b) / 2 + ((b - a) / 2) * t for t in ti_values[n_value]]
        i_values = [f(arg) for arg in arg_values]

        gaussian_result = (b - a) / 2 * sum(a * i for a, i in zip(ai_values[n_value], i_values))

        results.append(f"Результат для n={n_value}: {round(gaussian_result, 7)}, "
                       f"{', '.join([f'f(t{i}) = {round(f(arg), 5)}' for i, arg in enumerate(arg_values)])}, "
                       f"x_i = {arg_values}")
        resgau.append(round(gaussian_result, 7))
    return results


gaussian_results = gauss_method()
for result in gaussian_results:
    print(result)

exact_value = round(I, 4)



n_values = [4, 6]

plt.figure(figsize=(15, 5))

plt.subplot(131)
plt.plot(n_values, [exact_value - result for result in restrap], 'ro-')
plt.title('Метод трапеций')
plt.xlabel('n')
plt.ylabel('Разница с точным значением')

plt.subplot(132)
plt.plot(n_values, [exact_value - result for result in respar], 'bo-')
plt.title('Метод парабол')
plt.xlabel('n')
plt.ylabel('Разница с точным значением')

plt.subplot(133)
plt.plot(n_values, [exact_value - result for result in resgau], 'go-')
plt.title('Метод Гаусса')
plt.xlabel('n')
plt.ylabel('Разница с точным значением')

plt.tight_layout()
plt.show()