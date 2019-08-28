package ru.job4j.priority;

import ru.job4j.task.Task;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Class PriorityQueue
 * Класс служит для расстановки приоритетных задач в начало списка
 *
 * @author Petr B.
 * @since 27.08.2019
 */
public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позицию определять по полю приоритет.
     * Для вставки использовать add(int index, E value)
     * @param task задача
     */
    public void put(Task task) {
        int i = 0;
        if (this.tasks.isEmpty()) {
            this.tasks.add(i, task);
        } else {
            Iterator<Task> itr = this.tasks.iterator();
            while (itr.hasNext()) {
                if (itr.next().getPriority() > task.getPriority()) {
                    this.tasks.add(i, task);
                    break;
                } else if (!itr.hasNext()) {
                    this.tasks.add(i + 1, task);
                    break;
                }
                i++;
            }
        }
    }


    public Task take() {
        return this.tasks.poll();
    }
}
