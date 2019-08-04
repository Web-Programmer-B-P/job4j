package ru.job4j.condition;

/**
 * Class SqArea
 *
 * @author Petr B.
 * @since 04.08.2019
 * @version 1
 */
public class SqArea {
    /**
     * Метод square
     * @param p
     * @param k
     * @return int square
     */
    public static int square(int p, int k) {
        int h = p / (2 * (k + 1));
        int w = k * h;
        int s = w * h;
        return s;
    }
}
