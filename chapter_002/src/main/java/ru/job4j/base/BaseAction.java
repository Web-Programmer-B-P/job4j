package ru.job4j.base;

import ru.job4j.input.Input;
import ru.job4j.tracker.Tracker;
import ru.job4j.user.UserAction;

public abstract class BaseAction implements UserAction {
    private final int key;
    private final String name;

    protected BaseAction(final int key, final String name) {
        this.key = key;
        this.name = name;
    }

    @Override
    public int key() {
        return this.key;
    }

    @Override
    public String info() {
        return String.format("%s. %s", this.key, this.name);
    }

    public abstract void execute(Input input, Tracker tracker);
}