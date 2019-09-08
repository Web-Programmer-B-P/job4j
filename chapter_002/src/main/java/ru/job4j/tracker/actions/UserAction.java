package ru.job4j.tracker.actions;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.storage.Tracker;

import java.util.function.Consumer;

public interface UserAction {
    int key();
    void execute(Input input, Tracker tracker, Consumer<String> output);
    String info();
}
