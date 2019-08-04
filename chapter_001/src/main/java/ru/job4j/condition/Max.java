package ru.job4j.condition;

/**
 * Class Max
 *
 * @author Petr B
 * @version 1
 * @since 04.08.2019
 */
public class Max {
    /**
     * Метод max
     * Находит максимальное из двух
     * @param left
     * @param right
     * @return int max
     */
    public int max(int left, int right) {
        int result = left > right ? left : right;
        return result;
    }
}
