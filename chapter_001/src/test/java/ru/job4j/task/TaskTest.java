package ru.job4j.task;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TaskTest {
    @Test
    public void mergeTwoArrays() {
        Task check = new Task();
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] inputLeft = {2, 3, 4, 5, 6, 7, 8};
        int[] inputRight = {1, 9};
        int[] result = check.merge(inputLeft, inputRight);
        assertThat(result, is(expected));
    }
}
