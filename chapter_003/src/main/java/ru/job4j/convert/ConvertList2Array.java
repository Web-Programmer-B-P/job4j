package ru.job4j.convert;

import java.util.Iterator;
import java.util.List;

public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = rows;
        int[][] array = new int[rows][cells];
        int count = 0;
        for (int[] out : array) {
            int index = 0;
            for (int inner : out) {
                if (count <= list.size() - 1) {
                    out[index] = list.get(count++);
                } else {
                    out[index] = 0;
                }
                index++;
            }
        }
        return array;
    }
}
