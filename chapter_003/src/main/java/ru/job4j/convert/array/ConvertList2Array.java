package ru.job4j.convert.array;

import java.util.ArrayList;
import java.util.List;

public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = list.size() % rows == 0 ? list.size() / rows : (list.size() / rows) + 1;
        int[][] array = new int[rows][cells];
        int outer = 0;
        int inner = 0;
        for (Integer el : list) {
            if (inner == cells) {
                outer++;
                inner = 0;
            }
            array[outer][inner] = el;
            inner++;
        }
        return array;
    }

    public List<Integer> convert(List<int[]> list) {
        List<Integer> allArrays = new ArrayList<>();
        for (int[] array : list) {
            for (int elem : array) {
                allArrays.add(elem);
            }
        }
        return allArrays;
    }
}
