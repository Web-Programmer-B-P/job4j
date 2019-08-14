package ru.job4j.triangle;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class TriangleTest {
    @Test
    public void whenTestDrawTriangle() {
        Triangle triangle = new Triangle();
        assertThat(triangle.draw(),
                is(
                    new StringBuffer().
                    append(".......^.......").
                    append("......^^^......").
                    append(".....^^^^^.....").
                    append("....^^^^^^^....").
                    append("...^^^^^^^^^...").
                    append("..^^^^^^^^^^^..").
                    append(".^^^^^^^^^^^^^.").
                    append("^^^^^^^^^^^^^^^").toString()));
    }
}
