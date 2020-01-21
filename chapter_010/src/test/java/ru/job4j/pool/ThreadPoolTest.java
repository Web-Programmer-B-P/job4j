package ru.job4j.pool;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.*;

/**
 * Class ThreadPoolTest
 *
 * @author Petr B.
 * @since 17.01.2020, 11:48
 */
public class ThreadPoolTest {
    @Test
    public void whenStartPoolWithTasks() {
        int[] index = {0};
        int size = Runtime.getRuntime().availableProcessors();
        ThreadPool threadPool = new ThreadPool(size);
        threadPool.work(()-> index[0]++);
        threadPool.work(()-> index[0]++);
        threadPool.work(()-> index[0]++);
        threadPool.shutdown();
        assertThat(index[0], is(3));
    }
}