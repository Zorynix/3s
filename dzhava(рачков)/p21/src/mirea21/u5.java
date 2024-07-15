package mirea21;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;


public class u5<T, K, V> {
    private T genericT;
    private K genericK;
    private V genericV;

    public u5(T t, K k, V v) {
        this.genericT = t;
        this.genericK = k;
        this.genericV = v;
    }

    // Создать и вернуть ArrayList
    public List<T> newArrayList(T... elements) {
        List<T> list = new ArrayList<>();
        for (T element : elements) {
            list.add(element);
        }
        return list;
    }

    // Создать и вернуть HashSet, параметризированный типом T
    public HashSet<T> newHashSet(T... elements) {
        // Создание нового HashSet
        HashSet<T> set = new HashSet<>();
        // Добавление переданных элементов в HashSet
        for (T element : elements) {
            set.add(element);
        }
        return set;
    }

    // Создать и вернуть HashMap, параметризированный типами K и V
    public HashMap<K, V> newHashMap(K[] keys, V[] values) {
        // Проверка на равное количество ключей и значений
        if (keys.length != values.length) {
            throw new IllegalArgumentException("Количество ключей и значений должно быть одинаковым.");
        }

        // Создание нового HashMap
        HashMap<K, V> map = new HashMap<>();
        // Заполнение HashMap ключами и значениями из переданных массивов
        for (int i = 0; i < keys.length; i++) {
            map.put(keys[i], values[i]);
        }
        return map;
    }
}
//Хэширование – это техника, используемая для отображения данных
// на фиксированное значение, известное как хэш-код или хэш.
// Она берет входные данные, выполняет некоторые вычисления над ними и генерирует уникальный хэш-код.
// Полученный хэш-код используется в качестве индекса или
// ключа для хранения или извлечения данных из структуры данных.