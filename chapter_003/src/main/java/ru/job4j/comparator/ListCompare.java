package ru.job4j.comparator;

import java.util.Comparator;


public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int lef = 0;
        int check = 0;
        int size = Math.min(left.length(), right.length());
        for (int index = 0; index < size; index++) {
            check = Character.compare(left.charAt(index), right.charAt(index));
            if (check != 0) {
                lef = check;
                break;
            }
        }
        return lef != 0 ? lef : Integer.compare(left.length(), right.length());
    }
}
