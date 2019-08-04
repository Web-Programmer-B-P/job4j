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
        int[] finishArray = new int[sizeForNewArray];
        //Счетчики для индексации входящих массивов
        int l = 0, r = 0;
        for (int index = 0; index < finishArray.length; index++) {
            if (l < left.length && r < right.length) {
                if (left[l] < right[r]) {
                    finishArray[index] = left[l];
                    l++;
                } else {
                    finishArray[index] = right[r];
                    r++;
                }
            } else if (l == left.length) {
                finishArray[index] = right[r];
            } else {
                finishArray[index] = left[l];
            }
        }
        
        return finishArray;
    }
}
