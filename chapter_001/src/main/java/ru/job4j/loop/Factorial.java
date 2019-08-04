package ru.job4j.loop;

/**
 * Class Factorial
 *
 * @author Petr B.
 * @since 04.08.2019
 * @version 1
 */
public class Factorial {
    /**
     * Method calc
     * Метод поиска факториала
     * @param n
     * @return
     */
    public int calc(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
