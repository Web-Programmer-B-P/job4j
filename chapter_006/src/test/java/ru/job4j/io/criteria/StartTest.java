package ru.job4j.io.criteria;

import org.junit.Test;
import ru.job4j.io.criteria.model.Args;

import java.io.IOException;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Class StartTest
 *
 * @author Petr B.
 * @since 04.11.2019, 14:49
 */
public class StartTest {
    @Test
    public void whenSearchByMask() throws IOException {
        Args testParam = new Args("../chapter_006", "*.csv", "-m", "tr.txt");
        Start find = new Start(testParam);
        find.file();
        assertThat(find.getDataTargetFile().contains("unavailable.csv"), is(true));
    }

    @Test
    public void whenSearchByFullMatch() throws IOException {
        Args testParam = new Args("../chapter_006", "unavailable.csv", "-f", "tr.txt");
        Start find = new Start(testParam);
        find.file();
        assertThat(find.getDataTargetFile().contains("unavailable.csv"), is(true));
    }

    @Test
    public void whenSearchByRegex() throws IOException {
        Args testParam = new Args("../chapter_006", ".+([v])", "-r", "tr.txt");
        Start find = new Start(testParam);
        find.file();
        assertThat(find.getDataTargetFile().contains("unavailable.csv"), is(true));
    }
}