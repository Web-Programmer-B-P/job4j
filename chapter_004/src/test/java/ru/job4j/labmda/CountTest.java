package ru.job4j.labmda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class CountTest
 *
 * @author Petr B.
 * @since 08.09.2019, 12:15
 */
public class CountTest {
    @Test
    public void checkLinearFunction() {
        Count input = new Count();
        List<Double> result = input.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void checkQuadraticFunction() {
        Count input = new Count();
        List<Double> result = input.diapason(5, 8, x -> (x * x) + 1);
        List<Double> expected = Arrays.asList(26D, 37D, 50D);
        assertThat(result, is(expected));
    }

    @Test
    public void checkLogFunction() {
        Count input = new Count();
        List<Double> result = input.diapason(5, 8, x -> Math.log(x) / Math.log(2));
        List<Double> expected = Arrays.asList(2.321928094887362, 2.584962500721156, 2.807354922057604);
        assertThat(result, is(expected));
    }
}
