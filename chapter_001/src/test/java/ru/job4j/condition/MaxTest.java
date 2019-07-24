package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MaxTest {
    @Test
    public void whenMax1To2Then2() {
        Max max = new Max();
        int result = max.max(5, 2);
        assertThat(result, is(5));
    }


    @Test
    public void whenFirstIsMax() {
        Max maxFirst = new Max();
        int result = maxFirst.max(3, 1);
        assertThat(result, is(3));
    }


    @Test
    public void whenSecondIsMax() {
        Max maxSecond = new Max();
        int result = maxSecond.max(1, 4);
        assertThat(result, is(4));
    }


    @Test
    public void whenBothAreEqual() {
        Max equal = new Max();
        int result = equal.max(1, 1);
        assertThat(result, is(-1));
    }
}
