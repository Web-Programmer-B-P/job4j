package ru.job4j.task;

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
        int sizeForNewArray = left.length + right.length;
        int[] finishArray = new int[sizeForNewArray];
        for (int index = 0, count = 0; index < left.length; index ++, count++) {
            finishArray[count] = left[index];
            finishArray[++count] = right[index];
        }
        return finishArray;
    }
}
