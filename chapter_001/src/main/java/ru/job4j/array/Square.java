package ru.job4j.array;

/**
 * Class Square
 * Класс для возведения в квадрат
 *
 * @author Petr B.
 * @since 28.07.2019
 * @version 1
 */
public class Square {
    /**
     * Возведение в квадрат
     * @param bound единственный параметр
     * @return Возвращает int[]
     */
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        // заполнить массив через цикл элементами от 1 до bound возведенными в квадрат
        for (int index = 0, square = 1; index < rst.length; index++, square++){
            rst[index] = square * square;
        }
        return rst;
    }
}
