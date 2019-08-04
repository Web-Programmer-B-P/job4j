package ru.job4j.condition;

/**
 * Class MultiMax
 *
 * @author Petr B.
 * @since 04.08.2019
 * @version 1
 */
public class MultiMax {
    /**
     * Метод max
     * Находит максимальное из трех
     * @param first
     * @param second
     * @param third
     * @return int max
     */
    public int max(int first, int second, int third) {
        int result = first;
        if (third > second) {
            result = third;
        } else if (second > third) {
            result = second;
        }
        return result > first ? result : first;
    }
}
