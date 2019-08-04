package ru.job4j.task;

import ru.job4j.array.FindLoop;
/**
 * Class Task
 * Тестовая задача
 *
 * @autor Barsukov Petr
 * @since 03.08.2019
 * @version 1
 */
public class Task {
    /**
     * Метод merge
     * Объединение двух отсортированных по возрастанию массивов в один
     * @param left int[] массив
     * @param right int[] массив
     * @return int[] объедененные массивы left и right
     */
    public int[] merge(int[] left, int[] right) {
        int size = left.length + right.length;
        int[] result = new int[size];
        int l = 0, r = 0;
        for (int index = 0; index < result.length; index++) {
            if (l < left.length && r < right.length) {
                if (left[l] < right[r]) {
                    result[index] = left[l];
                    l++;
                } else {
                    result[index] = right[r];
                    r++;
                }
            } else if (l == left.length) {
                result[index] = right[r];
            } else {
                result[index] = left[l];
            }
        }

        return result;
    }
}
