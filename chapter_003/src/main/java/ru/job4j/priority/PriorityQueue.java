package ru.job4j.priority;

import ru.job4j.task.Task;

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
        int index = this.tasks.size();
        if (this.tasks.isEmpty()) {
            this.tasks.add(index, task);
        } else {
            for (int i = 0; i < index; i++) {
                if (this.tasks.get(i).getPriority() > task.getPriority()) {
                    this.tasks.add(i, task);
                } else if (i == index - 1) {
                    this.tasks.add(i + 1, task);
                }
            }
        }
    }

    public Task take() {
        return this.tasks.poll();
    }
}
