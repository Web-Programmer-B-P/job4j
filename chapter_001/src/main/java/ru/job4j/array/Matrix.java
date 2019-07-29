package ru.job4j.array;

/**
 * Class Matrix
 * Класс строит матрицу
 *
 * @author Petr B.
 * @since 29.07.2019
 * @version 1
 */
public class Matrix {
    /**
     * Метод multiple
     * Заполняет матрицу квадратами чисел
     * @param size размер матрицы
     * @return int[][] заполненую матрицу
     */
    public int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int col = 0; col < size; col++) {
            for (int row = 0; row < size; row++) {
                table[col][row] = (col + 1) * (row + 1);
            }
        }
        return table;
    }
}
