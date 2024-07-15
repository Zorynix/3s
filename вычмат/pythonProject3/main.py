import numpy as np
from scipy.integrate import quad
K = 2.4
L = 1.4
a = (K - L) / 2
b = K + L

def f(x):
    return 1/2 * np.log(x**2 + x + K) + (L - 1/2) / np.sqrt(K - 1/4) * np.arctan((x + 1/2) / (K - 1/4))

# Вычисляем интеграл
result, error = quad(f, a, b)

# Выводим результат
print("Результат интегрирования:", result)

# Вывод результата
print("Результат интегрирования:", integral_result)
