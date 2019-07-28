package ru.job4j.array;

/**
 * Class Turn
 * Класс Переварот
 *
 * @author Petr B.
 * @since 28.07.2019
 * @version 1
 */
public class Turn {
    /**
     * Метод выполняет переворот массива
     * @param array массив который нужно перевернуть
     * @return array массив в обратной последовательности
     */
    public int[] back(int[] array) {
        //Ищем половину массива, для прерывания перестановки.
        int halfArray = array.length / 2;
        for (int index = 0; index < array.length; index++) {
            if (index == halfArray){
                break;
            }
            int lastElemFromArray = array[array.length - index - 1];
            int firstElemFromArray = array[index];
            array[index] = lastElemFromArray;
            array[array.length - index - 1] = firstElemFromArray;
        }
        return array;
    }
}
