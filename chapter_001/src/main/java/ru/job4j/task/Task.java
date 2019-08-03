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
        int sizeForNewArray = left.length + right.length;
        int first = left[0] < right[0] ? left[0] : right[0];
        int[] finishArray = new int[sizeForNewArray];
        //Объединяем массив в один
        for (int index = 0; index < finishArray.length; index ++) {
            if (index <= left.length - 1) {
                finishArray[index] = left[index];
            } else {
                finishArray[index] = right[index - left.length];
            }
        }

        FindLoop sort = new FindLoop();
        int[] array = sort.sort(finishArray);
        return array;
    }
}
