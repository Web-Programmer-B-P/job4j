package ru.job4j.loop;

/**
 * Class PrimeNumber
 *
 * @author Petr B.
 * @version 1
 * @since 04.08.2019
 */
public class PrimeNumber {
    public int calc(int finish) {
        int count = 0;
        for (int i = 2; i <= finish; i++) {
            int check = 0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    check++;
                }
            }
            if (check == 2) {
                count++;
            }
        }
        return count;
    }
}
