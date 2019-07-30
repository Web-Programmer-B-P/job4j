package ru.job4j.loop;

public class Mortgage {
    public int year(int amount, int monthly, double percent) {
        int year = 0;
        double sumAmountWithPrecent = (amount / 100) * percent + amount;
        /**
         * Счетчик на который мы умножаем сумму годового платежа,
         * увеличивая сумму последовательно на 2, 3, 4 можем понять после скольких лет достигнем суммы долга.
         */
        int i = 1;
        while (sumAmountWithPrecent > monthly) {
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
