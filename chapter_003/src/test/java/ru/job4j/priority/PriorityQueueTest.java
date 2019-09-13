package ru.job4j.priority;

import org.junit.*;
import ru.job4j.priority.model.Task;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PriorityQueueTest {
    @Test
    public void whenHigherPriority() {
        var queue = new PriorityQueue();
        queue.put(new Task("low", 5));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("middle", 8));
        queue.put(new Task("middfdg", 3));
        queue.put(new Task("middleg", 4));
        queue.put(new Task("middled", 2));
        var result = queue.take();
        assertThat(result.getDesc(), is("urgent"));
    }
}
