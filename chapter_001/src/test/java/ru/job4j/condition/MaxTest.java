package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MaxTest {
    @Test
    public void whenMax1To2Then2() {
        Max maximum = new Max();
        int result = maximum.max(5, 2);
        assertThat(result, is(5));
    }

    @Test
    public void whenMax1From3Numbers() {
        Max maximum = new Max();
        int result = maximum.max(5, 10, 1);
        assertThat(result, is(10));
    }

    @Test
    public void whenMax1From4Numbers() {
        Max maximum = new Max();
        int result = maximum.max(5, 10, 1, 100);
        assertThat(result, is(100));
    }
}
