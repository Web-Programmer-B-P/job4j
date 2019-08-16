package ru.job4j.exit;

import ru.job4j.input.Input;
import ru.job4j.tracker.Tracker;
import ru.job4j.user.action.UserAction;

public class ExitProgramm implements UserAction {
    @Override
    public String key() {
        return "EXIT";
    }

    @Override
    public void execute(Input input, Tracker tracker) {
    }

    @Override
    public String info() {
        return "6. Выход из программы";
    }
}
