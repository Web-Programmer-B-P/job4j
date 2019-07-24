package ru.job4j.condition;

public class Max {
    public int max(int left, int right) {
        int result = (left > right) ? left : (left < right) ? right : -1;
        return result;
    }
}
