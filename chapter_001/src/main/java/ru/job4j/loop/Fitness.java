package ru.job4j.loop;

/**
 * Class Fitness
 *
 * @author Petr B.
 * @since 04.08.2019
 * @version 1
 */
public class Fitness {
    /**
     * Method calc
     * Метод поиска колличества месяцев для превосхождения
     * @param ivan спортсмен которог нужно обогнать
     * @param nik спортсмен которому нужно обогнать
     * @return int месяцев
     */
    public int calc(int ivan, int nik) {
        int month = 0;
        while (ivan < nik) {
            nik *= 2;
            ivan *= 3;
            month++;
        }
        return month;
    }
}
