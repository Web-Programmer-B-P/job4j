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

    public int max(int first, int second, int third) {
        int result = max(first, max(second, third));
        return result;
    }

    public int max(int first, int second, int third, int fourth) {
        int result = max(max(first, second), max(third, fourth));
        return result;
    }
}
