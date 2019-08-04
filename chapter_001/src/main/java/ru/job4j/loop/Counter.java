package ru.job4j.loop;

/**
 * Class Counter
 *
 * @author Petr B.
 * @since 04.08.2019
 * @version 1
 */
public class Counter {
    /**
     * Method add
     * @param start
     * @param finish
     * @return int sum
     */
    public int add(int start, int finish) {
        int sum = 0;
        for (int i = start; i <= finish; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        return sum;
    }
}
