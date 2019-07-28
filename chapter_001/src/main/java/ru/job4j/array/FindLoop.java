package ru.job4j.array;

/**
 * Class FindLoop
 * Класс поиска элементов в массиве
 *
 * @author Petr B.
 * @since 28.07.2019
 * @version 1
 */
public class FindLoop {
    /**
     * indexOf
     * @param data массив int[] в котором ищем элемент
     * @param el элемент который ищем
     * @return int -1 если не найден, 0 если найден.
     */
    public int indexOf(int[] data, int el) {
        int rst = -1; // если элемента нет в массиве, то возвращаем -1.
        for (int index = 0; index < data.length; index++) {
            if (data[index] == el) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}
