package ru.job4j.array;

/**
 * Class MatrixCheck
 * Класс проверки матриц
 *
 * @author Petr B.
 * @since 29.07.2019
 * @version 1
 */
public class MatrixCheck {
    /**
     * Метод mono
     * Проверяет матрицу на совпадение по диоганали, если диоганали равны,
     * или если одна диоганаль отлична от другой не имея равных элементов, возвращается true иначе false.
     * @param data boolean[] матрица
     * @return true/false
     */
    public boolean mono(boolean[][] data) {
        boolean result = true;
        int size = data.length;
        for (int index = 0; index < size; index++) {
                if (data[0][0] != data[index][index]) {
                    result = false;
                    break;
                } else if (data[size - 1][0] != data[size - 1 - index][index]) {
                    result = false;
                    break;
                }
        }
        return result;
    }
}
