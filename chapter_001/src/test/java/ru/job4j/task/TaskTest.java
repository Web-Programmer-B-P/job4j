package ru.job4j.task;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TaskTest {
    @Test
    public void mergeTwoArrays() {
        Task check = new Task();
        int[] expected = {1, 2, 3, 4};
        int[] inputLeft = {1, 3};
        int[] inputRight = {2, 4};
        int[] result = check.merge(inputLeft, inputRight);
        assertThat(result, is(expected));
    }
}
