package ru.job4j.array;

import java.util.Arrays;

/**
 * Class ArrayDuplicate
 *
 * @autor Petr B.
 * @since 30.07.2019
 * @version 1
 */
public class ArrayDuplicate {
    /**
     * Метод remove устраняет повторяющиеся элементы в массиве
     * @param array исходный массив
     * @return array отсортированный массив
     */
    public String[] remove(String[] array) {
        int countLeight = array.length;
        //Счеткик для значений null
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            String check = array[i];
            //Если достигли null дальше сверять нет смысла
            if (check != null) {
                for (int j = i + 1; j < array.length; j++) {
                    if (check.equals(array[j])) {
                        count++;
                        array[j] = array[array.length - count];
                        array[array.length - count] = null;
                        //Откатываем назад для этого элемента еще раз
                        j--;
                        countLeight--;
                    }
                }
            } else {
                break;
            }
        }
        return Arrays.copyOf(array, countLeight);
    }
}
