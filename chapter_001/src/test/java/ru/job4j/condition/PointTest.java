package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PointTest {
    @Test
    public void checkPoint() {
        Point check = new Point();
        double result = check.distance(3, -5, 2, 9);
        assertThat(result, is(14.035668847618199));
    }
}
