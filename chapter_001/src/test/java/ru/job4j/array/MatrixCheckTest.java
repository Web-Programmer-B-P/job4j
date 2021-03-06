package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MatrixCheckTest {
    @Test
    public void whenDataMonoByTrueThenTrue() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = {
                {true, true, true},
                {false, true, true},
                {true, false, true}
        };
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }

    @Test
    public void whenDataNotMonoByTrueThenFalse() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = {
                {true, true, false},
                {false, false, true},
                {true, false, true}
        };
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }

    @Test
    public void whenDataMonoByTrueThenFalse() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = {
                {true, false, false, false},
                {false, true, false, true},
                {false, false, true, true},
                {false, true, false, true},
        };
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }

    @Test
    public void whenDataMonoBy2x2() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = {
                {true, false},
                {false, true}
        };
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }
}