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

    /**
     * Метод indexOf
     * @param data массив int[] в котором ищем элемент
     * @param el элемент который ищем
     * @param start элемент с которого начинается диапазон
     * @param finish элемент закрывающий диапазон поиска
     * @return int -1 если не найден, индекс элемента если найден.
     */
    public int indexOf(int[] data, int el, int start, int finish) {
        int rst = -1; // если элемента нет в массиве, то возвращаем -1.
        for (int index = start; index < finish; index++) {
            if (data[index] == el) {
                rst = index;
                break;
            }
        }
        return rst;
    }

    /**
     * Метод sort
     * Сортировка по возрастанию
     * @param data массив который сортируем
     * @return data отсортированный
     */
    public int[] sort(int[] data) {
        int first = 0 , second;
        for (int index = 0; index < data.length; index++) {
            first = this.indexOf(data, index + 1, index, data.length);
            second = data[index];
            if (data[first] < second) {
                data[index] = data[first];
                data[first] = second;
            }
        }
        return data;
    }
}
