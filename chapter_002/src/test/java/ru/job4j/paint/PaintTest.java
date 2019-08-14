package ru.job4j.paint;

import org.junit.Test;
import ru.job4j.square.Square;
import ru.job4j.triangle.Triangle;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Для этого теста необходино убрать символ, переноса строки в цикле отрисовки треугольника, в методе triangle.draw().
 */
public class PaintTest {
    @Test
    public void whenDrawTriangle() {
        PrintStream stdout = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        new Paint().draw(new Triangle());
        assertThat(
                new String(out.toByteArray()),
                is(
                    new StringBuffer().
                        append(".......^.......").
                        append("......^^^......").
                        append(".....^^^^^.....").
                        append("....^^^^^^^....").
                        append("...^^^^^^^^^...").
                        append("..^^^^^^^^^^^..").
                        append(".^^^^^^^^^^^^^.").
                        append("^^^^^^^^^^^^^^^").
                        append(System.lineSeparator()).toString()
                )
        );
        System.setOut(stdout);
    }

    @Test
    public void whenDrawSquare() {
        PrintStream stdout = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        new Paint().draw(new Square());
        assertThat(
                new String(out.toByteArray()),
                is(
                    new StringBuffer().
                        append("xxxxxxxx").
                        append("xccccccx").
                        append("xccccccx").
                        append("xccccccx").
                        append("xxxxxxxx").
                        append(System.lineSeparator()).toString()
                )
        );
        System.setOut(stdout);
    }
}