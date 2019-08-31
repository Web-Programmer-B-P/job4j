package ru.job4j.convert.list;

import java.util.ArrayList;
import java.util.List;

/**
 * Class ConvertMatrix2List
 * Класс преобразует матрицу 2х2 в список
 *
 * @author Petr B.
 * @since 29.08.2019
 */
public class ConvertMatrix2List {
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] outer : array) {
            for (int inner : outer) {
                list.add(inner);
            }
        }
        return list;
    }
}
