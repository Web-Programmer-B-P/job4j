package ru.job4j.exit;

import ru.job4j.base.BaseAction;
import ru.job4j.input.Input;
import ru.job4j.tracker.Tracker;

public class ExitProgramm extends BaseAction {

    public ExitProgramm(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
    }
}
