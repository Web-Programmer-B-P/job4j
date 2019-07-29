package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class EndsWithTest {

    @Test
    public void whenStartWithPrefixThenTrue() {
        EndsWith word = new EndsWith();
        boolean result = word.endsWith("Hello", "ello");
        assertThat(result, is(true));
    }

    @Test
    public void whenNotStartWithPrefixThenFalse() {
        EndsWith word = new EndsWith();
        boolean result = word.endsWith("Hello", "zlo");
        assertThat(result, is(false));
    }
}
