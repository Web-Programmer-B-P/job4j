package ru.job4j.array;

/**
 * Class Check
 * Класс проверки массива
 *
 * @author Petr B.
 * @since 28.07.2019
 * @version 1
 */
public class Check {
    /**
     * Метод mono проверяет массив на true/false
     * @param data проверяемый массив
     * @return boolean true/false.
     */
    public boolean mono(boolean[] data) {
        boolean result = false;
        boolean j = data[0];
        for (int index = 0; index < data.length; index++) {
            if (data[index] != j) {
                result = false;
                break;
            }
            result = true;
        }
        return result;
    }
}

