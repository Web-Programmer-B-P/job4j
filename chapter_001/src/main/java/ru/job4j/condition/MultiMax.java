package ru.job4j.condition;

public class MultiMax {
    public int max(int first, int second, int third) {
        int result = first;
        if (third > second && first < third){
            result = third;
        } else if (second > third && first < second){
            result = second;
        }
        return result;
    }
}
