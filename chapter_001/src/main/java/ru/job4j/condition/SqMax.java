package ru.job4j.condition;

/**
 * Class SqMax
 *
 * @author Petr B.
 * @since 04.08.2019
 * @version 1
 */
public class SqMax {
    /**
     * Метод max
     * @param first
     * @param second
     * @param third
     * @param forth
     * @return int max
     */
    public static int max(int first, int second, int third, int forth) {
        int result = forth;
        if (first > second) {
            if (first > third) {
                if (first > forth) {
                    result = first;
                }
            } else {
                if (third > forth) {
                    result = third;
                }
            }
        } else if (second > third) {
                if (second > forth) {
                    result = second;
                }
        } else if (third > forth) {
            result = third;
        }
        return result;
    }
}