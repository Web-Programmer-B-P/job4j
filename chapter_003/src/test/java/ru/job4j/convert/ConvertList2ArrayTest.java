package ru.job4j.convert;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConvertList2ArrayTest {
    @Test
    public void when7ElementsThen9() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10),
                3
        );
        int[][] expect = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 0, 0}
        };
        assertThat(result, is(expect));
    }

    @Test
    public void whenMakeListFromArrays() {
        ConvertList2Array caller = new ConvertList2Array();
        List<int[]> data = new ArrayList<>();
        int[] first = {1, 2, 3};
        int[] second = {4, 5, 6, 7, 8, 9, 10};
        data.add(first);
        data.add(second);
        List<Integer> result = caller.convert(data);
        List<Integer> expected = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        assertThat(result, is(expected));
    }
}
