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
        //Элемент массива взятый за основу, если все элементы ему равны, значит результат true, независимо от содержания
        boolean paternElementFromArray = data[0];
        for (int index = 0; index < data.length; index++) {
            if (data[index] != paternElementFromArray){
                result = false;
                break;
            }
            result = true;
        }
        return result;
    }
}

