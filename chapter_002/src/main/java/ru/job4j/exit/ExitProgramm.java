package ru.job4j.exit;

import ru.job4j.base.BaseAction;
import ru.job4j.input.Input;
import ru.job4j.start.StartUI;
import ru.job4j.tracker.Tracker;

public class ExitProgramm extends BaseAction {
    private StartUI stop;

    public ExitProgramm(int key, String name, StartUI stop) {
        super(key, name);
        this.stop = stop;
    }


    @Override
    public void execute(Input input, Tracker tracker) {
        this.stop.exit();
    }
}
