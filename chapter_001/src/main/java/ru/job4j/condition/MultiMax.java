package ru.job4j.condition;

public class MultiMax {
    public int max(int first, int second, int third) {
        int result = first;
        if (third > second) {
            result = third;
        } else if (second > third) {
            result = second;
        }
        return result > first ? result : first;
    }
}
