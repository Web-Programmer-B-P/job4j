package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SqMaxTest {
    @Test
    public void whenMaxOutOfFourth() {
        SqMax check = new SqMax();
        int expected = 10;
        int max = check.max(2, 8, 1, 10);
        assertThat(max, is(expected));
    }

    @Test
    public void whenFirstMax() {
        SqMax check = new SqMax();
        int expected = 10;
        int max = check.max(10, 8, 1, 2);
        assertThat(max, is(expected));
    }

    @Test
    public void whenSecondMax() {
        SqMax check = new SqMax();
        int expected = 10;
        int max = check.max(9, 10, 1, 2);
        assertThat(max, is(expected));
    }

    @Test
    public void whenThirdMax() {
        SqMax check = new SqMax();
        int expected = 10;
        int max = check.max(1, 8, 10, 2);
        assertThat(max, is(expected));
    }

    @Test
    public void whenFourthMax() {
        SqMax check = new SqMax();
        int expected = 10;
        int max = check.max(6, 8, 1, 10);
        assertThat(max, is(expected));
    }

    @Test
    public void whenAllEqual() {
        SqMax check = new SqMax();
        int expected = 10;
        int max = check.max(10, 10, 10, 10);
        assertThat(max, is(expected));
    }
}
