package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class MultiMaxTest {
    @Test
    public void whenSecondMax() {
        MultiMax check = new MultiMax();
        int result = check.max(1, 4, 2);
        assertThat(result, is(4));
    }

    @Test
    public void whenFirstMax() {
        MultiMax maxFirst = new MultiMax();
        int result = maxFirst.max(3, 1, 2);
        assertThat(result, is(3));
    }


    @Test
    public void whenThirdMax() {
        MultiMax maxSecond = new MultiMax();
        int result = maxSecond.max(1, 4, 9);
        assertThat(result, is(9));
    }


    @Test
    public void whenAllEqual() {
        MultiMax equal = new MultiMax();
        int result = equal.max(1, 1, 1);
        assertThat(result, is(1));
    }
}