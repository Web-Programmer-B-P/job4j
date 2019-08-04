package ru.job4j.loop;

/**
 * Class Mortgage
 *
 * @author Petr B.
 * @since 04.08.2019
 * @version 1
 */
public class Mortgage {
    /**
     * Method year
     * Метод рассчета  колличества лет нужных для погашения задолжности
     * @param amount сумма
     * @param monthly платеж
     * @param percent процент
     * @return
     */
    public int year(int amount, int monthly, double percent) {
        int year = 0;
        double sum = ((amount / 100) * percent) + amount;
        int i = 1;
        while (sum > monthly) {
            if (year == 0) {
                monthly *= 12;
                year++;
            } else {
                monthly *= i;
                year++;
            }
            i++;
        }
        return year;
    }
}
