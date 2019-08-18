package ru.job4j.user;

import ru.job4j.input.Input;
import ru.job4j.tracker.Tracker;

public interface UserAction {
    int key();
    void execute(Input input, Tracker tracker);
    String info();
}
